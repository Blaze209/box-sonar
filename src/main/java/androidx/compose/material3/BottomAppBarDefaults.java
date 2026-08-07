package androidx.compose.material3;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.material3.internal.SystemBarsDefaultInsets_androidKt;
import androidx.compose.material3.tokens.BottomAppBarTokens;
import androidx.compose.material3.tokens.DockedToolbarTokens;
import androidx.compose.material3.tokens.FabSecondaryContainerTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AppBar.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JK\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010-2\u0010\b\u0002\u0010/\u001a\n\u0012\u0004\u0012\u00020.\u0018\u000100H\u0007¢\u0006\u0002\u00101R\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0007R\u001c\u0010\u0017\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0003\u001a\u0004\b\u0019\u0010\u0010R\u001e\u0010\u001a\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\f\u0012\u0004\b\u001b\u0010\u0003\u001a\u0004\b\u001c\u0010\u000bR\u001c\u0010\u001d\u001a\u00020\u001e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0003\u001a\u0004\b \u0010!R\u001c\u0010\"\u001a\u00020\u001e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0003\u001a\u0004\b$\u0010!¨\u00062"}, d2 = {"Landroidx/compose/material3/BottomAppBarDefaults;", "", "<init>", "()V", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "ContainerElevation", "Landroidx/compose/ui/unit/Dp;", "getContainerElevation-D9Ej5fM", "()F", "F", "ContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "bottomAppBarFabColor", "getBottomAppBarFabColor", "FlexibleContentPadding", "getFlexibleContentPadding$annotations", "getFlexibleContentPadding", "FlexibleBottomAppBarHeight", "getFlexibleBottomAppBarHeight-D9Ej5fM$annotations", "getFlexibleBottomAppBarHeight-D9Ej5fM", "FlexibleHorizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getFlexibleHorizontalArrangement$annotations", "getFlexibleHorizontalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "FlexibleFixedHorizontalArrangement", "getFlexibleFixedHorizontalArrangement$annotations", "getFlexibleFixedHorizontalArrangement", "exitAlwaysScrollBehavior", "Landroidx/compose/material3/BottomAppBarScrollBehavior;", "state", "Landroidx/compose/material3/BottomAppBarState;", "canScroll", "Lkotlin/Function0;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "(Landroidx/compose/material3/BottomAppBarState;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/BottomAppBarScrollBehavior;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BottomAppBarDefaults {
    public static final int $stable = 0;
    public static final BottomAppBarDefaults INSTANCE = new BottomAppBarDefaults();
    private static final float ContainerElevation = Dp.m9687constructorimpl(0);
    private static final PaddingValues ContentPadding = PaddingKt.m1215PaddingValuesa9UjIt4$default(AppBarKt.BottomAppBarHorizontalPadding, AppBarKt.getBottomAppBarVerticalPadding(), AppBarKt.BottomAppBarHorizontalPadding, 0.0f, 8, null);
    private static final PaddingValues FlexibleContentPadding = PaddingKt.m1215PaddingValuesa9UjIt4$default(DockedToolbarTokens.INSTANCE.m5337getContainerLeadingSpaceD9Ej5fM(), 0.0f, DockedToolbarTokens.INSTANCE.m5340getContainerTrailingSpaceD9Ej5fM(), 0.0f, 10, null);
    private static final float FlexibleBottomAppBarHeight = DockedToolbarTokens.INSTANCE.m5336getContainerHeightD9Ej5fM();
    private static final Arrangement.Horizontal FlexibleHorizontalArrangement = Arrangement.INSTANCE.getSpaceBetween();
    private static final Arrangement.Horizontal FlexibleFixedHorizontalArrangement = Arrangement.INSTANCE.m1074spacedByD5KLDUw(DockedToolbarTokens.INSTANCE.m5338getContainerMaxSpacingD9Ej5fM(), Alignment.INSTANCE.getCenterHorizontally());

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean exitAlwaysScrollBehavior$lambda$0$0() {
        return true;
    }

    /* JADX INFO: renamed from: getFlexibleBottomAppBarHeight-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m2808getFlexibleBottomAppBarHeightD9Ej5fM$annotations() {
    }

    public static /* synthetic */ void getFlexibleContentPadding$annotations() {
    }

    public static /* synthetic */ void getFlexibleFixedHorizontalArrangement$annotations() {
    }

    public static /* synthetic */ void getFlexibleHorizontalArrangement$annotations() {
    }

    private BottomAppBarDefaults() {
    }

    public final long getContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -368340078, "C(<get-containerColor>)2295@111760L5:AppBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-368340078, i, -1, "androidx.compose.material3.BottomAppBarDefaults.<get-containerColor> (AppBar.kt:2295)");
        }
        long value = ColorSchemeKt.getValue(BottomAppBarTokens.INSTANCE.getContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    /* JADX INFO: renamed from: getContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m2809getContainerElevationD9Ej5fM() {
        return ContainerElevation;
    }

    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    public final WindowInsets getWindowInsets(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 688896409, "C(<get-windowInsets>)2315@112417L29:AppBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(688896409, i, -1, "androidx.compose.material3.BottomAppBarDefaults.<get-windowInsets> (AppBar.kt:2314)");
        }
        WindowInsets windowInsetsM1294onlybOOhFvg = WindowInsetsKt.m1294onlybOOhFvg(SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.INSTANCE, composer, 6), WindowInsetsSides.m1311plusgK_yJZ4(WindowInsetsSides.INSTANCE.m1321getHorizontalJoeWqyM(), WindowInsetsSides.INSTANCE.m1319getBottomJoeWqyM()));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return windowInsetsM1294onlybOOhFvg;
    }

    public final long getBottomAppBarFabColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1464561486, "C(<get-bottomAppBarFabColor>)2322@112723L5:AppBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1464561486, i, -1, "androidx.compose.material3.BottomAppBarDefaults.<get-bottomAppBarFabColor> (AppBar.kt:2322)");
        }
        long value = ColorSchemeKt.getValue(FabSecondaryContainerTokens.INSTANCE.getContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final PaddingValues getFlexibleContentPadding() {
        return FlexibleContentPadding;
    }

    /* JADX INFO: renamed from: getFlexibleBottomAppBarHeight-D9Ej5fM, reason: not valid java name */
    public final float m2810getFlexibleBottomAppBarHeightD9Ej5fM() {
        return FlexibleBottomAppBarHeight;
    }

    public final Arrangement.Horizontal getFlexibleHorizontalArrangement() {
        return FlexibleHorizontalArrangement;
    }

    public final Arrangement.Horizontal getFlexibleFixedHorizontalArrangement() {
        return FlexibleFixedHorizontalArrangement;
    }

    public final BottomAppBarScrollBehavior exitAlwaysScrollBehavior(BottomAppBarState bottomAppBarState, Function0<Boolean> function0, AnimationSpec<Float> animationSpec, DecayAnimationSpec<Float> decayAnimationSpec, Composer composer, int i, int i2) {
        Composer composer2;
        ComposerKt.sourceInformationMarkerStart(composer, 457144034, "C(exitAlwaysScrollBehavior)N(state,canScroll,snapAnimationSpec,flingAnimationSpec)2374@115423L27,2375@115487L8,2376@115582L7,2377@115648L26,2379@115720L311:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            composer2 = composer;
            bottomAppBarState = AppBarKt.rememberBottomAppBarState(0.0f, 0.0f, 0.0f, composer2, 0, 7);
        } else {
            composer2 = composer;
        }
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, 1228756618, "CC(remember):AppBar.kt#9igjgp");
            Object objRememberedValue = composer2.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.BottomAppBarDefaults$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(BottomAppBarDefaults.exitAlwaysScrollBehavior$lambda$0$0());
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            }
            function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer2);
        }
        if ((i2 & 4) != 0) {
            animationSpec = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composer2, 6);
        }
        if ((i2 & 8) != 0) {
            decayAnimationSpec = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(composer2, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(457144034, i, -1, "androidx.compose.material3.BottomAppBarDefaults.exitAlwaysScrollBehavior (AppBar.kt:2379)");
        }
        ComposerKt.sourceInformationMarkerStart(composer2, 1228764377, "CC(remember):AppBar.kt#9igjgp");
        boolean zChanged = ((((i & 14) ^ 6) > 4 && composer2.changed(bottomAppBarState)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer2.changed(function0)) || (i & 48) == 32) | composer2.changed(animationSpec) | composer2.changed(decayAnimationSpec);
        Object objRememberedValue2 = composer2.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new ExitAlwaysScrollBehavior(bottomAppBarState, animationSpec, decayAnimationSpec, function0);
            composer2.updateRememberedValue(objRememberedValue2);
        }
        ExitAlwaysScrollBehavior exitAlwaysScrollBehavior = (ExitAlwaysScrollBehavior) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return exitAlwaysScrollBehavior;
    }
}
