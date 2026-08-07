package androidx.compose.material;

import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
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
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.pspdfkit.analytics.Analytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Snackbar.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\u001au\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0015\b\u0002\u0010\u0004\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a]\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a \u0010\u0018\u001a\u00020\u00012\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010\u0019\u001a3\u0010\u001a\u001a\u00020\u00012\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010\u001c\u001a3\u0010\u001d\u001a\u00020\u00012\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010\u001c\"\u0010\u0010\u001e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f\"\u0010\u0010 \u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f\"\u0010\u0010!\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f\"\u0010\u0010\"\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f\"\u0010\u0010#\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f\"\u0010\u0010$\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f\"\u0010\u0010%\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f\"\u0010\u0010&\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f\"\u0010\u0010'\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f¨\u0006("}, d2 = {"Snackbar", "", "modifier", "Landroidx/compose/ui/Modifier;", Analytics.Data.ACTION, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "actionOnNewLine", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "Landroidx/compose/ui/unit/Dp;", "content", "Snackbar-7zSek6w", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/graphics/Shape;JJFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "snackbarData", "Landroidx/compose/material/SnackbarData;", "actionColor", "Snackbar-sPrSdHI", "(Landroidx/compose/material/SnackbarData;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJJFLandroidx/compose/runtime/Composer;II)V", "TextOnlySnackbar", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "NewLineButtonSnackbar", "text", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "OneRowSnackbar", "HeightToFirstLine", "F", "HorizontalSpacing", "HorizontalSpacingButtonSide", "SeparateButtonExtraY", "SnackbarVerticalPadding", "TextEndExtraSpacing", "LongButtonVerticalOffset", "SnackbarMinHeightOneLine", "SnackbarMinHeightTwoLines", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SnackbarKt {
    private static final float HorizontalSpacingButtonSide;
    private static final float TextEndExtraSpacing;
    private static final float HeightToFirstLine = Dp.m9687constructorimpl(30);
    private static final float HorizontalSpacing = Dp.m9687constructorimpl(16);
    private static final float SeparateButtonExtraY = Dp.m9687constructorimpl(2);
    private static final float SnackbarVerticalPadding = Dp.m9687constructorimpl(6);
    private static final float LongButtonVerticalOffset = Dp.m9687constructorimpl(12);
    private static final float SnackbarMinHeightOneLine = Dp.m9687constructorimpl(48);
    private static final float SnackbarMinHeightTwoLines = Dp.m9687constructorimpl(68);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NewLineButtonSnackbar$lambda$1(Function2 function2, Function2 function3, int i, Composer composer, int i2) {
        NewLineButtonSnackbar(function2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OneRowSnackbar$lambda$2(Function2 function2, Function2 function3, int i, Composer composer, int i2) {
        OneRowSnackbar(function2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Snackbar_7zSek6w$lambda$1(Modifier modifier, Function2 function2, boolean z, Shape shape, long j, long j2, float f, Function2 function3, int i, int i2, Composer composer, int i3) {
        m2563Snackbar7zSek6w(modifier, function2, z, shape, j, j2, f, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Snackbar_sPrSdHI$lambda$2(SnackbarData snackbarData, Modifier modifier, boolean z, Shape shape, long j, long j2, long j3, float f, int i, int i2, Composer composer, int i3) {
        m2564SnackbarsPrSdHI(snackbarData, modifier, z, shape, j, j2, j3, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextOnlySnackbar$lambda$2(Function2 function2, int i, Composer composer, int i2) {
        TextOnlySnackbar(function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:106:0x0141 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:107:0x0143  */
    /* JADX WARN: Code duplicated, block: B:108:0x0148  */
    /* JADX WARN: Code duplicated, block: B:110:0x014c  */
    /* JADX WARN: Code duplicated, block: B:111:0x014e  */
    /* JADX WARN: Code duplicated, block: B:114:0x0152  */
    /* JADX WARN: Code duplicated, block: B:117:0x0159  */
    /* JADX WARN: Code duplicated, block: B:118:0x0168  */
    /* JADX WARN: Code duplicated, block: B:121:0x016d  */
    /* JADX WARN: Code duplicated, block: B:122:0x0176  */
    /* JADX WARN: Code duplicated, block: B:125:0x017b  */
    /* JADX WARN: Code duplicated, block: B:126:0x0188  */
    /* JADX WARN: Code duplicated, block: B:128:0x018b  */
    /* JADX WARN: Code duplicated, block: B:129:0x019d  */
    /* JADX WARN: Code duplicated, block: B:132:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:135:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:137:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:140:0x0212  */
    /* JADX WARN: Code duplicated, block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0050  */
    /* JADX WARN: Code duplicated, block: B:27:0x0053  */
    /* JADX WARN: Code duplicated, block: B:29:0x0057  */
    /* JADX WARN: Code duplicated, block: B:31:0x005f  */
    /* JADX WARN: Code duplicated, block: B:32:0x0062  */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0070  */
    /* JADX WARN: Code duplicated, block: B:41:0x0078  */
    /* JADX WARN: Code duplicated, block: B:42:0x007b  */
    /* JADX WARN: Code duplicated, block: B:45:0x0081  */
    /* JADX WARN: Code duplicated, block: B:48:0x0087  */
    /* JADX WARN: Code duplicated, block: B:50:0x008b  */
    /* JADX WARN: Code duplicated, block: B:52:0x0093  */
    /* JADX WARN: Code duplicated, block: B:53:0x0096  */
    /* JADX WARN: Code duplicated, block: B:56:0x009c  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:63:0x00af  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:80:0x00df  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:87:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:88:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:91:0x0107  */
    /* JADX WARN: Code duplicated, block: B:93:0x0119  */
    /* JADX INFO: renamed from: Snackbar-7zSek6w, reason: not valid java name */
    public static final void m2563Snackbar7zSek6w(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, boolean z, Shape shape, long j, long j2, float f, final Function2<? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Function2<? super Composer, ? super Integer, Unit> function4;
        int i4;
        final boolean z2;
        int i5;
        Shape shape2;
        long j3;
        long j4;
        int i6;
        int i7;
        boolean z3;
        Composer composer2;
        final Modifier modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function5;
        final boolean z4;
        final Shape shape3;
        final long j5;
        final long j6;
        final float f2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        final Function2<? super Composer, ? super Integer, Unit> function6;
        boolean z5;
        CornerBasedShape small;
        long backgroundColor;
        long jM2346getSurface0d7_KjU;
        Modifier modifier3;
        long j7;
        Shape shape4;
        long j8;
        float fM9687constructorimpl;
        int i8;
        Composer composerStartRestartGroup = composer.startRestartGroup(-662779944);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Snackbar)N(modifier,action,actionOnNewLine,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation:c#ui.unit.Dp,content)100@4429L464,94@4261L632:Snackbar.kt#jmzs0o");
        int i9 = i2 & 1;
        if (i9 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 == 0) {
            if ((i & 48) == 0) {
                function4 = function2;
                i3 |= composerStartRestartGroup.changedInstance(function4) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        int i11 = composerStartRestartGroup.changed(shape2) ? 2048 : 1024;
                        i3 |= i11;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i11;
                } else {
                    shape2 = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        j3 = j;
                        int i12 = composerStartRestartGroup.changed(j3) ? 16384 : 8192;
                        i3 |= i12;
                    } else {
                        j3 = j;
                    }
                    i3 |= i12;
                } else {
                    j3 = j;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        j4 = j2;
                        int i13 = composerStartRestartGroup.changed(j4) ? 131072 : 65536;
                        i3 |= i13;
                    } else {
                        j4 = j2;
                    }
                    i3 |= i13;
                } else {
                    j4 = j2;
                }
                i6 = i2 & 64;
                if (i6 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                    i3 |= i7;
                }
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i8 = 8388608;
                    } else {
                        i8 = 4194304;
                    }
                    i3 |= i8;
                }
                if ((i3 & 4793491) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "88@4057L6,89@4117L15,90@4174L6");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i10 != 0) {
                            function6 = null;
                        } else {
                            function6 = function4;
                        }
                        z5 = i4 == 0 ? z2 : false;
                        if ((i2 & 8) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i3 &= -7169;
                        } else {
                            small = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            backgroundColor = j3;
                        }
                        if ((i2 & 32) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i3 = (-458753) & i3;
                        } else {
                            jM2346getSurface0d7_KjU = j4;
                        }
                        if (i6 != 0) {
                            long j9 = jM2346getSurface0d7_KjU;
                            modifier3 = companion;
                            j7 = j9;
                            shape4 = small;
                            j8 = backgroundColor;
                            z2 = z5;
                            fM9687constructorimpl = Dp.m9687constructorimpl(6);
                        } else {
                            long j10 = jM2346getSurface0d7_KjU;
                            modifier3 = companion;
                            j7 = j10;
                            shape4 = small;
                            j8 = backgroundColor;
                            z2 = z5;
                            fM9687constructorimpl = f;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                        }
                        fM9687constructorimpl = f;
                        function6 = function4;
                        j7 = j4;
                        j8 = j3;
                        modifier3 = modifier;
                        shape4 = shape2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-662779944, i3, -1, "androidx.compose.material.Snackbar (Snackbar.kt:93)");
                    }
                    int i14 = i3 >> 6;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m2584SurfaceFjzlyU(modifier3, shape4, j8, j7, null, fM9687constructorimpl, ComposableLambdaKt.rememberComposableLambda(-1429068516, true, new Function2() { // from class: androidx.compose.material.SnackbarKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SnackbarKt.Snackbar_7zSek6w$lambda$0(function6, function3, z2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, 1572864 | (i3 & 14) | (i14 & 112) | (i14 & 896) | (i14 & 7168) | ((i3 >> 3) & 458752), 16);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function5 = function6;
                    z4 = z2;
                    modifier2 = modifier3;
                    shape3 = shape4;
                    j5 = j8;
                    j6 = j7;
                    f2 = fM9687constructorimpl;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier2 = modifier;
                    function5 = function4;
                    z4 = z2;
                    shape3 = shape2;
                    j5 = j3;
                    j6 = j4;
                    f2 = f;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SnackbarKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SnackbarKt.Snackbar_7zSek6w$lambda$1(modifier2, function5, z4, shape3, j5, j6, f2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            z2 = z;
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i11;
                } else {
                    shape2 = shape;
                }
                i3 |= i11;
            } else {
                shape2 = shape;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    j3 = j;
                    if (composerStartRestartGroup.changed(j3)) {
                    }
                    i3 |= i12;
                } else {
                    j3 = j;
                }
                i3 |= i12;
            } else {
                j3 = j;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    j4 = j2;
                    if (composerStartRestartGroup.changed(j4)) {
                    }
                    i3 |= i13;
                } else {
                    j4 = j2;
                }
                i3 |= i13;
            } else {
                j4 = j2;
            }
            i6 = i2 & 64;
            if (i6 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i7 = 1048576;
                } else {
                    i7 = 524288;
                }
                i3 |= i7;
            }
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i8 = 8388608;
                } else {
                    i8 = 4194304;
                }
                i3 |= i8;
            }
            if ((i3 & 4793491) != 4793490) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "88@4057L6,89@4117L15,90@4174L6");
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i10 != 0) {
                        function6 = null;
                    } else {
                        function6 = function4;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 8) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i3 &= -7169;
                    } else {
                        small = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        backgroundColor = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i3 = (-458753) & i3;
                    } else {
                        jM2346getSurface0d7_KjU = j4;
                    }
                    if (i6 != 0) {
                        long j11 = jM2346getSurface0d7_KjU;
                        modifier3 = companion;
                        j7 = j11;
                        shape4 = small;
                        j8 = backgroundColor;
                        z2 = z5;
                        fM9687constructorimpl = Dp.m9687constructorimpl(6);
                    } else {
                        long j12 = jM2346getSurface0d7_KjU;
                        modifier3 = companion;
                        j7 = j12;
                        shape4 = small;
                        j8 = backgroundColor;
                        z2 = z5;
                        fM9687constructorimpl = f;
                    }
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i10 != 0) {
                        function6 = null;
                    } else {
                        function6 = function4;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 8) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i3 &= -7169;
                    } else {
                        small = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        backgroundColor = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i3 = (-458753) & i3;
                    } else {
                        jM2346getSurface0d7_KjU = j4;
                    }
                    if (i6 != 0) {
                        long j13 = jM2346getSurface0d7_KjU;
                        modifier3 = companion;
                        j7 = j13;
                        shape4 = small;
                        j8 = backgroundColor;
                        z2 = z5;
                        fM9687constructorimpl = Dp.m9687constructorimpl(6);
                    } else {
                        long j14 = jM2346getSurface0d7_KjU;
                        modifier3 = companion;
                        j7 = j14;
                        shape4 = small;
                        j8 = backgroundColor;
                        z2 = z5;
                        fM9687constructorimpl = f;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-662779944, i3, -1, "androidx.compose.material.Snackbar (Snackbar.kt:93)");
                }
                int i15 = i3 >> 6;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m2584SurfaceFjzlyU(modifier3, shape4, j8, j7, null, fM9687constructorimpl, ComposableLambdaKt.rememberComposableLambda(-1429068516, true, new Function2() { // from class: androidx.compose.material.SnackbarKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SnackbarKt.Snackbar_7zSek6w$lambda$0(function6, function3, z2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, 1572864 | (i3 & 14) | (i15 & 112) | (i15 & 896) | (i15 & 7168) | ((i3 >> 3) & 458752), 16);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function5 = function6;
                z4 = z2;
                modifier2 = modifier3;
                shape3 = shape4;
                j5 = j8;
                j6 = j7;
                f2 = fM9687constructorimpl;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = modifier;
                function5 = function4;
                z4 = z2;
                shape3 = shape2;
                j5 = j3;
                j6 = j4;
                f2 = f;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SnackbarKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SnackbarKt.Snackbar_7zSek6w$lambda$1(modifier2, function5, z4, shape3, j5, j6, f2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        function4 = function2;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i11;
                } else {
                    shape2 = shape;
                }
                i3 |= i11;
            } else {
                shape2 = shape;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    j3 = j;
                    if (composerStartRestartGroup.changed(j3)) {
                    }
                    i3 |= i12;
                } else {
                    j3 = j;
                }
                i3 |= i12;
            } else {
                j3 = j;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    j4 = j2;
                    if (composerStartRestartGroup.changed(j4)) {
                    }
                    i3 |= i13;
                } else {
                    j4 = j2;
                }
                i3 |= i13;
            } else {
                j4 = j2;
            }
            i6 = i2 & 64;
            if (i6 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i7 = 1048576;
                } else {
                    i7 = 524288;
                }
                i3 |= i7;
            }
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i8 = 8388608;
                } else {
                    i8 = 4194304;
                }
                i3 |= i8;
            }
            if ((i3 & 4793491) != 4793490) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "88@4057L6,89@4117L15,90@4174L6");
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i10 != 0) {
                        function6 = null;
                    } else {
                        function6 = function4;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 8) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i3 &= -7169;
                    } else {
                        small = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        backgroundColor = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i3 = (-458753) & i3;
                    } else {
                        jM2346getSurface0d7_KjU = j4;
                    }
                    if (i6 != 0) {
                        long j15 = jM2346getSurface0d7_KjU;
                        modifier3 = companion;
                        j7 = j15;
                        shape4 = small;
                        j8 = backgroundColor;
                        z2 = z5;
                        fM9687constructorimpl = Dp.m9687constructorimpl(6);
                    } else {
                        long j16 = jM2346getSurface0d7_KjU;
                        modifier3 = companion;
                        j7 = j16;
                        shape4 = small;
                        j8 = backgroundColor;
                        z2 = z5;
                        fM9687constructorimpl = f;
                    }
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i10 != 0) {
                        function6 = null;
                    } else {
                        function6 = function4;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 8) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i3 &= -7169;
                    } else {
                        small = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        backgroundColor = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i3 = (-458753) & i3;
                    } else {
                        jM2346getSurface0d7_KjU = j4;
                    }
                    if (i6 != 0) {
                        long j17 = jM2346getSurface0d7_KjU;
                        modifier3 = companion;
                        j7 = j17;
                        shape4 = small;
                        j8 = backgroundColor;
                        z2 = z5;
                        fM9687constructorimpl = Dp.m9687constructorimpl(6);
                    } else {
                        long j18 = jM2346getSurface0d7_KjU;
                        modifier3 = companion;
                        j7 = j18;
                        shape4 = small;
                        j8 = backgroundColor;
                        z2 = z5;
                        fM9687constructorimpl = f;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-662779944, i3, -1, "androidx.compose.material.Snackbar (Snackbar.kt:93)");
                }
                int i16 = i3 >> 6;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m2584SurfaceFjzlyU(modifier3, shape4, j8, j7, null, fM9687constructorimpl, ComposableLambdaKt.rememberComposableLambda(-1429068516, true, new Function2() { // from class: androidx.compose.material.SnackbarKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SnackbarKt.Snackbar_7zSek6w$lambda$0(function6, function3, z2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, 1572864 | (i3 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | ((i3 >> 3) & 458752), 16);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function5 = function6;
                z4 = z2;
                modifier2 = modifier3;
                shape3 = shape4;
                j5 = j8;
                j6 = j7;
                f2 = fM9687constructorimpl;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = modifier;
                function5 = function4;
                z4 = z2;
                shape3 = shape2;
                j5 = j3;
                j6 = j4;
                f2 = f;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SnackbarKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SnackbarKt.Snackbar_7zSek6w$lambda$1(modifier2, function5, z4, shape3, j5, j6, f2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        z2 = z;
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i3 |= i11;
            } else {
                shape2 = shape;
            }
            i3 |= i11;
        } else {
            shape2 = shape;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                j3 = j;
                if (composerStartRestartGroup.changed(j3)) {
                }
                i3 |= i12;
            } else {
                j3 = j;
            }
            i3 |= i12;
        } else {
            j3 = j;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                j4 = j2;
                if (composerStartRestartGroup.changed(j4)) {
                }
                i3 |= i13;
            } else {
                j4 = j2;
            }
            i3 |= i13;
        } else {
            j4 = j2;
        }
        i6 = i2 & 64;
        if (i6 != 0) {
            i3 |= 1572864;
        } else if ((i & 1572864) == 0) {
            if (composerStartRestartGroup.changed(f)) {
                i7 = 1048576;
            } else {
                i7 = 524288;
            }
            i3 |= i7;
        }
        if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i8 = 8388608;
            } else {
                i8 = 4194304;
            }
            i3 |= i8;
        }
        if ((i3 & 4793491) != 4793490) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "88@4057L6,89@4117L15,90@4174L6");
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i10 != 0) {
                    function6 = null;
                } else {
                    function6 = function4;
                }
                if (i4 == 0) {
                }
                if ((i2 & 8) != 0) {
                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    i3 &= -7169;
                } else {
                    small = shape2;
                }
                if ((i2 & 16) != 0) {
                    backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                    i3 &= -57345;
                } else {
                    backgroundColor = j3;
                }
                if ((i2 & 32) != 0) {
                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                    i3 = (-458753) & i3;
                } else {
                    jM2346getSurface0d7_KjU = j4;
                }
                if (i6 != 0) {
                    long j19 = jM2346getSurface0d7_KjU;
                    modifier3 = companion;
                    j7 = j19;
                    shape4 = small;
                    j8 = backgroundColor;
                    z2 = z5;
                    fM9687constructorimpl = Dp.m9687constructorimpl(6);
                } else {
                    long j110 = jM2346getSurface0d7_KjU;
                    modifier3 = companion;
                    j7 = j110;
                    shape4 = small;
                    j8 = backgroundColor;
                    z2 = z5;
                    fM9687constructorimpl = f;
                }
            } else {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i10 != 0) {
                    function6 = null;
                } else {
                    function6 = function4;
                }
                if (i4 == 0) {
                }
                if ((i2 & 8) != 0) {
                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    i3 &= -7169;
                } else {
                    small = shape2;
                }
                if ((i2 & 16) != 0) {
                    backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                    i3 &= -57345;
                } else {
                    backgroundColor = j3;
                }
                if ((i2 & 32) != 0) {
                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                    i3 = (-458753) & i3;
                } else {
                    jM2346getSurface0d7_KjU = j4;
                }
                if (i6 != 0) {
                    long j111 = jM2346getSurface0d7_KjU;
                    modifier3 = companion;
                    j7 = j111;
                    shape4 = small;
                    j8 = backgroundColor;
                    z2 = z5;
                    fM9687constructorimpl = Dp.m9687constructorimpl(6);
                } else {
                    long j112 = jM2346getSurface0d7_KjU;
                    modifier3 = companion;
                    j7 = j112;
                    shape4 = small;
                    j8 = backgroundColor;
                    z2 = z5;
                    fM9687constructorimpl = f;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-662779944, i3, -1, "androidx.compose.material.Snackbar (Snackbar.kt:93)");
            }
            int i17 = i3 >> 6;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m2584SurfaceFjzlyU(modifier3, shape4, j8, j7, null, fM9687constructorimpl, ComposableLambdaKt.rememberComposableLambda(-1429068516, true, new Function2() { // from class: androidx.compose.material.SnackbarKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SnackbarKt.Snackbar_7zSek6w$lambda$0(function6, function3, z2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, 1572864 | (i3 & 14) | (i17 & 112) | (i17 & 896) | (i17 & 7168) | ((i3 >> 3) & 458752), 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function5 = function6;
            z4 = z2;
            modifier2 = modifier3;
            shape3 = shape4;
            j5 = j8;
            j6 = j7;
            f2 = fM9687constructorimpl;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier2 = modifier;
            function5 = function4;
            z4 = z2;
            shape3 = shape2;
            j5 = j3;
            j6 = j4;
            f2 = f;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SnackbarKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SnackbarKt.Snackbar_7zSek6w$lambda$1(modifier2, function5, z4, shape3, j5, j6, f2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Snackbar_7zSek6w$lambda$0(final Function2 function2, final Function2 function3, final boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C101@4504L4,101@4510L377,101@4439L448:Snackbar.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1429068516, i, -1, "androidx.compose.material.Snackbar.<anonymous> (Snackbar.kt:101)");
            }
            CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer, 6))), ComposableLambdaKt.rememberComposableLambda(1236486620, true, new Function2() { // from class: androidx.compose.material.SnackbarKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SnackbarKt.Snackbar_7zSek6w$lambda$0$0(function2, function3, z, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Snackbar_7zSek6w$lambda$0$0(final Function2 function2, final Function2 function3, final boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C102@4554L10,103@4619L258,103@4583L294:Snackbar.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1236486620, i, -1, "androidx.compose.material.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:102)");
            }
            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer, 6).getBody2(), ComposableLambdaKt.rememberComposableLambda(1789628237, true, new Function2() { // from class: androidx.compose.material.SnackbarKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SnackbarKt.Snackbar_7zSek6w$lambda$0$0$0(function2, function3, z, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Snackbar_7zSek6w$lambda$0$0$0(Function2 function2, Function2 function3, boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:Snackbar.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1789628237, i, -1, "androidx.compose.material.Snackbar.<anonymous>.<anonymous>.<anonymous> (Snackbar.kt:104)");
            }
            if (function2 == null) {
                composer.startReplaceGroup(1845819398);
                ComposerKt.sourceInformation(composer, "105@4682L25");
                TextOnlySnackbar(function3, composer, 0);
                composer.endReplaceGroup();
            } else if (z) {
                composer.startReplaceGroup(1845821491);
                ComposerKt.sourceInformation(composer, "106@4747L38");
                NewLineButtonSnackbar(function3, function2, composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1845823628);
                ComposerKt.sourceInformation(composer, "107@4814L31");
                OneRowSnackbar(function3, function2, composer, 0);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:111:0x014d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:112:0x014f  */
    /* JADX WARN: Code duplicated, block: B:114:0x0156  */
    /* JADX WARN: Code duplicated, block: B:117:0x015d  */
    /* JADX WARN: Code duplicated, block: B:120:0x0170  */
    /* JADX WARN: Code duplicated, block: B:123:0x017c  */
    /* JADX WARN: Code duplicated, block: B:126:0x018c  */
    /* JADX WARN: Code duplicated, block: B:127:0x0196  */
    /* JADX WARN: Code duplicated, block: B:129:0x019a  */
    /* JADX WARN: Code duplicated, block: B:130:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:134:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:137:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:138:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:141:0x0234  */
    /* JADX WARN: Code duplicated, block: B:143:0x0244  */
    /* JADX WARN: Code duplicated, block: B:146:0x025a  */
    /* JADX WARN: Code duplicated, block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x004d  */
    /* JADX WARN: Code duplicated, block: B:27:0x0050  */
    /* JADX WARN: Code duplicated, block: B:29:0x0054  */
    /* JADX WARN: Code duplicated, block: B:31:0x005c  */
    /* JADX WARN: Code duplicated, block: B:32:0x005f  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069  */
    /* JADX WARN: Code duplicated, block: B:39:0x006d  */
    /* JADX WARN: Code duplicated, block: B:41:0x0075  */
    /* JADX WARN: Code duplicated, block: B:42:0x0078  */
    /* JADX WARN: Code duplicated, block: B:45:0x007e  */
    /* JADX WARN: Code duplicated, block: B:48:0x0084  */
    /* JADX WARN: Code duplicated, block: B:50:0x0088  */
    /* JADX WARN: Code duplicated, block: B:52:0x0090  */
    /* JADX WARN: Code duplicated, block: B:53:0x0093  */
    /* JADX WARN: Code duplicated, block: B:56:0x0099  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:64:0x00af  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:69:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:74:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:76:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:80:0x00db  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:89:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:90:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:93:0x0107  */
    /* JADX WARN: Code duplicated, block: B:95:0x011c  */
    /* JADX INFO: renamed from: Snackbar-sPrSdHI, reason: not valid java name */
    public static final void m2564SnackbarsPrSdHI(final SnackbarData snackbarData, Modifier modifier, boolean z, Shape shape, long j, long j2, long j3, float f, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        Shape small;
        long backgroundColor;
        long jM2346getSurface0d7_KjU;
        int i6;
        int i7;
        boolean z3;
        Composer composer2;
        final float f2;
        final Modifier modifier3;
        final boolean z4;
        final Shape shape2;
        final long j4;
        final long j5;
        final long j6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long primaryActionColor;
        float fM9687constructorimpl;
        long j7;
        final long j8;
        boolean z5;
        Shape shape3;
        long j9;
        final String actionLabel;
        final SnackbarData snackbarData2;
        ComposableLambda composableLambdaRememberComposableLambda;
        int i8;
        int i9;
        Composer composerStartRestartGroup = composer.startRestartGroup(258660814);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Snackbar)N(snackbarData,modifier,actionOnNewLine,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,actionColor:c#ui.graphics.Color,elevation:c#ui.unit.Dp)181@7976L30,179@7904L321:Snackbar.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? composerStartRestartGroup.changed(snackbarData) : composerStartRestartGroup.changedInstance(snackbarData) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        small = shape;
                        int i11 = composerStartRestartGroup.changed(small) ? 2048 : 1024;
                        i3 |= i11;
                    } else {
                        small = shape;
                    }
                    i3 |= i11;
                } else {
                    small = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        backgroundColor = j;
                        int i12 = composerStartRestartGroup.changed(backgroundColor) ? 16384 : 8192;
                        i3 |= i12;
                    } else {
                        backgroundColor = j;
                    }
                    i3 |= i12;
                } else {
                    backgroundColor = j;
                }
                if ((196608 & i) == 0) {
                    jM2346getSurface0d7_KjU = j2;
                    if ((i2 & 32) == 0 || !composerStartRestartGroup.changed(jM2346getSurface0d7_KjU)) {
                        i9 = 65536;
                    } else {
                        i9 = 131072;
                    }
                    i3 |= i9;
                } else {
                    jM2346getSurface0d7_KjU = j2;
                }
                if ((1572864 & i) != 0) {
                    if ((i2 & 64) == 0 || !composerStartRestartGroup.changed(j3)) {
                        i8 = 524288;
                    } else {
                        i8 = 1048576;
                    }
                    i3 |= i8;
                }
                i6 = i2 & 128;
                if (i6 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i7 = 8388608;
                    } else {
                        i7 = 4194304;
                    }
                    i3 |= i7;
                }
                if ((4793491 & i3) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "160@7202L6,161@7262L15,162@7319L6,163@7377L18");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i10 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = false;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        }
                        if ((i2 & 16) != 0) {
                            backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i3 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            primaryActionColor = SnackbarDefaults.INSTANCE.getPrimaryActionColor(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            primaryActionColor = j3;
                        }
                        if (i6 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(6);
                        } else {
                            fM9687constructorimpl = f;
                        }
                        j7 = jM2346getSurface0d7_KjU;
                        j8 = primaryActionColor;
                        z5 = z2;
                        shape3 = small;
                        j9 = backgroundColor;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                        }
                        j8 = j3;
                        fM9687constructorimpl = f;
                        shape3 = small;
                        j9 = backgroundColor;
                        j7 = jM2346getSurface0d7_KjU;
                        z5 = z2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(258660814, i3, -1, "androidx.compose.material.Snackbar (Snackbar.kt:165)");
                    }
                    actionLabel = snackbarData.getActionLabel();
                    if (actionLabel != null) {
                        composerStartRestartGroup.startReplaceGroup(593497188);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "169@7587L268");
                        snackbarData2 = snackbarData;
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1843479216, true, new Function2() { // from class: androidx.compose.material.SnackbarKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SnackbarKt.Snackbar_sPrSdHI$lambda$0(j8, snackbarData2, actionLabel, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        snackbarData2 = snackbarData;
                        composerStartRestartGroup.startReplaceGroup(593796152);
                        composerStartRestartGroup.endReplaceGroup();
                        composableLambdaRememberComposableLambda = null;
                    }
                    composer2 = composerStartRestartGroup;
                    m2563Snackbar7zSek6w(PaddingKt.m1218padding3ABfNKs(modifier2, Dp.m9687constructorimpl(12)), composableLambdaRememberComposableLambda, z5, shape3, j9, j7, fM9687constructorimpl, ComposableLambdaKt.rememberComposableLambda(-261845785, true, new Function2() { // from class: androidx.compose.material.SnackbarKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SnackbarKt.Snackbar_sPrSdHI$lambda$1(snackbarData2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (i3 & 896) | 12582912 | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 >> 3) & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j6 = j8;
                    modifier3 = modifier2;
                    z4 = z5;
                    shape2 = shape3;
                    j4 = j9;
                    j5 = j7;
                    f2 = fM9687constructorimpl;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    f2 = f;
                    modifier3 = modifier2;
                    z4 = z2;
                    shape2 = small;
                    j4 = backgroundColor;
                    j5 = jM2346getSurface0d7_KjU;
                    j6 = j3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SnackbarKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SnackbarKt.Snackbar_sPrSdHI$lambda$2(snackbarData, modifier3, z4, shape2, j4, j5, j6, f2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            z2 = z;
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    small = shape;
                    if (composerStartRestartGroup.changed(small)) {
                    }
                    i3 |= i11;
                } else {
                    small = shape;
                }
                i3 |= i11;
            } else {
                small = shape;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    backgroundColor = j;
                    if (composerStartRestartGroup.changed(backgroundColor)) {
                    }
                    i3 |= i12;
                } else {
                    backgroundColor = j;
                }
                i3 |= i12;
            } else {
                backgroundColor = j;
            }
            if ((196608 & i) == 0) {
                jM2346getSurface0d7_KjU = j2;
                if ((i2 & 32) == 0) {
                    i9 = 65536;
                } else {
                    i9 = 65536;
                }
                i3 |= i9;
            } else {
                jM2346getSurface0d7_KjU = j2;
            }
            if ((1572864 & i) != 0) {
                if ((i2 & 64) == 0) {
                    i8 = 524288;
                } else {
                    i8 = 524288;
                }
                i3 |= i8;
            }
            i6 = i2 & 128;
            if (i6 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i7 = 8388608;
                } else {
                    i7 = 4194304;
                }
                i3 |= i7;
            }
            if ((4793491 & i3) != 4793490) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "160@7202L6,161@7262L15,162@7319L6,163@7377L18");
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        primaryActionColor = SnackbarDefaults.INSTANCE.getPrimaryActionColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        primaryActionColor = j3;
                    }
                    if (i6 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(6);
                    } else {
                        fM9687constructorimpl = f;
                    }
                    j7 = jM2346getSurface0d7_KjU;
                    j8 = primaryActionColor;
                    z5 = z2;
                    shape3 = small;
                    j9 = backgroundColor;
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        primaryActionColor = SnackbarDefaults.INSTANCE.getPrimaryActionColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        primaryActionColor = j3;
                    }
                    if (i6 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(6);
                    } else {
                        fM9687constructorimpl = f;
                    }
                    j7 = jM2346getSurface0d7_KjU;
                    j8 = primaryActionColor;
                    z5 = z2;
                    shape3 = small;
                    j9 = backgroundColor;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(258660814, i3, -1, "androidx.compose.material.Snackbar (Snackbar.kt:165)");
                }
                actionLabel = snackbarData.getActionLabel();
                if (actionLabel != null) {
                    composerStartRestartGroup.startReplaceGroup(593497188);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "169@7587L268");
                    snackbarData2 = snackbarData;
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1843479216, true, new Function2() { // from class: androidx.compose.material.SnackbarKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SnackbarKt.Snackbar_sPrSdHI$lambda$0(j8, snackbarData2, actionLabel, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    snackbarData2 = snackbarData;
                    composerStartRestartGroup.startReplaceGroup(593796152);
                    composerStartRestartGroup.endReplaceGroup();
                    composableLambdaRememberComposableLambda = null;
                }
                composer2 = composerStartRestartGroup;
                m2563Snackbar7zSek6w(PaddingKt.m1218padding3ABfNKs(modifier2, Dp.m9687constructorimpl(12)), composableLambdaRememberComposableLambda, z5, shape3, j9, j7, fM9687constructorimpl, ComposableLambdaKt.rememberComposableLambda(-261845785, true, new Function2() { // from class: androidx.compose.material.SnackbarKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SnackbarKt.Snackbar_sPrSdHI$lambda$1(snackbarData2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, (i3 & 896) | 12582912 | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 >> 3) & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j6 = j8;
                modifier3 = modifier2;
                z4 = z5;
                shape2 = shape3;
                j4 = j9;
                j5 = j7;
                f2 = fM9687constructorimpl;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                f2 = f;
                modifier3 = modifier2;
                z4 = z2;
                shape2 = small;
                j4 = backgroundColor;
                j5 = jM2346getSurface0d7_KjU;
                j6 = j3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SnackbarKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SnackbarKt.Snackbar_sPrSdHI$lambda$2(snackbarData, modifier3, z4, shape2, j4, j5, j6, f2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    small = shape;
                    if (composerStartRestartGroup.changed(small)) {
                    }
                    i3 |= i11;
                } else {
                    small = shape;
                }
                i3 |= i11;
            } else {
                small = shape;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    backgroundColor = j;
                    if (composerStartRestartGroup.changed(backgroundColor)) {
                    }
                    i3 |= i12;
                } else {
                    backgroundColor = j;
                }
                i3 |= i12;
            } else {
                backgroundColor = j;
            }
            if ((196608 & i) == 0) {
                jM2346getSurface0d7_KjU = j2;
                if ((i2 & 32) == 0) {
                    i9 = 65536;
                } else {
                    i9 = 65536;
                }
                i3 |= i9;
            } else {
                jM2346getSurface0d7_KjU = j2;
            }
            if ((1572864 & i) != 0) {
                if ((i2 & 64) == 0) {
                    i8 = 524288;
                } else {
                    i8 = 524288;
                }
                i3 |= i8;
            }
            i6 = i2 & 128;
            if (i6 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i7 = 8388608;
                } else {
                    i7 = 4194304;
                }
                i3 |= i7;
            }
            if ((4793491 & i3) != 4793490) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "160@7202L6,161@7262L15,162@7319L6,163@7377L18");
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        primaryActionColor = SnackbarDefaults.INSTANCE.getPrimaryActionColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        primaryActionColor = j3;
                    }
                    if (i6 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(6);
                    } else {
                        fM9687constructorimpl = f;
                    }
                    j7 = jM2346getSurface0d7_KjU;
                    j8 = primaryActionColor;
                    z5 = z2;
                    shape3 = small;
                    j9 = backgroundColor;
                } else {
                    if (i10 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    }
                    if ((i2 & 16) != 0) {
                        backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        primaryActionColor = SnackbarDefaults.INSTANCE.getPrimaryActionColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        primaryActionColor = j3;
                    }
                    if (i6 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(6);
                    } else {
                        fM9687constructorimpl = f;
                    }
                    j7 = jM2346getSurface0d7_KjU;
                    j8 = primaryActionColor;
                    z5 = z2;
                    shape3 = small;
                    j9 = backgroundColor;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(258660814, i3, -1, "androidx.compose.material.Snackbar (Snackbar.kt:165)");
                }
                actionLabel = snackbarData.getActionLabel();
                if (actionLabel != null) {
                    composerStartRestartGroup.startReplaceGroup(593497188);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "169@7587L268");
                    snackbarData2 = snackbarData;
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1843479216, true, new Function2() { // from class: androidx.compose.material.SnackbarKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SnackbarKt.Snackbar_sPrSdHI$lambda$0(j8, snackbarData2, actionLabel, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    snackbarData2 = snackbarData;
                    composerStartRestartGroup.startReplaceGroup(593796152);
                    composerStartRestartGroup.endReplaceGroup();
                    composableLambdaRememberComposableLambda = null;
                }
                composer2 = composerStartRestartGroup;
                m2563Snackbar7zSek6w(PaddingKt.m1218padding3ABfNKs(modifier2, Dp.m9687constructorimpl(12)), composableLambdaRememberComposableLambda, z5, shape3, j9, j7, fM9687constructorimpl, ComposableLambdaKt.rememberComposableLambda(-261845785, true, new Function2() { // from class: androidx.compose.material.SnackbarKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SnackbarKt.Snackbar_sPrSdHI$lambda$1(snackbarData2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, (i3 & 896) | 12582912 | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 >> 3) & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j6 = j8;
                modifier3 = modifier2;
                z4 = z5;
                shape2 = shape3;
                j4 = j9;
                j5 = j7;
                f2 = fM9687constructorimpl;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                f2 = f;
                modifier3 = modifier2;
                z4 = z2;
                shape2 = small;
                j4 = backgroundColor;
                j5 = jM2346getSurface0d7_KjU;
                j6 = j3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SnackbarKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SnackbarKt.Snackbar_sPrSdHI$lambda$2(snackbarData, modifier3, z4, shape2, j4, j5, j6, f2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        z2 = z;
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                small = shape;
                if (composerStartRestartGroup.changed(small)) {
                }
                i3 |= i11;
            } else {
                small = shape;
            }
            i3 |= i11;
        } else {
            small = shape;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                backgroundColor = j;
                if (composerStartRestartGroup.changed(backgroundColor)) {
                }
                i3 |= i12;
            } else {
                backgroundColor = j;
            }
            i3 |= i12;
        } else {
            backgroundColor = j;
        }
        if ((196608 & i) == 0) {
            jM2346getSurface0d7_KjU = j2;
            if ((i2 & 32) == 0) {
                i9 = 65536;
            } else {
                i9 = 65536;
            }
            i3 |= i9;
        } else {
            jM2346getSurface0d7_KjU = j2;
        }
        if ((1572864 & i) != 0) {
            if ((i2 & 64) == 0) {
                i8 = 524288;
            } else {
                i8 = 524288;
            }
            i3 |= i8;
        }
        i6 = i2 & 128;
        if (i6 != 0) {
            i3 |= 12582912;
        } else if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changed(f)) {
                i7 = 8388608;
            } else {
                i7 = 4194304;
            }
            i3 |= i7;
        }
        if ((4793491 & i3) != 4793490) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "160@7202L6,161@7262L15,162@7319L6,163@7377L18");
            if ((i & 1) != 0) {
                if (i10 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z2 = false;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                }
                if ((i2 & 16) != 0) {
                    backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                    i3 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                    i3 &= -458753;
                }
                if ((i2 & 64) != 0) {
                    primaryActionColor = SnackbarDefaults.INSTANCE.getPrimaryActionColor(composerStartRestartGroup, 6);
                    i3 &= -3670017;
                } else {
                    primaryActionColor = j3;
                }
                if (i6 != 0) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(6);
                } else {
                    fM9687constructorimpl = f;
                }
                j7 = jM2346getSurface0d7_KjU;
                j8 = primaryActionColor;
                z5 = z2;
                shape3 = small;
                j9 = backgroundColor;
            } else {
                if (i10 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z2 = false;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                }
                if ((i2 & 16) != 0) {
                    backgroundColor = SnackbarDefaults.INSTANCE.getBackgroundColor(composerStartRestartGroup, 6);
                    i3 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                    i3 &= -458753;
                }
                if ((i2 & 64) != 0) {
                    primaryActionColor = SnackbarDefaults.INSTANCE.getPrimaryActionColor(composerStartRestartGroup, 6);
                    i3 &= -3670017;
                } else {
                    primaryActionColor = j3;
                }
                if (i6 != 0) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(6);
                } else {
                    fM9687constructorimpl = f;
                }
                j7 = jM2346getSurface0d7_KjU;
                j8 = primaryActionColor;
                z5 = z2;
                shape3 = small;
                j9 = backgroundColor;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(258660814, i3, -1, "androidx.compose.material.Snackbar (Snackbar.kt:165)");
            }
            actionLabel = snackbarData.getActionLabel();
            if (actionLabel != null) {
                composerStartRestartGroup.startReplaceGroup(593497188);
                ComposerKt.sourceInformation(composerStartRestartGroup, "169@7587L268");
                snackbarData2 = snackbarData;
                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1843479216, true, new Function2() { // from class: androidx.compose.material.SnackbarKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SnackbarKt.Snackbar_sPrSdHI$lambda$0(j8, snackbarData2, actionLabel, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                snackbarData2 = snackbarData;
                composerStartRestartGroup.startReplaceGroup(593796152);
                composerStartRestartGroup.endReplaceGroup();
                composableLambdaRememberComposableLambda = null;
            }
            composer2 = composerStartRestartGroup;
            m2563Snackbar7zSek6w(PaddingKt.m1218padding3ABfNKs(modifier2, Dp.m9687constructorimpl(12)), composableLambdaRememberComposableLambda, z5, shape3, j9, j7, fM9687constructorimpl, ComposableLambdaKt.rememberComposableLambda(-261845785, true, new Function2() { // from class: androidx.compose.material.SnackbarKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SnackbarKt.Snackbar_sPrSdHI$lambda$1(snackbarData2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, (i3 & 896) | 12582912 | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 >> 3) & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j6 = j8;
            modifier3 = modifier2;
            z4 = z5;
            shape2 = shape3;
            j4 = j9;
            j5 = j7;
            f2 = fM9687constructorimpl;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            f2 = f;
            modifier3 = modifier2;
            z4 = z2;
            shape2 = small;
            j4 = backgroundColor;
            j5 = jM2346getSurface0d7_KjU;
            j6 = j3;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SnackbarKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SnackbarKt.Snackbar_sPrSdHI$lambda$2(snackbarData, modifier3, z4, shape2, j4, j5, j6, f2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Snackbar_sPrSdHI$lambda$0(long j, final SnackbarData snackbarData, final String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C171@7661L44,172@7737L32,173@7801L21,170@7605L236:Snackbar.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1843479216, i, -1, "androidx.compose.material.Snackbar.<anonymous> (Snackbar.kt:170)");
            }
            ButtonColors buttonColorsM2310textButtonColorsRGew2ao = ButtonDefaults.INSTANCE.m2310textButtonColorsRGew2ao(0L, j, 0L, composer, 3072, 5);
            ComposerKt.sourceInformationMarkerStart(composer, 2057005456, "CC(remember):Snackbar.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(snackbarData);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material.SnackbarKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SnackbarKt.Snackbar_sPrSdHI$lambda$0$0$0(snackbarData);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ButtonKt.TextButton((Function0) objRememberedValue, null, false, null, null, null, null, buttonColorsM2310textButtonColorsRGew2ao, null, ComposableLambdaKt.rememberComposableLambda(-929149933, true, new Function3() { // from class: androidx.compose.material.SnackbarKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SnackbarKt.Snackbar_sPrSdHI$lambda$0$1(str, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 805306368, 382);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Snackbar_sPrSdHI$lambda$0$0$0(SnackbarData snackbarData) {
        snackbarData.performAction();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Snackbar_sPrSdHI$lambda$0$1(String str, RowScope rowScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C173@7803L17:Snackbar.kt#jmzs0o");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-929149933, i, -1, "androidx.compose.material.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:173)");
            }
            TextKt.m2663Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Snackbar_sPrSdHI$lambda$1(SnackbarData snackbarData, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C181@7978L26:Snackbar.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-261845785, i, -1, "androidx.compose.material.Snackbar.<anonymous> (Snackbar.kt:181)");
            }
            TextKt.m2663Text4IGK_g(snackbarData.getMessage(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final void TextOnlySnackbar(final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(343813818);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextOnlySnackbar)N(content)243@10217L1665,236@10020L1862:Snackbar.kt#jmzs0o");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(343813818, i2, -1, "androidx.compose.material.TextOnlySnackbar (Snackbar.kt:235)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -307392805, "CC(remember):Snackbar.kt#9igjgp");
            SnackbarKt$TextOnlySnackbar$2$1 snackbarKt$TextOnlySnackbar$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (snackbarKt$TextOnlySnackbar$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                snackbarKt$TextOnlySnackbar$2$1RememberedValue = SnackbarKt$TextOnlySnackbar$2$1.INSTANCE;
                composerStartRestartGroup.updateRememberedValue(snackbarKt$TextOnlySnackbar$2$1RememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) snackbarKt$TextOnlySnackbar$2$1RememberedValue;
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 329364564, "C237@10037L172:Snackbar.kt#jmzs0o");
            Modifier modifierM1219paddingVpY3zN4 = PaddingKt.m1219paddingVpY3zN4(Modifier.INSTANCE, HorizontalSpacing, SnackbarVerticalPadding);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1219paddingVpY3zN4);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -687189347, "C241@10190L9:Snackbar.kt#jmzs0o");
            function2.invoke(composerStartRestartGroup, Integer.valueOf(i2 & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SnackbarKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SnackbarKt.TextOnlySnackbar$lambda$2(function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void NewLineButtonSnackbar(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1534293206);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NewLineButtonSnackbar)N(text,action)290@12000L529:Snackbar.kt#jmzs0o");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1534293206, i2, -1, "androidx.compose.material.NewLineButtonSnackbar (Snackbar.kt:289)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            float f = HorizontalSpacing;
            float f2 = HorizontalSpacingButtonSide;
            Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(modifierFillMaxWidth$default, f, 0.0f, f2, SeparateButtonExtraY, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1222paddingqDBjuR0$default);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1930803468, "C299@12276L191,305@12476L47:Snackbar.kt#jmzs0o");
            Modifier modifierM1222paddingqDBjuR0$default2 = PaddingKt.m1222paddingqDBjuR0$default(AlignmentLineKt.m1043paddingFromBaselineVpY3zN4(Modifier.INSTANCE, HeightToFirstLine, LongButtonVerticalOffset), 0.0f, 0.0f, f2, 0.0f, 11, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1222paddingqDBjuR0$default2);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1762149527, "C303@12451L6:Snackbar.kt#jmzs0o");
            function2.invoke(composerStartRestartGroup, Integer.valueOf(i2 & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierAlign = columnScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getEnd());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAlign);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -488335938, "C305@12513L8:Snackbar.kt#jmzs0o");
            function3.invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 3) & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SnackbarKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SnackbarKt.NewLineButtonSnackbar$lambda$1(function2, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void OneRowSnackbar(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1302703572);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OneRowSnackbar)N(text,action)319@12986L2277,313@12694L2569:Snackbar.kt#jmzs0o");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1302703572, i2, -1, "androidx.compose.material.OneRowSnackbar (Snackbar.kt:310)");
            }
            Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, HorizontalSpacing, 0.0f, HorizontalSpacingButtonSide, 0.0f, 10, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2062665689, "CC(remember):Snackbar.kt#9igjgp");
            SnackbarKt$OneRowSnackbar$2$1 snackbarKt$OneRowSnackbar$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (snackbarKt$OneRowSnackbar$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                snackbarKt$OneRowSnackbar$2$1RememberedValue = new SnackbarKt$OneRowSnackbar$2$1(Analytics.Data.ACTION, "text");
                composerStartRestartGroup.updateRememberedValue(snackbarKt$OneRowSnackbar$2$1RememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) snackbarKt$OneRowSnackbar$2$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1222paddingqDBjuR0$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1514754933, "C315@12724L86,316@12823L46:Snackbar.kt#jmzs0o");
            Modifier modifierM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, "text"), 0.0f, SnackbarVerticalPadding, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1220paddingVpY3zN4$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1933811418, "C315@12802L6:Snackbar.kt#jmzs0o");
            function2.invoke(composerStartRestartGroup, Integer.valueOf(i2 & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, Analytics.Data.ACTION);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierLayoutId);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 243306651, "C316@12859L8:Snackbar.kt#jmzs0o");
            function3.invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 3) & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SnackbarKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SnackbarKt.OneRowSnackbar$lambda$2(function2, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static {
        float f = 8;
        HorizontalSpacingButtonSide = Dp.m9687constructorimpl(f);
        TextEndExtraSpacing = Dp.m9687constructorimpl(f);
    }
}
