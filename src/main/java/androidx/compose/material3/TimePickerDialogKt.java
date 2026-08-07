package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.tokens.DialogTokens;
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
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimePickerDialog.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a·\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0014H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u009f\u0001\u0010\u0017\u001a\u00020\u00012\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0014H\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001aQ\u0010\u001a\u001a\u00020\u00012\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0014H\u0001¢\u0006\u0002\u0010\u001c¨\u0006\u001d"}, d2 = {"TimePickerDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "title", "modifier", "Landroidx/compose/ui/Modifier;", "properties", "Landroidx/compose/ui/window/DialogProperties;", "modeToggleButton", "dismissButton", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "TimePickerDialog-FItCLgY", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TimePickerDialogLayout", "TimePickerDialogLayout-3csKH6Y", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TimePickerCustomLayout", "actions", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TimePickerDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimePickerCustomLayout$lambda$2(Function2 function2, Function2 function3, Function3 function4, int i, Composer composer, int i2) {
        TimePickerCustomLayout(function2, function3, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimePickerDialogLayout_3csKH6Y$lambda$1(Function2 function2, Function2 function3, Modifier modifier, Function2 function4, Function2 function5, Shape shape, long j, Function3 function6, int i, int i2, Composer composer, int i3) {
        m4526TimePickerDialogLayout3csKH6Y(function2, function3, modifier, function4, function5, shape, j, function6, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimePickerDialog_FItCLgY$lambda$1(Function0 function0, Function2 function2, Function2 function3, Modifier modifier, DialogProperties dialogProperties, Function2 function4, Function2 function5, Shape shape, long j, Function3 function6, int i, int i2, Composer composer, int i3) {
        m4525TimePickerDialogFItCLgY(function0, function2, function3, modifier, dialogProperties, function4, function5, shape, j, function6, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0123  */
    /* JADX WARN: Code duplicated, block: B:101:0x0125  */
    /* JADX WARN: Code duplicated, block: B:104:0x012e  */
    /* JADX WARN: Code duplicated, block: B:106:0x0140  */
    /* JADX WARN: Code duplicated, block: B:116:0x0163 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:117:0x0165  */
    /* JADX WARN: Code duplicated, block: B:119:0x016c  */
    /* JADX WARN: Code duplicated, block: B:120:0x017c  */
    /* JADX WARN: Code duplicated, block: B:123:0x0181  */
    /* JADX WARN: Code duplicated, block: B:125:0x0184  */
    /* JADX WARN: Code duplicated, block: B:128:0x018a  */
    /* JADX WARN: Code duplicated, block: B:129:0x0193  */
    /* JADX WARN: Code duplicated, block: B:132:0x0199  */
    /* JADX WARN: Code duplicated, block: B:133:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:137:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:140:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:142:0x020a  */
    /* JADX WARN: Code duplicated, block: B:145:0x021c  */
    /* JADX WARN: Code duplicated, block: B:147:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x006d  */
    /* JADX WARN: Code duplicated, block: B:39:0x0070  */
    /* JADX WARN: Code duplicated, block: B:41:0x0074  */
    /* JADX WARN: Code duplicated, block: B:43:0x007c  */
    /* JADX WARN: Code duplicated, block: B:44:0x007f  */
    /* JADX WARN: Code duplicated, block: B:49:0x008b  */
    /* JADX WARN: Code duplicated, block: B:50:0x008d  */
    /* JADX WARN: Code duplicated, block: B:52:0x0090  */
    /* JADX WARN: Code duplicated, block: B:54:0x0098  */
    /* JADX WARN: Code duplicated, block: B:55:0x009b  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d3 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:79:0x00da  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:84:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:89:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:92:0x0108  */
    /* JADX WARN: Code duplicated, block: B:94:0x010e  */
    /* JADX WARN: Code duplicated, block: B:95:0x0111  */
    /* JADX WARN: Code duplicated, block: B:97:0x0116  */
    /* JADX INFO: renamed from: TimePickerDialog-FItCLgY, reason: not valid java name */
    public static final void m4525TimePickerDialogFItCLgY(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, Modifier modifier, DialogProperties dialogProperties, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, Shape shape, long j, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function6, Composer composer, final int i, final int i2) {
        int i3;
        Function2<? super Composer, ? super Integer, Unit> function7;
        Modifier modifier2;
        int i4;
        DialogProperties dialogProperties2;
        int i5;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function8;
        int i7;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function9;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        final DialogProperties dialogProperties3;
        final Function2<? super Composer, ? super Integer, Unit> function10;
        final Function2<? super Composer, ? super Integer, Unit> function11;
        final Shape shape2;
        final long j2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        DialogProperties dialogProperties4;
        final Shape shape3;
        final long containerColor;
        final Function2<? super Composer, ? super Integer, Unit> function12;
        int i13;
        final Modifier modifier4;
        final Function2<? super Composer, ? super Integer, Unit> function13;
        int i14;
        int i15;
        Composer composerStartRestartGroup = composer.startRestartGroup(951250327);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TimePickerDialog)N(onDismissRequest,confirmButton,title,modifier,properties,modeToggleButton,dismissButton,shape,containerColor:c#ui.graphics.Color,content)79@3820L347,79@3751L416:TimePickerDialog.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            function7 = function3;
            i3 |= composerStartRestartGroup.changedInstance(function7) ? 256 : 128;
        } else {
            function7 = function3;
        }
        int i16 = i2 & 8;
        if (i16 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    dialogProperties2 = dialogProperties;
                    if (composerStartRestartGroup.changed(dialogProperties2)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    if ((196608 & i) == 0) {
                        function8 = function4;
                        if (composerStartRestartGroup.changedInstance(function8)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 64;
                    if (i8 != 0) {
                        if ((1572864 & i) == 0) {
                            function9 = function5;
                            if (composerStartRestartGroup.changedInstance(function9)) {
                                i9 = 1048576;
                            } else {
                                i9 = 524288;
                            }
                            i3 |= i9;
                        }
                        if ((i & 12582912) != 0) {
                            i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(shape)) ? 4194304 : 8388608;
                        }
                        if ((i & 100663296) == 0) {
                            int i17 = i3;
                            if ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j)) {
                                i15 = 33554432;
                            } else {
                                i15 = 67108864;
                            }
                            i10 = i17 | i15;
                        } else {
                            i10 = i3;
                        }
                        i11 = i10;
                        if ((i & 805306368) == 0) {
                            if (composerStartRestartGroup.changedInstance(function6)) {
                                i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i14 = 268435456;
                            }
                            i12 = i11 | i14;
                        } else {
                            i12 = i11;
                        }
                        if ((i12 & 306783379) != 306783378) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "75@3618L5,76@3678L14");
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    dialogProperties4 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                                } else {
                                    dialogProperties4 = dialogProperties2;
                                }
                                if (i6 != 0) {
                                    function8 = null;
                                }
                                if (i8 != 0) {
                                    function9 = null;
                                }
                                if ((i2 & 128) != 0) {
                                    shape3 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                    i12 &= -29360129;
                                } else {
                                    shape3 = shape;
                                }
                                if ((i2 & 256) != 0) {
                                    i12 &= -234881025;
                                    containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                } else {
                                    containerColor = j;
                                }
                                function12 = function8;
                                i13 = i12;
                                dialogProperties2 = dialogProperties4;
                                modifier4 = modifier2;
                                function13 = function9;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 128) != 0) {
                                    i12 &= -29360129;
                                }
                                if ((i2 & 256) != 0) {
                                    i12 &= -234881025;
                                }
                                shape3 = shape;
                                containerColor = j;
                                function12 = function8;
                                function13 = function9;
                                i13 = i12;
                                modifier4 = modifier2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(951250327, i13, -1, "androidx.compose.material3.TimePickerDialog (TimePickerDialog.kt:78)");
                            }
                            final Function2<? super Composer, ? super Integer, Unit> function14 = function7;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties2, ComposableLambdaKt.rememberComposableLambda(296331566, true, new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TimePickerDialogKt.TimePickerDialog_FItCLgY$lambda$0(function2, function14, modifier4, function12, function13, shape3, containerColor, function6, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 9) & 112) | (i13 & 14) | 384, 0);
                            composer2 = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            dialogProperties3 = dialogProperties2;
                            modifier3 = modifier4;
                            function10 = function12;
                            function11 = function13;
                            shape2 = shape3;
                            j2 = containerColor;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            modifier3 = modifier2;
                            dialogProperties3 = dialogProperties2;
                            function10 = function8;
                            function11 = function9;
                            shape2 = shape;
                            j2 = j;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TimePickerDialogKt.TimePickerDialog_FItCLgY$lambda$1(function0, function2, function3, modifier3, dialogProperties3, function10, function11, shape2, j2, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 1572864;
                    function9 = function5;
                    if ((i & 12582912) != 0) {
                        i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(shape)) ? 4194304 : 8388608;
                    }
                    if ((i & 100663296) == 0) {
                        int i18 = i3;
                        if ((i2 & 256) == 0) {
                            i15 = 33554432;
                        } else {
                            i15 = 33554432;
                        }
                        i10 = i18 | i15;
                    } else {
                        i10 = i3;
                    }
                    i11 = i10;
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i14 = 268435456;
                        }
                        i12 = i11 | i14;
                    } else {
                        i12 = i11;
                    }
                    if ((i12 & 306783379) != 306783378) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "75@3618L5,76@3678L14");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                dialogProperties4 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties4 = dialogProperties2;
                            }
                            if (i6 != 0) {
                                function8 = null;
                            }
                            if (i8 != 0) {
                                function9 = null;
                            }
                            if ((i2 & 128) != 0) {
                                shape3 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i12 &= -29360129;
                            } else {
                                shape3 = shape;
                            }
                            if ((i2 & 256) != 0) {
                                i12 &= -234881025;
                                containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            } else {
                                containerColor = j;
                            }
                            function12 = function8;
                            i13 = i12;
                            dialogProperties2 = dialogProperties4;
                            modifier4 = modifier2;
                            function13 = function9;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                dialogProperties4 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties4 = dialogProperties2;
                            }
                            if (i6 != 0) {
                                function8 = null;
                            }
                            if (i8 != 0) {
                                function9 = null;
                            }
                            if ((i2 & 128) != 0) {
                                shape3 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i12 &= -29360129;
                            } else {
                                shape3 = shape;
                            }
                            if ((i2 & 256) != 0) {
                                i12 &= -234881025;
                                containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            } else {
                                containerColor = j;
                            }
                            function12 = function8;
                            i13 = i12;
                            dialogProperties2 = dialogProperties4;
                            modifier4 = modifier2;
                            function13 = function9;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(951250327, i13, -1, "androidx.compose.material3.TimePickerDialog (TimePickerDialog.kt:78)");
                        }
                        final Function2 function15 = function7;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties2, ComposableLambdaKt.rememberComposableLambda(296331566, true, new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TimePickerDialogKt.TimePickerDialog_FItCLgY$lambda$0(function2, function15, modifier4, function12, function13, shape3, containerColor, function6, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 9) & 112) | (i13 & 14) | 384, 0);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        dialogProperties3 = dialogProperties2;
                        modifier3 = modifier4;
                        function10 = function12;
                        function11 = function13;
                        shape2 = shape3;
                        j2 = containerColor;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        dialogProperties3 = dialogProperties2;
                        function10 = function8;
                        function11 = function9;
                        shape2 = shape;
                        j2 = j;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TimePickerDialogKt.TimePickerDialog_FItCLgY$lambda$1(function0, function2, function3, modifier3, dialogProperties3, function10, function11, shape2, j2, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function8 = function4;
                i8 = i2 & 64;
                if (i8 != 0) {
                    if ((1572864 & i) == 0) {
                        function9 = function5;
                        if (composerStartRestartGroup.changedInstance(function9)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    if ((i & 12582912) != 0) {
                        i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(shape)) ? 4194304 : 8388608;
                    }
                    if ((i & 100663296) == 0) {
                        int i19 = i3;
                        if ((i2 & 256) == 0) {
                            i15 = 33554432;
                        } else {
                            i15 = 33554432;
                        }
                        i10 = i19 | i15;
                    } else {
                        i10 = i3;
                    }
                    i11 = i10;
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i14 = 268435456;
                        }
                        i12 = i11 | i14;
                    } else {
                        i12 = i11;
                    }
                    if ((i12 & 306783379) != 306783378) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "75@3618L5,76@3678L14");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                dialogProperties4 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties4 = dialogProperties2;
                            }
                            if (i6 != 0) {
                                function8 = null;
                            }
                            if (i8 != 0) {
                                function9 = null;
                            }
                            if ((i2 & 128) != 0) {
                                shape3 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i12 &= -29360129;
                            } else {
                                shape3 = shape;
                            }
                            if ((i2 & 256) != 0) {
                                i12 &= -234881025;
                                containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            } else {
                                containerColor = j;
                            }
                            function12 = function8;
                            i13 = i12;
                            dialogProperties2 = dialogProperties4;
                            modifier4 = modifier2;
                            function13 = function9;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                dialogProperties4 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties4 = dialogProperties2;
                            }
                            if (i6 != 0) {
                                function8 = null;
                            }
                            if (i8 != 0) {
                                function9 = null;
                            }
                            if ((i2 & 128) != 0) {
                                shape3 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i12 &= -29360129;
                            } else {
                                shape3 = shape;
                            }
                            if ((i2 & 256) != 0) {
                                i12 &= -234881025;
                                containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            } else {
                                containerColor = j;
                            }
                            function12 = function8;
                            i13 = i12;
                            dialogProperties2 = dialogProperties4;
                            modifier4 = modifier2;
                            function13 = function9;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(951250327, i13, -1, "androidx.compose.material3.TimePickerDialog (TimePickerDialog.kt:78)");
                        }
                        final Function2 function16 = function7;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties2, ComposableLambdaKt.rememberComposableLambda(296331566, true, new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TimePickerDialogKt.TimePickerDialog_FItCLgY$lambda$0(function2, function16, modifier4, function12, function13, shape3, containerColor, function6, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 9) & 112) | (i13 & 14) | 384, 0);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        dialogProperties3 = dialogProperties2;
                        modifier3 = modifier4;
                        function10 = function12;
                        function11 = function13;
                        shape2 = shape3;
                        j2 = containerColor;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        dialogProperties3 = dialogProperties2;
                        function10 = function8;
                        function11 = function9;
                        shape2 = shape;
                        j2 = j;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TimePickerDialogKt.TimePickerDialog_FItCLgY$lambda$1(function0, function2, function3, modifier3, dialogProperties3, function10, function11, shape2, j2, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 1572864;
                function9 = function5;
                if ((i & 12582912) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(shape)) ? 4194304 : 8388608;
                }
                if ((i & 100663296) == 0) {
                    int i110 = i3;
                    if ((i2 & 256) == 0) {
                        i15 = 33554432;
                    } else {
                        i15 = 33554432;
                    }
                    i10 = i110 | i15;
                } else {
                    i10 = i3;
                }
                i11 = i10;
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i12 = i11 | i14;
                } else {
                    i12 = i11;
                }
                if ((i12 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "75@3618L5,76@3678L14");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            dialogProperties4 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties4 = dialogProperties2;
                        }
                        if (i6 != 0) {
                            function8 = null;
                        }
                        if (i8 != 0) {
                            function9 = null;
                        }
                        if ((i2 & 128) != 0) {
                            shape3 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i12 &= -29360129;
                        } else {
                            shape3 = shape;
                        }
                        if ((i2 & 256) != 0) {
                            i12 &= -234881025;
                            containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        } else {
                            containerColor = j;
                        }
                        function12 = function8;
                        i13 = i12;
                        dialogProperties2 = dialogProperties4;
                        modifier4 = modifier2;
                        function13 = function9;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            dialogProperties4 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties4 = dialogProperties2;
                        }
                        if (i6 != 0) {
                            function8 = null;
                        }
                        if (i8 != 0) {
                            function9 = null;
                        }
                        if ((i2 & 128) != 0) {
                            shape3 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i12 &= -29360129;
                        } else {
                            shape3 = shape;
                        }
                        if ((i2 & 256) != 0) {
                            i12 &= -234881025;
                            containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        } else {
                            containerColor = j;
                        }
                        function12 = function8;
                        i13 = i12;
                        dialogProperties2 = dialogProperties4;
                        modifier4 = modifier2;
                        function13 = function9;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(951250327, i13, -1, "androidx.compose.material3.TimePickerDialog (TimePickerDialog.kt:78)");
                    }
                    final Function2 function17 = function7;
                    AndroidDialog_androidKt.Dialog(function0, dialogProperties2, ComposableLambdaKt.rememberComposableLambda(296331566, true, new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TimePickerDialogKt.TimePickerDialog_FItCLgY$lambda$0(function2, function17, modifier4, function12, function13, shape3, containerColor, function6, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 9) & 112) | (i13 & 14) | 384, 0);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    dialogProperties3 = dialogProperties2;
                    modifier3 = modifier4;
                    function10 = function12;
                    function11 = function13;
                    shape2 = shape3;
                    j2 = containerColor;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    dialogProperties3 = dialogProperties2;
                    function10 = function8;
                    function11 = function9;
                    shape2 = shape;
                    j2 = j;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TimePickerDialogKt.TimePickerDialog_FItCLgY$lambda$1(function0, function2, function3, modifier3, dialogProperties3, function10, function11, shape2, j2, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            dialogProperties2 = dialogProperties;
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    function8 = function4;
                    if (composerStartRestartGroup.changedInstance(function8)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    if ((1572864 & i) == 0) {
                        function9 = function5;
                        if (composerStartRestartGroup.changedInstance(function9)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    if ((i & 12582912) != 0) {
                        i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(shape)) ? 4194304 : 8388608;
                    }
                    if ((i & 100663296) == 0) {
                        int i111 = i3;
                        if ((i2 & 256) == 0) {
                            i15 = 33554432;
                        } else {
                            i15 = 33554432;
                        }
                        i10 = i111 | i15;
                    } else {
                        i10 = i3;
                    }
                    i11 = i10;
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i14 = 268435456;
                        }
                        i12 = i11 | i14;
                    } else {
                        i12 = i11;
                    }
                    if ((i12 & 306783379) != 306783378) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "75@3618L5,76@3678L14");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                dialogProperties4 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties4 = dialogProperties2;
                            }
                            if (i6 != 0) {
                                function8 = null;
                            }
                            if (i8 != 0) {
                                function9 = null;
                            }
                            if ((i2 & 128) != 0) {
                                shape3 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i12 &= -29360129;
                            } else {
                                shape3 = shape;
                            }
                            if ((i2 & 256) != 0) {
                                i12 &= -234881025;
                                containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            } else {
                                containerColor = j;
                            }
                            function12 = function8;
                            i13 = i12;
                            dialogProperties2 = dialogProperties4;
                            modifier4 = modifier2;
                            function13 = function9;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                dialogProperties4 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties4 = dialogProperties2;
                            }
                            if (i6 != 0) {
                                function8 = null;
                            }
                            if (i8 != 0) {
                                function9 = null;
                            }
                            if ((i2 & 128) != 0) {
                                shape3 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i12 &= -29360129;
                            } else {
                                shape3 = shape;
                            }
                            if ((i2 & 256) != 0) {
                                i12 &= -234881025;
                                containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            } else {
                                containerColor = j;
                            }
                            function12 = function8;
                            i13 = i12;
                            dialogProperties2 = dialogProperties4;
                            modifier4 = modifier2;
                            function13 = function9;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(951250327, i13, -1, "androidx.compose.material3.TimePickerDialog (TimePickerDialog.kt:78)");
                        }
                        final Function2 function18 = function7;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties2, ComposableLambdaKt.rememberComposableLambda(296331566, true, new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TimePickerDialogKt.TimePickerDialog_FItCLgY$lambda$0(function2, function18, modifier4, function12, function13, shape3, containerColor, function6, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 9) & 112) | (i13 & 14) | 384, 0);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        dialogProperties3 = dialogProperties2;
                        modifier3 = modifier4;
                        function10 = function12;
                        function11 = function13;
                        shape2 = shape3;
                        j2 = containerColor;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        dialogProperties3 = dialogProperties2;
                        function10 = function8;
                        function11 = function9;
                        shape2 = shape;
                        j2 = j;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TimePickerDialogKt.TimePickerDialog_FItCLgY$lambda$1(function0, function2, function3, modifier3, dialogProperties3, function10, function11, shape2, j2, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 1572864;
                function9 = function5;
                if ((i & 12582912) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(shape)) ? 4194304 : 8388608;
                }
                if ((i & 100663296) == 0) {
                    int i112 = i3;
                    if ((i2 & 256) == 0) {
                        i15 = 33554432;
                    } else {
                        i15 = 33554432;
                    }
                    i10 = i112 | i15;
                } else {
                    i10 = i3;
                }
                i11 = i10;
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i12 = i11 | i14;
                } else {
                    i12 = i11;
                }
                if ((i12 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "75@3618L5,76@3678L14");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            dialogProperties4 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties4 = dialogProperties2;
                        }
                        if (i6 != 0) {
                            function8 = null;
                        }
                        if (i8 != 0) {
                            function9 = null;
                        }
                        if ((i2 & 128) != 0) {
                            shape3 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i12 &= -29360129;
                        } else {
                            shape3 = shape;
                        }
                        if ((i2 & 256) != 0) {
                            i12 &= -234881025;
                            containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        } else {
                            containerColor = j;
                        }
                        function12 = function8;
                        i13 = i12;
                        dialogProperties2 = dialogProperties4;
                        modifier4 = modifier2;
                        function13 = function9;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            dialogProperties4 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties4 = dialogProperties2;
                        }
                        if (i6 != 0) {
                            function8 = null;
                        }
                        if (i8 != 0) {
                            function9 = null;
                        }
                        if ((i2 & 128) != 0) {
                            shape3 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i12 &= -29360129;
                        } else {
                            shape3 = shape;
                        }
                        if ((i2 & 256) != 0) {
                            i12 &= -234881025;
                            containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        } else {
                            containerColor = j;
                        }
                        function12 = function8;
                        i13 = i12;
                        dialogProperties2 = dialogProperties4;
                        modifier4 = modifier2;
                        function13 = function9;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(951250327, i13, -1, "androidx.compose.material3.TimePickerDialog (TimePickerDialog.kt:78)");
                    }
                    final Function2 function19 = function7;
                    AndroidDialog_androidKt.Dialog(function0, dialogProperties2, ComposableLambdaKt.rememberComposableLambda(296331566, true, new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TimePickerDialogKt.TimePickerDialog_FItCLgY$lambda$0(function2, function19, modifier4, function12, function13, shape3, containerColor, function6, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 9) & 112) | (i13 & 14) | 384, 0);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    dialogProperties3 = dialogProperties2;
                    modifier3 = modifier4;
                    function10 = function12;
                    function11 = function13;
                    shape2 = shape3;
                    j2 = containerColor;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    dialogProperties3 = dialogProperties2;
                    function10 = function8;
                    function11 = function9;
                    shape2 = shape;
                    j2 = j;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TimePickerDialogKt.TimePickerDialog_FItCLgY$lambda$1(function0, function2, function3, modifier3, dialogProperties3, function10, function11, shape2, j2, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function8 = function4;
            i8 = i2 & 64;
            if (i8 != 0) {
                if ((1572864 & i) == 0) {
                    function9 = function5;
                    if (composerStartRestartGroup.changedInstance(function9)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((i & 12582912) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(shape)) ? 4194304 : 8388608;
                }
                if ((i & 100663296) == 0) {
                    int i113 = i3;
                    if ((i2 & 256) == 0) {
                        i15 = 33554432;
                    } else {
                        i15 = 33554432;
                    }
                    i10 = i113 | i15;
                } else {
                    i10 = i3;
                }
                i11 = i10;
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i12 = i11 | i14;
                } else {
                    i12 = i11;
                }
                if ((i12 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "75@3618L5,76@3678L14");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            dialogProperties4 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties4 = dialogProperties2;
                        }
                        if (i6 != 0) {
                            function8 = null;
                        }
                        if (i8 != 0) {
                            function9 = null;
                        }
                        if ((i2 & 128) != 0) {
                            shape3 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i12 &= -29360129;
                        } else {
                            shape3 = shape;
                        }
                        if ((i2 & 256) != 0) {
                            i12 &= -234881025;
                            containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        } else {
                            containerColor = j;
                        }
                        function12 = function8;
                        i13 = i12;
                        dialogProperties2 = dialogProperties4;
                        modifier4 = modifier2;
                        function13 = function9;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            dialogProperties4 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties4 = dialogProperties2;
                        }
                        if (i6 != 0) {
                            function8 = null;
                        }
                        if (i8 != 0) {
                            function9 = null;
                        }
                        if ((i2 & 128) != 0) {
                            shape3 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i12 &= -29360129;
                        } else {
                            shape3 = shape;
                        }
                        if ((i2 & 256) != 0) {
                            i12 &= -234881025;
                            containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        } else {
                            containerColor = j;
                        }
                        function12 = function8;
                        i13 = i12;
                        dialogProperties2 = dialogProperties4;
                        modifier4 = modifier2;
                        function13 = function9;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(951250327, i13, -1, "androidx.compose.material3.TimePickerDialog (TimePickerDialog.kt:78)");
                    }
                    final Function2 function110 = function7;
                    AndroidDialog_androidKt.Dialog(function0, dialogProperties2, ComposableLambdaKt.rememberComposableLambda(296331566, true, new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TimePickerDialogKt.TimePickerDialog_FItCLgY$lambda$0(function2, function110, modifier4, function12, function13, shape3, containerColor, function6, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 9) & 112) | (i13 & 14) | 384, 0);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    dialogProperties3 = dialogProperties2;
                    modifier3 = modifier4;
                    function10 = function12;
                    function11 = function13;
                    shape2 = shape3;
                    j2 = containerColor;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    dialogProperties3 = dialogProperties2;
                    function10 = function8;
                    function11 = function9;
                    shape2 = shape;
                    j2 = j;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TimePickerDialogKt.TimePickerDialog_FItCLgY$lambda$1(function0, function2, function3, modifier3, dialogProperties3, function10, function11, shape2, j2, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            function9 = function5;
            if ((i & 12582912) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(shape)) ? 4194304 : 8388608;
            }
            if ((i & 100663296) == 0) {
                int i114 = i3;
                if ((i2 & 256) == 0) {
                    i15 = 33554432;
                } else {
                    i15 = 33554432;
                }
                i10 = i114 | i15;
            } else {
                i10 = i3;
            }
            i11 = i10;
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i14 = 268435456;
                }
                i12 = i11 | i14;
            } else {
                i12 = i11;
            }
            if ((i12 & 306783379) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "75@3618L5,76@3678L14");
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        dialogProperties4 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties4 = dialogProperties2;
                    }
                    if (i6 != 0) {
                        function8 = null;
                    }
                    if (i8 != 0) {
                        function9 = null;
                    }
                    if ((i2 & 128) != 0) {
                        shape3 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i12 &= -29360129;
                    } else {
                        shape3 = shape;
                    }
                    if ((i2 & 256) != 0) {
                        i12 &= -234881025;
                        containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    } else {
                        containerColor = j;
                    }
                    function12 = function8;
                    i13 = i12;
                    dialogProperties2 = dialogProperties4;
                    modifier4 = modifier2;
                    function13 = function9;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        dialogProperties4 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties4 = dialogProperties2;
                    }
                    if (i6 != 0) {
                        function8 = null;
                    }
                    if (i8 != 0) {
                        function9 = null;
                    }
                    if ((i2 & 128) != 0) {
                        shape3 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i12 &= -29360129;
                    } else {
                        shape3 = shape;
                    }
                    if ((i2 & 256) != 0) {
                        i12 &= -234881025;
                        containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    } else {
                        containerColor = j;
                    }
                    function12 = function8;
                    i13 = i12;
                    dialogProperties2 = dialogProperties4;
                    modifier4 = modifier2;
                    function13 = function9;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(951250327, i13, -1, "androidx.compose.material3.TimePickerDialog (TimePickerDialog.kt:78)");
                }
                final Function2 function111 = function7;
                AndroidDialog_androidKt.Dialog(function0, dialogProperties2, ComposableLambdaKt.rememberComposableLambda(296331566, true, new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TimePickerDialogKt.TimePickerDialog_FItCLgY$lambda$0(function2, function111, modifier4, function12, function13, shape3, containerColor, function6, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 9) & 112) | (i13 & 14) | 384, 0);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                dialogProperties3 = dialogProperties2;
                modifier3 = modifier4;
                function10 = function12;
                function11 = function13;
                shape2 = shape3;
                j2 = containerColor;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                dialogProperties3 = dialogProperties2;
                function10 = function8;
                function11 = function9;
                shape2 = shape;
                j2 = j;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TimePickerDialogKt.TimePickerDialog_FItCLgY$lambda$1(function0, function2, function3, modifier3, dialogProperties3, function10, function11, shape2, j2, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        modifier2 = modifier;
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                dialogProperties2 = dialogProperties;
                if (composerStartRestartGroup.changed(dialogProperties2)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    function8 = function4;
                    if (composerStartRestartGroup.changedInstance(function8)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    if ((1572864 & i) == 0) {
                        function9 = function5;
                        if (composerStartRestartGroup.changedInstance(function9)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    if ((i & 12582912) != 0) {
                        i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(shape)) ? 4194304 : 8388608;
                    }
                    if ((i & 100663296) == 0) {
                        int i115 = i3;
                        if ((i2 & 256) == 0) {
                            i15 = 33554432;
                        } else {
                            i15 = 33554432;
                        }
                        i10 = i115 | i15;
                    } else {
                        i10 = i3;
                    }
                    i11 = i10;
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i14 = 268435456;
                        }
                        i12 = i11 | i14;
                    } else {
                        i12 = i11;
                    }
                    if ((i12 & 306783379) != 306783378) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "75@3618L5,76@3678L14");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                dialogProperties4 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties4 = dialogProperties2;
                            }
                            if (i6 != 0) {
                                function8 = null;
                            }
                            if (i8 != 0) {
                                function9 = null;
                            }
                            if ((i2 & 128) != 0) {
                                shape3 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i12 &= -29360129;
                            } else {
                                shape3 = shape;
                            }
                            if ((i2 & 256) != 0) {
                                i12 &= -234881025;
                                containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            } else {
                                containerColor = j;
                            }
                            function12 = function8;
                            i13 = i12;
                            dialogProperties2 = dialogProperties4;
                            modifier4 = modifier2;
                            function13 = function9;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                dialogProperties4 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties4 = dialogProperties2;
                            }
                            if (i6 != 0) {
                                function8 = null;
                            }
                            if (i8 != 0) {
                                function9 = null;
                            }
                            if ((i2 & 128) != 0) {
                                shape3 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i12 &= -29360129;
                            } else {
                                shape3 = shape;
                            }
                            if ((i2 & 256) != 0) {
                                i12 &= -234881025;
                                containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            } else {
                                containerColor = j;
                            }
                            function12 = function8;
                            i13 = i12;
                            dialogProperties2 = dialogProperties4;
                            modifier4 = modifier2;
                            function13 = function9;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(951250327, i13, -1, "androidx.compose.material3.TimePickerDialog (TimePickerDialog.kt:78)");
                        }
                        final Function2 function112 = function7;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties2, ComposableLambdaKt.rememberComposableLambda(296331566, true, new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TimePickerDialogKt.TimePickerDialog_FItCLgY$lambda$0(function2, function112, modifier4, function12, function13, shape3, containerColor, function6, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 9) & 112) | (i13 & 14) | 384, 0);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        dialogProperties3 = dialogProperties2;
                        modifier3 = modifier4;
                        function10 = function12;
                        function11 = function13;
                        shape2 = shape3;
                        j2 = containerColor;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        dialogProperties3 = dialogProperties2;
                        function10 = function8;
                        function11 = function9;
                        shape2 = shape;
                        j2 = j;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TimePickerDialogKt.TimePickerDialog_FItCLgY$lambda$1(function0, function2, function3, modifier3, dialogProperties3, function10, function11, shape2, j2, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 1572864;
                function9 = function5;
                if ((i & 12582912) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(shape)) ? 4194304 : 8388608;
                }
                if ((i & 100663296) == 0) {
                    int i116 = i3;
                    if ((i2 & 256) == 0) {
                        i15 = 33554432;
                    } else {
                        i15 = 33554432;
                    }
                    i10 = i116 | i15;
                } else {
                    i10 = i3;
                }
                i11 = i10;
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i12 = i11 | i14;
                } else {
                    i12 = i11;
                }
                if ((i12 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "75@3618L5,76@3678L14");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            dialogProperties4 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties4 = dialogProperties2;
                        }
                        if (i6 != 0) {
                            function8 = null;
                        }
                        if (i8 != 0) {
                            function9 = null;
                        }
                        if ((i2 & 128) != 0) {
                            shape3 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i12 &= -29360129;
                        } else {
                            shape3 = shape;
                        }
                        if ((i2 & 256) != 0) {
                            i12 &= -234881025;
                            containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        } else {
                            containerColor = j;
                        }
                        function12 = function8;
                        i13 = i12;
                        dialogProperties2 = dialogProperties4;
                        modifier4 = modifier2;
                        function13 = function9;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            dialogProperties4 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties4 = dialogProperties2;
                        }
                        if (i6 != 0) {
                            function8 = null;
                        }
                        if (i8 != 0) {
                            function9 = null;
                        }
                        if ((i2 & 128) != 0) {
                            shape3 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i12 &= -29360129;
                        } else {
                            shape3 = shape;
                        }
                        if ((i2 & 256) != 0) {
                            i12 &= -234881025;
                            containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        } else {
                            containerColor = j;
                        }
                        function12 = function8;
                        i13 = i12;
                        dialogProperties2 = dialogProperties4;
                        modifier4 = modifier2;
                        function13 = function9;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(951250327, i13, -1, "androidx.compose.material3.TimePickerDialog (TimePickerDialog.kt:78)");
                    }
                    final Function2 function113 = function7;
                    AndroidDialog_androidKt.Dialog(function0, dialogProperties2, ComposableLambdaKt.rememberComposableLambda(296331566, true, new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TimePickerDialogKt.TimePickerDialog_FItCLgY$lambda$0(function2, function113, modifier4, function12, function13, shape3, containerColor, function6, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 9) & 112) | (i13 & 14) | 384, 0);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    dialogProperties3 = dialogProperties2;
                    modifier3 = modifier4;
                    function10 = function12;
                    function11 = function13;
                    shape2 = shape3;
                    j2 = containerColor;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    dialogProperties3 = dialogProperties2;
                    function10 = function8;
                    function11 = function9;
                    shape2 = shape;
                    j2 = j;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TimePickerDialogKt.TimePickerDialog_FItCLgY$lambda$1(function0, function2, function3, modifier3, dialogProperties3, function10, function11, shape2, j2, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function8 = function4;
            i8 = i2 & 64;
            if (i8 != 0) {
                if ((1572864 & i) == 0) {
                    function9 = function5;
                    if (composerStartRestartGroup.changedInstance(function9)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((i & 12582912) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(shape)) ? 4194304 : 8388608;
                }
                if ((i & 100663296) == 0) {
                    int i117 = i3;
                    if ((i2 & 256) == 0) {
                        i15 = 33554432;
                    } else {
                        i15 = 33554432;
                    }
                    i10 = i117 | i15;
                } else {
                    i10 = i3;
                }
                i11 = i10;
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i12 = i11 | i14;
                } else {
                    i12 = i11;
                }
                if ((i12 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "75@3618L5,76@3678L14");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            dialogProperties4 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties4 = dialogProperties2;
                        }
                        if (i6 != 0) {
                            function8 = null;
                        }
                        if (i8 != 0) {
                            function9 = null;
                        }
                        if ((i2 & 128) != 0) {
                            shape3 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i12 &= -29360129;
                        } else {
                            shape3 = shape;
                        }
                        if ((i2 & 256) != 0) {
                            i12 &= -234881025;
                            containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        } else {
                            containerColor = j;
                        }
                        function12 = function8;
                        i13 = i12;
                        dialogProperties2 = dialogProperties4;
                        modifier4 = modifier2;
                        function13 = function9;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            dialogProperties4 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties4 = dialogProperties2;
                        }
                        if (i6 != 0) {
                            function8 = null;
                        }
                        if (i8 != 0) {
                            function9 = null;
                        }
                        if ((i2 & 128) != 0) {
                            shape3 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i12 &= -29360129;
                        } else {
                            shape3 = shape;
                        }
                        if ((i2 & 256) != 0) {
                            i12 &= -234881025;
                            containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        } else {
                            containerColor = j;
                        }
                        function12 = function8;
                        i13 = i12;
                        dialogProperties2 = dialogProperties4;
                        modifier4 = modifier2;
                        function13 = function9;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(951250327, i13, -1, "androidx.compose.material3.TimePickerDialog (TimePickerDialog.kt:78)");
                    }
                    final Function2 function114 = function7;
                    AndroidDialog_androidKt.Dialog(function0, dialogProperties2, ComposableLambdaKt.rememberComposableLambda(296331566, true, new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TimePickerDialogKt.TimePickerDialog_FItCLgY$lambda$0(function2, function114, modifier4, function12, function13, shape3, containerColor, function6, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 9) & 112) | (i13 & 14) | 384, 0);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    dialogProperties3 = dialogProperties2;
                    modifier3 = modifier4;
                    function10 = function12;
                    function11 = function13;
                    shape2 = shape3;
                    j2 = containerColor;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    dialogProperties3 = dialogProperties2;
                    function10 = function8;
                    function11 = function9;
                    shape2 = shape;
                    j2 = j;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TimePickerDialogKt.TimePickerDialog_FItCLgY$lambda$1(function0, function2, function3, modifier3, dialogProperties3, function10, function11, shape2, j2, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            function9 = function5;
            if ((i & 12582912) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(shape)) ? 4194304 : 8388608;
            }
            if ((i & 100663296) == 0) {
                int i118 = i3;
                if ((i2 & 256) == 0) {
                    i15 = 33554432;
                } else {
                    i15 = 33554432;
                }
                i10 = i118 | i15;
            } else {
                i10 = i3;
            }
            i11 = i10;
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i14 = 268435456;
                }
                i12 = i11 | i14;
            } else {
                i12 = i11;
            }
            if ((i12 & 306783379) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "75@3618L5,76@3678L14");
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        dialogProperties4 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties4 = dialogProperties2;
                    }
                    if (i6 != 0) {
                        function8 = null;
                    }
                    if (i8 != 0) {
                        function9 = null;
                    }
                    if ((i2 & 128) != 0) {
                        shape3 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i12 &= -29360129;
                    } else {
                        shape3 = shape;
                    }
                    if ((i2 & 256) != 0) {
                        i12 &= -234881025;
                        containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    } else {
                        containerColor = j;
                    }
                    function12 = function8;
                    i13 = i12;
                    dialogProperties2 = dialogProperties4;
                    modifier4 = modifier2;
                    function13 = function9;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        dialogProperties4 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties4 = dialogProperties2;
                    }
                    if (i6 != 0) {
                        function8 = null;
                    }
                    if (i8 != 0) {
                        function9 = null;
                    }
                    if ((i2 & 128) != 0) {
                        shape3 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i12 &= -29360129;
                    } else {
                        shape3 = shape;
                    }
                    if ((i2 & 256) != 0) {
                        i12 &= -234881025;
                        containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    } else {
                        containerColor = j;
                    }
                    function12 = function8;
                    i13 = i12;
                    dialogProperties2 = dialogProperties4;
                    modifier4 = modifier2;
                    function13 = function9;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(951250327, i13, -1, "androidx.compose.material3.TimePickerDialog (TimePickerDialog.kt:78)");
                }
                final Function2 function115 = function7;
                AndroidDialog_androidKt.Dialog(function0, dialogProperties2, ComposableLambdaKt.rememberComposableLambda(296331566, true, new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TimePickerDialogKt.TimePickerDialog_FItCLgY$lambda$0(function2, function115, modifier4, function12, function13, shape3, containerColor, function6, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 9) & 112) | (i13 & 14) | 384, 0);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                dialogProperties3 = dialogProperties2;
                modifier3 = modifier4;
                function10 = function12;
                function11 = function13;
                shape2 = shape3;
                j2 = containerColor;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                dialogProperties3 = dialogProperties2;
                function10 = function8;
                function11 = function9;
                shape2 = shape;
                j2 = j;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TimePickerDialogKt.TimePickerDialog_FItCLgY$lambda$1(function0, function2, function3, modifier3, dialogProperties3, function10, function11, shape2, j2, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        dialogProperties2 = dialogProperties;
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((196608 & i) == 0) {
                function8 = function4;
                if (composerStartRestartGroup.changedInstance(function8)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                if ((1572864 & i) == 0) {
                    function9 = function5;
                    if (composerStartRestartGroup.changedInstance(function9)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((i & 12582912) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(shape)) ? 4194304 : 8388608;
                }
                if ((i & 100663296) == 0) {
                    int i119 = i3;
                    if ((i2 & 256) == 0) {
                        i15 = 33554432;
                    } else {
                        i15 = 33554432;
                    }
                    i10 = i119 | i15;
                } else {
                    i10 = i3;
                }
                i11 = i10;
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i12 = i11 | i14;
                } else {
                    i12 = i11;
                }
                if ((i12 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "75@3618L5,76@3678L14");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            dialogProperties4 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties4 = dialogProperties2;
                        }
                        if (i6 != 0) {
                            function8 = null;
                        }
                        if (i8 != 0) {
                            function9 = null;
                        }
                        if ((i2 & 128) != 0) {
                            shape3 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i12 &= -29360129;
                        } else {
                            shape3 = shape;
                        }
                        if ((i2 & 256) != 0) {
                            i12 &= -234881025;
                            containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        } else {
                            containerColor = j;
                        }
                        function12 = function8;
                        i13 = i12;
                        dialogProperties2 = dialogProperties4;
                        modifier4 = modifier2;
                        function13 = function9;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            dialogProperties4 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties4 = dialogProperties2;
                        }
                        if (i6 != 0) {
                            function8 = null;
                        }
                        if (i8 != 0) {
                            function9 = null;
                        }
                        if ((i2 & 128) != 0) {
                            shape3 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i12 &= -29360129;
                        } else {
                            shape3 = shape;
                        }
                        if ((i2 & 256) != 0) {
                            i12 &= -234881025;
                            containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        } else {
                            containerColor = j;
                        }
                        function12 = function8;
                        i13 = i12;
                        dialogProperties2 = dialogProperties4;
                        modifier4 = modifier2;
                        function13 = function9;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(951250327, i13, -1, "androidx.compose.material3.TimePickerDialog (TimePickerDialog.kt:78)");
                    }
                    final Function2 function116 = function7;
                    AndroidDialog_androidKt.Dialog(function0, dialogProperties2, ComposableLambdaKt.rememberComposableLambda(296331566, true, new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TimePickerDialogKt.TimePickerDialog_FItCLgY$lambda$0(function2, function116, modifier4, function12, function13, shape3, containerColor, function6, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 9) & 112) | (i13 & 14) | 384, 0);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    dialogProperties3 = dialogProperties2;
                    modifier3 = modifier4;
                    function10 = function12;
                    function11 = function13;
                    shape2 = shape3;
                    j2 = containerColor;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    dialogProperties3 = dialogProperties2;
                    function10 = function8;
                    function11 = function9;
                    shape2 = shape;
                    j2 = j;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TimePickerDialogKt.TimePickerDialog_FItCLgY$lambda$1(function0, function2, function3, modifier3, dialogProperties3, function10, function11, shape2, j2, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            function9 = function5;
            if ((i & 12582912) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(shape)) ? 4194304 : 8388608;
            }
            if ((i & 100663296) == 0) {
                int i1110 = i3;
                if ((i2 & 256) == 0) {
                    i15 = 33554432;
                } else {
                    i15 = 33554432;
                }
                i10 = i1110 | i15;
            } else {
                i10 = i3;
            }
            i11 = i10;
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i14 = 268435456;
                }
                i12 = i11 | i14;
            } else {
                i12 = i11;
            }
            if ((i12 & 306783379) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "75@3618L5,76@3678L14");
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        dialogProperties4 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties4 = dialogProperties2;
                    }
                    if (i6 != 0) {
                        function8 = null;
                    }
                    if (i8 != 0) {
                        function9 = null;
                    }
                    if ((i2 & 128) != 0) {
                        shape3 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i12 &= -29360129;
                    } else {
                        shape3 = shape;
                    }
                    if ((i2 & 256) != 0) {
                        i12 &= -234881025;
                        containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    } else {
                        containerColor = j;
                    }
                    function12 = function8;
                    i13 = i12;
                    dialogProperties2 = dialogProperties4;
                    modifier4 = modifier2;
                    function13 = function9;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        dialogProperties4 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties4 = dialogProperties2;
                    }
                    if (i6 != 0) {
                        function8 = null;
                    }
                    if (i8 != 0) {
                        function9 = null;
                    }
                    if ((i2 & 128) != 0) {
                        shape3 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i12 &= -29360129;
                    } else {
                        shape3 = shape;
                    }
                    if ((i2 & 256) != 0) {
                        i12 &= -234881025;
                        containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    } else {
                        containerColor = j;
                    }
                    function12 = function8;
                    i13 = i12;
                    dialogProperties2 = dialogProperties4;
                    modifier4 = modifier2;
                    function13 = function9;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(951250327, i13, -1, "androidx.compose.material3.TimePickerDialog (TimePickerDialog.kt:78)");
                }
                final Function2 function117 = function7;
                AndroidDialog_androidKt.Dialog(function0, dialogProperties2, ComposableLambdaKt.rememberComposableLambda(296331566, true, new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TimePickerDialogKt.TimePickerDialog_FItCLgY$lambda$0(function2, function117, modifier4, function12, function13, shape3, containerColor, function6, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 9) & 112) | (i13 & 14) | 384, 0);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                dialogProperties3 = dialogProperties2;
                modifier3 = modifier4;
                function10 = function12;
                function11 = function13;
                shape2 = shape3;
                j2 = containerColor;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                dialogProperties3 = dialogProperties2;
                function10 = function8;
                function11 = function9;
                shape2 = shape;
                j2 = j;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TimePickerDialogKt.TimePickerDialog_FItCLgY$lambda$1(function0, function2, function3, modifier3, dialogProperties3, function10, function11, shape2, j2, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        function8 = function4;
        i8 = i2 & 64;
        if (i8 != 0) {
            if ((1572864 & i) == 0) {
                function9 = function5;
                if (composerStartRestartGroup.changedInstance(function9)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            if ((i & 12582912) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(shape)) ? 4194304 : 8388608;
            }
            if ((i & 100663296) == 0) {
                int i1111 = i3;
                if ((i2 & 256) == 0) {
                    i15 = 33554432;
                } else {
                    i15 = 33554432;
                }
                i10 = i1111 | i15;
            } else {
                i10 = i3;
            }
            i11 = i10;
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i14 = 268435456;
                }
                i12 = i11 | i14;
            } else {
                i12 = i11;
            }
            if ((i12 & 306783379) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "75@3618L5,76@3678L14");
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        dialogProperties4 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties4 = dialogProperties2;
                    }
                    if (i6 != 0) {
                        function8 = null;
                    }
                    if (i8 != 0) {
                        function9 = null;
                    }
                    if ((i2 & 128) != 0) {
                        shape3 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i12 &= -29360129;
                    } else {
                        shape3 = shape;
                    }
                    if ((i2 & 256) != 0) {
                        i12 &= -234881025;
                        containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    } else {
                        containerColor = j;
                    }
                    function12 = function8;
                    i13 = i12;
                    dialogProperties2 = dialogProperties4;
                    modifier4 = modifier2;
                    function13 = function9;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        dialogProperties4 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties4 = dialogProperties2;
                    }
                    if (i6 != 0) {
                        function8 = null;
                    }
                    if (i8 != 0) {
                        function9 = null;
                    }
                    if ((i2 & 128) != 0) {
                        shape3 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i12 &= -29360129;
                    } else {
                        shape3 = shape;
                    }
                    if ((i2 & 256) != 0) {
                        i12 &= -234881025;
                        containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    } else {
                        containerColor = j;
                    }
                    function12 = function8;
                    i13 = i12;
                    dialogProperties2 = dialogProperties4;
                    modifier4 = modifier2;
                    function13 = function9;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(951250327, i13, -1, "androidx.compose.material3.TimePickerDialog (TimePickerDialog.kt:78)");
                }
                final Function2 function118 = function7;
                AndroidDialog_androidKt.Dialog(function0, dialogProperties2, ComposableLambdaKt.rememberComposableLambda(296331566, true, new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TimePickerDialogKt.TimePickerDialog_FItCLgY$lambda$0(function2, function118, modifier4, function12, function13, shape3, containerColor, function6, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 9) & 112) | (i13 & 14) | 384, 0);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                dialogProperties3 = dialogProperties2;
                modifier3 = modifier4;
                function10 = function12;
                function11 = function13;
                shape2 = shape3;
                j2 = containerColor;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                dialogProperties3 = dialogProperties2;
                function10 = function8;
                function11 = function9;
                shape2 = shape;
                j2 = j;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TimePickerDialogKt.TimePickerDialog_FItCLgY$lambda$1(function0, function2, function3, modifier3, dialogProperties3, function10, function11, shape2, j2, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 1572864;
        function9 = function5;
        if ((i & 12582912) != 0) {
            i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(shape)) ? 4194304 : 8388608;
        }
        if ((i & 100663296) == 0) {
            int i1112 = i3;
            if ((i2 & 256) == 0) {
                i15 = 33554432;
            } else {
                i15 = 33554432;
            }
            i10 = i1112 | i15;
        } else {
            i10 = i3;
        }
        i11 = i10;
        if ((i & 805306368) == 0) {
            if (composerStartRestartGroup.changedInstance(function6)) {
                i14 = C.BUFFER_FLAG_LAST_SAMPLE;
            } else {
                i14 = 268435456;
            }
            i12 = i11 | i14;
        } else {
            i12 = i11;
        }
        if ((i12 & 306783379) != 306783378) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "75@3618L5,76@3678L14");
            if ((i & 1) != 0) {
                if (i16 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    dialogProperties4 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                } else {
                    dialogProperties4 = dialogProperties2;
                }
                if (i6 != 0) {
                    function8 = null;
                }
                if (i8 != 0) {
                    function9 = null;
                }
                if ((i2 & 128) != 0) {
                    shape3 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    i12 &= -29360129;
                } else {
                    shape3 = shape;
                }
                if ((i2 & 256) != 0) {
                    i12 &= -234881025;
                    containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                } else {
                    containerColor = j;
                }
                function12 = function8;
                i13 = i12;
                dialogProperties2 = dialogProperties4;
                modifier4 = modifier2;
                function13 = function9;
            } else {
                if (i16 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    dialogProperties4 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                } else {
                    dialogProperties4 = dialogProperties2;
                }
                if (i6 != 0) {
                    function8 = null;
                }
                if (i8 != 0) {
                    function9 = null;
                }
                if ((i2 & 128) != 0) {
                    shape3 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    i12 &= -29360129;
                } else {
                    shape3 = shape;
                }
                if ((i2 & 256) != 0) {
                    i12 &= -234881025;
                    containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                } else {
                    containerColor = j;
                }
                function12 = function8;
                i13 = i12;
                dialogProperties2 = dialogProperties4;
                modifier4 = modifier2;
                function13 = function9;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(951250327, i13, -1, "androidx.compose.material3.TimePickerDialog (TimePickerDialog.kt:78)");
            }
            final Function2 function119 = function7;
            AndroidDialog_androidKt.Dialog(function0, dialogProperties2, ComposableLambdaKt.rememberComposableLambda(296331566, true, new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerDialogKt.TimePickerDialog_FItCLgY$lambda$0(function2, function119, modifier4, function12, function13, shape3, containerColor, function6, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i13 >> 9) & 112) | (i13 & 14) | 384, 0);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            dialogProperties3 = dialogProperties2;
            modifier3 = modifier4;
            function10 = function12;
            function11 = function13;
            shape2 = shape3;
            j2 = containerColor;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            dialogProperties3 = dialogProperties2;
            function10 = function8;
            function11 = function9;
            shape2 = shape;
            j2 = j;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerDialogKt.TimePickerDialog_FItCLgY$lambda$1(function0, function2, function3, modifier3, dialogProperties3, function10, function11, shape2, j2, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimePickerDialog_FItCLgY$lambda$0(Function2 function2, Function2 function3, Modifier modifier, Function2 function4, Function2 function5, Shape shape, long j, Function3 function6, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C80@3830L331:TimePickerDialog.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(296331566, i, -1, "androidx.compose.material3.TimePickerDialog.<anonymous> (TimePickerDialog.kt:80)");
            }
            m4526TimePickerDialogLayout3csKH6Y(function2, function3, modifier, function4, function5, shape, j, function6, composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0122 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:102:0x0124  */
    /* JADX WARN: Code duplicated, block: B:105:0x012c  */
    /* JADX WARN: Code duplicated, block: B:107:0x012f  */
    /* JADX WARN: Code duplicated, block: B:110:0x0135  */
    /* JADX WARN: Code duplicated, block: B:111:0x013f  */
    /* JADX WARN: Code duplicated, block: B:114:0x0145  */
    /* JADX WARN: Code duplicated, block: B:117:0x0157  */
    /* JADX WARN: Code duplicated, block: B:120:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:122:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:125:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:32:0x005c  */
    /* JADX WARN: Code duplicated, block: B:34:0x0060  */
    /* JADX WARN: Code duplicated, block: B:36:0x0068  */
    /* JADX WARN: Code duplicated, block: B:37:0x006b  */
    /* JADX WARN: Code duplicated, block: B:42:0x0075  */
    /* JADX WARN: Code duplicated, block: B:43:0x0078  */
    /* JADX WARN: Code duplicated, block: B:45:0x007c  */
    /* JADX WARN: Code duplicated, block: B:47:0x0084  */
    /* JADX WARN: Code duplicated, block: B:48:0x0087  */
    /* JADX WARN: Code duplicated, block: B:53:0x0092  */
    /* JADX WARN: Code duplicated, block: B:55:0x0096  */
    /* JADX WARN: Code duplicated, block: B:57:0x009e  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:69:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:75:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:80:0x00da  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:84:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:89:0x0106  */
    /* JADX INFO: renamed from: TimePickerDialogLayout-3csKH6Y, reason: not valid java name */
    public static final void m4526TimePickerDialogLayout3csKH6Y(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, Shape shape, long j, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function6, Composer composer, final int i, final int i2) {
        int i3;
        Function2<? super Composer, ? super Integer, Unit> function7;
        Modifier modifier2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function8;
        int i5;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function9;
        int i7;
        Shape shape2;
        long containerColor;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function10;
        int i8;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function11;
        final Function2<? super Composer, ? super Integer, Unit> function12;
        final Shape shape3;
        final long j2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i9;
        int i10;
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(-401873644);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TimePickerDialogLayout)N(confirmButton,title,modifier,modeToggleButton,dismissButton,shape,containerColor:c#ui.graphics.Color,content)109@4776L519,104@4619L676:TimePickerDialog.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            function7 = function3;
            i3 |= composerStartRestartGroup.changedInstance(function7) ? 32 : 16;
        } else {
            function7 = function3;
        }
        int i12 = i2 & 4;
        if (i12 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    function8 = function4;
                    if (composerStartRestartGroup.changedInstance(function8)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((i & 24576) == 0) {
                        function9 = function5;
                        if (composerStartRestartGroup.changedInstance(function9)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    if ((196608 & i) == 0) {
                        if ((i2 & 32) == 0) {
                            shape2 = shape;
                            int i13 = composerStartRestartGroup.changed(shape2) ? 131072 : 65536;
                            i3 |= i13;
                        } else {
                            shape2 = shape;
                        }
                        i3 |= i13;
                    } else {
                        shape2 = shape;
                    }
                    if ((1572864 & i) == 0) {
                        if ((i2 & 64) == 0) {
                            containerColor = j;
                            int i14 = composerStartRestartGroup.changed(containerColor) ? 1048576 : 524288;
                            i3 |= i14;
                        } else {
                            containerColor = j;
                        }
                        i3 |= i14;
                    } else {
                        containerColor = j;
                    }
                    if ((12582912 & i) == 0) {
                        function10 = function6;
                        if (composerStartRestartGroup.changedInstance(function10)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    } else {
                        function10 = function6;
                    }
                    i8 = i3;
                    if ((i3 & 4793491) != 4793490) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i8 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "100@4486L5,101@4546L14");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i12 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function8 = null;
                            }
                            if (i6 != 0) {
                                function9 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i9 = i8 & (-458753);
                                shape2 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            } else {
                                i9 = i8;
                            }
                            if ((i2 & 64) != 0) {
                                containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i10 = i9 & (-3670017);
                            }
                            final Function2<? super Composer, ? super Integer, Unit> function13 = function9;
                            Modifier modifier4 = modifier2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-401873644, i9, -1, "androidx.compose.material3.TimePickerDialogLayout (TimePickerDialog.kt:103)");
                            }
                            final Function2<? super Composer, ? super Integer, Unit> function14 = function7;
                            final Function2<? super Composer, ? super Integer, Unit> function15 = function8;
                            final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function16 = function10;
                            int i15 = i9 >> 12;
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m4323SurfaceT9BRK9s(modifier4, shape2, containerColor, 0L, DialogTokens.INSTANCE.m5333getContainerElevationD9Ej5fM(), 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1522143641, true, new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TimePickerDialogKt.TimePickerDialogLayout_3csKH6Y$lambda$0(function14, function16, function15, function13, function2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composer2, ((i9 >> 6) & 14) | 12607488 | (i15 & 112) | (i15 & 896), 104);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function11 = function13;
                            modifier3 = modifier4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            i10 = (i2 & 32) != 0 ? i8 & (-458753) : i8;
                            if ((i2 & 64) != 0) {
                                i10 &= -3670017;
                            }
                        }
                        i9 = i10;
                        final Function2 function17 = function9;
                        Modifier modifier5 = modifier2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-401873644, i9, -1, "androidx.compose.material3.TimePickerDialogLayout (TimePickerDialog.kt:103)");
                        }
                        final Function2 function18 = function7;
                        final Function2 function19 = function8;
                        final Function3 function110 = function10;
                        int i16 = i9 >> 12;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m4323SurfaceT9BRK9s(modifier5, shape2, containerColor, 0L, DialogTokens.INSTANCE.m5333getContainerElevationD9Ej5fM(), 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1522143641, true, new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TimePickerDialogKt.TimePickerDialogLayout_3csKH6Y$lambda$0(function18, function110, function19, function17, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, ((i9 >> 6) & 14) | 12607488 | (i16 & 112) | (i16 & 896), 104);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function11 = function17;
                        modifier3 = modifier5;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        function11 = function9;
                    }
                    function12 = function8;
                    shape3 = shape2;
                    j2 = containerColor;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TimePickerDialogKt.TimePickerDialogLayout_3csKH6Y$lambda$1(function2, function3, modifier3, function12, function11, shape3, j2, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                function9 = function5;
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        shape2 = shape;
                        if (composerStartRestartGroup.changed(shape2)) {
                        }
                        i3 |= i13;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i13;
                } else {
                    shape2 = shape;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        containerColor = j;
                        if (composerStartRestartGroup.changed(containerColor)) {
                        }
                        i3 |= i14;
                    } else {
                        containerColor = j;
                    }
                    i3 |= i14;
                } else {
                    containerColor = j;
                }
                if ((12582912 & i) == 0) {
                    function10 = function6;
                    if (composerStartRestartGroup.changedInstance(function10)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                } else {
                    function10 = function6;
                }
                i8 = i3;
                if ((i3 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i8 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "100@4486L5,101@4546L14");
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function8 = null;
                        }
                        if (i6 != 0) {
                            function9 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i9 = i8 & (-458753);
                            shape2 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            i9 = i8;
                        }
                        if ((i2 & 64) != 0) {
                            containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i10 = i9 & (-3670017);
                            i9 = i10;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function8 = null;
                        }
                        if (i6 != 0) {
                            function9 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i9 = i8 & (-458753);
                            shape2 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            i9 = i8;
                        }
                        if ((i2 & 64) != 0) {
                            containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i10 = i9 & (-3670017);
                            i9 = i10;
                        }
                    }
                    final Function2 function111 = function9;
                    Modifier modifier6 = modifier2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-401873644, i9, -1, "androidx.compose.material3.TimePickerDialogLayout (TimePickerDialog.kt:103)");
                    }
                    final Function2 function112 = function7;
                    final Function2 function113 = function8;
                    final Function3 function114 = function10;
                    int i17 = i9 >> 12;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m4323SurfaceT9BRK9s(modifier6, shape2, containerColor, 0L, DialogTokens.INSTANCE.m5333getContainerElevationD9Ej5fM(), 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1522143641, true, new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TimePickerDialogKt.TimePickerDialogLayout_3csKH6Y$lambda$0(function112, function114, function113, function111, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, ((i9 >> 6) & 14) | 12607488 | (i17 & 112) | (i17 & 896), 104);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function11 = function111;
                    modifier3 = modifier6;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    function11 = function9;
                }
                function12 = function8;
                shape3 = shape2;
                j2 = containerColor;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TimePickerDialogKt.TimePickerDialogLayout_3csKH6Y$lambda$1(function2, function3, modifier3, function12, function11, shape3, j2, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            function8 = function4;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    function9 = function5;
                    if (composerStartRestartGroup.changedInstance(function9)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        shape2 = shape;
                        if (composerStartRestartGroup.changed(shape2)) {
                        }
                        i3 |= i13;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i13;
                } else {
                    shape2 = shape;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        containerColor = j;
                        if (composerStartRestartGroup.changed(containerColor)) {
                        }
                        i3 |= i14;
                    } else {
                        containerColor = j;
                    }
                    i3 |= i14;
                } else {
                    containerColor = j;
                }
                if ((12582912 & i) == 0) {
                    function10 = function6;
                    if (composerStartRestartGroup.changedInstance(function10)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                } else {
                    function10 = function6;
                }
                i8 = i3;
                if ((i3 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i8 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "100@4486L5,101@4546L14");
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function8 = null;
                        }
                        if (i6 != 0) {
                            function9 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i9 = i8 & (-458753);
                            shape2 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            i9 = i8;
                        }
                        if ((i2 & 64) != 0) {
                            containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i10 = i9 & (-3670017);
                            i9 = i10;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function8 = null;
                        }
                        if (i6 != 0) {
                            function9 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i9 = i8 & (-458753);
                            shape2 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            i9 = i8;
                        }
                        if ((i2 & 64) != 0) {
                            containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i10 = i9 & (-3670017);
                            i9 = i10;
                        }
                    }
                    final Function2 function115 = function9;
                    Modifier modifier7 = modifier2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-401873644, i9, -1, "androidx.compose.material3.TimePickerDialogLayout (TimePickerDialog.kt:103)");
                    }
                    final Function2 function116 = function7;
                    final Function2 function117 = function8;
                    final Function3 function118 = function10;
                    int i18 = i9 >> 12;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m4323SurfaceT9BRK9s(modifier7, shape2, containerColor, 0L, DialogTokens.INSTANCE.m5333getContainerElevationD9Ej5fM(), 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1522143641, true, new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TimePickerDialogKt.TimePickerDialogLayout_3csKH6Y$lambda$0(function116, function118, function117, function115, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, ((i9 >> 6) & 14) | 12607488 | (i18 & 112) | (i18 & 896), 104);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function11 = function115;
                    modifier3 = modifier7;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    function11 = function9;
                }
                function12 = function8;
                shape3 = shape2;
                j2 = containerColor;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TimePickerDialogKt.TimePickerDialogLayout_3csKH6Y$lambda$1(function2, function3, modifier3, function12, function11, shape3, j2, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            function9 = function5;
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i13;
                } else {
                    shape2 = shape;
                }
                i3 |= i13;
            } else {
                shape2 = shape;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    containerColor = j;
                    if (composerStartRestartGroup.changed(containerColor)) {
                    }
                    i3 |= i14;
                } else {
                    containerColor = j;
                }
                i3 |= i14;
            } else {
                containerColor = j;
            }
            if ((12582912 & i) == 0) {
                function10 = function6;
                if (composerStartRestartGroup.changedInstance(function10)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            } else {
                function10 = function6;
            }
            i8 = i3;
            if ((i3 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i8 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "100@4486L5,101@4546L14");
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function8 = null;
                    }
                    if (i6 != 0) {
                        function9 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i9 = i8 & (-458753);
                        shape2 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    } else {
                        i9 = i8;
                    }
                    if ((i2 & 64) != 0) {
                        containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i10 = i9 & (-3670017);
                        i9 = i10;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function8 = null;
                    }
                    if (i6 != 0) {
                        function9 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i9 = i8 & (-458753);
                        shape2 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    } else {
                        i9 = i8;
                    }
                    if ((i2 & 64) != 0) {
                        containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i10 = i9 & (-3670017);
                        i9 = i10;
                    }
                }
                final Function2 function119 = function9;
                Modifier modifier8 = modifier2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-401873644, i9, -1, "androidx.compose.material3.TimePickerDialogLayout (TimePickerDialog.kt:103)");
                }
                final Function2 function1110 = function7;
                final Function2 function1111 = function8;
                final Function3 function1112 = function10;
                int i19 = i9 >> 12;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m4323SurfaceT9BRK9s(modifier8, shape2, containerColor, 0L, DialogTokens.INSTANCE.m5333getContainerElevationD9Ej5fM(), 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1522143641, true, new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TimePickerDialogKt.TimePickerDialogLayout_3csKH6Y$lambda$0(function1110, function1112, function1111, function119, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, ((i9 >> 6) & 14) | 12607488 | (i19 & 112) | (i19 & 896), 104);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function11 = function119;
                modifier3 = modifier8;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                function11 = function9;
            }
            function12 = function8;
            shape3 = shape2;
            j2 = containerColor;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TimePickerDialogKt.TimePickerDialogLayout_3csKH6Y$lambda$1(function2, function3, modifier3, function12, function11, shape3, j2, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                function8 = function4;
                if (composerStartRestartGroup.changedInstance(function8)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    function9 = function5;
                    if (composerStartRestartGroup.changedInstance(function9)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        shape2 = shape;
                        if (composerStartRestartGroup.changed(shape2)) {
                        }
                        i3 |= i13;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i13;
                } else {
                    shape2 = shape;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        containerColor = j;
                        if (composerStartRestartGroup.changed(containerColor)) {
                        }
                        i3 |= i14;
                    } else {
                        containerColor = j;
                    }
                    i3 |= i14;
                } else {
                    containerColor = j;
                }
                if ((12582912 & i) == 0) {
                    function10 = function6;
                    if (composerStartRestartGroup.changedInstance(function10)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                } else {
                    function10 = function6;
                }
                i8 = i3;
                if ((i3 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i8 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "100@4486L5,101@4546L14");
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function8 = null;
                        }
                        if (i6 != 0) {
                            function9 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i9 = i8 & (-458753);
                            shape2 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            i9 = i8;
                        }
                        if ((i2 & 64) != 0) {
                            containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i10 = i9 & (-3670017);
                            i9 = i10;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function8 = null;
                        }
                        if (i6 != 0) {
                            function9 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i9 = i8 & (-458753);
                            shape2 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            i9 = i8;
                        }
                        if ((i2 & 64) != 0) {
                            containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i10 = i9 & (-3670017);
                            i9 = i10;
                        }
                    }
                    final Function2 function1113 = function9;
                    Modifier modifier9 = modifier2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-401873644, i9, -1, "androidx.compose.material3.TimePickerDialogLayout (TimePickerDialog.kt:103)");
                    }
                    final Function2 function1114 = function7;
                    final Function2 function1115 = function8;
                    final Function3 function1116 = function10;
                    int i110 = i9 >> 12;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m4323SurfaceT9BRK9s(modifier9, shape2, containerColor, 0L, DialogTokens.INSTANCE.m5333getContainerElevationD9Ej5fM(), 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1522143641, true, new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TimePickerDialogKt.TimePickerDialogLayout_3csKH6Y$lambda$0(function1114, function1116, function1115, function1113, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, ((i9 >> 6) & 14) | 12607488 | (i110 & 112) | (i110 & 896), 104);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function11 = function1113;
                    modifier3 = modifier9;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    function11 = function9;
                }
                function12 = function8;
                shape3 = shape2;
                j2 = containerColor;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TimePickerDialogKt.TimePickerDialogLayout_3csKH6Y$lambda$1(function2, function3, modifier3, function12, function11, shape3, j2, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            function9 = function5;
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i13;
                } else {
                    shape2 = shape;
                }
                i3 |= i13;
            } else {
                shape2 = shape;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    containerColor = j;
                    if (composerStartRestartGroup.changed(containerColor)) {
                    }
                    i3 |= i14;
                } else {
                    containerColor = j;
                }
                i3 |= i14;
            } else {
                containerColor = j;
            }
            if ((12582912 & i) == 0) {
                function10 = function6;
                if (composerStartRestartGroup.changedInstance(function10)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            } else {
                function10 = function6;
            }
            i8 = i3;
            if ((i3 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i8 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "100@4486L5,101@4546L14");
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function8 = null;
                    }
                    if (i6 != 0) {
                        function9 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i9 = i8 & (-458753);
                        shape2 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    } else {
                        i9 = i8;
                    }
                    if ((i2 & 64) != 0) {
                        containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i10 = i9 & (-3670017);
                        i9 = i10;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function8 = null;
                    }
                    if (i6 != 0) {
                        function9 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i9 = i8 & (-458753);
                        shape2 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    } else {
                        i9 = i8;
                    }
                    if ((i2 & 64) != 0) {
                        containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i10 = i9 & (-3670017);
                        i9 = i10;
                    }
                }
                final Function2 function1117 = function9;
                Modifier modifier10 = modifier2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-401873644, i9, -1, "androidx.compose.material3.TimePickerDialogLayout (TimePickerDialog.kt:103)");
                }
                final Function2 function1118 = function7;
                final Function2 function1119 = function8;
                final Function3 function11110 = function10;
                int i111 = i9 >> 12;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m4323SurfaceT9BRK9s(modifier10, shape2, containerColor, 0L, DialogTokens.INSTANCE.m5333getContainerElevationD9Ej5fM(), 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1522143641, true, new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TimePickerDialogKt.TimePickerDialogLayout_3csKH6Y$lambda$0(function1118, function11110, function1119, function1117, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, ((i9 >> 6) & 14) | 12607488 | (i111 & 112) | (i111 & 896), 104);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function11 = function1117;
                modifier3 = modifier10;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                function11 = function9;
            }
            function12 = function8;
            shape3 = shape2;
            j2 = containerColor;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TimePickerDialogKt.TimePickerDialogLayout_3csKH6Y$lambda$1(function2, function3, modifier3, function12, function11, shape3, j2, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        function8 = function4;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 24576) == 0) {
                function9 = function5;
                if (composerStartRestartGroup.changedInstance(function9)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i13;
                } else {
                    shape2 = shape;
                }
                i3 |= i13;
            } else {
                shape2 = shape;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    containerColor = j;
                    if (composerStartRestartGroup.changed(containerColor)) {
                    }
                    i3 |= i14;
                } else {
                    containerColor = j;
                }
                i3 |= i14;
            } else {
                containerColor = j;
            }
            if ((12582912 & i) == 0) {
                function10 = function6;
                if (composerStartRestartGroup.changedInstance(function10)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            } else {
                function10 = function6;
            }
            i8 = i3;
            if ((i3 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i8 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "100@4486L5,101@4546L14");
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function8 = null;
                    }
                    if (i6 != 0) {
                        function9 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i9 = i8 & (-458753);
                        shape2 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    } else {
                        i9 = i8;
                    }
                    if ((i2 & 64) != 0) {
                        containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i10 = i9 & (-3670017);
                        i9 = i10;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function8 = null;
                    }
                    if (i6 != 0) {
                        function9 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i9 = i8 & (-458753);
                        shape2 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    } else {
                        i9 = i8;
                    }
                    if ((i2 & 64) != 0) {
                        containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i10 = i9 & (-3670017);
                        i9 = i10;
                    }
                }
                final Function2 function11111 = function9;
                Modifier modifier11 = modifier2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-401873644, i9, -1, "androidx.compose.material3.TimePickerDialogLayout (TimePickerDialog.kt:103)");
                }
                final Function2 function11112 = function7;
                final Function2 function11113 = function8;
                final Function3 function11114 = function10;
                int i112 = i9 >> 12;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m4323SurfaceT9BRK9s(modifier11, shape2, containerColor, 0L, DialogTokens.INSTANCE.m5333getContainerElevationD9Ej5fM(), 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1522143641, true, new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TimePickerDialogKt.TimePickerDialogLayout_3csKH6Y$lambda$0(function11112, function11114, function11113, function11111, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, ((i9 >> 6) & 14) | 12607488 | (i112 & 112) | (i112 & 896), 104);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function11 = function11111;
                modifier3 = modifier11;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                function11 = function9;
            }
            function12 = function8;
            shape3 = shape2;
            j2 = containerColor;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TimePickerDialogKt.TimePickerDialogLayout_3csKH6Y$lambda$1(function2, function3, modifier3, function12, function11, shape3, j2, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        function9 = function5;
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i3 |= i13;
            } else {
                shape2 = shape;
            }
            i3 |= i13;
        } else {
            shape2 = shape;
        }
        if ((1572864 & i) == 0) {
            if ((i2 & 64) == 0) {
                containerColor = j;
                if (composerStartRestartGroup.changed(containerColor)) {
                }
                i3 |= i14;
            } else {
                containerColor = j;
            }
            i3 |= i14;
        } else {
            containerColor = j;
        }
        if ((12582912 & i) == 0) {
            function10 = function6;
            if (composerStartRestartGroup.changedInstance(function10)) {
                i11 = 8388608;
            } else {
                i11 = 4194304;
            }
            i3 |= i11;
        } else {
            function10 = function6;
        }
        i8 = i3;
        if ((i3 & 4793491) != 4793490) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i8 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "100@4486L5,101@4546L14");
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    function8 = null;
                }
                if (i6 != 0) {
                    function9 = null;
                }
                if ((i2 & 32) != 0) {
                    i9 = i8 & (-458753);
                    shape2 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                } else {
                    i9 = i8;
                }
                if ((i2 & 64) != 0) {
                    containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i10 = i9 & (-3670017);
                    i9 = i10;
                }
            } else {
                if (i12 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    function8 = null;
                }
                if (i6 != 0) {
                    function9 = null;
                }
                if ((i2 & 32) != 0) {
                    i9 = i8 & (-458753);
                    shape2 = TimePickerDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                } else {
                    i9 = i8;
                }
                if ((i2 & 64) != 0) {
                    containerColor = TimePickerDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i10 = i9 & (-3670017);
                    i9 = i10;
                }
            }
            final Function2 function11115 = function9;
            Modifier modifier12 = modifier2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-401873644, i9, -1, "androidx.compose.material3.TimePickerDialogLayout (TimePickerDialog.kt:103)");
            }
            final Function2 function11116 = function7;
            final Function2 function11117 = function8;
            final Function3 function11118 = function10;
            int i113 = i9 >> 12;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m4323SurfaceT9BRK9s(modifier12, shape2, containerColor, 0L, DialogTokens.INSTANCE.m5333getContainerElevationD9Ej5fM(), 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1522143641, true, new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerDialogKt.TimePickerDialogLayout_3csKH6Y$lambda$0(function11116, function11118, function11117, function11115, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, ((i9 >> 6) & 14) | 12607488 | (i113 & 112) | (i113 & 896), 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function11 = function11115;
            modifier3 = modifier12;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            function11 = function9;
        }
        function12 = function8;
        shape3 = shape2;
        j2 = containerColor;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerDialogKt.TimePickerDialogLayout_3csKH6Y$lambda$1(function2, function3, modifier3, function12, function11, shape3, j2, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimePickerDialogLayout_3csKH6Y$lambda$0(Function2 function2, Function3 function3, final Function2 function4, final Function2 function5, final Function2 function6, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C112@4859L388,110@4786L503:TimePickerDialog.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1522143641, i, -1, "androidx.compose.material3.TimePickerDialogLayout.<anonymous> (TimePickerDialog.kt:110)");
            }
            TimePickerCustomLayout(function2, ComposableLambdaKt.rememberComposableLambda(2122920701, true, new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerDialogKt.TimePickerDialogLayout_3csKH6Y$lambda$0$0(function4, function5, function6, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), function3, composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimePickerDialogLayout_3csKH6Y$lambda$0$0(Function2 function2, Function2 function3, Function2 function4, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C113@4877L356:TimePickerDialog.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2122920701, i, -1, "androidx.compose.material3.TimePickerDialogLayout.<anonymous>.<anonymous> (TimePickerDialog.kt:113)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_4 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(8));
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_4, Alignment.INSTANCE.getTop(), composer, 6);
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
            ComposerKt.sourceInformationMarkerStart(composer, 675820093, "C118@5097L38,120@5200L15:TimePickerDialog.kt#uh7d8r");
            if (function2 == null) {
                composer.startReplaceGroup(675833080);
            } else {
                composer.startReplaceGroup(2100011049);
                ComposerKt.sourceInformation(composer, "117@5068L8");
                function2.invoke(composer, 0);
            }
            composer.endReplaceGroup();
            SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composer, 0);
            if (function3 == null) {
                composer.startReplaceGroup(675935256);
            } else {
                composer.startReplaceGroup(2100014345);
                ComposerKt.sourceInformation(composer, "119@5171L8");
                function3.invoke(composer, 0);
            }
            composer.endReplaceGroup();
            function4.invoke(composer, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final void TimePickerCustomLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-493479138);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TimePickerCustomLayout)N(title,actions,content)135@5511L238,141@5775L4285,237@10066L56:TimePickerDialog.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function4) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-493479138, i2, -1, "androidx.compose.material3.TimePickerCustomLayout (TimePickerDialog.kt:133)");
            }
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(468305759, true, new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerDialogKt.TimePickerCustomLayout$lambda$0(function4, function2, function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1787030213, "CC(remember):TimePickerDialog.kt#9igjgp");
            TimePickerDialogKt$TimePickerCustomLayout$measurePolicy$1$1 timePickerDialogKt$TimePickerCustomLayout$measurePolicy$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (timePickerDialogKt$TimePickerCustomLayout$measurePolicy$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                timePickerDialogKt$TimePickerCustomLayout$measurePolicy$1$1RememberedValue = TimePickerDialogKt$TimePickerCustomLayout$measurePolicy$1$1.INSTANCE;
                composerStartRestartGroup.updateRememberedValue(timePickerDialogKt$TimePickerCustomLayout$measurePolicy$1$1RememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) timePickerDialogKt$TimePickerCustomLayout$measurePolicy$1$1RememberedValue;
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
            composableLambdaRememberComposableLambda.invoke(composerStartRestartGroup, 6);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerDialogKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerDialogKt.TimePickerCustomLayout$lambda$2(function2, function3, function4, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimePickerCustomLayout$lambda$0(Function3 function3, Function2 function2, Function2 function4, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C136@5525L54,137@5592L58,138@5663L76:TimePickerDialog.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(468305759, i, -1, "androidx.compose.material3.TimePickerCustomLayout.<anonymous> (TimePickerDialog.kt:136)");
            }
            Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "title");
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierLayoutId);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1033675543, "C136@5570L7:TimePickerDialog.kt#uh7d8r");
            function2.invoke(composer, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierLayoutId2 = LayoutIdKt.layoutId(Modifier.INSTANCE, "actions");
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierLayoutId2);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composer);
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1586475714, "C137@5639L9:TimePickerDialog.kt#uh7d8r");
            function4.invoke(composer, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierLayoutId3 = LayoutIdKt.layoutId(Modifier.INSTANCE, "timePickerContent");
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifierLayoutId3);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor3);
            } else {
                composer.useNode();
            }
            Composer composerM6062constructorimpl3 = Updater.m6062constructorimpl(composer);
            Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
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
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
