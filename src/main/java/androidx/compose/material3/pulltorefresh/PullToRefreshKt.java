package androidx.compose.material3.pulltorefresh;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.LoadingIndicatorDefaults;
import androidx.compose.material3.MotionSchemeKt;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.material.internal.ViewUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: PullToRefresh.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001a\u001a\u007f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001e\b\u0002\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u00102\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0012\u001aC\u0010\u0013\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00162\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0004\b\u0017\u0010\u0018\u001a\r\u0010\u0019\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u001a\u001a\b\u0010\u001b\u001a\u00020\tH\u0007\u001a\u001f\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0003¢\u0006\u0004\b!\u0010\"\u001a;\u0010#\u001a\u00020\u0001*\u00020$2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0016H\u0002¢\u0006\u0004\b,\u0010-\u001a\u0010\u0010.\u001a\u00020(2\u0006\u0010\u001d\u001a\u00020&H\u0002\u001aC\u0010/\u001a\u00020\u0001*\u00020$2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020*2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010+\u001a\u00020\u0016H\u0002¢\u0006\u0004\b3\u00104\"\u000e\u00105\u001a\u00020&X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u00106\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00107\"\u0010\u00108\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00107\"\u0016\u00109\u001a\u00020\u0016X\u0080\u0004¢\u0006\n\n\u0002\u00107\u001a\u0004\b:\u0010;\"\u0016\u0010<\u001a\u00020\u0016X\u0080\u0004¢\u0006\n\n\u0002\u00107\u001a\u0004\b=\u0010;\"\u0010\u0010>\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00107\"\u0010\u0010?\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00107\"\u001c\u0010@\u001a\u00020\u0016X\u0080\u0004¢\u0006\u0010\n\u0002\u00107\u0012\u0004\bA\u0010B\u001a\u0004\bC\u0010;\"\u001c\u0010D\u001a\u00020\u0016X\u0080\u0004¢\u0006\u0010\n\u0002\u00107\u0012\u0004\bE\u0010B\u001a\u0004\bF\u0010;\"\u000e\u0010G\u001a\u00020&X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010H\u001a\u00020&X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010I\u001a\u00020&X\u0082T¢\u0006\u0002\n\u0000¨\u0006J²\u0006\n\u0010K\u001a\u00020&X\u008a\u0084\u0002"}, d2 = {"PullToRefreshBox", "", "isRefreshing", "", "onRefresh", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "indicator", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "content", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/pulltorefresh/PullToRefreshState;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "pullToRefresh", "enabled", "threshold", "Landroidx/compose/ui/unit/Dp;", "pullToRefresh-Z4HSEVQ", "(Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/pulltorefresh/PullToRefreshState;ZFLkotlin/jvm/functions/Function0;)Landroidx/compose/ui/Modifier;", "rememberPullToRefreshState", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "PullToRefreshState", "CircularArrowProgressIndicator", "progress", "Landroidx/compose/material3/internal/FloatProducer;", "color", "Landroidx/compose/ui/graphics/Color;", "CircularArrowProgressIndicator-RPmYEkk", "(Landroidx/compose/material3/internal/FloatProducer;JLandroidx/compose/runtime/Composer;I)V", "drawCircularIndicator", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "alpha", "", "values", "Landroidx/compose/material3/pulltorefresh/ArrowValues;", "arcBounds", "Landroidx/compose/ui/geometry/Rect;", "strokeWidth", "drawCircularIndicator-KzyDr3Q", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFLandroidx/compose/material3/pulltorefresh/ArrowValues;Landroidx/compose/ui/geometry/Rect;F)V", "ArrowValues", "drawArrow", "arrow", "Landroidx/compose/ui/graphics/Path;", "bounds", "drawArrow-uDrxG_w", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/geometry/Rect;JFLandroidx/compose/material3/pulltorefresh/ArrowValues;F)V", "MaxProgressArc", "StrokeWidth", "F", "ArcRadius", "SpinnerSize", "getSpinnerSize", "()F", "SpinnerContainerSize", "getSpinnerContainerSize", "ArrowWidth", "ArrowHeight", "LoaderIndicatorHeight", "getLoaderIndicatorHeight$annotations", "()V", "getLoaderIndicatorHeight", "LoaderIndicatorWidth", "getLoaderIndicatorWidth$annotations", "getLoaderIndicatorWidth", "MinAlpha", "MaxAlpha", "DragMultiplier", "material3", "targetAlpha"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PullToRefreshKt {
    private static final float DragMultiplier = 0.5f;
    private static final float MaxAlpha = 1.0f;
    private static final float MaxProgressArc = 0.8f;
    private static final float MinAlpha = 0.3f;
    private static final float StrokeWidth = Dp.m9687constructorimpl((float) 2.5d);
    private static final float ArcRadius = Dp.m9687constructorimpl((float) 5.5d);
    private static final float SpinnerSize = Dp.m9687constructorimpl(16);
    private static final float SpinnerContainerSize = Dp.m9687constructorimpl(40);
    private static final float ArrowWidth = Dp.m9687constructorimpl(10);
    private static final float ArrowHeight = Dp.m9687constructorimpl(5);
    private static final float LoaderIndicatorHeight = LoadingIndicatorDefaults.INSTANCE.m3722getContainerHeightD9Ej5fM();
    private static final float LoaderIndicatorWidth = LoadingIndicatorDefaults.INSTANCE.m3723getContainerWidthD9Ej5fM();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CircularArrowProgressIndicator_RPmYEkk$lambda$5(FloatProducer floatProducer, long j, int i, Composer composer, int i2) {
        m5114CircularArrowProgressIndicatorRPmYEkk(floatProducer, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PullToRefreshBox$lambda$2(boolean z, Function0 function0, Modifier modifier, PullToRefreshState pullToRefreshState, Alignment alignment, Function3 function3, Function3 function4, int i, int i2, Composer composer, int i3) {
        PullToRefreshBox(z, function0, modifier, pullToRefreshState, alignment, function3, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void getLoaderIndicatorHeight$annotations() {
    }

    public static /* synthetic */ void getLoaderIndicatorWidth$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PullToRefreshBox$lambda$0(PullToRefreshState pullToRefreshState, boolean z, BoxScope boxScope, Composer composer, int i) {
        int i2;
        ComposerKt.sourceInformation(composer, "C140@6497L148:PullToRefresh.kt#djiw08");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(boxScope) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1028036671, i2, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox.<anonymous> (PullToRefresh.kt:140)");
            }
            PullToRefreshDefaults.INSTANCE.m5106Indicator2poqoh4(pullToRefreshState, z, boxScope.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), 0L, 0L, 0.0f, composer, 1572864, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x017f  */
    /* JADX WARN: Code duplicated, block: B:103:0x0183  */
    /* JADX WARN: Code duplicated, block: B:106:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:108:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:111:0x0212  */
    /* JADX WARN: Code duplicated, block: B:113:0x0218  */
    /* JADX WARN: Code duplicated, block: B:116:0x0225  */
    /* JADX WARN: Code duplicated, block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0056  */
    /* JADX WARN: Code duplicated, block: B:32:0x005a  */
    /* JADX WARN: Code duplicated, block: B:34:0x0062  */
    /* JADX WARN: Code duplicated, block: B:35:0x0065  */
    /* JADX WARN: Code duplicated, block: B:38:0x006b  */
    /* JADX WARN: Code duplicated, block: B:41:0x0071  */
    /* JADX WARN: Code duplicated, block: B:42:0x0074  */
    /* JADX WARN: Code duplicated, block: B:44:0x0078  */
    /* JADX WARN: Code duplicated, block: B:46:0x0080  */
    /* JADX WARN: Code duplicated, block: B:47:0x0083  */
    /* JADX WARN: Code duplicated, block: B:52:0x008f  */
    /* JADX WARN: Code duplicated, block: B:53:0x0091  */
    /* JADX WARN: Code duplicated, block: B:55:0x0094  */
    /* JADX WARN: Code duplicated, block: B:57:0x009c  */
    /* JADX WARN: Code duplicated, block: B:58:0x009f  */
    /* JADX WARN: Code duplicated, block: B:63:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:74:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:76:0x00da  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ee A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:84:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:89:0x0100  */
    /* JADX WARN: Code duplicated, block: B:90:0x0107  */
    /* JADX WARN: Code duplicated, block: B:92:0x010a  */
    /* JADX WARN: Code duplicated, block: B:96:0x0128  */
    /* JADX WARN: Code duplicated, block: B:99:0x0173  */
    public static final void PullToRefreshBox(final boolean z, final Function0<Unit> function0, Modifier modifier, PullToRefreshState pullToRefreshState, Alignment alignment, Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function3, final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i, final int i2) {
        int i3;
        Modifier.Companion companion;
        final PullToRefreshState pullToRefreshStateRememberPullToRefreshState;
        int i4;
        Alignment alignment2;
        int i5;
        int i6;
        Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function3RememberComposableLambda;
        int i7;
        boolean z2;
        final Modifier modifier2;
        final PullToRefreshState pullToRefreshState2;
        final Alignment alignment3;
        final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Alignment topStart;
        int i8;
        Modifier modifier3;
        PullToRefreshState pullToRefreshState3;
        int currentCompositeKeyHash;
        Function0<ComposeUiNode> constructor;
        Composer composerM6062constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        int i9;
        Composer composerStartRestartGroup = composer.startRestartGroup(-532332839);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PullToRefreshBox)N(isRefreshing,onRefresh,modifier,state,contentAlignment,indicator,content)148@6707L200:PullToRefresh.kt#djiw08");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i10 = i2 & 4;
        if (i10 == 0) {
            if ((i & 384) == 0) {
                companion = modifier;
                i3 |= composerStartRestartGroup.changed(companion) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    pullToRefreshStateRememberPullToRefreshState = pullToRefreshState;
                    int i11 = composerStartRestartGroup.changed(pullToRefreshStateRememberPullToRefreshState) ? 2048 : 1024;
                    i3 |= i11;
                } else {
                    pullToRefreshStateRememberPullToRefreshState = pullToRefreshState;
                }
                i3 |= i11;
            } else {
                pullToRefreshStateRememberPullToRefreshState = pullToRefreshState;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    alignment2 = alignment;
                    if (composerStartRestartGroup.changed(alignment2)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    if ((196608 & i) == 0) {
                        function3RememberComposableLambda = function3;
                        if (composerStartRestartGroup.changedInstance(function3RememberComposableLambda)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                    if ((1572864 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    if ((599187 & i3) != 599186) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "137@6354L28,139@6487L164");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i10 != 0) {
                                companion = Modifier.INSTANCE;
                            }
                            if ((i2 & 8) != 0) {
                                pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                                i3 &= -7169;
                            }
                            if (i4 != 0) {
                                topStart = Alignment.INSTANCE.getTopStart();
                            } else {
                                topStart = alignment2;
                            }
                            if (i6 != 0) {
                                function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1028036671, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return PullToRefreshKt.PullToRefreshBox$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            }
                            i8 = i3;
                            modifier3 = companion;
                            pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                            alignment2 = topStart;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            i8 = i3;
                            modifier3 = companion;
                            pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-532332839, i8, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox (PullToRefresh.kt:147)");
                        }
                        Modifier modifierM5119pullToRefreshZ4HSEVQ$default = m5119pullToRefreshZ4HSEVQ$default(modifier3, z, pullToRefreshState3, false, 0.0f, function0, 12, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(alignment2, false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default);
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
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1589913939, "C152@6872L9,153@6890L11:PullToRefresh.kt#djiw08");
                        function4.invoke(boxScopeInstance, composerStartRestartGroup, Integer.valueOf(((i8 >> 15) & 112) | 6));
                        function3RememberComposableLambda.invoke(boxScopeInstance, composerStartRestartGroup, Integer.valueOf(((i8 >> 12) & 112) | 6));
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier3;
                        pullToRefreshState2 = pullToRefreshState3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier2 = companion;
                        pullToRefreshState2 = pullToRefreshStateRememberPullToRefreshState;
                    }
                    alignment3 = alignment2;
                    function5 = function3RememberComposableLambda;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return PullToRefreshKt.PullToRefreshBox$lambda$2(z, function0, modifier2, pullToRefreshState2, alignment3, function5, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function3RememberComposableLambda = function3;
                if ((1572864 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((599187 & i3) != 599186) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "137@6354L28,139@6487L164");
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        }
                        if ((i2 & 8) != 0) {
                            pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            topStart = Alignment.INSTANCE.getTopStart();
                        } else {
                            topStart = alignment2;
                        }
                        if (i6 != 0) {
                            function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1028036671, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return PullToRefreshKt.PullToRefreshBox$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        i8 = i3;
                        modifier3 = companion;
                        pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                        alignment2 = topStart;
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        }
                        if ((i2 & 8) != 0) {
                            pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            topStart = Alignment.INSTANCE.getTopStart();
                        } else {
                            topStart = alignment2;
                        }
                        if (i6 != 0) {
                            function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1028036671, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return PullToRefreshKt.PullToRefreshBox$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        i8 = i3;
                        modifier3 = companion;
                        pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                        alignment2 = topStart;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-532332839, i8, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox (PullToRefresh.kt:147)");
                    }
                    Modifier modifierM5119pullToRefreshZ4HSEVQ$default2 = m5119pullToRefreshZ4HSEVQ$default(modifier3, z, pullToRefreshState3, false, 0.0f, function0, 12, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(alignment2, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default2);
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
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1589913939, "C152@6872L9,153@6890L11:PullToRefresh.kt#djiw08");
                    function4.invoke(boxScopeInstance2, composerStartRestartGroup, Integer.valueOf(((i8 >> 15) & 112) | 6));
                    function3RememberComposableLambda.invoke(boxScopeInstance2, composerStartRestartGroup, Integer.valueOf(((i8 >> 12) & 112) | 6));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    pullToRefreshState2 = pullToRefreshState3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = companion;
                    pullToRefreshState2 = pullToRefreshStateRememberPullToRefreshState;
                }
                alignment3 = alignment2;
                function5 = function3RememberComposableLambda;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PullToRefreshKt.PullToRefreshBox$lambda$2(z, function0, modifier2, pullToRefreshState2, alignment3, function5, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            alignment2 = alignment;
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    function3RememberComposableLambda = function3;
                    if (composerStartRestartGroup.changedInstance(function3RememberComposableLambda)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((1572864 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((599187 & i3) != 599186) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "137@6354L28,139@6487L164");
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        }
                        if ((i2 & 8) != 0) {
                            pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            topStart = Alignment.INSTANCE.getTopStart();
                        } else {
                            topStart = alignment2;
                        }
                        if (i6 != 0) {
                            function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1028036671, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return PullToRefreshKt.PullToRefreshBox$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        i8 = i3;
                        modifier3 = companion;
                        pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                        alignment2 = topStart;
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        }
                        if ((i2 & 8) != 0) {
                            pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            topStart = Alignment.INSTANCE.getTopStart();
                        } else {
                            topStart = alignment2;
                        }
                        if (i6 != 0) {
                            function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1028036671, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return PullToRefreshKt.PullToRefreshBox$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        i8 = i3;
                        modifier3 = companion;
                        pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                        alignment2 = topStart;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-532332839, i8, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox (PullToRefresh.kt:147)");
                    }
                    Modifier modifierM5119pullToRefreshZ4HSEVQ$default3 = m5119pullToRefreshZ4HSEVQ$default(modifier3, z, pullToRefreshState3, false, 0.0f, function0, 12, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(alignment2, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default3);
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
                    BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1589913939, "C152@6872L9,153@6890L11:PullToRefresh.kt#djiw08");
                    function4.invoke(boxScopeInstance3, composerStartRestartGroup, Integer.valueOf(((i8 >> 15) & 112) | 6));
                    function3RememberComposableLambda.invoke(boxScopeInstance3, composerStartRestartGroup, Integer.valueOf(((i8 >> 12) & 112) | 6));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    pullToRefreshState2 = pullToRefreshState3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = companion;
                    pullToRefreshState2 = pullToRefreshStateRememberPullToRefreshState;
                }
                alignment3 = alignment2;
                function5 = function3RememberComposableLambda;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PullToRefreshKt.PullToRefreshBox$lambda$2(z, function0, modifier2, pullToRefreshState2, alignment3, function5, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function3RememberComposableLambda = function3;
            if ((1572864 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            if ((599187 & i3) != 599186) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "137@6354L28,139@6487L164");
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    }
                    if ((i2 & 8) != 0) {
                        pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        topStart = Alignment.INSTANCE.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i6 != 0) {
                        function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1028036671, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return PullToRefreshKt.PullToRefreshBox$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    i8 = i3;
                    modifier3 = companion;
                    pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                    alignment2 = topStart;
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    }
                    if ((i2 & 8) != 0) {
                        pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        topStart = Alignment.INSTANCE.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i6 != 0) {
                        function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1028036671, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return PullToRefreshKt.PullToRefreshBox$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    i8 = i3;
                    modifier3 = companion;
                    pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                    alignment2 = topStart;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-532332839, i8, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox (PullToRefresh.kt:147)");
                }
                Modifier modifierM5119pullToRefreshZ4HSEVQ$default4 = m5119pullToRefreshZ4HSEVQ$default(modifier3, z, pullToRefreshState3, false, 0.0f, function0, 12, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(alignment2, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default4);
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
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1589913939, "C152@6872L9,153@6890L11:PullToRefresh.kt#djiw08");
                function4.invoke(boxScopeInstance4, composerStartRestartGroup, Integer.valueOf(((i8 >> 15) & 112) | 6));
                function3RememberComposableLambda.invoke(boxScopeInstance4, composerStartRestartGroup, Integer.valueOf(((i8 >> 12) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                pullToRefreshState2 = pullToRefreshState3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = companion;
                pullToRefreshState2 = pullToRefreshStateRememberPullToRefreshState;
            }
            alignment3 = alignment2;
            function5 = function3RememberComposableLambda;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PullToRefreshKt.PullToRefreshBox$lambda$2(z, function0, modifier2, pullToRefreshState2, alignment3, function5, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        companion = modifier;
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                pullToRefreshStateRememberPullToRefreshState = pullToRefreshState;
                if (composerStartRestartGroup.changed(pullToRefreshStateRememberPullToRefreshState)) {
                }
                i3 |= i11;
            } else {
                pullToRefreshStateRememberPullToRefreshState = pullToRefreshState;
            }
            i3 |= i11;
        } else {
            pullToRefreshStateRememberPullToRefreshState = pullToRefreshState;
        }
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                alignment2 = alignment;
                if (composerStartRestartGroup.changed(alignment2)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    function3RememberComposableLambda = function3;
                    if (composerStartRestartGroup.changedInstance(function3RememberComposableLambda)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((1572864 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((599187 & i3) != 599186) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "137@6354L28,139@6487L164");
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        }
                        if ((i2 & 8) != 0) {
                            pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            topStart = Alignment.INSTANCE.getTopStart();
                        } else {
                            topStart = alignment2;
                        }
                        if (i6 != 0) {
                            function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1028036671, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return PullToRefreshKt.PullToRefreshBox$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        i8 = i3;
                        modifier3 = companion;
                        pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                        alignment2 = topStart;
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        }
                        if ((i2 & 8) != 0) {
                            pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            topStart = Alignment.INSTANCE.getTopStart();
                        } else {
                            topStart = alignment2;
                        }
                        if (i6 != 0) {
                            function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1028036671, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return PullToRefreshKt.PullToRefreshBox$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        i8 = i3;
                        modifier3 = companion;
                        pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                        alignment2 = topStart;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-532332839, i8, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox (PullToRefresh.kt:147)");
                    }
                    Modifier modifierM5119pullToRefreshZ4HSEVQ$default5 = m5119pullToRefreshZ4HSEVQ$default(modifier3, z, pullToRefreshState3, false, 0.0f, function0, 12, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(alignment2, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default5);
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
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl.getInserting()) {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1589913939, "C152@6872L9,153@6890L11:PullToRefresh.kt#djiw08");
                    function4.invoke(boxScopeInstance5, composerStartRestartGroup, Integer.valueOf(((i8 >> 15) & 112) | 6));
                    function3RememberComposableLambda.invoke(boxScopeInstance5, composerStartRestartGroup, Integer.valueOf(((i8 >> 12) & 112) | 6));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    pullToRefreshState2 = pullToRefreshState3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier2 = companion;
                    pullToRefreshState2 = pullToRefreshStateRememberPullToRefreshState;
                }
                alignment3 = alignment2;
                function5 = function3RememberComposableLambda;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PullToRefreshKt.PullToRefreshBox$lambda$2(z, function0, modifier2, pullToRefreshState2, alignment3, function5, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function3RememberComposableLambda = function3;
            if ((1572864 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            if ((599187 & i3) != 599186) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "137@6354L28,139@6487L164");
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    }
                    if ((i2 & 8) != 0) {
                        pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        topStart = Alignment.INSTANCE.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i6 != 0) {
                        function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1028036671, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return PullToRefreshKt.PullToRefreshBox$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    i8 = i3;
                    modifier3 = companion;
                    pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                    alignment2 = topStart;
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    }
                    if ((i2 & 8) != 0) {
                        pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        topStart = Alignment.INSTANCE.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i6 != 0) {
                        function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1028036671, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return PullToRefreshKt.PullToRefreshBox$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    i8 = i3;
                    modifier3 = companion;
                    pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                    alignment2 = topStart;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-532332839, i8, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox (PullToRefresh.kt:147)");
                }
                Modifier modifierM5119pullToRefreshZ4HSEVQ$default6 = m5119pullToRefreshZ4HSEVQ$default(modifier3, z, pullToRefreshState3, false, 0.0f, function0, 12, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(alignment2, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default6);
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
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting()) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1589913939, "C152@6872L9,153@6890L11:PullToRefresh.kt#djiw08");
                function4.invoke(boxScopeInstance6, composerStartRestartGroup, Integer.valueOf(((i8 >> 15) & 112) | 6));
                function3RememberComposableLambda.invoke(boxScopeInstance6, composerStartRestartGroup, Integer.valueOf(((i8 >> 12) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                pullToRefreshState2 = pullToRefreshState3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = companion;
                pullToRefreshState2 = pullToRefreshStateRememberPullToRefreshState;
            }
            alignment3 = alignment2;
            function5 = function3RememberComposableLambda;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PullToRefreshKt.PullToRefreshBox$lambda$2(z, function0, modifier2, pullToRefreshState2, alignment3, function5, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        alignment2 = alignment;
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((196608 & i) == 0) {
                function3RememberComposableLambda = function3;
                if (composerStartRestartGroup.changedInstance(function3RememberComposableLambda)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            if ((1572864 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            if ((599187 & i3) != 599186) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "137@6354L28,139@6487L164");
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    }
                    if ((i2 & 8) != 0) {
                        pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        topStart = Alignment.INSTANCE.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i6 != 0) {
                        function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1028036671, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return PullToRefreshKt.PullToRefreshBox$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    i8 = i3;
                    modifier3 = companion;
                    pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                    alignment2 = topStart;
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    }
                    if ((i2 & 8) != 0) {
                        pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        topStart = Alignment.INSTANCE.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i6 != 0) {
                        function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1028036671, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return PullToRefreshKt.PullToRefreshBox$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    i8 = i3;
                    modifier3 = companion;
                    pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                    alignment2 = topStart;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-532332839, i8, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox (PullToRefresh.kt:147)");
                }
                Modifier modifierM5119pullToRefreshZ4HSEVQ$default7 = m5119pullToRefreshZ4HSEVQ$default(modifier3, z, pullToRefreshState3, false, 0.0f, function0, 12, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(alignment2, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default7);
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
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting()) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1589913939, "C152@6872L9,153@6890L11:PullToRefresh.kt#djiw08");
                function4.invoke(boxScopeInstance7, composerStartRestartGroup, Integer.valueOf(((i8 >> 15) & 112) | 6));
                function3RememberComposableLambda.invoke(boxScopeInstance7, composerStartRestartGroup, Integer.valueOf(((i8 >> 12) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                pullToRefreshState2 = pullToRefreshState3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = companion;
                pullToRefreshState2 = pullToRefreshStateRememberPullToRefreshState;
            }
            alignment3 = alignment2;
            function5 = function3RememberComposableLambda;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PullToRefreshKt.PullToRefreshBox$lambda$2(z, function0, modifier2, pullToRefreshState2, alignment3, function5, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        function3RememberComposableLambda = function3;
        if ((1572864 & i) == 0) {
            if (composerStartRestartGroup.changedInstance(function4)) {
                i9 = 1048576;
            } else {
                i9 = 524288;
            }
            i3 |= i9;
        }
        if ((599187 & i3) != 599186) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "137@6354L28,139@6487L164");
            if ((i & 1) != 0) {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                }
                if ((i2 & 8) != 0) {
                    pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    topStart = Alignment.INSTANCE.getTopStart();
                } else {
                    topStart = alignment2;
                }
                if (i6 != 0) {
                    function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1028036671, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return PullToRefreshKt.PullToRefreshBox$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                }
                i8 = i3;
                modifier3 = companion;
                pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                alignment2 = topStart;
            } else {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                }
                if ((i2 & 8) != 0) {
                    pullToRefreshStateRememberPullToRefreshState = rememberPullToRefreshState(composerStartRestartGroup, 0);
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    topStart = Alignment.INSTANCE.getTopStart();
                } else {
                    topStart = alignment2;
                }
                if (i6 != 0) {
                    function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1028036671, true, new Function3() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return PullToRefreshKt.PullToRefreshBox$lambda$0(pullToRefreshStateRememberPullToRefreshState, z, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                }
                i8 = i3;
                modifier3 = companion;
                pullToRefreshState3 = pullToRefreshStateRememberPullToRefreshState;
                alignment2 = topStart;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-532332839, i8, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox (PullToRefresh.kt:147)");
            }
            Modifier modifierM5119pullToRefreshZ4HSEVQ$default8 = m5119pullToRefreshZ4HSEVQ$default(modifier3, z, pullToRefreshState3, false, 0.0f, function0, 12, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(alignment2, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default8);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM6062constructorimpl.getInserting()) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance8 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1589913939, "C152@6872L9,153@6890L11:PullToRefresh.kt#djiw08");
            function4.invoke(boxScopeInstance8, composerStartRestartGroup, Integer.valueOf(((i8 >> 15) & 112) | 6));
            function3RememberComposableLambda.invoke(boxScopeInstance8, composerStartRestartGroup, Integer.valueOf(((i8 >> 12) & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            pullToRefreshState2 = pullToRefreshState3;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = companion;
            pullToRefreshState2 = pullToRefreshStateRememberPullToRefreshState;
        }
        alignment3 = alignment2;
        function5 = function3RememberComposableLambda;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PullToRefreshKt.PullToRefreshBox$lambda$2(z, function0, modifier2, pullToRefreshState2, alignment3, function5, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: pullToRefresh-Z4HSEVQ$default, reason: not valid java name */
    public static /* synthetic */ Modifier m5119pullToRefreshZ4HSEVQ$default(Modifier modifier, boolean z, PullToRefreshState pullToRefreshState, boolean z2, float f, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = true;
        }
        boolean z3 = z2;
        if ((i & 8) != 0) {
            f = PullToRefreshDefaults.INSTANCE.m5112getPositionalThresholdD9Ej5fM();
        }
        return m5118pullToRefreshZ4HSEVQ(modifier, z, pullToRefreshState, z3, f, function0);
    }

    /* JADX INFO: renamed from: pullToRefresh-Z4HSEVQ, reason: not valid java name */
    public static final Modifier m5118pullToRefreshZ4HSEVQ(Modifier modifier, boolean z, PullToRefreshState pullToRefreshState, boolean z2, float f, Function0<Unit> function0) {
        return modifier.then(new PullToRefreshElement(z, function0, z2, pullToRefreshState, f, null));
    }

    public static final PullToRefreshState rememberPullToRefreshState(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 318623070, "C(rememberPullToRefreshState)696@27791L28,696@27736L83:PullToRefresh.kt#djiw08");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(318623070, i, -1, "androidx.compose.material3.pulltorefresh.rememberPullToRefreshState (PullToRefresh.kt:695)");
        }
        Object[] objArr = new Object[0];
        Saver<PullToRefreshStateImpl, Float> saver = PullToRefreshStateImpl.INSTANCE.getSaver();
        ComposerKt.sourceInformationMarkerStart(composer, 1254096154, "CC(remember):PullToRefresh.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PullToRefreshKt.rememberPullToRefreshState$lambda$0$0();
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        PullToRefreshStateImpl pullToRefreshStateImpl = (PullToRefreshStateImpl) RememberSaveableKt.m6247rememberSaveable(objArr, (Saver) saver, (Function0) objRememberedValue, composer, 384);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return pullToRefreshStateImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PullToRefreshStateImpl rememberPullToRefreshState$lambda$0$0() {
        return new PullToRefreshStateImpl();
    }

    public static final PullToRefreshState PullToRefreshState() {
        return new PullToRefreshStateImpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: CircularArrowProgressIndicator-RPmYEkk, reason: not valid java name */
    public static final void m5114CircularArrowProgressIndicatorRPmYEkk(final FloatProducer floatProducer, final long j, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1353562852);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CircularArrowProgressIndicator)N(progress,color:c#ui.graphics.Color)742@29136L61,744@29298L76,749@29601L7,747@29476L143,754@29694L175,760@29911L443,752@29625L729:PullToRefresh.kt#djiw08");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(floatProducer) : composerStartRestartGroup.changedInstance(floatProducer) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1353562852, i2, -1, "androidx.compose.material3.pulltorefresh.CircularArrowProgressIndicator (PullToRefresh.kt:741)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 601192889, "CC(remember):PullToRefresh.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Object obj = objRememberedValue;
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                Path Path = AndroidPath_androidKt.Path();
                Path.mo6704setFillTypeoQ8Xj4U(PathFillType.INSTANCE.m7112getEvenOddRgk1Os());
                composerStartRestartGroup.updateRememberedValue(Path);
                obj = Path;
            }
            final Path path = (Path) obj;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 601198088, "CC(remember):PullToRefresh.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(PullToRefreshKt.CircularArrowProgressIndicator_RPmYEkk$lambda$1$0(floatProducer));
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(CircularArrowProgressIndicator_RPmYEkk$lambda$2((State) objRememberedValue2), MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 601210859, "CC(remember):PullToRefresh.kt#9igjgp");
            int i3 = i2 & 14;
            boolean z = i3 == 4 || ((i2 & 8) != 0 && composerStartRestartGroup.changedInstance(floatProducer));
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return PullToRefreshKt.CircularArrowProgressIndicator_RPmYEkk$lambda$3$0(floatProducer, (SemanticsPropertyReceiver) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM1266size3ABfNKs = SizeKt.m1266size3ABfNKs(SemanticsModifierKt.clearAndSetSemantics(companion, (Function1) objRememberedValue3), SpinnerSize);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 601218071, "CC(remember):PullToRefresh.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(stateAnimateFloatAsState) | (i3 == 4 || ((i2 & 8) != 0 && composerStartRestartGroup.changedInstance(floatProducer))) | ((i2 & 112) == 32) | composerStartRestartGroup.changedInstance(path);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                Function1 function1 = new Function1() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return PullToRefreshKt.CircularArrowProgressIndicator_RPmYEkk$lambda$4$0(floatProducer, stateAnimateFloatAsState, j, path, (DrawScope) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function1);
                objRememberedValue4 = function1;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CanvasKt.Canvas(modifierM1266size3ABfNKs, (Function1) objRememberedValue4, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return PullToRefreshKt.CircularArrowProgressIndicator_RPmYEkk$lambda$5(floatProducer, j, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float CircularArrowProgressIndicator_RPmYEkk$lambda$1$0(FloatProducer floatProducer) {
        if (floatProducer.invoke() >= 1.0f) {
            return 1.0f;
        }
        return MinAlpha;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CircularArrowProgressIndicator_RPmYEkk$lambda$3$0(FloatProducer floatProducer, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (floatProducer.invoke() > 0.0f) {
            SemanticsPropertiesKt.setProgressBarRangeInfo(semanticsPropertyReceiver, new ProgressBarRangeInfo(floatProducer.invoke(), RangesKt.rangeTo(0.0f, 1.0f), 0));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CircularArrowProgressIndicator_RPmYEkk$lambda$4$0(FloatProducer floatProducer, State state, long j, Path path, DrawScope drawScope) {
        ArrowValues ArrowValues = ArrowValues(floatProducer.invoke());
        float fFloatValue = ((Number) state.getValue()).floatValue();
        float rotation = ArrowValues.getRotation();
        long jMo7394getCenterF1C5BW0 = drawScope.mo7394getCenterF1C5BW0();
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo7316getSizeNHjbRc = drawContext.mo7316getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo7322rotateUv8p0NA(rotation, jMo7394getCenterF1C5BW0);
            float f = drawScope.mo754toPx0680j_4(ArcRadius);
            float f2 = StrokeWidth;
            Rect rectM6608Rect3MmeM6k = RectKt.m6608Rect3MmeM6k(androidx.compose.ui.geometry.SizeKt.m6648getCenteruvyYCjk(drawScope.mo7395getSizeNHjbRc()), f + (drawScope.mo754toPx0680j_4(f2) / 2.0f));
            m5117drawCircularIndicatorKzyDr3Q(drawScope, j, fFloatValue, ArrowValues, rectM6608Rect3MmeM6k, f2);
            m5116drawArrowuDrxG_w(drawScope, path, rectM6608Rect3MmeM6k, j, fFloatValue, ArrowValues, f2);
            return Unit.INSTANCE;
        } finally {
            drawContext.getCanvas().restore();
            drawContext.mo7317setSizeuvyYCjk(jMo7316getSizeNHjbRc);
        }
    }

    /* JADX INFO: renamed from: drawCircularIndicator-KzyDr3Q, reason: not valid java name */
    private static final void m5117drawCircularIndicatorKzyDr3Q(DrawScope drawScope, long j, float f, ArrowValues arrowValues, Rect rect, float f2) {
        DrawScope.m7374drawArcyD3GUKo$default(drawScope, j, arrowValues.getStartAngle(), arrowValues.getEndAngle() - arrowValues.getStartAngle(), false, rect.m6604getTopLeftF1C5BW0(), rect.m6602getSizeNHjbRc(), f, new Stroke(drawScope.mo754toPx0680j_4(f2), 0.0f, StrokeCap.INSTANCE.m7190getButtKaPHkGw(), 0, null, 26, null), null, 0, ViewUtils.EDGE_TO_EDGE_FLAGS, null);
    }

    private static final ArrowValues ArrowValues(float f) {
        float fMax = (Math.max(Math.min(1.0f, f) - 0.4f, 0.0f) * 5) / 3;
        float fCoerceIn = RangesKt.coerceIn(Math.abs(f) - 1.0f, 0.0f, 2.0f);
        float fPow = (((0.4f * fMax) - 0.25f) + (fCoerceIn - (((float) Math.pow(fCoerceIn, 2)) / 4))) * 0.5f;
        float f2 = 360;
        return new ArrowValues(fPow, fPow * f2, ((0.8f * fMax) + fPow) * f2, Math.min(1.0f, fMax));
    }

    /* JADX INFO: renamed from: drawArrow-uDrxG_w, reason: not valid java name */
    private static final void m5116drawArrowuDrxG_w(DrawScope drawScope, Path path, Rect rect, long j, float f, ArrowValues arrowValues, float f2) {
        path.reset();
        path.moveTo(0.0f, 0.0f);
        float f3 = ArrowWidth;
        path.lineTo((drawScope.mo754toPx0680j_4(f3) * arrowValues.getScale()) / 2, drawScope.mo754toPx0680j_4(ArrowHeight) * arrowValues.getScale());
        path.lineTo(drawScope.mo754toPx0680j_4(f3) * arrowValues.getScale(), 0.0f);
        float fMin = ((Math.min(rect.getRight() - rect.getLeft(), rect.getBottom() - rect.getTop()) / 2.0f) + Float.intBitsToFloat((int) (rect.m6599getCenterF1C5BW0() >> 32))) - ((drawScope.mo754toPx0680j_4(f3) * arrowValues.getScale()) / 2.0f);
        path.mo6706translatek4lQ0M(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (rect.m6599getCenterF1C5BW0() & 4294967295L)) - drawScope.mo754toPx0680j_4(f2))) & 4294967295L) | (Float.floatToRawIntBits(fMin) << 32)));
        float endAngle = arrowValues.getEndAngle() - drawScope.mo754toPx0680j_4(f2);
        long jMo7394getCenterF1C5BW0 = drawScope.mo7394getCenterF1C5BW0();
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo7316getSizeNHjbRc = drawContext.mo7316getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo7322rotateUv8p0NA(endAngle, jMo7394getCenterF1C5BW0);
            DrawScope.m7385drawPathLG529CI$default(drawScope, path, j, f, new Stroke(drawScope.mo754toPx0680j_4(f2), 0.0f, 0, 0, null, 30, null), null, 0, 48, null);
        } finally {
            drawContext.getCanvas().restore();
            drawContext.mo7317setSizeuvyYCjk(jMo7316getSizeNHjbRc);
        }
    }

    public static final float getSpinnerSize() {
        return SpinnerSize;
    }

    public static final float getSpinnerContainerSize() {
        return SpinnerContainerSize;
    }

    public static final float getLoaderIndicatorHeight() {
        return LoaderIndicatorHeight;
    }

    public static final float getLoaderIndicatorWidth() {
        return LoaderIndicatorWidth;
    }

    private static final float CircularArrowProgressIndicator_RPmYEkk$lambda$2(State<Float> state) {
        return state.getValue().floatValue();
    }
}
