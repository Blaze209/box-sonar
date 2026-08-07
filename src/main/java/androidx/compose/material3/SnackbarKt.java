package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.Icons;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.SnackbarTokens;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import com.pspdfkit.analytics.Analytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Snackbar.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0096\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0015\b\u0002\u0010\u0004\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010\u0007\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\r2\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001ag\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001ab\u0010\u0019\u001a\u00020\u00012\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0013\u0010\u0007\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0003¢\u0006\u0004\b\u001d\u0010\u001e\u001ad\u0010\u001f\u001a\u00020\u00012\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0013\u0010\u0004\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0013\u0010\u0007\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\rH\u0003¢\u0006\u0004\b\"\u0010\u001e\"\u0010\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%\"\u0010\u0010&\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%\"\u0010\u0010'\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%\"\u0010\u0010(\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%\"\u0010\u0010)\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%\"\u0010\u0010*\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%\"\u0010\u0010+\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%\"\u0010\u0010,\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%¨\u0006-"}, d2 = {"Snackbar", "", "modifier", "Landroidx/compose/ui/Modifier;", Analytics.Data.ACTION, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "dismissAction", "actionOnNewLine", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "actionContentColor", "dismissActionContentColor", "content", "Snackbar-eQBnUkQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/graphics/Shape;JJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "snackbarData", "Landroidx/compose/material3/SnackbarData;", "actionColor", "Snackbar-sDKtq54", "(Landroidx/compose/material3/SnackbarData;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJJJJLandroidx/compose/runtime/Composer;II)V", "NewLineButtonSnackbar", "text", "actionTextStyle", "Landroidx/compose/ui/text/TextStyle;", "NewLineButtonSnackbar-kKq0p4A", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JJLandroidx/compose/runtime/Composer;I)V", "OneRowSnackbar", "actionTextColor", "dismissActionColor", "OneRowSnackbar-kKq0p4A", "ContainerMaxWidth", "Landroidx/compose/ui/unit/Dp;", "F", "HeightToFirstLine", "HorizontalSpacing", "HorizontalSpacingButtonSide", "SeparateButtonExtraY", "SnackbarVerticalPadding", "TextEndExtraSpacing", "LongButtonVerticalOffset", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SnackbarKt {
    private static final float HorizontalSpacingButtonSide;
    private static final float TextEndExtraSpacing;
    private static final float ContainerMaxWidth = Dp.m9687constructorimpl(600);
    private static final float HeightToFirstLine = Dp.m9687constructorimpl(30);
    private static final float HorizontalSpacing = Dp.m9687constructorimpl(16);
    private static final float SeparateButtonExtraY = Dp.m9687constructorimpl(2);
    private static final float SnackbarVerticalPadding = Dp.m9687constructorimpl(6);
    private static final float LongButtonVerticalOffset = Dp.m9687constructorimpl(12);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NewLineButtonSnackbar_kKq0p4A$lambda$1(Function2 function2, Function2 function3, Function2 function4, TextStyle textStyle, long j, long j2, int i, Composer composer, int i2) {
        m4271NewLineButtonSnackbarkKq0p4A(function2, function3, function4, textStyle, j, j2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OneRowSnackbar_kKq0p4A$lambda$2(Function2 function2, Function2 function3, Function2 function4, TextStyle textStyle, long j, long j2, int i, Composer composer, int i2) {
        m4272OneRowSnackbarkKq0p4A(function2, function3, function4, textStyle, j, j2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Snackbar_eQBnUkQ$lambda$1(Modifier modifier, Function2 function2, Function2 function3, boolean z, Shape shape, long j, long j2, long j3, long j4, Function2 function4, int i, int i2, Composer composer, int i3) {
        m4273SnackbareQBnUkQ(modifier, function2, function3, z, shape, j, j2, j3, j4, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Snackbar_sDKtq54$lambda$3(SnackbarData snackbarData, Modifier modifier, boolean z, Shape shape, long j, long j2, long j3, long j4, long j5, int i, int i2, Composer composer, int i3) {
        m4274SnackbarsDKtq54(snackbarData, modifier, z, shape, j, j2, j3, j4, j5, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0116  */
    /* JADX WARN: Code duplicated, block: B:102:0x011e  */
    /* JADX WARN: Code duplicated, block: B:103:0x0121  */
    /* JADX WARN: Code duplicated, block: B:105:0x0126  */
    /* JADX WARN: Code duplicated, block: B:108:0x0132  */
    /* JADX WARN: Code duplicated, block: B:109:0x0134  */
    /* JADX WARN: Code duplicated, block: B:112:0x013d  */
    /* JADX WARN: Code duplicated, block: B:114:0x0158  */
    /* JADX WARN: Code duplicated, block: B:133:0x018f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:134:0x0191  */
    /* JADX WARN: Code duplicated, block: B:135:0x0196  */
    /* JADX WARN: Code duplicated, block: B:138:0x019c  */
    /* JADX WARN: Code duplicated, block: B:141:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:143:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:144:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:147:0x01af  */
    /* JADX WARN: Code duplicated, block: B:148:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:151:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:152:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:155:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:156:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:159:0x01da  */
    /* JADX WARN: Code duplicated, block: B:160:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:163:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:164:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:167:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:170:0x0264  */
    /* JADX WARN: Code duplicated, block: B:172:0x0273  */
    /* JADX WARN: Code duplicated, block: B:175:0x028a  */
    /* JADX WARN: Code duplicated, block: B:177:? A[RETURN, SYNTHETIC] */
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
    /* JADX WARN: Code duplicated, block: B:50:0x008c  */
    /* JADX WARN: Code duplicated, block: B:52:0x0094  */
    /* JADX WARN: Code duplicated, block: B:53:0x0097  */
    /* JADX WARN: Code duplicated, block: B:56:0x009d  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:90:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:92:0x0102  */
    /* JADX WARN: Code duplicated, block: B:95:0x010b  */
    /* JADX WARN: Code duplicated, block: B:97:0x010f  */
    /* JADX INFO: renamed from: Snackbar-eQBnUkQ, reason: not valid java name */
    public static final void m4273SnackbareQBnUkQ(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, boolean z, Shape shape, long j, long j2, long j3, long j4, final Function2<? super Composer, ? super Integer, Unit> function4, Composer composer, final int i, final int i2) {
        int i3;
        Function2<? super Composer, ? super Integer, Unit> function5;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function6;
        int i5;
        int i6;
        boolean z2;
        int i7;
        Shape shape2;
        long j5;
        boolean z3;
        Composer composer2;
        final Modifier modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function7;
        final Function2<? super Composer, ? super Integer, Unit> function8;
        final boolean z4;
        final Shape shape3;
        final long j6;
        final long j7;
        final long j8;
        final long j9;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Function2<? super Composer, ? super Integer, Unit> function9;
        boolean z5;
        Shape shape4;
        long color;
        long contentColor;
        long actionContentColor;
        long dismissActionContentColor;
        int i8;
        int i9;
        int i10;
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1218779924);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Snackbar)N(modifier,action,dismissAction,actionOnNewLine,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,actionContentColor:c#ui.graphics.Color,dismissActionContentColor:c#ui.graphics.Color,content)117@5477L1123,111@5280L1320:Snackbar.kt#uh7d8r");
        int i12 = i2 & 1;
        if (i12 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i13 = i2 & 2;
        if (i13 == 0) {
            if ((i & 48) == 0) {
                function5 = function2;
                i3 |= composerStartRestartGroup.changedInstance(function5) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    function6 = function3;
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 3072) == 0) {
                        z2 = z;
                        if (composerStartRestartGroup.changed(z2)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    if ((i & 24576) == 0) {
                        if ((i2 & 16) == 0) {
                            shape2 = shape;
                            int i14 = composerStartRestartGroup.changed(shape2) ? 16384 : 8192;
                            i3 |= i14;
                        } else {
                            shape2 = shape;
                        }
                        i3 |= i14;
                    } else {
                        shape2 = shape;
                    }
                    if ((196608 & i) == 0) {
                        if ((i2 & 32) == 0) {
                            j5 = j;
                            int i15 = composerStartRestartGroup.changed(j5) ? 131072 : 65536;
                            i3 |= i15;
                        } else {
                            j5 = j;
                        }
                        i3 |= i15;
                    } else {
                        j5 = j;
                    }
                    if ((i & 1572864) != 0) {
                        if ((i2 & 64) == 0 || !composerStartRestartGroup.changed(j2)) {
                            i11 = 524288;
                        } else {
                            i11 = 1048576;
                        }
                        i3 |= i11;
                    }
                    if ((i & 12582912) != 0) {
                        if ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j3)) {
                            i10 = 4194304;
                        } else {
                            i10 = 8388608;
                        }
                        i3 |= i10;
                    }
                    if ((100663296 & i) != 0) {
                        if ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j4)) {
                            i9 = 33554432;
                        } else {
                            i9 = 67108864;
                        }
                        i3 |= i9;
                    }
                    if ((805306368 & i) != 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i8 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i8 = 268435456;
                        }
                        i3 |= i8;
                    }
                    if ((i3 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "104@4967L5,105@5019L5,106@5069L12,107@5132L18,108@5208L25");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i13 != 0) {
                                function5 = null;
                            }
                            function9 = i4 == 0 ? function6 : null;
                            if (i6 != 0) {
                                z5 = false;
                            } else {
                                z5 = z2;
                            }
                            if ((i2 & 16) != 0) {
                                shape4 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i3 &= -57345;
                            } else {
                                shape4 = shape2;
                            }
                            if ((i2 & 32) != 0) {
                                color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                                i3 &= -458753;
                            } else {
                                color = j5;
                            }
                            if ((i2 & 64) != 0) {
                                contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                contentColor = j2;
                            }
                            if ((i2 & 128) != 0) {
                                actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                actionContentColor = j3;
                            }
                            if ((i2 & 256) != 0) {
                                dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                                i3 &= -234881025;
                            } else {
                                dismissActionContentColor = j4;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                            }
                            if ((i2 & 128) != 0) {
                                i3 &= -29360129;
                            }
                            if ((i2 & 256) != 0) {
                                i3 &= -234881025;
                            }
                            companion = modifier;
                            dismissActionContentColor = j4;
                            function9 = function6;
                            z5 = z2;
                            shape4 = shape2;
                            color = j5;
                            contentColor = j2;
                            actionContentColor = j3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1218779924, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:110)");
                        }
                        final Function2<? super Composer, ? super Integer, Unit> function10 = function5;
                        final long j10 = actionContentColor;
                        final boolean z6 = z5;
                        final long j11 = dismissActionContentColor;
                        final Function2<? super Composer, ? super Integer, Unit> function11 = function9;
                        Modifier modifier3 = companion;
                        int i16 = i3 >> 9;
                        SurfaceKt.m4323SurfaceT9BRK9s(modifier3, shape4, color, contentColor, 0.0f, SnackbarTokens.INSTANCE.m5781getContainerElevationD9Ej5fM(), null, ComposableLambdaKt.rememberComposableLambda(-1343524879, true, new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SnackbarKt.Snackbar_eQBnUkQ$lambda$0(z6, function10, function4, function11, j10, j11, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 12779520 | (i16 & 112) | (i16 & 896) | (i16 & 7168), 80);
                        modifier2 = modifier3;
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        shape3 = shape4;
                        function7 = function5;
                        j6 = color;
                        j7 = contentColor;
                        j8 = actionContentColor;
                        z4 = z5;
                        j9 = dismissActionContentColor;
                        function8 = function9;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier2 = modifier;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        shape3 = shape2;
                        j6 = j5;
                        j7 = j2;
                        j8 = j3;
                        j9 = j4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SnackbarKt.Snackbar_eQBnUkQ$lambda$1(modifier2, function7, function8, z4, shape3, j6, j7, j8, j9, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 3072;
                z2 = z;
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        shape2 = shape;
                        if (composerStartRestartGroup.changed(shape2)) {
                        }
                        i3 |= i14;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i14;
                } else {
                    shape2 = shape;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        j5 = j;
                        if (composerStartRestartGroup.changed(j5)) {
                        }
                        i3 |= i15;
                    } else {
                        j5 = j;
                    }
                    i3 |= i15;
                } else {
                    j5 = j;
                }
                if ((i & 1572864) != 0) {
                    if ((i2 & 64) == 0) {
                        i11 = 524288;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                if ((i & 12582912) != 0) {
                    if ((i2 & 128) == 0) {
                        i10 = 4194304;
                    } else {
                        i10 = 4194304;
                    }
                    i3 |= i10;
                }
                if ((100663296 & i) != 0) {
                    if ((i2 & 256) == 0) {
                        i9 = 33554432;
                    } else {
                        i9 = 33554432;
                    }
                    i3 |= i9;
                }
                if ((805306368 & i) != 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i8 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i8 = 268435456;
                    }
                    i3 |= i8;
                }
                if ((i3 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4967L5,105@5019L5,106@5069L12,107@5132L18,108@5208L25");
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i13 != 0) {
                            function5 = null;
                        }
                        if (i4 == 0) {
                        }
                        if (i6 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if ((i2 & 16) != 0) {
                            shape4 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            shape4 = shape2;
                        }
                        if ((i2 & 32) != 0) {
                            color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        } else {
                            color = j5;
                        }
                        if ((i2 & 64) != 0) {
                            contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            contentColor = j2;
                        }
                        if ((i2 & 128) != 0) {
                            actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            actionContentColor = j3;
                        }
                        if ((i2 & 256) != 0) {
                            dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -234881025;
                        } else {
                            dismissActionContentColor = j4;
                        }
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i13 != 0) {
                            function5 = null;
                        }
                        if (i4 == 0) {
                        }
                        if (i6 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if ((i2 & 16) != 0) {
                            shape4 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            shape4 = shape2;
                        }
                        if ((i2 & 32) != 0) {
                            color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        } else {
                            color = j5;
                        }
                        if ((i2 & 64) != 0) {
                            contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            contentColor = j2;
                        }
                        if ((i2 & 128) != 0) {
                            actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            actionContentColor = j3;
                        }
                        if ((i2 & 256) != 0) {
                            dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -234881025;
                        } else {
                            dismissActionContentColor = j4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1218779924, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:110)");
                    }
                    final Function2 function12 = function5;
                    final long j12 = actionContentColor;
                    final boolean z7 = z5;
                    final long j13 = dismissActionContentColor;
                    final Function2 function13 = function9;
                    Modifier modifier4 = companion;
                    int i17 = i3 >> 9;
                    SurfaceKt.m4323SurfaceT9BRK9s(modifier4, shape4, color, contentColor, 0.0f, SnackbarTokens.INSTANCE.m5781getContainerElevationD9Ej5fM(), null, ComposableLambdaKt.rememberComposableLambda(-1343524879, true, new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SnackbarKt.Snackbar_eQBnUkQ$lambda$0(z7, function12, function4, function13, j12, j13, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 12779520 | (i17 & 112) | (i17 & 896) | (i17 & 7168), 80);
                    modifier2 = modifier4;
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape3 = shape4;
                    function7 = function5;
                    j6 = color;
                    j7 = contentColor;
                    j8 = actionContentColor;
                    z4 = z5;
                    j9 = dismissActionContentColor;
                    function8 = function9;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier2 = modifier;
                    function7 = function5;
                    function8 = function6;
                    z4 = z2;
                    shape3 = shape2;
                    j6 = j5;
                    j7 = j2;
                    j8 = j3;
                    j9 = j4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SnackbarKt.Snackbar_eQBnUkQ$lambda$1(modifier2, function7, function8, z4, shape3, j6, j7, j8, j9, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            function6 = function3;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        shape2 = shape;
                        if (composerStartRestartGroup.changed(shape2)) {
                        }
                        i3 |= i14;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i14;
                } else {
                    shape2 = shape;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        j5 = j;
                        if (composerStartRestartGroup.changed(j5)) {
                        }
                        i3 |= i15;
                    } else {
                        j5 = j;
                    }
                    i3 |= i15;
                } else {
                    j5 = j;
                }
                if ((i & 1572864) != 0) {
                    if ((i2 & 64) == 0) {
                        i11 = 524288;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                if ((i & 12582912) != 0) {
                    if ((i2 & 128) == 0) {
                        i10 = 4194304;
                    } else {
                        i10 = 4194304;
                    }
                    i3 |= i10;
                }
                if ((100663296 & i) != 0) {
                    if ((i2 & 256) == 0) {
                        i9 = 33554432;
                    } else {
                        i9 = 33554432;
                    }
                    i3 |= i9;
                }
                if ((805306368 & i) != 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i8 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i8 = 268435456;
                    }
                    i3 |= i8;
                }
                if ((i3 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4967L5,105@5019L5,106@5069L12,107@5132L18,108@5208L25");
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i13 != 0) {
                            function5 = null;
                        }
                        if (i4 == 0) {
                        }
                        if (i6 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if ((i2 & 16) != 0) {
                            shape4 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            shape4 = shape2;
                        }
                        if ((i2 & 32) != 0) {
                            color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        } else {
                            color = j5;
                        }
                        if ((i2 & 64) != 0) {
                            contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            contentColor = j2;
                        }
                        if ((i2 & 128) != 0) {
                            actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            actionContentColor = j3;
                        }
                        if ((i2 & 256) != 0) {
                            dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -234881025;
                        } else {
                            dismissActionContentColor = j4;
                        }
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i13 != 0) {
                            function5 = null;
                        }
                        if (i4 == 0) {
                        }
                        if (i6 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if ((i2 & 16) != 0) {
                            shape4 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            shape4 = shape2;
                        }
                        if ((i2 & 32) != 0) {
                            color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        } else {
                            color = j5;
                        }
                        if ((i2 & 64) != 0) {
                            contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            contentColor = j2;
                        }
                        if ((i2 & 128) != 0) {
                            actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            actionContentColor = j3;
                        }
                        if ((i2 & 256) != 0) {
                            dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -234881025;
                        } else {
                            dismissActionContentColor = j4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1218779924, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:110)");
                    }
                    final Function2 function14 = function5;
                    final long j14 = actionContentColor;
                    final boolean z8 = z5;
                    final long j15 = dismissActionContentColor;
                    final Function2 function15 = function9;
                    Modifier modifier5 = companion;
                    int i18 = i3 >> 9;
                    SurfaceKt.m4323SurfaceT9BRK9s(modifier5, shape4, color, contentColor, 0.0f, SnackbarTokens.INSTANCE.m5781getContainerElevationD9Ej5fM(), null, ComposableLambdaKt.rememberComposableLambda(-1343524879, true, new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SnackbarKt.Snackbar_eQBnUkQ$lambda$0(z8, function14, function4, function15, j14, j15, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 12779520 | (i18 & 112) | (i18 & 896) | (i18 & 7168), 80);
                    modifier2 = modifier5;
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape3 = shape4;
                    function7 = function5;
                    j6 = color;
                    j7 = contentColor;
                    j8 = actionContentColor;
                    z4 = z5;
                    j9 = dismissActionContentColor;
                    function8 = function9;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier2 = modifier;
                    function7 = function5;
                    function8 = function6;
                    z4 = z2;
                    shape3 = shape2;
                    j6 = j5;
                    j7 = j2;
                    j8 = j3;
                    j9 = j4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SnackbarKt.Snackbar_eQBnUkQ$lambda$1(modifier2, function7, function8, z4, shape3, j6, j7, j8, j9, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z2 = z;
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i14;
                } else {
                    shape2 = shape;
                }
                i3 |= i14;
            } else {
                shape2 = shape;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    j5 = j;
                    if (composerStartRestartGroup.changed(j5)) {
                    }
                    i3 |= i15;
                } else {
                    j5 = j;
                }
                i3 |= i15;
            } else {
                j5 = j;
            }
            if ((i & 1572864) != 0) {
                if ((i2 & 64) == 0) {
                    i11 = 524288;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
            if ((i & 12582912) != 0) {
                if ((i2 & 128) == 0) {
                    i10 = 4194304;
                } else {
                    i10 = 4194304;
                }
                i3 |= i10;
            }
            if ((100663296 & i) != 0) {
                if ((i2 & 256) == 0) {
                    i9 = 33554432;
                } else {
                    i9 = 33554432;
                }
                i3 |= i9;
            }
            if ((805306368 & i) != 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i8 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i8 = 268435456;
                }
                i3 |= i8;
            }
            if ((i3 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4967L5,105@5019L5,106@5069L12,107@5132L18,108@5208L25");
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i13 != 0) {
                        function5 = null;
                    }
                    if (i4 == 0) {
                    }
                    if (i6 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if ((i2 & 16) != 0) {
                        shape4 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        shape4 = shape2;
                    }
                    if ((i2 & 32) != 0) {
                        color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    } else {
                        color = j5;
                    }
                    if ((i2 & 64) != 0) {
                        contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        contentColor = j2;
                    }
                    if ((i2 & 128) != 0) {
                        actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        actionContentColor = j3;
                    }
                    if ((i2 & 256) != 0) {
                        dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -234881025;
                    } else {
                        dismissActionContentColor = j4;
                    }
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i13 != 0) {
                        function5 = null;
                    }
                    if (i4 == 0) {
                    }
                    if (i6 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if ((i2 & 16) != 0) {
                        shape4 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        shape4 = shape2;
                    }
                    if ((i2 & 32) != 0) {
                        color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    } else {
                        color = j5;
                    }
                    if ((i2 & 64) != 0) {
                        contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        contentColor = j2;
                    }
                    if ((i2 & 128) != 0) {
                        actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        actionContentColor = j3;
                    }
                    if ((i2 & 256) != 0) {
                        dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -234881025;
                    } else {
                        dismissActionContentColor = j4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1218779924, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:110)");
                }
                final Function2 function16 = function5;
                final long j16 = actionContentColor;
                final boolean z9 = z5;
                final long j17 = dismissActionContentColor;
                final Function2 function17 = function9;
                Modifier modifier6 = companion;
                int i19 = i3 >> 9;
                SurfaceKt.m4323SurfaceT9BRK9s(modifier6, shape4, color, contentColor, 0.0f, SnackbarTokens.INSTANCE.m5781getContainerElevationD9Ej5fM(), null, ComposableLambdaKt.rememberComposableLambda(-1343524879, true, new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SnackbarKt.Snackbar_eQBnUkQ$lambda$0(z9, function16, function4, function17, j16, j17, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 12779520 | (i19 & 112) | (i19 & 896) | (i19 & 7168), 80);
                modifier2 = modifier6;
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape3 = shape4;
                function7 = function5;
                j6 = color;
                j7 = contentColor;
                j8 = actionContentColor;
                z4 = z5;
                j9 = dismissActionContentColor;
                function8 = function9;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = modifier;
                function7 = function5;
                function8 = function6;
                z4 = z2;
                shape3 = shape2;
                j6 = j5;
                j7 = j2;
                j8 = j3;
                j9 = j4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SnackbarKt.Snackbar_eQBnUkQ$lambda$1(modifier2, function7, function8, z4, shape3, j6, j7, j8, j9, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        function5 = function2;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                function6 = function3;
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        shape2 = shape;
                        if (composerStartRestartGroup.changed(shape2)) {
                        }
                        i3 |= i14;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i14;
                } else {
                    shape2 = shape;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        j5 = j;
                        if (composerStartRestartGroup.changed(j5)) {
                        }
                        i3 |= i15;
                    } else {
                        j5 = j;
                    }
                    i3 |= i15;
                } else {
                    j5 = j;
                }
                if ((i & 1572864) != 0) {
                    if ((i2 & 64) == 0) {
                        i11 = 524288;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                if ((i & 12582912) != 0) {
                    if ((i2 & 128) == 0) {
                        i10 = 4194304;
                    } else {
                        i10 = 4194304;
                    }
                    i3 |= i10;
                }
                if ((100663296 & i) != 0) {
                    if ((i2 & 256) == 0) {
                        i9 = 33554432;
                    } else {
                        i9 = 33554432;
                    }
                    i3 |= i9;
                }
                if ((805306368 & i) != 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i8 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i8 = 268435456;
                    }
                    i3 |= i8;
                }
                if ((i3 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "104@4967L5,105@5019L5,106@5069L12,107@5132L18,108@5208L25");
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i13 != 0) {
                            function5 = null;
                        }
                        if (i4 == 0) {
                        }
                        if (i6 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if ((i2 & 16) != 0) {
                            shape4 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            shape4 = shape2;
                        }
                        if ((i2 & 32) != 0) {
                            color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        } else {
                            color = j5;
                        }
                        if ((i2 & 64) != 0) {
                            contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            contentColor = j2;
                        }
                        if ((i2 & 128) != 0) {
                            actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            actionContentColor = j3;
                        }
                        if ((i2 & 256) != 0) {
                            dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -234881025;
                        } else {
                            dismissActionContentColor = j4;
                        }
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i13 != 0) {
                            function5 = null;
                        }
                        if (i4 == 0) {
                        }
                        if (i6 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if ((i2 & 16) != 0) {
                            shape4 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            shape4 = shape2;
                        }
                        if ((i2 & 32) != 0) {
                            color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                            i3 &= -458753;
                        } else {
                            color = j5;
                        }
                        if ((i2 & 64) != 0) {
                            contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i3 &= -3670017;
                        } else {
                            contentColor = j2;
                        }
                        if ((i2 & 128) != 0) {
                            actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            actionContentColor = j3;
                        }
                        if ((i2 & 256) != 0) {
                            dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                            i3 &= -234881025;
                        } else {
                            dismissActionContentColor = j4;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1218779924, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:110)");
                    }
                    final Function2 function18 = function5;
                    final long j18 = actionContentColor;
                    final boolean z10 = z5;
                    final long j19 = dismissActionContentColor;
                    final Function2 function19 = function9;
                    Modifier modifier7 = companion;
                    int i110 = i3 >> 9;
                    SurfaceKt.m4323SurfaceT9BRK9s(modifier7, shape4, color, contentColor, 0.0f, SnackbarTokens.INSTANCE.m5781getContainerElevationD9Ej5fM(), null, ComposableLambdaKt.rememberComposableLambda(-1343524879, true, new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SnackbarKt.Snackbar_eQBnUkQ$lambda$0(z10, function18, function4, function19, j18, j19, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 12779520 | (i110 & 112) | (i110 & 896) | (i110 & 7168), 80);
                    modifier2 = modifier7;
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape3 = shape4;
                    function7 = function5;
                    j6 = color;
                    j7 = contentColor;
                    j8 = actionContentColor;
                    z4 = z5;
                    j9 = dismissActionContentColor;
                    function8 = function9;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier2 = modifier;
                    function7 = function5;
                    function8 = function6;
                    z4 = z2;
                    shape3 = shape2;
                    j6 = j5;
                    j7 = j2;
                    j8 = j3;
                    j9 = j4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SnackbarKt.Snackbar_eQBnUkQ$lambda$1(modifier2, function7, function8, z4, shape3, j6, j7, j8, j9, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z2 = z;
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i14;
                } else {
                    shape2 = shape;
                }
                i3 |= i14;
            } else {
                shape2 = shape;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    j5 = j;
                    if (composerStartRestartGroup.changed(j5)) {
                    }
                    i3 |= i15;
                } else {
                    j5 = j;
                }
                i3 |= i15;
            } else {
                j5 = j;
            }
            if ((i & 1572864) != 0) {
                if ((i2 & 64) == 0) {
                    i11 = 524288;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
            if ((i & 12582912) != 0) {
                if ((i2 & 128) == 0) {
                    i10 = 4194304;
                } else {
                    i10 = 4194304;
                }
                i3 |= i10;
            }
            if ((100663296 & i) != 0) {
                if ((i2 & 256) == 0) {
                    i9 = 33554432;
                } else {
                    i9 = 33554432;
                }
                i3 |= i9;
            }
            if ((805306368 & i) != 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i8 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i8 = 268435456;
                }
                i3 |= i8;
            }
            if ((i3 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4967L5,105@5019L5,106@5069L12,107@5132L18,108@5208L25");
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i13 != 0) {
                        function5 = null;
                    }
                    if (i4 == 0) {
                    }
                    if (i6 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if ((i2 & 16) != 0) {
                        shape4 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        shape4 = shape2;
                    }
                    if ((i2 & 32) != 0) {
                        color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    } else {
                        color = j5;
                    }
                    if ((i2 & 64) != 0) {
                        contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        contentColor = j2;
                    }
                    if ((i2 & 128) != 0) {
                        actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        actionContentColor = j3;
                    }
                    if ((i2 & 256) != 0) {
                        dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -234881025;
                    } else {
                        dismissActionContentColor = j4;
                    }
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i13 != 0) {
                        function5 = null;
                    }
                    if (i4 == 0) {
                    }
                    if (i6 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if ((i2 & 16) != 0) {
                        shape4 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        shape4 = shape2;
                    }
                    if ((i2 & 32) != 0) {
                        color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    } else {
                        color = j5;
                    }
                    if ((i2 & 64) != 0) {
                        contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        contentColor = j2;
                    }
                    if ((i2 & 128) != 0) {
                        actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        actionContentColor = j3;
                    }
                    if ((i2 & 256) != 0) {
                        dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -234881025;
                    } else {
                        dismissActionContentColor = j4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1218779924, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:110)");
                }
                final Function2 function110 = function5;
                final long j110 = actionContentColor;
                final boolean z11 = z5;
                final long j111 = dismissActionContentColor;
                final Function2 function111 = function9;
                Modifier modifier8 = companion;
                int i111 = i3 >> 9;
                SurfaceKt.m4323SurfaceT9BRK9s(modifier8, shape4, color, contentColor, 0.0f, SnackbarTokens.INSTANCE.m5781getContainerElevationD9Ej5fM(), null, ComposableLambdaKt.rememberComposableLambda(-1343524879, true, new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SnackbarKt.Snackbar_eQBnUkQ$lambda$0(z11, function110, function4, function111, j110, j111, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 12779520 | (i111 & 112) | (i111 & 896) | (i111 & 7168), 80);
                modifier2 = modifier8;
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape3 = shape4;
                function7 = function5;
                j6 = color;
                j7 = contentColor;
                j8 = actionContentColor;
                z4 = z5;
                j9 = dismissActionContentColor;
                function8 = function9;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = modifier;
                function7 = function5;
                function8 = function6;
                z4 = z2;
                shape3 = shape2;
                j6 = j5;
                j7 = j2;
                j8 = j3;
                j9 = j4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SnackbarKt.Snackbar_eQBnUkQ$lambda$1(modifier2, function7, function8, z4, shape3, j6, j7, j8, j9, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        function6 = function3;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 3072) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i14;
                } else {
                    shape2 = shape;
                }
                i3 |= i14;
            } else {
                shape2 = shape;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    j5 = j;
                    if (composerStartRestartGroup.changed(j5)) {
                    }
                    i3 |= i15;
                } else {
                    j5 = j;
                }
                i3 |= i15;
            } else {
                j5 = j;
            }
            if ((i & 1572864) != 0) {
                if ((i2 & 64) == 0) {
                    i11 = 524288;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
            if ((i & 12582912) != 0) {
                if ((i2 & 128) == 0) {
                    i10 = 4194304;
                } else {
                    i10 = 4194304;
                }
                i3 |= i10;
            }
            if ((100663296 & i) != 0) {
                if ((i2 & 256) == 0) {
                    i9 = 33554432;
                } else {
                    i9 = 33554432;
                }
                i3 |= i9;
            }
            if ((805306368 & i) != 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i8 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i8 = 268435456;
                }
                i3 |= i8;
            }
            if ((i3 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "104@4967L5,105@5019L5,106@5069L12,107@5132L18,108@5208L25");
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i13 != 0) {
                        function5 = null;
                    }
                    if (i4 == 0) {
                    }
                    if (i6 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if ((i2 & 16) != 0) {
                        shape4 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        shape4 = shape2;
                    }
                    if ((i2 & 32) != 0) {
                        color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    } else {
                        color = j5;
                    }
                    if ((i2 & 64) != 0) {
                        contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        contentColor = j2;
                    }
                    if ((i2 & 128) != 0) {
                        actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        actionContentColor = j3;
                    }
                    if ((i2 & 256) != 0) {
                        dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -234881025;
                    } else {
                        dismissActionContentColor = j4;
                    }
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i13 != 0) {
                        function5 = null;
                    }
                    if (i4 == 0) {
                    }
                    if (i6 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if ((i2 & 16) != 0) {
                        shape4 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        shape4 = shape2;
                    }
                    if ((i2 & 32) != 0) {
                        color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    } else {
                        color = j5;
                    }
                    if ((i2 & 64) != 0) {
                        contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i3 &= -3670017;
                    } else {
                        contentColor = j2;
                    }
                    if ((i2 & 128) != 0) {
                        actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        actionContentColor = j3;
                    }
                    if ((i2 & 256) != 0) {
                        dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                        i3 &= -234881025;
                    } else {
                        dismissActionContentColor = j4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1218779924, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:110)");
                }
                final Function2 function112 = function5;
                final long j112 = actionContentColor;
                final boolean z12 = z5;
                final long j113 = dismissActionContentColor;
                final Function2 function113 = function9;
                Modifier modifier9 = companion;
                int i112 = i3 >> 9;
                SurfaceKt.m4323SurfaceT9BRK9s(modifier9, shape4, color, contentColor, 0.0f, SnackbarTokens.INSTANCE.m5781getContainerElevationD9Ej5fM(), null, ComposableLambdaKt.rememberComposableLambda(-1343524879, true, new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SnackbarKt.Snackbar_eQBnUkQ$lambda$0(z12, function112, function4, function113, j112, j113, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 12779520 | (i112 & 112) | (i112 & 896) | (i112 & 7168), 80);
                modifier2 = modifier9;
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape3 = shape4;
                function7 = function5;
                j6 = color;
                j7 = contentColor;
                j8 = actionContentColor;
                z4 = z5;
                j9 = dismissActionContentColor;
                function8 = function9;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = modifier;
                function7 = function5;
                function8 = function6;
                z4 = z2;
                shape3 = shape2;
                j6 = j5;
                j7 = j2;
                j8 = j3;
                j9 = j4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SnackbarKt.Snackbar_eQBnUkQ$lambda$1(modifier2, function7, function8, z4, shape3, j6, j7, j8, j9, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        z2 = z;
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i3 |= i14;
            } else {
                shape2 = shape;
            }
            i3 |= i14;
        } else {
            shape2 = shape;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                j5 = j;
                if (composerStartRestartGroup.changed(j5)) {
                }
                i3 |= i15;
            } else {
                j5 = j;
            }
            i3 |= i15;
        } else {
            j5 = j;
        }
        if ((i & 1572864) != 0) {
            if ((i2 & 64) == 0) {
                i11 = 524288;
            } else {
                i11 = 524288;
            }
            i3 |= i11;
        }
        if ((i & 12582912) != 0) {
            if ((i2 & 128) == 0) {
                i10 = 4194304;
            } else {
                i10 = 4194304;
            }
            i3 |= i10;
        }
        if ((100663296 & i) != 0) {
            if ((i2 & 256) == 0) {
                i9 = 33554432;
            } else {
                i9 = 33554432;
            }
            i3 |= i9;
        }
        if ((805306368 & i) != 0) {
            if (composerStartRestartGroup.changedInstance(function4)) {
                i8 = C.BUFFER_FLAG_LAST_SAMPLE;
            } else {
                i8 = 268435456;
            }
            i3 |= i8;
        }
        if ((i3 & 306783379) != 306783378) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "104@4967L5,105@5019L5,106@5069L12,107@5132L18,108@5208L25");
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i13 != 0) {
                    function5 = null;
                }
                if (i4 == 0) {
                }
                if (i6 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if ((i2 & 16) != 0) {
                    shape4 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    i3 &= -57345;
                } else {
                    shape4 = shape2;
                }
                if ((i2 & 32) != 0) {
                    color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                    i3 &= -458753;
                } else {
                    color = j5;
                }
                if ((i2 & 64) != 0) {
                    contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                    i3 &= -3670017;
                } else {
                    contentColor = j2;
                }
                if ((i2 & 128) != 0) {
                    actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                    i3 &= -29360129;
                } else {
                    actionContentColor = j3;
                }
                if ((i2 & 256) != 0) {
                    dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                    i3 &= -234881025;
                } else {
                    dismissActionContentColor = j4;
                }
            } else {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i13 != 0) {
                    function5 = null;
                }
                if (i4 == 0) {
                }
                if (i6 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if ((i2 & 16) != 0) {
                    shape4 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    i3 &= -57345;
                } else {
                    shape4 = shape2;
                }
                if ((i2 & 32) != 0) {
                    color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                    i3 &= -458753;
                } else {
                    color = j5;
                }
                if ((i2 & 64) != 0) {
                    contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                    i3 &= -3670017;
                } else {
                    contentColor = j2;
                }
                if ((i2 & 128) != 0) {
                    actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                    i3 &= -29360129;
                } else {
                    actionContentColor = j3;
                }
                if ((i2 & 256) != 0) {
                    dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                    i3 &= -234881025;
                } else {
                    dismissActionContentColor = j4;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1218779924, i3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:110)");
            }
            final Function2 function114 = function5;
            final long j114 = actionContentColor;
            final boolean z13 = z5;
            final long j115 = dismissActionContentColor;
            final Function2 function115 = function9;
            Modifier modifier10 = companion;
            int i113 = i3 >> 9;
            SurfaceKt.m4323SurfaceT9BRK9s(modifier10, shape4, color, contentColor, 0.0f, SnackbarTokens.INSTANCE.m5781getContainerElevationD9Ej5fM(), null, ComposableLambdaKt.rememberComposableLambda(-1343524879, true, new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SnackbarKt.Snackbar_eQBnUkQ$lambda$0(z13, function114, function4, function115, j114, j115, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 12779520 | (i113 & 112) | (i113 & 896) | (i113 & 7168), 80);
            modifier2 = modifier10;
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            shape3 = shape4;
            function7 = function5;
            j6 = color;
            j7 = contentColor;
            j8 = actionContentColor;
            z4 = z5;
            j9 = dismissActionContentColor;
            function8 = function9;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier2 = modifier;
            function7 = function5;
            function8 = function6;
            z4 = z2;
            shape3 = shape2;
            j6 = j5;
            j7 = j2;
            j8 = j3;
            j9 = j4;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SnackbarKt.Snackbar_eQBnUkQ$lambda$1(modifier2, function7, function8, z4, shape3, j6, j7, j8, j9, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Snackbar_eQBnUkQ$lambda$0(final boolean z, final Function2 function2, final Function2 function3, final Function2 function4, final long j, final long j2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C118@5537L5,119@5608L5,120@5682L912,120@5622L972:Snackbar.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1343524879, i, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:118)");
            }
            TextStyle value = TypographyKt.getValue(SnackbarTokens.INSTANCE.getSupportingTextFont(), composer, 6);
            final TextStyle value2 = TypographyKt.getValue(SnackbarTokens.INSTANCE.getActionLabelTextFont(), composer, 6);
            CompositionLocalKt.CompositionLocalProvider(TextKt.getLocalTextStyle().provides(value), ComposableLambdaKt.rememberComposableLambda(969655473, true, new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SnackbarKt.Snackbar_eQBnUkQ$lambda$0$0(z, function2, function3, function4, value2, j, j2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Snackbar_eQBnUkQ$lambda$0$0(boolean z, Function2 function2, Function2 function3, Function2 function4, TextStyle textStyle, long j, long j2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:Snackbar.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(969655473, i, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:121)");
            }
            if (z && function2 != null) {
                composer.startReplaceGroup(-168990288);
                ComposerKt.sourceInformation(composer, "123@5776L383");
                m4271NewLineButtonSnackbarkKq0p4A(function3, function2, function4, textStyle, j, j2, composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-168976609);
                ComposerKt.sourceInformation(composer, "132@6204L366");
                m4272OneRowSnackbarkKq0p4A(function3, function2, function4, textStyle, j, j2, composer, 0);
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

    /* JADX WARN: Code duplicated, block: B:102:0x011e  */
    /* JADX WARN: Code duplicated, block: B:104:0x0139  */
    /* JADX WARN: Code duplicated, block: B:126:0x0177 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:127:0x0179  */
    /* JADX WARN: Code duplicated, block: B:128:0x017e  */
    /* JADX WARN: Code duplicated, block: B:130:0x0181  */
    /* JADX WARN: Code duplicated, block: B:131:0x0184  */
    /* JADX WARN: Code duplicated, block: B:134:0x018b  */
    /* JADX WARN: Code duplicated, block: B:135:0x0194  */
    /* JADX WARN: Code duplicated, block: B:138:0x0199  */
    /* JADX WARN: Code duplicated, block: B:139:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:142:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:143:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:146:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:147:0x01be  */
    /* JADX WARN: Code duplicated, block: B:150:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:151:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:154:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:155:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:159:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:162:0x0214  */
    /* JADX WARN: Code duplicated, block: B:163:0x0233  */
    /* JADX WARN: Code duplicated, block: B:166:0x0248  */
    /* JADX WARN: Code duplicated, block: B:167:0x0266  */
    /* JADX WARN: Code duplicated, block: B:170:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:172:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:175:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:177:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:24:0x0047  */
    /* JADX WARN: Code duplicated, block: B:26:0x004b  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:29:0x0056  */
    /* JADX WARN: Code duplicated, block: B:34:0x0060  */
    /* JADX WARN: Code duplicated, block: B:36:0x0064  */
    /* JADX WARN: Code duplicated, block: B:38:0x006c  */
    /* JADX WARN: Code duplicated, block: B:39:0x006f  */
    /* JADX WARN: Code duplicated, block: B:42:0x0075  */
    /* JADX WARN: Code duplicated, block: B:45:0x007b  */
    /* JADX WARN: Code duplicated, block: B:47:0x007f  */
    /* JADX WARN: Code duplicated, block: B:49:0x0087  */
    /* JADX WARN: Code duplicated, block: B:50:0x008a  */
    /* JADX WARN: Code duplicated, block: B:53:0x0090  */
    /* JADX WARN: Code duplicated, block: B:56:0x0097  */
    /* JADX WARN: Code duplicated, block: B:58:0x009b  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:69:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:75:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:78:0x00da  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:90:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:93:0x0103  */
    /* JADX WARN: Code duplicated, block: B:95:0x0107  */
    /* JADX WARN: Code duplicated, block: B:98:0x0113  */
    /* JADX WARN: Code duplicated, block: B:99:0x0115  */
    /* JADX INFO: renamed from: Snackbar-sDKtq54, reason: not valid java name */
    public static final void m4274SnackbarsDKtq54(final SnackbarData snackbarData, Modifier modifier, boolean z, Shape shape, long j, long j2, long j3, long j4, long j5, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        Shape shape2;
        long j6;
        long j7;
        int i6;
        int i7;
        boolean z3;
        Composer composer2;
        final Modifier.Companion companion;
        final boolean z4;
        final Shape shape3;
        final long j8;
        final long j9;
        final long j10;
        final long j11;
        final long j12;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z5;
        Shape shape4;
        long color;
        long contentColor;
        final long actionColor;
        long actionContentColor;
        long dismissActionContentColor;
        boolean z6;
        final String actionLabel;
        ComposableLambda composableLambdaRememberComposableLambda;
        ComposableLambda composableLambda;
        int i8;
        int i9;
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(274621471);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Snackbar)N(snackbarData,modifier,actionOnNewLine,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,actionColor:c#ui.graphics.Color,actionContentColor:c#ui.graphics.Color,dismissActionContentColor:c#ui.graphics.Color)254@11656L38,244@11244L457:Snackbar.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(snackbarData) ? 4 : 2) | i;
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
                        int i12 = composerStartRestartGroup.changed(shape2) ? 2048 : 1024;
                        i3 |= i12;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i12;
                } else {
                    shape2 = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        j6 = j;
                        int i13 = composerStartRestartGroup.changed(j6) ? 16384 : 8192;
                        i3 |= i13;
                    } else {
                        j6 = j;
                    }
                    i3 |= i13;
                } else {
                    j6 = j;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        j7 = j2;
                        int i14 = composerStartRestartGroup.changed(j7) ? 131072 : 65536;
                        i3 |= i14;
                    } else {
                        j7 = j2;
                    }
                    i3 |= i14;
                } else {
                    j7 = j2;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        i10 = i3;
                        i7 = i11;
                        int i15 = composerStartRestartGroup.changed(j3) ? 1048576 : 524288;
                        i6 = i10 | i15;
                    } else {
                        i10 = i3;
                        i7 = i11;
                    }
                    i6 = i10 | i15;
                } else {
                    i6 = i3;
                    i7 = i11;
                }
                if ((i & 12582912) != 0) {
                    if ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j4)) {
                        i9 = 4194304;
                    } else {
                        i9 = 8388608;
                    }
                    i6 |= i9;
                }
                if ((100663296 & i) != 0) {
                    if ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j5)) {
                        i8 = 33554432;
                    } else {
                        i8 = 67108864;
                    }
                    i6 |= i8;
                }
                if ((38347923 & i6) != 38347922) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i6 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "201@9494L5,202@9546L5,203@9596L12,204@9652L11,205@9714L18,206@9790L25");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i7 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if ((i2 & 8) != 0) {
                            shape4 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i6 &= -7169;
                        } else {
                            shape4 = shape2;
                        }
                        if ((i2 & 16) != 0) {
                            color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                            i6 &= -57345;
                        } else {
                            color = j6;
                        }
                        if ((i2 & 32) != 0) {
                            contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                            i6 &= -458753;
                        } else {
                            contentColor = j7;
                        }
                        if ((i2 & 64) != 0) {
                            actionColor = SnackbarDefaults.INSTANCE.getActionColor(composerStartRestartGroup, 6);
                            i6 &= -3670017;
                        } else {
                            actionColor = j3;
                        }
                        if ((i2 & 128) != 0) {
                            actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                            i6 &= -29360129;
                        } else {
                            actionContentColor = j4;
                        }
                        if ((i2 & 256) != 0) {
                            i6 &= -234881025;
                            dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                        } else {
                            dismissActionContentColor = j5;
                        }
                        z6 = z5;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i6 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i6 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i6 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            i6 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            i6 &= -29360129;
                        }
                        if ((i2 & 256) != 0) {
                            i6 &= -234881025;
                        }
                        actionContentColor = j4;
                        dismissActionContentColor = j5;
                        companion = modifier2;
                        z6 = z2;
                        shape4 = shape2;
                        color = j6;
                        contentColor = j7;
                        actionColor = j3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(274621471, i6, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:207)");
                    }
                    actionLabel = snackbarData.getVisuals().getActionLabel();
                    composableLambdaRememberComposableLambda = null;
                    if (actionLabel != null) {
                        composerStartRestartGroup.startReplaceGroup(-663827885);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "211@9989L268");
                        ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1378313599, true, new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SnackbarKt.Snackbar_sDKtq54$lambda$0(actionColor, snackbarData, actionLabel, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        composerStartRestartGroup.endReplaceGroup();
                        composableLambda = composableLambdaRememberComposableLambda2;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-663528921);
                        composerStartRestartGroup.endReplaceGroup();
                        composableLambda = null;
                    }
                    if (snackbarData.getVisuals().getWithDismissAction()) {
                        composerStartRestartGroup.startReplaceGroup(-663364435);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "223@10441L754");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1812633777, true, new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SnackbarKt.Snackbar_sDKtq54$lambda$1(snackbarData, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-662598425);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    int i16 = i6 << 3;
                    composer2 = composerStartRestartGroup;
                    m4273SnackbareQBnUkQ(PaddingKt.m1218padding3ABfNKs(companion, Dp.m9687constructorimpl(12)), composableLambda, composableLambdaRememberComposableLambda, z6, shape4, color, contentColor, actionContentColor, dismissActionContentColor, ComposableLambdaKt.rememberComposableLambda(-1266389126, true, new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SnackbarKt.Snackbar_sDKtq54$lambda$2(snackbarData, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (i16 & 3670016) | (i16 & 7168) | 805306368 | (57344 & i16) | (458752 & i16) | (29360128 & i6) | (234881024 & i6), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j10 = actionColor;
                    z4 = z6;
                    shape3 = shape4;
                    j8 = color;
                    j9 = contentColor;
                    j11 = actionContentColor;
                    j12 = dismissActionContentColor;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    companion = modifier2;
                    z4 = z2;
                    shape3 = shape2;
                    j8 = j6;
                    j9 = j7;
                    j10 = j3;
                    j11 = j4;
                    j12 = j5;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SnackbarKt.Snackbar_sDKtq54$lambda$3(snackbarData, companion, z4, shape3, j8, j9, j10, j11, j12, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                    i3 |= i12;
                } else {
                    shape2 = shape;
                }
                i3 |= i12;
            } else {
                shape2 = shape;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    j6 = j;
                    if (composerStartRestartGroup.changed(j6)) {
                    }
                    i3 |= i13;
                } else {
                    j6 = j;
                }
                i3 |= i13;
            } else {
                j6 = j;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    j7 = j2;
                    if (composerStartRestartGroup.changed(j7)) {
                    }
                    i3 |= i14;
                } else {
                    j7 = j2;
                }
                i3 |= i14;
            } else {
                j7 = j2;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    i10 = i3;
                    i7 = i11;
                    if (composerStartRestartGroup.changed(j3)) {
                    }
                    i6 = i10 | i15;
                } else {
                    i10 = i3;
                    i7 = i11;
                }
                i6 = i10 | i15;
            } else {
                i6 = i3;
                i7 = i11;
            }
            if ((i & 12582912) != 0) {
                if ((i2 & 128) == 0) {
                    i9 = 4194304;
                } else {
                    i9 = 4194304;
                }
                i6 |= i9;
            }
            if ((100663296 & i) != 0) {
                if ((i2 & 256) == 0) {
                    i8 = 33554432;
                } else {
                    i8 = 33554432;
                }
                i6 |= i8;
            }
            if ((38347923 & i6) != 38347922) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i6 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "201@9494L5,202@9546L5,203@9596L12,204@9652L11,205@9714L18,206@9790L25");
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if ((i2 & 8) != 0) {
                        shape4 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i6 &= -7169;
                    } else {
                        shape4 = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                        i6 &= -57345;
                    } else {
                        color = j6;
                    }
                    if ((i2 & 32) != 0) {
                        contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i6 &= -458753;
                    } else {
                        contentColor = j7;
                    }
                    if ((i2 & 64) != 0) {
                        actionColor = SnackbarDefaults.INSTANCE.getActionColor(composerStartRestartGroup, 6);
                        i6 &= -3670017;
                    } else {
                        actionColor = j3;
                    }
                    if ((i2 & 128) != 0) {
                        actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                        i6 &= -29360129;
                    } else {
                        actionContentColor = j4;
                    }
                    if ((i2 & 256) != 0) {
                        i6 &= -234881025;
                        dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                    } else {
                        dismissActionContentColor = j5;
                    }
                    z6 = z5;
                } else {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if ((i2 & 8) != 0) {
                        shape4 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i6 &= -7169;
                    } else {
                        shape4 = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                        i6 &= -57345;
                    } else {
                        color = j6;
                    }
                    if ((i2 & 32) != 0) {
                        contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i6 &= -458753;
                    } else {
                        contentColor = j7;
                    }
                    if ((i2 & 64) != 0) {
                        actionColor = SnackbarDefaults.INSTANCE.getActionColor(composerStartRestartGroup, 6);
                        i6 &= -3670017;
                    } else {
                        actionColor = j3;
                    }
                    if ((i2 & 128) != 0) {
                        actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                        i6 &= -29360129;
                    } else {
                        actionContentColor = j4;
                    }
                    if ((i2 & 256) != 0) {
                        i6 &= -234881025;
                        dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                    } else {
                        dismissActionContentColor = j5;
                    }
                    z6 = z5;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(274621471, i6, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:207)");
                }
                actionLabel = snackbarData.getVisuals().getActionLabel();
                composableLambdaRememberComposableLambda = null;
                if (actionLabel != null) {
                    composerStartRestartGroup.startReplaceGroup(-663827885);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "211@9989L268");
                    ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1378313599, true, new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SnackbarKt.Snackbar_sDKtq54$lambda$0(actionColor, snackbarData, actionLabel, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    composerStartRestartGroup.endReplaceGroup();
                    composableLambda = composableLambdaRememberComposableLambda3;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-663528921);
                    composerStartRestartGroup.endReplaceGroup();
                    composableLambda = null;
                }
                if (snackbarData.getVisuals().getWithDismissAction()) {
                    composerStartRestartGroup.startReplaceGroup(-663364435);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "223@10441L754");
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1812633777, true, new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SnackbarKt.Snackbar_sDKtq54$lambda$1(snackbarData, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-662598425);
                    composerStartRestartGroup.endReplaceGroup();
                }
                int i17 = i6 << 3;
                composer2 = composerStartRestartGroup;
                m4273SnackbareQBnUkQ(PaddingKt.m1218padding3ABfNKs(companion, Dp.m9687constructorimpl(12)), composableLambda, composableLambdaRememberComposableLambda, z6, shape4, color, contentColor, actionContentColor, dismissActionContentColor, ComposableLambdaKt.rememberComposableLambda(-1266389126, true, new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SnackbarKt.Snackbar_sDKtq54$lambda$2(snackbarData, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, (i17 & 3670016) | (i17 & 7168) | 805306368 | (57344 & i17) | (458752 & i17) | (29360128 & i6) | (234881024 & i6), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j10 = actionColor;
                z4 = z6;
                shape3 = shape4;
                j8 = color;
                j9 = contentColor;
                j11 = actionContentColor;
                j12 = dismissActionContentColor;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                companion = modifier2;
                z4 = z2;
                shape3 = shape2;
                j8 = j6;
                j9 = j7;
                j10 = j3;
                j11 = j4;
                j12 = j5;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SnackbarKt.Snackbar_sDKtq54$lambda$3(snackbarData, companion, z4, shape3, j8, j9, j10, j11, j12, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i12;
                } else {
                    shape2 = shape;
                }
                i3 |= i12;
            } else {
                shape2 = shape;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    j6 = j;
                    if (composerStartRestartGroup.changed(j6)) {
                    }
                    i3 |= i13;
                } else {
                    j6 = j;
                }
                i3 |= i13;
            } else {
                j6 = j;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    j7 = j2;
                    if (composerStartRestartGroup.changed(j7)) {
                    }
                    i3 |= i14;
                } else {
                    j7 = j2;
                }
                i3 |= i14;
            } else {
                j7 = j2;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    i10 = i3;
                    i7 = i11;
                    if (composerStartRestartGroup.changed(j3)) {
                    }
                    i6 = i10 | i15;
                } else {
                    i10 = i3;
                    i7 = i11;
                }
                i6 = i10 | i15;
            } else {
                i6 = i3;
                i7 = i11;
            }
            if ((i & 12582912) != 0) {
                if ((i2 & 128) == 0) {
                    i9 = 4194304;
                } else {
                    i9 = 4194304;
                }
                i6 |= i9;
            }
            if ((100663296 & i) != 0) {
                if ((i2 & 256) == 0) {
                    i8 = 33554432;
                } else {
                    i8 = 33554432;
                }
                i6 |= i8;
            }
            if ((38347923 & i6) != 38347922) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i6 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "201@9494L5,202@9546L5,203@9596L12,204@9652L11,205@9714L18,206@9790L25");
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if ((i2 & 8) != 0) {
                        shape4 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i6 &= -7169;
                    } else {
                        shape4 = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                        i6 &= -57345;
                    } else {
                        color = j6;
                    }
                    if ((i2 & 32) != 0) {
                        contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i6 &= -458753;
                    } else {
                        contentColor = j7;
                    }
                    if ((i2 & 64) != 0) {
                        actionColor = SnackbarDefaults.INSTANCE.getActionColor(composerStartRestartGroup, 6);
                        i6 &= -3670017;
                    } else {
                        actionColor = j3;
                    }
                    if ((i2 & 128) != 0) {
                        actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                        i6 &= -29360129;
                    } else {
                        actionContentColor = j4;
                    }
                    if ((i2 & 256) != 0) {
                        i6 &= -234881025;
                        dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                    } else {
                        dismissActionContentColor = j5;
                    }
                    z6 = z5;
                } else {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if ((i2 & 8) != 0) {
                        shape4 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i6 &= -7169;
                    } else {
                        shape4 = shape2;
                    }
                    if ((i2 & 16) != 0) {
                        color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                        i6 &= -57345;
                    } else {
                        color = j6;
                    }
                    if ((i2 & 32) != 0) {
                        contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                        i6 &= -458753;
                    } else {
                        contentColor = j7;
                    }
                    if ((i2 & 64) != 0) {
                        actionColor = SnackbarDefaults.INSTANCE.getActionColor(composerStartRestartGroup, 6);
                        i6 &= -3670017;
                    } else {
                        actionColor = j3;
                    }
                    if ((i2 & 128) != 0) {
                        actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                        i6 &= -29360129;
                    } else {
                        actionContentColor = j4;
                    }
                    if ((i2 & 256) != 0) {
                        i6 &= -234881025;
                        dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                    } else {
                        dismissActionContentColor = j5;
                    }
                    z6 = z5;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(274621471, i6, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:207)");
                }
                actionLabel = snackbarData.getVisuals().getActionLabel();
                composableLambdaRememberComposableLambda = null;
                if (actionLabel != null) {
                    composerStartRestartGroup.startReplaceGroup(-663827885);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "211@9989L268");
                    ComposableLambda composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(-1378313599, true, new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SnackbarKt.Snackbar_sDKtq54$lambda$0(actionColor, snackbarData, actionLabel, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    composerStartRestartGroup.endReplaceGroup();
                    composableLambda = composableLambdaRememberComposableLambda4;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-663528921);
                    composerStartRestartGroup.endReplaceGroup();
                    composableLambda = null;
                }
                if (snackbarData.getVisuals().getWithDismissAction()) {
                    composerStartRestartGroup.startReplaceGroup(-663364435);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "223@10441L754");
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1812633777, true, new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SnackbarKt.Snackbar_sDKtq54$lambda$1(snackbarData, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-662598425);
                    composerStartRestartGroup.endReplaceGroup();
                }
                int i18 = i6 << 3;
                composer2 = composerStartRestartGroup;
                m4273SnackbareQBnUkQ(PaddingKt.m1218padding3ABfNKs(companion, Dp.m9687constructorimpl(12)), composableLambda, composableLambdaRememberComposableLambda, z6, shape4, color, contentColor, actionContentColor, dismissActionContentColor, ComposableLambdaKt.rememberComposableLambda(-1266389126, true, new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SnackbarKt.Snackbar_sDKtq54$lambda$2(snackbarData, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, (i18 & 3670016) | (i18 & 7168) | 805306368 | (57344 & i18) | (458752 & i18) | (29360128 & i6) | (234881024 & i6), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j10 = actionColor;
                z4 = z6;
                shape3 = shape4;
                j8 = color;
                j9 = contentColor;
                j11 = actionContentColor;
                j12 = dismissActionContentColor;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                companion = modifier2;
                z4 = z2;
                shape3 = shape2;
                j8 = j6;
                j9 = j7;
                j10 = j3;
                j11 = j4;
                j12 = j5;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SnackbarKt.Snackbar_sDKtq54$lambda$3(snackbarData, companion, z4, shape3, j8, j9, j10, j11, j12, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                i3 |= i12;
            } else {
                shape2 = shape;
            }
            i3 |= i12;
        } else {
            shape2 = shape;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                j6 = j;
                if (composerStartRestartGroup.changed(j6)) {
                }
                i3 |= i13;
            } else {
                j6 = j;
            }
            i3 |= i13;
        } else {
            j6 = j;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                j7 = j2;
                if (composerStartRestartGroup.changed(j7)) {
                }
                i3 |= i14;
            } else {
                j7 = j2;
            }
            i3 |= i14;
        } else {
            j7 = j2;
        }
        if ((1572864 & i) == 0) {
            if ((i2 & 64) == 0) {
                i10 = i3;
                i7 = i11;
                if (composerStartRestartGroup.changed(j3)) {
                }
                i6 = i10 | i15;
            } else {
                i10 = i3;
                i7 = i11;
            }
            i6 = i10 | i15;
        } else {
            i6 = i3;
            i7 = i11;
        }
        if ((i & 12582912) != 0) {
            if ((i2 & 128) == 0) {
                i9 = 4194304;
            } else {
                i9 = 4194304;
            }
            i6 |= i9;
        }
        if ((100663296 & i) != 0) {
            if ((i2 & 256) == 0) {
                i8 = 33554432;
            } else {
                i8 = 33554432;
            }
            i6 |= i8;
        }
        if ((38347923 & i6) != 38347922) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i6 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "201@9494L5,202@9546L5,203@9596L12,204@9652L11,205@9714L18,206@9790L25");
            if ((i & 1) != 0) {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if ((i2 & 8) != 0) {
                    shape4 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    i6 &= -7169;
                } else {
                    shape4 = shape2;
                }
                if ((i2 & 16) != 0) {
                    color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                    i6 &= -57345;
                } else {
                    color = j6;
                }
                if ((i2 & 32) != 0) {
                    contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                    i6 &= -458753;
                } else {
                    contentColor = j7;
                }
                if ((i2 & 64) != 0) {
                    actionColor = SnackbarDefaults.INSTANCE.getActionColor(composerStartRestartGroup, 6);
                    i6 &= -3670017;
                } else {
                    actionColor = j3;
                }
                if ((i2 & 128) != 0) {
                    actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                    i6 &= -29360129;
                } else {
                    actionContentColor = j4;
                }
                if ((i2 & 256) != 0) {
                    i6 &= -234881025;
                    dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                } else {
                    dismissActionContentColor = j5;
                }
                z6 = z5;
            } else {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if ((i2 & 8) != 0) {
                    shape4 = SnackbarDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    i6 &= -7169;
                } else {
                    shape4 = shape2;
                }
                if ((i2 & 16) != 0) {
                    color = SnackbarDefaults.INSTANCE.getColor(composerStartRestartGroup, 6);
                    i6 &= -57345;
                } else {
                    color = j6;
                }
                if ((i2 & 32) != 0) {
                    contentColor = SnackbarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                    i6 &= -458753;
                } else {
                    contentColor = j7;
                }
                if ((i2 & 64) != 0) {
                    actionColor = SnackbarDefaults.INSTANCE.getActionColor(composerStartRestartGroup, 6);
                    i6 &= -3670017;
                } else {
                    actionColor = j3;
                }
                if ((i2 & 128) != 0) {
                    actionContentColor = SnackbarDefaults.INSTANCE.getActionContentColor(composerStartRestartGroup, 6);
                    i6 &= -29360129;
                } else {
                    actionContentColor = j4;
                }
                if ((i2 & 256) != 0) {
                    i6 &= -234881025;
                    dismissActionContentColor = SnackbarDefaults.INSTANCE.getDismissActionContentColor(composerStartRestartGroup, 6);
                } else {
                    dismissActionContentColor = j5;
                }
                z6 = z5;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(274621471, i6, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:207)");
            }
            actionLabel = snackbarData.getVisuals().getActionLabel();
            composableLambdaRememberComposableLambda = null;
            if (actionLabel != null) {
                composerStartRestartGroup.startReplaceGroup(-663827885);
                ComposerKt.sourceInformation(composerStartRestartGroup, "211@9989L268");
                ComposableLambda composableLambdaRememberComposableLambda5 = ComposableLambdaKt.rememberComposableLambda(-1378313599, true, new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SnackbarKt.Snackbar_sDKtq54$lambda$0(actionColor, snackbarData, actionLabel, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                composerStartRestartGroup.endReplaceGroup();
                composableLambda = composableLambdaRememberComposableLambda5;
            } else {
                composerStartRestartGroup.startReplaceGroup(-663528921);
                composerStartRestartGroup.endReplaceGroup();
                composableLambda = null;
            }
            if (snackbarData.getVisuals().getWithDismissAction()) {
                composerStartRestartGroup.startReplaceGroup(-663364435);
                ComposerKt.sourceInformation(composerStartRestartGroup, "223@10441L754");
                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1812633777, true, new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SnackbarKt.Snackbar_sDKtq54$lambda$1(snackbarData, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-662598425);
                composerStartRestartGroup.endReplaceGroup();
            }
            int i19 = i6 << 3;
            composer2 = composerStartRestartGroup;
            m4273SnackbareQBnUkQ(PaddingKt.m1218padding3ABfNKs(companion, Dp.m9687constructorimpl(12)), composableLambda, composableLambdaRememberComposableLambda, z6, shape4, color, contentColor, actionContentColor, dismissActionContentColor, ComposableLambdaKt.rememberComposableLambda(-1266389126, true, new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SnackbarKt.Snackbar_sDKtq54$lambda$2(snackbarData, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, (i19 & 3670016) | (i19 & 7168) | 805306368 | (57344 & i19) | (458752 & i19) | (29360128 & i6) | (234881024 & i6), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j10 = actionColor;
            z4 = z6;
            shape3 = shape4;
            j8 = color;
            j9 = contentColor;
            j11 = actionContentColor;
            j12 = dismissActionContentColor;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            companion = modifier2;
            z4 = z2;
            shape3 = shape2;
            j8 = j6;
            j9 = j7;
            j10 = j3;
            j11 = j4;
            j12 = j5;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SnackbarKt.Snackbar_sDKtq54$lambda$3(snackbarData, companion, z4, shape3, j8, j9, j10, j11, j12, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Snackbar_sDKtq54$lambda$0(long j, final SnackbarData snackbarData, final String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C213@10063L44,214@10139L32,215@10203L21,212@10007L236:Snackbar.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1378313599, i, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:212)");
            }
            ButtonColors buttonColorsM2878textButtonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2878textButtonColorsro_MJ88(0L, j, 0L, 0L, composer, 24576, 13);
            ComposerKt.sourceInformationMarkerStart(composer, -1709436639, "CC(remember):Snackbar.kt#9igjgp");
            boolean zChanged = composer.changed(snackbarData);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SnackbarKt.Snackbar_sDKtq54$lambda$0$0$0(snackbarData);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ButtonKt.TextButton((Function0<Unit>) objRememberedValue, (Modifier) null, false, (Shape) null, buttonColorsM2878textButtonColorsro_MJ88, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(521110564, true, new Function3() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SnackbarKt.Snackbar_sDKtq54$lambda$0$1(str, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 805306368, 494);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Snackbar_sDKtq54$lambda$0$0$0(SnackbarData snackbarData) {
        snackbarData.performAction();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Snackbar_sDKtq54$lambda$0$1(String str, RowScope rowScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C215@10205L17:Snackbar.kt#uh7d8r");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(521110564, i, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:215)");
            }
            TextKt.m4494TextNvy7gAk(str, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Snackbar_sDKtq54$lambda$1(final SnackbarData snackbarData, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C224@10484L34,227@10626L114,230@10772L45,231@10847L22,232@10889L292,225@10535L646:Snackbar.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1812633777, i, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:224)");
            }
            Strings.Companion companion = Strings.INSTANCE;
            final String strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_snackbar_dismiss), composer, 0);
            TooltipKt.TooltipBox(TooltipDefaults.INSTANCE.m4738rememberTooltipPositionProviderHu5FAss(TooltipAnchorPosition.INSTANCE.m4725getAbovelOKsHw4(), 0.0f, composer, 390, 2), ComposableLambdaKt.rememberComposableLambda(1030267332, true, new Function3() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SnackbarKt.Snackbar_sDKtq54$lambda$1$0(strM5086getString2EP1pXo, (TooltipScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), TooltipKt.rememberTooltipState(false, false, null, composer, 0, 7), null, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(1926608556, true, new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SnackbarKt.Snackbar_sDKtq54$lambda$1$1(snackbarData, strM5086getString2EP1pXo, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 100663344, 248);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Snackbar_sDKtq54$lambda$1$0(final String str, TooltipScope tooltipScope, Composer composer, int i) {
        int i2;
        ComposerKt.sourceInformation(composer, "C230@10787L28,230@10774L41:Snackbar.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = i | ((i & 8) == 0 ? composer.changed(tooltipScope) : composer.changedInstance(tooltipScope) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1030267332, i2, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:230)");
            }
            TooltipKt.m4746PlainTooltipgv3ox5I(tooltipScope, null, null, 0.0f, null, 0L, 0L, 0.0f, 0.0f, ComposableLambdaKt.rememberComposableLambda(-132223210, true, new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SnackbarKt.Snackbar_sDKtq54$lambda$1$0$0(str, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, (i2 & 14) | 805306368, 255);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Snackbar_sDKtq54$lambda$1$0$0(String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C230@10789L24:Snackbar.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-132223210, i, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous>.<anonymous> (Snackbar.kt:230)");
            }
            TextKt.m4494TextNvy7gAk(str, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Snackbar_sDKtq54$lambda$1$1(final SnackbarData snackbarData, final String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C234@10957L26,235@11019L121,233@10911L252:Snackbar.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1926608556, i, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:233)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 339919942, "CC(remember):Snackbar.kt#9igjgp");
            boolean zChanged = composer.changed(snackbarData);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SnackbarKt.Snackbar_sDKtq54$lambda$1$1$0$0(snackbarData);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton((Function0<Unit>) objRememberedValue, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(1306131274, true, new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SnackbarKt.Snackbar_sDKtq54$lambda$1$1$1(str, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 1572864, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Snackbar_sDKtq54$lambda$1$1$0$0(SnackbarData snackbarData) {
        snackbarData.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Snackbar_sDKtq54$lambda$1$1$1(String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C236@11049L65:Snackbar.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1306131274, i, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous>.<anonymous> (Snackbar.kt:236)");
            }
            IconKt.m3576Iconww6aTOc(Icons.Filled.INSTANCE.getClose$material3(), str, (Modifier) null, 0L, composer, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Snackbar_sDKtq54$lambda$2(SnackbarData snackbarData, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C254@11658L34:Snackbar.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1266389126, i, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:254)");
            }
            TextKt.m4494TextNvy7gAk(snackbarData.getVisuals().getMessage(), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: NewLineButtonSnackbar-kKq0p4A, reason: not valid java name */
    private static final void m4271NewLineButtonSnackbarkKq0p4A(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function4, final TextStyle textStyle, final long j, final long j2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-264666338);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NewLineButtonSnackbar)N(text,action,dismissAction,actionTextStyle,actionContentColor:c#ui.graphics.Color,dismissActionContentColor:c#ui.graphics.Color)267@11977L1177:Snackbar.kt#uh7d8r");
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
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(textStyle) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(j2) ? 131072 : 65536;
        }
        if (!composerStartRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-264666338, i2, -1, "androidx.compose.material3.NewLineButtonSnackbar (Snackbar.kt:266)");
            }
            Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(SizeKt.m1273widthInVpY3zN4$default(Modifier.INSTANCE, 0.0f, ContainerMaxWidth, 1, null), 0.0f, 1, null), HorizontalSpacing, 0.0f, 0.0f, SeparateButtonExtraY, 6, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1222paddingqDBjuR0$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i3 = i2;
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1768435799, "C275@12266L191,282@12467L681:Snackbar.kt#uh7d8r");
            Modifier modifierM1043paddingFromBaselineVpY3zN4 = AlignmentLineKt.m1043paddingFromBaselineVpY3zN4(Modifier.INSTANCE, HeightToFirstLine, LongButtonVerticalOffset);
            float fM9687constructorimpl = HorizontalSpacingButtonSide;
            Modifier modifierM1222paddingqDBjuR0$default2 = PaddingKt.m1222paddingqDBjuR0$default(modifierM1043paddingFromBaselineVpY3zN4, 0.0f, 0.0f, fM9687constructorimpl, 0.0f, 11, null);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1846600805, "C279@12441L6:Snackbar.kt#uh7d8r");
            function2.invoke(composerStartRestartGroup, Integer.valueOf(i3 & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierAlign = columnScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getEnd());
            if (function4 != null) {
                fM9687constructorimpl = Dp.m9687constructorimpl(0);
            }
            Modifier modifierM1222paddingqDBjuR0$default3 = PaddingKt.m1222paddingqDBjuR0$default(modifierAlign, 0.0f, 0.0f, fM9687constructorimpl, 0.0f, 11, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1222paddingqDBjuR0$default3);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1104195777, "C286@12635L503:Snackbar.kt#uh7d8r");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor4);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl4 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                composerM6062constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                composerM6062constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 916026697, "C287@12657L209:Snackbar.kt#uh7d8r");
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j)), TextKt.getLocalTextStyle().provides(textStyle)}, function3, composerStartRestartGroup, ProvidedValue.$stable | (i3 & 112));
            if (function4 != null) {
                composerStartRestartGroup.startReplaceGroup(916269829);
                ComposerKt.sourceInformation(composerStartRestartGroup, "293@12932L174");
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j2)), function4, composerStartRestartGroup, ProvidedValue.$stable | ((i3 >> 3) & 112));
            } else {
                composerStartRestartGroup.startReplaceGroup(903455483);
            }
            composerStartRestartGroup.endReplaceGroup();
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SnackbarKt.NewLineButtonSnackbar_kKq0p4A$lambda$1(function2, function3, function4, textStyle, j, j2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: OneRowSnackbar-kKq0p4A, reason: not valid java name */
    private static final void m4272OneRowSnackbarkKq0p4A(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function4, final TextStyle textStyle, final long j, final long j2, Composer composer, final int i) {
        int i2;
        float fM9687constructorimpl;
        Composer composerStartRestartGroup = composer.startRestartGroup(-931325388);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OneRowSnackbar)N(text,action,dismissAction,actionTextStyle,actionTextColor:c#ui.graphics.Color,dismissActionColor:c#ui.graphics.Color)341@14523L3580,315@13513L4590:Snackbar.kt#uh7d8r");
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
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(textStyle) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(j2) ? 131072 : 65536;
        }
        if (!composerStartRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-931325388, i2, -1, "androidx.compose.material3.OneRowSnackbar (Snackbar.kt:311)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f = HorizontalSpacing;
            if (function4 == null) {
                fM9687constructorimpl = HorizontalSpacingButtonSide;
            } else {
                fM9687constructorimpl = Dp.m9687constructorimpl(0);
            }
            Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(companion, f, 0.0f, fM9687constructorimpl, 0.0f, 10, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1650453680, "CC(remember):Snackbar.kt#9igjgp");
            SnackbarKt$OneRowSnackbar$2$1 snackbarKt$OneRowSnackbar$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            int i3 = i2;
            if (snackbarKt$OneRowSnackbar$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                snackbarKt$OneRowSnackbar$2$1RememberedValue = new SnackbarKt$OneRowSnackbar$2$1(Analytics.Data.ACTION, "dismissAction", "text");
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1014272487, "C317@13543L86:Snackbar.kt#uh7d8r");
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1416883884, "C317@13621L6:Snackbar.kt#uh7d8r");
            function2.invoke(composerStartRestartGroup, Integer.valueOf(i3 & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (function3 != null) {
                composerStartRestartGroup.startReplaceGroup(-1014168049);
                ComposerKt.sourceInformation(composerStartRestartGroup, "319@13680L296");
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 124234777, "C320@13736L222:Snackbar.kt#uh7d8r");
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j)), TextKt.getLocalTextStyle().provides(textStyle)}, function3, composerStartRestartGroup, ProvidedValue.$stable | (i3 & 112));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1027731913);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (function4 != null) {
                composerStartRestartGroup.startReplaceGroup(-1013804481);
                ComposerKt.sourceInformation(composerStartRestartGroup, "328@14048L248");
                Modifier modifierLayoutId2 = LayoutIdKt.layoutId(Modifier.INSTANCE, "dismissAction");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierLayoutId2);
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor4);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM6062constructorimpl4 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM6062constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                    composerM6062constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    composerM6062constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -339190631, "C329@14111L167:Snackbar.kt#uh7d8r");
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j2)), function4, composerStartRestartGroup, ProvidedValue.$stable | ((i3 >> 3) & 112));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1027731913);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SnackbarKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SnackbarKt.OneRowSnackbar_kKq0p4A$lambda$2(function2, function3, function4, textStyle, j, j2, i, (Composer) obj, ((Integer) obj2).intValue());
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
