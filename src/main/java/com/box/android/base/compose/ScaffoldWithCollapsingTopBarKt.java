package com.box.android.base.compose;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.material3.ScaffoldDefaults;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.material3.TopAppBarState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.media3.common.C;
import androidx.media3.extractor.ts.TsExtractor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ScaffoldWithCollapsingTopBar.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ab\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\b\u001a\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0004H\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"ScaffoldWithCollapsingTopBar", "", "topBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "floatingActionButton", "contentWindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/PaddingValues;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ScaffoldWithCollapsingTopBarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScaffoldWithCollapsingTopBar$lambda$3(Function2 function2, Modifier modifier, Function2 function3, WindowInsets windowInsets, Function3 function4, int i, int i2, Composer composer, int i3) {
        ScaffoldWithCollapsingTopBar(function2, modifier, function3, windowInsets, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0050  */
    /* JADX WARN: Code duplicated, block: B:24:0x0053  */
    /* JADX WARN: Code duplicated, block: B:26:0x0057  */
    /* JADX WARN: Code duplicated, block: B:28:0x005f  */
    /* JADX WARN: Code duplicated, block: B:29:0x0062  */
    /* JADX WARN: Code duplicated, block: B:34:0x006c  */
    /* JADX WARN: Code duplicated, block: B:36:0x0070  */
    /* JADX WARN: Code duplicated, block: B:38:0x0078  */
    /* JADX WARN: Code duplicated, block: B:39:0x007b  */
    /* JADX WARN: Code duplicated, block: B:42:0x0081  */
    /* JADX WARN: Code duplicated, block: B:45:0x0087  */
    /* JADX WARN: Code duplicated, block: B:47:0x008d  */
    /* JADX WARN: Code duplicated, block: B:48:0x0090  */
    /* JADX WARN: Code duplicated, block: B:52:0x009a  */
    /* JADX WARN: Code duplicated, block: B:53:0x009c  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:58:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:67:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:70:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:74:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:75:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:78:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:81:0x014d  */
    /* JADX WARN: Code duplicated, block: B:83:0x0155  */
    /* JADX WARN: Code duplicated, block: B:86:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:88:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:91:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:93:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void ScaffoldWithCollapsingTopBar(final Function2<? super Composer, ? super Integer, Unit> topBar, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, WindowInsets windowInsets, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function3;
        int i5;
        WindowInsets windowInsets2;
        boolean z;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function4;
        final WindowInsets windowInsets3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Function2<? super Composer, ? super Integer, Unit> lambda$934188961$base_generalProdRelease;
        Modifier modifier4;
        Function2<? super Composer, ? super Integer, Unit> function5;
        WindowInsets contentWindowInsets;
        final TopAppBarScrollBehavior topAppBarScrollBehaviorEnterAlwaysScrollBehavior;
        float fMo754toPx0680j_4;
        boolean zChanged;
        ScaffoldWithCollapsingTopBarKt$ScaffoldWithCollapsingTopBar$1$1 scaffoldWithCollapsingTopBarKt$ScaffoldWithCollapsingTopBar$1$1RememberedValue;
        int i6;
        Intrinsics.checkNotNullParameter(topBar, "topBar");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1487421787);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ScaffoldWithCollapsingTopBar)N(topBar,modifier,floatingActionButton,contentWindowInsets,content)40@1799L27,41@1870L7,43@1938L72,43@1917L93,72@3102L6,48@2043L888,47@2016L1271:ScaffoldWithCollapsingTopBar.kt#vejmn0");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(topBar) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    function3 = function2;
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        windowInsets2 = windowInsets;
                        int i8 = composerStartRestartGroup.changed(windowInsets2) ? 2048 : 1024;
                        i3 |= i8;
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    i3 |= i8;
                } else {
                    windowInsets2 = windowInsets;
                }
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changedInstance(content)) {
                        i6 = 16384;
                    } else {
                        i6 = 8192;
                    }
                    i3 |= i6;
                }
                if ((i3 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "37@1682L19");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i7 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            lambda$934188961$base_generalProdRelease = ComposableSingletons$ScaffoldWithCollapsingTopBarKt.INSTANCE.getLambda$934188961$base_generalProdRelease();
                        } else {
                            lambda$934188961$base_generalProdRelease = function3;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            modifier4 = companion;
                            function5 = lambda$934188961$base_generalProdRelease;
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, ScaffoldDefaults.$stable);
                        } else {
                            modifier4 = companion;
                            function5 = lambda$934188961$base_generalProdRelease;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1487421787, i3, -1, "com.box.android.base.compose.ScaffoldWithCollapsingTopBar (ScaffoldWithCollapsingTopBar.kt:39)");
                        }
                        int i9 = i3;
                        topAppBarScrollBehaviorEnterAlwaysScrollBehavior = TopAppBarDefaults.INSTANCE.enterAlwaysScrollBehavior((TopAppBarState) null, (Function0<Boolean>) null, (AnimationSpec<Float>) null, (DecayAnimationSpec<Float>) null, false, composerStartRestartGroup, TopAppBarDefaults.$stable << 15, 31);
                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume = composerStartRestartGroup.consume(localDensity);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        fMo754toPx0680j_4 = ((Density) objConsume).mo754toPx0680j_4(BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM());
                        Unit unit = Unit.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 811787469, "CC(remember):ScaffoldWithCollapsingTopBar.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(topAppBarScrollBehaviorEnterAlwaysScrollBehavior) | composerStartRestartGroup.changed(fMo754toPx0680j_4);
                        scaffoldWithCollapsingTopBarKt$ScaffoldWithCollapsingTopBar$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged || scaffoldWithCollapsingTopBarKt$ScaffoldWithCollapsingTopBar$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            scaffoldWithCollapsingTopBarKt$ScaffoldWithCollapsingTopBar$1$1RememberedValue = new ScaffoldWithCollapsingTopBarKt$ScaffoldWithCollapsingTopBar$1$1(topAppBarScrollBehaviorEnterAlwaysScrollBehavior, fMo754toPx0680j_4, null);
                            composerStartRestartGroup.updateRememberedValue(scaffoldWithCollapsingTopBarKt$ScaffoldWithCollapsingTopBar$1$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) scaffoldWithCollapsingTopBarKt$ScaffoldWithCollapsingTopBar$1$1RememberedValue, composerStartRestartGroup, 6);
                        long jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                        Modifier modifierNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(modifier4, topAppBarScrollBehaviorEnterAlwaysScrollBehavior.getNestedScrollConnection(), null, 2, null);
                        ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-700779159, true, new Function2() { // from class: com.box.android.base.compose.ScaffoldWithCollapsingTopBarKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ScaffoldWithCollapsingTopBarKt.ScaffoldWithCollapsingTopBar$lambda$2(topAppBarScrollBehaviorEnterAlwaysScrollBehavior, topBar, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        int i10 = ((i9 << 6) & 57344) | 48;
                        int i11 = i9 << 15;
                        int i12 = (i11 & C.ENCODING_PCM_DOUBLE) | i10 | (234881024 & i11);
                        Modifier modifier5 = modifier4;
                        Function2<? super Composer, ? super Integer, Unit> function6 = function5;
                        WindowInsets windowInsets4 = contentWindowInsets;
                        ScaffoldKt.m4038ScaffoldTvnljyQ(modifierNestedScroll$default, composableLambdaRememberComposableLambda, null, null, function6, 0, jM11498getAppBackground0d7_KjU, 0L, windowInsets4, content, composerStartRestartGroup, i12, TsExtractor.TS_STREAM_TYPE_AC4);
                        composerStartRestartGroup = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function4 = function6;
                        windowInsets3 = windowInsets4;
                        modifier3 = modifier5;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        modifier4 = modifier2;
                        function5 = function3;
                    }
                    contentWindowInsets = windowInsets2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1487421787, i3, -1, "com.box.android.base.compose.ScaffoldWithCollapsingTopBar (ScaffoldWithCollapsingTopBar.kt:39)");
                    }
                    int i13 = i3;
                    topAppBarScrollBehaviorEnterAlwaysScrollBehavior = TopAppBarDefaults.INSTANCE.enterAlwaysScrollBehavior((TopAppBarState) null, (Function0<Boolean>) null, (AnimationSpec<Float>) null, (DecayAnimationSpec<Float>) null, false, composerStartRestartGroup, TopAppBarDefaults.$stable << 15, 31);
                    ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(localDensity2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    fMo754toPx0680j_4 = ((Density) objConsume2).mo754toPx0680j_4(BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM());
                    Unit unit2 = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 811787469, "CC(remember):ScaffoldWithCollapsingTopBar.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(topAppBarScrollBehaviorEnterAlwaysScrollBehavior) | composerStartRestartGroup.changed(fMo754toPx0680j_4);
                    scaffoldWithCollapsingTopBarKt$ScaffoldWithCollapsingTopBar$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        scaffoldWithCollapsingTopBarKt$ScaffoldWithCollapsingTopBar$1$1RememberedValue = new ScaffoldWithCollapsingTopBarKt$ScaffoldWithCollapsingTopBar$1$1(topAppBarScrollBehaviorEnterAlwaysScrollBehavior, fMo754toPx0680j_4, null);
                        composerStartRestartGroup.updateRememberedValue(scaffoldWithCollapsingTopBarKt$ScaffoldWithCollapsingTopBar$1$1RememberedValue);
                    } else {
                        scaffoldWithCollapsingTopBarKt$ScaffoldWithCollapsingTopBar$1$1RememberedValue = new ScaffoldWithCollapsingTopBarKt$ScaffoldWithCollapsingTopBar$1$1(topAppBarScrollBehaviorEnterAlwaysScrollBehavior, fMo754toPx0680j_4, null);
                        composerStartRestartGroup.updateRememberedValue(scaffoldWithCollapsingTopBarKt$ScaffoldWithCollapsingTopBar$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(unit2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) scaffoldWithCollapsingTopBarKt$ScaffoldWithCollapsingTopBar$1$1RememberedValue, composerStartRestartGroup, 6);
                    long jM11498getAppBackground0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                    Modifier modifierNestedScroll$default2 = NestedScrollModifierKt.nestedScroll$default(modifier4, topAppBarScrollBehaviorEnterAlwaysScrollBehavior.getNestedScrollConnection(), null, 2, null);
                    ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-700779159, true, new Function2() { // from class: com.box.android.base.compose.ScaffoldWithCollapsingTopBarKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ScaffoldWithCollapsingTopBarKt.ScaffoldWithCollapsingTopBar$lambda$2(topAppBarScrollBehaviorEnterAlwaysScrollBehavior, topBar, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    int i14 = ((i13 << 6) & 57344) | 48;
                    int i15 = i13 << 15;
                    int i16 = (i15 & C.ENCODING_PCM_DOUBLE) | i14 | (234881024 & i15);
                    Modifier modifier6 = modifier4;
                    Function2<? super Composer, ? super Integer, Unit> function7 = function5;
                    WindowInsets windowInsets5 = contentWindowInsets;
                    ScaffoldKt.m4038ScaffoldTvnljyQ(modifierNestedScroll$default2, composableLambdaRememberComposableLambda2, null, null, function7, 0, jM11498getAppBackground0d7_KjU2, 0L, windowInsets5, content, composerStartRestartGroup, i16, TsExtractor.TS_STREAM_TYPE_AC4);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function4 = function7;
                    windowInsets3 = windowInsets5;
                    modifier3 = modifier6;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    function4 = function3;
                    windowInsets3 = windowInsets2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.ScaffoldWithCollapsingTopBarKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ScaffoldWithCollapsingTopBarKt.ScaffoldWithCollapsingTopBar$lambda$3(topBar, modifier3, function4, windowInsets3, content, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            function3 = function2;
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    windowInsets2 = windowInsets;
                    if (composerStartRestartGroup.changed(windowInsets2)) {
                    }
                    i3 |= i8;
                } else {
                    windowInsets2 = windowInsets;
                }
                i3 |= i8;
            } else {
                windowInsets2 = windowInsets;
            }
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(content)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i3 |= i6;
            }
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "37@1682L19");
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        lambda$934188961$base_generalProdRelease = ComposableSingletons$ScaffoldWithCollapsingTopBarKt.INSTANCE.getLambda$934188961$base_generalProdRelease();
                    } else {
                        lambda$934188961$base_generalProdRelease = function3;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        modifier4 = companion;
                        function5 = lambda$934188961$base_generalProdRelease;
                        contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, ScaffoldDefaults.$stable);
                    } else {
                        modifier4 = companion;
                        function5 = lambda$934188961$base_generalProdRelease;
                        contentWindowInsets = windowInsets2;
                    }
                } else {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        lambda$934188961$base_generalProdRelease = ComposableSingletons$ScaffoldWithCollapsingTopBarKt.INSTANCE.getLambda$934188961$base_generalProdRelease();
                    } else {
                        lambda$934188961$base_generalProdRelease = function3;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        modifier4 = companion;
                        function5 = lambda$934188961$base_generalProdRelease;
                        contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, ScaffoldDefaults.$stable);
                    } else {
                        modifier4 = companion;
                        function5 = lambda$934188961$base_generalProdRelease;
                        contentWindowInsets = windowInsets2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1487421787, i3, -1, "com.box.android.base.compose.ScaffoldWithCollapsingTopBar (ScaffoldWithCollapsingTopBar.kt:39)");
                }
                int i17 = i3;
                topAppBarScrollBehaviorEnterAlwaysScrollBehavior = TopAppBarDefaults.INSTANCE.enterAlwaysScrollBehavior((TopAppBarState) null, (Function0<Boolean>) null, (AnimationSpec<Float>) null, (DecayAnimationSpec<Float>) null, false, composerStartRestartGroup, TopAppBarDefaults.$stable << 15, 31);
                ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume3 = composerStartRestartGroup.consume(localDensity3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                fMo754toPx0680j_4 = ((Density) objConsume3).mo754toPx0680j_4(BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM());
                Unit unit3 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 811787469, "CC(remember):ScaffoldWithCollapsingTopBar.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(topAppBarScrollBehaviorEnterAlwaysScrollBehavior) | composerStartRestartGroup.changed(fMo754toPx0680j_4);
                scaffoldWithCollapsingTopBarKt$ScaffoldWithCollapsingTopBar$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    scaffoldWithCollapsingTopBarKt$ScaffoldWithCollapsingTopBar$1$1RememberedValue = new ScaffoldWithCollapsingTopBarKt$ScaffoldWithCollapsingTopBar$1$1(topAppBarScrollBehaviorEnterAlwaysScrollBehavior, fMo754toPx0680j_4, null);
                    composerStartRestartGroup.updateRememberedValue(scaffoldWithCollapsingTopBarKt$ScaffoldWithCollapsingTopBar$1$1RememberedValue);
                } else {
                    scaffoldWithCollapsingTopBarKt$ScaffoldWithCollapsingTopBar$1$1RememberedValue = new ScaffoldWithCollapsingTopBarKt$ScaffoldWithCollapsingTopBar$1$1(topAppBarScrollBehaviorEnterAlwaysScrollBehavior, fMo754toPx0680j_4, null);
                    composerStartRestartGroup.updateRememberedValue(scaffoldWithCollapsingTopBarKt$ScaffoldWithCollapsingTopBar$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(unit3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) scaffoldWithCollapsingTopBarKt$ScaffoldWithCollapsingTopBar$1$1RememberedValue, composerStartRestartGroup, 6);
                long jM11498getAppBackground0d7_KjU3 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                Modifier modifierNestedScroll$default3 = NestedScrollModifierKt.nestedScroll$default(modifier4, topAppBarScrollBehaviorEnterAlwaysScrollBehavior.getNestedScrollConnection(), null, 2, null);
                ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-700779159, true, new Function2() { // from class: com.box.android.base.compose.ScaffoldWithCollapsingTopBarKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ScaffoldWithCollapsingTopBarKt.ScaffoldWithCollapsingTopBar$lambda$2(topAppBarScrollBehaviorEnterAlwaysScrollBehavior, topBar, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                int i18 = ((i17 << 6) & 57344) | 48;
                int i19 = i17 << 15;
                int i110 = (i19 & C.ENCODING_PCM_DOUBLE) | i18 | (234881024 & i19);
                Modifier modifier7 = modifier4;
                Function2<? super Composer, ? super Integer, Unit> function8 = function5;
                WindowInsets windowInsets6 = contentWindowInsets;
                ScaffoldKt.m4038ScaffoldTvnljyQ(modifierNestedScroll$default3, composableLambdaRememberComposableLambda3, null, null, function8, 0, jM11498getAppBackground0d7_KjU3, 0L, windowInsets6, content, composerStartRestartGroup, i110, TsExtractor.TS_STREAM_TYPE_AC4);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function4 = function8;
                windowInsets3 = windowInsets6;
                modifier3 = modifier7;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                function4 = function3;
                windowInsets3 = windowInsets2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.ScaffoldWithCollapsingTopBarKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ScaffoldWithCollapsingTopBarKt.ScaffoldWithCollapsingTopBar$lambda$3(topBar, modifier3, function4, windowInsets3, content, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                function3 = function2;
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    windowInsets2 = windowInsets;
                    if (composerStartRestartGroup.changed(windowInsets2)) {
                    }
                    i3 |= i8;
                } else {
                    windowInsets2 = windowInsets;
                }
                i3 |= i8;
            } else {
                windowInsets2 = windowInsets;
            }
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(content)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i3 |= i6;
            }
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "37@1682L19");
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        lambda$934188961$base_generalProdRelease = ComposableSingletons$ScaffoldWithCollapsingTopBarKt.INSTANCE.getLambda$934188961$base_generalProdRelease();
                    } else {
                        lambda$934188961$base_generalProdRelease = function3;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        modifier4 = companion;
                        function5 = lambda$934188961$base_generalProdRelease;
                        contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, ScaffoldDefaults.$stable);
                    } else {
                        modifier4 = companion;
                        function5 = lambda$934188961$base_generalProdRelease;
                        contentWindowInsets = windowInsets2;
                    }
                } else {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        lambda$934188961$base_generalProdRelease = ComposableSingletons$ScaffoldWithCollapsingTopBarKt.INSTANCE.getLambda$934188961$base_generalProdRelease();
                    } else {
                        lambda$934188961$base_generalProdRelease = function3;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        modifier4 = companion;
                        function5 = lambda$934188961$base_generalProdRelease;
                        contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, ScaffoldDefaults.$stable);
                    } else {
                        modifier4 = companion;
                        function5 = lambda$934188961$base_generalProdRelease;
                        contentWindowInsets = windowInsets2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1487421787, i3, -1, "com.box.android.base.compose.ScaffoldWithCollapsingTopBar (ScaffoldWithCollapsingTopBar.kt:39)");
                }
                int i111 = i3;
                topAppBarScrollBehaviorEnterAlwaysScrollBehavior = TopAppBarDefaults.INSTANCE.enterAlwaysScrollBehavior((TopAppBarState) null, (Function0<Boolean>) null, (AnimationSpec<Float>) null, (DecayAnimationSpec<Float>) null, false, composerStartRestartGroup, TopAppBarDefaults.$stable << 15, 31);
                ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume4 = composerStartRestartGroup.consume(localDensity4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                fMo754toPx0680j_4 = ((Density) objConsume4).mo754toPx0680j_4(BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM());
                Unit unit4 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 811787469, "CC(remember):ScaffoldWithCollapsingTopBar.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(topAppBarScrollBehaviorEnterAlwaysScrollBehavior) | composerStartRestartGroup.changed(fMo754toPx0680j_4);
                scaffoldWithCollapsingTopBarKt$ScaffoldWithCollapsingTopBar$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    scaffoldWithCollapsingTopBarKt$ScaffoldWithCollapsingTopBar$1$1RememberedValue = new ScaffoldWithCollapsingTopBarKt$ScaffoldWithCollapsingTopBar$1$1(topAppBarScrollBehaviorEnterAlwaysScrollBehavior, fMo754toPx0680j_4, null);
                    composerStartRestartGroup.updateRememberedValue(scaffoldWithCollapsingTopBarKt$ScaffoldWithCollapsingTopBar$1$1RememberedValue);
                } else {
                    scaffoldWithCollapsingTopBarKt$ScaffoldWithCollapsingTopBar$1$1RememberedValue = new ScaffoldWithCollapsingTopBarKt$ScaffoldWithCollapsingTopBar$1$1(topAppBarScrollBehaviorEnterAlwaysScrollBehavior, fMo754toPx0680j_4, null);
                    composerStartRestartGroup.updateRememberedValue(scaffoldWithCollapsingTopBarKt$ScaffoldWithCollapsingTopBar$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(unit4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) scaffoldWithCollapsingTopBarKt$ScaffoldWithCollapsingTopBar$1$1RememberedValue, composerStartRestartGroup, 6);
                long jM11498getAppBackground0d7_KjU4 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                Modifier modifierNestedScroll$default4 = NestedScrollModifierKt.nestedScroll$default(modifier4, topAppBarScrollBehaviorEnterAlwaysScrollBehavior.getNestedScrollConnection(), null, 2, null);
                ComposableLambda composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(-700779159, true, new Function2() { // from class: com.box.android.base.compose.ScaffoldWithCollapsingTopBarKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ScaffoldWithCollapsingTopBarKt.ScaffoldWithCollapsingTopBar$lambda$2(topAppBarScrollBehaviorEnterAlwaysScrollBehavior, topBar, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                int i112 = ((i111 << 6) & 57344) | 48;
                int i113 = i111 << 15;
                int i114 = (i113 & C.ENCODING_PCM_DOUBLE) | i112 | (234881024 & i113);
                Modifier modifier8 = modifier4;
                Function2<? super Composer, ? super Integer, Unit> function9 = function5;
                WindowInsets windowInsets7 = contentWindowInsets;
                ScaffoldKt.m4038ScaffoldTvnljyQ(modifierNestedScroll$default4, composableLambdaRememberComposableLambda4, null, null, function9, 0, jM11498getAppBackground0d7_KjU4, 0L, windowInsets7, content, composerStartRestartGroup, i114, TsExtractor.TS_STREAM_TYPE_AC4);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function4 = function9;
                windowInsets3 = windowInsets7;
                modifier3 = modifier8;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                function4 = function3;
                windowInsets3 = windowInsets2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.ScaffoldWithCollapsingTopBarKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ScaffoldWithCollapsingTopBarKt.ScaffoldWithCollapsingTopBar$lambda$3(topBar, modifier3, function4, windowInsets3, content, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        function3 = function2;
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                windowInsets2 = windowInsets;
                if (composerStartRestartGroup.changed(windowInsets2)) {
                }
                i3 |= i8;
            } else {
                windowInsets2 = windowInsets;
            }
            i3 |= i8;
        } else {
            windowInsets2 = windowInsets;
        }
        if ((i & 24576) == 0) {
            if (composerStartRestartGroup.changedInstance(content)) {
                i6 = 16384;
            } else {
                i6 = 8192;
            }
            i3 |= i6;
        }
        if ((i3 & 9363) != 9362) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "37@1682L19");
            if ((i & 1) != 0) {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    lambda$934188961$base_generalProdRelease = ComposableSingletons$ScaffoldWithCollapsingTopBarKt.INSTANCE.getLambda$934188961$base_generalProdRelease();
                } else {
                    lambda$934188961$base_generalProdRelease = function3;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    modifier4 = companion;
                    function5 = lambda$934188961$base_generalProdRelease;
                    contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, ScaffoldDefaults.$stable);
                } else {
                    modifier4 = companion;
                    function5 = lambda$934188961$base_generalProdRelease;
                    contentWindowInsets = windowInsets2;
                }
            } else {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    lambda$934188961$base_generalProdRelease = ComposableSingletons$ScaffoldWithCollapsingTopBarKt.INSTANCE.getLambda$934188961$base_generalProdRelease();
                } else {
                    lambda$934188961$base_generalProdRelease = function3;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    modifier4 = companion;
                    function5 = lambda$934188961$base_generalProdRelease;
                    contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, ScaffoldDefaults.$stable);
                } else {
                    modifier4 = companion;
                    function5 = lambda$934188961$base_generalProdRelease;
                    contentWindowInsets = windowInsets2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1487421787, i3, -1, "com.box.android.base.compose.ScaffoldWithCollapsingTopBar (ScaffoldWithCollapsingTopBar.kt:39)");
            }
            int i115 = i3;
            topAppBarScrollBehaviorEnterAlwaysScrollBehavior = TopAppBarDefaults.INSTANCE.enterAlwaysScrollBehavior((TopAppBarState) null, (Function0<Boolean>) null, (AnimationSpec<Float>) null, (DecayAnimationSpec<Float>) null, false, composerStartRestartGroup, TopAppBarDefaults.$stable << 15, 31);
            ProvidableCompositionLocal<Density> localDensity5 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume5 = composerStartRestartGroup.consume(localDensity5);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            fMo754toPx0680j_4 = ((Density) objConsume5).mo754toPx0680j_4(BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM());
            Unit unit5 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 811787469, "CC(remember):ScaffoldWithCollapsingTopBar.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(topAppBarScrollBehaviorEnterAlwaysScrollBehavior) | composerStartRestartGroup.changed(fMo754toPx0680j_4);
            scaffoldWithCollapsingTopBarKt$ScaffoldWithCollapsingTopBar$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                scaffoldWithCollapsingTopBarKt$ScaffoldWithCollapsingTopBar$1$1RememberedValue = new ScaffoldWithCollapsingTopBarKt$ScaffoldWithCollapsingTopBar$1$1(topAppBarScrollBehaviorEnterAlwaysScrollBehavior, fMo754toPx0680j_4, null);
                composerStartRestartGroup.updateRememberedValue(scaffoldWithCollapsingTopBarKt$ScaffoldWithCollapsingTopBar$1$1RememberedValue);
            } else {
                scaffoldWithCollapsingTopBarKt$ScaffoldWithCollapsingTopBar$1$1RememberedValue = new ScaffoldWithCollapsingTopBarKt$ScaffoldWithCollapsingTopBar$1$1(topAppBarScrollBehaviorEnterAlwaysScrollBehavior, fMo754toPx0680j_4, null);
                composerStartRestartGroup.updateRememberedValue(scaffoldWithCollapsingTopBarKt$ScaffoldWithCollapsingTopBar$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(unit5, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) scaffoldWithCollapsingTopBarKt$ScaffoldWithCollapsingTopBar$1$1RememberedValue, composerStartRestartGroup, 6);
            long jM11498getAppBackground0d7_KjU5 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
            Modifier modifierNestedScroll$default5 = NestedScrollModifierKt.nestedScroll$default(modifier4, topAppBarScrollBehaviorEnterAlwaysScrollBehavior.getNestedScrollConnection(), null, 2, null);
            ComposableLambda composableLambdaRememberComposableLambda5 = ComposableLambdaKt.rememberComposableLambda(-700779159, true, new Function2() { // from class: com.box.android.base.compose.ScaffoldWithCollapsingTopBarKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ScaffoldWithCollapsingTopBarKt.ScaffoldWithCollapsingTopBar$lambda$2(topAppBarScrollBehaviorEnterAlwaysScrollBehavior, topBar, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            int i116 = ((i115 << 6) & 57344) | 48;
            int i117 = i115 << 15;
            int i118 = (i117 & C.ENCODING_PCM_DOUBLE) | i116 | (234881024 & i117);
            Modifier modifier9 = modifier4;
            Function2<? super Composer, ? super Integer, Unit> function10 = function5;
            WindowInsets windowInsets8 = contentWindowInsets;
            ScaffoldKt.m4038ScaffoldTvnljyQ(modifierNestedScroll$default5, composableLambdaRememberComposableLambda5, null, null, function10, 0, jM11498getAppBackground0d7_KjU5, 0L, windowInsets8, content, composerStartRestartGroup, i118, TsExtractor.TS_STREAM_TYPE_AC4);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function4 = function10;
            windowInsets3 = windowInsets8;
            modifier3 = modifier9;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            function4 = function3;
            windowInsets3 = windowInsets2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.ScaffoldWithCollapsingTopBarKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ScaffoldWithCollapsingTopBarKt.ScaffoldWithCollapsingTopBar$lambda$3(topBar, modifier3, function4, windowInsets3, content, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScaffoldWithCollapsingTopBar$lambda$2(final TopAppBarScrollBehavior topAppBarScrollBehavior, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C51@2139L6,49@2057L864:ScaffoldWithCollapsingTopBar.kt#vejmn0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-700779159, i, -1, "com.box.android.base.compose.ScaffoldWithCollapsingTopBar.<anonymous> (ScaffoldWithCollapsingTopBar.kt:49)");
            }
            Modifier modifierStatusBarsPadding = WindowInsetsPadding_androidKt.statusBarsPadding(BackgroundKt.m589backgroundbw27NRU$default(Modifier.INSTANCE, BoxTheme.INSTANCE.getColors(composer, 6).m11498getAppBackground0d7_KjU(), null, 2, null));
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierStatusBarsPadding);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1712721139, "C57@2351L489,54@2234L673:ScaffoldWithCollapsingTopBar.kt#vejmn0");
            Modifier modifierClipToBounds = ClipKt.clipToBounds(Modifier.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composer, -914578696, "CC(remember):ScaffoldWithCollapsingTopBar.kt#9igjgp");
            boolean zChanged = composer.changed(topAppBarScrollBehavior);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function3() { // from class: com.box.android.base.compose.ScaffoldWithCollapsingTopBarKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ScaffoldWithCollapsingTopBarKt.ScaffoldWithCollapsingTopBar$lambda$2$0$0$0(topAppBarScrollBehavior, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierLayout = LayoutModifierKt.layout(modifierClipToBounds, (Function3) objRememberedValue);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierLayout);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1959011878, "C66@2881L8:ScaffoldWithCollapsingTopBar.kt#vejmn0");
            function2.invoke(composer, 0);
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
    public static final MeasureResult ScaffoldWithCollapsingTopBar$lambda$2$0$0$0(TopAppBarScrollBehavior topAppBarScrollBehavior, MeasureScope layout, Measurable measurable, Constraints constraints) {
        Intrinsics.checkNotNullParameter(layout, "$this$layout");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        final Placeable placeableMo8265measureBRTryo0 = measurable.mo8265measureBRTryo0(constraints.getValue());
        final int iRoundToInt = MathKt.roundToInt(topAppBarScrollBehavior.getState().getHeightOffset());
        return MeasureScope.layout$default(layout, placeableMo8265measureBRTryo0.getWidth(), RangesKt.coerceAtLeast(placeableMo8265measureBRTryo0.getHeight() + iRoundToInt, 0), null, new Function1() { // from class: com.box.android.base.compose.ScaffoldWithCollapsingTopBarKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ScaffoldWithCollapsingTopBarKt.ScaffoldWithCollapsingTopBar$lambda$2$0$0$0$0(placeableMo8265measureBRTryo0, iRoundToInt, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScaffoldWithCollapsingTopBar$lambda$2$0$0$0$0(Placeable placeable, int i, Placeable.PlacementScope layout) {
        Intrinsics.checkNotNullParameter(layout, "$this$layout");
        Placeable.PlacementScope.place$default(layout, placeable, 0, i, 0.0f, 4, null);
        return Unit.INSTANCE;
    }
}
