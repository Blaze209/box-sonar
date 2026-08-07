package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.material3.tokens.DialogTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.DialogProperties;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: DatePickerDialog.android.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0097\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0014H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\"\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0019\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a\"\u0010\u0010\u001b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a¨\u0006\u001c"}, d2 = {"DatePickerDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "dismissButton", "shape", "Landroidx/compose/ui/graphics/Shape;", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "colors", "Landroidx/compose/material3/DatePickerColors;", "properties", "Landroidx/compose/ui/window/DialogProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "DatePickerDialog-GmEhDVc", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;FLandroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DialogButtonsPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "DialogButtonsMainAxisSpacing", "F", "DialogButtonsCrossAxisSpacing", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DatePickerDialog_androidKt {
    private static final float DialogButtonsCrossAxisSpacing;
    private static final float DialogButtonsMainAxisSpacing;
    private static final PaddingValues DialogButtonsPadding;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DatePickerDialog_GmEhDVc$lambda$1(Function0 function0, Function2 function2, Modifier modifier, Function2 function3, Shape shape, float f, DatePickerColors datePickerColors, DialogProperties dialogProperties, Function3 function4, int i, int i2, Composer composer, int i3) {
        m3156DatePickerDialogGmEhDVc(function0, function2, modifier, function3, shape, f, datePickerColors, dialogProperties, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:108:0x013d A[PHI: r0 r6 r8 r9 r13 r14
      0x013d: PHI (r0v28 int) = (r0v15 int), (r0v33 int), (r0v34 int) binds: [B:124:0x017b, B:106:0x0139, B:107:0x013b] A[DONT_GENERATE, DONT_INLINE]
      0x013d: PHI (r6v15 androidx.compose.ui.Modifier) = (r6v5 androidx.compose.ui.Modifier), (r6v2 androidx.compose.ui.Modifier), (r6v2 androidx.compose.ui.Modifier) binds: [B:124:0x017b, B:106:0x0139, B:107:0x013b] A[DONT_GENERATE, DONT_INLINE]
      0x013d: PHI (r8v9 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) = 
      (r8v5 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
      (r8v2 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
      (r8v2 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
     binds: [B:124:0x017b, B:106:0x0139, B:107:0x013b] A[DONT_GENERATE, DONT_INLINE]
      0x013d: PHI (r9v11 androidx.compose.ui.graphics.Shape) = 
      (r9v8 androidx.compose.ui.graphics.Shape)
      (r9v6 androidx.compose.ui.graphics.Shape)
      (r9v6 androidx.compose.ui.graphics.Shape)
     binds: [B:124:0x017b, B:106:0x0139, B:107:0x013b] A[DONT_GENERATE, DONT_INLINE]
      0x013d: PHI (r13v7 float) = (r13v4 float), (r13v3 float), (r13v3 float) binds: [B:124:0x017b, B:106:0x0139, B:107:0x013b] A[DONT_GENERATE, DONT_INLINE]
      0x013d: PHI (r14v12 androidx.compose.material3.DatePickerColors) = 
      (r14v9 androidx.compose.material3.DatePickerColors)
      (r14v7 androidx.compose.material3.DatePickerColors)
      (r14v7 androidx.compose.material3.DatePickerColors)
     binds: [B:124:0x017b, B:106:0x0139, B:107:0x013b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:110:0x0147 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:111:0x0149  */
    /* JADX WARN: Code duplicated, block: B:113:0x0150  */
    /* JADX WARN: Code duplicated, block: B:116:0x0156  */
    /* JADX WARN: Code duplicated, block: B:117:0x0160  */
    /* JADX WARN: Code duplicated, block: B:119:0x0164  */
    /* JADX WARN: Code duplicated, block: B:122:0x016f  */
    /* JADX WARN: Code duplicated, block: B:123:0x017a  */
    /* JADX WARN: Code duplicated, block: B:125:0x017d  */
    /* JADX WARN: Code duplicated, block: B:128:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:131:0x01df  */
    /* JADX WARN: Code duplicated, block: B:133:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:136:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:138:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x005b  */
    /* JADX WARN: Code duplicated, block: B:32:0x005e  */
    /* JADX WARN: Code duplicated, block: B:34:0x0062  */
    /* JADX WARN: Code duplicated, block: B:36:0x006a  */
    /* JADX WARN: Code duplicated, block: B:37:0x006d  */
    /* JADX WARN: Code duplicated, block: B:42:0x0077  */
    /* JADX WARN: Code duplicated, block: B:44:0x007b  */
    /* JADX WARN: Code duplicated, block: B:46:0x0083  */
    /* JADX WARN: Code duplicated, block: B:47:0x0086  */
    /* JADX WARN: Code duplicated, block: B:50:0x008c  */
    /* JADX WARN: Code duplicated, block: B:53:0x0094  */
    /* JADX WARN: Code duplicated, block: B:54:0x0096  */
    /* JADX WARN: Code duplicated, block: B:56:0x0099  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:64:0x00af  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:69:0x00be  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:75:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:80:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:92:0x0106  */
    /* JADX WARN: Code duplicated, block: B:93:0x0108  */
    /* JADX WARN: Code duplicated, block: B:96:0x0111  */
    /* JADX WARN: Code duplicated, block: B:98:0x0124  */
    /* JADX INFO: renamed from: DatePickerDialog-GmEhDVc, reason: not valid java name */
    public static final void m3156DatePickerDialogGmEhDVc(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function3, Shape shape, float f, DatePickerColors datePickerColors, DialogProperties dialogProperties, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function5;
        int i5;
        Shape shape2;
        int i6;
        float fM3153getTonalElevationD9Ej5fM;
        int i7;
        final DatePickerColors datePickerColorsColors;
        int i8;
        int i9;
        int i10;
        boolean z;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function6;
        final Shape shape3;
        final float f2;
        final DialogProperties dialogProperties2;
        final DatePickerColors datePickerColors2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i11;
        int i12;
        DialogProperties dialogProperties3;
        final Function2<? super Composer, ? super Integer, Unit> function7;
        final float f3;
        int i13;
        Modifier modifier4;
        int i14;
        Composer composerStartRestartGroup = composer.startRestartGroup(219718641);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DatePickerDialog)N(onDismissRequest,confirmButton,modifier,dismissButton,shape,tonalElevation:c#ui.unit.Dp,colors,properties,content)80@3789L2032,76@3638L2183:DatePickerDialog.android.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
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
                    function5 = function3;
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        shape2 = shape;
                        int i16 = composerStartRestartGroup.changed(shape2) ? 16384 : 8192;
                        i3 |= i16;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i16;
                } else {
                    shape2 = shape;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    if ((196608 & i) == 0) {
                        fM3153getTonalElevationD9Ej5fM = f;
                        if (composerStartRestartGroup.changed(fM3153getTonalElevationD9Ej5fM)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                    if ((1572864 & i) == 0) {
                        if ((i2 & 64) == 0) {
                            datePickerColorsColors = datePickerColors;
                            int i17 = composerStartRestartGroup.changed(datePickerColorsColors) ? 1048576 : 524288;
                            i3 |= i17;
                        } else {
                            datePickerColorsColors = datePickerColors;
                        }
                        i3 |= i17;
                    } else {
                        datePickerColorsColors = datePickerColors;
                    }
                    i8 = i2 & 128;
                    if (i8 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(dialogProperties)) {
                            i9 = 8388608;
                        } else {
                            i9 = 4194304;
                        }
                        i3 |= i9;
                    }
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i14 = 67108864;
                        } else {
                            i14 = 33554432;
                        }
                        i3 |= i14;
                    }
                    i10 = i3;
                    if ((i3 & 38347923) != 38347922) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i10 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "56@2765L5,57@2882L8");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if ((i2 & 16) != 0) {
                                i11 = i10 & (-57345);
                                shape2 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            } else {
                                i11 = i10;
                            }
                            if (i6 != 0) {
                                fM3153getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m3153getTonalElevationD9Ej5fM();
                            }
                            if ((i2 & 64) != 0) {
                                datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i12 = i11 & (-3670017);
                            } else {
                                i12 = i11;
                            }
                            if (i8 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                                function7 = function5;
                                f3 = fM3153getTonalElevationD9Ej5fM;
                                i13 = i12;
                                modifier4 = modifier2;
                            }
                            final Shape shape4 = shape2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(219718641, i13, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:75)");
                            }
                            AlertDialogKt.BasicAlertDialog(function0, SizeKt.wrapContentHeight$default(modifier4, null, false, 3, null), dialogProperties3, ComposableLambdaKt.rememberComposableLambda(1108953335, true, new Function2() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return DatePickerDialog_androidKt.DatePickerDialog_GmEhDVc$lambda$0(shape4, datePickerColorsColors, f3, function4, function2, function7, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i13 & 14) | 3072 | ((i13 >> 15) & 896), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            dialogProperties2 = dialogProperties3;
                            f2 = f3;
                            function6 = function7;
                            modifier3 = modifier4;
                            shape3 = shape4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            i12 = (i2 & 16) != 0 ? i10 & (-57345) : i10;
                            if ((i2 & 64) != 0) {
                                i12 &= -3670017;
                            }
                        }
                        dialogProperties3 = dialogProperties;
                        i13 = i12;
                        modifier4 = modifier2;
                        function7 = function5;
                        f3 = fM3153getTonalElevationD9Ej5fM;
                        final Shape shape5 = shape2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(219718641, i13, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:75)");
                        }
                        AlertDialogKt.BasicAlertDialog(function0, SizeKt.wrapContentHeight$default(modifier4, null, false, 3, null), dialogProperties3, ComposableLambdaKt.rememberComposableLambda(1108953335, true, new Function2() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DatePickerDialog_androidKt.DatePickerDialog_GmEhDVc$lambda$0(shape5, datePickerColorsColors, f3, function4, function2, function7, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i13 & 14) | 3072 | ((i13 >> 15) & 896), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        dialogProperties2 = dialogProperties3;
                        f2 = f3;
                        function6 = function7;
                        modifier3 = modifier4;
                        shape3 = shape5;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        function6 = function5;
                        shape3 = shape2;
                        f2 = fM3153getTonalElevationD9Ej5fM;
                        dialogProperties2 = dialogProperties;
                    }
                    datePickerColors2 = datePickerColorsColors;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DatePickerDialog_androidKt.DatePickerDialog_GmEhDVc$lambda$1(function0, function2, modifier3, function6, shape3, f2, datePickerColors2, dialogProperties2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                fM3153getTonalElevationD9Ej5fM = f;
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        datePickerColorsColors = datePickerColors;
                        if (composerStartRestartGroup.changed(datePickerColorsColors)) {
                        }
                        i3 |= i17;
                    } else {
                        datePickerColorsColors = datePickerColors;
                    }
                    i3 |= i17;
                } else {
                    datePickerColorsColors = datePickerColors;
                }
                i8 = i2 & 128;
                if (i8 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(dialogProperties)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i14 = 67108864;
                    } else {
                        i14 = 33554432;
                    }
                    i3 |= i14;
                }
                i10 = i3;
                if ((i3 & 38347923) != 38347922) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i10 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "56@2765L5,57@2882L8");
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i10 & (-57345);
                            shape2 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            i11 = i10;
                        }
                        if (i6 != 0) {
                            fM3153getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m3153getTonalElevationD9Ej5fM();
                        }
                        if ((i2 & 64) != 0) {
                            datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i12 = i11 & (-3670017);
                        } else {
                            i12 = i11;
                        }
                        if (i8 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                            function7 = function5;
                            f3 = fM3153getTonalElevationD9Ej5fM;
                            i13 = i12;
                            modifier4 = modifier2;
                        } else {
                            dialogProperties3 = dialogProperties;
                            i13 = i12;
                            modifier4 = modifier2;
                            function7 = function5;
                            f3 = fM3153getTonalElevationD9Ej5fM;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i10 & (-57345);
                            shape2 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            i11 = i10;
                        }
                        if (i6 != 0) {
                            fM3153getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m3153getTonalElevationD9Ej5fM();
                        }
                        if ((i2 & 64) != 0) {
                            datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i12 = i11 & (-3670017);
                        } else {
                            i12 = i11;
                        }
                        if (i8 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                            function7 = function5;
                            f3 = fM3153getTonalElevationD9Ej5fM;
                            i13 = i12;
                            modifier4 = modifier2;
                        } else {
                            dialogProperties3 = dialogProperties;
                            i13 = i12;
                            modifier4 = modifier2;
                            function7 = function5;
                            f3 = fM3153getTonalElevationD9Ej5fM;
                        }
                    }
                    final Shape shape6 = shape2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(219718641, i13, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:75)");
                    }
                    AlertDialogKt.BasicAlertDialog(function0, SizeKt.wrapContentHeight$default(modifier4, null, false, 3, null), dialogProperties3, ComposableLambdaKt.rememberComposableLambda(1108953335, true, new Function2() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DatePickerDialog_androidKt.DatePickerDialog_GmEhDVc$lambda$0(shape6, datePickerColorsColors, f3, function4, function2, function7, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i13 & 14) | 3072 | ((i13 >> 15) & 896), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    dialogProperties2 = dialogProperties3;
                    f2 = f3;
                    function6 = function7;
                    modifier3 = modifier4;
                    shape3 = shape6;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    function6 = function5;
                    shape3 = shape2;
                    f2 = fM3153getTonalElevationD9Ej5fM;
                    dialogProperties2 = dialogProperties;
                }
                datePickerColors2 = datePickerColorsColors;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DatePickerDialog_androidKt.DatePickerDialog_GmEhDVc$lambda$1(function0, function2, modifier3, function6, shape3, f2, datePickerColors2, dialogProperties2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            function5 = function3;
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i16;
                } else {
                    shape2 = shape;
                }
                i3 |= i16;
            } else {
                shape2 = shape;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    fM3153getTonalElevationD9Ej5fM = f;
                    if (composerStartRestartGroup.changed(fM3153getTonalElevationD9Ej5fM)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        datePickerColorsColors = datePickerColors;
                        if (composerStartRestartGroup.changed(datePickerColorsColors)) {
                        }
                        i3 |= i17;
                    } else {
                        datePickerColorsColors = datePickerColors;
                    }
                    i3 |= i17;
                } else {
                    datePickerColorsColors = datePickerColors;
                }
                i8 = i2 & 128;
                if (i8 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(dialogProperties)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i14 = 67108864;
                    } else {
                        i14 = 33554432;
                    }
                    i3 |= i14;
                }
                i10 = i3;
                if ((i3 & 38347923) != 38347922) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i10 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "56@2765L5,57@2882L8");
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i10 & (-57345);
                            shape2 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            i11 = i10;
                        }
                        if (i6 != 0) {
                            fM3153getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m3153getTonalElevationD9Ej5fM();
                        }
                        if ((i2 & 64) != 0) {
                            datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i12 = i11 & (-3670017);
                        } else {
                            i12 = i11;
                        }
                        if (i8 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                            function7 = function5;
                            f3 = fM3153getTonalElevationD9Ej5fM;
                            i13 = i12;
                            modifier4 = modifier2;
                        } else {
                            dialogProperties3 = dialogProperties;
                            i13 = i12;
                            modifier4 = modifier2;
                            function7 = function5;
                            f3 = fM3153getTonalElevationD9Ej5fM;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i10 & (-57345);
                            shape2 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            i11 = i10;
                        }
                        if (i6 != 0) {
                            fM3153getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m3153getTonalElevationD9Ej5fM();
                        }
                        if ((i2 & 64) != 0) {
                            datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i12 = i11 & (-3670017);
                        } else {
                            i12 = i11;
                        }
                        if (i8 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                            function7 = function5;
                            f3 = fM3153getTonalElevationD9Ej5fM;
                            i13 = i12;
                            modifier4 = modifier2;
                        } else {
                            dialogProperties3 = dialogProperties;
                            i13 = i12;
                            modifier4 = modifier2;
                            function7 = function5;
                            f3 = fM3153getTonalElevationD9Ej5fM;
                        }
                    }
                    final Shape shape7 = shape2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(219718641, i13, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:75)");
                    }
                    AlertDialogKt.BasicAlertDialog(function0, SizeKt.wrapContentHeight$default(modifier4, null, false, 3, null), dialogProperties3, ComposableLambdaKt.rememberComposableLambda(1108953335, true, new Function2() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DatePickerDialog_androidKt.DatePickerDialog_GmEhDVc$lambda$0(shape7, datePickerColorsColors, f3, function4, function2, function7, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i13 & 14) | 3072 | ((i13 >> 15) & 896), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    dialogProperties2 = dialogProperties3;
                    f2 = f3;
                    function6 = function7;
                    modifier3 = modifier4;
                    shape3 = shape7;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    function6 = function5;
                    shape3 = shape2;
                    f2 = fM3153getTonalElevationD9Ej5fM;
                    dialogProperties2 = dialogProperties;
                }
                datePickerColors2 = datePickerColorsColors;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DatePickerDialog_androidKt.DatePickerDialog_GmEhDVc$lambda$1(function0, function2, modifier3, function6, shape3, f2, datePickerColors2, dialogProperties2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            fM3153getTonalElevationD9Ej5fM = f;
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    datePickerColorsColors = datePickerColors;
                    if (composerStartRestartGroup.changed(datePickerColorsColors)) {
                    }
                    i3 |= i17;
                } else {
                    datePickerColorsColors = datePickerColors;
                }
                i3 |= i17;
            } else {
                datePickerColorsColors = datePickerColors;
            }
            i8 = i2 & 128;
            if (i8 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(dialogProperties)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i14 = 67108864;
                } else {
                    i14 = 33554432;
                }
                i3 |= i14;
            }
            i10 = i3;
            if ((i3 & 38347923) != 38347922) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i10 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "56@2765L5,57@2882L8");
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if ((i2 & 16) != 0) {
                        i11 = i10 & (-57345);
                        shape2 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    } else {
                        i11 = i10;
                    }
                    if (i6 != 0) {
                        fM3153getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m3153getTonalElevationD9Ej5fM();
                    }
                    if ((i2 & 64) != 0) {
                        datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i12 = i11 & (-3670017);
                    } else {
                        i12 = i11;
                    }
                    if (i8 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                        function7 = function5;
                        f3 = fM3153getTonalElevationD9Ej5fM;
                        i13 = i12;
                        modifier4 = modifier2;
                    } else {
                        dialogProperties3 = dialogProperties;
                        i13 = i12;
                        modifier4 = modifier2;
                        function7 = function5;
                        f3 = fM3153getTonalElevationD9Ej5fM;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if ((i2 & 16) != 0) {
                        i11 = i10 & (-57345);
                        shape2 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    } else {
                        i11 = i10;
                    }
                    if (i6 != 0) {
                        fM3153getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m3153getTonalElevationD9Ej5fM();
                    }
                    if ((i2 & 64) != 0) {
                        datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i12 = i11 & (-3670017);
                    } else {
                        i12 = i11;
                    }
                    if (i8 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                        function7 = function5;
                        f3 = fM3153getTonalElevationD9Ej5fM;
                        i13 = i12;
                        modifier4 = modifier2;
                    } else {
                        dialogProperties3 = dialogProperties;
                        i13 = i12;
                        modifier4 = modifier2;
                        function7 = function5;
                        f3 = fM3153getTonalElevationD9Ej5fM;
                    }
                }
                final Shape shape8 = shape2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(219718641, i13, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:75)");
                }
                AlertDialogKt.BasicAlertDialog(function0, SizeKt.wrapContentHeight$default(modifier4, null, false, 3, null), dialogProperties3, ComposableLambdaKt.rememberComposableLambda(1108953335, true, new Function2() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DatePickerDialog_androidKt.DatePickerDialog_GmEhDVc$lambda$0(shape8, datePickerColorsColors, f3, function4, function2, function7, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i13 & 14) | 3072 | ((i13 >> 15) & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                dialogProperties2 = dialogProperties3;
                f2 = f3;
                function6 = function7;
                modifier3 = modifier4;
                shape3 = shape8;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                function6 = function5;
                shape3 = shape2;
                f2 = fM3153getTonalElevationD9Ej5fM;
                dialogProperties2 = dialogProperties;
            }
            datePickerColors2 = datePickerColorsColors;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DatePickerDialog_androidKt.DatePickerDialog_GmEhDVc$lambda$1(function0, function2, modifier3, function6, shape3, f2, datePickerColors2, dialogProperties2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                function5 = function3;
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i16;
                } else {
                    shape2 = shape;
                }
                i3 |= i16;
            } else {
                shape2 = shape;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    fM3153getTonalElevationD9Ej5fM = f;
                    if (composerStartRestartGroup.changed(fM3153getTonalElevationD9Ej5fM)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        datePickerColorsColors = datePickerColors;
                        if (composerStartRestartGroup.changed(datePickerColorsColors)) {
                        }
                        i3 |= i17;
                    } else {
                        datePickerColorsColors = datePickerColors;
                    }
                    i3 |= i17;
                } else {
                    datePickerColorsColors = datePickerColors;
                }
                i8 = i2 & 128;
                if (i8 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(dialogProperties)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i14 = 67108864;
                    } else {
                        i14 = 33554432;
                    }
                    i3 |= i14;
                }
                i10 = i3;
                if ((i3 & 38347923) != 38347922) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i10 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "56@2765L5,57@2882L8");
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i10 & (-57345);
                            shape2 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            i11 = i10;
                        }
                        if (i6 != 0) {
                            fM3153getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m3153getTonalElevationD9Ej5fM();
                        }
                        if ((i2 & 64) != 0) {
                            datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i12 = i11 & (-3670017);
                        } else {
                            i12 = i11;
                        }
                        if (i8 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                            function7 = function5;
                            f3 = fM3153getTonalElevationD9Ej5fM;
                            i13 = i12;
                            modifier4 = modifier2;
                        } else {
                            dialogProperties3 = dialogProperties;
                            i13 = i12;
                            modifier4 = modifier2;
                            function7 = function5;
                            f3 = fM3153getTonalElevationD9Ej5fM;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if ((i2 & 16) != 0) {
                            i11 = i10 & (-57345);
                            shape2 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        } else {
                            i11 = i10;
                        }
                        if (i6 != 0) {
                            fM3153getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m3153getTonalElevationD9Ej5fM();
                        }
                        if ((i2 & 64) != 0) {
                            datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i12 = i11 & (-3670017);
                        } else {
                            i12 = i11;
                        }
                        if (i8 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                            function7 = function5;
                            f3 = fM3153getTonalElevationD9Ej5fM;
                            i13 = i12;
                            modifier4 = modifier2;
                        } else {
                            dialogProperties3 = dialogProperties;
                            i13 = i12;
                            modifier4 = modifier2;
                            function7 = function5;
                            f3 = fM3153getTonalElevationD9Ej5fM;
                        }
                    }
                    final Shape shape9 = shape2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(219718641, i13, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:75)");
                    }
                    AlertDialogKt.BasicAlertDialog(function0, SizeKt.wrapContentHeight$default(modifier4, null, false, 3, null), dialogProperties3, ComposableLambdaKt.rememberComposableLambda(1108953335, true, new Function2() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DatePickerDialog_androidKt.DatePickerDialog_GmEhDVc$lambda$0(shape9, datePickerColorsColors, f3, function4, function2, function7, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i13 & 14) | 3072 | ((i13 >> 15) & 896), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    dialogProperties2 = dialogProperties3;
                    f2 = f3;
                    function6 = function7;
                    modifier3 = modifier4;
                    shape3 = shape9;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    function6 = function5;
                    shape3 = shape2;
                    f2 = fM3153getTonalElevationD9Ej5fM;
                    dialogProperties2 = dialogProperties;
                }
                datePickerColors2 = datePickerColorsColors;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return DatePickerDialog_androidKt.DatePickerDialog_GmEhDVc$lambda$1(function0, function2, modifier3, function6, shape3, f2, datePickerColors2, dialogProperties2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            fM3153getTonalElevationD9Ej5fM = f;
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    datePickerColorsColors = datePickerColors;
                    if (composerStartRestartGroup.changed(datePickerColorsColors)) {
                    }
                    i3 |= i17;
                } else {
                    datePickerColorsColors = datePickerColors;
                }
                i3 |= i17;
            } else {
                datePickerColorsColors = datePickerColors;
            }
            i8 = i2 & 128;
            if (i8 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(dialogProperties)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i14 = 67108864;
                } else {
                    i14 = 33554432;
                }
                i3 |= i14;
            }
            i10 = i3;
            if ((i3 & 38347923) != 38347922) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i10 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "56@2765L5,57@2882L8");
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if ((i2 & 16) != 0) {
                        i11 = i10 & (-57345);
                        shape2 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    } else {
                        i11 = i10;
                    }
                    if (i6 != 0) {
                        fM3153getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m3153getTonalElevationD9Ej5fM();
                    }
                    if ((i2 & 64) != 0) {
                        datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i12 = i11 & (-3670017);
                    } else {
                        i12 = i11;
                    }
                    if (i8 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                        function7 = function5;
                        f3 = fM3153getTonalElevationD9Ej5fM;
                        i13 = i12;
                        modifier4 = modifier2;
                    } else {
                        dialogProperties3 = dialogProperties;
                        i13 = i12;
                        modifier4 = modifier2;
                        function7 = function5;
                        f3 = fM3153getTonalElevationD9Ej5fM;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if ((i2 & 16) != 0) {
                        i11 = i10 & (-57345);
                        shape2 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    } else {
                        i11 = i10;
                    }
                    if (i6 != 0) {
                        fM3153getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m3153getTonalElevationD9Ej5fM();
                    }
                    if ((i2 & 64) != 0) {
                        datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i12 = i11 & (-3670017);
                    } else {
                        i12 = i11;
                    }
                    if (i8 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                        function7 = function5;
                        f3 = fM3153getTonalElevationD9Ej5fM;
                        i13 = i12;
                        modifier4 = modifier2;
                    } else {
                        dialogProperties3 = dialogProperties;
                        i13 = i12;
                        modifier4 = modifier2;
                        function7 = function5;
                        f3 = fM3153getTonalElevationD9Ej5fM;
                    }
                }
                final Shape shape10 = shape2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(219718641, i13, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:75)");
                }
                AlertDialogKt.BasicAlertDialog(function0, SizeKt.wrapContentHeight$default(modifier4, null, false, 3, null), dialogProperties3, ComposableLambdaKt.rememberComposableLambda(1108953335, true, new Function2() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DatePickerDialog_androidKt.DatePickerDialog_GmEhDVc$lambda$0(shape10, datePickerColorsColors, f3, function4, function2, function7, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i13 & 14) | 3072 | ((i13 >> 15) & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                dialogProperties2 = dialogProperties3;
                f2 = f3;
                function6 = function7;
                modifier3 = modifier4;
                shape3 = shape10;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                function6 = function5;
                shape3 = shape2;
                f2 = fM3153getTonalElevationD9Ej5fM;
                dialogProperties2 = dialogProperties;
            }
            datePickerColors2 = datePickerColorsColors;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DatePickerDialog_androidKt.DatePickerDialog_GmEhDVc$lambda$1(function0, function2, modifier3, function6, shape3, f2, datePickerColors2, dialogProperties2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        function5 = function3;
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i3 |= i16;
            } else {
                shape2 = shape;
            }
            i3 |= i16;
        } else {
            shape2 = shape;
        }
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((196608 & i) == 0) {
                fM3153getTonalElevationD9Ej5fM = f;
                if (composerStartRestartGroup.changed(fM3153getTonalElevationD9Ej5fM)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    datePickerColorsColors = datePickerColors;
                    if (composerStartRestartGroup.changed(datePickerColorsColors)) {
                    }
                    i3 |= i17;
                } else {
                    datePickerColorsColors = datePickerColors;
                }
                i3 |= i17;
            } else {
                datePickerColorsColors = datePickerColors;
            }
            i8 = i2 & 128;
            if (i8 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(dialogProperties)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i14 = 67108864;
                } else {
                    i14 = 33554432;
                }
                i3 |= i14;
            }
            i10 = i3;
            if ((i3 & 38347923) != 38347922) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i10 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "56@2765L5,57@2882L8");
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if ((i2 & 16) != 0) {
                        i11 = i10 & (-57345);
                        shape2 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    } else {
                        i11 = i10;
                    }
                    if (i6 != 0) {
                        fM3153getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m3153getTonalElevationD9Ej5fM();
                    }
                    if ((i2 & 64) != 0) {
                        datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i12 = i11 & (-3670017);
                    } else {
                        i12 = i11;
                    }
                    if (i8 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                        function7 = function5;
                        f3 = fM3153getTonalElevationD9Ej5fM;
                        i13 = i12;
                        modifier4 = modifier2;
                    } else {
                        dialogProperties3 = dialogProperties;
                        i13 = i12;
                        modifier4 = modifier2;
                        function7 = function5;
                        f3 = fM3153getTonalElevationD9Ej5fM;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if ((i2 & 16) != 0) {
                        i11 = i10 & (-57345);
                        shape2 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    } else {
                        i11 = i10;
                    }
                    if (i6 != 0) {
                        fM3153getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m3153getTonalElevationD9Ej5fM();
                    }
                    if ((i2 & 64) != 0) {
                        datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i12 = i11 & (-3670017);
                    } else {
                        i12 = i11;
                    }
                    if (i8 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                        function7 = function5;
                        f3 = fM3153getTonalElevationD9Ej5fM;
                        i13 = i12;
                        modifier4 = modifier2;
                    } else {
                        dialogProperties3 = dialogProperties;
                        i13 = i12;
                        modifier4 = modifier2;
                        function7 = function5;
                        f3 = fM3153getTonalElevationD9Ej5fM;
                    }
                }
                final Shape shape11 = shape2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(219718641, i13, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:75)");
                }
                AlertDialogKt.BasicAlertDialog(function0, SizeKt.wrapContentHeight$default(modifier4, null, false, 3, null), dialogProperties3, ComposableLambdaKt.rememberComposableLambda(1108953335, true, new Function2() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DatePickerDialog_androidKt.DatePickerDialog_GmEhDVc$lambda$0(shape11, datePickerColorsColors, f3, function4, function2, function7, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i13 & 14) | 3072 | ((i13 >> 15) & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                dialogProperties2 = dialogProperties3;
                f2 = f3;
                function6 = function7;
                modifier3 = modifier4;
                shape3 = shape11;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                function6 = function5;
                shape3 = shape2;
                f2 = fM3153getTonalElevationD9Ej5fM;
                dialogProperties2 = dialogProperties;
            }
            datePickerColors2 = datePickerColorsColors;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DatePickerDialog_androidKt.DatePickerDialog_GmEhDVc$lambda$1(function0, function2, modifier3, function6, shape3, f2, datePickerColors2, dialogProperties2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        fM3153getTonalElevationD9Ej5fM = f;
        if ((1572864 & i) == 0) {
            if ((i2 & 64) == 0) {
                datePickerColorsColors = datePickerColors;
                if (composerStartRestartGroup.changed(datePickerColorsColors)) {
                }
                i3 |= i17;
            } else {
                datePickerColorsColors = datePickerColors;
            }
            i3 |= i17;
        } else {
            datePickerColorsColors = datePickerColors;
        }
        i8 = i2 & 128;
        if (i8 != 0) {
            i3 |= 12582912;
        } else if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changed(dialogProperties)) {
                i9 = 8388608;
            } else {
                i9 = 4194304;
            }
            i3 |= i9;
        }
        if ((i & 100663296) == 0) {
            if (composerStartRestartGroup.changedInstance(function4)) {
                i14 = 67108864;
            } else {
                i14 = 33554432;
            }
            i3 |= i14;
        }
        i10 = i3;
        if ((i3 & 38347923) != 38347922) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i10 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "56@2765L5,57@2882L8");
            if ((i & 1) != 0) {
                if (i15 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    function5 = null;
                }
                if ((i2 & 16) != 0) {
                    i11 = i10 & (-57345);
                    shape2 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                } else {
                    i11 = i10;
                }
                if (i6 != 0) {
                    fM3153getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m3153getTonalElevationD9Ej5fM();
                }
                if ((i2 & 64) != 0) {
                    datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    i12 = i11 & (-3670017);
                } else {
                    i12 = i11;
                }
                if (i8 != 0) {
                    dialogProperties3 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                    function7 = function5;
                    f3 = fM3153getTonalElevationD9Ej5fM;
                    i13 = i12;
                    modifier4 = modifier2;
                } else {
                    dialogProperties3 = dialogProperties;
                    i13 = i12;
                    modifier4 = modifier2;
                    function7 = function5;
                    f3 = fM3153getTonalElevationD9Ej5fM;
                }
            } else {
                if (i15 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    function5 = null;
                }
                if ((i2 & 16) != 0) {
                    i11 = i10 & (-57345);
                    shape2 = DatePickerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                } else {
                    i11 = i10;
                }
                if (i6 != 0) {
                    fM3153getTonalElevationD9Ej5fM = DatePickerDefaults.INSTANCE.m3153getTonalElevationD9Ej5fM();
                }
                if ((i2 & 64) != 0) {
                    datePickerColorsColors = DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    i12 = i11 & (-3670017);
                } else {
                    i12 = i11;
                }
                if (i8 != 0) {
                    dialogProperties3 = new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null);
                    function7 = function5;
                    f3 = fM3153getTonalElevationD9Ej5fM;
                    i13 = i12;
                    modifier4 = modifier2;
                } else {
                    dialogProperties3 = dialogProperties;
                    i13 = i12;
                    modifier4 = modifier2;
                    function7 = function5;
                    f3 = fM3153getTonalElevationD9Ej5fM;
                }
            }
            final Shape shape12 = shape2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(219718641, i13, -1, "androidx.compose.material3.DatePickerDialog (DatePickerDialog.android.kt:75)");
            }
            AlertDialogKt.BasicAlertDialog(function0, SizeKt.wrapContentHeight$default(modifier4, null, false, 3, null), dialogProperties3, ComposableLambdaKt.rememberComposableLambda(1108953335, true, new Function2() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerDialog_androidKt.DatePickerDialog_GmEhDVc$lambda$0(shape12, datePickerColorsColors, f3, function4, function2, function7, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i13 & 14) | 3072 | ((i13 >> 15) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            dialogProperties2 = dialogProperties3;
            f2 = f3;
            function6 = function7;
            modifier3 = modifier4;
            shape3 = shape12;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            function6 = function5;
            shape3 = shape2;
            f2 = fM3153getTonalElevationD9Ej5fM;
            dialogProperties2 = dialogProperties;
        }
        datePickerColors2 = datePickerColorsColors;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerDialog_androidKt.DatePickerDialog_GmEhDVc$lambda$1(function0, function2, modifier3, function6, shape3, f2, datePickerColors2, dialogProperties2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DatePickerDialog_GmEhDVc$lambda$0(Shape shape, DatePickerColors datePickerColors, float f, final Function3 function3, final Function2 function2, final Function2 function4, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C88@4109L1706,81@3799L2016:DatePickerDialog.android.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1108953335, i, -1, "androidx.compose.material3.DatePickerDialog.<anonymous> (DatePickerDialog.android.kt:81)");
            }
            SurfaceKt.m4323SurfaceT9BRK9s(SizeKt.m1254heightInVpY3zN4$default(SizeKt.m1263requiredWidth3ABfNKs(Modifier.INSTANCE, DatePickerModalTokens.INSTANCE.m5318getContainerWidthD9Ej5fM()), 0.0f, DatePickerModalTokens.INSTANCE.m5317getContainerHeightD9Ej5fM(), 1, null), shape, datePickerColors.getContainerColor(), 0L, f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1782015378, true, new Function2() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerDialog_androidKt.DatePickerDialog_GmEhDVc$lambda$0$0(function3, function2, function4, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 12582918, 104);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DatePickerDialog_GmEhDVc$lambda$0$0(Function3 function3, final Function2 function2, final Function2 function4, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C89@4123L1682:DatePickerDialog.android.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1782015378, i, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous> (DatePickerDialog.android.kt:89)");
            }
            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(spaceBetween, Alignment.INSTANCE.getStart(), composer, 6);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1407361339, "C95@4573L64,97@4681L1110:DatePickerDialog.android.kt#uh7d8r");
            Modifier modifierWeight = columnScopeInstance.weight(Modifier.INSTANCE, 1.0f, false);
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierWeight);
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
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -114868488, "C95@4626L9:DatePickerDialog.android.kt#uh7d8r");
            function3.invoke(columnScopeInstance, composer, 6);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierPadding = PaddingKt.padding(columnScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getEnd()), DialogButtonsPadding);
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifierPadding);
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
            Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 775974658, "C99@4882L5,100@4958L5,101@4987L786,98@4779L994:DatePickerDialog.android.kt#uh7d8r");
            ProvideContentColorTextStyleKt.m4997ProvideContentColorTextStyle3JVO9M(ColorSchemeKt.getValue(DialogTokens.INSTANCE.getActionLabelTextColor(), composer, 6), TypographyKt.getValue(DialogTokens.INSTANCE.getActionLabelTextFont(), composer, 6), ComposableLambdaKt.rememberComposableLambda(-1103927529, true, new Function2() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerDialog_androidKt.DatePickerDialog_GmEhDVc$lambda$0$0$0$1$0(function2, function4, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 384);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
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
    public static final Unit DatePickerDialog_GmEhDVc$lambda$0$0$0$1$0(final Function2 function2, final Function2 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C103@5106L7,112@5628L123,105@5217L534:DatePickerDialog.android.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1103927529, i, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePickerDialog.android.kt:102)");
            }
            ProvidableCompositionLocal<Dp> localMinimumInteractiveComponentSize = InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localMinimumInteractiveComponentSize);
            ComposerKt.sourceInformationMarkerEnd(composer);
            float fM9701unboximpl = ((Dp) objConsume).m9701unboximpl();
            if (Float.isNaN(fM9701unboximpl)) {
                fM9701unboximpl = Dp.m9687constructorimpl(0);
            }
            float fM9687constructorimpl = Dp.m9687constructorimpl(fM9701unboximpl - ButtonDefaults.INSTANCE.m2871getMinHeightD9Ej5fM());
            float f = DialogButtonsMainAxisSpacing;
            float f2 = DialogButtonsCrossAxisSpacing;
            AlertDialogKt.m2725AlertDialogFlowRowixp7dh8(f, ((Dp) RangesKt.coerceIn(Dp.m9685boximpl(Dp.m9687constructorimpl(f2 - fM9687constructorimpl)), Dp.m9685boximpl(Dp.m9687constructorimpl(0)), Dp.m9685boximpl(f2))).m9701unboximpl(), ComposableLambdaKt.rememberComposableLambda(-1980163584, true, new Function2() { // from class: androidx.compose.material3.DatePickerDialog_androidKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerDialog_androidKt.DatePickerDialog_GmEhDVc$lambda$0$0$0$1$0$1(function2, function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 390);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DatePickerDialog_GmEhDVc$lambda$0$0$0$1$0$1(Function2 function2, Function2 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C113@5658L15:DatePickerDialog.android.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1980163584, i, -1, "androidx.compose.material3.DatePickerDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePickerDialog.android.kt:113)");
            }
            function2.invoke(composer, 0);
            if (function3 == null) {
                composer.startReplaceGroup(322568153);
            } else {
                composer.startReplaceGroup(-266689240);
                ComposerKt.sourceInformation(composer, "114@5717L8");
                function3.invoke(composer, 0);
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static {
        float f = 8;
        DialogButtonsPadding = PaddingKt.m1215PaddingValuesa9UjIt4$default(0.0f, 0.0f, Dp.m9687constructorimpl(6), Dp.m9687constructorimpl(f), 3, null);
        DialogButtonsMainAxisSpacing = Dp.m9687constructorimpl(f);
        DialogButtonsCrossAxisSpacing = Dp.m9687constructorimpl(f);
    }
}
