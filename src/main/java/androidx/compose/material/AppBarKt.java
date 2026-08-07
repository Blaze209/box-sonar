package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppBar.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\u001a\u0089\u0001\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0004¢\u0006\u0002\b\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0081\u0001\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0004¢\u0006\u0002\b\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001ag\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0004¢\u0006\u0002\b\rH\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a_\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0004¢\u0006\u0002\b\rH\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001as\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0004¢\u0006\u0002\b\rH\u0007¢\u0006\u0004\b!\u0010\"\u001ak\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0004¢\u0006\u0002\b\rH\u0007¢\u0006\u0004\b#\u0010$\u001a\u0011\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0082\b\u001a\u0019\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020&H\u0080\b\u001a,\u0010+\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&0,2\u0006\u0010-\u001a\u00020&2\u0006\u0010*\u001a\u00020&2\u0006\u0010.\u001a\u00020&H\u0000\u001ag\u0010/\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u00100\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0004¢\u0006\u0002\b\rH\u0003¢\u0006\u0004\b1\u00102\"\u0010\u00103\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u00104\"\u0010\u00105\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u00104\"\u000e\u00106\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u00107\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u00108\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u00104\"\u0010\u00109\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u00104\"\u000e\u0010:\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"TopAppBar", "", "title", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "modifier", "Landroidx/compose/ui/Modifier;", "navigationIcon", "actions", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "Landroidx/compose/ui/unit/Dp;", "TopAppBar-Rx1qByU", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;JJFLandroidx/compose/runtime/Composer;II)V", "TopAppBar-xWeB9-s", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;JJFLandroidx/compose/runtime/Composer;II)V", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "content", "TopAppBar-afqeVBk", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TopAppBar-HsRjFd4", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBar", "cutoutShape", "Landroidx/compose/ui/graphics/Shape;", "BottomAppBar-DanWW-k", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/graphics/Shape;FLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBar-Y1yfwus", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/graphics/Shape;FLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "square", "", "x", "calculateCutoutCircleYIntercept", "cutoutRadius", "verticalOffset", "calculateRoundedEdgeIntercept", "Lkotlin/Pair;", "controlPointX", "radius", "AppBar", "shape", "AppBar-HkEspTQ", "(JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "AppBarHeight", "F", "AppBarHorizontalPadding", "TitleInsetWithoutIcon", "TitleIconModifier", "BottomAppBarCutoutOffset", "BottomAppBarRoundedEdgeRadius", "ZeroInsets", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AppBarKt {
    private static final float AppBarHeight = Dp.m9687constructorimpl(56);
    private static final float AppBarHorizontalPadding;
    private static final float BottomAppBarCutoutOffset;
    private static final float BottomAppBarRoundedEdgeRadius;
    private static final Modifier TitleIconModifier;
    private static final Modifier TitleInsetWithoutIcon;
    private static final WindowInsets ZeroInsets;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppBar_HkEspTQ$lambda$1(long j, long j2, float f, PaddingValues paddingValues, Shape shape, WindowInsets windowInsets, Modifier modifier, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2251AppBarHkEspTQ(j, j2, f, paddingValues, shape, windowInsets, modifier, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomAppBar_DanWW_k$lambda$0(WindowInsets windowInsets, Modifier modifier, long j, long j2, Shape shape, float f, PaddingValues paddingValues, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2252BottomAppBarDanWWk(windowInsets, modifier, j, j2, shape, f, paddingValues, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomAppBar_Y1yfwus$lambda$0(Modifier modifier, long j, long j2, Shape shape, float f, PaddingValues paddingValues, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2253BottomAppBarY1yfwus(modifier, j, j2, shape, f, paddingValues, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopAppBar_HsRjFd4$lambda$0(Modifier modifier, long j, long j2, float f, PaddingValues paddingValues, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2254TopAppBarHsRjFd4(modifier, j, j2, f, paddingValues, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopAppBar_Rx1qByU$lambda$1(Function2 function2, WindowInsets windowInsets, Modifier modifier, Function2 function3, Function3 function4, long j, long j2, float f, int i, int i2, Composer composer, int i3) {
        m2255TopAppBarRx1qByU(function2, windowInsets, modifier, function3, function4, j, j2, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopAppBar_afqeVBk$lambda$0(WindowInsets windowInsets, Modifier modifier, long j, long j2, float f, PaddingValues paddingValues, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2256TopAppBarafqeVBk(windowInsets, modifier, j, j2, f, paddingValues, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopAppBar_xWeB9_s$lambda$0(Function2 function2, Modifier modifier, Function2 function3, Function3 function4, long j, long j2, float f, int i, int i2, Composer composer, int i3) {
        m2257TopAppBarxWeB9s(function2, modifier, function3, function4, j, j2, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    private static final float square(float f) {
        return f * f;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x012b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:101:0x012d  */
    /* JADX WARN: Code duplicated, block: B:103:0x0134  */
    /* JADX WARN: Code duplicated, block: B:105:0x0138  */
    /* JADX WARN: Code duplicated, block: B:108:0x0143  */
    /* JADX WARN: Code duplicated, block: B:111:0x0156  */
    /* JADX WARN: Code duplicated, block: B:112:0x0163  */
    /* JADX WARN: Code duplicated, block: B:114:0x0167  */
    /* JADX WARN: Code duplicated, block: B:115:0x0178  */
    /* JADX WARN: Code duplicated, block: B:118:0x0189  */
    /* JADX WARN: Code duplicated, block: B:121:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:123:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:126:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:128:? A[RETURN, SYNTHETIC] */
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
    /* JADX WARN: Code duplicated, block: B:66:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:69:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:74:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:75:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:79:0x00db  */
    /* JADX WARN: Code duplicated, block: B:80:0x00de  */
    /* JADX WARN: Code duplicated, block: B:84:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:90:0x010a  */
    /* JADX INFO: renamed from: TopAppBar-Rx1qByU, reason: not valid java name */
    public static final void m2255TopAppBarRx1qByU(final Function2<? super Composer, ? super Integer, Unit> function2, final WindowInsets windowInsets, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function3, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4, long j, long j2, float f, Composer composer, final int i, final int i2) {
        int i3;
        WindowInsets windowInsets2;
        Modifier modifier2;
        int i4;
        final Function2<? super Composer, ? super Integer, Unit> function5;
        int i5;
        int i6;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> lambda$269254275$material;
        int i7;
        long primarySurface;
        int i8;
        int i9;
        int i10;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function6;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function7;
        final long j3;
        final float f2;
        final long j4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long jM2360contentColorForek8zF_U;
        Modifier modifier4;
        int i11;
        long j5;
        float fM2246getTopAppBarElevationD9Ej5fM;
        int i12;
        Composer composerStartRestartGroup = composer.startRestartGroup(138090236);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TopAppBar)N(title,windowInsets,modifier,navigationIcon,actions,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation:c#ui.unit.Dp)101@4667L1063,93@4484L1246:AppBar.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            windowInsets2 = windowInsets;
            i3 |= composerStartRestartGroup.changed(windowInsets2) ? 32 : 16;
        } else {
            windowInsets2 = windowInsets;
        }
        int i13 = i2 & 4;
        if (i13 == 0) {
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
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((i & 24576) == 0) {
                        lambda$269254275$material = function4;
                        if (composerStartRestartGroup.changedInstance(lambda$269254275$material)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    if ((196608 & i) == 0) {
                        if ((i2 & 32) == 0) {
                            primarySurface = j;
                            int i14 = composerStartRestartGroup.changed(primarySurface) ? 131072 : 65536;
                            i3 |= i14;
                        } else {
                            primarySurface = j;
                        }
                        i3 |= i14;
                    } else {
                        primarySurface = j;
                    }
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0 || !composerStartRestartGroup.changed(j2)) {
                            i12 = 524288;
                        } else {
                            i12 = 1048576;
                        }
                        i3 |= i12;
                    }
                    i8 = i2 & 128;
                    if (i8 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(f)) {
                            i9 = 8388608;
                        } else {
                            i9 = 4194304;
                        }
                        i3 |= i9;
                    }
                    i10 = i3;
                    if ((4793491 & i3) != 4793490) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i10 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "89@4338L6,90@4387L32");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i13 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                lambda$269254275$material = ComposableSingletons$AppBarKt.INSTANCE.getLambda$269254275$material();
                            }
                            if ((i2 & 32) != 0) {
                                primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                                i10 &= -458753;
                            }
                            if ((i2 & 64) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i10 >> 15) & 14);
                                i10 &= -3670017;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i8 != 0) {
                                long j6 = jM2360contentColorForek8zF_U;
                                fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                                i11 = i10;
                                j5 = j6;
                                modifier4 = modifier2;
                            } else {
                                modifier4 = modifier2;
                                i11 = i10;
                                j5 = jM2360contentColorForek8zF_U;
                                fM2246getTopAppBarElevationD9Ej5fM = f;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 32) != 0) {
                                i10 &= -458753;
                            }
                            if ((i2 & 64) != 0) {
                                i10 &= -3670017;
                            }
                            fM2246getTopAppBarElevationD9Ej5fM = f;
                            modifier4 = modifier2;
                            i11 = i10;
                            j5 = j2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(138090236, i11, -1, "androidx.compose.material.TopAppBar (AppBar.kt:92)");
                        }
                        int i15 = i11 >> 15;
                        int i16 = i11 << 12;
                        composer2 = composerStartRestartGroup;
                        m2251AppBarHkEspTQ(primarySurface, j5, fM2246getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), windowInsets2, modifier4, ComposableLambdaKt.rememberComposableLambda(-2019867954, true, new Function3() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return AppBarKt.TopAppBar_Rx1qByU$lambda$0(function5, function2, lambda$269254275$material, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, (i15 & 896) | (i15 & 14) | 12610560 | (i15 & 112) | (458752 & i16) | (i16 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function6 = function5;
                        function7 = lambda$269254275$material;
                        j3 = j5;
                        f2 = fM2246getTopAppBarElevationD9Ej5fM;
                        modifier3 = modifier4;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        function6 = function5;
                        function7 = lambda$269254275$material;
                        j3 = j2;
                        f2 = f;
                    }
                    j4 = primarySurface;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AppBarKt.TopAppBar_Rx1qByU$lambda$1(function2, windowInsets, modifier3, function6, function7, j4, j3, f2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                lambda$269254275$material = function4;
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        primarySurface = j;
                        if (composerStartRestartGroup.changed(primarySurface)) {
                        }
                        i3 |= i14;
                    } else {
                        primarySurface = j;
                    }
                    i3 |= i14;
                } else {
                    primarySurface = j;
                }
                if ((1572864 & i) != 0) {
                    if ((i2 & 64) == 0) {
                        i12 = 524288;
                    } else {
                        i12 = 524288;
                    }
                    i3 |= i12;
                }
                i8 = i2 & 128;
                if (i8 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
                i10 = i3;
                if ((4793491 & i3) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i10 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "89@4338L6,90@4387L32");
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            lambda$269254275$material = ComposableSingletons$AppBarKt.INSTANCE.getLambda$269254275$material();
                        }
                        if ((i2 & 32) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i10 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i10 >> 15) & 14);
                            i10 &= -3670017;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i8 != 0) {
                            long j7 = jM2360contentColorForek8zF_U;
                            fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                            i11 = i10;
                            j5 = j7;
                            modifier4 = modifier2;
                        } else {
                            modifier4 = modifier2;
                            i11 = i10;
                            j5 = jM2360contentColorForek8zF_U;
                            fM2246getTopAppBarElevationD9Ej5fM = f;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            lambda$269254275$material = ComposableSingletons$AppBarKt.INSTANCE.getLambda$269254275$material();
                        }
                        if ((i2 & 32) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i10 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i10 >> 15) & 14);
                            i10 &= -3670017;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i8 != 0) {
                            long j8 = jM2360contentColorForek8zF_U;
                            fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                            i11 = i10;
                            j5 = j8;
                            modifier4 = modifier2;
                        } else {
                            modifier4 = modifier2;
                            i11 = i10;
                            j5 = jM2360contentColorForek8zF_U;
                            fM2246getTopAppBarElevationD9Ej5fM = f;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(138090236, i11, -1, "androidx.compose.material.TopAppBar (AppBar.kt:92)");
                    }
                    int i17 = i11 >> 15;
                    int i18 = i11 << 12;
                    composer2 = composerStartRestartGroup;
                    m2251AppBarHkEspTQ(primarySurface, j5, fM2246getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), windowInsets2, modifier4, ComposableLambdaKt.rememberComposableLambda(-2019867954, true, new Function3() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return AppBarKt.TopAppBar_Rx1qByU$lambda$0(function5, function2, lambda$269254275$material, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (i17 & 896) | (i17 & 14) | 12610560 | (i17 & 112) | (458752 & i18) | (i18 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function6 = function5;
                    function7 = lambda$269254275$material;
                    j3 = j5;
                    f2 = fM2246getTopAppBarElevationD9Ej5fM;
                    modifier3 = modifier4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    function6 = function5;
                    function7 = lambda$269254275$material;
                    j3 = j2;
                    f2 = f;
                }
                j4 = primarySurface;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AppBarKt.TopAppBar_Rx1qByU$lambda$1(function2, windowInsets, modifier3, function6, function7, j4, j3, f2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            function5 = function3;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    lambda$269254275$material = function4;
                    if (composerStartRestartGroup.changedInstance(lambda$269254275$material)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        primarySurface = j;
                        if (composerStartRestartGroup.changed(primarySurface)) {
                        }
                        i3 |= i14;
                    } else {
                        primarySurface = j;
                    }
                    i3 |= i14;
                } else {
                    primarySurface = j;
                }
                if ((1572864 & i) != 0) {
                    if ((i2 & 64) == 0) {
                        i12 = 524288;
                    } else {
                        i12 = 524288;
                    }
                    i3 |= i12;
                }
                i8 = i2 & 128;
                if (i8 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
                i10 = i3;
                if ((4793491 & i3) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i10 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "89@4338L6,90@4387L32");
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            lambda$269254275$material = ComposableSingletons$AppBarKt.INSTANCE.getLambda$269254275$material();
                        }
                        if ((i2 & 32) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i10 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i10 >> 15) & 14);
                            i10 &= -3670017;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i8 != 0) {
                            long j9 = jM2360contentColorForek8zF_U;
                            fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                            i11 = i10;
                            j5 = j9;
                            modifier4 = modifier2;
                        } else {
                            modifier4 = modifier2;
                            i11 = i10;
                            j5 = jM2360contentColorForek8zF_U;
                            fM2246getTopAppBarElevationD9Ej5fM = f;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            lambda$269254275$material = ComposableSingletons$AppBarKt.INSTANCE.getLambda$269254275$material();
                        }
                        if ((i2 & 32) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i10 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i10 >> 15) & 14);
                            i10 &= -3670017;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i8 != 0) {
                            long j10 = jM2360contentColorForek8zF_U;
                            fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                            i11 = i10;
                            j5 = j10;
                            modifier4 = modifier2;
                        } else {
                            modifier4 = modifier2;
                            i11 = i10;
                            j5 = jM2360contentColorForek8zF_U;
                            fM2246getTopAppBarElevationD9Ej5fM = f;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(138090236, i11, -1, "androidx.compose.material.TopAppBar (AppBar.kt:92)");
                    }
                    int i19 = i11 >> 15;
                    int i110 = i11 << 12;
                    composer2 = composerStartRestartGroup;
                    m2251AppBarHkEspTQ(primarySurface, j5, fM2246getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), windowInsets2, modifier4, ComposableLambdaKt.rememberComposableLambda(-2019867954, true, new Function3() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return AppBarKt.TopAppBar_Rx1qByU$lambda$0(function5, function2, lambda$269254275$material, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (i19 & 896) | (i19 & 14) | 12610560 | (i19 & 112) | (458752 & i110) | (i110 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function6 = function5;
                    function7 = lambda$269254275$material;
                    j3 = j5;
                    f2 = fM2246getTopAppBarElevationD9Ej5fM;
                    modifier3 = modifier4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    function6 = function5;
                    function7 = lambda$269254275$material;
                    j3 = j2;
                    f2 = f;
                }
                j4 = primarySurface;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AppBarKt.TopAppBar_Rx1qByU$lambda$1(function2, windowInsets, modifier3, function6, function7, j4, j3, f2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            lambda$269254275$material = function4;
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    primarySurface = j;
                    if (composerStartRestartGroup.changed(primarySurface)) {
                    }
                    i3 |= i14;
                } else {
                    primarySurface = j;
                }
                i3 |= i14;
            } else {
                primarySurface = j;
            }
            if ((1572864 & i) != 0) {
                if ((i2 & 64) == 0) {
                    i12 = 524288;
                } else {
                    i12 = 524288;
                }
                i3 |= i12;
            }
            i8 = i2 & 128;
            if (i8 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            i10 = i3;
            if ((4793491 & i3) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i10 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "89@4338L6,90@4387L32");
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        lambda$269254275$material = ComposableSingletons$AppBarKt.INSTANCE.getLambda$269254275$material();
                    }
                    if ((i2 & 32) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i10 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i10 >> 15) & 14);
                        i10 &= -3670017;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i8 != 0) {
                        long j11 = jM2360contentColorForek8zF_U;
                        fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                        i11 = i10;
                        j5 = j11;
                        modifier4 = modifier2;
                    } else {
                        modifier4 = modifier2;
                        i11 = i10;
                        j5 = jM2360contentColorForek8zF_U;
                        fM2246getTopAppBarElevationD9Ej5fM = f;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        lambda$269254275$material = ComposableSingletons$AppBarKt.INSTANCE.getLambda$269254275$material();
                    }
                    if ((i2 & 32) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i10 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i10 >> 15) & 14);
                        i10 &= -3670017;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i8 != 0) {
                        long j12 = jM2360contentColorForek8zF_U;
                        fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                        i11 = i10;
                        j5 = j12;
                        modifier4 = modifier2;
                    } else {
                        modifier4 = modifier2;
                        i11 = i10;
                        j5 = jM2360contentColorForek8zF_U;
                        fM2246getTopAppBarElevationD9Ej5fM = f;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(138090236, i11, -1, "androidx.compose.material.TopAppBar (AppBar.kt:92)");
                }
                int i111 = i11 >> 15;
                int i112 = i11 << 12;
                composer2 = composerStartRestartGroup;
                m2251AppBarHkEspTQ(primarySurface, j5, fM2246getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), windowInsets2, modifier4, ComposableLambdaKt.rememberComposableLambda(-2019867954, true, new Function3() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return AppBarKt.TopAppBar_Rx1qByU$lambda$0(function5, function2, lambda$269254275$material, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, (i111 & 896) | (i111 & 14) | 12610560 | (i111 & 112) | (458752 & i112) | (i112 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function6 = function5;
                function7 = lambda$269254275$material;
                j3 = j5;
                f2 = fM2246getTopAppBarElevationD9Ej5fM;
                modifier3 = modifier4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                function6 = function5;
                function7 = lambda$269254275$material;
                j3 = j2;
                f2 = f;
            }
            j4 = primarySurface;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AppBarKt.TopAppBar_Rx1qByU$lambda$1(function2, windowInsets, modifier3, function6, function7, j4, j3, f2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    lambda$269254275$material = function4;
                    if (composerStartRestartGroup.changedInstance(lambda$269254275$material)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        primarySurface = j;
                        if (composerStartRestartGroup.changed(primarySurface)) {
                        }
                        i3 |= i14;
                    } else {
                        primarySurface = j;
                    }
                    i3 |= i14;
                } else {
                    primarySurface = j;
                }
                if ((1572864 & i) != 0) {
                    if ((i2 & 64) == 0) {
                        i12 = 524288;
                    } else {
                        i12 = 524288;
                    }
                    i3 |= i12;
                }
                i8 = i2 & 128;
                if (i8 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
                i10 = i3;
                if ((4793491 & i3) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i10 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "89@4338L6,90@4387L32");
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            lambda$269254275$material = ComposableSingletons$AppBarKt.INSTANCE.getLambda$269254275$material();
                        }
                        if ((i2 & 32) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i10 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i10 >> 15) & 14);
                            i10 &= -3670017;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i8 != 0) {
                            long j13 = jM2360contentColorForek8zF_U;
                            fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                            i11 = i10;
                            j5 = j13;
                            modifier4 = modifier2;
                        } else {
                            modifier4 = modifier2;
                            i11 = i10;
                            j5 = jM2360contentColorForek8zF_U;
                            fM2246getTopAppBarElevationD9Ej5fM = f;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            lambda$269254275$material = ComposableSingletons$AppBarKt.INSTANCE.getLambda$269254275$material();
                        }
                        if ((i2 & 32) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i10 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i10 >> 15) & 14);
                            i10 &= -3670017;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i8 != 0) {
                            long j14 = jM2360contentColorForek8zF_U;
                            fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                            i11 = i10;
                            j5 = j14;
                            modifier4 = modifier2;
                        } else {
                            modifier4 = modifier2;
                            i11 = i10;
                            j5 = jM2360contentColorForek8zF_U;
                            fM2246getTopAppBarElevationD9Ej5fM = f;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(138090236, i11, -1, "androidx.compose.material.TopAppBar (AppBar.kt:92)");
                    }
                    int i113 = i11 >> 15;
                    int i114 = i11 << 12;
                    composer2 = composerStartRestartGroup;
                    m2251AppBarHkEspTQ(primarySurface, j5, fM2246getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), windowInsets2, modifier4, ComposableLambdaKt.rememberComposableLambda(-2019867954, true, new Function3() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return AppBarKt.TopAppBar_Rx1qByU$lambda$0(function5, function2, lambda$269254275$material, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (i113 & 896) | (i113 & 14) | 12610560 | (i113 & 112) | (458752 & i114) | (i114 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function6 = function5;
                    function7 = lambda$269254275$material;
                    j3 = j5;
                    f2 = fM2246getTopAppBarElevationD9Ej5fM;
                    modifier3 = modifier4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    function6 = function5;
                    function7 = lambda$269254275$material;
                    j3 = j2;
                    f2 = f;
                }
                j4 = primarySurface;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AppBarKt.TopAppBar_Rx1qByU$lambda$1(function2, windowInsets, modifier3, function6, function7, j4, j3, f2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            lambda$269254275$material = function4;
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    primarySurface = j;
                    if (composerStartRestartGroup.changed(primarySurface)) {
                    }
                    i3 |= i14;
                } else {
                    primarySurface = j;
                }
                i3 |= i14;
            } else {
                primarySurface = j;
            }
            if ((1572864 & i) != 0) {
                if ((i2 & 64) == 0) {
                    i12 = 524288;
                } else {
                    i12 = 524288;
                }
                i3 |= i12;
            }
            i8 = i2 & 128;
            if (i8 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            i10 = i3;
            if ((4793491 & i3) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i10 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "89@4338L6,90@4387L32");
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        lambda$269254275$material = ComposableSingletons$AppBarKt.INSTANCE.getLambda$269254275$material();
                    }
                    if ((i2 & 32) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i10 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i10 >> 15) & 14);
                        i10 &= -3670017;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i8 != 0) {
                        long j15 = jM2360contentColorForek8zF_U;
                        fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                        i11 = i10;
                        j5 = j15;
                        modifier4 = modifier2;
                    } else {
                        modifier4 = modifier2;
                        i11 = i10;
                        j5 = jM2360contentColorForek8zF_U;
                        fM2246getTopAppBarElevationD9Ej5fM = f;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        lambda$269254275$material = ComposableSingletons$AppBarKt.INSTANCE.getLambda$269254275$material();
                    }
                    if ((i2 & 32) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i10 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i10 >> 15) & 14);
                        i10 &= -3670017;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i8 != 0) {
                        long j16 = jM2360contentColorForek8zF_U;
                        fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                        i11 = i10;
                        j5 = j16;
                        modifier4 = modifier2;
                    } else {
                        modifier4 = modifier2;
                        i11 = i10;
                        j5 = jM2360contentColorForek8zF_U;
                        fM2246getTopAppBarElevationD9Ej5fM = f;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(138090236, i11, -1, "androidx.compose.material.TopAppBar (AppBar.kt:92)");
                }
                int i115 = i11 >> 15;
                int i116 = i11 << 12;
                composer2 = composerStartRestartGroup;
                m2251AppBarHkEspTQ(primarySurface, j5, fM2246getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), windowInsets2, modifier4, ComposableLambdaKt.rememberComposableLambda(-2019867954, true, new Function3() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return AppBarKt.TopAppBar_Rx1qByU$lambda$0(function5, function2, lambda$269254275$material, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, (i115 & 896) | (i115 & 14) | 12610560 | (i115 & 112) | (458752 & i116) | (i116 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function6 = function5;
                function7 = lambda$269254275$material;
                j3 = j5;
                f2 = fM2246getTopAppBarElevationD9Ej5fM;
                modifier3 = modifier4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                function6 = function5;
                function7 = lambda$269254275$material;
                j3 = j2;
                f2 = f;
            }
            j4 = primarySurface;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AppBarKt.TopAppBar_Rx1qByU$lambda$1(function2, windowInsets, modifier3, function6, function7, j4, j3, f2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        function5 = function3;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 24576) == 0) {
                lambda$269254275$material = function4;
                if (composerStartRestartGroup.changedInstance(lambda$269254275$material)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    primarySurface = j;
                    if (composerStartRestartGroup.changed(primarySurface)) {
                    }
                    i3 |= i14;
                } else {
                    primarySurface = j;
                }
                i3 |= i14;
            } else {
                primarySurface = j;
            }
            if ((1572864 & i) != 0) {
                if ((i2 & 64) == 0) {
                    i12 = 524288;
                } else {
                    i12 = 524288;
                }
                i3 |= i12;
            }
            i8 = i2 & 128;
            if (i8 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            i10 = i3;
            if ((4793491 & i3) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i10 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "89@4338L6,90@4387L32");
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        lambda$269254275$material = ComposableSingletons$AppBarKt.INSTANCE.getLambda$269254275$material();
                    }
                    if ((i2 & 32) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i10 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i10 >> 15) & 14);
                        i10 &= -3670017;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i8 != 0) {
                        long j17 = jM2360contentColorForek8zF_U;
                        fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                        i11 = i10;
                        j5 = j17;
                        modifier4 = modifier2;
                    } else {
                        modifier4 = modifier2;
                        i11 = i10;
                        j5 = jM2360contentColorForek8zF_U;
                        fM2246getTopAppBarElevationD9Ej5fM = f;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        lambda$269254275$material = ComposableSingletons$AppBarKt.INSTANCE.getLambda$269254275$material();
                    }
                    if ((i2 & 32) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i10 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i10 >> 15) & 14);
                        i10 &= -3670017;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i8 != 0) {
                        long j18 = jM2360contentColorForek8zF_U;
                        fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                        i11 = i10;
                        j5 = j18;
                        modifier4 = modifier2;
                    } else {
                        modifier4 = modifier2;
                        i11 = i10;
                        j5 = jM2360contentColorForek8zF_U;
                        fM2246getTopAppBarElevationD9Ej5fM = f;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(138090236, i11, -1, "androidx.compose.material.TopAppBar (AppBar.kt:92)");
                }
                int i117 = i11 >> 15;
                int i118 = i11 << 12;
                composer2 = composerStartRestartGroup;
                m2251AppBarHkEspTQ(primarySurface, j5, fM2246getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), windowInsets2, modifier4, ComposableLambdaKt.rememberComposableLambda(-2019867954, true, new Function3() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return AppBarKt.TopAppBar_Rx1qByU$lambda$0(function5, function2, lambda$269254275$material, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, (i117 & 896) | (i117 & 14) | 12610560 | (i117 & 112) | (458752 & i118) | (i118 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function6 = function5;
                function7 = lambda$269254275$material;
                j3 = j5;
                f2 = fM2246getTopAppBarElevationD9Ej5fM;
                modifier3 = modifier4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                function6 = function5;
                function7 = lambda$269254275$material;
                j3 = j2;
                f2 = f;
            }
            j4 = primarySurface;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AppBarKt.TopAppBar_Rx1qByU$lambda$1(function2, windowInsets, modifier3, function6, function7, j4, j3, f2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        lambda$269254275$material = function4;
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                primarySurface = j;
                if (composerStartRestartGroup.changed(primarySurface)) {
                }
                i3 |= i14;
            } else {
                primarySurface = j;
            }
            i3 |= i14;
        } else {
            primarySurface = j;
        }
        if ((1572864 & i) != 0) {
            if ((i2 & 64) == 0) {
                i12 = 524288;
            } else {
                i12 = 524288;
            }
            i3 |= i12;
        }
        i8 = i2 & 128;
        if (i8 != 0) {
            i3 |= 12582912;
        } else if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changed(f)) {
                i9 = 8388608;
            } else {
                i9 = 4194304;
            }
            i3 |= i9;
        }
        i10 = i3;
        if ((4793491 & i3) != 4793490) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i10 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "89@4338L6,90@4387L32");
            if ((i & 1) != 0) {
                if (i13 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    function5 = null;
                }
                if (i6 != 0) {
                    lambda$269254275$material = ComposableSingletons$AppBarKt.INSTANCE.getLambda$269254275$material();
                }
                if ((i2 & 32) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i10 &= -458753;
                }
                if ((i2 & 64) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i10 >> 15) & 14);
                    i10 &= -3670017;
                } else {
                    jM2360contentColorForek8zF_U = j2;
                }
                if (i8 != 0) {
                    long j19 = jM2360contentColorForek8zF_U;
                    fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                    i11 = i10;
                    j5 = j19;
                    modifier4 = modifier2;
                } else {
                    modifier4 = modifier2;
                    i11 = i10;
                    j5 = jM2360contentColorForek8zF_U;
                    fM2246getTopAppBarElevationD9Ej5fM = f;
                }
            } else {
                if (i13 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    function5 = null;
                }
                if (i6 != 0) {
                    lambda$269254275$material = ComposableSingletons$AppBarKt.INSTANCE.getLambda$269254275$material();
                }
                if ((i2 & 32) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i10 &= -458753;
                }
                if ((i2 & 64) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i10 >> 15) & 14);
                    i10 &= -3670017;
                } else {
                    jM2360contentColorForek8zF_U = j2;
                }
                if (i8 != 0) {
                    long j110 = jM2360contentColorForek8zF_U;
                    fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                    i11 = i10;
                    j5 = j110;
                    modifier4 = modifier2;
                } else {
                    modifier4 = modifier2;
                    i11 = i10;
                    j5 = jM2360contentColorForek8zF_U;
                    fM2246getTopAppBarElevationD9Ej5fM = f;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(138090236, i11, -1, "androidx.compose.material.TopAppBar (AppBar.kt:92)");
            }
            int i119 = i11 >> 15;
            int i1110 = i11 << 12;
            composer2 = composerStartRestartGroup;
            m2251AppBarHkEspTQ(primarySurface, j5, fM2246getTopAppBarElevationD9Ej5fM, AppBarDefaults.INSTANCE.getContentPadding(), RectangleShapeKt.getRectangleShape(), windowInsets2, modifier4, ComposableLambdaKt.rememberComposableLambda(-2019867954, true, new Function3() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AppBarKt.TopAppBar_Rx1qByU$lambda$0(function5, function2, lambda$269254275$material, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, (i119 & 896) | (i119 & 14) | 12610560 | (i119 & 112) | (458752 & i1110) | (i1110 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function6 = function5;
            function7 = lambda$269254275$material;
            j3 = j5;
            f2 = fM2246getTopAppBarElevationD9Ej5fM;
            modifier3 = modifier4;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            function6 = function5;
            function7 = lambda$269254275$material;
            j3 = j2;
            f2 = f;
        }
        j4 = primarySurface;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBarKt.TopAppBar_Rx1qByU$lambda$1(function2, windowInsets, modifier3, function6, function7, j4, j3, f2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopAppBar_Rx1qByU$lambda$0(Function2 function2, final Function2 function3, final Function3 function4, RowScope rowScope, Composer composer, int i) {
        int i2;
        ComposerKt.sourceInformation(composer, "C113@5056L345,122@5476L6,122@5484L240,122@5411L313:AppBar.kt#jmzs0o");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(rowScope) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2019867954, i2, -1, "androidx.compose.material.TopAppBar.<anonymous> (AppBar.kt:102)");
            }
            if (function2 == null) {
                composer.startReplaceGroup(-1394361313);
                ComposerKt.sourceInformation(composer, "103@4719L29");
                SpacerKt.Spacer(TitleInsetWithoutIcon, composer, 6);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1394295686);
                ComposerKt.sourceInformation(composer, "105@4778L258");
                Modifier modifier = TitleIconModifier;
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
                ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifier);
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
                ComposerKt.sourceInformationMarkerStart(composer, 2031468274, "C107@4953L4,106@4867L155:AppBar.kt#jmzs0o");
                CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer, 6))), (Function2<? super Composer, ? super Integer, Unit>) function2, composer, ProvidedValue.$stable);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endReplaceGroup();
            }
            Modifier modifierWeight$default = RowScope.weight$default(rowScope, SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null);
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierWeight$default);
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
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -297206295, "C114@5198L10,114@5213L178,114@5159L232:AppBar.kt#jmzs0o");
            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer, 6).getH6(), ComposableLambdaKt.rememberComposableLambda(1206983395, true, new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBarKt.TopAppBar_Rx1qByU$lambda$0$1$0(function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 48);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer, 6))), ComposableLambdaKt.rememberComposableLambda(-1033635954, true, new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBarKt.TopAppBar_Rx1qByU$lambda$0$2(function4, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopAppBar_Rx1qByU$lambda$0$1$0(Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C116@5317L4,115@5231L146:AppBar.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1206983395, i, -1, "androidx.compose.material.TopAppBar.<anonymous>.<anonymous>.<anonymous> (AppBar.kt:115)");
            }
            CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer, 6))), (Function2<? super Composer, ? super Integer, Unit>) function2, composer, ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopAppBar_Rx1qByU$lambda$0$2(Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C123@5498L216:AppBar.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1033635954, i, -1, "androidx.compose.material.TopAppBar.<anonymous>.<anonymous> (AppBar.kt:123)");
            }
            Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(end, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxHeight$default);
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
            function3.invoke(RowScopeInstance.INSTANCE, composer, 6);
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

    /* JADX WARN: Code duplicated, block: B:101:0x012d  */
    /* JADX WARN: Code duplicated, block: B:102:0x013b  */
    /* JADX WARN: Code duplicated, block: B:105:0x0141  */
    /* JADX WARN: Code duplicated, block: B:107:0x014c  */
    /* JADX WARN: Code duplicated, block: B:110:0x015e  */
    /* JADX WARN: Code duplicated, block: B:113:0x0191  */
    /* JADX WARN: Code duplicated, block: B:115:0x019e  */
    /* JADX WARN: Code duplicated, block: B:118:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:120:? A[RETURN, SYNTHETIC] */
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
    /* JADX WARN: Code duplicated, block: B:47:0x0080  */
    /* JADX WARN: Code duplicated, block: B:50:0x0089  */
    /* JADX WARN: Code duplicated, block: B:52:0x008d  */
    /* JADX WARN: Code duplicated, block: B:55:0x0094  */
    /* JADX WARN: Code duplicated, block: B:57:0x009a  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:65:0x00af  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:79:0x00de  */
    /* JADX WARN: Code duplicated, block: B:81:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:91:0x0108 A[PHI: r0 r4 r6 r8 r12 r14
      0x0108: PHI (r0v26 int) = (r0v12 int), (r0v30 int), (r0v31 int) binds: [B:106:0x014a, B:89:0x0105, B:90:0x0107] A[DONT_GENERATE, DONT_INLINE]
      0x0108: PHI (r4v10 androidx.compose.ui.Modifier) = (r4v5 androidx.compose.ui.Modifier), (r4v2 androidx.compose.ui.Modifier), (r4v2 androidx.compose.ui.Modifier) binds: [B:106:0x014a, B:89:0x0105, B:90:0x0107] A[DONT_GENERATE, DONT_INLINE]
      0x0108: PHI (r6v6 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) = 
      (r6v3 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
      (r6v2 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
      (r6v2 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
     binds: [B:106:0x014a, B:89:0x0105, B:90:0x0107] A[DONT_GENERATE, DONT_INLINE]
      0x0108: PHI (r8v6 kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) = 
      (r8v3 kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
      (r8v2 kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
      (r8v2 kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
     binds: [B:106:0x014a, B:89:0x0105, B:90:0x0107] A[DONT_GENERATE, DONT_INLINE]
      0x0108: PHI (r12v7 long) = (r12v3 long), (r12v1 long), (r12v1 long) binds: [B:106:0x014a, B:89:0x0105, B:90:0x0107] A[DONT_GENERATE, DONT_INLINE]
      0x0108: PHI (r14v6 long) = (r14v2 long), (r14v1 long), (r14v1 long) binds: [B:106:0x014a, B:89:0x0105, B:90:0x0107] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:93:0x0115 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:94:0x0117  */
    /* JADX WARN: Code duplicated, block: B:96:0x011e  */
    /* JADX WARN: Code duplicated, block: B:98:0x0122  */
    /* JADX INFO: renamed from: TopAppBar-xWeB9-s, reason: not valid java name */
    public static final void m2257TopAppBarxWeB9s(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function3, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4, long j, long j2, float f, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function5;
        int i5;
        int i6;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> lambda$1260131259$material;
        int i7;
        long primarySurface;
        long jM2360contentColorForek8zF_U;
        int i8;
        int i9;
        int i10;
        boolean z;
        Composer composer2;
        final float f2;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function6;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function7;
        final long j3;
        final long j4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i11;
        float fM2246getTopAppBarElevationD9Ej5fM;
        int i12;
        int i13;
        Composer composerStartRestartGroup = composer.startRestartGroup(-350082398);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TopAppBar)N(title,modifier,navigationIcon,actions,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation:c#ui.unit.Dp)169@7728L176:AppBar.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i14 = i2 & 2;
        if (i14 == 0) {
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
                        lambda$1260131259$material = function4;
                        if (composerStartRestartGroup.changedInstance(lambda$1260131259$material)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    if ((i & 24576) == 0) {
                        primarySurface = j;
                        if ((i2 & 16) == 0 || !composerStartRestartGroup.changed(primarySurface)) {
                            i13 = 8192;
                        } else {
                            i13 = 16384;
                        }
                        i3 |= i13;
                    } else {
                        primarySurface = j;
                    }
                    if ((196608 & i) == 0) {
                        jM2360contentColorForek8zF_U = j2;
                        if ((i2 & 32) == 0 || !composerStartRestartGroup.changed(jM2360contentColorForek8zF_U)) {
                            i12 = 65536;
                        } else {
                            i12 = 131072;
                        }
                        i3 |= i12;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    i8 = i2 & 64;
                    if (i8 != 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(f)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    i10 = i3;
                    if ((i3 & 599187) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i10 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "165@7582L6,166@7631L32");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                lambda$1260131259$material = ComposableSingletons$AppBarKt.INSTANCE.getLambda$1260131259$material();
                            }
                            if ((i2 & 16) != 0) {
                                primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                                i11 = i10 & (-57345);
                            } else {
                                i11 = i10;
                            }
                            if ((i2 & 32) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i11 >> 12) & 14);
                                i11 &= -458753;
                            }
                            if (i8 != 0) {
                                fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                            }
                            long j5 = primarySurface;
                            long j6 = jM2360contentColorForek8zF_U;
                            Modifier modifier4 = modifier2;
                            Function2<? super Composer, ? super Integer, Unit> function8 = function5;
                            Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function9 = lambda$1260131259$material;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-350082398, i11, -1, "androidx.compose.material.TopAppBar (AppBar.kt:168)");
                            }
                            int i15 = (i11 & 14) | 48;
                            int i16 = i11 << 3;
                            composer2 = composerStartRestartGroup;
                            m2255TopAppBarRx1qByU(function2, ZeroInsets, modifier4, function8, function9, j5, j6, fM2246getTopAppBarElevationD9Ej5fM, composer2, i15 | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            function6 = function8;
                            function7 = function9;
                            j3 = j5;
                            j4 = j6;
                            f2 = fM2246getTopAppBarElevationD9Ej5fM;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            i11 = (i2 & 16) != 0 ? i10 & (-57345) : i10;
                            if ((i2 & 32) != 0) {
                                i11 &= -458753;
                            }
                        }
                        fM2246getTopAppBarElevationD9Ej5fM = f;
                        long j7 = primarySurface;
                        long j8 = jM2360contentColorForek8zF_U;
                        Modifier modifier5 = modifier2;
                        Function2<? super Composer, ? super Integer, Unit> function10 = function5;
                        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function11 = lambda$1260131259$material;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-350082398, i11, -1, "androidx.compose.material.TopAppBar (AppBar.kt:168)");
                        }
                        int i17 = (i11 & 14) | 48;
                        int i18 = i11 << 3;
                        composer2 = composerStartRestartGroup;
                        m2255TopAppBarRx1qByU(function2, ZeroInsets, modifier5, function10, function11, j7, j8, fM2246getTopAppBarElevationD9Ej5fM, composer2, i17 | (i18 & 896) | (i18 & 7168) | (57344 & i18) | (458752 & i18) | (3670016 & i18) | (i18 & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier5;
                        function6 = function10;
                        function7 = function11;
                        j3 = j7;
                        j4 = j8;
                        f2 = fM2246getTopAppBarElevationD9Ej5fM;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        f2 = f;
                        modifier3 = modifier2;
                        function6 = function5;
                        function7 = lambda$1260131259$material;
                        j3 = primarySurface;
                        j4 = jM2360contentColorForek8zF_U;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AppBarKt.TopAppBar_xWeB9_s$lambda$0(function2, modifier3, function6, function7, j3, j4, f2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 3072;
                lambda$1260131259$material = function4;
                if ((i & 24576) == 0) {
                    primarySurface = j;
                    if ((i2 & 16) == 0) {
                        i13 = 8192;
                    } else {
                        i13 = 8192;
                    }
                    i3 |= i13;
                } else {
                    primarySurface = j;
                }
                if ((196608 & i) == 0) {
                    jM2360contentColorForek8zF_U = j2;
                    if ((i2 & 32) == 0) {
                        i12 = 65536;
                    } else {
                        i12 = 65536;
                    }
                    i3 |= i12;
                } else {
                    jM2360contentColorForek8zF_U = j2;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                i10 = i3;
                if ((i3 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i10 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "165@7582L6,166@7631L32");
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            lambda$1260131259$material = ComposableSingletons$AppBarKt.INSTANCE.getLambda$1260131259$material();
                        }
                        if ((i2 & 16) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i11 = i10 & (-57345);
                        } else {
                            i11 = i10;
                        }
                        if ((i2 & 32) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i11 >> 12) & 14);
                            i11 &= -458753;
                        }
                        if (i8 != 0) {
                            fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                        } else {
                            fM2246getTopAppBarElevationD9Ej5fM = f;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            lambda$1260131259$material = ComposableSingletons$AppBarKt.INSTANCE.getLambda$1260131259$material();
                        }
                        if ((i2 & 16) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i11 = i10 & (-57345);
                        } else {
                            i11 = i10;
                        }
                        if ((i2 & 32) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i11 >> 12) & 14);
                            i11 &= -458753;
                        }
                        if (i8 != 0) {
                            fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                        } else {
                            fM2246getTopAppBarElevationD9Ej5fM = f;
                        }
                    }
                    long j9 = primarySurface;
                    long j10 = jM2360contentColorForek8zF_U;
                    Modifier modifier6 = modifier2;
                    Function2<? super Composer, ? super Integer, Unit> function12 = function5;
                    Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function13 = lambda$1260131259$material;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-350082398, i11, -1, "androidx.compose.material.TopAppBar (AppBar.kt:168)");
                    }
                    int i19 = (i11 & 14) | 48;
                    int i110 = i11 << 3;
                    composer2 = composerStartRestartGroup;
                    m2255TopAppBarRx1qByU(function2, ZeroInsets, modifier6, function12, function13, j9, j10, fM2246getTopAppBarElevationD9Ej5fM, composer2, i19 | (i110 & 896) | (i110 & 7168) | (57344 & i110) | (458752 & i110) | (3670016 & i110) | (i110 & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier6;
                    function6 = function12;
                    function7 = function13;
                    j3 = j9;
                    j4 = j10;
                    f2 = fM2246getTopAppBarElevationD9Ej5fM;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    f2 = f;
                    modifier3 = modifier2;
                    function6 = function5;
                    function7 = lambda$1260131259$material;
                    j3 = primarySurface;
                    j4 = jM2360contentColorForek8zF_U;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AppBarKt.TopAppBar_xWeB9_s$lambda$0(function2, modifier3, function6, function7, j3, j4, f2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            function5 = function3;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    lambda$1260131259$material = function4;
                    if (composerStartRestartGroup.changedInstance(lambda$1260131259$material)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i & 24576) == 0) {
                    primarySurface = j;
                    if ((i2 & 16) == 0) {
                        i13 = 8192;
                    } else {
                        i13 = 8192;
                    }
                    i3 |= i13;
                } else {
                    primarySurface = j;
                }
                if ((196608 & i) == 0) {
                    jM2360contentColorForek8zF_U = j2;
                    if ((i2 & 32) == 0) {
                        i12 = 65536;
                    } else {
                        i12 = 65536;
                    }
                    i3 |= i12;
                } else {
                    jM2360contentColorForek8zF_U = j2;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                i10 = i3;
                if ((i3 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i10 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "165@7582L6,166@7631L32");
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            lambda$1260131259$material = ComposableSingletons$AppBarKt.INSTANCE.getLambda$1260131259$material();
                        }
                        if ((i2 & 16) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i11 = i10 & (-57345);
                        } else {
                            i11 = i10;
                        }
                        if ((i2 & 32) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i11 >> 12) & 14);
                            i11 &= -458753;
                        }
                        if (i8 != 0) {
                            fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                        } else {
                            fM2246getTopAppBarElevationD9Ej5fM = f;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            lambda$1260131259$material = ComposableSingletons$AppBarKt.INSTANCE.getLambda$1260131259$material();
                        }
                        if ((i2 & 16) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i11 = i10 & (-57345);
                        } else {
                            i11 = i10;
                        }
                        if ((i2 & 32) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i11 >> 12) & 14);
                            i11 &= -458753;
                        }
                        if (i8 != 0) {
                            fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                        } else {
                            fM2246getTopAppBarElevationD9Ej5fM = f;
                        }
                    }
                    long j11 = primarySurface;
                    long j12 = jM2360contentColorForek8zF_U;
                    Modifier modifier7 = modifier2;
                    Function2<? super Composer, ? super Integer, Unit> function14 = function5;
                    Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function15 = lambda$1260131259$material;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-350082398, i11, -1, "androidx.compose.material.TopAppBar (AppBar.kt:168)");
                    }
                    int i111 = (i11 & 14) | 48;
                    int i112 = i11 << 3;
                    composer2 = composerStartRestartGroup;
                    m2255TopAppBarRx1qByU(function2, ZeroInsets, modifier7, function14, function15, j11, j12, fM2246getTopAppBarElevationD9Ej5fM, composer2, i111 | (i112 & 896) | (i112 & 7168) | (57344 & i112) | (458752 & i112) | (3670016 & i112) | (i112 & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier7;
                    function6 = function14;
                    function7 = function15;
                    j3 = j11;
                    j4 = j12;
                    f2 = fM2246getTopAppBarElevationD9Ej5fM;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    f2 = f;
                    modifier3 = modifier2;
                    function6 = function5;
                    function7 = lambda$1260131259$material;
                    j3 = primarySurface;
                    j4 = jM2360contentColorForek8zF_U;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AppBarKt.TopAppBar_xWeB9_s$lambda$0(function2, modifier3, function6, function7, j3, j4, f2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            lambda$1260131259$material = function4;
            if ((i & 24576) == 0) {
                primarySurface = j;
                if ((i2 & 16) == 0) {
                    i13 = 8192;
                } else {
                    i13 = 8192;
                }
                i3 |= i13;
            } else {
                primarySurface = j;
            }
            if ((196608 & i) == 0) {
                jM2360contentColorForek8zF_U = j2;
                if ((i2 & 32) == 0) {
                    i12 = 65536;
                } else {
                    i12 = 65536;
                }
                i3 |= i12;
            } else {
                jM2360contentColorForek8zF_U = j2;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            i10 = i3;
            if ((i3 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i10 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "165@7582L6,166@7631L32");
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        lambda$1260131259$material = ComposableSingletons$AppBarKt.INSTANCE.getLambda$1260131259$material();
                    }
                    if ((i2 & 16) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i11 = i10 & (-57345);
                    } else {
                        i11 = i10;
                    }
                    if ((i2 & 32) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i11 >> 12) & 14);
                        i11 &= -458753;
                    }
                    if (i8 != 0) {
                        fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                    } else {
                        fM2246getTopAppBarElevationD9Ej5fM = f;
                    }
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        lambda$1260131259$material = ComposableSingletons$AppBarKt.INSTANCE.getLambda$1260131259$material();
                    }
                    if ((i2 & 16) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i11 = i10 & (-57345);
                    } else {
                        i11 = i10;
                    }
                    if ((i2 & 32) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i11 >> 12) & 14);
                        i11 &= -458753;
                    }
                    if (i8 != 0) {
                        fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                    } else {
                        fM2246getTopAppBarElevationD9Ej5fM = f;
                    }
                }
                long j13 = primarySurface;
                long j14 = jM2360contentColorForek8zF_U;
                Modifier modifier8 = modifier2;
                Function2<? super Composer, ? super Integer, Unit> function16 = function5;
                Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function17 = lambda$1260131259$material;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-350082398, i11, -1, "androidx.compose.material.TopAppBar (AppBar.kt:168)");
                }
                int i113 = (i11 & 14) | 48;
                int i114 = i11 << 3;
                composer2 = composerStartRestartGroup;
                m2255TopAppBarRx1qByU(function2, ZeroInsets, modifier8, function16, function17, j13, j14, fM2246getTopAppBarElevationD9Ej5fM, composer2, i113 | (i114 & 896) | (i114 & 7168) | (57344 & i114) | (458752 & i114) | (3670016 & i114) | (i114 & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier8;
                function6 = function16;
                function7 = function17;
                j3 = j13;
                j4 = j14;
                f2 = fM2246getTopAppBarElevationD9Ej5fM;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                f2 = f;
                modifier3 = modifier2;
                function6 = function5;
                function7 = lambda$1260131259$material;
                j3 = primarySurface;
                j4 = jM2360contentColorForek8zF_U;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AppBarKt.TopAppBar_xWeB9_s$lambda$0(function2, modifier3, function6, function7, j3, j4, f2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                    lambda$1260131259$material = function4;
                    if (composerStartRestartGroup.changedInstance(lambda$1260131259$material)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i & 24576) == 0) {
                    primarySurface = j;
                    if ((i2 & 16) == 0) {
                        i13 = 8192;
                    } else {
                        i13 = 8192;
                    }
                    i3 |= i13;
                } else {
                    primarySurface = j;
                }
                if ((196608 & i) == 0) {
                    jM2360contentColorForek8zF_U = j2;
                    if ((i2 & 32) == 0) {
                        i12 = 65536;
                    } else {
                        i12 = 65536;
                    }
                    i3 |= i12;
                } else {
                    jM2360contentColorForek8zF_U = j2;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                i10 = i3;
                if ((i3 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i10 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "165@7582L6,166@7631L32");
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            lambda$1260131259$material = ComposableSingletons$AppBarKt.INSTANCE.getLambda$1260131259$material();
                        }
                        if ((i2 & 16) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i11 = i10 & (-57345);
                        } else {
                            i11 = i10;
                        }
                        if ((i2 & 32) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i11 >> 12) & 14);
                            i11 &= -458753;
                        }
                        if (i8 != 0) {
                            fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                        } else {
                            fM2246getTopAppBarElevationD9Ej5fM = f;
                        }
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            lambda$1260131259$material = ComposableSingletons$AppBarKt.INSTANCE.getLambda$1260131259$material();
                        }
                        if ((i2 & 16) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i11 = i10 & (-57345);
                        } else {
                            i11 = i10;
                        }
                        if ((i2 & 32) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i11 >> 12) & 14);
                            i11 &= -458753;
                        }
                        if (i8 != 0) {
                            fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                        } else {
                            fM2246getTopAppBarElevationD9Ej5fM = f;
                        }
                    }
                    long j15 = primarySurface;
                    long j16 = jM2360contentColorForek8zF_U;
                    Modifier modifier9 = modifier2;
                    Function2<? super Composer, ? super Integer, Unit> function18 = function5;
                    Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function19 = lambda$1260131259$material;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-350082398, i11, -1, "androidx.compose.material.TopAppBar (AppBar.kt:168)");
                    }
                    int i115 = (i11 & 14) | 48;
                    int i116 = i11 << 3;
                    composer2 = composerStartRestartGroup;
                    m2255TopAppBarRx1qByU(function2, ZeroInsets, modifier9, function18, function19, j15, j16, fM2246getTopAppBarElevationD9Ej5fM, composer2, i115 | (i116 & 896) | (i116 & 7168) | (57344 & i116) | (458752 & i116) | (3670016 & i116) | (i116 & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier9;
                    function6 = function18;
                    function7 = function19;
                    j3 = j15;
                    j4 = j16;
                    f2 = fM2246getTopAppBarElevationD9Ej5fM;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    f2 = f;
                    modifier3 = modifier2;
                    function6 = function5;
                    function7 = lambda$1260131259$material;
                    j3 = primarySurface;
                    j4 = jM2360contentColorForek8zF_U;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AppBarKt.TopAppBar_xWeB9_s$lambda$0(function2, modifier3, function6, function7, j3, j4, f2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            lambda$1260131259$material = function4;
            if ((i & 24576) == 0) {
                primarySurface = j;
                if ((i2 & 16) == 0) {
                    i13 = 8192;
                } else {
                    i13 = 8192;
                }
                i3 |= i13;
            } else {
                primarySurface = j;
            }
            if ((196608 & i) == 0) {
                jM2360contentColorForek8zF_U = j2;
                if ((i2 & 32) == 0) {
                    i12 = 65536;
                } else {
                    i12 = 65536;
                }
                i3 |= i12;
            } else {
                jM2360contentColorForek8zF_U = j2;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            i10 = i3;
            if ((i3 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i10 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "165@7582L6,166@7631L32");
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        lambda$1260131259$material = ComposableSingletons$AppBarKt.INSTANCE.getLambda$1260131259$material();
                    }
                    if ((i2 & 16) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i11 = i10 & (-57345);
                    } else {
                        i11 = i10;
                    }
                    if ((i2 & 32) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i11 >> 12) & 14);
                        i11 &= -458753;
                    }
                    if (i8 != 0) {
                        fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                    } else {
                        fM2246getTopAppBarElevationD9Ej5fM = f;
                    }
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        lambda$1260131259$material = ComposableSingletons$AppBarKt.INSTANCE.getLambda$1260131259$material();
                    }
                    if ((i2 & 16) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i11 = i10 & (-57345);
                    } else {
                        i11 = i10;
                    }
                    if ((i2 & 32) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i11 >> 12) & 14);
                        i11 &= -458753;
                    }
                    if (i8 != 0) {
                        fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                    } else {
                        fM2246getTopAppBarElevationD9Ej5fM = f;
                    }
                }
                long j17 = primarySurface;
                long j18 = jM2360contentColorForek8zF_U;
                Modifier modifier10 = modifier2;
                Function2<? super Composer, ? super Integer, Unit> function110 = function5;
                Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function111 = lambda$1260131259$material;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-350082398, i11, -1, "androidx.compose.material.TopAppBar (AppBar.kt:168)");
                }
                int i117 = (i11 & 14) | 48;
                int i118 = i11 << 3;
                composer2 = composerStartRestartGroup;
                m2255TopAppBarRx1qByU(function2, ZeroInsets, modifier10, function110, function111, j17, j18, fM2246getTopAppBarElevationD9Ej5fM, composer2, i117 | (i118 & 896) | (i118 & 7168) | (57344 & i118) | (458752 & i118) | (3670016 & i118) | (i118 & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier10;
                function6 = function110;
                function7 = function111;
                j3 = j17;
                j4 = j18;
                f2 = fM2246getTopAppBarElevationD9Ej5fM;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                f2 = f;
                modifier3 = modifier2;
                function6 = function5;
                function7 = lambda$1260131259$material;
                j3 = primarySurface;
                j4 = jM2360contentColorForek8zF_U;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AppBarKt.TopAppBar_xWeB9_s$lambda$0(function2, modifier3, function6, function7, j3, j4, f2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        function5 = function3;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 3072) == 0) {
                lambda$1260131259$material = function4;
                if (composerStartRestartGroup.changedInstance(lambda$1260131259$material)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            if ((i & 24576) == 0) {
                primarySurface = j;
                if ((i2 & 16) == 0) {
                    i13 = 8192;
                } else {
                    i13 = 8192;
                }
                i3 |= i13;
            } else {
                primarySurface = j;
            }
            if ((196608 & i) == 0) {
                jM2360contentColorForek8zF_U = j2;
                if ((i2 & 32) == 0) {
                    i12 = 65536;
                } else {
                    i12 = 65536;
                }
                i3 |= i12;
            } else {
                jM2360contentColorForek8zF_U = j2;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            i10 = i3;
            if ((i3 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i10 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "165@7582L6,166@7631L32");
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        lambda$1260131259$material = ComposableSingletons$AppBarKt.INSTANCE.getLambda$1260131259$material();
                    }
                    if ((i2 & 16) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i11 = i10 & (-57345);
                    } else {
                        i11 = i10;
                    }
                    if ((i2 & 32) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i11 >> 12) & 14);
                        i11 &= -458753;
                    }
                    if (i8 != 0) {
                        fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                    } else {
                        fM2246getTopAppBarElevationD9Ej5fM = f;
                    }
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        lambda$1260131259$material = ComposableSingletons$AppBarKt.INSTANCE.getLambda$1260131259$material();
                    }
                    if ((i2 & 16) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i11 = i10 & (-57345);
                    } else {
                        i11 = i10;
                    }
                    if ((i2 & 32) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i11 >> 12) & 14);
                        i11 &= -458753;
                    }
                    if (i8 != 0) {
                        fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                    } else {
                        fM2246getTopAppBarElevationD9Ej5fM = f;
                    }
                }
                long j19 = primarySurface;
                long j110 = jM2360contentColorForek8zF_U;
                Modifier modifier11 = modifier2;
                Function2<? super Composer, ? super Integer, Unit> function112 = function5;
                Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function113 = lambda$1260131259$material;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-350082398, i11, -1, "androidx.compose.material.TopAppBar (AppBar.kt:168)");
                }
                int i119 = (i11 & 14) | 48;
                int i1110 = i11 << 3;
                composer2 = composerStartRestartGroup;
                m2255TopAppBarRx1qByU(function2, ZeroInsets, modifier11, function112, function113, j19, j110, fM2246getTopAppBarElevationD9Ej5fM, composer2, i119 | (i1110 & 896) | (i1110 & 7168) | (57344 & i1110) | (458752 & i1110) | (3670016 & i1110) | (i1110 & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier11;
                function6 = function112;
                function7 = function113;
                j3 = j19;
                j4 = j110;
                f2 = fM2246getTopAppBarElevationD9Ej5fM;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                f2 = f;
                modifier3 = modifier2;
                function6 = function5;
                function7 = lambda$1260131259$material;
                j3 = primarySurface;
                j4 = jM2360contentColorForek8zF_U;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AppBarKt.TopAppBar_xWeB9_s$lambda$0(function2, modifier3, function6, function7, j3, j4, f2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        lambda$1260131259$material = function4;
        if ((i & 24576) == 0) {
            primarySurface = j;
            if ((i2 & 16) == 0) {
                i13 = 8192;
            } else {
                i13 = 8192;
            }
            i3 |= i13;
        } else {
            primarySurface = j;
        }
        if ((196608 & i) == 0) {
            jM2360contentColorForek8zF_U = j2;
            if ((i2 & 32) == 0) {
                i12 = 65536;
            } else {
                i12 = 65536;
            }
            i3 |= i12;
        } else {
            jM2360contentColorForek8zF_U = j2;
        }
        i8 = i2 & 64;
        if (i8 != 0) {
            i3 |= 1572864;
        } else if ((i & 1572864) == 0) {
            if (composerStartRestartGroup.changed(f)) {
                i9 = 1048576;
            } else {
                i9 = 524288;
            }
            i3 |= i9;
        }
        i10 = i3;
        if ((i3 & 599187) != 599186) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i10 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "165@7582L6,166@7631L32");
            if ((i & 1) != 0) {
                if (i14 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    function5 = null;
                }
                if (i6 != 0) {
                    lambda$1260131259$material = ComposableSingletons$AppBarKt.INSTANCE.getLambda$1260131259$material();
                }
                if ((i2 & 16) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i11 = i10 & (-57345);
                } else {
                    i11 = i10;
                }
                if ((i2 & 32) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i11 >> 12) & 14);
                    i11 &= -458753;
                }
                if (i8 != 0) {
                    fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                } else {
                    fM2246getTopAppBarElevationD9Ej5fM = f;
                }
            } else {
                if (i14 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    function5 = null;
                }
                if (i6 != 0) {
                    lambda$1260131259$material = ComposableSingletons$AppBarKt.INSTANCE.getLambda$1260131259$material();
                }
                if ((i2 & 16) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i11 = i10 & (-57345);
                } else {
                    i11 = i10;
                }
                if ((i2 & 32) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i11 >> 12) & 14);
                    i11 &= -458753;
                }
                if (i8 != 0) {
                    fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                } else {
                    fM2246getTopAppBarElevationD9Ej5fM = f;
                }
            }
            long j111 = primarySurface;
            long j112 = jM2360contentColorForek8zF_U;
            Modifier modifier12 = modifier2;
            Function2<? super Composer, ? super Integer, Unit> function114 = function5;
            Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function115 = lambda$1260131259$material;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-350082398, i11, -1, "androidx.compose.material.TopAppBar (AppBar.kt:168)");
            }
            int i1111 = (i11 & 14) | 48;
            int i1112 = i11 << 3;
            composer2 = composerStartRestartGroup;
            m2255TopAppBarRx1qByU(function2, ZeroInsets, modifier12, function114, function115, j111, j112, fM2246getTopAppBarElevationD9Ej5fM, composer2, i1111 | (i1112 & 896) | (i1112 & 7168) | (57344 & i1112) | (458752 & i1112) | (3670016 & i1112) | (i1112 & 29360128), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier12;
            function6 = function114;
            function7 = function115;
            j3 = j111;
            j4 = j112;
            f2 = fM2246getTopAppBarElevationD9Ej5fM;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            f2 = f;
            modifier3 = modifier2;
            function6 = function5;
            function7 = lambda$1260131259$material;
            j3 = primarySurface;
            j4 = jM2360contentColorForek8zF_U;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBarKt.TopAppBar_xWeB9_s$lambda$0(function2, modifier3, function6, function7, j3, j4, f2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x012d  */
    /* JADX WARN: Code duplicated, block: B:102:0x0136  */
    /* JADX WARN: Code duplicated, block: B:105:0x014c  */
    /* JADX WARN: Code duplicated, block: B:108:0x018a  */
    /* JADX WARN: Code duplicated, block: B:110:0x0195  */
    /* JADX WARN: Code duplicated, block: B:113:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:25:0x0048  */
    /* JADX WARN: Code duplicated, block: B:27:0x0050  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:34:0x005f  */
    /* JADX WARN: Code duplicated, block: B:36:0x0063  */
    /* JADX WARN: Code duplicated, block: B:38:0x006b  */
    /* JADX WARN: Code duplicated, block: B:39:0x006e  */
    /* JADX WARN: Code duplicated, block: B:42:0x0074  */
    /* JADX WARN: Code duplicated, block: B:45:0x007a  */
    /* JADX WARN: Code duplicated, block: B:46:0x007d  */
    /* JADX WARN: Code duplicated, block: B:48:0x0081  */
    /* JADX WARN: Code duplicated, block: B:50:0x0089  */
    /* JADX WARN: Code duplicated, block: B:51:0x008c  */
    /* JADX WARN: Code duplicated, block: B:56:0x0098  */
    /* JADX WARN: Code duplicated, block: B:57:0x009a  */
    /* JADX WARN: Code duplicated, block: B:59:0x009d  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:69:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:70:0x00be  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:75:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:79:0x00da  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:90:0x00fc A[PHI: r3 r5 r6 r8 r12
      0x00fc: PHI (r3v20 int) = (r3v14 int), (r3v21 int), (r3v22 int) binds: [B:101:0x0134, B:88:0x00f8, B:89:0x00fa] A[DONT_GENERATE, DONT_INLINE]
      0x00fc: PHI (r5v8 androidx.compose.ui.Modifier) = (r5v5 androidx.compose.ui.Modifier), (r5v2 androidx.compose.ui.Modifier), (r5v2 androidx.compose.ui.Modifier) binds: [B:101:0x0134, B:88:0x00f8, B:89:0x00fa] A[DONT_GENERATE, DONT_INLINE]
      0x00fc: PHI (r6v9 long) = (r6v7 long), (r6v6 long), (r6v6 long) binds: [B:101:0x0134, B:88:0x00f8, B:89:0x00fa] A[DONT_GENERATE, DONT_INLINE]
      0x00fc: PHI (r8v8 long) = (r8v5 long), (r8v2 long), (r8v2 long) binds: [B:101:0x0134, B:88:0x00f8, B:89:0x00fa] A[DONT_GENERATE, DONT_INLINE]
      0x00fc: PHI (r12v6 float) = (r12v4 float), (r12v2 float), (r12v2 float) binds: [B:101:0x0134, B:88:0x00f8, B:89:0x00fa] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:91:0x0104 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x0106  */
    /* JADX WARN: Code duplicated, block: B:95:0x010f  */
    /* JADX WARN: Code duplicated, block: B:98:0x0120  */
    /* JADX INFO: renamed from: TopAppBar-afqeVBk, reason: not valid java name */
    public static final void m2256TopAppBarafqeVBk(final WindowInsets windowInsets, Modifier modifier, long j, long j2, float f, PaddingValues paddingValues, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        long primarySurface;
        long jM2360contentColorForek8zF_U;
        int i4;
        float fM2246getTopAppBarElevationD9Ej5fM;
        int i5;
        int i6;
        PaddingValues paddingValues2;
        int i7;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        final long j3;
        final long j4;
        final float f2;
        final PaddingValues paddingValues3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        PaddingValues contentPadding;
        Modifier modifier4;
        long j5;
        float f3;
        long j6;
        int i8;
        Composer composerStartRestartGroup = composer.startRestartGroup(684777089);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TopAppBar)N(windowInsets,modifier,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation:c#ui.unit.Dp,contentPadding,content)222@10051L205:AppBar.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(windowInsets) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    primarySurface = j;
                    int i10 = composerStartRestartGroup.changed(primarySurface) ? 256 : 128;
                    i3 |= i10;
                } else {
                    primarySurface = j;
                }
                i3 |= i10;
            } else {
                primarySurface = j;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    jM2360contentColorForek8zF_U = j2;
                    int i11 = composerStartRestartGroup.changed(jM2360contentColorForek8zF_U) ? 2048 : 1024;
                    i3 |= i11;
                } else {
                    jM2360contentColorForek8zF_U = j2;
                }
                i3 |= i11;
            } else {
                jM2360contentColorForek8zF_U = j2;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    fM2246getTopAppBarElevationD9Ej5fM = f;
                    if (composerStartRestartGroup.changed(fM2246getTopAppBarElevationD9Ej5fM)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    if ((196608 & i) == 0) {
                        paddingValues2 = paddingValues;
                        if (composerStartRestartGroup.changed(paddingValues2)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                    if ((1572864 & i) != 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i8 = 1048576;
                        } else {
                            i8 = 524288;
                        }
                        i3 |= i8;
                    }
                    if ((i3 & 599187) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "216@9792L6,217@9841L32");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i9 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 6) & 14);
                                i3 &= -7169;
                            }
                            if (i4 != 0) {
                                fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                            }
                            if (i6 != 0) {
                                contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                                modifier4 = modifier2;
                                j5 = jM2360contentColorForek8zF_U;
                                f3 = fM2246getTopAppBarElevationD9Ej5fM;
                                j6 = primarySurface;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(684777089, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:221)");
                            }
                            int i12 = i3 >> 6;
                            int i13 = i3 << 15;
                            composer2 = composerStartRestartGroup;
                            m2251AppBarHkEspTQ(j6, j5, f3, contentPadding, RectangleShapeKt.getRectangleShape(), windowInsets, modifier4, function3, composer2, (i12 & 7168) | (i12 & 14) | 24576 | (i12 & 112) | (i12 & 896) | (458752 & i13) | (i13 & 3670016) | ((i3 << 3) & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            j3 = j6;
                            j4 = j5;
                            f2 = f3;
                            paddingValues3 = contentPadding;
                            modifier3 = modifier4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                        }
                        modifier4 = modifier2;
                        f3 = fM2246getTopAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                        j6 = primarySurface;
                        j5 = jM2360contentColorForek8zF_U;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(684777089, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:221)");
                        }
                        int i14 = i3 >> 6;
                        int i15 = i3 << 15;
                        composer2 = composerStartRestartGroup;
                        m2251AppBarHkEspTQ(j6, j5, f3, contentPadding, RectangleShapeKt.getRectangleShape(), windowInsets, modifier4, function3, composer2, (i14 & 7168) | (i14 & 14) | 24576 | (i14 & 112) | (i14 & 896) | (458752 & i15) | (i15 & 3670016) | ((i3 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j3 = j6;
                        j4 = j5;
                        f2 = f3;
                        paddingValues3 = contentPadding;
                        modifier3 = modifier4;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        j3 = primarySurface;
                        j4 = jM2360contentColorForek8zF_U;
                        f2 = fM2246getTopAppBarElevationD9Ej5fM;
                        paddingValues3 = paddingValues2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AppBarKt.TopAppBar_afqeVBk$lambda$0(windowInsets, modifier3, j3, j4, f2, paddingValues3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                paddingValues2 = paddingValues;
                if ((1572864 & i) != 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i8 = 1048576;
                    } else {
                        i8 = 524288;
                    }
                    i3 |= i8;
                }
                if ((i3 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "216@9792L6,217@9841L32");
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            modifier4 = modifier2;
                            j5 = jM2360contentColorForek8zF_U;
                            f3 = fM2246getTopAppBarElevationD9Ej5fM;
                            j6 = primarySurface;
                        } else {
                            modifier4 = modifier2;
                            f3 = fM2246getTopAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                            j6 = primarySurface;
                            j5 = jM2360contentColorForek8zF_U;
                        }
                    } else {
                        if (i9 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            modifier4 = modifier2;
                            j5 = jM2360contentColorForek8zF_U;
                            f3 = fM2246getTopAppBarElevationD9Ej5fM;
                            j6 = primarySurface;
                        } else {
                            modifier4 = modifier2;
                            f3 = fM2246getTopAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                            j6 = primarySurface;
                            j5 = jM2360contentColorForek8zF_U;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(684777089, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:221)");
                    }
                    int i16 = i3 >> 6;
                    int i17 = i3 << 15;
                    composer2 = composerStartRestartGroup;
                    m2251AppBarHkEspTQ(j6, j5, f3, contentPadding, RectangleShapeKt.getRectangleShape(), windowInsets, modifier4, function3, composer2, (i16 & 7168) | (i16 & 14) | 24576 | (i16 & 112) | (i16 & 896) | (458752 & i17) | (i17 & 3670016) | ((i3 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j3 = j6;
                    j4 = j5;
                    f2 = f3;
                    paddingValues3 = contentPadding;
                    modifier3 = modifier4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    j3 = primarySurface;
                    j4 = jM2360contentColorForek8zF_U;
                    f2 = fM2246getTopAppBarElevationD9Ej5fM;
                    paddingValues3 = paddingValues2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AppBarKt.TopAppBar_afqeVBk$lambda$0(windowInsets, modifier3, j3, j4, f2, paddingValues3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            fM2246getTopAppBarElevationD9Ej5fM = f;
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    paddingValues2 = paddingValues;
                    if (composerStartRestartGroup.changed(paddingValues2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((1572864 & i) != 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i8 = 1048576;
                    } else {
                        i8 = 524288;
                    }
                    i3 |= i8;
                }
                if ((i3 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "216@9792L6,217@9841L32");
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            modifier4 = modifier2;
                            j5 = jM2360contentColorForek8zF_U;
                            f3 = fM2246getTopAppBarElevationD9Ej5fM;
                            j6 = primarySurface;
                        } else {
                            modifier4 = modifier2;
                            f3 = fM2246getTopAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                            j6 = primarySurface;
                            j5 = jM2360contentColorForek8zF_U;
                        }
                    } else {
                        if (i9 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            modifier4 = modifier2;
                            j5 = jM2360contentColorForek8zF_U;
                            f3 = fM2246getTopAppBarElevationD9Ej5fM;
                            j6 = primarySurface;
                        } else {
                            modifier4 = modifier2;
                            f3 = fM2246getTopAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                            j6 = primarySurface;
                            j5 = jM2360contentColorForek8zF_U;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(684777089, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:221)");
                    }
                    int i18 = i3 >> 6;
                    int i19 = i3 << 15;
                    composer2 = composerStartRestartGroup;
                    m2251AppBarHkEspTQ(j6, j5, f3, contentPadding, RectangleShapeKt.getRectangleShape(), windowInsets, modifier4, function3, composer2, (i18 & 7168) | (i18 & 14) | 24576 | (i18 & 112) | (i18 & 896) | (458752 & i19) | (i19 & 3670016) | ((i3 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j3 = j6;
                    j4 = j5;
                    f2 = f3;
                    paddingValues3 = contentPadding;
                    modifier3 = modifier4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    j3 = primarySurface;
                    j4 = jM2360contentColorForek8zF_U;
                    f2 = fM2246getTopAppBarElevationD9Ej5fM;
                    paddingValues3 = paddingValues2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AppBarKt.TopAppBar_afqeVBk$lambda$0(windowInsets, modifier3, j3, j4, f2, paddingValues3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            paddingValues2 = paddingValues;
            if ((1572864 & i) != 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i8 = 1048576;
                } else {
                    i8 = 524288;
                }
                i3 |= i8;
            }
            if ((i3 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "216@9792L6,217@9841L32");
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        modifier4 = modifier2;
                        j5 = jM2360contentColorForek8zF_U;
                        f3 = fM2246getTopAppBarElevationD9Ej5fM;
                        j6 = primarySurface;
                    } else {
                        modifier4 = modifier2;
                        f3 = fM2246getTopAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                        j6 = primarySurface;
                        j5 = jM2360contentColorForek8zF_U;
                    }
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        modifier4 = modifier2;
                        j5 = jM2360contentColorForek8zF_U;
                        f3 = fM2246getTopAppBarElevationD9Ej5fM;
                        j6 = primarySurface;
                    } else {
                        modifier4 = modifier2;
                        f3 = fM2246getTopAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                        j6 = primarySurface;
                        j5 = jM2360contentColorForek8zF_U;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(684777089, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:221)");
                }
                int i110 = i3 >> 6;
                int i111 = i3 << 15;
                composer2 = composerStartRestartGroup;
                m2251AppBarHkEspTQ(j6, j5, f3, contentPadding, RectangleShapeKt.getRectangleShape(), windowInsets, modifier4, function3, composer2, (i110 & 7168) | (i110 & 14) | 24576 | (i110 & 112) | (i110 & 896) | (458752 & i111) | (i111 & 3670016) | ((i3 << 3) & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j3 = j6;
                j4 = j5;
                f2 = f3;
                paddingValues3 = contentPadding;
                modifier3 = modifier4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                j3 = primarySurface;
                j4 = jM2360contentColorForek8zF_U;
                f2 = fM2246getTopAppBarElevationD9Ej5fM;
                paddingValues3 = paddingValues2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AppBarKt.TopAppBar_afqeVBk$lambda$0(windowInsets, modifier3, j3, j4, f2, paddingValues3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                primarySurface = j;
                if (composerStartRestartGroup.changed(primarySurface)) {
                }
                i3 |= i10;
            } else {
                primarySurface = j;
            }
            i3 |= i10;
        } else {
            primarySurface = j;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                jM2360contentColorForek8zF_U = j2;
                if (composerStartRestartGroup.changed(jM2360contentColorForek8zF_U)) {
                }
                i3 |= i11;
            } else {
                jM2360contentColorForek8zF_U = j2;
            }
            i3 |= i11;
        } else {
            jM2360contentColorForek8zF_U = j2;
        }
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                fM2246getTopAppBarElevationD9Ej5fM = f;
                if (composerStartRestartGroup.changed(fM2246getTopAppBarElevationD9Ej5fM)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    paddingValues2 = paddingValues;
                    if (composerStartRestartGroup.changed(paddingValues2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((1572864 & i) != 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i8 = 1048576;
                    } else {
                        i8 = 524288;
                    }
                    i3 |= i8;
                }
                if ((i3 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "216@9792L6,217@9841L32");
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            modifier4 = modifier2;
                            j5 = jM2360contentColorForek8zF_U;
                            f3 = fM2246getTopAppBarElevationD9Ej5fM;
                            j6 = primarySurface;
                        } else {
                            modifier4 = modifier2;
                            f3 = fM2246getTopAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                            j6 = primarySurface;
                            j5 = jM2360contentColorForek8zF_U;
                        }
                    } else {
                        if (i9 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            modifier4 = modifier2;
                            j5 = jM2360contentColorForek8zF_U;
                            f3 = fM2246getTopAppBarElevationD9Ej5fM;
                            j6 = primarySurface;
                        } else {
                            modifier4 = modifier2;
                            f3 = fM2246getTopAppBarElevationD9Ej5fM;
                            contentPadding = paddingValues2;
                            j6 = primarySurface;
                            j5 = jM2360contentColorForek8zF_U;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(684777089, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:221)");
                    }
                    int i112 = i3 >> 6;
                    int i113 = i3 << 15;
                    composer2 = composerStartRestartGroup;
                    m2251AppBarHkEspTQ(j6, j5, f3, contentPadding, RectangleShapeKt.getRectangleShape(), windowInsets, modifier4, function3, composer2, (i112 & 7168) | (i112 & 14) | 24576 | (i112 & 112) | (i112 & 896) | (458752 & i113) | (i113 & 3670016) | ((i3 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j3 = j6;
                    j4 = j5;
                    f2 = f3;
                    paddingValues3 = contentPadding;
                    modifier3 = modifier4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    j3 = primarySurface;
                    j4 = jM2360contentColorForek8zF_U;
                    f2 = fM2246getTopAppBarElevationD9Ej5fM;
                    paddingValues3 = paddingValues2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AppBarKt.TopAppBar_afqeVBk$lambda$0(windowInsets, modifier3, j3, j4, f2, paddingValues3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            paddingValues2 = paddingValues;
            if ((1572864 & i) != 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i8 = 1048576;
                } else {
                    i8 = 524288;
                }
                i3 |= i8;
            }
            if ((i3 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "216@9792L6,217@9841L32");
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        modifier4 = modifier2;
                        j5 = jM2360contentColorForek8zF_U;
                        f3 = fM2246getTopAppBarElevationD9Ej5fM;
                        j6 = primarySurface;
                    } else {
                        modifier4 = modifier2;
                        f3 = fM2246getTopAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                        j6 = primarySurface;
                        j5 = jM2360contentColorForek8zF_U;
                    }
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        modifier4 = modifier2;
                        j5 = jM2360contentColorForek8zF_U;
                        f3 = fM2246getTopAppBarElevationD9Ej5fM;
                        j6 = primarySurface;
                    } else {
                        modifier4 = modifier2;
                        f3 = fM2246getTopAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                        j6 = primarySurface;
                        j5 = jM2360contentColorForek8zF_U;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(684777089, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:221)");
                }
                int i114 = i3 >> 6;
                int i115 = i3 << 15;
                composer2 = composerStartRestartGroup;
                m2251AppBarHkEspTQ(j6, j5, f3, contentPadding, RectangleShapeKt.getRectangleShape(), windowInsets, modifier4, function3, composer2, (i114 & 7168) | (i114 & 14) | 24576 | (i114 & 112) | (i114 & 896) | (458752 & i115) | (i115 & 3670016) | ((i3 << 3) & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j3 = j6;
                j4 = j5;
                f2 = f3;
                paddingValues3 = contentPadding;
                modifier3 = modifier4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                j3 = primarySurface;
                j4 = jM2360contentColorForek8zF_U;
                f2 = fM2246getTopAppBarElevationD9Ej5fM;
                paddingValues3 = paddingValues2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AppBarKt.TopAppBar_afqeVBk$lambda$0(windowInsets, modifier3, j3, j4, f2, paddingValues3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        fM2246getTopAppBarElevationD9Ej5fM = f;
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((196608 & i) == 0) {
                paddingValues2 = paddingValues;
                if (composerStartRestartGroup.changed(paddingValues2)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            if ((1572864 & i) != 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i8 = 1048576;
                } else {
                    i8 = 524288;
                }
                i3 |= i8;
            }
            if ((i3 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "216@9792L6,217@9841L32");
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        modifier4 = modifier2;
                        j5 = jM2360contentColorForek8zF_U;
                        f3 = fM2246getTopAppBarElevationD9Ej5fM;
                        j6 = primarySurface;
                    } else {
                        modifier4 = modifier2;
                        f3 = fM2246getTopAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                        j6 = primarySurface;
                        j5 = jM2360contentColorForek8zF_U;
                    }
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        modifier4 = modifier2;
                        j5 = jM2360contentColorForek8zF_U;
                        f3 = fM2246getTopAppBarElevationD9Ej5fM;
                        j6 = primarySurface;
                    } else {
                        modifier4 = modifier2;
                        f3 = fM2246getTopAppBarElevationD9Ej5fM;
                        contentPadding = paddingValues2;
                        j6 = primarySurface;
                        j5 = jM2360contentColorForek8zF_U;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(684777089, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:221)");
                }
                int i116 = i3 >> 6;
                int i117 = i3 << 15;
                composer2 = composerStartRestartGroup;
                m2251AppBarHkEspTQ(j6, j5, f3, contentPadding, RectangleShapeKt.getRectangleShape(), windowInsets, modifier4, function3, composer2, (i116 & 7168) | (i116 & 14) | 24576 | (i116 & 112) | (i116 & 896) | (458752 & i117) | (i117 & 3670016) | ((i3 << 3) & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j3 = j6;
                j4 = j5;
                f2 = f3;
                paddingValues3 = contentPadding;
                modifier3 = modifier4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                j3 = primarySurface;
                j4 = jM2360contentColorForek8zF_U;
                f2 = fM2246getTopAppBarElevationD9Ej5fM;
                paddingValues3 = paddingValues2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AppBarKt.TopAppBar_afqeVBk$lambda$0(windowInsets, modifier3, j3, j4, f2, paddingValues3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        paddingValues2 = paddingValues;
        if ((1572864 & i) != 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i8 = 1048576;
            } else {
                i8 = 524288;
            }
            i3 |= i8;
        }
        if ((i3 & 599187) != 599186) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "216@9792L6,217@9841L32");
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 4) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 6) & 14);
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                }
                if (i6 != 0) {
                    contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                    modifier4 = modifier2;
                    j5 = jM2360contentColorForek8zF_U;
                    f3 = fM2246getTopAppBarElevationD9Ej5fM;
                    j6 = primarySurface;
                } else {
                    modifier4 = modifier2;
                    f3 = fM2246getTopAppBarElevationD9Ej5fM;
                    contentPadding = paddingValues2;
                    j6 = primarySurface;
                    j5 = jM2360contentColorForek8zF_U;
                }
            } else {
                if (i9 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 4) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 6) & 14);
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                }
                if (i6 != 0) {
                    contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                    modifier4 = modifier2;
                    j5 = jM2360contentColorForek8zF_U;
                    f3 = fM2246getTopAppBarElevationD9Ej5fM;
                    j6 = primarySurface;
                } else {
                    modifier4 = modifier2;
                    f3 = fM2246getTopAppBarElevationD9Ej5fM;
                    contentPadding = paddingValues2;
                    j6 = primarySurface;
                    j5 = jM2360contentColorForek8zF_U;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(684777089, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:221)");
            }
            int i118 = i3 >> 6;
            int i119 = i3 << 15;
            composer2 = composerStartRestartGroup;
            m2251AppBarHkEspTQ(j6, j5, f3, contentPadding, RectangleShapeKt.getRectangleShape(), windowInsets, modifier4, function3, composer2, (i118 & 7168) | (i118 & 14) | 24576 | (i118 & 112) | (i118 & 896) | (458752 & i119) | (i119 & 3670016) | ((i3 << 3) & 29360128), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j3 = j6;
            j4 = j5;
            f2 = f3;
            paddingValues3 = contentPadding;
            modifier3 = modifier4;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            j3 = primarySurface;
            j4 = jM2360contentColorForek8zF_U;
            f2 = fM2246getTopAppBarElevationD9Ej5fM;
            paddingValues3 = paddingValues2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBarKt.TopAppBar_afqeVBk$lambda$0(windowInsets, modifier3, j3, j4, f2, paddingValues3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x013e  */
    /* JADX WARN: Code duplicated, block: B:103:0x017a  */
    /* JADX WARN: Code duplicated, block: B:105:0x0184  */
    /* JADX WARN: Code duplicated, block: B:108:0x0194  */
    /* JADX WARN: Code duplicated, block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x0084  */
    /* JADX WARN: Code duplicated, block: B:49:0x0087  */
    /* JADX WARN: Code duplicated, block: B:51:0x008b  */
    /* JADX WARN: Code duplicated, block: B:53:0x0093  */
    /* JADX WARN: Code duplicated, block: B:54:0x0096  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:85:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:89:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:92:0x010e  */
    /* JADX WARN: Code duplicated, block: B:94:0x011b  */
    /* JADX WARN: Code duplicated, block: B:96:0x0124  */
    /* JADX WARN: Code duplicated, block: B:97:0x0132  */
    /* JADX INFO: renamed from: TopAppBar-HsRjFd4, reason: not valid java name */
    public static final void m2254TopAppBarHsRjFd4(Modifier modifier, long j, long j2, float f, PaddingValues paddingValues, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long primarySurface;
        long j3;
        float fM2246getTopAppBarElevationD9Ej5fM;
        int i4;
        PaddingValues paddingValues2;
        int i5;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        final long j4;
        final long j5;
        final float f2;
        final PaddingValues paddingValues3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Modifier modifier4;
        long j6;
        float f3;
        PaddingValues contentPadding;
        long j7;
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2030536439);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TopAppBar)N(modifier,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation:c#ui.unit.Dp,contentPadding,content)270@12153L203:AppBar.kt#jmzs0o");
        int i7 = i2 & 1;
        if (i7 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                primarySurface = j;
                int i8 = composerStartRestartGroup.changed(primarySurface) ? 32 : 16;
                i3 |= i8;
            } else {
                primarySurface = j;
            }
            i3 |= i8;
        } else {
            primarySurface = j;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                j3 = j2;
                int i9 = composerStartRestartGroup.changed(j3) ? 256 : 128;
                i3 |= i9;
            } else {
                j3 = j2;
            }
            i3 |= i9;
        } else {
            j3 = j2;
        }
        int i10 = i2 & 8;
        if (i10 == 0) {
            if ((i & 3072) == 0) {
                fM2246getTopAppBarElevationD9Ej5fM = f;
                i3 |= composerStartRestartGroup.changed(fM2246getTopAppBarElevationD9Ej5fM) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    paddingValues2 = paddingValues;
                    if (composerStartRestartGroup.changed(paddingValues2)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                if ((196608 & i) != 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i6 = 131072;
                    } else {
                        i6 = 65536;
                    }
                    i3 |= i6;
                }
                if ((74899 & i3) != 74898) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "264@11894L6,265@11943L32");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i7 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        }
                        if ((i2 & 4) != 0) {
                            long jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j3 = jM2360contentColorForek8zF_U;
                        }
                        if (i10 != 0) {
                            fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            modifier4 = companion;
                            j6 = j3;
                            f3 = fM2246getTopAppBarElevationD9Ej5fM;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            j7 = primarySurface;
                        } else {
                            modifier4 = companion;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2030536439, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:269)");
                        }
                        int i11 = i3 >> 3;
                        composer2 = composerStartRestartGroup;
                        m2251AppBarHkEspTQ(j7, j6, f3, contentPadding, RectangleShapeKt.getRectangleShape(), ZeroInsets, modifier4, function3, composer2, (i11 & 7168) | (i11 & 14) | 221184 | (i11 & 112) | (i11 & 896) | ((i3 << 18) & 3670016) | ((i3 << 6) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j4 = j7;
                        j5 = j6;
                        f2 = f3;
                        paddingValues3 = contentPadding;
                        modifier3 = modifier4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        modifier4 = modifier2;
                    }
                    f3 = fM2246getTopAppBarElevationD9Ej5fM;
                    j7 = primarySurface;
                    contentPadding = paddingValues2;
                    j6 = j3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2030536439, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:269)");
                    }
                    int i12 = i3 >> 3;
                    composer2 = composerStartRestartGroup;
                    m2251AppBarHkEspTQ(j7, j6, f3, contentPadding, RectangleShapeKt.getRectangleShape(), ZeroInsets, modifier4, function3, composer2, (i12 & 7168) | (i12 & 14) | 221184 | (i12 & 112) | (i12 & 896) | ((i3 << 18) & 3670016) | ((i3 << 6) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j4 = j7;
                    j5 = j6;
                    f2 = f3;
                    paddingValues3 = contentPadding;
                    modifier3 = modifier4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    j4 = primarySurface;
                    j5 = j3;
                    f2 = fM2246getTopAppBarElevationD9Ej5fM;
                    paddingValues3 = paddingValues2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AppBarKt.TopAppBar_HsRjFd4$lambda$0(modifier3, j4, j5, f2, paddingValues3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            paddingValues2 = paddingValues;
            if ((196608 & i) != 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i6 = 131072;
                } else {
                    i6 = 65536;
                }
                i3 |= i6;
            }
            if ((74899 & i3) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "264@11894L6,265@11943L32");
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    }
                    if ((i2 & 4) != 0) {
                        long jM2360contentColorForek8zF_U2 = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j3 = jM2360contentColorForek8zF_U2;
                    }
                    if (i10 != 0) {
                        fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        modifier4 = companion;
                        j6 = j3;
                        f3 = fM2246getTopAppBarElevationD9Ej5fM;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        j7 = primarySurface;
                    } else {
                        modifier4 = companion;
                        f3 = fM2246getTopAppBarElevationD9Ej5fM;
                        j7 = primarySurface;
                        contentPadding = paddingValues2;
                        j6 = j3;
                    }
                } else {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    }
                    if ((i2 & 4) != 0) {
                        long jM2360contentColorForek8zF_U3 = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j3 = jM2360contentColorForek8zF_U3;
                    }
                    if (i10 != 0) {
                        fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        modifier4 = companion;
                        j6 = j3;
                        f3 = fM2246getTopAppBarElevationD9Ej5fM;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        j7 = primarySurface;
                    } else {
                        modifier4 = companion;
                        f3 = fM2246getTopAppBarElevationD9Ej5fM;
                        j7 = primarySurface;
                        contentPadding = paddingValues2;
                        j6 = j3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2030536439, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:269)");
                }
                int i13 = i3 >> 3;
                composer2 = composerStartRestartGroup;
                m2251AppBarHkEspTQ(j7, j6, f3, contentPadding, RectangleShapeKt.getRectangleShape(), ZeroInsets, modifier4, function3, composer2, (i13 & 7168) | (i13 & 14) | 221184 | (i13 & 112) | (i13 & 896) | ((i3 << 18) & 3670016) | ((i3 << 6) & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j4 = j7;
                j5 = j6;
                f2 = f3;
                paddingValues3 = contentPadding;
                modifier3 = modifier4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                j4 = primarySurface;
                j5 = j3;
                f2 = fM2246getTopAppBarElevationD9Ej5fM;
                paddingValues3 = paddingValues2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AppBarKt.TopAppBar_HsRjFd4$lambda$0(modifier3, j4, j5, f2, paddingValues3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        fM2246getTopAppBarElevationD9Ej5fM = f;
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                paddingValues2 = paddingValues;
                if (composerStartRestartGroup.changed(paddingValues2)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            if ((196608 & i) != 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i6 = 131072;
                } else {
                    i6 = 65536;
                }
                i3 |= i6;
            }
            if ((74899 & i3) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "264@11894L6,265@11943L32");
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    }
                    if ((i2 & 4) != 0) {
                        long jM2360contentColorForek8zF_U4 = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j3 = jM2360contentColorForek8zF_U4;
                    }
                    if (i10 != 0) {
                        fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        modifier4 = companion;
                        j6 = j3;
                        f3 = fM2246getTopAppBarElevationD9Ej5fM;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        j7 = primarySurface;
                    } else {
                        modifier4 = companion;
                        f3 = fM2246getTopAppBarElevationD9Ej5fM;
                        j7 = primarySurface;
                        contentPadding = paddingValues2;
                        j6 = j3;
                    }
                } else {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    }
                    if ((i2 & 4) != 0) {
                        long jM2360contentColorForek8zF_U5 = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j3 = jM2360contentColorForek8zF_U5;
                    }
                    if (i10 != 0) {
                        fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        modifier4 = companion;
                        j6 = j3;
                        f3 = fM2246getTopAppBarElevationD9Ej5fM;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        j7 = primarySurface;
                    } else {
                        modifier4 = companion;
                        f3 = fM2246getTopAppBarElevationD9Ej5fM;
                        j7 = primarySurface;
                        contentPadding = paddingValues2;
                        j6 = j3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2030536439, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:269)");
                }
                int i14 = i3 >> 3;
                composer2 = composerStartRestartGroup;
                m2251AppBarHkEspTQ(j7, j6, f3, contentPadding, RectangleShapeKt.getRectangleShape(), ZeroInsets, modifier4, function3, composer2, (i14 & 7168) | (i14 & 14) | 221184 | (i14 & 112) | (i14 & 896) | ((i3 << 18) & 3670016) | ((i3 << 6) & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j4 = j7;
                j5 = j6;
                f2 = f3;
                paddingValues3 = contentPadding;
                modifier3 = modifier4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                j4 = primarySurface;
                j5 = j3;
                f2 = fM2246getTopAppBarElevationD9Ej5fM;
                paddingValues3 = paddingValues2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AppBarKt.TopAppBar_HsRjFd4$lambda$0(modifier3, j4, j5, f2, paddingValues3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        paddingValues2 = paddingValues;
        if ((196608 & i) != 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i6 = 131072;
            } else {
                i6 = 65536;
            }
            i3 |= i6;
        }
        if ((74899 & i3) != 74898) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "264@11894L6,265@11943L32");
            if ((i & 1) != 0) {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                }
                if ((i2 & 4) != 0) {
                    long jM2360contentColorForek8zF_U6 = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                    j3 = jM2360contentColorForek8zF_U6;
                }
                if (i10 != 0) {
                    fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                }
                if (i4 != 0) {
                    modifier4 = companion;
                    j6 = j3;
                    f3 = fM2246getTopAppBarElevationD9Ej5fM;
                    contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                    j7 = primarySurface;
                } else {
                    modifier4 = companion;
                    f3 = fM2246getTopAppBarElevationD9Ej5fM;
                    j7 = primarySurface;
                    contentPadding = paddingValues2;
                    j6 = j3;
                }
            } else {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                }
                if ((i2 & 4) != 0) {
                    long jM2360contentColorForek8zF_U7 = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                    j3 = jM2360contentColorForek8zF_U7;
                }
                if (i10 != 0) {
                    fM2246getTopAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2246getTopAppBarElevationD9Ej5fM();
                }
                if (i4 != 0) {
                    modifier4 = companion;
                    j6 = j3;
                    f3 = fM2246getTopAppBarElevationD9Ej5fM;
                    contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                    j7 = primarySurface;
                } else {
                    modifier4 = companion;
                    f3 = fM2246getTopAppBarElevationD9Ej5fM;
                    j7 = primarySurface;
                    contentPadding = paddingValues2;
                    j6 = j3;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2030536439, i3, -1, "androidx.compose.material.TopAppBar (AppBar.kt:269)");
            }
            int i15 = i3 >> 3;
            composer2 = composerStartRestartGroup;
            m2251AppBarHkEspTQ(j7, j6, f3, contentPadding, RectangleShapeKt.getRectangleShape(), ZeroInsets, modifier4, function3, composer2, (i15 & 7168) | (i15 & 14) | 221184 | (i15 & 112) | (i15 & 896) | ((i3 << 18) & 3670016) | ((i3 << 6) & 29360128), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j4 = j7;
            j5 = j6;
            f2 = f3;
            paddingValues3 = contentPadding;
            modifier3 = modifier4;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            j4 = primarySurface;
            j5 = j3;
            f2 = fM2246getTopAppBarElevationD9Ej5fM;
            paddingValues3 = paddingValues2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBarKt.TopAppBar_HsRjFd4$lambda$0(modifier3, j4, j5, f2, paddingValues3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0128 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:102:0x012a  */
    /* JADX WARN: Code duplicated, block: B:105:0x0133  */
    /* JADX WARN: Code duplicated, block: B:108:0x0144  */
    /* JADX WARN: Code duplicated, block: B:110:0x0151  */
    /* JADX WARN: Code duplicated, block: B:112:0x0155  */
    /* JADX WARN: Code duplicated, block: B:114:0x015e  */
    /* JADX WARN: Code duplicated, block: B:117:0x0170  */
    /* JADX WARN: Code duplicated, block: B:120:0x018f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:124:0x019f  */
    /* JADX WARN: Code duplicated, block: B:127:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:129:0x01de  */
    /* JADX WARN: Code duplicated, block: B:132:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:134:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:25:0x0048  */
    /* JADX WARN: Code duplicated, block: B:27:0x0050  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:34:0x005f  */
    /* JADX WARN: Code duplicated, block: B:36:0x0063  */
    /* JADX WARN: Code duplicated, block: B:38:0x006b  */
    /* JADX WARN: Code duplicated, block: B:39:0x006e  */
    /* JADX WARN: Code duplicated, block: B:42:0x0074  */
    /* JADX WARN: Code duplicated, block: B:45:0x007a  */
    /* JADX WARN: Code duplicated, block: B:46:0x007d  */
    /* JADX WARN: Code duplicated, block: B:48:0x0081  */
    /* JADX WARN: Code duplicated, block: B:50:0x0089  */
    /* JADX WARN: Code duplicated, block: B:51:0x008c  */
    /* JADX WARN: Code duplicated, block: B:56:0x0098  */
    /* JADX WARN: Code duplicated, block: B:57:0x009a  */
    /* JADX WARN: Code duplicated, block: B:59:0x009d  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:70:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:79:0x00da  */
    /* JADX WARN: Code duplicated, block: B:80:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:84:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:90:0x0105  */
    /* JADX WARN: Code duplicated, block: B:99:0x011b A[PHI: r3 r5 r6 r8 r12 r14
      0x011b: PHI (r3v22 int) = (r3v16 int), (r3v23 int), (r3v24 int) binds: [B:113:0x015c, B:97:0x0117, B:98:0x0119] A[DONT_GENERATE, DONT_INLINE]
      0x011b: PHI (r5v17 androidx.compose.ui.Modifier) = (r5v5 androidx.compose.ui.Modifier), (r5v2 androidx.compose.ui.Modifier), (r5v2 androidx.compose.ui.Modifier) binds: [B:113:0x015c, B:97:0x0117, B:98:0x0119] A[DONT_GENERATE, DONT_INLINE]
      0x011b: PHI (r6v12 long) = (r6v7 long), (r6v6 long), (r6v6 long) binds: [B:113:0x015c, B:97:0x0117, B:98:0x0119] A[DONT_GENERATE, DONT_INLINE]
      0x011b: PHI (r8v9 long) = (r8v5 long), (r8v2 long), (r8v2 long) binds: [B:113:0x015c, B:97:0x0117, B:98:0x0119] A[DONT_GENERATE, DONT_INLINE]
      0x011b: PHI (r12v8 androidx.compose.ui.graphics.Shape) = 
      (r12v4 androidx.compose.ui.graphics.Shape)
      (r12v2 androidx.compose.ui.graphics.Shape)
      (r12v2 androidx.compose.ui.graphics.Shape)
     binds: [B:113:0x015c, B:97:0x0117, B:98:0x0119] A[DONT_GENERATE, DONT_INLINE]
      0x011b: PHI (r14v8 float) = (r14v4 float), (r14v3 float), (r14v3 float) binds: [B:113:0x015c, B:97:0x0117, B:98:0x0119] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: BottomAppBar-DanWW-k, reason: not valid java name */
    public static final void m2252BottomAppBarDanWWk(final WindowInsets windowInsets, Modifier modifier, long j, long j2, Shape shape, float f, PaddingValues paddingValues, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        long primarySurface;
        long jM2360contentColorForek8zF_U;
        int i4;
        Shape shape2;
        int i5;
        int i6;
        float fM2245getBottomAppBarElevationD9Ej5fM;
        int i7;
        int i8;
        int i9;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        final long j3;
        final long j4;
        final Shape shape3;
        final float f2;
        final PaddingValues paddingValues2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        PaddingValues contentPadding;
        Shape shape4;
        BottomAppBarCutoutShape rectangleShape;
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1136595494);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BottomAppBar)N(windowInsets,modifier,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,cutoutShape,elevation:c#ui.unit.Dp,contentPadding,content)337@15398L7,344@15612L175:AppBar.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(windowInsets) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i11 = i2 & 2;
        if (i11 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    primarySurface = j;
                    int i12 = composerStartRestartGroup.changed(primarySurface) ? 256 : 128;
                    i3 |= i12;
                } else {
                    primarySurface = j;
                }
                i3 |= i12;
            } else {
                primarySurface = j;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    jM2360contentColorForek8zF_U = j2;
                    int i13 = composerStartRestartGroup.changed(jM2360contentColorForek8zF_U) ? 2048 : 1024;
                    i3 |= i13;
                } else {
                    jM2360contentColorForek8zF_U = j2;
                }
                i3 |= i13;
            } else {
                jM2360contentColorForek8zF_U = j2;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    if ((196608 & i) == 0) {
                        fM2245getBottomAppBarElevationD9Ej5fM = f;
                        if (composerStartRestartGroup.changed(fM2245getBottomAppBarElevationD9Ej5fM)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 64;
                    if (i8 != 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(paddingValues)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i10 = 8388608;
                        } else {
                            i10 = 4194304;
                        }
                        i3 |= i10;
                    }
                    if ((i3 & 4793491) != 4793490) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "330@15067L6,331@15116L32");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 6) & 14);
                                i3 &= -7169;
                            }
                            if (i4 != 0) {
                                shape2 = null;
                            }
                            if (i6 != 0) {
                                fM2245getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2245getBottomAppBarElevationD9Ej5fM();
                            }
                            if (i8 != 0) {
                                contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            }
                            Modifier modifier4 = modifier2;
                            shape4 = shape2;
                            float f3 = fM2245getBottomAppBarElevationD9Ej5fM;
                            long j5 = primarySurface;
                            long j6 = jM2360contentColorForek8zF_U;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1136595494, i3, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:336)");
                            }
                            ProvidableCompositionLocal<FabPlacement> localFabPlacement = ScaffoldKt.getLocalFabPlacement();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(localFabPlacement);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            FabPlacement fabPlacement = (FabPlacement) objConsume;
                            if (shape4 == null && fabPlacement != null && fabPlacement.getIsDocked()) {
                                rectangleShape = new BottomAppBarCutoutShape(shape4, fabPlacement);
                            } else {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            }
                            Shape shape5 = rectangleShape;
                            int i14 = i3 >> 9;
                            int i15 = ((i3 >> 6) & 126) | (i14 & 896) | (i14 & 7168);
                            int i16 = i3 << 15;
                            composer2 = composerStartRestartGroup;
                            m2251AppBarHkEspTQ(j5, j6, f3, contentPadding, shape5, windowInsets, modifier4, function3, composer2, i15 | (458752 & i16) | (i16 & 3670016) | (i3 & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            shape3 = shape4;
                            j3 = j5;
                            j4 = j6;
                            f2 = f3;
                            paddingValues2 = contentPadding;
                            modifier3 = modifier4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                        }
                        contentPadding = paddingValues;
                        Modifier modifier5 = modifier2;
                        shape4 = shape2;
                        float f4 = fM2245getBottomAppBarElevationD9Ej5fM;
                        long j7 = primarySurface;
                        long j8 = jM2360contentColorForek8zF_U;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1136595494, i3, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:336)");
                        }
                        ProvidableCompositionLocal<FabPlacement> localFabPlacement2 = ScaffoldKt.getLocalFabPlacement();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composerStartRestartGroup.consume(localFabPlacement2);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        FabPlacement fabPlacement2 = (FabPlacement) objConsume2;
                        if (shape4 == null) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        Shape shape6 = rectangleShape;
                        int i17 = i3 >> 9;
                        int i18 = ((i3 >> 6) & 126) | (i17 & 896) | (i17 & 7168);
                        int i19 = i3 << 15;
                        composer2 = composerStartRestartGroup;
                        m2251AppBarHkEspTQ(j7, j8, f4, contentPadding, shape6, windowInsets, modifier5, function3, composer2, i18 | (458752 & i19) | (i19 & 3670016) | (i3 & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        shape3 = shape4;
                        j3 = j7;
                        j4 = j8;
                        f2 = f4;
                        paddingValues2 = contentPadding;
                        modifier3 = modifier5;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        j3 = primarySurface;
                        j4 = jM2360contentColorForek8zF_U;
                        shape3 = shape2;
                        f2 = fM2245getBottomAppBarElevationD9Ej5fM;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AppBarKt.BottomAppBar_DanWW_k$lambda$0(windowInsets, modifier3, j3, j4, shape3, f2, paddingValues2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                fM2245getBottomAppBarElevationD9Ej5fM = f;
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 8388608;
                    } else {
                        i10 = 4194304;
                    }
                    i3 |= i10;
                }
                if ((i3 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "330@15067L6,331@15116L32");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            shape2 = null;
                        }
                        if (i6 != 0) {
                            fM2245getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2245getBottomAppBarElevationD9Ej5fM();
                        }
                        if (i8 != 0) {
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            shape2 = null;
                        }
                        if (i6 != 0) {
                            fM2245getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2245getBottomAppBarElevationD9Ej5fM();
                        }
                        if (i8 != 0) {
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                    }
                    Modifier modifier6 = modifier2;
                    shape4 = shape2;
                    float f5 = fM2245getBottomAppBarElevationD9Ej5fM;
                    long j9 = primarySurface;
                    long j10 = jM2360contentColorForek8zF_U;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1136595494, i3, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:336)");
                    }
                    ProvidableCompositionLocal<FabPlacement> localFabPlacement3 = ScaffoldKt.getLocalFabPlacement();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume3 = composerStartRestartGroup.consume(localFabPlacement3);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    FabPlacement fabPlacement3 = (FabPlacement) objConsume3;
                    if (shape4 == null) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    Shape shape7 = rectangleShape;
                    int i110 = i3 >> 9;
                    int i111 = ((i3 >> 6) & 126) | (i110 & 896) | (i110 & 7168);
                    int i112 = i3 << 15;
                    composer2 = composerStartRestartGroup;
                    m2251AppBarHkEspTQ(j9, j10, f5, contentPadding, shape7, windowInsets, modifier6, function3, composer2, i111 | (458752 & i112) | (i112 & 3670016) | (i3 & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape3 = shape4;
                    j3 = j9;
                    j4 = j10;
                    f2 = f5;
                    paddingValues2 = contentPadding;
                    modifier3 = modifier6;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    j3 = primarySurface;
                    j4 = jM2360contentColorForek8zF_U;
                    shape3 = shape2;
                    f2 = fM2245getBottomAppBarElevationD9Ej5fM;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AppBarKt.BottomAppBar_DanWW_k$lambda$0(windowInsets, modifier3, j3, j4, shape3, f2, paddingValues2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            shape2 = shape;
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    fM2245getBottomAppBarElevationD9Ej5fM = f;
                    if (composerStartRestartGroup.changed(fM2245getBottomAppBarElevationD9Ej5fM)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 8388608;
                    } else {
                        i10 = 4194304;
                    }
                    i3 |= i10;
                }
                if ((i3 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "330@15067L6,331@15116L32");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            shape2 = null;
                        }
                        if (i6 != 0) {
                            fM2245getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2245getBottomAppBarElevationD9Ej5fM();
                        }
                        if (i8 != 0) {
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            shape2 = null;
                        }
                        if (i6 != 0) {
                            fM2245getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2245getBottomAppBarElevationD9Ej5fM();
                        }
                        if (i8 != 0) {
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                    }
                    Modifier modifier7 = modifier2;
                    shape4 = shape2;
                    float f6 = fM2245getBottomAppBarElevationD9Ej5fM;
                    long j11 = primarySurface;
                    long j12 = jM2360contentColorForek8zF_U;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1136595494, i3, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:336)");
                    }
                    ProvidableCompositionLocal<FabPlacement> localFabPlacement4 = ScaffoldKt.getLocalFabPlacement();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume4 = composerStartRestartGroup.consume(localFabPlacement4);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    FabPlacement fabPlacement4 = (FabPlacement) objConsume4;
                    if (shape4 == null) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    Shape shape8 = rectangleShape;
                    int i113 = i3 >> 9;
                    int i114 = ((i3 >> 6) & 126) | (i113 & 896) | (i113 & 7168);
                    int i115 = i3 << 15;
                    composer2 = composerStartRestartGroup;
                    m2251AppBarHkEspTQ(j11, j12, f6, contentPadding, shape8, windowInsets, modifier7, function3, composer2, i114 | (458752 & i115) | (i115 & 3670016) | (i3 & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape3 = shape4;
                    j3 = j11;
                    j4 = j12;
                    f2 = f6;
                    paddingValues2 = contentPadding;
                    modifier3 = modifier7;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    j3 = primarySurface;
                    j4 = jM2360contentColorForek8zF_U;
                    shape3 = shape2;
                    f2 = fM2245getBottomAppBarElevationD9Ej5fM;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AppBarKt.BottomAppBar_DanWW_k$lambda$0(windowInsets, modifier3, j3, j4, shape3, f2, paddingValues2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            fM2245getBottomAppBarElevationD9Ej5fM = f;
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(paddingValues)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i10 = 8388608;
                } else {
                    i10 = 4194304;
                }
                i3 |= i10;
            }
            if ((i3 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "330@15067L6,331@15116L32");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        shape2 = null;
                    }
                    if (i6 != 0) {
                        fM2245getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2245getBottomAppBarElevationD9Ej5fM();
                    }
                    if (i8 != 0) {
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        shape2 = null;
                    }
                    if (i6 != 0) {
                        fM2245getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2245getBottomAppBarElevationD9Ej5fM();
                    }
                    if (i8 != 0) {
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                    }
                }
                Modifier modifier8 = modifier2;
                shape4 = shape2;
                float f7 = fM2245getBottomAppBarElevationD9Ej5fM;
                long j13 = primarySurface;
                long j14 = jM2360contentColorForek8zF_U;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1136595494, i3, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:336)");
                }
                ProvidableCompositionLocal<FabPlacement> localFabPlacement5 = ScaffoldKt.getLocalFabPlacement();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume5 = composerStartRestartGroup.consume(localFabPlacement5);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                FabPlacement fabPlacement5 = (FabPlacement) objConsume5;
                if (shape4 == null) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                Shape shape9 = rectangleShape;
                int i116 = i3 >> 9;
                int i117 = ((i3 >> 6) & 126) | (i116 & 896) | (i116 & 7168);
                int i118 = i3 << 15;
                composer2 = composerStartRestartGroup;
                m2251AppBarHkEspTQ(j13, j14, f7, contentPadding, shape9, windowInsets, modifier8, function3, composer2, i117 | (458752 & i118) | (i118 & 3670016) | (i3 & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape3 = shape4;
                j3 = j13;
                j4 = j14;
                f2 = f7;
                paddingValues2 = contentPadding;
                modifier3 = modifier8;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                j3 = primarySurface;
                j4 = jM2360contentColorForek8zF_U;
                shape3 = shape2;
                f2 = fM2245getBottomAppBarElevationD9Ej5fM;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AppBarKt.BottomAppBar_DanWW_k$lambda$0(windowInsets, modifier3, j3, j4, shape3, f2, paddingValues2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                primarySurface = j;
                if (composerStartRestartGroup.changed(primarySurface)) {
                }
                i3 |= i12;
            } else {
                primarySurface = j;
            }
            i3 |= i12;
        } else {
            primarySurface = j;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                jM2360contentColorForek8zF_U = j2;
                if (composerStartRestartGroup.changed(jM2360contentColorForek8zF_U)) {
                }
                i3 |= i13;
            } else {
                jM2360contentColorForek8zF_U = j2;
            }
            i3 |= i13;
        } else {
            jM2360contentColorForek8zF_U = j2;
        }
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    fM2245getBottomAppBarElevationD9Ej5fM = f;
                    if (composerStartRestartGroup.changed(fM2245getBottomAppBarElevationD9Ej5fM)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 8388608;
                    } else {
                        i10 = 4194304;
                    }
                    i3 |= i10;
                }
                if ((i3 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "330@15067L6,331@15116L32");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            shape2 = null;
                        }
                        if (i6 != 0) {
                            fM2245getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2245getBottomAppBarElevationD9Ej5fM();
                        }
                        if (i8 != 0) {
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            shape2 = null;
                        }
                        if (i6 != 0) {
                            fM2245getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2245getBottomAppBarElevationD9Ej5fM();
                        }
                        if (i8 != 0) {
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                    }
                    Modifier modifier9 = modifier2;
                    shape4 = shape2;
                    float f8 = fM2245getBottomAppBarElevationD9Ej5fM;
                    long j15 = primarySurface;
                    long j16 = jM2360contentColorForek8zF_U;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1136595494, i3, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:336)");
                    }
                    ProvidableCompositionLocal<FabPlacement> localFabPlacement6 = ScaffoldKt.getLocalFabPlacement();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume6 = composerStartRestartGroup.consume(localFabPlacement6);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    FabPlacement fabPlacement6 = (FabPlacement) objConsume6;
                    if (shape4 == null) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    Shape shape10 = rectangleShape;
                    int i119 = i3 >> 9;
                    int i1110 = ((i3 >> 6) & 126) | (i119 & 896) | (i119 & 7168);
                    int i1111 = i3 << 15;
                    composer2 = composerStartRestartGroup;
                    m2251AppBarHkEspTQ(j15, j16, f8, contentPadding, shape10, windowInsets, modifier9, function3, composer2, i1110 | (458752 & i1111) | (i1111 & 3670016) | (i3 & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape3 = shape4;
                    j3 = j15;
                    j4 = j16;
                    f2 = f8;
                    paddingValues2 = contentPadding;
                    modifier3 = modifier9;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    j3 = primarySurface;
                    j4 = jM2360contentColorForek8zF_U;
                    shape3 = shape2;
                    f2 = fM2245getBottomAppBarElevationD9Ej5fM;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AppBarKt.BottomAppBar_DanWW_k$lambda$0(windowInsets, modifier3, j3, j4, shape3, f2, paddingValues2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            fM2245getBottomAppBarElevationD9Ej5fM = f;
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(paddingValues)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i10 = 8388608;
                } else {
                    i10 = 4194304;
                }
                i3 |= i10;
            }
            if ((i3 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "330@15067L6,331@15116L32");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        shape2 = null;
                    }
                    if (i6 != 0) {
                        fM2245getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2245getBottomAppBarElevationD9Ej5fM();
                    }
                    if (i8 != 0) {
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        shape2 = null;
                    }
                    if (i6 != 0) {
                        fM2245getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2245getBottomAppBarElevationD9Ej5fM();
                    }
                    if (i8 != 0) {
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                    }
                }
                Modifier modifier10 = modifier2;
                shape4 = shape2;
                float f9 = fM2245getBottomAppBarElevationD9Ej5fM;
                long j17 = primarySurface;
                long j18 = jM2360contentColorForek8zF_U;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1136595494, i3, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:336)");
                }
                ProvidableCompositionLocal<FabPlacement> localFabPlacement7 = ScaffoldKt.getLocalFabPlacement();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume7 = composerStartRestartGroup.consume(localFabPlacement7);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                FabPlacement fabPlacement7 = (FabPlacement) objConsume7;
                if (shape4 == null) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                Shape shape11 = rectangleShape;
                int i1112 = i3 >> 9;
                int i1113 = ((i3 >> 6) & 126) | (i1112 & 896) | (i1112 & 7168);
                int i1114 = i3 << 15;
                composer2 = composerStartRestartGroup;
                m2251AppBarHkEspTQ(j17, j18, f9, contentPadding, shape11, windowInsets, modifier10, function3, composer2, i1113 | (458752 & i1114) | (i1114 & 3670016) | (i3 & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape3 = shape4;
                j3 = j17;
                j4 = j18;
                f2 = f9;
                paddingValues2 = contentPadding;
                modifier3 = modifier10;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                j3 = primarySurface;
                j4 = jM2360contentColorForek8zF_U;
                shape3 = shape2;
                f2 = fM2245getBottomAppBarElevationD9Ej5fM;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AppBarKt.BottomAppBar_DanWW_k$lambda$0(windowInsets, modifier3, j3, j4, shape3, f2, paddingValues2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        shape2 = shape;
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((196608 & i) == 0) {
                fM2245getBottomAppBarElevationD9Ej5fM = f;
                if (composerStartRestartGroup.changed(fM2245getBottomAppBarElevationD9Ej5fM)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(paddingValues)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i10 = 8388608;
                } else {
                    i10 = 4194304;
                }
                i3 |= i10;
            }
            if ((i3 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "330@15067L6,331@15116L32");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        shape2 = null;
                    }
                    if (i6 != 0) {
                        fM2245getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2245getBottomAppBarElevationD9Ej5fM();
                    }
                    if (i8 != 0) {
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        shape2 = null;
                    }
                    if (i6 != 0) {
                        fM2245getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2245getBottomAppBarElevationD9Ej5fM();
                    }
                    if (i8 != 0) {
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                    }
                }
                Modifier modifier11 = modifier2;
                shape4 = shape2;
                float f10 = fM2245getBottomAppBarElevationD9Ej5fM;
                long j19 = primarySurface;
                long j110 = jM2360contentColorForek8zF_U;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1136595494, i3, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:336)");
                }
                ProvidableCompositionLocal<FabPlacement> localFabPlacement8 = ScaffoldKt.getLocalFabPlacement();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume8 = composerStartRestartGroup.consume(localFabPlacement8);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                FabPlacement fabPlacement8 = (FabPlacement) objConsume8;
                if (shape4 == null) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                Shape shape12 = rectangleShape;
                int i1115 = i3 >> 9;
                int i1116 = ((i3 >> 6) & 126) | (i1115 & 896) | (i1115 & 7168);
                int i1117 = i3 << 15;
                composer2 = composerStartRestartGroup;
                m2251AppBarHkEspTQ(j19, j110, f10, contentPadding, shape12, windowInsets, modifier11, function3, composer2, i1116 | (458752 & i1117) | (i1117 & 3670016) | (i3 & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape3 = shape4;
                j3 = j19;
                j4 = j110;
                f2 = f10;
                paddingValues2 = contentPadding;
                modifier3 = modifier11;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                j3 = primarySurface;
                j4 = jM2360contentColorForek8zF_U;
                shape3 = shape2;
                f2 = fM2245getBottomAppBarElevationD9Ej5fM;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AppBarKt.BottomAppBar_DanWW_k$lambda$0(windowInsets, modifier3, j3, j4, shape3, f2, paddingValues2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        fM2245getBottomAppBarElevationD9Ej5fM = f;
        i8 = i2 & 64;
        if (i8 != 0) {
            i3 |= 1572864;
        } else if ((i & 1572864) == 0) {
            if (composerStartRestartGroup.changed(paddingValues)) {
                i9 = 1048576;
            } else {
                i9 = 524288;
            }
            i3 |= i9;
        }
        if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i10 = 8388608;
            } else {
                i10 = 4194304;
            }
            i3 |= i10;
        }
        if ((i3 & 4793491) != 4793490) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "330@15067L6,331@15116L32");
            if ((i & 1) != 0) {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 4) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 6) & 14);
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    shape2 = null;
                }
                if (i6 != 0) {
                    fM2245getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2245getBottomAppBarElevationD9Ej5fM();
                }
                if (i8 != 0) {
                    contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                } else {
                    contentPadding = paddingValues;
                }
            } else {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 4) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 6) & 14);
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    shape2 = null;
                }
                if (i6 != 0) {
                    fM2245getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2245getBottomAppBarElevationD9Ej5fM();
                }
                if (i8 != 0) {
                    contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                } else {
                    contentPadding = paddingValues;
                }
            }
            Modifier modifier12 = modifier2;
            shape4 = shape2;
            float f11 = fM2245getBottomAppBarElevationD9Ej5fM;
            long j111 = primarySurface;
            long j112 = jM2360contentColorForek8zF_U;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1136595494, i3, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:336)");
            }
            ProvidableCompositionLocal<FabPlacement> localFabPlacement9 = ScaffoldKt.getLocalFabPlacement();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume9 = composerStartRestartGroup.consume(localFabPlacement9);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            FabPlacement fabPlacement9 = (FabPlacement) objConsume9;
            if (shape4 == null) {
                rectangleShape = RectangleShapeKt.getRectangleShape();
            } else {
                rectangleShape = RectangleShapeKt.getRectangleShape();
            }
            Shape shape13 = rectangleShape;
            int i1118 = i3 >> 9;
            int i1119 = ((i3 >> 6) & 126) | (i1118 & 896) | (i1118 & 7168);
            int i11110 = i3 << 15;
            composer2 = composerStartRestartGroup;
            m2251AppBarHkEspTQ(j111, j112, f11, contentPadding, shape13, windowInsets, modifier12, function3, composer2, i1119 | (458752 & i11110) | (i11110 & 3670016) | (i3 & 29360128), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            shape3 = shape4;
            j3 = j111;
            j4 = j112;
            f2 = f11;
            paddingValues2 = contentPadding;
            modifier3 = modifier12;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            j3 = primarySurface;
            j4 = jM2360contentColorForek8zF_U;
            shape3 = shape2;
            f2 = fM2245getBottomAppBarElevationD9Ej5fM;
            paddingValues2 = paddingValues;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBarKt.BottomAppBar_DanWW_k$lambda$0(windowInsets, modifier3, j3, j4, shape3, f2, paddingValues2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0136  */
    /* JADX WARN: Code duplicated, block: B:104:0x0143  */
    /* JADX WARN: Code duplicated, block: B:106:0x0147  */
    /* JADX WARN: Code duplicated, block: B:108:0x0150  */
    /* JADX WARN: Code duplicated, block: B:109:0x0161  */
    /* JADX WARN: Code duplicated, block: B:112:0x016d  */
    /* JADX WARN: Code duplicated, block: B:115:0x018c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:119:0x019c  */
    /* JADX WARN: Code duplicated, block: B:122:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:124:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:127:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:129:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x0084  */
    /* JADX WARN: Code duplicated, block: B:49:0x0087  */
    /* JADX WARN: Code duplicated, block: B:51:0x008b  */
    /* JADX WARN: Code duplicated, block: B:53:0x0093  */
    /* JADX WARN: Code duplicated, block: B:54:0x0096  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:76:0x00df  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:80:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:94:0x0118 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:95:0x011a  */
    /* JADX WARN: Code duplicated, block: B:96:0x011f  */
    /* JADX WARN: Code duplicated, block: B:99:0x0125  */
    /* JADX INFO: renamed from: BottomAppBar-Y1yfwus, reason: not valid java name */
    public static final void m2253BottomAppBarY1yfwus(Modifier modifier, long j, long j2, Shape shape, float f, PaddingValues paddingValues, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        long primarySurface;
        long jM2360contentColorForek8zF_U;
        Shape shape2;
        int i4;
        float fM2245getBottomAppBarElevationD9Ej5fM;
        int i5;
        int i6;
        int i7;
        PaddingValues paddingValues2;
        int i8;
        boolean z;
        Composer composer2;
        final Modifier modifier2;
        final long j3;
        final long j4;
        final Shape shape3;
        final float f2;
        final PaddingValues paddingValues3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Modifier modifier3;
        PaddingValues contentPadding;
        Shape shape4;
        float f3;
        int i9;
        long j5;
        BottomAppBarCutoutShape rectangleShape;
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2058075642);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BottomAppBar)N(modifier,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,cutoutShape,elevation:c#ui.unit.Dp,contentPadding,content)406@18576L7,413@18790L173:AppBar.kt#jmzs0o");
        int i11 = i2 & 1;
        if (i11 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                primarySurface = j;
                int i12 = composerStartRestartGroup.changed(primarySurface) ? 32 : 16;
                i3 |= i12;
            } else {
                primarySurface = j;
            }
            i3 |= i12;
        } else {
            primarySurface = j;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                jM2360contentColorForek8zF_U = j2;
                int i13 = composerStartRestartGroup.changed(jM2360contentColorForek8zF_U) ? 256 : 128;
                i3 |= i13;
            } else {
                jM2360contentColorForek8zF_U = j2;
            }
            i3 |= i13;
        } else {
            jM2360contentColorForek8zF_U = j2;
        }
        int i14 = i2 & 8;
        if (i14 == 0) {
            if ((i & 3072) == 0) {
                shape2 = shape;
                i3 |= composerStartRestartGroup.changed(shape2) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    fM2245getBottomAppBarElevationD9Ej5fM = f;
                    if (composerStartRestartGroup.changed(fM2245getBottomAppBarElevationD9Ej5fM)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    i7 = 196608;
                    paddingValues2 = paddingValues;
                } else {
                    i7 = 196608;
                    paddingValues2 = paddingValues;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(paddingValues2)) {
                            i8 = 131072;
                        } else {
                            i8 = 65536;
                        }
                        i3 |= i8;
                    }
                }
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
                if ((i3 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "399@18245L6,400@18294L32");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -113;
                        }
                        if ((i2 & 4) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                        }
                        if (i14 != 0) {
                            shape2 = null;
                        }
                        if (i4 != 0) {
                            fM2245getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2245getBottomAppBarElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            modifier3 = companion;
                            contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                            shape4 = shape2;
                            f3 = fM2245getBottomAppBarElevationD9Ej5fM;
                            i9 = -2058075642;
                            j5 = primarySurface;
                        } else {
                            modifier3 = companion;
                        }
                        long j6 = jM2360contentColorForek8zF_U;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i9, i3, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:405)");
                        }
                        ProvidableCompositionLocal<FabPlacement> localFabPlacement = ScaffoldKt.getLocalFabPlacement();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume = composerStartRestartGroup.consume(localFabPlacement);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        FabPlacement fabPlacement = (FabPlacement) objConsume;
                        if (shape4 == null && fabPlacement != null && fabPlacement.getIsDocked()) {
                            rectangleShape = new BottomAppBarCutoutShape(shape4, fabPlacement);
                        } else {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        int i15 = i3 >> 3;
                        int i16 = i3 >> 6;
                        composer2 = composerStartRestartGroup;
                        m2251AppBarHkEspTQ(j5, j6, f3, contentPadding, rectangleShape, ZeroInsets, modifier3, function3, composer2, (i15 & 112) | (i15 & 14) | i7 | (i16 & 896) | (i16 & 7168) | ((i3 << 18) & 3670016) | (29360128 & (i3 << 3)), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        shape3 = shape4;
                        j3 = j5;
                        j4 = j6;
                        f2 = f3;
                        paddingValues3 = contentPadding;
                        modifier2 = modifier3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        modifier3 = modifier;
                    }
                    shape4 = shape2;
                    contentPadding = paddingValues2;
                    i9 = -2058075642;
                    j5 = primarySurface;
                    f3 = fM2245getBottomAppBarElevationD9Ej5fM;
                    long j7 = jM2360contentColorForek8zF_U;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i9, i3, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:405)");
                    }
                    ProvidableCompositionLocal<FabPlacement> localFabPlacement2 = ScaffoldKt.getLocalFabPlacement();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(localFabPlacement2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    FabPlacement fabPlacement2 = (FabPlacement) objConsume2;
                    if (shape4 == null) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    int i17 = i3 >> 3;
                    int i18 = i3 >> 6;
                    composer2 = composerStartRestartGroup;
                    m2251AppBarHkEspTQ(j5, j7, f3, contentPadding, rectangleShape, ZeroInsets, modifier3, function3, composer2, (i17 & 112) | (i17 & 14) | i7 | (i18 & 896) | (i18 & 7168) | ((i3 << 18) & 3670016) | (29360128 & (i3 << 3)), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape3 = shape4;
                    j3 = j5;
                    j4 = j7;
                    f2 = f3;
                    paddingValues3 = contentPadding;
                    modifier2 = modifier3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier2 = modifier;
                    j3 = primarySurface;
                    j4 = jM2360contentColorForek8zF_U;
                    shape3 = shape2;
                    f2 = fM2245getBottomAppBarElevationD9Ej5fM;
                    paddingValues3 = paddingValues2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AppBarKt.BottomAppBar_Y1yfwus$lambda$0(modifier2, j3, j4, shape3, f2, paddingValues3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            fM2245getBottomAppBarElevationD9Ej5fM = f;
            i6 = i2 & 32;
            if (i6 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i7 = 196608;
                paddingValues2 = paddingValues;
            } else {
                i7 = 196608;
                paddingValues2 = paddingValues;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues2)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                    i3 |= i8;
                }
            }
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i3 |= i10;
            }
            if ((i3 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "399@18245L6,400@18294L32");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i14 != 0) {
                        shape2 = null;
                    }
                    if (i4 != 0) {
                        fM2245getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2245getBottomAppBarElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        modifier3 = companion;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        shape4 = shape2;
                        f3 = fM2245getBottomAppBarElevationD9Ej5fM;
                        i9 = -2058075642;
                        j5 = primarySurface;
                    } else {
                        modifier3 = companion;
                        shape4 = shape2;
                        contentPadding = paddingValues2;
                        i9 = -2058075642;
                        j5 = primarySurface;
                        f3 = fM2245getBottomAppBarElevationD9Ej5fM;
                    }
                } else {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i14 != 0) {
                        shape2 = null;
                    }
                    if (i4 != 0) {
                        fM2245getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2245getBottomAppBarElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        modifier3 = companion;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        shape4 = shape2;
                        f3 = fM2245getBottomAppBarElevationD9Ej5fM;
                        i9 = -2058075642;
                        j5 = primarySurface;
                    } else {
                        modifier3 = companion;
                        shape4 = shape2;
                        contentPadding = paddingValues2;
                        i9 = -2058075642;
                        j5 = primarySurface;
                        f3 = fM2245getBottomAppBarElevationD9Ej5fM;
                    }
                }
                long j8 = jM2360contentColorForek8zF_U;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i9, i3, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:405)");
                }
                ProvidableCompositionLocal<FabPlacement> localFabPlacement3 = ScaffoldKt.getLocalFabPlacement();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume3 = composerStartRestartGroup.consume(localFabPlacement3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                FabPlacement fabPlacement3 = (FabPlacement) objConsume3;
                if (shape4 == null) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                int i19 = i3 >> 3;
                int i110 = i3 >> 6;
                composer2 = composerStartRestartGroup;
                m2251AppBarHkEspTQ(j5, j8, f3, contentPadding, rectangleShape, ZeroInsets, modifier3, function3, composer2, (i19 & 112) | (i19 & 14) | i7 | (i110 & 896) | (i110 & 7168) | ((i3 << 18) & 3670016) | (29360128 & (i3 << 3)), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape3 = shape4;
                j3 = j5;
                j4 = j8;
                f2 = f3;
                paddingValues3 = contentPadding;
                modifier2 = modifier3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = modifier;
                j3 = primarySurface;
                j4 = jM2360contentColorForek8zF_U;
                shape3 = shape2;
                f2 = fM2245getBottomAppBarElevationD9Ej5fM;
                paddingValues3 = paddingValues2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AppBarKt.BottomAppBar_Y1yfwus$lambda$0(modifier2, j3, j4, shape3, f2, paddingValues3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        shape2 = shape;
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                fM2245getBottomAppBarElevationD9Ej5fM = f;
                if (composerStartRestartGroup.changed(fM2245getBottomAppBarElevationD9Ej5fM)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i7 = 196608;
                paddingValues2 = paddingValues;
            } else {
                i7 = 196608;
                paddingValues2 = paddingValues;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues2)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                    i3 |= i8;
                }
            }
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i3 |= i10;
            }
            if ((i3 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "399@18245L6,400@18294L32");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i14 != 0) {
                        shape2 = null;
                    }
                    if (i4 != 0) {
                        fM2245getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2245getBottomAppBarElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        modifier3 = companion;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        shape4 = shape2;
                        f3 = fM2245getBottomAppBarElevationD9Ej5fM;
                        i9 = -2058075642;
                        j5 = primarySurface;
                    } else {
                        modifier3 = companion;
                        shape4 = shape2;
                        contentPadding = paddingValues2;
                        i9 = -2058075642;
                        j5 = primarySurface;
                        f3 = fM2245getBottomAppBarElevationD9Ej5fM;
                    }
                } else {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i14 != 0) {
                        shape2 = null;
                    }
                    if (i4 != 0) {
                        fM2245getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2245getBottomAppBarElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        modifier3 = companion;
                        contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                        shape4 = shape2;
                        f3 = fM2245getBottomAppBarElevationD9Ej5fM;
                        i9 = -2058075642;
                        j5 = primarySurface;
                    } else {
                        modifier3 = companion;
                        shape4 = shape2;
                        contentPadding = paddingValues2;
                        i9 = -2058075642;
                        j5 = primarySurface;
                        f3 = fM2245getBottomAppBarElevationD9Ej5fM;
                    }
                }
                long j9 = jM2360contentColorForek8zF_U;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i9, i3, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:405)");
                }
                ProvidableCompositionLocal<FabPlacement> localFabPlacement4 = ScaffoldKt.getLocalFabPlacement();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume4 = composerStartRestartGroup.consume(localFabPlacement4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                FabPlacement fabPlacement4 = (FabPlacement) objConsume4;
                if (shape4 == null) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                int i111 = i3 >> 3;
                int i112 = i3 >> 6;
                composer2 = composerStartRestartGroup;
                m2251AppBarHkEspTQ(j5, j9, f3, contentPadding, rectangleShape, ZeroInsets, modifier3, function3, composer2, (i111 & 112) | (i111 & 14) | i7 | (i112 & 896) | (i112 & 7168) | ((i3 << 18) & 3670016) | (29360128 & (i3 << 3)), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape3 = shape4;
                j3 = j5;
                j4 = j9;
                f2 = f3;
                paddingValues3 = contentPadding;
                modifier2 = modifier3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = modifier;
                j3 = primarySurface;
                j4 = jM2360contentColorForek8zF_U;
                shape3 = shape2;
                f2 = fM2245getBottomAppBarElevationD9Ej5fM;
                paddingValues3 = paddingValues2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AppBarKt.BottomAppBar_Y1yfwus$lambda$0(modifier2, j3, j4, shape3, f2, paddingValues3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        fM2245getBottomAppBarElevationD9Ej5fM = f;
        i6 = i2 & 32;
        if (i6 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i7 = 196608;
            paddingValues2 = paddingValues;
        } else {
            i7 = 196608;
            paddingValues2 = paddingValues;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(paddingValues2)) {
                    i8 = 131072;
                } else {
                    i8 = 65536;
                }
                i3 |= i8;
            }
        }
        if ((i & 1572864) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i10 = 1048576;
            } else {
                i10 = 524288;
            }
            i3 |= i10;
        }
        if ((i3 & 599187) != 599186) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "399@18245L6,400@18294L32");
            if ((i & 1) != 0) {
                if (i11 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i2 & 2) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                }
                if (i14 != 0) {
                    shape2 = null;
                }
                if (i4 != 0) {
                    fM2245getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2245getBottomAppBarElevationD9Ej5fM();
                }
                if (i6 != 0) {
                    modifier3 = companion;
                    contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                    shape4 = shape2;
                    f3 = fM2245getBottomAppBarElevationD9Ej5fM;
                    i9 = -2058075642;
                    j5 = primarySurface;
                } else {
                    modifier3 = companion;
                    shape4 = shape2;
                    contentPadding = paddingValues2;
                    i9 = -2058075642;
                    j5 = primarySurface;
                    f3 = fM2245getBottomAppBarElevationD9Ej5fM;
                }
            } else {
                if (i11 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i2 & 2) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                }
                if (i14 != 0) {
                    shape2 = null;
                }
                if (i4 != 0) {
                    fM2245getBottomAppBarElevationD9Ej5fM = AppBarDefaults.INSTANCE.m2245getBottomAppBarElevationD9Ej5fM();
                }
                if (i6 != 0) {
                    modifier3 = companion;
                    contentPadding = AppBarDefaults.INSTANCE.getContentPadding();
                    shape4 = shape2;
                    f3 = fM2245getBottomAppBarElevationD9Ej5fM;
                    i9 = -2058075642;
                    j5 = primarySurface;
                } else {
                    modifier3 = companion;
                    shape4 = shape2;
                    contentPadding = paddingValues2;
                    i9 = -2058075642;
                    j5 = primarySurface;
                    f3 = fM2245getBottomAppBarElevationD9Ej5fM;
                }
            }
            long j10 = jM2360contentColorForek8zF_U;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i9, i3, -1, "androidx.compose.material.BottomAppBar (AppBar.kt:405)");
            }
            ProvidableCompositionLocal<FabPlacement> localFabPlacement5 = ScaffoldKt.getLocalFabPlacement();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume5 = composerStartRestartGroup.consume(localFabPlacement5);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            FabPlacement fabPlacement5 = (FabPlacement) objConsume5;
            if (shape4 == null) {
                rectangleShape = RectangleShapeKt.getRectangleShape();
            } else {
                rectangleShape = RectangleShapeKt.getRectangleShape();
            }
            int i113 = i3 >> 3;
            int i114 = i3 >> 6;
            composer2 = composerStartRestartGroup;
            m2251AppBarHkEspTQ(j5, j10, f3, contentPadding, rectangleShape, ZeroInsets, modifier3, function3, composer2, (i113 & 112) | (i113 & 14) | i7 | (i114 & 896) | (i114 & 7168) | ((i3 << 18) & 3670016) | (29360128 & (i3 << 3)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            shape3 = shape4;
            j3 = j5;
            j4 = j10;
            f2 = f3;
            paddingValues3 = contentPadding;
            modifier2 = modifier3;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier2 = modifier;
            j3 = primarySurface;
            j4 = jM2360contentColorForek8zF_U;
            shape3 = shape2;
            f2 = fM2245getBottomAppBarElevationD9Ej5fM;
            paddingValues3 = paddingValues2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBarKt.BottomAppBar_Y1yfwus$lambda$0(modifier2, j3, j4, shape3, f2, paddingValues3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final float calculateCutoutCircleYIntercept(float f, float f2) {
        return -((float) Math.sqrt((f * f) - (f2 * f2)));
    }

    public static final Pair<Float, Float> calculateRoundedEdgeIntercept(float f, float f2, float f3) {
        Float fValueOf;
        Float fValueOf2;
        Pair pair;
        Float fValueOf3;
        Float fValueOf4;
        float f4 = f2 * f2;
        float f5 = f3 * f3;
        float f6 = (f * f) + f4;
        float f7 = f4 * f5 * (f6 - f5);
        float f8 = f * f5;
        double d = f7;
        float fSqrt = (f8 - ((float) Math.sqrt(d))) / f6;
        float fSqrt2 = (f8 + ((float) Math.sqrt(d))) / f6;
        float fSqrt3 = (float) Math.sqrt(f5 - (fSqrt * fSqrt));
        float fSqrt4 = (float) Math.sqrt(f5 - (fSqrt2 * fSqrt2));
        if (f2 > 0.0f) {
            if (fSqrt3 > fSqrt4) {
                fValueOf3 = Float.valueOf(fSqrt);
                fValueOf4 = Float.valueOf(fSqrt3);
            } else {
                fValueOf3 = Float.valueOf(fSqrt2);
                fValueOf4 = Float.valueOf(fSqrt4);
            }
            pair = TuplesKt.to(fValueOf3, fValueOf4);
        } else {
            if (fSqrt3 < fSqrt4) {
                fValueOf = Float.valueOf(fSqrt);
                fValueOf2 = Float.valueOf(fSqrt3);
            } else {
                fValueOf = Float.valueOf(fSqrt2);
                fValueOf2 = Float.valueOf(fSqrt4);
            }
            pair = TuplesKt.to(fValueOf, fValueOf2);
        }
        float fFloatValue = ((Number) pair.component1()).floatValue();
        float fFloatValue2 = ((Number) pair.component2()).floatValue();
        if (fFloatValue < f) {
            fFloatValue2 = -fFloatValue2;
        }
        return TuplesKt.to(Float.valueOf(fFloatValue), Float.valueOf(fFloatValue2));
    }

    /* JADX WARN: Code duplicated, block: B:61:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:73:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:80:0x0129  */
    /* JADX WARN: Code duplicated, block: B:82:0x012e  */
    /* JADX WARN: Code duplicated, block: B:85:0x013a  */
    /* JADX WARN: Code duplicated, block: B:87:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: AppBar-HkEspTQ, reason: not valid java name */
    private static final void m2251AppBarHkEspTQ(final long j, final long j2, final float f, final PaddingValues paddingValues, final Shape shape, final WindowInsets windowInsets, Modifier modifier, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        float f2;
        Shape shape2;
        Modifier modifier2;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(1222317265);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AppBar)N(backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation:c#ui.unit.Dp,contentPadding,shape,windowInsets,modifier,content)706@31596L472,700@31428L640:AppBar.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(j2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            f2 = f;
            i3 |= composerStartRestartGroup.changed(f2) ? 256 : 128;
        } else {
            f2 = f;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(paddingValues) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            shape2 = shape;
            i3 |= composerStartRestartGroup.changed(shape2) ? 16384 : 8192;
        } else {
            shape2 = shape;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(windowInsets) ? 131072 : 65536;
        }
        int i5 = i2 & 64;
        if (i5 == 0) {
            if ((i & 1572864) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 1048576 : 524288;
            }
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i4 = 8388608;
                } else {
                    i4 = 4194304;
                }
                i3 |= i4;
            }
            if ((i3 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i5 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1222317265, i3, -1, "androidx.compose.material.AppBar (AppBar.kt:699)");
                }
                int i6 = i3 << 6;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m2584SurfaceFjzlyU(modifier4, shape2, j, j2, null, f2, ComposableLambdaKt.rememberComposableLambda(-1628734195, true, new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AppBarKt.AppBar_HkEspTQ$lambda$0(windowInsets, paddingValues, function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, ((i3 >> 18) & 14) | 1572864 | ((i3 >> 9) & 112) | (i6 & 896) | (i6 & 7168) | ((i3 << 9) & 458752), 16);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AppBarKt.AppBar_HkEspTQ$lambda$1(j, j2, f, paddingValues, shape, windowInsets, modifier3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 1572864;
        modifier2 = modifier;
        if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i4 = 8388608;
            } else {
                i4 = 4194304;
            }
            i3 |= i4;
        }
        if ((i3 & 4793491) != 4793490) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i5 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1222317265, i3, -1, "androidx.compose.material.AppBar (AppBar.kt:699)");
            }
            int i7 = i3 << 6;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m2584SurfaceFjzlyU(modifier4, shape2, j, j2, null, f2, ComposableLambdaKt.rememberComposableLambda(-1628734195, true, new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBarKt.AppBar_HkEspTQ$lambda$0(windowInsets, paddingValues, function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, ((i3 >> 18) & 14) | 1572864 | ((i3 >> 9) & 112) | (i7 & 896) | (i7 & 7168) | ((i3 << 9) & 458752), 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBarKt.AppBar_HkEspTQ$lambda$1(j, j2, f, paddingValues, shape, windowInsets, modifier3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppBar_HkEspTQ$lambda$0(final WindowInsets windowInsets, final PaddingValues paddingValues, final Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C707@31671L6,707@31679L383,707@31606L456:AppBar.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1628734195, i, -1, "androidx.compose.material.AppBar.<anonymous> (AppBar.kt:707)");
            }
            CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer, 6))), ComposableLambdaKt.rememberComposableLambda(597057613, true, new Function2() { // from class: androidx.compose.material.AppBarKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBarKt.AppBar_HkEspTQ$lambda$0$0(windowInsets, paddingValues, function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppBar_HkEspTQ$lambda$0$0(WindowInsets windowInsets, PaddingValues paddingValues, Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C708@31693L359:AppBar.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(597057613, i, -1, "androidx.compose.material.AppBar.<anonymous>.<anonymous> (AppBar.kt:708)");
            }
            Modifier modifierM1252height3ABfNKs = SizeKt.m1252height3ABfNKs(PaddingKt.padding(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), windowInsets), paddingValues), AppBarHeight);
            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1252height3ABfNKs);
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
            function3.invoke(RowScopeInstance.INSTANCE, composer, 6);
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

    static {
        float f = 4;
        float fM9687constructorimpl = Dp.m9687constructorimpl(f);
        AppBarHorizontalPadding = fM9687constructorimpl;
        TitleInsetWithoutIcon = SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(Dp.m9687constructorimpl(16) - fM9687constructorimpl));
        TitleIconModifier = SizeKt.m1271width3ABfNKs(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9687constructorimpl(Dp.m9687constructorimpl(72) - fM9687constructorimpl));
        BottomAppBarCutoutOffset = Dp.m9687constructorimpl(8);
        BottomAppBarRoundedEdgeRadius = Dp.m9687constructorimpl(f);
        ZeroInsets = WindowInsetsKt.m1293WindowInsetsa9UjIt4$default(Dp.m9687constructorimpl(0), 0.0f, 0.0f, 0.0f, 14, null);
    }
}
