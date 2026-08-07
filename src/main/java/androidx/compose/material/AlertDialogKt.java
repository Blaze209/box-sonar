package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
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
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AlertDialog.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a¢\u0001\u0010\u0000\u001a\u00020\u00012\u000e\b\b\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0013\b\b\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0015\b\b\u0010\b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\b\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\b\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0081\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u008b\u0001\u0010\u0000\u001a\u00020\u00012\u000e\b\b\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0013\b\b\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0015\b\b\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\b\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0081\b¢\u0006\u0004\b\u0015\u0010\u0016\u001ax\u0010\u0017\u001a\u00020\u00012\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001a;\u0010\u001a\u001a\u00020\u0001*\u00020\u001b2\u0013\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u0005H\u0001¢\u0006\u0002\u0010\u001c\u001a2\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005H\u0001¢\u0006\u0004\b\"\u0010#\"\u000e\u0010$\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010%\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(\"\u0010\u0010)\u001a\u00020'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(\"\u0010\u0010*\u001a\u00020'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(¨\u0006+"}, d2 = {"AlertDialogImpl", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "dismissButton", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "properties", "Landroidx/compose/ui/window/DialogProperties;", "AlertDialogImpl-0nD-MI0", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;I)V", "buttons", "AlertDialogImpl-SxpAMN0", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;I)V", "AlertDialogContent", "AlertDialogContent-WMdw5o4", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/runtime/Composer;II)V", "AlertDialogBaselineLayout", "Landroidx/compose/foundation/layout/ColumnScope;", "(Landroidx/compose/foundation/layout/ColumnScope;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "AlertDialogFlowRow", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", "content", "AlertDialogFlowRow-ixp7dh8", "(FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TitlePadding", "TextPadding", "TitleBaselineDistanceFromTop", "Landroidx/compose/ui/unit/TextUnit;", "J", "TextBaselineDistanceFromTitle", "TextBaselineDistanceFromTop", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AlertDialogKt {
    private static final Modifier TextPadding;
    private static final Modifier TitlePadding;
    private static final long TitleBaselineDistanceFromTop = TextUnitKt.getSp(40);
    private static final long TextBaselineDistanceFromTitle = TextUnitKt.getSp(36);
    private static final long TextBaselineDistanceFromTop = TextUnitKt.getSp(38);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AlertDialogBaselineLayout$lambda$2(ColumnScope columnScope, Function2 function2, Function2 function3, int i, Composer composer, int i2) {
        AlertDialogBaselineLayout(columnScope, function2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AlertDialogContent_WMdw5o4$lambda$1(Function2 function2, Modifier modifier, Function2 function3, Function2 function4, Shape shape, long j, long j2, int i, int i2, Composer composer, int i3) {
        m2231AlertDialogContentWMdw5o4(function2, modifier, function3, function4, shape, j, j2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AlertDialogFlowRow_ixp7dh8$lambda$1(float f, float f2, Function2 function2, int i, Composer composer, int i2) {
        m2232AlertDialogFlowRowixp7dh8(f, f2, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: AlertDialogImpl-0nD-MI0, reason: not valid java name */
    public static final void m2233AlertDialogImpl0nDMI0(Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, Shape shape, long j, long j2, DialogProperties dialogProperties, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1483448977, "CC(AlertDialogImpl)N(onDismissRequest,confirmButton,modifier,dismissButton,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)149@6875L386,147@6799L678:AlertDialog.kt#jmzs0o");
        int i2 = i >> 3;
        AndroidAlertDialog_androidKt.m2242AlertDialogwqdebIU(function0, ComposableLambdaKt.rememberComposableLambda(-309297447, true, new AlertDialogKt$AlertDialogImpl$1(function3, function2), composer, 54), modifier, function4, function5, shape, j, j2, dialogProperties, composer, (i & 14) | 48 | (i & 896) | (i2 & 7168) | (57344 & i2) | (458752 & i2) | (3670016 & i2) | (29360128 & i2) | (i2 & 234881024), 0);
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* JADX INFO: renamed from: AlertDialogImpl-SxpAMN0, reason: not valid java name */
    public static final void m2234AlertDialogImplSxpAMN0(Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, Shape shape, long j, long j2, DialogProperties dialogProperties, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -214309806, "CC(AlertDialogImpl)N(onDismissRequest,buttons,modifier,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)180@7953L276,180@7884L345:AlertDialog.kt#jmzs0o");
        AndroidDialog_androidKt.Dialog(function0, dialogProperties, ComposableLambdaKt.rememberComposableLambda(-488319269, true, new AlertDialogKt$AlertDialogImpl$2(function2, modifier, function3, function4, shape, j, j2), composer, 54), composer, (i & 14) | 384 | ((i >> 21) & 112), 0);
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x012d  */
    /* JADX WARN: Code duplicated, block: B:103:0x0130  */
    /* JADX WARN: Code duplicated, block: B:106:0x0136  */
    /* JADX WARN: Code duplicated, block: B:107:0x0146  */
    /* JADX WARN: Code duplicated, block: B:110:0x014c  */
    /* JADX WARN: Code duplicated, block: B:111:0x015b  */
    /* JADX WARN: Code duplicated, block: B:114:0x0161  */
    /* JADX WARN: Code duplicated, block: B:117:0x0173  */
    /* JADX WARN: Code duplicated, block: B:120:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:122:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:125:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0042  */
    /* JADX WARN: Code duplicated, block: B:24:0x0045  */
    /* JADX WARN: Code duplicated, block: B:26:0x0049  */
    /* JADX WARN: Code duplicated, block: B:28:0x0051  */
    /* JADX WARN: Code duplicated, block: B:29:0x0054  */
    /* JADX WARN: Code duplicated, block: B:34:0x005e  */
    /* JADX WARN: Code duplicated, block: B:35:0x0061  */
    /* JADX WARN: Code duplicated, block: B:37:0x0065  */
    /* JADX WARN: Code duplicated, block: B:39:0x006d  */
    /* JADX WARN: Code duplicated, block: B:40:0x0070  */
    /* JADX WARN: Code duplicated, block: B:45:0x007a  */
    /* JADX WARN: Code duplicated, block: B:47:0x007e  */
    /* JADX WARN: Code duplicated, block: B:49:0x0086  */
    /* JADX WARN: Code duplicated, block: B:50:0x0089  */
    /* JADX WARN: Code duplicated, block: B:53:0x008f  */
    /* JADX WARN: Code duplicated, block: B:56:0x0096  */
    /* JADX WARN: Code duplicated, block: B:58:0x009a  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:69:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:75:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:78:0x00de  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:84:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:97:0x0123 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:98:0x0125  */
    /* JADX INFO: renamed from: AlertDialogContent-WMdw5o4, reason: not valid java name */
    public static final void m2231AlertDialogContentWMdw5o4(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, Shape shape, long j, long j2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        final Function2<? super Composer, ? super Integer, Unit> function5;
        int i5;
        int i6;
        final Function2<? super Composer, ? super Integer, Unit> function6;
        int i7;
        Shape medium;
        long jM2346getSurface0d7_KjU;
        long jM2360contentColorForek8zF_U;
        int i8;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function7;
        final Function2<? super Composer, ? super Integer, Unit> function8;
        final Shape shape2;
        final long j3;
        final long j4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i9;
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(1945098332);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AlertDialogContent)N(buttons,modifier,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color)207@8749L1016,202@8612L1153:AlertDialog.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i11 = i2 & 2;
        if (i11 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    function5 = function3;
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 3072) == 0) {
                        function6 = function4;
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    if ((i & 24576) == 0) {
                        if ((i2 & 16) == 0) {
                            medium = shape;
                            int i12 = composerStartRestartGroup.changed(medium) ? 16384 : 8192;
                            i3 |= i12;
                        } else {
                            medium = shape;
                        }
                        i3 |= i12;
                    } else {
                        medium = shape;
                    }
                    if ((196608 & i) == 0) {
                        if ((i2 & 32) == 0) {
                            jM2346getSurface0d7_KjU = j;
                            int i13 = composerStartRestartGroup.changed(jM2346getSurface0d7_KjU) ? 131072 : 65536;
                            i3 |= i13;
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        i3 |= i13;
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    if ((i & 1572864) == 0) {
                        if ((i2 & 64) == 0) {
                            jM2360contentColorForek8zF_U = j2;
                            int i14 = composerStartRestartGroup.changed(jM2360contentColorForek8zF_U) ? 1048576 : 524288;
                            i3 |= i14;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        i3 |= i14;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    i8 = i3;
                    if ((i3 & 599187) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i8 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "198@8470L6,199@8528L6,200@8570L32");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if ((i2 & 16) != 0) {
                                i9 = i8 & (-57345);
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            } else {
                                i9 = i8;
                            }
                            if ((i2 & 32) != 0) {
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                i8 = i9 & (-458753);
                            } else {
                                i8 = i9;
                            }
                            if ((i2 & 64) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 15) & 14);
                                i8 &= -3670017;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 16) != 0) {
                                i8 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                i8 &= -458753;
                            }
                            if ((i2 & 64) != 0) {
                                i8 &= -3670017;
                            }
                        }
                        i10 = i8;
                        long j5 = jM2360contentColorForek8zF_U;
                        long j6 = jM2346getSurface0d7_KjU;
                        Shape shape3 = medium;
                        Modifier modifier4 = modifier2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1945098332, i10, -1, "androidx.compose.material.AlertDialogContent (AlertDialog.kt:201)");
                        }
                        int i15 = ((i10 >> 3) & 14) | 1572864;
                        int i16 = i10 >> 9;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m2584SurfaceFjzlyU(modifier4, shape3, j6, j5, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(802957984, true, new Function2() { // from class: androidx.compose.material.AlertDialogKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AlertDialogKt.AlertDialogContent_WMdw5o4$lambda$0(function5, function6, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, i15 | (i16 & 112) | (i16 & 896) | (i16 & 7168), 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function7 = function5;
                        function8 = function6;
                        modifier3 = modifier4;
                        shape2 = shape3;
                        j3 = j6;
                        j4 = j5;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        shape2 = medium;
                        j3 = jM2346getSurface0d7_KjU;
                        j4 = jM2360contentColorForek8zF_U;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AlertDialogKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AlertDialogKt.AlertDialogContent_WMdw5o4$lambda$1(function2, modifier3, function7, function8, shape2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 3072;
                function6 = function4;
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        medium = shape;
                        if (composerStartRestartGroup.changed(medium)) {
                        }
                        i3 |= i12;
                    } else {
                        medium = shape;
                    }
                    i3 |= i12;
                } else {
                    medium = shape;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        jM2346getSurface0d7_KjU = j;
                        if (composerStartRestartGroup.changed(jM2346getSurface0d7_KjU)) {
                        }
                        i3 |= i13;
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    i3 |= i13;
                } else {
                    jM2346getSurface0d7_KjU = j;
                }
                if ((i & 1572864) == 0) {
                    if ((i2 & 64) == 0) {
                        jM2360contentColorForek8zF_U = j2;
                        if (composerStartRestartGroup.changed(jM2360contentColorForek8zF_U)) {
                        }
                        i3 |= i14;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    i3 |= i14;
                } else {
                    jM2360contentColorForek8zF_U = j2;
                }
                i8 = i3;
                if ((i3 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i8 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "198@8470L6,199@8528L6,200@8570L32");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i8 & (-57345);
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        } else {
                            i9 = i8;
                        }
                        if ((i2 & 32) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i8 = i9 & (-458753);
                        } else {
                            i8 = i9;
                        }
                        if ((i2 & 64) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 15) & 14);
                            i8 &= -3670017;
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i8 & (-57345);
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        } else {
                            i9 = i8;
                        }
                        if ((i2 & 32) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i8 = i9 & (-458753);
                        } else {
                            i8 = i9;
                        }
                        if ((i2 & 64) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 15) & 14);
                            i8 &= -3670017;
                        }
                    }
                    i10 = i8;
                    long j7 = jM2360contentColorForek8zF_U;
                    long j8 = jM2346getSurface0d7_KjU;
                    Shape shape4 = medium;
                    Modifier modifier5 = modifier2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1945098332, i10, -1, "androidx.compose.material.AlertDialogContent (AlertDialog.kt:201)");
                    }
                    int i17 = ((i10 >> 3) & 14) | 1572864;
                    int i18 = i10 >> 9;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m2584SurfaceFjzlyU(modifier5, shape4, j8, j7, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(802957984, true, new Function2() { // from class: androidx.compose.material.AlertDialogKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AlertDialogKt.AlertDialogContent_WMdw5o4$lambda$0(function5, function6, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, i17 | (i18 & 112) | (i18 & 896) | (i18 & 7168), 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function7 = function5;
                    function8 = function6;
                    modifier3 = modifier5;
                    shape2 = shape4;
                    j3 = j8;
                    j4 = j7;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    function7 = function5;
                    function8 = function6;
                    shape2 = medium;
                    j3 = jM2346getSurface0d7_KjU;
                    j4 = jM2360contentColorForek8zF_U;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AlertDialogKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AlertDialogKt.AlertDialogContent_WMdw5o4$lambda$1(function2, modifier3, function7, function8, shape2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            function5 = function3;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    function6 = function4;
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        medium = shape;
                        if (composerStartRestartGroup.changed(medium)) {
                        }
                        i3 |= i12;
                    } else {
                        medium = shape;
                    }
                    i3 |= i12;
                } else {
                    medium = shape;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        jM2346getSurface0d7_KjU = j;
                        if (composerStartRestartGroup.changed(jM2346getSurface0d7_KjU)) {
                        }
                        i3 |= i13;
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    i3 |= i13;
                } else {
                    jM2346getSurface0d7_KjU = j;
                }
                if ((i & 1572864) == 0) {
                    if ((i2 & 64) == 0) {
                        jM2360contentColorForek8zF_U = j2;
                        if (composerStartRestartGroup.changed(jM2360contentColorForek8zF_U)) {
                        }
                        i3 |= i14;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    i3 |= i14;
                } else {
                    jM2360contentColorForek8zF_U = j2;
                }
                i8 = i3;
                if ((i3 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i8 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "198@8470L6,199@8528L6,200@8570L32");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i8 & (-57345);
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        } else {
                            i9 = i8;
                        }
                        if ((i2 & 32) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i8 = i9 & (-458753);
                        } else {
                            i8 = i9;
                        }
                        if ((i2 & 64) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 15) & 14);
                            i8 &= -3670017;
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i8 & (-57345);
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        } else {
                            i9 = i8;
                        }
                        if ((i2 & 32) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i8 = i9 & (-458753);
                        } else {
                            i8 = i9;
                        }
                        if ((i2 & 64) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 15) & 14);
                            i8 &= -3670017;
                        }
                    }
                    i10 = i8;
                    long j9 = jM2360contentColorForek8zF_U;
                    long j10 = jM2346getSurface0d7_KjU;
                    Shape shape5 = medium;
                    Modifier modifier6 = modifier2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1945098332, i10, -1, "androidx.compose.material.AlertDialogContent (AlertDialog.kt:201)");
                    }
                    int i19 = ((i10 >> 3) & 14) | 1572864;
                    int i110 = i10 >> 9;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m2584SurfaceFjzlyU(modifier6, shape5, j10, j9, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(802957984, true, new Function2() { // from class: androidx.compose.material.AlertDialogKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AlertDialogKt.AlertDialogContent_WMdw5o4$lambda$0(function5, function6, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, i19 | (i110 & 112) | (i110 & 896) | (i110 & 7168), 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function7 = function5;
                    function8 = function6;
                    modifier3 = modifier6;
                    shape2 = shape5;
                    j3 = j10;
                    j4 = j9;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    function7 = function5;
                    function8 = function6;
                    shape2 = medium;
                    j3 = jM2346getSurface0d7_KjU;
                    j4 = jM2360contentColorForek8zF_U;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AlertDialogKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AlertDialogKt.AlertDialogContent_WMdw5o4$lambda$1(function2, modifier3, function7, function8, shape2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            function6 = function4;
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    medium = shape;
                    if (composerStartRestartGroup.changed(medium)) {
                    }
                    i3 |= i12;
                } else {
                    medium = shape;
                }
                i3 |= i12;
            } else {
                medium = shape;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    jM2346getSurface0d7_KjU = j;
                    if (composerStartRestartGroup.changed(jM2346getSurface0d7_KjU)) {
                    }
                    i3 |= i13;
                } else {
                    jM2346getSurface0d7_KjU = j;
                }
                i3 |= i13;
            } else {
                jM2346getSurface0d7_KjU = j;
            }
            if ((i & 1572864) == 0) {
                if ((i2 & 64) == 0) {
                    jM2360contentColorForek8zF_U = j2;
                    if (composerStartRestartGroup.changed(jM2360contentColorForek8zF_U)) {
                    }
                    i3 |= i14;
                } else {
                    jM2360contentColorForek8zF_U = j2;
                }
                i3 |= i14;
            } else {
                jM2360contentColorForek8zF_U = j2;
            }
            i8 = i3;
            if ((i3 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i8 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "198@8470L6,199@8528L6,200@8570L32");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = null;
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i8 & (-57345);
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    } else {
                        i9 = i8;
                    }
                    if ((i2 & 32) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i8 = i9 & (-458753);
                    } else {
                        i8 = i9;
                    }
                    if ((i2 & 64) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 15) & 14);
                        i8 &= -3670017;
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = null;
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i8 & (-57345);
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    } else {
                        i9 = i8;
                    }
                    if ((i2 & 32) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i8 = i9 & (-458753);
                    } else {
                        i8 = i9;
                    }
                    if ((i2 & 64) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 15) & 14);
                        i8 &= -3670017;
                    }
                }
                i10 = i8;
                long j11 = jM2360contentColorForek8zF_U;
                long j12 = jM2346getSurface0d7_KjU;
                Shape shape6 = medium;
                Modifier modifier7 = modifier2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1945098332, i10, -1, "androidx.compose.material.AlertDialogContent (AlertDialog.kt:201)");
                }
                int i111 = ((i10 >> 3) & 14) | 1572864;
                int i112 = i10 >> 9;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m2584SurfaceFjzlyU(modifier7, shape6, j12, j11, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(802957984, true, new Function2() { // from class: androidx.compose.material.AlertDialogKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AlertDialogKt.AlertDialogContent_WMdw5o4$lambda$0(function5, function6, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, i111 | (i112 & 112) | (i112 & 896) | (i112 & 7168), 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function7 = function5;
                function8 = function6;
                modifier3 = modifier7;
                shape2 = shape6;
                j3 = j12;
                j4 = j11;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                function7 = function5;
                function8 = function6;
                shape2 = medium;
                j3 = jM2346getSurface0d7_KjU;
                j4 = jM2360contentColorForek8zF_U;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AlertDialogKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AlertDialogKt.AlertDialogContent_WMdw5o4$lambda$1(function2, modifier3, function7, function8, shape2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                function5 = function3;
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    function6 = function4;
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        medium = shape;
                        if (composerStartRestartGroup.changed(medium)) {
                        }
                        i3 |= i12;
                    } else {
                        medium = shape;
                    }
                    i3 |= i12;
                } else {
                    medium = shape;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        jM2346getSurface0d7_KjU = j;
                        if (composerStartRestartGroup.changed(jM2346getSurface0d7_KjU)) {
                        }
                        i3 |= i13;
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    i3 |= i13;
                } else {
                    jM2346getSurface0d7_KjU = j;
                }
                if ((i & 1572864) == 0) {
                    if ((i2 & 64) == 0) {
                        jM2360contentColorForek8zF_U = j2;
                        if (composerStartRestartGroup.changed(jM2360contentColorForek8zF_U)) {
                        }
                        i3 |= i14;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    i3 |= i14;
                } else {
                    jM2360contentColorForek8zF_U = j2;
                }
                i8 = i3;
                if ((i3 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i8 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "198@8470L6,199@8528L6,200@8570L32");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i8 & (-57345);
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        } else {
                            i9 = i8;
                        }
                        if ((i2 & 32) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i8 = i9 & (-458753);
                        } else {
                            i8 = i9;
                        }
                        if ((i2 & 64) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 15) & 14);
                            i8 &= -3670017;
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i8 & (-57345);
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        } else {
                            i9 = i8;
                        }
                        if ((i2 & 32) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i8 = i9 & (-458753);
                        } else {
                            i8 = i9;
                        }
                        if ((i2 & 64) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 15) & 14);
                            i8 &= -3670017;
                        }
                    }
                    i10 = i8;
                    long j13 = jM2360contentColorForek8zF_U;
                    long j14 = jM2346getSurface0d7_KjU;
                    Shape shape7 = medium;
                    Modifier modifier8 = modifier2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1945098332, i10, -1, "androidx.compose.material.AlertDialogContent (AlertDialog.kt:201)");
                    }
                    int i113 = ((i10 >> 3) & 14) | 1572864;
                    int i114 = i10 >> 9;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m2584SurfaceFjzlyU(modifier8, shape7, j14, j13, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(802957984, true, new Function2() { // from class: androidx.compose.material.AlertDialogKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AlertDialogKt.AlertDialogContent_WMdw5o4$lambda$0(function5, function6, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, i113 | (i114 & 112) | (i114 & 896) | (i114 & 7168), 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function7 = function5;
                    function8 = function6;
                    modifier3 = modifier8;
                    shape2 = shape7;
                    j3 = j14;
                    j4 = j13;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    function7 = function5;
                    function8 = function6;
                    shape2 = medium;
                    j3 = jM2346getSurface0d7_KjU;
                    j4 = jM2360contentColorForek8zF_U;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AlertDialogKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AlertDialogKt.AlertDialogContent_WMdw5o4$lambda$1(function2, modifier3, function7, function8, shape2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            function6 = function4;
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    medium = shape;
                    if (composerStartRestartGroup.changed(medium)) {
                    }
                    i3 |= i12;
                } else {
                    medium = shape;
                }
                i3 |= i12;
            } else {
                medium = shape;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    jM2346getSurface0d7_KjU = j;
                    if (composerStartRestartGroup.changed(jM2346getSurface0d7_KjU)) {
                    }
                    i3 |= i13;
                } else {
                    jM2346getSurface0d7_KjU = j;
                }
                i3 |= i13;
            } else {
                jM2346getSurface0d7_KjU = j;
            }
            if ((i & 1572864) == 0) {
                if ((i2 & 64) == 0) {
                    jM2360contentColorForek8zF_U = j2;
                    if (composerStartRestartGroup.changed(jM2360contentColorForek8zF_U)) {
                    }
                    i3 |= i14;
                } else {
                    jM2360contentColorForek8zF_U = j2;
                }
                i3 |= i14;
            } else {
                jM2360contentColorForek8zF_U = j2;
            }
            i8 = i3;
            if ((i3 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i8 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "198@8470L6,199@8528L6,200@8570L32");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = null;
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i8 & (-57345);
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    } else {
                        i9 = i8;
                    }
                    if ((i2 & 32) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i8 = i9 & (-458753);
                    } else {
                        i8 = i9;
                    }
                    if ((i2 & 64) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 15) & 14);
                        i8 &= -3670017;
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = null;
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i8 & (-57345);
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    } else {
                        i9 = i8;
                    }
                    if ((i2 & 32) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i8 = i9 & (-458753);
                    } else {
                        i8 = i9;
                    }
                    if ((i2 & 64) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 15) & 14);
                        i8 &= -3670017;
                    }
                }
                i10 = i8;
                long j15 = jM2360contentColorForek8zF_U;
                long j16 = jM2346getSurface0d7_KjU;
                Shape shape8 = medium;
                Modifier modifier9 = modifier2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1945098332, i10, -1, "androidx.compose.material.AlertDialogContent (AlertDialog.kt:201)");
                }
                int i115 = ((i10 >> 3) & 14) | 1572864;
                int i116 = i10 >> 9;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m2584SurfaceFjzlyU(modifier9, shape8, j16, j15, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(802957984, true, new Function2() { // from class: androidx.compose.material.AlertDialogKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AlertDialogKt.AlertDialogContent_WMdw5o4$lambda$0(function5, function6, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, i115 | (i116 & 112) | (i116 & 896) | (i116 & 7168), 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function7 = function5;
                function8 = function6;
                modifier3 = modifier9;
                shape2 = shape8;
                j3 = j16;
                j4 = j15;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                function7 = function5;
                function8 = function6;
                shape2 = medium;
                j3 = jM2346getSurface0d7_KjU;
                j4 = jM2360contentColorForek8zF_U;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AlertDialogKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AlertDialogKt.AlertDialogContent_WMdw5o4$lambda$1(function2, modifier3, function7, function8, shape2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        function5 = function3;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 3072) == 0) {
                function6 = function4;
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    medium = shape;
                    if (composerStartRestartGroup.changed(medium)) {
                    }
                    i3 |= i12;
                } else {
                    medium = shape;
                }
                i3 |= i12;
            } else {
                medium = shape;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    jM2346getSurface0d7_KjU = j;
                    if (composerStartRestartGroup.changed(jM2346getSurface0d7_KjU)) {
                    }
                    i3 |= i13;
                } else {
                    jM2346getSurface0d7_KjU = j;
                }
                i3 |= i13;
            } else {
                jM2346getSurface0d7_KjU = j;
            }
            if ((i & 1572864) == 0) {
                if ((i2 & 64) == 0) {
                    jM2360contentColorForek8zF_U = j2;
                    if (composerStartRestartGroup.changed(jM2360contentColorForek8zF_U)) {
                    }
                    i3 |= i14;
                } else {
                    jM2360contentColorForek8zF_U = j2;
                }
                i3 |= i14;
            } else {
                jM2360contentColorForek8zF_U = j2;
            }
            i8 = i3;
            if ((i3 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i8 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "198@8470L6,199@8528L6,200@8570L32");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = null;
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i8 & (-57345);
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    } else {
                        i9 = i8;
                    }
                    if ((i2 & 32) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i8 = i9 & (-458753);
                    } else {
                        i8 = i9;
                    }
                    if ((i2 & 64) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 15) & 14);
                        i8 &= -3670017;
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = null;
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i8 & (-57345);
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    } else {
                        i9 = i8;
                    }
                    if ((i2 & 32) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i8 = i9 & (-458753);
                    } else {
                        i8 = i9;
                    }
                    if ((i2 & 64) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 15) & 14);
                        i8 &= -3670017;
                    }
                }
                i10 = i8;
                long j17 = jM2360contentColorForek8zF_U;
                long j18 = jM2346getSurface0d7_KjU;
                Shape shape9 = medium;
                Modifier modifier10 = modifier2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1945098332, i10, -1, "androidx.compose.material.AlertDialogContent (AlertDialog.kt:201)");
                }
                int i117 = ((i10 >> 3) & 14) | 1572864;
                int i118 = i10 >> 9;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m2584SurfaceFjzlyU(modifier10, shape9, j18, j17, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(802957984, true, new Function2() { // from class: androidx.compose.material.AlertDialogKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AlertDialogKt.AlertDialogContent_WMdw5o4$lambda$0(function5, function6, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, i117 | (i118 & 112) | (i118 & 896) | (i118 & 7168), 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function7 = function5;
                function8 = function6;
                modifier3 = modifier10;
                shape2 = shape9;
                j3 = j18;
                j4 = j17;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                function7 = function5;
                function8 = function6;
                shape2 = medium;
                j3 = jM2346getSurface0d7_KjU;
                j4 = jM2360contentColorForek8zF_U;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AlertDialogKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AlertDialogKt.AlertDialogContent_WMdw5o4$lambda$1(function2, modifier3, function7, function8, shape2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        function6 = function4;
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                medium = shape;
                if (composerStartRestartGroup.changed(medium)) {
                }
                i3 |= i12;
            } else {
                medium = shape;
            }
            i3 |= i12;
        } else {
            medium = shape;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                jM2346getSurface0d7_KjU = j;
                if (composerStartRestartGroup.changed(jM2346getSurface0d7_KjU)) {
                }
                i3 |= i13;
            } else {
                jM2346getSurface0d7_KjU = j;
            }
            i3 |= i13;
        } else {
            jM2346getSurface0d7_KjU = j;
        }
        if ((i & 1572864) == 0) {
            if ((i2 & 64) == 0) {
                jM2360contentColorForek8zF_U = j2;
                if (composerStartRestartGroup.changed(jM2360contentColorForek8zF_U)) {
                }
                i3 |= i14;
            } else {
                jM2360contentColorForek8zF_U = j2;
            }
            i3 |= i14;
        } else {
            jM2360contentColorForek8zF_U = j2;
        }
        i8 = i3;
        if ((i3 & 599187) != 599186) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i8 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "198@8470L6,199@8528L6,200@8570L32");
            if ((i & 1) != 0) {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    function5 = null;
                }
                if (i6 != 0) {
                    function6 = null;
                }
                if ((i2 & 16) != 0) {
                    i9 = i8 & (-57345);
                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                } else {
                    i9 = i8;
                }
                if ((i2 & 32) != 0) {
                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                    i8 = i9 & (-458753);
                } else {
                    i8 = i9;
                }
                if ((i2 & 64) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 15) & 14);
                    i8 &= -3670017;
                }
            } else {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    function5 = null;
                }
                if (i6 != 0) {
                    function6 = null;
                }
                if ((i2 & 16) != 0) {
                    i9 = i8 & (-57345);
                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                } else {
                    i9 = i8;
                }
                if ((i2 & 32) != 0) {
                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                    i8 = i9 & (-458753);
                } else {
                    i8 = i9;
                }
                if ((i2 & 64) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i8 >> 15) & 14);
                    i8 &= -3670017;
                }
            }
            i10 = i8;
            long j19 = jM2360contentColorForek8zF_U;
            long j110 = jM2346getSurface0d7_KjU;
            Shape shape10 = medium;
            Modifier modifier11 = modifier2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1945098332, i10, -1, "androidx.compose.material.AlertDialogContent (AlertDialog.kt:201)");
            }
            int i119 = ((i10 >> 3) & 14) | 1572864;
            int i1110 = i10 >> 9;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m2584SurfaceFjzlyU(modifier11, shape10, j110, j19, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(802957984, true, new Function2() { // from class: androidx.compose.material.AlertDialogKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AlertDialogKt.AlertDialogContent_WMdw5o4$lambda$0(function5, function6, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, i119 | (i1110 & 112) | (i1110 & 896) | (i1110 & 7168), 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function7 = function5;
            function8 = function6;
            modifier3 = modifier11;
            shape2 = shape10;
            j3 = j110;
            j4 = j19;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            function7 = function5;
            function8 = function6;
            shape2 = medium;
            j3 = jM2346getSurface0d7_KjU;
            j4 = jM2360contentColorForek8zF_U;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AlertDialogKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AlertDialogKt.AlertDialogContent_WMdw5o4$lambda$1(function2, modifier3, function7, function8, shape2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AlertDialogContent_WMdw5o4$lambda$0(final Function2 function2, final Function2 function3, Function2 function4, Composer composer, int i) {
        ComposableLambda composableLambdaRememberComposableLambda;
        ComposerKt.sourceInformation(composer, "C208@8759L1000:AlertDialog.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(802957984, i, -1, "androidx.compose.material.AlertDialogContent.<anonymous> (AlertDialog.kt:208)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -98027836, "C209@8780L947,231@9740L9:AlertDialog.kt#jmzs0o");
            ComposableLambda composableLambdaRememberComposableLambda2 = null;
            if (function2 == null) {
                composer.startReplaceGroup(-97968969);
                composer.endReplaceGroup();
                composableLambdaRememberComposableLambda = null;
            } else {
                composer.startReplaceGroup(-97968968);
                ComposerKt.sourceInformation(composer, "*212@8900L308");
                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1737550099, true, new Function2() { // from class: androidx.compose.material.AlertDialogKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AlertDialogKt.AlertDialogContent_WMdw5o4$lambda$0$0$0$0(function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer, 54);
                composer.endReplaceGroup();
            }
            if (function3 == null) {
                composer.startReplaceGroup(-97547524);
            } else {
                composer.startReplaceGroup(-97547523);
                ComposerKt.sourceInformation(composer, "*221@9323L367");
                composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1265552690, true, new Function2() { // from class: androidx.compose.material.AlertDialogKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AlertDialogKt.AlertDialogContent_WMdw5o4$lambda$0$0$1$0(function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer, 54);
            }
            composer.endReplaceGroup();
            AlertDialogBaselineLayout(columnScopeInstance, composableLambdaRememberComposableLambda, composableLambdaRememberComposableLambda2, composer, 6);
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
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AlertDialogContent_WMdw5o4$lambda$0$0$0$0(final Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C213@8995L4,213@9001L181,213@8930L252:AlertDialog.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1737550099, i, -1, "androidx.compose.material.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:213)");
            }
            CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer, 6))), ComposableLambdaKt.rememberComposableLambda(-1654653485, true, new Function2() { // from class: androidx.compose.material.AlertDialogKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AlertDialogKt.AlertDialogContent_WMdw5o4$lambda$0$0$0$0$0(function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AlertDialogContent_WMdw5o4$lambda$0$0$0$0$0(Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C214@9065L10,215@9118L34:AlertDialog.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1654653485, i, -1, "androidx.compose.material.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:214)");
            }
            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer, 6).getSubtitle1(), function2, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AlertDialogContent_WMdw5o4$lambda$0$0$1$0(final Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C223@9451L6,224@9488L176,222@9353L311:AlertDialog.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1265552690, i, -1, "androidx.compose.material.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:222)");
            }
            CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer, 6))), ComposableLambdaKt.rememberComposableLambda(-2126650894, true, new Function2() { // from class: androidx.compose.material.AlertDialogKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AlertDialogKt.AlertDialogContent_WMdw5o4$lambda$0$0$1$0$0(function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AlertDialogContent_WMdw5o4$lambda$0$0$1$0$0(Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C225@9552L10,226@9601L33:AlertDialog.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2126650894, i, -1, "androidx.compose.material.AlertDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:225)");
            }
            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer, 6).getBody2(), function2, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void AlertDialogBaselineLayout(final ColumnScope columnScope, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composerStartRestartGroup = composer.startRestartGroup(1213983107);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AlertDialogBaselineLayout)N(title,text)258@10578L3363,248@10242L3699:AlertDialog.kt#jmzs0o");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(columnScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1213983107, i2, -1, "androidx.compose.material.AlertDialogBaselineLayout (AlertDialog.kt:247)");
            }
            Modifier modifierWeight = columnScope.weight(Modifier.INSTANCE, 1.0f, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1593320538, "CC(remember):AlertDialog.kt#9igjgp");
            AlertDialogKt$AlertDialogBaselineLayout$2$1 alertDialogKt$AlertDialogBaselineLayout$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (alertDialogKt$AlertDialogBaselineLayout$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                alertDialogKt$AlertDialogBaselineLayout$2$1RememberedValue = AlertDialogKt$AlertDialogBaselineLayout$2$1.INSTANCE;
                composerStartRestartGroup.updateRememberedValue(alertDialogKt$AlertDialogBaselineLayout$2$1RememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) alertDialogKt$AlertDialogBaselineLayout$2$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1809234843, "C:AlertDialog.kt#jmzs0o");
            if (function2 == null) {
                composerStartRestartGroup.startReplaceGroup(1809237538);
                composerStartRestartGroup.endReplaceGroup();
                z = false;
            } else {
                composerStartRestartGroup.startReplaceGroup(1809237539);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*251@10310L70");
                Modifier modifierAlign = columnScope.align(LayoutIdKt.layoutId(TitlePadding, "title"), Alignment.INSTANCE.getStart());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAlign);
                z = false;
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1262627484, "C251@10371L7:AlertDialog.kt#jmzs0o");
                function2.invoke(composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (function3 == null) {
                composerStartRestartGroup.startReplaceGroup(1809370342);
            } else {
                composerStartRestartGroup.startReplaceGroup(1809370343);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*254@10443L67");
                Modifier modifierAlign2 = columnScope.align(LayoutIdKt.layoutId(TextPadding, "text"), Alignment.INSTANCE.getStart());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                boolean z2 = z;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), z2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, z2 ? 1 : 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAlign2);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2120720012, "C254@10502L6:AlertDialog.kt#jmzs0o");
                function3.invoke(composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AlertDialogKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AlertDialogKt.AlertDialogBaselineLayout$lambda$2(columnScope, function2, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: AlertDialogFlowRow-ixp7dh8, reason: not valid java name */
    public static final void m2232AlertDialogFlowRowixp7dh8(final float f, final float f2, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1271829505);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AlertDialogFlowRow)N(mainAxisSpacing:c#ui.unit.Dp,crossAxisSpacing:c#ui.unit.Dp,content)350@14216L3557,350@14200L3573:AlertDialog.kt#jmzs0o");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(f2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1271829505, i2, -1, "androidx.compose.material.AlertDialogFlowRow (AlertDialog.kt:349)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1837517146, "CC(remember):AlertDialog.kt#9igjgp");
            boolean z = ((i2 & 14) == 4) | ((i2 & 112) == 32);
            AlertDialogKt$AlertDialogFlowRow$1$1 alertDialogKt$AlertDialogFlowRow$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || alertDialogKt$AlertDialogFlowRow$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                alertDialogKt$AlertDialogFlowRow$1$1RememberedValue = new AlertDialogKt$AlertDialogFlowRow$1$1(f, f2);
                composerStartRestartGroup.updateRememberedValue(alertDialogKt$AlertDialogFlowRow$1$1RememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) alertDialogKt$AlertDialogFlowRow$1$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i3 = (i2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            Modifier.Companion companion = Modifier.INSTANCE;
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i4 = ((i3 << 6) & 896) | 6;
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
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 6) & 14));
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AlertDialogKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AlertDialogKt.AlertDialogFlowRow_ixp7dh8$lambda$1(f, f2, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static {
        float f = 24;
        TitlePadding = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(f), 0.0f, Dp.m9687constructorimpl(f), 0.0f, 10, null);
        TextPadding = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(f), 0.0f, Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(28), 2, null);
    }
}
