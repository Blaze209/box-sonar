package androidx.compose.material3.pulltorefresh;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.LoadingIndicatorDefaults;
import androidx.compose.material3.LoadingIndicatorKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.MotionSchemeKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PullToRefresh.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jo\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020\u001c2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010/\u001a\u00020\u001c2\u001c\u00100\u001a\u0018\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020'01¢\u0006\u0002\b3¢\u0006\u0002\b4H\u0007¢\u0006\u0004\b5\u00106JG\u00107\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u00108\u001a\u00020\f2\b\b\u0002\u0010.\u001a\u00020\u001cH\u0007¢\u0006\u0004\b9\u0010:JQ\u0010;\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u00108\u001a\u00020\f2\b\b\u0002\u0010/\u001a\u00020\u001c2\b\b\u0002\u0010.\u001a\u00020\u001cH\u0007¢\u0006\u0004\b<\u0010=R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u001a\u0010\u000b\u001a\u00020\f8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\f8G¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\f8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0016\u001a\u00020\f8G¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0010R\u001a\u0010\u0018\u001a\u00020\f8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010R\u0013\u0010\u001b\u001a\u00020\u001c¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010 \u001a\u00020\u001c¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b!\u0010\u001eR\u0013\u0010\"\u001a\u00020\u001c¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b#\u0010\u001eR\u0013\u0010$\u001a\u00020\u001c¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b%\u0010\u001e¨\u0006>"}, d2 = {"Landroidx/compose/material3/pulltorefresh/PullToRefreshDefaults;", "", "<init>", "()V", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape$annotations", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "indicatorShape", "getIndicatorShape", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor$annotations", "(Landroidx/compose/runtime/Composer;I)V", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "indicatorContainerColor", "getIndicatorContainerColor", "loadingIndicatorContainerColor", "getLoadingIndicatorContainerColor$annotations", "getLoadingIndicatorContainerColor", "indicatorColor", "getIndicatorColor", "loadingIndicatorColor", "getLoadingIndicatorColor$annotations", "getLoadingIndicatorColor", "PositionalThreshold", "Landroidx/compose/ui/unit/Dp;", "getPositionalThreshold-D9Ej5fM", "()F", "F", "IndicatorMaxDistance", "getIndicatorMaxDistance-D9Ej5fM", "Elevation", "getElevation-D9Ej5fM", "LoadingIndicatorElevation", "getLoadingIndicatorElevation-D9Ej5fM", "IndicatorBox", "", "state", "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "isRefreshing", "", "modifier", "Landroidx/compose/ui/Modifier;", "maxDistance", "elevation", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "IndicatorBox-1CPYgEU", "(Landroidx/compose/material3/pulltorefresh/PullToRefreshState;ZLandroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Shape;JFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Indicator", "color", "Indicator-2poqoh4", "(Landroidx/compose/material3/pulltorefresh/PullToRefreshState;ZLandroidx/compose/ui/Modifier;JJFLandroidx/compose/runtime/Composer;II)V", "LoadingIndicator", "LoadingIndicator-4eDdRP8", "(Landroidx/compose/material3/pulltorefresh/PullToRefreshState;ZLandroidx/compose/ui/Modifier;JJFFLandroidx/compose/runtime/Composer;II)V", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PullToRefreshDefaults {
    public static final int $stable = 0;
    private static final float Elevation;
    private static final float IndicatorMaxDistance;
    private static final float LoadingIndicatorElevation;
    private static final float PositionalThreshold;
    public static final PullToRefreshDefaults INSTANCE = new PullToRefreshDefaults();
    private static final Shape shape = RoundedCornerShapeKt.getCircleShape();
    private static final Shape indicatorShape = RoundedCornerShapeKt.getCircleShape();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IndicatorBox_1CPYgEU$lambda$2(PullToRefreshDefaults pullToRefreshDefaults, PullToRefreshState pullToRefreshState, boolean z, Modifier modifier, float f, Shape shape2, long j, float f2, Function3 function3, int i, int i2, Composer composer, int i3) {
        pullToRefreshDefaults.m5107IndicatorBox1CPYgEU(pullToRefreshState, z, modifier, f, shape2, j, f2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Indicator_2poqoh4$lambda$1(PullToRefreshDefaults pullToRefreshDefaults, PullToRefreshState pullToRefreshState, boolean z, Modifier modifier, long j, long j2, float f, int i, int i2, Composer composer, int i3) {
        pullToRefreshDefaults.m5106Indicator2poqoh4(pullToRefreshState, z, modifier, j, j2, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoadingIndicator_4eDdRP8$lambda$1(PullToRefreshDefaults pullToRefreshDefaults, PullToRefreshState pullToRefreshState, boolean z, Modifier modifier, long j, long j2, float f, float f2, int i, int i2, Composer composer, int i3) {
        pullToRefreshDefaults.m5108LoadingIndicator4eDdRP8(pullToRefreshState, z, modifier, j, j2, f, f2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    @Deprecated(message = "Use indicatorContainerColor instead", replaceWith = @ReplaceWith(expression = "indicatorContainerColor", imports = {}))
    public static /* synthetic */ void getContainerColor$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getLoadingIndicatorColor$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getLoadingIndicatorContainerColor$annotations(Composer composer, int i) {
    }

    @Deprecated(message = "Use indicatorShape instead", replaceWith = @ReplaceWith(expression = "indicatorShape", imports = {}))
    public static /* synthetic */ void getShape$annotations() {
    }

    private PullToRefreshDefaults() {
    }

    static {
        float fM9687constructorimpl = Dp.m9687constructorimpl(80);
        PositionalThreshold = fM9687constructorimpl;
        IndicatorMaxDistance = fM9687constructorimpl;
        Elevation = ElevationTokens.INSTANCE.m5365getLevel2D9Ej5fM();
        LoadingIndicatorElevation = ElevationTokens.INSTANCE.m5363getLevel0D9Ej5fM();
    }

    public final Shape getShape() {
        return shape;
    }

    public final Shape getIndicatorShape() {
        return indicatorShape;
    }

    public final long getContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1066257972, "C(<get-containerColor>)419@16136L11:PullToRefresh.kt#djiw08");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1066257972, i, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.<get-containerColor> (PullToRefresh.kt:419)");
        }
        long surfaceContainerHigh = MaterialTheme.INSTANCE.getColorScheme(composer, 6).getSurfaceContainerHigh();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return surfaceContainerHigh;
    }

    public final long getIndicatorContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -80510850, "C(<get-indicatorContainerColor>)423@16306L11:PullToRefresh.kt#djiw08");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-80510850, i, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.<get-indicatorContainerColor> (PullToRefresh.kt:423)");
        }
        long surfaceContainerHigh = MaterialTheme.INSTANCE.getColorScheme(composer, 6).getSurfaceContainerHigh();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return surfaceContainerHigh;
    }

    public final long getLoadingIndicatorContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1747883372, "C(<get-loadingIndicatorContainerColor>)430@16594L23:PullToRefresh.kt#djiw08");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1747883372, i, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.<get-loadingIndicatorContainerColor> (PullToRefresh.kt:430)");
        }
        long containedContainerColor = LoadingIndicatorDefaults.INSTANCE.getContainedContainerColor(composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return containedContainerColor;
    }

    public final long getIndicatorColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1441334156, "C(<get-indicatorColor>)434@16746L11:PullToRefresh.kt#djiw08");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1441334156, i, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.<get-indicatorColor> (PullToRefresh.kt:434)");
        }
        long onSurfaceVariant = MaterialTheme.INSTANCE.getColorScheme(composer, 6).getOnSurfaceVariant();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return onSurfaceVariant;
    }

    public final long getLoadingIndicatorColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1583174528, "C(<get-loadingIndicatorColor>)442@17035L23:PullToRefresh.kt#djiw08");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1583174528, i, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.<get-loadingIndicatorColor> (PullToRefresh.kt:442)");
        }
        long containedIndicatorColor = LoadingIndicatorDefaults.INSTANCE.getContainedIndicatorColor(composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return containedIndicatorColor;
    }

    /* JADX INFO: renamed from: getPositionalThreshold-D9Ej5fM, reason: not valid java name */
    public final float m5112getPositionalThresholdD9Ej5fM() {
        return PositionalThreshold;
    }

    /* JADX INFO: renamed from: getIndicatorMaxDistance-D9Ej5fM, reason: not valid java name */
    public final float m5110getIndicatorMaxDistanceD9Ej5fM() {
        return IndicatorMaxDistance;
    }

    /* JADX INFO: renamed from: getElevation-D9Ej5fM, reason: not valid java name */
    public final float m5109getElevationD9Ej5fM() {
        return Elevation;
    }

    /* JADX INFO: renamed from: getLoadingIndicatorElevation-D9Ej5fM, reason: not valid java name */
    public final float m5111getLoadingIndicatorElevationD9Ej5fM() {
        return LoadingIndicatorElevation;
    }

    /* JADX WARN: Code duplicated, block: B:106:0x0135 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:107:0x0137  */
    /* JADX WARN: Code duplicated, block: B:110:0x0140  */
    /* JADX WARN: Code duplicated, block: B:113:0x0149  */
    /* JADX WARN: Code duplicated, block: B:115:0x0150  */
    /* JADX WARN: Code duplicated, block: B:118:0x015a  */
    /* JADX WARN: Code duplicated, block: B:121:0x0167  */
    /* JADX WARN: Code duplicated, block: B:124:0x018d  */
    /* JADX WARN: Code duplicated, block: B:127:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:128:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:131:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:132:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:135:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:137:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:143:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:145:0x01de  */
    /* JADX WARN: Code duplicated, block: B:151:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:153:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:159:0x0206  */
    /* JADX WARN: Code duplicated, block: B:161:0x020e  */
    /* JADX WARN: Code duplicated, block: B:164:0x0278  */
    /* JADX WARN: Code duplicated, block: B:167:0x0284  */
    /* JADX WARN: Code duplicated, block: B:168:0x0288  */
    /* JADX WARN: Code duplicated, block: B:171:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:173:0x02bb  */
    /* JADX WARN: Code duplicated, block: B:176:0x02fe  */
    /* JADX WARN: Code duplicated, block: B:177:0x0302  */
    /* JADX WARN: Code duplicated, block: B:180:0x0310  */
    /* JADX WARN: Code duplicated, block: B:182:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x005b  */
    /* JADX WARN: Code duplicated, block: B:33:0x005f  */
    /* JADX WARN: Code duplicated, block: B:35:0x0067  */
    /* JADX WARN: Code duplicated, block: B:36:0x006a  */
    /* JADX WARN: Code duplicated, block: B:39:0x0070  */
    /* JADX WARN: Code duplicated, block: B:42:0x0076  */
    /* JADX WARN: Code duplicated, block: B:44:0x007a  */
    /* JADX WARN: Code duplicated, block: B:46:0x0082  */
    /* JADX WARN: Code duplicated, block: B:47:0x0085  */
    /* JADX WARN: Code duplicated, block: B:50:0x008b  */
    /* JADX WARN: Code duplicated, block: B:53:0x0093  */
    /* JADX WARN: Code duplicated, block: B:54:0x0096  */
    /* JADX WARN: Code duplicated, block: B:56:0x009a  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:66:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:71:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:77:0x00db  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:88:0x0100  */
    /* JADX WARN: Code duplicated, block: B:89:0x0103  */
    /* JADX WARN: Code duplicated, block: B:92:0x010c  */
    /* JADX WARN: Code duplicated, block: B:94:0x0119  */
    /* JADX INFO: renamed from: IndicatorBox-1CPYgEU, reason: not valid java name */
    public final void m5107IndicatorBox1CPYgEU(final PullToRefreshState pullToRefreshState, final boolean z, Modifier modifier, float f, Shape shape2, long j, float f2, final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        boolean z2;
        Modifier modifier2;
        float f3;
        Shape shape3;
        int i4;
        long jM6850getUnspecified0d7_KjU;
        int i5;
        float f4;
        boolean z3;
        boolean z4;
        final Modifier modifier3;
        final float f5;
        final float f6;
        final Shape shape4;
        final long j2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Object objRememberedValue;
        boolean z5;
        boolean z6;
        boolean z7;
        Object objRememberedValue2;
        int currentCompositeKeyHash;
        Function0<ComposeUiNode> constructor;
        Composer composerM6062constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        int i6;
        int i7;
        int i8;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1341144489);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(IndicatorBox)N(state,isRefreshing,modifier,maxDistance:c#ui.unit.Dp,shape,containerColor:c#ui.graphics.Color,elevation:c#ui.unit.Dp,content)490@19054L372,500@19455L951,486@18916L1652:PullToRefresh.kt#djiw08");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(pullToRefreshState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            z2 = z;
            i3 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
        } else {
            z2 = z;
        }
        int i9 = i2 & 4;
        if (i9 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    f3 = f;
                    int i10 = composerStartRestartGroup.changed(f3) ? 2048 : 1024;
                    i3 |= i10;
                } else {
                    f3 = f;
                }
                i3 |= i10;
            } else {
                f3 = f;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    shape3 = shape2;
                    int i11 = composerStartRestartGroup.changed(shape3) ? 16384 : 8192;
                    i3 |= i11;
                } else {
                    shape3 = shape2;
                }
                i3 |= i11;
            } else {
                shape3 = shape2;
            }
            i4 = i2 & 32;
            if (i4 != 0) {
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    jM6850getUnspecified0d7_KjU = j;
                    if (composerStartRestartGroup.changed(jM6850getUnspecified0d7_KjU)) {
                        i5 = 131072;
                    } else {
                        i5 = 65536;
                    }
                    i3 |= i5;
                }
                if ((i & 1572864) == 0) {
                    f4 = f2;
                    if ((i2 & 64) == 0 || !composerStartRestartGroup.changed(f4)) {
                        i8 = 524288;
                    } else {
                        i8 = 1048576;
                    }
                    i3 |= i8;
                } else {
                    f4 = f2;
                }
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i7 = 8388608;
                    } else {
                        i7 = 4194304;
                    }
                    i3 |= i7;
                }
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(this)) {
                        i6 = 67108864;
                    } else {
                        i6 = 33554432;
                    }
                    i3 |= i6;
                }
                z3 = true;
                if ((i3 & 38347923) != 38347922) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i9 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            f3 = IndicatorMaxDistance;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            shape3 = indicatorShape;
                        }
                        if (i4 != 0) {
                            jM6850getUnspecified0d7_KjU = Color.INSTANCE.m6850getUnspecified0d7_KjU();
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            f4 = Elevation;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1341144489, i3, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.IndicatorBox (PullToRefresh.kt:485)");
                    }
                    Modifier modifierM1266size3ABfNKs = SizeKt.m1266size3ABfNKs(modifier2, PullToRefreshKt.getSpinnerContainerSize());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -349648757, "CC(remember):PullToRefresh.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return PullToRefreshDefaults.IndicatorBox_1CPYgEU$lambda$0$0((ContentDrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierDrawWithContent = DrawModifierKt.drawWithContent(modifierM1266size3ABfNKs, (Function1) objRememberedValue);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -349635346, "CC(remember):PullToRefresh.kt#9igjgp");
                    if ((i3 & 14) == 4) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if ((i3 & 112) == 32) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    boolean z8 = z5 | z6 | ((((i3 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(f3)) || (i3 & 3072) == 2048) | ((((3670016 & i3) ^ 1572864) <= 1048576 && composerStartRestartGroup.changed(f4)) || (i3 & 1572864) == 1048576);
                    if ((((57344 & i3) ^ 24576) > 16384 || !composerStartRestartGroup.changed(shape3)) && (i3 & 24576) != 16384) {
                    }
                    z7 = z8 | z3;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z7 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        final boolean z9 = z2;
                        final float f7 = f3;
                        final float f8 = f4;
                        final Shape shape5 = shape3;
                        objRememberedValue2 = new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return PullToRefreshDefaults.IndicatorBox_1CPYgEU$lambda$1$0(pullToRefreshState, z9, f7, f8, shape5, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierM588backgroundbw27NRU = BackgroundKt.m588backgroundbw27NRU(LayoutModifierKt.layout(modifierDrawWithContent, (Function3) objRememberedValue2), jM6850getUnspecified0d7_KjU, shape3);
                    Alignment center = Alignment.INSTANCE.getCenter();
                    int i12 = ((i3 >> 12) & 7168) | 48;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM588backgroundbw27NRU);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                    composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    function3.invoke(BoxScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i12 >> 6) & 112) | 6));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                }
                modifier3 = modifier2;
                f5 = f3;
                f6 = f4;
                shape4 = shape3;
                j2 = jM6850getUnspecified0d7_KjU;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PullToRefreshDefaults.IndicatorBox_1CPYgEU$lambda$2(this.f$0, pullToRefreshState, z, modifier3, f5, shape4, j2, f6, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            jM6850getUnspecified0d7_KjU = j;
            if ((i & 1572864) == 0) {
                f4 = f2;
                if ((i2 & 64) == 0) {
                    i8 = 524288;
                } else {
                    i8 = 524288;
                }
                i3 |= i8;
            } else {
                f4 = f2;
            }
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i7 = 8388608;
                } else {
                    i7 = 4194304;
                }
                i3 |= i7;
            }
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i6 = 67108864;
                } else {
                    i6 = 33554432;
                }
                i3 |= i6;
            }
            z3 = true;
            if ((i3 & 38347923) != 38347922) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        f3 = IndicatorMaxDistance;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        shape3 = indicatorShape;
                    }
                    if (i4 != 0) {
                        jM6850getUnspecified0d7_KjU = Color.INSTANCE.m6850getUnspecified0d7_KjU();
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        f4 = Elevation;
                    }
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        f3 = IndicatorMaxDistance;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        shape3 = indicatorShape;
                    }
                    if (i4 != 0) {
                        jM6850getUnspecified0d7_KjU = Color.INSTANCE.m6850getUnspecified0d7_KjU();
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        f4 = Elevation;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1341144489, i3, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.IndicatorBox (PullToRefresh.kt:485)");
                }
                Modifier modifierM1266size3ABfNKs2 = SizeKt.m1266size3ABfNKs(modifier2, PullToRefreshKt.getSpinnerContainerSize());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -349648757, "CC(remember):PullToRefresh.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PullToRefreshDefaults.IndicatorBox_1CPYgEU$lambda$0$0((ContentDrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierDrawWithContent2 = DrawModifierKt.drawWithContent(modifierM1266size3ABfNKs2, (Function1) objRememberedValue);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -349635346, "CC(remember):PullToRefresh.kt#9igjgp");
                if ((i3 & 14) == 4) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if ((i3 & 112) == 32) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                boolean z10 = z5 | z6 | ((((i3 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(f3)) || (i3 & 3072) == 2048) | ((((3670016 & i3) ^ 1572864) <= 1048576 && composerStartRestartGroup.changed(f4)) || (i3 & 1572864) == 1048576);
                z3 = ((57344 & i3) ^ 24576) > 16384 ? false : false;
                z7 = z10 | z3;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z7) {
                    final boolean z11 = z2;
                    final float f9 = f3;
                    final float f10 = f4;
                    final Shape shape6 = shape3;
                    objRememberedValue2 = new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return PullToRefreshDefaults.IndicatorBox_1CPYgEU$lambda$1$0(pullToRefreshState, z11, f9, f10, shape6, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    final boolean z12 = z2;
                    final float f11 = f3;
                    final float f12 = f4;
                    final Shape shape7 = shape3;
                    objRememberedValue2 = new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return PullToRefreshDefaults.IndicatorBox_1CPYgEU$lambda$1$0(pullToRefreshState, z12, f11, f12, shape7, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierM588backgroundbw27NRU2 = BackgroundKt.m588backgroundbw27NRU(LayoutModifierKt.layout(modifierDrawWithContent2, (Function3) objRememberedValue2), jM6850getUnspecified0d7_KjU, shape3);
                Alignment center2 = Alignment.INSTANCE.getCenter();
                int i13 = ((i3 >> 12) & 7168) | 48;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM588backgroundbw27NRU2);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting()) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                function3.invoke(BoxScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i13 >> 6) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
            }
            modifier3 = modifier2;
            f5 = f3;
            f6 = f4;
            shape4 = shape3;
            j2 = jM6850getUnspecified0d7_KjU;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PullToRefreshDefaults.IndicatorBox_1CPYgEU$lambda$2(this.f$0, pullToRefreshState, z, modifier3, f5, shape4, j2, f6, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                f3 = f;
                if (composerStartRestartGroup.changed(f3)) {
                }
                i3 |= i10;
            } else {
                f3 = f;
            }
            i3 |= i10;
        } else {
            f3 = f;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                shape3 = shape2;
                if (composerStartRestartGroup.changed(shape3)) {
                }
                i3 |= i11;
            } else {
                shape3 = shape2;
            }
            i3 |= i11;
        } else {
            shape3 = shape2;
        }
        i4 = i2 & 32;
        if (i4 != 0) {
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                jM6850getUnspecified0d7_KjU = j;
                if (composerStartRestartGroup.changed(jM6850getUnspecified0d7_KjU)) {
                    i5 = 131072;
                } else {
                    i5 = 65536;
                }
                i3 |= i5;
            }
            if ((i & 1572864) == 0) {
                f4 = f2;
                if ((i2 & 64) == 0) {
                    i8 = 524288;
                } else {
                    i8 = 524288;
                }
                i3 |= i8;
            } else {
                f4 = f2;
            }
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i7 = 8388608;
                } else {
                    i7 = 4194304;
                }
                i3 |= i7;
            }
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i6 = 67108864;
                } else {
                    i6 = 33554432;
                }
                i3 |= i6;
            }
            z3 = true;
            if ((i3 & 38347923) != 38347922) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        f3 = IndicatorMaxDistance;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        shape3 = indicatorShape;
                    }
                    if (i4 != 0) {
                        jM6850getUnspecified0d7_KjU = Color.INSTANCE.m6850getUnspecified0d7_KjU();
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        f4 = Elevation;
                    }
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        f3 = IndicatorMaxDistance;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        shape3 = indicatorShape;
                    }
                    if (i4 != 0) {
                        jM6850getUnspecified0d7_KjU = Color.INSTANCE.m6850getUnspecified0d7_KjU();
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        f4 = Elevation;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1341144489, i3, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.IndicatorBox (PullToRefresh.kt:485)");
                }
                Modifier modifierM1266size3ABfNKs3 = SizeKt.m1266size3ABfNKs(modifier2, PullToRefreshKt.getSpinnerContainerSize());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -349648757, "CC(remember):PullToRefresh.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PullToRefreshDefaults.IndicatorBox_1CPYgEU$lambda$0$0((ContentDrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierDrawWithContent3 = DrawModifierKt.drawWithContent(modifierM1266size3ABfNKs3, (Function1) objRememberedValue);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -349635346, "CC(remember):PullToRefresh.kt#9igjgp");
                if ((i3 & 14) == 4) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if ((i3 & 112) == 32) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                boolean z13 = z5 | z6 | ((((i3 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(f3)) || (i3 & 3072) == 2048) | ((((3670016 & i3) ^ 1572864) <= 1048576 && composerStartRestartGroup.changed(f4)) || (i3 & 1572864) == 1048576);
                if (((57344 & i3) ^ 24576) > 16384) {
                }
                z7 = z13 | z3;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z7) {
                    final boolean z14 = z2;
                    final float f13 = f3;
                    final float f14 = f4;
                    final Shape shape8 = shape3;
                    objRememberedValue2 = new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return PullToRefreshDefaults.IndicatorBox_1CPYgEU$lambda$1$0(pullToRefreshState, z14, f13, f14, shape8, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    final boolean z15 = z2;
                    final float f15 = f3;
                    final float f16 = f4;
                    final Shape shape9 = shape3;
                    objRememberedValue2 = new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return PullToRefreshDefaults.IndicatorBox_1CPYgEU$lambda$1$0(pullToRefreshState, z15, f15, f16, shape9, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierM588backgroundbw27NRU3 = BackgroundKt.m588backgroundbw27NRU(LayoutModifierKt.layout(modifierDrawWithContent3, (Function3) objRememberedValue2), jM6850getUnspecified0d7_KjU, shape3);
                Alignment center3 = Alignment.INSTANCE.getCenter();
                int i14 = ((i3 >> 12) & 7168) | 48;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center3, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM588backgroundbw27NRU3);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting()) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                function3.invoke(BoxScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i14 >> 6) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
            }
            modifier3 = modifier2;
            f5 = f3;
            f6 = f4;
            shape4 = shape3;
            j2 = jM6850getUnspecified0d7_KjU;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PullToRefreshDefaults.IndicatorBox_1CPYgEU$lambda$2(this.f$0, pullToRefreshState, z, modifier3, f5, shape4, j2, f6, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        jM6850getUnspecified0d7_KjU = j;
        if ((i & 1572864) == 0) {
            f4 = f2;
            if ((i2 & 64) == 0) {
                i8 = 524288;
            } else {
                i8 = 524288;
            }
            i3 |= i8;
        } else {
            f4 = f2;
        }
        if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i7 = 8388608;
            } else {
                i7 = 4194304;
            }
            i3 |= i7;
        }
        if ((i & 100663296) == 0) {
            if (composerStartRestartGroup.changed(this)) {
                i6 = 67108864;
            } else {
                i6 = 33554432;
            }
            i3 |= i6;
        }
        z3 = true;
        if ((i3 & 38347923) != 38347922) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    f3 = IndicatorMaxDistance;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    shape3 = indicatorShape;
                }
                if (i4 != 0) {
                    jM6850getUnspecified0d7_KjU = Color.INSTANCE.m6850getUnspecified0d7_KjU();
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    f4 = Elevation;
                }
            } else {
                if (i9 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    f3 = IndicatorMaxDistance;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    shape3 = indicatorShape;
                }
                if (i4 != 0) {
                    jM6850getUnspecified0d7_KjU = Color.INSTANCE.m6850getUnspecified0d7_KjU();
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    f4 = Elevation;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1341144489, i3, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.IndicatorBox (PullToRefresh.kt:485)");
            }
            Modifier modifierM1266size3ABfNKs4 = SizeKt.m1266size3ABfNKs(modifier2, PullToRefreshKt.getSpinnerContainerSize());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -349648757, "CC(remember):PullToRefresh.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PullToRefreshDefaults.IndicatorBox_1CPYgEU$lambda$0$0((ContentDrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierDrawWithContent4 = DrawModifierKt.drawWithContent(modifierM1266size3ABfNKs4, (Function1) objRememberedValue);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -349635346, "CC(remember):PullToRefresh.kt#9igjgp");
            if ((i3 & 14) == 4) {
                z5 = true;
            } else {
                z5 = false;
            }
            if ((i3 & 112) == 32) {
                z6 = true;
            } else {
                z6 = false;
            }
            boolean z16 = z5 | z6 | ((((i3 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(f3)) || (i3 & 3072) == 2048) | ((((3670016 & i3) ^ 1572864) <= 1048576 && composerStartRestartGroup.changed(f4)) || (i3 & 1572864) == 1048576);
            if (((57344 & i3) ^ 24576) > 16384) {
            }
            z7 = z16 | z3;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!z7) {
                final boolean z17 = z2;
                final float f17 = f3;
                final float f18 = f4;
                final Shape shape10 = shape3;
                objRememberedValue2 = new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PullToRefreshDefaults.IndicatorBox_1CPYgEU$lambda$1$0(pullToRefreshState, z17, f17, f18, shape10, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                final boolean z18 = z2;
                final float f19 = f3;
                final float f110 = f4;
                final Shape shape11 = shape3;
                objRememberedValue2 = new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PullToRefreshDefaults.IndicatorBox_1CPYgEU$lambda$1$0(pullToRefreshState, z18, f19, f110, shape11, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM588backgroundbw27NRU4 = BackgroundKt.m588backgroundbw27NRU(LayoutModifierKt.layout(modifierDrawWithContent4, (Function3) objRememberedValue2), jM6850getUnspecified0d7_KjU, shape3);
            Alignment center4 = Alignment.INSTANCE.getCenter();
            int i15 = ((i3 >> 12) & 7168) | 48;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(center4, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM588backgroundbw27NRU4);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
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
            composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM6062constructorimpl.getInserting()) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            function3.invoke(BoxScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i15 >> 6) & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        modifier3 = modifier2;
        f5 = f3;
        f6 = f4;
        shape4 = shape3;
        j2 = jM6850getUnspecified0d7_KjU;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PullToRefreshDefaults.IndicatorBox_1CPYgEU$lambda$2(this.f$0, pullToRefreshState, z, modifier3, f5, shape4, j2, f6, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IndicatorBox_1CPYgEU$lambda$0$0(ContentDrawScope contentDrawScope) {
        int iM6803getIntersectrtfAjoo = ClipOp.INSTANCE.m6803getIntersectrtfAjoo();
        DrawContext drawContext = contentDrawScope.getDrawContext();
        long jMo7316getSizeNHjbRc = drawContext.mo7316getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo7319clipRectN_I0leg(-3.4028235E38f, 0.0f, Float.MAX_VALUE, Float.MAX_VALUE, iM6803getIntersectrtfAjoo);
            contentDrawScope.drawContent();
            return Unit.INSTANCE;
        } finally {
            drawContext.getCanvas().restore();
            drawContext.mo7317setSizeuvyYCjk(jMo7316getSizeNHjbRc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult IndicatorBox_1CPYgEU$lambda$1$0(final PullToRefreshState pullToRefreshState, final boolean z, final float f, final float f2, final Shape shape2, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        final Placeable placeableMo8265measureBRTryo0 = measurable.mo8265measureBRTryo0(constraints.getValue());
        return MeasureScope.layout$default(measureScope, placeableMo8265measureBRTryo0.getWidth(), placeableMo8265measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PullToRefreshDefaults.IndicatorBox_1CPYgEU$lambda$1$0$0(placeableMo8265measureBRTryo0, pullToRefreshState, z, f, f2, shape2, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IndicatorBox_1CPYgEU$lambda$1$0$0(Placeable placeable, final PullToRefreshState pullToRefreshState, final boolean z, final float f, final float f2, final Shape shape2, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeWithLayer$default(placementScope, placeable, 0, 0, 0.0f, new Function1() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PullToRefreshDefaults.IndicatorBox_1CPYgEU$lambda$1$0$0$0(pullToRefreshState, z, f, f2, shape2, (GraphicsLayerScope) obj);
            }
        }, 4, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IndicatorBox_1CPYgEU$lambda$1$0$0$0(PullToRefreshState pullToRefreshState, boolean z, float f, float f2, Shape shape2, GraphicsLayerScope graphicsLayerScope) {
        boolean z2 = pullToRefreshState.getDistanceFraction() > 0.0f || z;
        graphicsLayerScope.setTranslationY((pullToRefreshState.getDistanceFraction() * graphicsLayerScope.mo748roundToPx0680j_4(f)) - Float.intBitsToFloat((int) (graphicsLayerScope.getSize() & 4294967295L)));
        graphicsLayerScope.setShadowElevation(z2 ? graphicsLayerScope.mo754toPx0680j_4(f2) : 0.0f);
        graphicsLayerScope.setShape(shape2);
        graphicsLayerScope.setClip(true);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0125  */
    /* JADX WARN: Code duplicated, block: B:101:0x012c  */
    /* JADX WARN: Code duplicated, block: B:105:0x0138  */
    /* JADX WARN: Code duplicated, block: B:108:0x017c  */
    /* JADX WARN: Code duplicated, block: B:110:0x0184  */
    /* JADX WARN: Code duplicated, block: B:113:0x0190  */
    /* JADX WARN: Code duplicated, block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0056  */
    /* JADX WARN: Code duplicated, block: B:32:0x005a  */
    /* JADX WARN: Code duplicated, block: B:34:0x0062  */
    /* JADX WARN: Code duplicated, block: B:35:0x0065  */
    /* JADX WARN: Code duplicated, block: B:38:0x006b  */
    /* JADX WARN: Code duplicated, block: B:41:0x0071  */
    /* JADX WARN: Code duplicated, block: B:46:0x0080  */
    /* JADX WARN: Code duplicated, block: B:48:0x0084  */
    /* JADX WARN: Code duplicated, block: B:51:0x008b  */
    /* JADX WARN: Code duplicated, block: B:53:0x008f  */
    /* JADX WARN: Code duplicated, block: B:55:0x0097  */
    /* JADX WARN: Code duplicated, block: B:56:0x009a  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:69:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:70:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:88:0x00fb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:89:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:90:0x0102  */
    /* JADX WARN: Code duplicated, block: B:93:0x0107  */
    /* JADX WARN: Code duplicated, block: B:94:0x0112  */
    /* JADX WARN: Code duplicated, block: B:97:0x0117  */
    /* JADX INFO: renamed from: Indicator-2poqoh4, reason: not valid java name */
    public final void m5106Indicator2poqoh4(final PullToRefreshState pullToRefreshState, final boolean z, Modifier modifier, long j, long j2, float f, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        long j3;
        long indicatorColor;
        final float f2;
        boolean z2;
        final Modifier modifier3;
        final long j4;
        final long j5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        long indicatorContainerColor;
        int i4;
        float f3;
        final long j6;
        int i5;
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1076870256);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Indicator)N(state,isRefreshing,modifier,containerColor:c#ui.graphics.Color,color:c#ui.graphics.Color,maxDistance:c#ui.unit.Dp)551@21662L755,545@21453L964:PullToRefresh.kt#djiw08");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(pullToRefreshState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        int i7 = i2 & 4;
        if (i7 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    j3 = j;
                    int i8 = composerStartRestartGroup.changed(j3) ? 2048 : 1024;
                    i3 |= i8;
                } else {
                    j3 = j;
                }
                i3 |= i8;
            } else {
                j3 = j;
            }
            if ((i & 24576) == 0) {
                indicatorColor = j2;
                if ((i2 & 16) == 0 || !composerStartRestartGroup.changed(indicatorColor)) {
                    i6 = 8192;
                } else {
                    i6 = 16384;
                }
                i3 |= i6;
            } else {
                indicatorColor = j2;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    f2 = f;
                    int i9 = composerStartRestartGroup.changed(f2) ? 131072 : 65536;
                    i3 |= i9;
                } else {
                    f2 = f;
                }
                i3 |= i9;
            } else {
                f2 = f;
            }
            if ((1572864 & i) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i5 = 1048576;
                } else {
                    i5 = 524288;
                }
                i3 |= i5;
            }
            if ((599187 & i3) != 599186) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "541@21320L23,542@21373L14");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 8) != 0) {
                        indicatorContainerColor = getIndicatorContainerColor(composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -7169;
                    } else {
                        indicatorContainerColor = j3;
                    }
                    if ((i2 & 16) != 0) {
                        indicatorColor = getIndicatorColor(composerStartRestartGroup, (i3 >> 18) & 14);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i4 = i3 & (-458753);
                        f3 = IndicatorMaxDistance;
                    } else {
                        i4 = i3;
                        f3 = f2;
                    }
                    j6 = indicatorColor;
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
                    companion = modifier2;
                    indicatorContainerColor = j3;
                    j6 = indicatorColor;
                    i4 = i3;
                    f3 = f2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1076870256, i4, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator (PullToRefresh.kt:544)");
                }
                int i10 = (i4 & 14) | 12582912 | (i4 & 112) | (i4 & 896) | ((i4 >> 6) & 7168);
                int i11 = i4 << 6;
                int i12 = i10 | (458752 & i11) | (i11 & 234881024);
                Modifier modifier4 = companion;
                m5107IndicatorBox1CPYgEU(pullToRefreshState, z, modifier4, f3, null, indicatorContainerColor, 0.0f, ComposableLambdaKt.rememberComposableLambda(298232649, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PullToRefreshDefaults.Indicator_2poqoh4$lambda$0(z, j6, pullToRefreshState, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, i12, 80);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f2 = f3;
                j4 = indicatorContainerColor;
                j5 = j6;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                j4 = j3;
                j5 = indicatorColor;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PullToRefreshDefaults.Indicator_2poqoh4$lambda$1(this.f$0, pullToRefreshState, z, modifier3, j4, j5, f2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                j3 = j;
                if (composerStartRestartGroup.changed(j3)) {
                }
                i3 |= i8;
            } else {
                j3 = j;
            }
            i3 |= i8;
        } else {
            j3 = j;
        }
        if ((i & 24576) == 0) {
            indicatorColor = j2;
            if ((i2 & 16) == 0) {
                i6 = 8192;
            } else {
                i6 = 8192;
            }
            i3 |= i6;
        } else {
            indicatorColor = j2;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                f2 = f;
                if (composerStartRestartGroup.changed(f2)) {
                }
                i3 |= i9;
            } else {
                f2 = f;
            }
            i3 |= i9;
        } else {
            f2 = f;
        }
        if ((1572864 & i) == 0) {
            if (composerStartRestartGroup.changed(this)) {
                i5 = 1048576;
            } else {
                i5 = 524288;
            }
            i3 |= i5;
        }
        if ((599187 & i3) != 599186) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "541@21320L23,542@21373L14");
            if ((i & 1) != 0) {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 8) != 0) {
                    indicatorContainerColor = getIndicatorContainerColor(composerStartRestartGroup, (i3 >> 18) & 14);
                    i3 &= -7169;
                } else {
                    indicatorContainerColor = j3;
                }
                if ((i2 & 16) != 0) {
                    indicatorColor = getIndicatorColor(composerStartRestartGroup, (i3 >> 18) & 14);
                    i3 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    i4 = i3 & (-458753);
                    f3 = IndicatorMaxDistance;
                } else {
                    i4 = i3;
                    f3 = f2;
                }
                j6 = indicatorColor;
            } else {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 8) != 0) {
                    indicatorContainerColor = getIndicatorContainerColor(composerStartRestartGroup, (i3 >> 18) & 14);
                    i3 &= -7169;
                } else {
                    indicatorContainerColor = j3;
                }
                if ((i2 & 16) != 0) {
                    indicatorColor = getIndicatorColor(composerStartRestartGroup, (i3 >> 18) & 14);
                    i3 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    i4 = i3 & (-458753);
                    f3 = IndicatorMaxDistance;
                } else {
                    i4 = i3;
                    f3 = f2;
                }
                j6 = indicatorColor;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1076870256, i4, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator (PullToRefresh.kt:544)");
            }
            int i13 = (i4 & 14) | 12582912 | (i4 & 112) | (i4 & 896) | ((i4 >> 6) & 7168);
            int i14 = i4 << 6;
            int i15 = i13 | (458752 & i14) | (i14 & 234881024);
            Modifier modifier5 = companion;
            m5107IndicatorBox1CPYgEU(pullToRefreshState, z, modifier5, f3, null, indicatorContainerColor, 0.0f, ComposableLambdaKt.rememberComposableLambda(298232649, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PullToRefreshDefaults.Indicator_2poqoh4$lambda$0(z, j6, pullToRefreshState, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, i15, 80);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f2 = f3;
            j4 = indicatorContainerColor;
            j5 = j6;
            modifier3 = modifier5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            j4 = j3;
            j5 = indicatorColor;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PullToRefreshDefaults.Indicator_2poqoh4$lambda$1(this.f$0, pullToRefreshState, z, modifier3, j4, j5, f2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Indicator_2poqoh4$lambda$0(boolean z, final long j, final PullToRefreshState pullToRefreshState, BoxScope boxScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C555@21880L7,556@21903L504,553@21756L651:PullToRefresh.kt#djiw08");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(298232649, i, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator.<anonymous> (PullToRefresh.kt:553)");
            }
            CrossfadeKt.Crossfade(Boolean.valueOf(z), (Modifier) null, (FiniteAnimationSpec<Float>) MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composer, 6), (String) null, ComposableLambdaKt.rememberComposableLambda(-2064098104, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PullToRefreshDefaults.Indicator_2poqoh4$lambda$0$0(j, pullToRefreshState, ((Boolean) obj).booleanValue(), (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 24576, 10);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Indicator_2poqoh4$lambda$0$0(long j, final PullToRefreshState pullToRefreshState, boolean z, Composer composer, int i) {
        int i2;
        ComposerKt.sourceInformation(composer, "CN(refreshing):PullToRefresh.kt#djiw08");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(z) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2064098104, i2, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator.<anonymous>.<anonymous> (PullToRefresh.kt:557)");
            }
            if (z) {
                composer.startReplaceGroup(-499763759);
                ComposerKt.sourceInformation(composer, "558@21973L201");
                ProgressIndicatorKt.m3993CircularProgressIndicator4lLiAd8(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, PullToRefreshKt.getSpinnerSize()), j, PullToRefreshKt.StrokeWidth, 0L, 0, 0.0f, composer, 390, 56);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-499540745);
                ComposerKt.sourceInformation(composer, "565@22287L26,564@22220L155");
                ComposerKt.sourceInformationMarkerStart(composer, 676625122, "CC(remember):PullToRefresh.kt#9igjgp");
                boolean zChanged = composer.changed(pullToRefreshState);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new FloatProducer() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda9
                        @Override // androidx.compose.material3.internal.FloatProducer
                        public final float invoke() {
                            return pullToRefreshState.getDistanceFraction();
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                PullToRefreshKt.m5114CircularArrowProgressIndicatorRPmYEkk((FloatProducer) objRememberedValue, j, composer, 0);
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

    /* JADX WARN: Code duplicated, block: B:102:0x0125 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:103:0x0127  */
    /* JADX WARN: Code duplicated, block: B:106:0x0130  */
    /* JADX WARN: Code duplicated, block: B:109:0x013e  */
    /* JADX WARN: Code duplicated, block: B:112:0x014c  */
    /* JADX WARN: Code duplicated, block: B:115:0x0155  */
    /* JADX WARN: Code duplicated, block: B:116:0x015a A[PHI: r3 r6 r7 r9 r11
      0x015a: PHI (r3v22 int) = (r3v13 int), (r3v25 int), (r3v26 int) binds: [B:114:0x0153, B:100:0x0121, B:101:0x0123] A[DONT_GENERATE, DONT_INLINE]
      0x015a: PHI (r6v7 androidx.compose.ui.Modifier) = (r6v3 androidx.compose.ui.Modifier), (r6v2 androidx.compose.ui.Modifier), (r6v2 androidx.compose.ui.Modifier) binds: [B:114:0x0153, B:100:0x0121, B:101:0x0123] A[DONT_GENERATE, DONT_INLINE]
      0x015a: PHI (r7v13 long) = (r7v9 long), (r7v6 long), (r7v6 long) binds: [B:114:0x0153, B:100:0x0121, B:101:0x0123] A[DONT_GENERATE, DONT_INLINE]
      0x015a: PHI (r9v14 float) = (r9v6 float), (r9v4 float), (r9v4 float) binds: [B:114:0x0153, B:100:0x0121, B:101:0x0123] A[DONT_GENERATE, DONT_INLINE]
      0x015a: PHI (r11v9 long) = (r11v3 long), (r11v1 long), (r11v1 long) binds: [B:114:0x0153, B:100:0x0121, B:101:0x0123] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:119:0x0167  */
    /* JADX WARN: Code duplicated, block: B:122:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:124:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:127:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:129:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x005b  */
    /* JADX WARN: Code duplicated, block: B:33:0x005f  */
    /* JADX WARN: Code duplicated, block: B:35:0x0067  */
    /* JADX WARN: Code duplicated, block: B:36:0x006a  */
    /* JADX WARN: Code duplicated, block: B:39:0x0070  */
    /* JADX WARN: Code duplicated, block: B:42:0x0076  */
    /* JADX WARN: Code duplicated, block: B:47:0x0085  */
    /* JADX WARN: Code duplicated, block: B:49:0x0089  */
    /* JADX WARN: Code duplicated, block: B:52:0x0090  */
    /* JADX WARN: Code duplicated, block: B:54:0x0094  */
    /* JADX WARN: Code duplicated, block: B:56:0x009c  */
    /* JADX WARN: Code duplicated, block: B:57:0x009f  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:74:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:76:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ee  */
    /* JADX INFO: renamed from: LoadingIndicator-4eDdRP8, reason: not valid java name */
    public final void m5108LoadingIndicator4eDdRP8(final PullToRefreshState pullToRefreshState, final boolean z, Modifier modifier, long j, long j2, float f, float f2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        long loadingIndicatorContainerColor;
        long loadingIndicatorColor;
        final float f3;
        float f4;
        boolean z2;
        final Modifier modifier3;
        final long j3;
        final long j4;
        final float f5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        float f6;
        int i4;
        int i5;
        Composer composerStartRestartGroup = composer.startRestartGroup(182619560);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadingIndicator)N(state,isRefreshing,modifier,containerColor:c#ui.graphics.Color,color:c#ui.graphics.Color,elevation:c#ui.unit.Dp,maxDistance:c#ui.unit.Dp)604@23790L2488,597@23479L2799:PullToRefresh.kt#djiw08");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(pullToRefreshState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        int i6 = i2 & 4;
        if (i6 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    loadingIndicatorContainerColor = j;
                    int i7 = composerStartRestartGroup.changed(loadingIndicatorContainerColor) ? 2048 : 1024;
                    i3 |= i7;
                } else {
                    loadingIndicatorContainerColor = j;
                }
                i3 |= i7;
            } else {
                loadingIndicatorContainerColor = j;
            }
            if ((i & 24576) == 0) {
                loadingIndicatorColor = j2;
                if ((i2 & 16) == 0 || !composerStartRestartGroup.changed(loadingIndicatorColor)) {
                    i5 = 8192;
                } else {
                    i5 = 16384;
                }
                i3 |= i5;
            } else {
                loadingIndicatorColor = j2;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    f3 = f;
                    int i8 = composerStartRestartGroup.changed(f3) ? 131072 : 65536;
                    i3 |= i8;
                } else {
                    f3 = f;
                }
                i3 |= i8;
            } else {
                f3 = f;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    f4 = f2;
                    int i9 = composerStartRestartGroup.changed(f4) ? 1048576 : 524288;
                    i3 |= i9;
                } else {
                    f4 = f2;
                }
                i3 |= i9;
            } else {
                f4 = f2;
            }
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i4 = 8388608;
                } else {
                    i4 = 4194304;
                }
                i3 |= i4;
            }
            if ((i3 & 4793491) != 4793490) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "592@23281L30,593@23341L21");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i6 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 8) != 0) {
                        loadingIndicatorContainerColor = getLoadingIndicatorContainerColor(composerStartRestartGroup, (i3 >> 21) & 14);
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        loadingIndicatorColor = getLoadingIndicatorColor(composerStartRestartGroup, (i3 >> 21) & 14);
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        f3 = LoadingIndicatorElevation;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        f6 = IndicatorMaxDistance;
                    }
                    Modifier modifier4 = modifier2;
                    final long j5 = loadingIndicatorContainerColor;
                    float f7 = f3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(182619560, i3, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.LoadingIndicator (PullToRefresh.kt:596)");
                    }
                    final long j6 = loadingIndicatorColor;
                    int i10 = (i3 & 14) | 12582912 | (i3 & 112) | ((i3 >> 9) & 7168) | (458752 & (i3 << 6));
                    int i11 = i3 << 3;
                    m5107IndicatorBox1CPYgEU(pullToRefreshState, z, SizeKt.m1268sizeVpY3zN4(modifier4, PullToRefreshKt.getLoaderIndicatorWidth(), PullToRefreshKt.getLoaderIndicatorHeight()), f6, null, j5, f7, ComposableLambdaKt.rememberComposableLambda(2122932769, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return PullToRefreshDefaults.LoadingIndicator_4eDdRP8$lambda$0(z, j5, j6, pullToRefreshState, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, i10 | (3670016 & i11) | (i11 & 234881024), 16);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j3 = j5;
                    f3 = f7;
                    j4 = j6;
                    f5 = f6;
                    modifier3 = modifier4;
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
                }
                f6 = f4;
                Modifier modifier5 = modifier2;
                final long j7 = loadingIndicatorContainerColor;
                float f8 = f3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(182619560, i3, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.LoadingIndicator (PullToRefresh.kt:596)");
                }
                final long j8 = loadingIndicatorColor;
                int i12 = (i3 & 14) | 12582912 | (i3 & 112) | ((i3 >> 9) & 7168) | (458752 & (i3 << 6));
                int i13 = i3 << 3;
                m5107IndicatorBox1CPYgEU(pullToRefreshState, z, SizeKt.m1268sizeVpY3zN4(modifier5, PullToRefreshKt.getLoaderIndicatorWidth(), PullToRefreshKt.getLoaderIndicatorHeight()), f6, null, j7, f8, ComposableLambdaKt.rememberComposableLambda(2122932769, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PullToRefreshDefaults.LoadingIndicator_4eDdRP8$lambda$0(z, j7, j8, pullToRefreshState, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, i12 | (3670016 & i13) | (i13 & 234881024), 16);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j3 = j7;
                f3 = f8;
                j4 = j8;
                f5 = f6;
                modifier3 = modifier5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                j3 = loadingIndicatorContainerColor;
                j4 = loadingIndicatorColor;
                f5 = f4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PullToRefreshDefaults.LoadingIndicator_4eDdRP8$lambda$1(this.f$0, pullToRefreshState, z, modifier3, j3, j4, f3, f5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                loadingIndicatorContainerColor = j;
                if (composerStartRestartGroup.changed(loadingIndicatorContainerColor)) {
                }
                i3 |= i7;
            } else {
                loadingIndicatorContainerColor = j;
            }
            i3 |= i7;
        } else {
            loadingIndicatorContainerColor = j;
        }
        if ((i & 24576) == 0) {
            loadingIndicatorColor = j2;
            if ((i2 & 16) == 0) {
                i5 = 8192;
            } else {
                i5 = 8192;
            }
            i3 |= i5;
        } else {
            loadingIndicatorColor = j2;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                f3 = f;
                if (composerStartRestartGroup.changed(f3)) {
                }
                i3 |= i8;
            } else {
                f3 = f;
            }
            i3 |= i8;
        } else {
            f3 = f;
        }
        if ((1572864 & i) == 0) {
            if ((i2 & 64) == 0) {
                f4 = f2;
                if (composerStartRestartGroup.changed(f4)) {
                }
                i3 |= i9;
            } else {
                f4 = f2;
            }
            i3 |= i9;
        } else {
            f4 = f2;
        }
        if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changed(this)) {
                i4 = 8388608;
            } else {
                i4 = 4194304;
            }
            i3 |= i4;
        }
        if ((i3 & 4793491) != 4793490) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "592@23281L30,593@23341L21");
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 8) != 0) {
                    loadingIndicatorContainerColor = getLoadingIndicatorContainerColor(composerStartRestartGroup, (i3 >> 21) & 14);
                    i3 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    loadingIndicatorColor = getLoadingIndicatorColor(composerStartRestartGroup, (i3 >> 21) & 14);
                    i3 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    f3 = LoadingIndicatorElevation;
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    f6 = IndicatorMaxDistance;
                } else {
                    f6 = f4;
                }
            } else {
                if (i6 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 8) != 0) {
                    loadingIndicatorContainerColor = getLoadingIndicatorContainerColor(composerStartRestartGroup, (i3 >> 21) & 14);
                    i3 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    loadingIndicatorColor = getLoadingIndicatorColor(composerStartRestartGroup, (i3 >> 21) & 14);
                    i3 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    f3 = LoadingIndicatorElevation;
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    f6 = IndicatorMaxDistance;
                } else {
                    f6 = f4;
                }
            }
            Modifier modifier6 = modifier2;
            final long j9 = loadingIndicatorContainerColor;
            float f9 = f3;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(182619560, i3, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.LoadingIndicator (PullToRefresh.kt:596)");
            }
            final long j10 = loadingIndicatorColor;
            int i14 = (i3 & 14) | 12582912 | (i3 & 112) | ((i3 >> 9) & 7168) | (458752 & (i3 << 6));
            int i15 = i3 << 3;
            m5107IndicatorBox1CPYgEU(pullToRefreshState, z, SizeKt.m1268sizeVpY3zN4(modifier6, PullToRefreshKt.getLoaderIndicatorWidth(), PullToRefreshKt.getLoaderIndicatorHeight()), f6, null, j9, f9, ComposableLambdaKt.rememberComposableLambda(2122932769, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PullToRefreshDefaults.LoadingIndicator_4eDdRP8$lambda$0(z, j9, j10, pullToRefreshState, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, i14 | (3670016 & i15) | (i15 & 234881024), 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j3 = j9;
            f3 = f9;
            j4 = j10;
            f5 = f6;
            modifier3 = modifier6;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            j3 = loadingIndicatorContainerColor;
            j4 = loadingIndicatorColor;
            f5 = f4;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PullToRefreshDefaults.LoadingIndicator_4eDdRP8$lambda$1(this.f$0, pullToRefreshState, z, modifier3, j3, j4, f3, f5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoadingIndicator_4eDdRP8$lambda$0(boolean z, final long j, final long j2, final PullToRefreshState pullToRefreshState, BoxScope boxScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C608@24008L7,609@24031L2237,606@23884L2384:PullToRefresh.kt#djiw08");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2122932769, i, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.LoadingIndicator.<anonymous> (PullToRefresh.kt:606)");
            }
            CrossfadeKt.Crossfade(Boolean.valueOf(z), (Modifier) null, (FiniteAnimationSpec<Float>) MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composer, 6), (String) null, ComposableLambdaKt.rememberComposableLambda(1703313632, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PullToRefreshDefaults.LoadingIndicator_4eDdRP8$lambda$0$0(j, j2, pullToRefreshState, ((Boolean) obj).booleanValue(), (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 24576, 10);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoadingIndicator_4eDdRP8$lambda$0$0(long j, long j2, final PullToRefreshState pullToRefreshState, boolean z, Composer composer, int i) {
        int i2;
        ComposerKt.sourceInformation(composer, "CN(refreshing):PullToRefresh.kt#djiw08");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(z) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1703313632, i2, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.LoadingIndicator.<anonymous>.<anonymous> (PullToRefresh.kt:610)");
            }
            if (z) {
                composer.startReplaceGroup(-1622128210);
                ComposerKt.sourceInformation(composer, "611@24101L460");
                LoadingIndicatorKt.m3728ContainedLoadingIndicatorDTcfvLk(SizeKt.m1260requiredSizeVpY3zN4(Modifier.INSTANCE, PullToRefreshKt.getLoaderIndicatorWidth(), PullToRefreshKt.getLoaderIndicatorHeight()), j, j2, null, null, composer, 6, 24);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1621590019);
                ComposerKt.sourceInformation(composer, "627@25029L26,633@25360L748,625@24903L1333");
                ComposerKt.sourceInformationMarkerStart(composer, 501892538, "CC(remember):PullToRefresh.kt#9igjgp");
                boolean zChanged = composer.changed(pullToRefreshState);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(pullToRefreshState.getDistanceFraction());
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Function0 function0 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                Modifier modifierM1260requiredSizeVpY3zN4 = SizeKt.m1260requiredSizeVpY3zN4(Modifier.INSTANCE, PullToRefreshKt.getLoaderIndicatorWidth(), PullToRefreshKt.getLoaderIndicatorHeight());
                ComposerKt.sourceInformationMarkerStart(composer, 501903852, "CC(remember):PullToRefresh.kt#9igjgp");
                boolean zChanged2 = composer.changed(pullToRefreshState);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PullToRefreshDefaults.LoadingIndicator_4eDdRP8$lambda$0$0$1$0(pullToRefreshState, (ContentDrawScope) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                LoadingIndicatorKt.m3729ContainedLoadingIndicatorY0xEhic(function0, DrawModifierKt.drawWithContent(modifierM1260requiredSizeVpY3zN4, (Function1) objRememberedValue2), j, j2, null, null, composer, 0, 48);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoadingIndicator_4eDdRP8$lambda$0$0$1$0(PullToRefreshState pullToRefreshState, ContentDrawScope contentDrawScope) {
        float distanceFraction = pullToRefreshState.getDistanceFraction();
        if (distanceFraction > 1.0f) {
            ContentDrawScope contentDrawScope2 = contentDrawScope;
            float f = (-(distanceFraction - 1)) * 180;
            long jMo7394getCenterF1C5BW0 = contentDrawScope2.mo7394getCenterF1C5BW0();
            DrawContext drawContext = contentDrawScope2.getDrawContext();
            long jMo7316getSizeNHjbRc = drawContext.mo7316getSizeNHjbRc();
            drawContext.getCanvas().save();
            try {
                drawContext.getTransform().mo7322rotateUv8p0NA(f, jMo7394getCenterF1C5BW0);
                contentDrawScope.drawContent();
            } finally {
                drawContext.getCanvas().restore();
                drawContext.mo7317setSizeuvyYCjk(jMo7316getSizeNHjbRc);
            }
        } else {
            contentDrawScope.drawContent();
        }
        return Unit.INSTANCE;
    }
}
