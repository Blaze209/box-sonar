package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: TabRow.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\u001a\u009c\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u000723\b\u0002\u0010\t\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a¦\u0001\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u001923\b\u0002\u0010\t\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\"\u0010\u0010\u001c\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001d\"\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"TabRow", "", "selectedTabIndex", "", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "indicator", "Lkotlin/Function1;", "", "Landroidx/compose/material/TabPosition;", "Lkotlin/ParameterName;", "name", "tabPositions", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "divider", "Lkotlin/Function0;", "tabs", "TabRow-pAZo6Ak", "(ILandroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ScrollableTabRow", "edgePadding", "Landroidx/compose/ui/unit/Dp;", "ScrollableTabRow-sKfQg0A", "(ILandroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ScrollableTabRowMinimumTabWidth", "F", "ScrollableTabRowScrollSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TabRowKt {
    private static final float ScrollableTabRowMinimumTabWidth = Dp.m9687constructorimpl(90);
    private static final AnimationSpec<Float> ScrollableTabRowScrollSpec = AnimationSpecKt.tween$default(250, 0, EasingKt.getFastOutSlowInEasing(), 2, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScrollableTabRow_sKfQg0A$lambda$2(int i, Modifier modifier, long j, long j2, float f, Function3 function3, Function2 function2, Function2 function4, int i2, int i3, Composer composer, int i4) {
        m2622ScrollableTabRowsKfQg0A(i, modifier, j, j2, f, function3, function2, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TabRow_pAZo6Ak$lambda$2(int i, Modifier modifier, long j, long j2, Function3 function3, Function2 function2, Function2 function4, int i2, int i3, Composer composer, int i4) {
        m2623TabRowpAZo6Ak(i, modifier, j, j2, function3, function2, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TabRow_pAZo6Ak$lambda$0(int i, List list, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "CN(tabPositions)141@6972L70:TabRow.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1896966245, i2, -1, "androidx.compose.material.TabRow.<anonymous> (TabRow.kt:141)");
        }
        TabRowDefaults.INSTANCE.m2614Indicator9IZ8Weo(TabRowDefaults.INSTANCE.tabIndicatorOffset(Modifier.INSTANCE, (TabPosition) list.get(i)), 0.0f, 0L, composer, 3072, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0130  */
    /* JADX WARN: Code duplicated, block: B:102:0x013f  */
    /* JADX WARN: Code duplicated, block: B:104:0x0142  */
    /* JADX WARN: Code duplicated, block: B:107:0x015a  */
    /* JADX WARN: Code duplicated, block: B:108:0x0166  */
    /* JADX WARN: Code duplicated, block: B:111:0x0196  */
    /* JADX WARN: Code duplicated, block: B:113:0x019f  */
    /* JADX WARN: Code duplicated, block: B:116:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:25:0x0048  */
    /* JADX WARN: Code duplicated, block: B:27:0x0050  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:34:0x005f  */
    /* JADX WARN: Code duplicated, block: B:39:0x006e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0072  */
    /* JADX WARN: Code duplicated, block: B:44:0x0078  */
    /* JADX WARN: Code duplicated, block: B:45:0x007b  */
    /* JADX WARN: Code duplicated, block: B:47:0x007f  */
    /* JADX WARN: Code duplicated, block: B:49:0x0087  */
    /* JADX WARN: Code duplicated, block: B:50:0x008a  */
    /* JADX WARN: Code duplicated, block: B:55:0x0096  */
    /* JADX WARN: Code duplicated, block: B:56:0x0098  */
    /* JADX WARN: Code duplicated, block: B:58:0x009b  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:69:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:74:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:89:0x00ff A[PHI: r0 r3 r6 r8 r11
      0x00ff: PHI (r0v13 androidx.compose.ui.Modifier) = (r0v9 androidx.compose.ui.Modifier), (r0v17 androidx.compose.ui.Modifier) binds: [B:103:0x0140, B:88:0x00fc] A[DONT_GENERATE, DONT_INLINE]
      0x00ff: PHI (r3v22 int) = (r3v16 int), (r3v25 int) binds: [B:103:0x0140, B:88:0x00fc] A[DONT_GENERATE, DONT_INLINE]
      0x00ff: PHI (r6v13 long) = (r6v7 long), (r6v6 long) binds: [B:103:0x0140, B:88:0x00fc] A[DONT_GENERATE, DONT_INLINE]
      0x00ff: PHI (r8v11 kotlin.jvm.functions.Function3<? super java.util.List<androidx.compose.material.TabPosition>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) = 
      (r8v5 kotlin.jvm.functions.Function3<? super java.util.List<androidx.compose.material.TabPosition>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
      (r8v12 kotlin.jvm.functions.Function3<? super java.util.List<androidx.compose.material.TabPosition>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
     binds: [B:103:0x0140, B:88:0x00fc] A[DONT_GENERATE, DONT_INLINE]
      0x00ff: PHI (r11v11 long) = (r11v3 long), (r11v1 long) binds: [B:103:0x0140, B:88:0x00fc] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:91:0x0106 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x0108  */
    /* JADX WARN: Code duplicated, block: B:93:0x010d  */
    /* JADX WARN: Code duplicated, block: B:96:0x0113  */
    /* JADX WARN: Code duplicated, block: B:99:0x0124  */
    /* JADX INFO: renamed from: TabRow-pAZo6Ak, reason: not valid java name */
    public static final void m2623TabRowpAZo6Ak(final int i, Modifier modifier, long j, long j2, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function4, Composer composer, final int i2, final int i3) {
        int i4;
        long primarySurface;
        long jM2360contentColorForek8zF_U;
        int i5;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function5;
        int i6;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function6;
        int i8;
        boolean z;
        Composer composer2;
        final Modifier modifier2;
        final long j3;
        final long j4;
        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function7;
        final Function2<? super Composer, ? super Integer, Unit> function8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        final ComposableLambda composableLambdaRememberComposableLambda;
        int i9;
        final Function2<? super Composer, ? super Integer, Unit> function2M2375getLambda$1216856915$material;
        long j5;
        int i10;
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(113221600);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TabRow)N(selectedTabIndex,modifier,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,indicator,divider,tabs)150@7336L1392,146@7204L1524:TabRow.kt#jmzs0o");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i12 = i3 & 2;
        if (i12 == 0) {
            if ((i2 & 48) == 0) {
                i4 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i2 & 384) == 0) {
                if ((i3 & 4) == 0) {
                    primarySurface = j;
                    int i13 = composerStartRestartGroup.changed(primarySurface) ? 256 : 128;
                    i4 |= i13;
                } else {
                    primarySurface = j;
                }
                i4 |= i13;
            } else {
                primarySurface = j;
            }
            if ((i2 & 3072) == 0) {
                jM2360contentColorForek8zF_U = j2;
                if ((i3 & 8) == 0 || !composerStartRestartGroup.changed(jM2360contentColorForek8zF_U)) {
                    i11 = 1024;
                } else {
                    i11 = 2048;
                }
                i4 |= i11;
            } else {
                jM2360contentColorForek8zF_U = j2;
            }
            i5 = i3 & 16;
            if (i5 != 0) {
                if ((i2 & 24576) == 0) {
                    function5 = function3;
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i6 = 16384;
                    } else {
                        i6 = 8192;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 32;
                if (i7 != 0) {
                    if ((196608 & i2) == 0) {
                        function6 = function2;
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i8 = 131072;
                        } else {
                            i8 = 65536;
                        }
                        i4 |= i8;
                    }
                    if ((i2 & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i4 |= i10;
                    }
                    if ((i4 & 599187) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "137@6739L6,138@6788L32,140@6927L125");
                        if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                                i4 &= -897;
                            }
                            if ((i3 & 8) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                                i4 &= -7169;
                            }
                            if (i5 != 0) {
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1896966245, true, new Function3() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return TabRowKt.TabRow_pAZo6Ak$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            } else {
                                composableLambdaRememberComposableLambda = function5;
                            }
                            if (i7 != 0) {
                                long j6 = primarySurface;
                                i9 = i4;
                                function2M2375getLambda$1216856915$material = ComposableSingletons$TabRowKt.INSTANCE.m2375getLambda$1216856915$material();
                                j5 = j6;
                            }
                            long j7 = jM2360contentColorForek8zF_U;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(113221600, i9, -1, "androidx.compose.material.TabRow (TabRow.kt:145)");
                            }
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m2584SurfaceFjzlyU(SelectableGroupKt.selectableGroup(companion), null, j5, j7, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(-638448612, true, new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TabRowKt.TabRow_pAZo6Ak$lambda$1(function4, function2M2375getLambda$1216856915$material, composableLambdaRememberComposableLambda, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composer2, (i9 & 896) | 1572864 | (i9 & 7168), 50);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier2 = companion;
                            function7 = composableLambdaRememberComposableLambda;
                            j4 = j7;
                            function8 = function2M2375getLambda$1216856915$material;
                            j3 = j5;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i3 & 4) != 0) {
                                i4 &= -897;
                            }
                            if ((i3 & 8) != 0) {
                                i4 &= -7169;
                            }
                            companion = modifier;
                            composableLambdaRememberComposableLambda = function5;
                        }
                        j5 = primarySurface;
                        i9 = i4;
                        function2M2375getLambda$1216856915$material = function6;
                        long j8 = jM2360contentColorForek8zF_U;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(113221600, i9, -1, "androidx.compose.material.TabRow (TabRow.kt:145)");
                        }
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m2584SurfaceFjzlyU(SelectableGroupKt.selectableGroup(companion), null, j5, j8, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(-638448612, true, new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabRowKt.TabRow_pAZo6Ak$lambda$1(function4, function2M2375getLambda$1216856915$material, composableLambdaRememberComposableLambda, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, (i9 & 896) | 1572864 | (i9 & 7168), 50);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = companion;
                        function7 = composableLambdaRememberComposableLambda;
                        j4 = j8;
                        function8 = function2M2375getLambda$1216856915$material;
                        j3 = j5;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier2 = modifier;
                        j3 = primarySurface;
                        j4 = jM2360contentColorForek8zF_U;
                        function7 = function5;
                        function8 = function6;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabRowKt.TabRow_pAZo6Ak$lambda$2(i, modifier2, j3, j4, function7, function8, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function6 = function2;
                if ((i2 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i4 |= i10;
                }
                if ((i4 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "137@6739L6,138@6788L32,140@6927L125");
                    if ((i2 & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1896966245, true, new Function3() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.TabRow_pAZo6Ak$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function5;
                        }
                        if (i7 != 0) {
                            long j9 = primarySurface;
                            i9 = i4;
                            function2M2375getLambda$1216856915$material = ComposableSingletons$TabRowKt.INSTANCE.m2375getLambda$1216856915$material();
                            j5 = j9;
                        } else {
                            j5 = primarySurface;
                            i9 = i4;
                            function2M2375getLambda$1216856915$material = function6;
                        }
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1896966245, true, new Function3() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.TabRow_pAZo6Ak$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function5;
                        }
                        if (i7 != 0) {
                            long j10 = primarySurface;
                            i9 = i4;
                            function2M2375getLambda$1216856915$material = ComposableSingletons$TabRowKt.INSTANCE.m2375getLambda$1216856915$material();
                            j5 = j10;
                        } else {
                            j5 = primarySurface;
                            i9 = i4;
                            function2M2375getLambda$1216856915$material = function6;
                        }
                    }
                    long j11 = jM2360contentColorForek8zF_U;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(113221600, i9, -1, "androidx.compose.material.TabRow (TabRow.kt:145)");
                    }
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m2584SurfaceFjzlyU(SelectableGroupKt.selectableGroup(companion), null, j5, j11, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(-638448612, true, new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.TabRow_pAZo6Ak$lambda$1(function4, function2M2375getLambda$1216856915$material, composableLambdaRememberComposableLambda, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (i9 & 896) | 1572864 | (i9 & 7168), 50);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = companion;
                    function7 = composableLambdaRememberComposableLambda;
                    j4 = j11;
                    function8 = function2M2375getLambda$1216856915$material;
                    j3 = j5;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier2 = modifier;
                    j3 = primarySurface;
                    j4 = jM2360contentColorForek8zF_U;
                    function7 = function5;
                    function8 = function6;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.TabRow_pAZo6Ak$lambda$2(i, modifier2, j3, j4, function7, function8, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 24576;
            function5 = function3;
            i7 = i3 & 32;
            if (i7 != 0) {
                if ((196608 & i2) == 0) {
                    function6 = function2;
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                    i4 |= i8;
                }
                if ((i2 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i4 |= i10;
                }
                if ((i4 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "137@6739L6,138@6788L32,140@6927L125");
                    if ((i2 & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1896966245, true, new Function3() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.TabRow_pAZo6Ak$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function5;
                        }
                        if (i7 != 0) {
                            long j12 = primarySurface;
                            i9 = i4;
                            function2M2375getLambda$1216856915$material = ComposableSingletons$TabRowKt.INSTANCE.m2375getLambda$1216856915$material();
                            j5 = j12;
                        } else {
                            j5 = primarySurface;
                            i9 = i4;
                            function2M2375getLambda$1216856915$material = function6;
                        }
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1896966245, true, new Function3() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.TabRow_pAZo6Ak$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function5;
                        }
                        if (i7 != 0) {
                            long j13 = primarySurface;
                            i9 = i4;
                            function2M2375getLambda$1216856915$material = ComposableSingletons$TabRowKt.INSTANCE.m2375getLambda$1216856915$material();
                            j5 = j13;
                        } else {
                            j5 = primarySurface;
                            i9 = i4;
                            function2M2375getLambda$1216856915$material = function6;
                        }
                    }
                    long j14 = jM2360contentColorForek8zF_U;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(113221600, i9, -1, "androidx.compose.material.TabRow (TabRow.kt:145)");
                    }
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m2584SurfaceFjzlyU(SelectableGroupKt.selectableGroup(companion), null, j5, j14, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(-638448612, true, new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.TabRow_pAZo6Ak$lambda$1(function4, function2M2375getLambda$1216856915$material, composableLambdaRememberComposableLambda, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (i9 & 896) | 1572864 | (i9 & 7168), 50);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = companion;
                    function7 = composableLambdaRememberComposableLambda;
                    j4 = j14;
                    function8 = function2M2375getLambda$1216856915$material;
                    j3 = j5;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier2 = modifier;
                    j3 = primarySurface;
                    j4 = jM2360contentColorForek8zF_U;
                    function7 = function5;
                    function8 = function6;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.TabRow_pAZo6Ak$lambda$2(i, modifier2, j3, j4, function7, function8, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function6 = function2;
            if ((i2 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i4 |= i10;
            }
            if ((i4 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "137@6739L6,138@6788L32,140@6927L125");
                if ((i2 & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                        i4 &= -7169;
                    }
                    if (i5 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1896966245, true, new Function3() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.TabRow_pAZo6Ak$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function5;
                    }
                    if (i7 != 0) {
                        long j15 = primarySurface;
                        i9 = i4;
                        function2M2375getLambda$1216856915$material = ComposableSingletons$TabRowKt.INSTANCE.m2375getLambda$1216856915$material();
                        j5 = j15;
                    } else {
                        j5 = primarySurface;
                        i9 = i4;
                        function2M2375getLambda$1216856915$material = function6;
                    }
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                        i4 &= -7169;
                    }
                    if (i5 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1896966245, true, new Function3() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.TabRow_pAZo6Ak$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function5;
                    }
                    if (i7 != 0) {
                        long j16 = primarySurface;
                        i9 = i4;
                        function2M2375getLambda$1216856915$material = ComposableSingletons$TabRowKt.INSTANCE.m2375getLambda$1216856915$material();
                        j5 = j16;
                    } else {
                        j5 = primarySurface;
                        i9 = i4;
                        function2M2375getLambda$1216856915$material = function6;
                    }
                }
                long j17 = jM2360contentColorForek8zF_U;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(113221600, i9, -1, "androidx.compose.material.TabRow (TabRow.kt:145)");
                }
                composer2 = composerStartRestartGroup;
                SurfaceKt.m2584SurfaceFjzlyU(SelectableGroupKt.selectableGroup(companion), null, j5, j17, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(-638448612, true, new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.TabRow_pAZo6Ak$lambda$1(function4, function2M2375getLambda$1216856915$material, composableLambdaRememberComposableLambda, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, (i9 & 896) | 1572864 | (i9 & 7168), 50);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = companion;
                function7 = composableLambdaRememberComposableLambda;
                j4 = j17;
                function8 = function2M2375getLambda$1216856915$material;
                j3 = j5;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = modifier;
                j3 = primarySurface;
                j4 = jM2360contentColorForek8zF_U;
                function7 = function5;
                function8 = function6;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.TabRow_pAZo6Ak$lambda$2(i, modifier2, j3, j4, function7, function8, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 48;
        if ((i2 & 384) == 0) {
            if ((i3 & 4) == 0) {
                primarySurface = j;
                if (composerStartRestartGroup.changed(primarySurface)) {
                }
                i4 |= i13;
            } else {
                primarySurface = j;
            }
            i4 |= i13;
        } else {
            primarySurface = j;
        }
        if ((i2 & 3072) == 0) {
            jM2360contentColorForek8zF_U = j2;
            if ((i3 & 8) == 0) {
                i11 = 1024;
            } else {
                i11 = 1024;
            }
            i4 |= i11;
        } else {
            jM2360contentColorForek8zF_U = j2;
        }
        i5 = i3 & 16;
        if (i5 != 0) {
            if ((i2 & 24576) == 0) {
                function5 = function3;
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i4 |= i6;
            }
            i7 = i3 & 32;
            if (i7 != 0) {
                if ((196608 & i2) == 0) {
                    function6 = function2;
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                    i4 |= i8;
                }
                if ((i2 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i4 |= i10;
                }
                if ((i4 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "137@6739L6,138@6788L32,140@6927L125");
                    if ((i2 & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1896966245, true, new Function3() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.TabRow_pAZo6Ak$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function5;
                        }
                        if (i7 != 0) {
                            long j18 = primarySurface;
                            i9 = i4;
                            function2M2375getLambda$1216856915$material = ComposableSingletons$TabRowKt.INSTANCE.m2375getLambda$1216856915$material();
                            j5 = j18;
                        } else {
                            j5 = primarySurface;
                            i9 = i4;
                            function2M2375getLambda$1216856915$material = function6;
                        }
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1896966245, true, new Function3() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.TabRow_pAZo6Ak$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function5;
                        }
                        if (i7 != 0) {
                            long j19 = primarySurface;
                            i9 = i4;
                            function2M2375getLambda$1216856915$material = ComposableSingletons$TabRowKt.INSTANCE.m2375getLambda$1216856915$material();
                            j5 = j19;
                        } else {
                            j5 = primarySurface;
                            i9 = i4;
                            function2M2375getLambda$1216856915$material = function6;
                        }
                    }
                    long j110 = jM2360contentColorForek8zF_U;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(113221600, i9, -1, "androidx.compose.material.TabRow (TabRow.kt:145)");
                    }
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m2584SurfaceFjzlyU(SelectableGroupKt.selectableGroup(companion), null, j5, j110, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(-638448612, true, new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.TabRow_pAZo6Ak$lambda$1(function4, function2M2375getLambda$1216856915$material, composableLambdaRememberComposableLambda, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (i9 & 896) | 1572864 | (i9 & 7168), 50);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = companion;
                    function7 = composableLambdaRememberComposableLambda;
                    j4 = j110;
                    function8 = function2M2375getLambda$1216856915$material;
                    j3 = j5;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier2 = modifier;
                    j3 = primarySurface;
                    j4 = jM2360contentColorForek8zF_U;
                    function7 = function5;
                    function8 = function6;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.TabRow_pAZo6Ak$lambda$2(i, modifier2, j3, j4, function7, function8, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function6 = function2;
            if ((i2 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i4 |= i10;
            }
            if ((i4 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "137@6739L6,138@6788L32,140@6927L125");
                if ((i2 & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                        i4 &= -7169;
                    }
                    if (i5 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1896966245, true, new Function3() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.TabRow_pAZo6Ak$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function5;
                    }
                    if (i7 != 0) {
                        long j111 = primarySurface;
                        i9 = i4;
                        function2M2375getLambda$1216856915$material = ComposableSingletons$TabRowKt.INSTANCE.m2375getLambda$1216856915$material();
                        j5 = j111;
                    } else {
                        j5 = primarySurface;
                        i9 = i4;
                        function2M2375getLambda$1216856915$material = function6;
                    }
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                        i4 &= -7169;
                    }
                    if (i5 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1896966245, true, new Function3() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.TabRow_pAZo6Ak$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function5;
                    }
                    if (i7 != 0) {
                        long j112 = primarySurface;
                        i9 = i4;
                        function2M2375getLambda$1216856915$material = ComposableSingletons$TabRowKt.INSTANCE.m2375getLambda$1216856915$material();
                        j5 = j112;
                    } else {
                        j5 = primarySurface;
                        i9 = i4;
                        function2M2375getLambda$1216856915$material = function6;
                    }
                }
                long j113 = jM2360contentColorForek8zF_U;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(113221600, i9, -1, "androidx.compose.material.TabRow (TabRow.kt:145)");
                }
                composer2 = composerStartRestartGroup;
                SurfaceKt.m2584SurfaceFjzlyU(SelectableGroupKt.selectableGroup(companion), null, j5, j113, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(-638448612, true, new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.TabRow_pAZo6Ak$lambda$1(function4, function2M2375getLambda$1216856915$material, composableLambdaRememberComposableLambda, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, (i9 & 896) | 1572864 | (i9 & 7168), 50);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = companion;
                function7 = composableLambdaRememberComposableLambda;
                j4 = j113;
                function8 = function2M2375getLambda$1216856915$material;
                j3 = j5;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = modifier;
                j3 = primarySurface;
                j4 = jM2360contentColorForek8zF_U;
                function7 = function5;
                function8 = function6;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.TabRow_pAZo6Ak$lambda$2(i, modifier2, j3, j4, function7, function8, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 24576;
        function5 = function3;
        i7 = i3 & 32;
        if (i7 != 0) {
            if ((196608 & i2) == 0) {
                function6 = function2;
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i8 = 131072;
                } else {
                    i8 = 65536;
                }
                i4 |= i8;
            }
            if ((i2 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i4 |= i10;
            }
            if ((i4 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "137@6739L6,138@6788L32,140@6927L125");
                if ((i2 & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                        i4 &= -7169;
                    }
                    if (i5 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1896966245, true, new Function3() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.TabRow_pAZo6Ak$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function5;
                    }
                    if (i7 != 0) {
                        long j114 = primarySurface;
                        i9 = i4;
                        function2M2375getLambda$1216856915$material = ComposableSingletons$TabRowKt.INSTANCE.m2375getLambda$1216856915$material();
                        j5 = j114;
                    } else {
                        j5 = primarySurface;
                        i9 = i4;
                        function2M2375getLambda$1216856915$material = function6;
                    }
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                        i4 &= -7169;
                    }
                    if (i5 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1896966245, true, new Function3() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.TabRow_pAZo6Ak$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function5;
                    }
                    if (i7 != 0) {
                        long j115 = primarySurface;
                        i9 = i4;
                        function2M2375getLambda$1216856915$material = ComposableSingletons$TabRowKt.INSTANCE.m2375getLambda$1216856915$material();
                        j5 = j115;
                    } else {
                        j5 = primarySurface;
                        i9 = i4;
                        function2M2375getLambda$1216856915$material = function6;
                    }
                }
                long j116 = jM2360contentColorForek8zF_U;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(113221600, i9, -1, "androidx.compose.material.TabRow (TabRow.kt:145)");
                }
                composer2 = composerStartRestartGroup;
                SurfaceKt.m2584SurfaceFjzlyU(SelectableGroupKt.selectableGroup(companion), null, j5, j116, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(-638448612, true, new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.TabRow_pAZo6Ak$lambda$1(function4, function2M2375getLambda$1216856915$material, composableLambdaRememberComposableLambda, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, (i9 & 896) | 1572864 | (i9 & 7168), 50);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = companion;
                function7 = composableLambdaRememberComposableLambda;
                j4 = j116;
                function8 = function2M2375getLambda$1216856915$material;
                j3 = j5;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = modifier;
                j3 = primarySurface;
                j4 = jM2360contentColorForek8zF_U;
                function7 = function5;
                function8 = function6;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.TabRow_pAZo6Ak$lambda$2(i, modifier2, j3, j4, function7, function8, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        function6 = function2;
        if ((i2 & 1572864) == 0) {
            if (composerStartRestartGroup.changedInstance(function4)) {
                i10 = 1048576;
            } else {
                i10 = 524288;
            }
            i4 |= i10;
        }
        if ((i4 & 599187) != 599186) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "137@6739L6,138@6788L32,140@6927L125");
            if ((i2 & 1) != 0) {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i3 & 4) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i4 &= -897;
                }
                if ((i3 & 8) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                    i4 &= -7169;
                }
                if (i5 != 0) {
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1896966245, true, new Function3() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TabRowKt.TabRow_pAZo6Ak$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                } else {
                    composableLambdaRememberComposableLambda = function5;
                }
                if (i7 != 0) {
                    long j117 = primarySurface;
                    i9 = i4;
                    function2M2375getLambda$1216856915$material = ComposableSingletons$TabRowKt.INSTANCE.m2375getLambda$1216856915$material();
                    j5 = j117;
                } else {
                    j5 = primarySurface;
                    i9 = i4;
                    function2M2375getLambda$1216856915$material = function6;
                }
            } else {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i3 & 4) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i4 &= -897;
                }
                if ((i3 & 8) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                    i4 &= -7169;
                }
                if (i5 != 0) {
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1896966245, true, new Function3() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TabRowKt.TabRow_pAZo6Ak$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                } else {
                    composableLambdaRememberComposableLambda = function5;
                }
                if (i7 != 0) {
                    long j118 = primarySurface;
                    i9 = i4;
                    function2M2375getLambda$1216856915$material = ComposableSingletons$TabRowKt.INSTANCE.m2375getLambda$1216856915$material();
                    j5 = j118;
                } else {
                    j5 = primarySurface;
                    i9 = i4;
                    function2M2375getLambda$1216856915$material = function6;
                }
            }
            long j119 = jM2360contentColorForek8zF_U;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(113221600, i9, -1, "androidx.compose.material.TabRow (TabRow.kt:145)");
            }
            composer2 = composerStartRestartGroup;
            SurfaceKt.m2584SurfaceFjzlyU(SelectableGroupKt.selectableGroup(companion), null, j5, j119, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(-638448612, true, new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabRowKt.TabRow_pAZo6Ak$lambda$1(function4, function2M2375getLambda$1216856915$material, composableLambdaRememberComposableLambda, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, (i9 & 896) | 1572864 | (i9 & 7168), 50);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = companion;
            function7 = composableLambdaRememberComposableLambda;
            j4 = j119;
            function8 = function2M2375getLambda$1216856915$material;
            j3 = j5;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier2 = modifier;
            j3 = primarySurface;
            j4 = jM2360contentColorForek8zF_U;
            function7 = function5;
            function8 = function6;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabRowKt.TabRow_pAZo6Ak$lambda$2(i, modifier2, j3, j4, function7, function8, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TabRow_pAZo6Ak$lambda$1(final Function2 function2, final Function2 function3, final Function3 function4, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C151@7388L1334,151@7346L1376:TabRow.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-638448612, i, -1, "androidx.compose.material.TabRow.<anonymous> (TabRow.kt:151)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 631210194, "CC(remember):TabRow.kt#9igjgp");
            boolean zChanged = composer.changed(function2) | composer.changed(function3) | composer.changed(function4);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.TabRow_pAZo6Ak$lambda$1$0$0(function2, function3, function4, (SubcomposeMeasureScope) obj, (Constraints) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SubcomposeLayoutKt.SubcomposeLayout(modifierFillMaxWidth$default, (Function2) objRememberedValue, composer, 6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult TabRow_pAZo6Ak$lambda$1$0$0(Function2 function2, final Function2 function3, final Function3 function4, final SubcomposeMeasureScope subcomposeMeasureScope, final Constraints constraints) {
        int i;
        Object obj;
        final int iM9640getMaxWidthimpl = Constraints.m9640getMaxWidthimpl(constraints.getValue());
        List<Measurable> listSubcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function2);
        int size = listSubcompose.size();
        int i2 = iM9640getMaxWidthimpl / size;
        ArrayList arrayList = new ArrayList(listSubcompose.size());
        int size2 = listSubcompose.size();
        int i3 = 0;
        while (i3 < size2) {
            int i4 = i2;
            arrayList.add(listSubcompose.get(i3).mo8265measureBRTryo0(Constraints.m9630copyZbe2FdA$default(constraints.getValue(), i4, i4, 0, 0, 12, null)));
            i3++;
            i2 = i4;
            listSubcompose = listSubcompose;
        }
        final int i5 = i2;
        final ArrayList arrayList2 = arrayList;
        if (!arrayList2.isEmpty()) {
            i = 0;
            obj = arrayList2.get(0);
            int height = ((Placeable) obj).getHeight();
            int lastIndex = CollectionsKt.getLastIndex(arrayList2);
            int i6 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Object obj2 = arrayList2.get(i6);
                    int height2 = ((Placeable) obj2).getHeight();
                    if (height < height2) {
                        obj = obj2;
                        height = height2;
                    }
                    if (i6 == lastIndex) {
                        break;
                    }
                    i6++;
                }
            }
        } else {
            obj = null;
            i = 0;
        }
        Placeable placeable = (Placeable) obj;
        int height3 = placeable != null ? placeable.getHeight() : i;
        ArrayList arrayList3 = new ArrayList(size);
        for (int i7 = i; i7 < size; i7++) {
            arrayList3.add(new TabPosition(Dp.m9687constructorimpl(subcomposeMeasureScope.mo751toDpu2uoSUM(i5) * i7), subcomposeMeasureScope.mo751toDpu2uoSUM(i5), null));
        }
        final ArrayList arrayList4 = arrayList3;
        final int i8 = height3;
        return MeasureScope.layout$default(subcomposeMeasureScope, iM9640getMaxWidthimpl, i8, null, new Function1() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj3) {
                return TabRowKt.TabRow_pAZo6Ak$lambda$1$0$0$3(arrayList2, subcomposeMeasureScope, function3, i5, constraints, i8, function4, arrayList4, iM9640getMaxWidthimpl, (Placeable.PlacementScope) obj3);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TabRow_pAZo6Ak$lambda$1$0$0$3$2(Function3 function3, List list, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C176@8515L23:TabRow.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-220665376, i, -1, "androidx.compose.material.TabRow.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:176)");
            }
            function3.invoke(list, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScrollableTabRow_sKfQg0A$lambda$0(int i, List list, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "CN(tabPositions)232@11660L70:TabRow.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-233732148, i2, -1, "androidx.compose.material.ScrollableTabRow.<anonymous> (TabRow.kt:232)");
        }
        TabRowDefaults.INSTANCE.m2614Indicator9IZ8Weo(TabRowDefaults.INSTANCE.tabIndicatorOffset(Modifier.INSTANCE, (TabPosition) list.get(i)), 0.0f, 0L, composer, 3072, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x012a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:102:0x012c  */
    /* JADX WARN: Code duplicated, block: B:103:0x0131  */
    /* JADX WARN: Code duplicated, block: B:106:0x0137  */
    /* JADX WARN: Code duplicated, block: B:109:0x0148  */
    /* JADX WARN: Code duplicated, block: B:111:0x0154  */
    /* JADX WARN: Code duplicated, block: B:112:0x015b  */
    /* JADX WARN: Code duplicated, block: B:114:0x015e  */
    /* JADX WARN: Code duplicated, block: B:115:0x016d  */
    /* JADX WARN: Code duplicated, block: B:117:0x0170  */
    /* JADX WARN: Code duplicated, block: B:118:0x017a  */
    /* JADX WARN: Code duplicated, block: B:121:0x0189  */
    /* JADX WARN: Code duplicated, block: B:124:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:126:0x01da  */
    /* JADX WARN: Code duplicated, block: B:129:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0042  */
    /* JADX WARN: Code duplicated, block: B:25:0x0046  */
    /* JADX WARN: Code duplicated, block: B:27:0x004e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0051  */
    /* JADX WARN: Code duplicated, block: B:31:0x0057  */
    /* JADX WARN: Code duplicated, block: B:34:0x005d  */
    /* JADX WARN: Code duplicated, block: B:36:0x0061  */
    /* JADX WARN: Code duplicated, block: B:38:0x0069  */
    /* JADX WARN: Code duplicated, block: B:39:0x006c  */
    /* JADX WARN: Code duplicated, block: B:42:0x0072  */
    /* JADX WARN: Code duplicated, block: B:45:0x0078  */
    /* JADX WARN: Code duplicated, block: B:46:0x007b  */
    /* JADX WARN: Code duplicated, block: B:48:0x007f  */
    /* JADX WARN: Code duplicated, block: B:50:0x0087  */
    /* JADX WARN: Code duplicated, block: B:51:0x008a  */
    /* JADX WARN: Code duplicated, block: B:56:0x0096  */
    /* JADX WARN: Code duplicated, block: B:57:0x0098  */
    /* JADX WARN: Code duplicated, block: B:59:0x009b  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:70:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:80:0x00db  */
    /* JADX WARN: Code duplicated, block: B:84:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:90:0x0105  */
    /* JADX INFO: renamed from: ScrollableTabRow-sKfQg0A, reason: not valid java name */
    public static final void m2622ScrollableTabRowsKfQg0A(final int i, Modifier modifier, long j, long j2, float f, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function4, Composer composer, final int i2, final int i3) {
        int i4;
        long primarySurface;
        long jM2360contentColorForek8zF_U;
        int i5;
        float f2;
        int i6;
        int i7;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function5;
        int i8;
        int i9;
        int i10;
        boolean z;
        Composer composer2;
        final Modifier modifier2;
        final long j3;
        final long j4;
        final float f3;
        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function6;
        final Function2<? super Composer, ? super Integer, Unit> function7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        float fM2617getScrollableTabRowPaddingD9Ej5fM;
        ComposableLambda composableLambdaRememberComposableLambda;
        Modifier modifier3;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function8;
        Function2<? super Composer, ? super Integer, Unit> function2M2376getLambda$222041980$material;
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1291546575);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ScrollableTabRow)N(selectedTabIndex,modifier,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,edgePadding:c#ui.unit.Dp,indicator,divider,tabs)237@11975L2929,237@11892L3012:TabRow.kt#jmzs0o");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i12 = i3 & 2;
        if (i12 == 0) {
            if ((i2 & 48) == 0) {
                i4 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i2 & 384) == 0) {
                if ((i3 & 4) == 0) {
                    primarySurface = j;
                    int i13 = composerStartRestartGroup.changed(primarySurface) ? 256 : 128;
                    i4 |= i13;
                } else {
                    primarySurface = j;
                }
                i4 |= i13;
            } else {
                primarySurface = j;
            }
            if ((i2 & 3072) == 0) {
                if ((i3 & 8) == 0) {
                    jM2360contentColorForek8zF_U = j2;
                    int i14 = composerStartRestartGroup.changed(jM2360contentColorForek8zF_U) ? 2048 : 1024;
                    i4 |= i14;
                } else {
                    jM2360contentColorForek8zF_U = j2;
                }
                i4 |= i14;
            } else {
                jM2360contentColorForek8zF_U = j2;
            }
            i5 = i3 & 16;
            if (i5 != 0) {
                if ((i2 & 24576) == 0) {
                    f2 = f;
                    if (composerStartRestartGroup.changed(f2)) {
                        i6 = 16384;
                    } else {
                        i6 = 8192;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 32;
                if (i7 != 0) {
                    if ((196608 & i2) == 0) {
                        function5 = function3;
                        if (composerStartRestartGroup.changedInstance(function5)) {
                            i8 = 131072;
                        } else {
                            i8 = 65536;
                        }
                        i4 |= i8;
                    }
                    i9 = i3 & 64;
                    if (i9 != 0) {
                        i4 |= 1572864;
                    } else if ((i2 & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i4 |= i10;
                    }
                    if ((i2 & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i4 |= i11;
                    }
                    if ((i4 & 4793491) != 4793490) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "227@11365L6,228@11414L32,231@11615L125");
                        if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i12 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i3 & 4) != 0) {
                                primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                                i4 &= -897;
                            }
                            if ((i3 & 8) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                                i4 &= -7169;
                            }
                            if (i5 != 0) {
                                fM2617getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m2617getScrollableTabRowPaddingD9Ej5fM();
                            } else {
                                fM2617getScrollableTabRowPaddingD9Ej5fM = f2;
                            }
                            if (i7 != 0) {
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-233732148, true, new Function3() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            } else {
                                composableLambdaRememberComposableLambda = function5;
                            }
                            if (i9 != 0) {
                                function2M2376getLambda$222041980$material = ComposableSingletons$TabRowKt.INSTANCE.m2376getLambda$222041980$material();
                                Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function9 = composableLambdaRememberComposableLambda;
                                modifier3 = companion;
                                function8 = function9;
                            } else {
                                Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function10 = composableLambdaRememberComposableLambda;
                                modifier3 = companion;
                                function8 = function10;
                                function2M2376getLambda$222041980$material = function2;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i3 & 4) != 0) {
                                i4 &= -897;
                            }
                            if ((i3 & 8) != 0) {
                                i4 &= -7169;
                            }
                            function2M2376getLambda$222041980$material = function2;
                            fM2617getScrollableTabRowPaddingD9Ej5fM = f2;
                            function8 = function5;
                            modifier3 = modifier;
                        }
                        long j5 = primarySurface;
                        long j6 = jM2360contentColorForek8zF_U;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1291546575, i4, -1, "androidx.compose.material.ScrollableTabRow (TabRow.kt:236)");
                        }
                        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function11 = function8;
                        final float f4 = fM2617getScrollableTabRowPaddingD9Ej5fM;
                        final Function2<? super Composer, ? super Integer, Unit> function12 = function2M2376getLambda$222041980$material;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m2584SurfaceFjzlyU(modifier3, null, j5, j6, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(-1575164555, true, new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$1(f4, function4, function12, function11, i, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, ((i4 >> 3) & 14) | 1572864 | (i4 & 896) | (i4 & 7168), 50);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function6 = function11;
                        function7 = function12;
                        f3 = fM2617getScrollableTabRowPaddingD9Ej5fM;
                        modifier2 = modifier3;
                        j3 = j5;
                        j4 = j6;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier2 = modifier;
                        j3 = primarySurface;
                        j4 = jM2360contentColorForek8zF_U;
                        f3 = f2;
                        function6 = function5;
                        function7 = function2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$2(i, modifier2, j3, j4, f3, function6, function7, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function5 = function3;
                i9 = i3 & 64;
                if (i9 != 0) {
                    i4 |= 1572864;
                } else if ((i2 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i4 |= i10;
                }
                if ((i2 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i4 |= i11;
                }
                if ((i4 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "227@11365L6,228@11414L32,231@11615L125");
                    if ((i2 & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            fM2617getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m2617getScrollableTabRowPaddingD9Ej5fM();
                        } else {
                            fM2617getScrollableTabRowPaddingD9Ej5fM = f2;
                        }
                        if (i7 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-233732148, true, new Function3() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function5;
                        }
                        if (i9 != 0) {
                            function2M2376getLambda$222041980$material = ComposableSingletons$TabRowKt.INSTANCE.m2376getLambda$222041980$material();
                            Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function13 = composableLambdaRememberComposableLambda;
                            modifier3 = companion;
                            function8 = function13;
                        } else {
                            Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function14 = composableLambdaRememberComposableLambda;
                            modifier3 = companion;
                            function8 = function14;
                            function2M2376getLambda$222041980$material = function2;
                        }
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            fM2617getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m2617getScrollableTabRowPaddingD9Ej5fM();
                        } else {
                            fM2617getScrollableTabRowPaddingD9Ej5fM = f2;
                        }
                        if (i7 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-233732148, true, new Function3() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function5;
                        }
                        if (i9 != 0) {
                            function2M2376getLambda$222041980$material = ComposableSingletons$TabRowKt.INSTANCE.m2376getLambda$222041980$material();
                            Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function15 = composableLambdaRememberComposableLambda;
                            modifier3 = companion;
                            function8 = function15;
                        } else {
                            Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function16 = composableLambdaRememberComposableLambda;
                            modifier3 = companion;
                            function8 = function16;
                            function2M2376getLambda$222041980$material = function2;
                        }
                    }
                    long j7 = primarySurface;
                    long j8 = jM2360contentColorForek8zF_U;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1291546575, i4, -1, "androidx.compose.material.ScrollableTabRow (TabRow.kt:236)");
                    }
                    final Function3 function17 = function8;
                    final float f5 = fM2617getScrollableTabRowPaddingD9Ej5fM;
                    final Function2 function18 = function2M2376getLambda$222041980$material;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m2584SurfaceFjzlyU(modifier3, null, j7, j8, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(-1575164555, true, new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$1(f5, function4, function18, function17, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, ((i4 >> 3) & 14) | 1572864 | (i4 & 896) | (i4 & 7168), 50);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function6 = function17;
                    function7 = function18;
                    f3 = fM2617getScrollableTabRowPaddingD9Ej5fM;
                    modifier2 = modifier3;
                    j3 = j7;
                    j4 = j8;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier2 = modifier;
                    j3 = primarySurface;
                    j4 = jM2360contentColorForek8zF_U;
                    f3 = f2;
                    function6 = function5;
                    function7 = function2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$2(i, modifier2, j3, j4, f3, function6, function7, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 24576;
            f2 = f;
            i7 = i3 & 32;
            if (i7 != 0) {
                if ((196608 & i2) == 0) {
                    function5 = function3;
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                    i4 |= i8;
                }
                i9 = i3 & 64;
                if (i9 != 0) {
                    i4 |= 1572864;
                } else if ((i2 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i4 |= i10;
                }
                if ((i2 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i4 |= i11;
                }
                if ((i4 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "227@11365L6,228@11414L32,231@11615L125");
                    if ((i2 & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            fM2617getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m2617getScrollableTabRowPaddingD9Ej5fM();
                        } else {
                            fM2617getScrollableTabRowPaddingD9Ej5fM = f2;
                        }
                        if (i7 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-233732148, true, new Function3() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function5;
                        }
                        if (i9 != 0) {
                            function2M2376getLambda$222041980$material = ComposableSingletons$TabRowKt.INSTANCE.m2376getLambda$222041980$material();
                            Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function19 = composableLambdaRememberComposableLambda;
                            modifier3 = companion;
                            function8 = function19;
                        } else {
                            Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function110 = composableLambdaRememberComposableLambda;
                            modifier3 = companion;
                            function8 = function110;
                            function2M2376getLambda$222041980$material = function2;
                        }
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            fM2617getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m2617getScrollableTabRowPaddingD9Ej5fM();
                        } else {
                            fM2617getScrollableTabRowPaddingD9Ej5fM = f2;
                        }
                        if (i7 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-233732148, true, new Function3() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function5;
                        }
                        if (i9 != 0) {
                            function2M2376getLambda$222041980$material = ComposableSingletons$TabRowKt.INSTANCE.m2376getLambda$222041980$material();
                            Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function111 = composableLambdaRememberComposableLambda;
                            modifier3 = companion;
                            function8 = function111;
                        } else {
                            Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function112 = composableLambdaRememberComposableLambda;
                            modifier3 = companion;
                            function8 = function112;
                            function2M2376getLambda$222041980$material = function2;
                        }
                    }
                    long j9 = primarySurface;
                    long j10 = jM2360contentColorForek8zF_U;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1291546575, i4, -1, "androidx.compose.material.ScrollableTabRow (TabRow.kt:236)");
                    }
                    final Function3 function113 = function8;
                    final float f6 = fM2617getScrollableTabRowPaddingD9Ej5fM;
                    final Function2 function114 = function2M2376getLambda$222041980$material;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m2584SurfaceFjzlyU(modifier3, null, j9, j10, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(-1575164555, true, new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$1(f6, function4, function114, function113, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, ((i4 >> 3) & 14) | 1572864 | (i4 & 896) | (i4 & 7168), 50);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function6 = function113;
                    function7 = function114;
                    f3 = fM2617getScrollableTabRowPaddingD9Ej5fM;
                    modifier2 = modifier3;
                    j3 = j9;
                    j4 = j10;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier2 = modifier;
                    j3 = primarySurface;
                    j4 = jM2360contentColorForek8zF_U;
                    f3 = f2;
                    function6 = function5;
                    function7 = function2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$2(i, modifier2, j3, j4, f3, function6, function7, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function5 = function3;
            i9 = i3 & 64;
            if (i9 != 0) {
                i4 |= 1572864;
            } else if ((i2 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i4 |= i10;
            }
            if ((i2 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i4 |= i11;
            }
            if ((i4 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "227@11365L6,228@11414L32,231@11615L125");
                if ((i2 & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                        i4 &= -7169;
                    }
                    if (i5 != 0) {
                        fM2617getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m2617getScrollableTabRowPaddingD9Ej5fM();
                    } else {
                        fM2617getScrollableTabRowPaddingD9Ej5fM = f2;
                    }
                    if (i7 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-233732148, true, new Function3() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function5;
                    }
                    if (i9 != 0) {
                        function2M2376getLambda$222041980$material = ComposableSingletons$TabRowKt.INSTANCE.m2376getLambda$222041980$material();
                        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function115 = composableLambdaRememberComposableLambda;
                        modifier3 = companion;
                        function8 = function115;
                    } else {
                        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function116 = composableLambdaRememberComposableLambda;
                        modifier3 = companion;
                        function8 = function116;
                        function2M2376getLambda$222041980$material = function2;
                    }
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                        i4 &= -7169;
                    }
                    if (i5 != 0) {
                        fM2617getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m2617getScrollableTabRowPaddingD9Ej5fM();
                    } else {
                        fM2617getScrollableTabRowPaddingD9Ej5fM = f2;
                    }
                    if (i7 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-233732148, true, new Function3() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function5;
                    }
                    if (i9 != 0) {
                        function2M2376getLambda$222041980$material = ComposableSingletons$TabRowKt.INSTANCE.m2376getLambda$222041980$material();
                        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function117 = composableLambdaRememberComposableLambda;
                        modifier3 = companion;
                        function8 = function117;
                    } else {
                        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function118 = composableLambdaRememberComposableLambda;
                        modifier3 = companion;
                        function8 = function118;
                        function2M2376getLambda$222041980$material = function2;
                    }
                }
                long j11 = primarySurface;
                long j12 = jM2360contentColorForek8zF_U;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1291546575, i4, -1, "androidx.compose.material.ScrollableTabRow (TabRow.kt:236)");
                }
                final Function3 function119 = function8;
                final float f7 = fM2617getScrollableTabRowPaddingD9Ej5fM;
                final Function2 function1110 = function2M2376getLambda$222041980$material;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m2584SurfaceFjzlyU(modifier3, null, j11, j12, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(-1575164555, true, new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$1(f7, function4, function1110, function119, i, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, ((i4 >> 3) & 14) | 1572864 | (i4 & 896) | (i4 & 7168), 50);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function6 = function119;
                function7 = function1110;
                f3 = fM2617getScrollableTabRowPaddingD9Ej5fM;
                modifier2 = modifier3;
                j3 = j11;
                j4 = j12;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = modifier;
                j3 = primarySurface;
                j4 = jM2360contentColorForek8zF_U;
                f3 = f2;
                function6 = function5;
                function7 = function2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$2(i, modifier2, j3, j4, f3, function6, function7, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 48;
        if ((i2 & 384) == 0) {
            if ((i3 & 4) == 0) {
                primarySurface = j;
                if (composerStartRestartGroup.changed(primarySurface)) {
                }
                i4 |= i13;
            } else {
                primarySurface = j;
            }
            i4 |= i13;
        } else {
            primarySurface = j;
        }
        if ((i2 & 3072) == 0) {
            if ((i3 & 8) == 0) {
                jM2360contentColorForek8zF_U = j2;
                if (composerStartRestartGroup.changed(jM2360contentColorForek8zF_U)) {
                }
                i4 |= i14;
            } else {
                jM2360contentColorForek8zF_U = j2;
            }
            i4 |= i14;
        } else {
            jM2360contentColorForek8zF_U = j2;
        }
        i5 = i3 & 16;
        if (i5 != 0) {
            if ((i2 & 24576) == 0) {
                f2 = f;
                if (composerStartRestartGroup.changed(f2)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i4 |= i6;
            }
            i7 = i3 & 32;
            if (i7 != 0) {
                if ((196608 & i2) == 0) {
                    function5 = function3;
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                    i4 |= i8;
                }
                i9 = i3 & 64;
                if (i9 != 0) {
                    i4 |= 1572864;
                } else if ((i2 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i4 |= i10;
                }
                if ((i2 & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i4 |= i11;
                }
                if ((i4 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "227@11365L6,228@11414L32,231@11615L125");
                    if ((i2 & 1) != 0) {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            fM2617getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m2617getScrollableTabRowPaddingD9Ej5fM();
                        } else {
                            fM2617getScrollableTabRowPaddingD9Ej5fM = f2;
                        }
                        if (i7 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-233732148, true, new Function3() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function5;
                        }
                        if (i9 != 0) {
                            function2M2376getLambda$222041980$material = ComposableSingletons$TabRowKt.INSTANCE.m2376getLambda$222041980$material();
                            Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function1111 = composableLambdaRememberComposableLambda;
                            modifier3 = companion;
                            function8 = function1111;
                        } else {
                            Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function1112 = composableLambdaRememberComposableLambda;
                            modifier3 = companion;
                            function8 = function1112;
                            function2M2376getLambda$222041980$material = function2;
                        }
                    } else {
                        if (i12 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i3 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            fM2617getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m2617getScrollableTabRowPaddingD9Ej5fM();
                        } else {
                            fM2617getScrollableTabRowPaddingD9Ej5fM = f2;
                        }
                        if (i7 != 0) {
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-233732148, true, new Function3() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        } else {
                            composableLambdaRememberComposableLambda = function5;
                        }
                        if (i9 != 0) {
                            function2M2376getLambda$222041980$material = ComposableSingletons$TabRowKt.INSTANCE.m2376getLambda$222041980$material();
                            Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function1113 = composableLambdaRememberComposableLambda;
                            modifier3 = companion;
                            function8 = function1113;
                        } else {
                            Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function1114 = composableLambdaRememberComposableLambda;
                            modifier3 = companion;
                            function8 = function1114;
                            function2M2376getLambda$222041980$material = function2;
                        }
                    }
                    long j13 = primarySurface;
                    long j14 = jM2360contentColorForek8zF_U;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1291546575, i4, -1, "androidx.compose.material.ScrollableTabRow (TabRow.kt:236)");
                    }
                    final Function3 function1115 = function8;
                    final float f8 = fM2617getScrollableTabRowPaddingD9Ej5fM;
                    final Function2 function1116 = function2M2376getLambda$222041980$material;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m2584SurfaceFjzlyU(modifier3, null, j13, j14, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(-1575164555, true, new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$1(f8, function4, function1116, function1115, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, ((i4 >> 3) & 14) | 1572864 | (i4 & 896) | (i4 & 7168), 50);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function6 = function1115;
                    function7 = function1116;
                    f3 = fM2617getScrollableTabRowPaddingD9Ej5fM;
                    modifier2 = modifier3;
                    j3 = j13;
                    j4 = j14;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier2 = modifier;
                    j3 = primarySurface;
                    j4 = jM2360contentColorForek8zF_U;
                    f3 = f2;
                    function6 = function5;
                    function7 = function2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$2(i, modifier2, j3, j4, f3, function6, function7, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function5 = function3;
            i9 = i3 & 64;
            if (i9 != 0) {
                i4 |= 1572864;
            } else if ((i2 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i4 |= i10;
            }
            if ((i2 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i4 |= i11;
            }
            if ((i4 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "227@11365L6,228@11414L32,231@11615L125");
                if ((i2 & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                        i4 &= -7169;
                    }
                    if (i5 != 0) {
                        fM2617getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m2617getScrollableTabRowPaddingD9Ej5fM();
                    } else {
                        fM2617getScrollableTabRowPaddingD9Ej5fM = f2;
                    }
                    if (i7 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-233732148, true, new Function3() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function5;
                    }
                    if (i9 != 0) {
                        function2M2376getLambda$222041980$material = ComposableSingletons$TabRowKt.INSTANCE.m2376getLambda$222041980$material();
                        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function1117 = composableLambdaRememberComposableLambda;
                        modifier3 = companion;
                        function8 = function1117;
                    } else {
                        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function1118 = composableLambdaRememberComposableLambda;
                        modifier3 = companion;
                        function8 = function1118;
                        function2M2376getLambda$222041980$material = function2;
                    }
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                        i4 &= -7169;
                    }
                    if (i5 != 0) {
                        fM2617getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m2617getScrollableTabRowPaddingD9Ej5fM();
                    } else {
                        fM2617getScrollableTabRowPaddingD9Ej5fM = f2;
                    }
                    if (i7 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-233732148, true, new Function3() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function5;
                    }
                    if (i9 != 0) {
                        function2M2376getLambda$222041980$material = ComposableSingletons$TabRowKt.INSTANCE.m2376getLambda$222041980$material();
                        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function1119 = composableLambdaRememberComposableLambda;
                        modifier3 = companion;
                        function8 = function1119;
                    } else {
                        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function11110 = composableLambdaRememberComposableLambda;
                        modifier3 = companion;
                        function8 = function11110;
                        function2M2376getLambda$222041980$material = function2;
                    }
                }
                long j15 = primarySurface;
                long j16 = jM2360contentColorForek8zF_U;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1291546575, i4, -1, "androidx.compose.material.ScrollableTabRow (TabRow.kt:236)");
                }
                final Function3 function11111 = function8;
                final float f9 = fM2617getScrollableTabRowPaddingD9Ej5fM;
                final Function2 function11112 = function2M2376getLambda$222041980$material;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m2584SurfaceFjzlyU(modifier3, null, j15, j16, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(-1575164555, true, new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$1(f9, function4, function11112, function11111, i, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, ((i4 >> 3) & 14) | 1572864 | (i4 & 896) | (i4 & 7168), 50);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function6 = function11111;
                function7 = function11112;
                f3 = fM2617getScrollableTabRowPaddingD9Ej5fM;
                modifier2 = modifier3;
                j3 = j15;
                j4 = j16;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = modifier;
                j3 = primarySurface;
                j4 = jM2360contentColorForek8zF_U;
                f3 = f2;
                function6 = function5;
                function7 = function2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$2(i, modifier2, j3, j4, f3, function6, function7, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 24576;
        f2 = f;
        i7 = i3 & 32;
        if (i7 != 0) {
            if ((196608 & i2) == 0) {
                function5 = function3;
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i8 = 131072;
                } else {
                    i8 = 65536;
                }
                i4 |= i8;
            }
            i9 = i3 & 64;
            if (i9 != 0) {
                i4 |= 1572864;
            } else if ((i2 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i4 |= i10;
            }
            if ((i2 & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i4 |= i11;
            }
            if ((i4 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "227@11365L6,228@11414L32,231@11615L125");
                if ((i2 & 1) != 0) {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                        i4 &= -7169;
                    }
                    if (i5 != 0) {
                        fM2617getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m2617getScrollableTabRowPaddingD9Ej5fM();
                    } else {
                        fM2617getScrollableTabRowPaddingD9Ej5fM = f2;
                    }
                    if (i7 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-233732148, true, new Function3() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function5;
                    }
                    if (i9 != 0) {
                        function2M2376getLambda$222041980$material = ComposableSingletons$TabRowKt.INSTANCE.m2376getLambda$222041980$material();
                        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function11113 = composableLambdaRememberComposableLambda;
                        modifier3 = companion;
                        function8 = function11113;
                    } else {
                        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function11114 = composableLambdaRememberComposableLambda;
                        modifier3 = companion;
                        function8 = function11114;
                        function2M2376getLambda$222041980$material = function2;
                    }
                } else {
                    if (i12 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i3 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                        i4 &= -7169;
                    }
                    if (i5 != 0) {
                        fM2617getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m2617getScrollableTabRowPaddingD9Ej5fM();
                    } else {
                        fM2617getScrollableTabRowPaddingD9Ej5fM = f2;
                    }
                    if (i7 != 0) {
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-233732148, true, new Function3() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    } else {
                        composableLambdaRememberComposableLambda = function5;
                    }
                    if (i9 != 0) {
                        function2M2376getLambda$222041980$material = ComposableSingletons$TabRowKt.INSTANCE.m2376getLambda$222041980$material();
                        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function11115 = composableLambdaRememberComposableLambda;
                        modifier3 = companion;
                        function8 = function11115;
                    } else {
                        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function11116 = composableLambdaRememberComposableLambda;
                        modifier3 = companion;
                        function8 = function11116;
                        function2M2376getLambda$222041980$material = function2;
                    }
                }
                long j17 = primarySurface;
                long j18 = jM2360contentColorForek8zF_U;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1291546575, i4, -1, "androidx.compose.material.ScrollableTabRow (TabRow.kt:236)");
                }
                final Function3 function11117 = function8;
                final float f10 = fM2617getScrollableTabRowPaddingD9Ej5fM;
                final Function2 function11118 = function2M2376getLambda$222041980$material;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m2584SurfaceFjzlyU(modifier3, null, j17, j18, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(-1575164555, true, new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$1(f10, function4, function11118, function11117, i, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, ((i4 >> 3) & 14) | 1572864 | (i4 & 896) | (i4 & 7168), 50);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function6 = function11117;
                function7 = function11118;
                f3 = fM2617getScrollableTabRowPaddingD9Ej5fM;
                modifier2 = modifier3;
                j3 = j17;
                j4 = j18;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = modifier;
                j3 = primarySurface;
                j4 = jM2360contentColorForek8zF_U;
                f3 = f2;
                function6 = function5;
                function7 = function2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$2(i, modifier2, j3, j4, f3, function6, function7, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        function5 = function3;
        i9 = i3 & 64;
        if (i9 != 0) {
            i4 |= 1572864;
        } else if ((i2 & 1572864) == 0) {
            if (composerStartRestartGroup.changedInstance(function2)) {
                i10 = 1048576;
            } else {
                i10 = 524288;
            }
            i4 |= i10;
        }
        if ((i2 & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(function4)) {
                i11 = 8388608;
            } else {
                i11 = 4194304;
            }
            i4 |= i11;
        }
        if ((i4 & 4793491) != 4793490) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "227@11365L6,228@11414L32,231@11615L125");
            if ((i2 & 1) != 0) {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i3 & 4) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i4 &= -897;
                }
                if ((i3 & 8) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                    i4 &= -7169;
                }
                if (i5 != 0) {
                    fM2617getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m2617getScrollableTabRowPaddingD9Ej5fM();
                } else {
                    fM2617getScrollableTabRowPaddingD9Ej5fM = f2;
                }
                if (i7 != 0) {
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-233732148, true, new Function3() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                } else {
                    composableLambdaRememberComposableLambda = function5;
                }
                if (i9 != 0) {
                    function2M2376getLambda$222041980$material = ComposableSingletons$TabRowKt.INSTANCE.m2376getLambda$222041980$material();
                    Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function11119 = composableLambdaRememberComposableLambda;
                    modifier3 = companion;
                    function8 = function11119;
                } else {
                    Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function111110 = composableLambdaRememberComposableLambda;
                    modifier3 = companion;
                    function8 = function111110;
                    function2M2376getLambda$222041980$material = function2;
                }
            } else {
                if (i12 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i3 & 4) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i4 &= -897;
                }
                if ((i3 & 8) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i4 >> 6) & 14);
                    i4 &= -7169;
                }
                if (i5 != 0) {
                    fM2617getScrollableTabRowPaddingD9Ej5fM = TabRowDefaults.INSTANCE.m2617getScrollableTabRowPaddingD9Ej5fM();
                } else {
                    fM2617getScrollableTabRowPaddingD9Ej5fM = f2;
                }
                if (i7 != 0) {
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-233732148, true, new Function3() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$0(i, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                } else {
                    composableLambdaRememberComposableLambda = function5;
                }
                if (i9 != 0) {
                    function2M2376getLambda$222041980$material = ComposableSingletons$TabRowKt.INSTANCE.m2376getLambda$222041980$material();
                    Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function111111 = composableLambdaRememberComposableLambda;
                    modifier3 = companion;
                    function8 = function111111;
                } else {
                    Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function111112 = composableLambdaRememberComposableLambda;
                    modifier3 = companion;
                    function8 = function111112;
                    function2M2376getLambda$222041980$material = function2;
                }
            }
            long j19 = primarySurface;
            long j110 = jM2360contentColorForek8zF_U;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1291546575, i4, -1, "androidx.compose.material.ScrollableTabRow (TabRow.kt:236)");
            }
            final Function3 function111113 = function8;
            final float f11 = fM2617getScrollableTabRowPaddingD9Ej5fM;
            final Function2 function111114 = function2M2376getLambda$222041980$material;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m2584SurfaceFjzlyU(modifier3, null, j19, j110, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(-1575164555, true, new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$1(f11, function4, function111114, function111113, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, ((i4 >> 3) & 14) | 1572864 | (i4 & 896) | (i4 & 7168), 50);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function6 = function111113;
            function7 = function111114;
            f3 = fM2617getScrollableTabRowPaddingD9Ej5fM;
            modifier2 = modifier3;
            j3 = j19;
            j4 = j110;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier2 = modifier;
            j3 = primarySurface;
            j4 = jM2360contentColorForek8zF_U;
            f3 = f2;
            function6 = function5;
            function7 = function2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$2(i, modifier2, j3, j4, f3, function6, function7, function4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScrollableTabRow_sKfQg0A$lambda$1(final float f, final Function2 function2, final Function2 function3, final Function3 function4, final int i, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C238@12003L21,239@12054L24,241@12123L147,250@12521L2377,244@12279L2619:TabRow.kt#jmzs0o");
        if (!composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1575164555, i2, -1, "androidx.compose.material.ScrollableTabRow.<anonymous> (TabRow.kt:238)");
            }
            ScrollState scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composer, 0, 1);
            ComposerKt.sourceInformationMarkerStart(composer, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composer, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer);
                composer.updateRememberedValue(objRememberedValue);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1904644280, "CC(remember):TabRow.kt#9igjgp");
            boolean zChanged = composer.changed(scrollStateRememberScrollState) | composer.changed(coroutineScope);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new ScrollableTabData(scrollStateRememberScrollState, coroutineScope);
                composer.updateRememberedValue(objRememberedValue2);
            }
            final ScrollableTabData scrollableTabData = (ScrollableTabData) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierClipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getCenterStart(), false, 2, null), scrollStateRememberScrollState, false, null, false, 14, null)));
            ComposerKt.sourceInformationMarkerStart(composer, -1904629314, "CC(remember):TabRow.kt#9igjgp");
            boolean zChanged2 = composer.changed(f) | composer.changed(function2) | composer.changed(function3) | composer.changed(function4) | composer.changedInstance(scrollableTabData) | composer.changed(i);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                Object obj = new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$1$1$0(f, function2, function3, scrollableTabData, i, function4, (SubcomposeMeasureScope) obj2, (Constraints) obj3);
                    }
                };
                composer.updateRememberedValue(obj);
                objRememberedValue3 = obj;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SubcomposeLayoutKt.SubcomposeLayout(modifierClipToBounds, (Function2) objRememberedValue3, composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult ScrollableTabRow_sKfQg0A$lambda$1$1$0(float f, Function2 function2, final Function2 function3, final ScrollableTabData scrollableTabData, final int i, final Function3 function4, final SubcomposeMeasureScope subcomposeMeasureScope, final Constraints constraints) {
        int i2 = subcomposeMeasureScope.mo748roundToPx0680j_4(ScrollableTabRowMinimumTabWidth);
        final int i3 = subcomposeMeasureScope.mo748roundToPx0680j_4(f);
        long jM9630copyZbe2FdA$default = Constraints.m9630copyZbe2FdA$default(constraints.getValue(), i2, 0, 0, 0, 14, null);
        List<Measurable> listSubcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function2);
        ArrayList arrayList = new ArrayList(listSubcompose.size());
        int size = listSubcompose.size();
        for (int i4 = 0; i4 < size; i4++) {
            arrayList.add(listSubcompose.get(i4).mo8265measureBRTryo0(jM9630copyZbe2FdA$default));
        }
        final ArrayList arrayList2 = arrayList;
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = i3 * 2;
        final Ref.IntRef intRef2 = new Ref.IntRef();
        int size2 = arrayList2.size();
        for (int i5 = 0; i5 < size2; i5++) {
            Placeable placeable = (Placeable) arrayList2.get(i5);
            intRef.element += placeable.getWidth();
            intRef2.element = Math.max(intRef2.element, placeable.getHeight());
        }
        return MeasureScope.layout$default(subcomposeMeasureScope, intRef.element, intRef2.element, null, new Function1() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$1$1$0$2(i3, arrayList2, subcomposeMeasureScope, function3, scrollableTabData, i, constraints, intRef, intRef2, function4, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScrollableTabRow_sKfQg0A$lambda$1$1$0$2(int i, List list, SubcomposeMeasureScope subcomposeMeasureScope, Function2 function2, ScrollableTabData scrollableTabData, int i2, Constraints constraints, Ref.IntRef intRef, Ref.IntRef intRef2, final Function3 function3, Placeable.PlacementScope placementScope) {
        final ArrayList arrayList = new ArrayList();
        int size = list.size();
        int width = i;
        for (int i3 = 0; i3 < size; i3++) {
            Placeable placeable = (Placeable) list.get(i3);
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, width, 0, 0.0f, 4, null);
            arrayList.add(new TabPosition(subcomposeMeasureScope.mo751toDpu2uoSUM(width), subcomposeMeasureScope.mo751toDpu2uoSUM(placeable.getWidth()), null));
            width += placeable.getWidth();
        }
        List<Measurable> listSubcompose = subcomposeMeasureScope.subcompose(TabSlots.Divider, function2);
        int size2 = listSubcompose.size();
        for (int i4 = 0; i4 < size2; i4++) {
            Placeable placeableMo8265measureBRTryo0 = listSubcompose.get(i4).mo8265measureBRTryo0(Constraints.m9630copyZbe2FdA$default(constraints.getValue(), intRef.element, intRef.element, 0, 0, 8, null));
            Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo8265measureBRTryo0, 0, intRef2.element - placeableMo8265measureBRTryo0.getHeight(), 0.0f, 4, null);
        }
        List<Measurable> listSubcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Indicator, ComposableLambdaKt.composableLambdaInstance(-43203918, true, new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return TabRowKt.ScrollableTabRow_sKfQg0A$lambda$1$1$0$2$2(function3, arrayList, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
        int size3 = listSubcompose2.size();
        for (int i5 = 0; i5 < size3; i5++) {
            Placeable.PlacementScope.placeRelative$default(placementScope, listSubcompose2.get(i5).mo8265measureBRTryo0(Constraints.INSTANCE.m9650fixedJhjzzOo(intRef.element, intRef2.element)), 0, 0, 0.0f, 4, null);
        }
        scrollableTabData.onLaidOut(subcomposeMeasureScope, i, arrayList, i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScrollableTabRow_sKfQg0A$lambda$1$1$0$2$2(Function3 function3, List list, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C292@14431L23:TabRow.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-43203918, i, -1, "androidx.compose.material.ScrollableTabRow.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:292)");
            }
            function3.invoke(list, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TabRow_pAZo6Ak$lambda$1$0$0$3(List list, SubcomposeMeasureScope subcomposeMeasureScope, Function2 function2, int i, Constraints constraints, int i2, final Function3 function3, final List list2, int i3, Placeable.PlacementScope placementScope) {
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) list.get(i4), i4 * i, 0, 0.0f, 4, null);
        }
        List<Measurable> listSubcompose = subcomposeMeasureScope.subcompose(TabSlots.Divider, function2);
        int size2 = listSubcompose.size();
        for (int i5 = 0; i5 < size2; i5++) {
            Placeable placeableMo8265measureBRTryo0 = listSubcompose.get(i5).mo8265measureBRTryo0(Constraints.m9630copyZbe2FdA$default(constraints.getValue(), 0, 0, 0, 0, 11, null));
            Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo8265measureBRTryo0, 0, i2 - placeableMo8265measureBRTryo0.getHeight(), 0.0f, 4, null);
        }
        List<Measurable> listSubcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Indicator, ComposableLambdaKt.composableLambdaInstance(-220665376, true, new Function2() { // from class: androidx.compose.material.TabRowKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return TabRowKt.TabRow_pAZo6Ak$lambda$1$0$0$3$2(function3, list2, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
        int size3 = listSubcompose2.size();
        for (int i6 = 0; i6 < size3; i6++) {
            Placeable.PlacementScope.placeRelative$default(placementScope, listSubcompose2.get(i6).mo8265measureBRTryo0(Constraints.INSTANCE.m9650fixedJhjzzOo(i3, i2)), 0, 0, 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }
}
