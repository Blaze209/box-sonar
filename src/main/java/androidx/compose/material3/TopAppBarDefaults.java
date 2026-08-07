package androidx.compose.material3;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material3.internal.SystemBarsDefaultInsets_androidKt;
import androidx.compose.material3.tokens.AppBarLargeFlexibleTokens;
import androidx.compose.material3.tokens.AppBarLargeTokens;
import androidx.compose.material3.tokens.AppBarMediumFlexibleTokens;
import androidx.compose.material3.tokens.AppBarMediumTokens;
import androidx.compose.material3.tokens.AppBarSmallTokens;
import androidx.compose.material3.tokens.AppBarTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AppBar.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006JK\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJA\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u001e\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006JA\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001f\u0010\u0011J\r\u0010 \u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006JA\u0010 \u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\bH\u0007¢\u0006\u0004\b!\u0010\u0011J\r\u0010\"\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006JA\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\bH\u0007¢\u0006\u0004\b#\u0010\u0011J'\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)H\u0007¢\u0006\u0002\u0010+J/\u0010$\u001a\u00020%2\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010&\u001a\u00020'2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)H\u0007¢\u0006\u0002\u0010.J9\u0010$\u001a\u00020%2\u0006\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u00020*2\b\b\u0002\u0010&\u001a\u00020'2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)H\u0007¢\u0006\u0002\u00102JK\u00103\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\u0010\b\u0002\u00104\u001a\n\u0012\u0004\u0012\u000206\u0018\u0001052\u0010\b\u0002\u00107\u001a\n\u0012\u0004\u0012\u000206\u0018\u000108H\u0007¢\u0006\u0002\u00109JU\u00103\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\u0010\b\u0002\u00104\u001a\n\u0012\u0004\u0012\u000206\u0018\u0001052\u0010\b\u0002\u00107\u001a\n\u0012\u0004\u0012\u000206\u0018\u0001082\b\b\u0002\u0010:\u001a\u00020*H\u0007¢\u0006\u0002\u0010;JS\u00103\u001a\u00020%2\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010&\u001a\u00020'2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\u0010\b\u0002\u00104\u001a\n\u0012\u0004\u0012\u000206\u0018\u0001052\u0010\b\u0002\u00107\u001a\n\u0012\u0004\u0012\u000206\u0018\u000108H\u0007¢\u0006\u0002\u0010<J]\u00103\u001a\u00020%2\u0006\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u00020*2\b\b\u0002\u0010&\u001a\u00020'2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\u0010\b\u0002\u00104\u001a\n\u0012\u0004\u0012\u000206\u0018\u0001052\u0010\b\u0002\u00107\u001a\n\u0012\u0004\u0012\u000206\u0018\u000108H\u0007¢\u0006\u0002\u0010=JK\u0010>\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\u0010\b\u0002\u00104\u001a\n\u0012\u0004\u0012\u000206\u0018\u0001052\u0010\b\u0002\u00107\u001a\n\u0012\u0004\u0012\u000206\u0018\u000108H\u0007¢\u0006\u0002\u00109R\u0018\u0010\u0012\u001a\u00020\u0005*\u00020\u00138@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b8G¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010?\u001a\u00020@¢\u0006\n\n\u0002\u0010C\u001a\u0004\bA\u0010BR\u0013\u0010D\u001a\u00020@¢\u0006\n\n\u0002\u0010C\u001a\u0004\bE\u0010BR\u0013\u0010F\u001a\u00020@¢\u0006\n\n\u0002\u0010C\u001a\u0004\bG\u0010BR\u0013\u0010H\u001a\u00020@¢\u0006\n\n\u0002\u0010C\u001a\u0004\bI\u0010BR\u0013\u0010J\u001a\u00020@¢\u0006\n\n\u0002\u0010C\u001a\u0004\bK\u0010BR\u0013\u0010L\u001a\u00020@¢\u0006\n\n\u0002\u0010C\u001a\u0004\bM\u0010BR\u0013\u0010N\u001a\u00020@¢\u0006\n\n\u0002\u0010C\u001a\u0004\bO\u0010BR\u0013\u0010P\u001a\u00020@¢\u0006\n\n\u0002\u0010C\u001a\u0004\bQ\u0010BR\u0013\u0010R\u001a\u00020@¢\u0006\n\n\u0002\u0010C\u001a\u0004\bS\u0010B¨\u0006T"}, d2 = {"Landroidx/compose/material3/TopAppBarDefaults;", "", "<init>", "()V", "topAppBarColors", "Landroidx/compose/material3/TopAppBarColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TopAppBarColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "scrolledContainerColor", "navigationIconContentColor", "titleContentColor", "actionIconContentColor", "subtitleContentColor", "topAppBarColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarColors;", "topAppBarColors-zjMxDiM", "(JJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarColors;", "defaultTopAppBarColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultTopAppBarColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/TopAppBarColors;", "ContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "centerAlignedTopAppBarColors", "centerAlignedTopAppBarColors-zjMxDiM", "mediumTopAppBarColors", "mediumTopAppBarColors-zjMxDiM", "largeTopAppBarColors", "largeTopAppBarColors-zjMxDiM", "pinnedScrollBehavior", "Landroidx/compose/material3/TopAppBarScrollBehavior;", "state", "Landroidx/compose/material3/TopAppBarState;", "canScroll", "Lkotlin/Function0;", "", "(Landroidx/compose/material3/TopAppBarState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarScrollBehavior;", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/material3/TopAppBarState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarScrollBehavior;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "reverseScrolling", "(Landroidx/compose/foundation/ScrollState;ZLandroidx/compose/material3/TopAppBarState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarScrollBehavior;", "enterAlwaysScrollBehavior", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "(Landroidx/compose/material3/TopAppBarState;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarScrollBehavior;", "reverseLayout", "(Landroidx/compose/material3/TopAppBarState;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarScrollBehavior;", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/material3/TopAppBarState;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarScrollBehavior;", "(Landroidx/compose/foundation/ScrollState;ZLandroidx/compose/material3/TopAppBarState;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarScrollBehavior;", "exitUntilCollapsedScrollBehavior", "TopAppBarExpandedHeight", "Landroidx/compose/ui/unit/Dp;", "getTopAppBarExpandedHeight-D9Ej5fM", "()F", "F", "MediumAppBarCollapsedHeight", "getMediumAppBarCollapsedHeight-D9Ej5fM", "MediumAppBarExpandedHeight", "getMediumAppBarExpandedHeight-D9Ej5fM", "MediumFlexibleAppBarWithoutSubtitleExpandedHeight", "getMediumFlexibleAppBarWithoutSubtitleExpandedHeight-D9Ej5fM", "MediumFlexibleAppBarWithSubtitleExpandedHeight", "getMediumFlexibleAppBarWithSubtitleExpandedHeight-D9Ej5fM", "LargeAppBarCollapsedHeight", "getLargeAppBarCollapsedHeight-D9Ej5fM", "LargeAppBarExpandedHeight", "getLargeAppBarExpandedHeight-D9Ej5fM", "LargeFlexibleAppBarWithoutSubtitleExpandedHeight", "getLargeFlexibleAppBarWithoutSubtitleExpandedHeight-D9Ej5fM", "LargeFlexibleAppBarWithSubtitleExpandedHeight", "getLargeFlexibleAppBarWithSubtitleExpandedHeight-D9Ej5fM", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TopAppBarDefaults {
    public static final int $stable = 0;
    public static final TopAppBarDefaults INSTANCE = new TopAppBarDefaults();
    private static final PaddingValues ContentPadding = PaddingKt.m1211PaddingValues0680j_4(Dp.m9687constructorimpl(0));
    private static final float TopAppBarExpandedHeight = AppBarSmallTokens.INSTANCE.m5129getContainerHeightD9Ej5fM();
    private static final float MediumAppBarCollapsedHeight = AppBarSmallTokens.INSTANCE.m5129getContainerHeightD9Ej5fM();
    private static final float MediumAppBarExpandedHeight = AppBarMediumTokens.INSTANCE.m5128getContainerHeightD9Ej5fM();
    private static final float MediumFlexibleAppBarWithoutSubtitleExpandedHeight = AppBarMediumFlexibleTokens.INSTANCE.m5126getContainerHeightD9Ej5fM();
    private static final float MediumFlexibleAppBarWithSubtitleExpandedHeight = AppBarMediumFlexibleTokens.INSTANCE.m5127getLargeContainerHeightD9Ej5fM();
    private static final float LargeAppBarCollapsedHeight = AppBarSmallTokens.INSTANCE.m5129getContainerHeightD9Ej5fM();
    private static final float LargeAppBarExpandedHeight = AppBarLargeTokens.INSTANCE.m5125getContainerHeightD9Ej5fM();
    private static final float LargeFlexibleAppBarWithoutSubtitleExpandedHeight = AppBarLargeFlexibleTokens.INSTANCE.m5123getContainerHeightD9Ej5fM();
    private static final float LargeFlexibleAppBarWithSubtitleExpandedHeight = AppBarLargeFlexibleTokens.INSTANCE.m5124getLargeContainerHeightD9Ej5fM();

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enterAlwaysScrollBehavior$lambda$0$0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enterAlwaysScrollBehavior$lambda$2$0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enterAlwaysScrollBehavior$lambda$4$0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enterAlwaysScrollBehavior$lambda$6$0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean exitUntilCollapsedScrollBehavior$lambda$0$0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean pinnedScrollBehavior$lambda$0$0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean pinnedScrollBehavior$lambda$2$0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean pinnedScrollBehavior$lambda$4$0() {
        return true;
    }

    private TopAppBarDefaults() {
    }

    public final TopAppBarColors topAppBarColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1388520854, "C(topAppBarColors)1402@71585L11:AppBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1388520854, i, -1, "androidx.compose.material3.TopAppBarDefaults.topAppBarColors (AppBar.kt:1402)");
        }
        TopAppBarColors defaultTopAppBarColors$material3 = getDefaultTopAppBarColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultTopAppBarColors$material3;
    }

    /* JADX INFO: renamed from: topAppBarColors-5tl4gsc, reason: not valid java name */
    public final TopAppBarColors m4782topAppBarColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1325733438, "C(topAppBarColors)N(containerColor:c#ui.graphics.Color,scrolledContainerColor:c#ui.graphics.Color,navigationIconContentColor:c#ui.graphics.Color,titleContentColor:c#ui.graphics.Color,actionIconContentColor:c#ui.graphics.Color,subtitleContentColor:c#ui.graphics.Color)1425@72769L11:AppBar.kt#uh7d8r");
        long jM6850getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j;
        long jM6850getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j2;
        long jM6850getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j3;
        long jM6850getUnspecified0d7_KjU4 = (i2 & 8) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j4;
        long jM6850getUnspecified0d7_KjU5 = (i2 & 16) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j5;
        long jM6850getUnspecified0d7_KjU6 = (i2 & 32) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1325733438, i, -1, "androidx.compose.material3.TopAppBarDefaults.topAppBarColors (AppBar.kt:1425)");
        }
        TopAppBarColors topAppBarColorsM4759copytNS2XkQ = getDefaultTopAppBarColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m4759copytNS2XkQ(jM6850getUnspecified0d7_KjU, jM6850getUnspecified0d7_KjU2, jM6850getUnspecified0d7_KjU3, jM6850getUnspecified0d7_KjU4, jM6850getUnspecified0d7_KjU5, jM6850getUnspecified0d7_KjU6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return topAppBarColorsM4759copytNS2XkQ;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility in favor of topAppBarColors with subtitleContentColor")
    /* JADX INFO: renamed from: topAppBarColors-zjMxDiM, reason: not valid java name */
    public final /* synthetic */ TopAppBarColors m4783topAppBarColorszjMxDiM(long j, long j2, long j3, long j4, long j5, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 2142919275, "C(topAppBarColors)N(containerColor:c#ui.graphics.Color,scrolledContainerColor:c#ui.graphics.Color,navigationIconContentColor:c#ui.graphics.Color,titleContentColor:c#ui.graphics.Color,actionIconContentColor:c#ui.graphics.Color)1457@74193L367:AppBar.kt#uh7d8r");
        long jM6850getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j;
        long jM6850getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j2;
        long jM6850getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j3;
        long jM6850getUnspecified0d7_KjU4 = (i2 & 8) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j4;
        long jM6850getUnspecified0d7_KjU5 = (i2 & 16) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2142919275, i, -1, "androidx.compose.material3.TopAppBarDefaults.topAppBarColors (AppBar.kt:1457)");
        }
        TopAppBarColors topAppBarColorsM4782topAppBarColors5tl4gsc = m4782topAppBarColors5tl4gsc(jM6850getUnspecified0d7_KjU, jM6850getUnspecified0d7_KjU2, jM6850getUnspecified0d7_KjU3, jM6850getUnspecified0d7_KjU4, jM6850getUnspecified0d7_KjU5, jM6850getUnspecified0d7_KjU4, composer, (65534 & i) | ((i << 6) & 458752) | ((i << 3) & 3670016), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return topAppBarColorsM4782topAppBarColors5tl4gsc;
    }

    public final TopAppBarColors getDefaultTopAppBarColors$material3(ColorScheme colorScheme) {
        TopAppBarColors defaultTopAppBarColorsCached = colorScheme.getDefaultTopAppBarColorsCached();
        if (defaultTopAppBarColorsCached != null) {
            return defaultTopAppBarColorsCached;
        }
        TopAppBarColors topAppBarColors = new TopAppBarColors(ColorSchemeKt.fromToken(colorScheme, AppBarTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, AppBarTokens.INSTANCE.getOnScrollContainerColor()), ColorSchemeKt.fromToken(colorScheme, AppBarTokens.INSTANCE.getLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, AppBarTokens.INSTANCE.getTitleColor()), ColorSchemeKt.fromToken(colorScheme, AppBarTokens.INSTANCE.getTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme, AppBarTokens.INSTANCE.getSubtitleColor()), null);
        colorScheme.setDefaultTopAppBarColorsCached$material3(topAppBarColors);
        return topAppBarColors;
    }

    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    public final WindowInsets getWindowInsets(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 2143182847, "C(<get-windowInsets>)1487@75633L29:AppBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2143182847, i, -1, "androidx.compose.material3.TopAppBarDefaults.<get-windowInsets> (AppBar.kt:1487)");
        }
        WindowInsets windowInsetsM1294onlybOOhFvg = WindowInsetsKt.m1294onlybOOhFvg(SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.INSTANCE, composer, 6), WindowInsetsSides.m1311plusgK_yJZ4(WindowInsetsSides.INSTANCE.m1321getHorizontalJoeWqyM(), WindowInsetsSides.INSTANCE.m1325getTopJoeWqyM()));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return windowInsetsM1294onlybOOhFvg;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use topAppBarColors instead", replaceWith = @ReplaceWith(expression = "topAppBarColors()", imports = {}))
    public final TopAppBarColors centerAlignedTopAppBarColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 513940029, "C(centerAlignedTopAppBarColors)1501@76177L11:AppBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(513940029, i, -1, "androidx.compose.material3.TopAppBarDefaults.centerAlignedTopAppBarColors (AppBar.kt:1501)");
        }
        TopAppBarColors defaultTopAppBarColors$material3 = getDefaultTopAppBarColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultTopAppBarColors$material3;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use topAppBarColors instead", replaceWith = @ReplaceWith(expression = "topAppBarColors(containerColor, scrolledContainerColor, navigationIconContentColor, titleContentColor, actionIconContentColor)", imports = {}))
    /* JADX INFO: renamed from: centerAlignedTopAppBarColors-zjMxDiM, reason: not valid java name */
    public final TopAppBarColors m4770centerAlignedTopAppBarColorszjMxDiM(long j, long j2, long j3, long j4, long j5, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1896017784, "C(centerAlignedTopAppBarColors)N(containerColor:c#ui.graphics.Color,scrolledContainerColor:c#ui.graphics.Color,navigationIconContentColor:c#ui.graphics.Color,titleContentColor:c#ui.graphics.Color,actionIconContentColor:c#ui.graphics.Color)1531@77578L11:AppBar.kt#uh7d8r");
        long jM6850getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j;
        long jM6850getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j2;
        long jM6850getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j3;
        long jM6850getUnspecified0d7_KjU4 = (i2 & 8) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j4;
        long jM6850getUnspecified0d7_KjU5 = (i2 & 16) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1896017784, i, -1, "androidx.compose.material3.TopAppBarDefaults.centerAlignedTopAppBarColors (AppBar.kt:1531)");
        }
        TopAppBarColors topAppBarColorsM4757copytNS2XkQ$default = TopAppBarColors.m4757copytNS2XkQ$default(getDefaultTopAppBarColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)), jM6850getUnspecified0d7_KjU, jM6850getUnspecified0d7_KjU2, jM6850getUnspecified0d7_KjU3, jM6850getUnspecified0d7_KjU4, jM6850getUnspecified0d7_KjU5, 0L, 32, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return topAppBarColorsM4757copytNS2XkQ$default;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use topAppBarColors instead", replaceWith = @ReplaceWith(expression = "topAppBarColors()", imports = {}))
    public final TopAppBarColors mediumTopAppBarColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1268886463, "C(mediumTopAppBarColors)1550@78249L11:AppBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1268886463, i, -1, "androidx.compose.material3.TopAppBarDefaults.mediumTopAppBarColors (AppBar.kt:1550)");
        }
        TopAppBarColors defaultTopAppBarColors$material3 = getDefaultTopAppBarColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultTopAppBarColors$material3;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use topAppBarColors instead", replaceWith = @ReplaceWith(expression = "topAppBarColors(containerColor, scrolledContainerColor, navigationIconContentColor, titleContentColor, actionIconContentColor)", imports = {}))
    /* JADX INFO: renamed from: mediumTopAppBarColors-zjMxDiM, reason: not valid java name */
    public final TopAppBarColors m4781mediumTopAppBarColorszjMxDiM(long j, long j2, long j3, long j4, long j5, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -582474442, "C(mediumTopAppBarColors)N(containerColor:c#ui.graphics.Color,scrolledContainerColor:c#ui.graphics.Color,navigationIconContentColor:c#ui.graphics.Color,titleContentColor:c#ui.graphics.Color,actionIconContentColor:c#ui.graphics.Color)1581@79674L11:AppBar.kt#uh7d8r");
        long jM6850getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j;
        long jM6850getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j2;
        long jM6850getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j3;
        long jM6850getUnspecified0d7_KjU4 = (i2 & 8) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j4;
        long jM6850getUnspecified0d7_KjU5 = (i2 & 16) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-582474442, i, -1, "androidx.compose.material3.TopAppBarDefaults.mediumTopAppBarColors (AppBar.kt:1581)");
        }
        TopAppBarColors topAppBarColorsM4757copytNS2XkQ$default = TopAppBarColors.m4757copytNS2XkQ$default(getDefaultTopAppBarColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)), jM6850getUnspecified0d7_KjU, jM6850getUnspecified0d7_KjU2, jM6850getUnspecified0d7_KjU3, jM6850getUnspecified0d7_KjU4, jM6850getUnspecified0d7_KjU5, 0L, 32, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return topAppBarColorsM4757copytNS2XkQ$default;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use topAppBarColors instead", replaceWith = @ReplaceWith(expression = "topAppBarColors()", imports = {}))
    public final TopAppBarColors largeTopAppBarColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1744932393, "C(largeTopAppBarColors)1600@80343L11:AppBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1744932393, i, -1, "androidx.compose.material3.TopAppBarDefaults.largeTopAppBarColors (AppBar.kt:1600)");
        }
        TopAppBarColors defaultTopAppBarColors$material3 = getDefaultTopAppBarColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultTopAppBarColors$material3;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use topAppBarColors instead", replaceWith = @ReplaceWith(expression = "topAppBarColors(containerColor, scrolledContainerColor, navigationIconContentColor, titleContentColor, actionIconContentColor)", imports = {}))
    /* JADX INFO: renamed from: largeTopAppBarColors-zjMxDiM, reason: not valid java name */
    public final TopAppBarColors m4780largeTopAppBarColorszjMxDiM(long j, long j2, long j3, long j4, long j5, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1471507700, "C(largeTopAppBarColors)N(containerColor:c#ui.graphics.Color,scrolledContainerColor:c#ui.graphics.Color,navigationIconContentColor:c#ui.graphics.Color,titleContentColor:c#ui.graphics.Color,actionIconContentColor:c#ui.graphics.Color)1631@81766L11:AppBar.kt#uh7d8r");
        long jM6850getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j;
        long jM6850getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j2;
        long jM6850getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j3;
        long jM6850getUnspecified0d7_KjU4 = (i2 & 8) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j4;
        long jM6850getUnspecified0d7_KjU5 = (i2 & 16) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1471507700, i, -1, "androidx.compose.material3.TopAppBarDefaults.largeTopAppBarColors (AppBar.kt:1631)");
        }
        TopAppBarColors topAppBarColorsM4757copytNS2XkQ$default = TopAppBarColors.m4757copytNS2XkQ$default(getDefaultTopAppBarColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)), jM6850getUnspecified0d7_KjU, jM6850getUnspecified0d7_KjU2, jM6850getUnspecified0d7_KjU3, jM6850getUnspecified0d7_KjU4, jM6850getUnspecified0d7_KjU5, 0L, 32, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return topAppBarColorsM4757copytNS2XkQ$default;
    }

    public final TopAppBarScrollBehavior pinnedScrollBehavior(TopAppBarState topAppBarState, Function0<Boolean> function0, Composer composer, int i, int i2) {
        Function0<Boolean> function1;
        ComposerKt.sourceInformationMarkerStart(composer, 286497075, "C(pinnedScrollBehavior)N(state,canScroll)1655@82911L24,1656@82972L8,1658@83023L89:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            topAppBarState = AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composer, 0, 7);
        }
        TopAppBarState topAppBarState2 = topAppBarState;
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 445785947, "CC(remember):AppBar.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.TopAppBarDefaults$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(TopAppBarDefaults.pinnedScrollBehavior$lambda$0$0());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            function1 = (Function0) objRememberedValue;
        } else {
            function1 = function0;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(286497075, i, -1, "androidx.compose.material3.TopAppBarDefaults.pinnedScrollBehavior (AppBar.kt:1658)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 445787660, "CC(remember):AppBar.kt#9igjgp");
        boolean z = ((((i & 14) ^ 6) > 4 && composer.changed(topAppBarState2)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(function1)) || (i & 48) == 32);
        Object objRememberedValue2 = composer.rememberedValue();
        if (z || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            PinnedScrollBehavior pinnedScrollBehavior = new PinnedScrollBehavior(topAppBarState2, function1, null, 4, null);
            composer.updateRememberedValue(pinnedScrollBehavior);
            objRememberedValue2 = pinnedScrollBehavior;
        }
        PinnedScrollBehavior pinnedScrollBehavior2 = (PinnedScrollBehavior) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return pinnedScrollBehavior2;
    }

    public final TopAppBarScrollBehavior pinnedScrollBehavior(LazyListState lazyListState, TopAppBarState topAppBarState, Function0<Boolean> function0, Composer composer, int i, int i2) {
        Composer composer2;
        ComposerKt.sourceInformationMarkerStart(composer, -608587040, "C(pinnedScrollBehavior)N(lazyListState,state,canScroll)1677@84013L24,1678@84074L8,1680@84144L46,1681@84206L225:AppBar.kt#uh7d8r");
        if ((i2 & 2) != 0) {
            composer2 = composer;
            topAppBarState = AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composer2, 0, 7);
        } else {
            composer2 = composer;
        }
        if ((i2 & 4) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, -736588152, "CC(remember):AppBar.kt#9igjgp");
            Object objRememberedValue = composer2.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.TopAppBarDefaults$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(TopAppBarDefaults.pinnedScrollBehavior$lambda$2$0());
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            }
            function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer2);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-608587040, i, -1, "androidx.compose.material3.TopAppBarDefaults.pinnedScrollBehavior (AppBar.kt:1679)");
        }
        final State stateRememberIsAtTop = AppBarKt.rememberIsAtTop(lazyListState, composer2, i & 14);
        ComposerKt.sourceInformationMarkerStart(composer2, -736583711, "CC(remember):AppBar.kt#9igjgp");
        boolean zChanged = ((((i & 112) ^ 48) > 32 && composer2.changed(topAppBarState)) || (i & 48) == 32) | ((((i & 896) ^ 384) > 256 && composer2.changed(function0)) || (i & 384) == 256) | composer2.changed(stateRememberIsAtTop);
        Object objRememberedValue2 = composer2.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new PinnedScrollBehavior(topAppBarState, function0, new Function0() { // from class: androidx.compose.material3.TopAppBarDefaults$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(TopAppBarDefaults.pinnedScrollBehavior$lambda$3$0(stateRememberIsAtTop));
                }
            });
            composer2.updateRememberedValue(objRememberedValue2);
        }
        PinnedScrollBehavior pinnedScrollBehavior = (PinnedScrollBehavior) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return pinnedScrollBehavior;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean pinnedScrollBehavior$lambda$3$0(State state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    public final TopAppBarScrollBehavior pinnedScrollBehavior(ScrollState scrollState, boolean z, TopAppBarState topAppBarState, Function0<Boolean> function0, Composer composer, int i, int i2) {
        Composer composer2;
        ComposerKt.sourceInformationMarkerStart(composer, -209339169, "C(pinnedScrollBehavior)N(scrollState,reverseScrolling,state,canScroll)1709@85447L24,1710@85508L8,1713@85590L79,1714@85685L225:AppBar.kt#uh7d8r");
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            composer2 = composer;
            topAppBarState = AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composer2, 0, 7);
        } else {
            composer2 = composer;
        }
        if ((i2 & 8) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, 688527783, "CC(remember):AppBar.kt#9igjgp");
            Object objRememberedValue = composer2.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.TopAppBarDefaults$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(TopAppBarDefaults.pinnedScrollBehavior$lambda$4$0());
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            }
            function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer2);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-209339169, i, -1, "androidx.compose.material3.TopAppBarDefaults.pinnedScrollBehavior (AppBar.kt:1711)");
        }
        final State stateRememberIsAtTop = AppBarKt.rememberIsAtTop(scrollState, z, composer2, i & 126);
        ComposerKt.sourceInformationMarkerStart(composer2, 688533664, "CC(remember):AppBar.kt#9igjgp");
        boolean zChanged = ((((i & 896) ^ 384) > 256 && composer2.changed(topAppBarState)) || (i & 384) == 256) | ((((i & 7168) ^ 3072) > 2048 && composer2.changed(function0)) || (i & 3072) == 2048) | composer2.changed(stateRememberIsAtTop);
        Object objRememberedValue2 = composer2.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new PinnedScrollBehavior(topAppBarState, function0, new Function0() { // from class: androidx.compose.material3.TopAppBarDefaults$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(TopAppBarDefaults.pinnedScrollBehavior$lambda$5$0(stateRememberIsAtTop));
                }
            });
            composer2.updateRememberedValue(objRememberedValue2);
        }
        PinnedScrollBehavior pinnedScrollBehavior = (PinnedScrollBehavior) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return pinnedScrollBehavior;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean pinnedScrollBehavior$lambda$5$0(State state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    public final TopAppBarScrollBehavior enterAlwaysScrollBehavior(TopAppBarState topAppBarState, Function0<Boolean> function0, AnimationSpec<Float> animationSpec, DecayAnimationSpec<Float> decayAnimationSpec, Composer composer, int i, int i2) {
        Function0<Boolean> function1;
        ComposerKt.sourceInformationMarkerStart(composer, 959086674, "C(enterAlwaysScrollBehavior)N(state,canScroll,snapAnimationSpec,flingAnimationSpec)1746@87413L24,1747@87474L8,1748@87572L7,1749@87638L26,1751@87707L312:AppBar.kt#uh7d8r");
        TopAppBarState topAppBarStateRememberTopAppBarState = (i2 & 1) != 0 ? AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composer, 0, 7) : topAppBarState;
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, -1735670950, "CC(remember):AppBar.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.TopAppBarDefaults$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(TopAppBarDefaults.enterAlwaysScrollBehavior$lambda$0$0());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            function1 = (Function0) objRememberedValue;
        } else {
            function1 = function0;
        }
        AnimationSpec<Float> animationSpecValue = (i2 & 4) != 0 ? MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composer, 6) : animationSpec;
        DecayAnimationSpec<Float> decayAnimationSpecRememberSplineBasedDecay = (i2 & 8) != 0 ? SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(composer, 0) : decayAnimationSpec;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(959086674, i, -1, "androidx.compose.material3.TopAppBarDefaults.enterAlwaysScrollBehavior (AppBar.kt:1751)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1735663190, "CC(remember):AppBar.kt#9igjgp");
        boolean zChanged = ((((i & 14) ^ 6) > 4 && composer.changed(topAppBarStateRememberTopAppBarState)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(function1)) || (i & 48) == 32) | composer.changed(animationSpecValue) | composer.changed(decayAnimationSpecRememberSplineBasedDecay);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            EnterAlwaysScrollBehavior enterAlwaysScrollBehavior = new EnterAlwaysScrollBehavior(topAppBarStateRememberTopAppBarState, animationSpecValue, decayAnimationSpecRememberSplineBasedDecay, function1, null, 16, null);
            composer.updateRememberedValue(enterAlwaysScrollBehavior);
            objRememberedValue2 = enterAlwaysScrollBehavior;
        }
        EnterAlwaysScrollBehavior enterAlwaysScrollBehavior2 = (EnterAlwaysScrollBehavior) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return enterAlwaysScrollBehavior2;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Please use the enterAlwaysScrollBehavior() function that takes lazyListState or scrollState parameters.", replaceWith = @ReplaceWith(expression = "enterAlwaysScrollBehavior(lazyListState, state, canScroll, snapAnimationSpec, flingAnimationSpec)", imports = {}))
    public final TopAppBarScrollBehavior enterAlwaysScrollBehavior(TopAppBarState topAppBarState, Function0<Boolean> function0, AnimationSpec<Float> animationSpec, DecayAnimationSpec<Float> decayAnimationSpec, boolean z, Composer composer, int i, int i2) {
        Composer composer2;
        ComposerKt.sourceInformationMarkerStart(composer, 53729710, "C(enterAlwaysScrollBehavior)N(state,canScroll,snapAnimationSpec,flingAnimationSpec,reverseLayout)1792@89838L24,1793@89899L8,1794@89997L7,1795@90063L26,1798@90172L380:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            composer2 = composer;
            topAppBarState = AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composer2, 0, 7);
        } else {
            composer2 = composer;
        }
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, 94647734, "CC(remember):AppBar.kt#9igjgp");
            Object objRememberedValue = composer2.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.TopAppBarDefaults$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(TopAppBarDefaults.enterAlwaysScrollBehavior$lambda$2$0());
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            }
            function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer2);
        }
        if ((i2 & 4) != 0) {
            animationSpec = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composer2, 6);
        }
        if ((i2 & 8) != 0) {
            decayAnimationSpec = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(composer2, 0);
        }
        if ((i2 & 16) != 0) {
            z = false;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(53729710, i, -1, "androidx.compose.material3.TopAppBarDefaults.enterAlwaysScrollBehavior (AppBar.kt:1798)");
        }
        ComposerKt.sourceInformationMarkerStart(composer2, 94656842, "CC(remember):AppBar.kt#9igjgp");
        boolean zChanged = ((((i & 14) ^ 6) > 4 && composer2.changed(topAppBarState)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer2.changed(function0)) || (i & 48) == 32) | composer2.changed(animationSpec) | composer2.changed(decayAnimationSpec) | ((((57344 & i) ^ 24576) > 16384 && composer2.changed(z)) || (i & 24576) == 16384);
        Object objRememberedValue2 = composer2.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            boolean z2 = z;
            LegacyEnterAlwaysScrollBehavior legacyEnterAlwaysScrollBehavior = new LegacyEnterAlwaysScrollBehavior(topAppBarState, animationSpec, decayAnimationSpec, function0, z2);
            composer2.updateRememberedValue(legacyEnterAlwaysScrollBehavior);
            objRememberedValue2 = legacyEnterAlwaysScrollBehavior;
        }
        LegacyEnterAlwaysScrollBehavior legacyEnterAlwaysScrollBehavior2 = (LegacyEnterAlwaysScrollBehavior) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return legacyEnterAlwaysScrollBehavior2;
    }

    public final TopAppBarScrollBehavior enterAlwaysScrollBehavior(LazyListState lazyListState, TopAppBarState topAppBarState, Function0<Boolean> function0, AnimationSpec<Float> animationSpec, DecayAnimationSpec<Float> decayAnimationSpec, Composer composer, int i, int i2) {
        Composer composer2;
        ComposerKt.sourceInformationMarkerStart(composer, -1173138683, "C(enterAlwaysScrollBehavior)N(lazyListState,state,canScroll,snapAnimationSpec,flingAnimationSpec)1832@92027L24,1833@92088L8,1834@92186L7,1835@92252L26,1837@92340L46,1838@92402L381:AppBar.kt#uh7d8r");
        if ((i2 & 2) != 0) {
            composer2 = composer;
            topAppBarState = AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composer2, 0, 7);
        } else {
            composer2 = composer;
        }
        if ((i2 & 4) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, -2104837619, "CC(remember):AppBar.kt#9igjgp");
            Object objRememberedValue = composer2.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.TopAppBarDefaults$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(TopAppBarDefaults.enterAlwaysScrollBehavior$lambda$4$0());
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            }
            function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer2);
        }
        if ((i2 & 8) != 0) {
            animationSpec = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composer2, 6);
        }
        if ((i2 & 16) != 0) {
            decayAnimationSpec = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(composer2, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1173138683, i, -1, "androidx.compose.material3.TopAppBarDefaults.enterAlwaysScrollBehavior (AppBar.kt:1836)");
        }
        final State stateRememberIsAtTop = AppBarKt.rememberIsAtTop(lazyListState, composer2, i & 14);
        ComposerKt.sourceInformationMarkerStart(composer2, -2104827198, "CC(remember):AppBar.kt#9igjgp");
        boolean zChanged = ((((i & 112) ^ 48) > 32 && composer2.changed(topAppBarState)) || (i & 48) == 32) | ((((i & 896) ^ 384) > 256 && composer2.changed(function0)) || (i & 384) == 256) | composer2.changed(animationSpec) | composer2.changed(decayAnimationSpec) | composer2.changed(stateRememberIsAtTop);
        Object objRememberedValue2 = composer2.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            DecayAnimationSpec<Float> decayAnimationSpec2 = decayAnimationSpec;
            EnterAlwaysScrollBehavior enterAlwaysScrollBehavior = new EnterAlwaysScrollBehavior(topAppBarState, animationSpec, decayAnimationSpec2, function0, new Function0() { // from class: androidx.compose.material3.TopAppBarDefaults$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(TopAppBarDefaults.enterAlwaysScrollBehavior$lambda$5$0(stateRememberIsAtTop));
                }
            });
            composer2.updateRememberedValue(enterAlwaysScrollBehavior);
            objRememberedValue2 = enterAlwaysScrollBehavior;
        }
        EnterAlwaysScrollBehavior enterAlwaysScrollBehavior2 = (EnterAlwaysScrollBehavior) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return enterAlwaysScrollBehavior2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enterAlwaysScrollBehavior$lambda$5$0(State state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    public final TopAppBarScrollBehavior enterAlwaysScrollBehavior(ScrollState scrollState, boolean z, TopAppBarState topAppBarState, Function0<Boolean> function0, AnimationSpec<Float> animationSpec, DecayAnimationSpec<Float> decayAnimationSpec, Composer composer, int i, int i2) {
        Function0<Boolean> function1;
        ComposerKt.sourceInformationMarkerStart(composer, -1264911706, "C(enterAlwaysScrollBehavior)N(scrollState,reverseScrolling,state,canScroll,snapAnimationSpec,flingAnimationSpec)1875@94373L24,1876@94434L8,1877@94532L7,1878@94598L26,1880@94686L46,1881@94748L381:AppBar.kt#uh7d8r");
        boolean z2 = (i2 & 2) != 0 ? false : z;
        TopAppBarState topAppBarStateRememberTopAppBarState = (i2 & 4) != 0 ? AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composer, 0, 7) : topAppBarState;
        if ((i2 & 8) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, -104398258, "CC(remember):AppBar.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.TopAppBarDefaults$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(TopAppBarDefaults.enterAlwaysScrollBehavior$lambda$6$0());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            function1 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
        } else {
            function1 = function0;
        }
        FiniteAnimationSpec finiteAnimationSpecValue = (i2 & 16) != 0 ? MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composer, 6) : animationSpec;
        DecayAnimationSpec<Float> decayAnimationSpecRememberSplineBasedDecay = (i2 & 32) != 0 ? SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(composer, 0) : decayAnimationSpec;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1264911706, i, -1, "androidx.compose.material3.TopAppBarDefaults.enterAlwaysScrollBehavior (AppBar.kt:1879)");
        }
        final State stateRememberIsAtTop = AppBarKt.rememberIsAtTop(scrollState, z2, composer, i & 126);
        ComposerKt.sourceInformationMarkerStart(composer, -104387837, "CC(remember):AppBar.kt#9igjgp");
        boolean zChanged = ((((i & 896) ^ 384) > 256 && composer.changed(topAppBarStateRememberTopAppBarState)) || (i & 384) == 256) | ((((i & 7168) ^ 3072) > 2048 && composer.changed(function1)) || (i & 3072) == 2048) | composer.changed(finiteAnimationSpecValue) | composer.changed(decayAnimationSpecRememberSplineBasedDecay) | composer.changed(stateRememberIsAtTop);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new EnterAlwaysScrollBehavior(topAppBarStateRememberTopAppBarState, finiteAnimationSpecValue, decayAnimationSpecRememberSplineBasedDecay, function1, new Function0() { // from class: androidx.compose.material3.TopAppBarDefaults$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(TopAppBarDefaults.enterAlwaysScrollBehavior$lambda$7$0(stateRememberIsAtTop));
                }
            });
            composer.updateRememberedValue(objRememberedValue2);
        }
        EnterAlwaysScrollBehavior enterAlwaysScrollBehavior = (EnterAlwaysScrollBehavior) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return enterAlwaysScrollBehavior;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enterAlwaysScrollBehavior$lambda$7$0(State state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    public final TopAppBarScrollBehavior exitUntilCollapsedScrollBehavior(TopAppBarState topAppBarState, Function0<Boolean> function0, AnimationSpec<Float> animationSpec, DecayAnimationSpec<Float> decayAnimationSpec, Composer composer, int i, int i2) {
        Composer composer2;
        ComposerKt.sourceInformationMarkerStart(composer, -1757023234, "C(exitUntilCollapsedScrollBehavior)N(state,canScroll,snapAnimationSpec,flingAnimationSpec)1916@96564L24,1917@96625L8,1918@96723L7,1919@96789L26,1921@96858L319:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            composer2 = composer;
            topAppBarState = AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composer2, 0, 7);
        } else {
            composer2 = composer;
        }
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, -577176346, "CC(remember):AppBar.kt#9igjgp");
            Object objRememberedValue = composer2.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.TopAppBarDefaults$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(TopAppBarDefaults.exitUntilCollapsedScrollBehavior$lambda$0$0());
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            }
            function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer2);
        }
        if ((i2 & 4) != 0) {
            animationSpec = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composer2, 6);
        }
        if ((i2 & 8) != 0) {
            decayAnimationSpec = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(composer2, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1757023234, i, -1, "androidx.compose.material3.TopAppBarDefaults.exitUntilCollapsedScrollBehavior (AppBar.kt:1921)");
        }
        ComposerKt.sourceInformationMarkerStart(composer2, -577168579, "CC(remember):AppBar.kt#9igjgp");
        boolean zChanged = ((((i & 14) ^ 6) > 4 && composer2.changed(topAppBarState)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer2.changed(function0)) || (i & 48) == 32) | composer2.changed(animationSpec) | composer2.changed(decayAnimationSpec);
        Object objRememberedValue2 = composer2.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new ExitUntilCollapsedScrollBehavior(topAppBarState, animationSpec, decayAnimationSpec, function0);
            composer2.updateRememberedValue(objRememberedValue2);
        }
        ExitUntilCollapsedScrollBehavior exitUntilCollapsedScrollBehavior = (ExitUntilCollapsedScrollBehavior) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return exitUntilCollapsedScrollBehavior;
    }

    /* JADX INFO: renamed from: getTopAppBarExpandedHeight-D9Ej5fM, reason: not valid java name */
    public final float m4779getTopAppBarExpandedHeightD9Ej5fM() {
        return TopAppBarExpandedHeight;
    }

    /* JADX INFO: renamed from: getMediumAppBarCollapsedHeight-D9Ej5fM, reason: not valid java name */
    public final float m4775getMediumAppBarCollapsedHeightD9Ej5fM() {
        return MediumAppBarCollapsedHeight;
    }

    /* JADX INFO: renamed from: getMediumAppBarExpandedHeight-D9Ej5fM, reason: not valid java name */
    public final float m4776getMediumAppBarExpandedHeightD9Ej5fM() {
        return MediumAppBarExpandedHeight;
    }

    /* JADX INFO: renamed from: getMediumFlexibleAppBarWithoutSubtitleExpandedHeight-D9Ej5fM, reason: not valid java name */
    public final float m4778getMediumFlexibleAppBarWithoutSubtitleExpandedHeightD9Ej5fM() {
        return MediumFlexibleAppBarWithoutSubtitleExpandedHeight;
    }

    /* JADX INFO: renamed from: getMediumFlexibleAppBarWithSubtitleExpandedHeight-D9Ej5fM, reason: not valid java name */
    public final float m4777getMediumFlexibleAppBarWithSubtitleExpandedHeightD9Ej5fM() {
        return MediumFlexibleAppBarWithSubtitleExpandedHeight;
    }

    /* JADX INFO: renamed from: getLargeAppBarCollapsedHeight-D9Ej5fM, reason: not valid java name */
    public final float m4771getLargeAppBarCollapsedHeightD9Ej5fM() {
        return LargeAppBarCollapsedHeight;
    }

    /* JADX INFO: renamed from: getLargeAppBarExpandedHeight-D9Ej5fM, reason: not valid java name */
    public final float m4772getLargeAppBarExpandedHeightD9Ej5fM() {
        return LargeAppBarExpandedHeight;
    }

    /* JADX INFO: renamed from: getLargeFlexibleAppBarWithoutSubtitleExpandedHeight-D9Ej5fM, reason: not valid java name */
    public final float m4774getLargeFlexibleAppBarWithoutSubtitleExpandedHeightD9Ej5fM() {
        return LargeFlexibleAppBarWithoutSubtitleExpandedHeight;
    }

    /* JADX INFO: renamed from: getLargeFlexibleAppBarWithSubtitleExpandedHeight-D9Ej5fM, reason: not valid java name */
    public final float m4773getLargeFlexibleAppBarWithSubtitleExpandedHeightD9Ej5fM() {
        return LargeFlexibleAppBarWithSubtitleExpandedHeight;
    }
}
