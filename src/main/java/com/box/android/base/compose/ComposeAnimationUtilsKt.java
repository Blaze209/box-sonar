package com.box.android.base.compose;

import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.SharedTransitionScope;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.unit.IntOffset;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ComposeAnimationUtils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a'\u0010\r\u001a\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000e¢\u0006\u0002\b\u00122\u0006\u0010\u0013\u001a\u00020\u0014\u001a'\u0010\u0015\u001a\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u000e¢\u0006\u0002\b\u00122\u0006\u0010\u0013\u001a\u00020\u0014\u001a\u0014\u0010\u0017\u001a\u00020\u0018*\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\"\u0019\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0019\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0004\"\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"LocalSharedTransitionScope", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/animation/SharedTransitionScope;", "getLocalSharedTransitionScope", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalNavAnimatedVisibilityScope", "Landroidx/compose/animation/AnimatedVisibilityScope;", "getLocalNavAnimatedVisibilityScope", "navigationTransitionSpec", "Landroidx/compose/animation/core/SpringSpec;", "Landroidx/compose/ui/unit/IntOffset;", "getNavigationTransitionSpec", "()Landroidx/compose/animation/core/SpringSpec;", "slidingNavGraphEnterTransition", "Lkotlin/Function1;", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "Landroidx/navigation/NavBackStackEntry;", "Landroidx/compose/animation/EnterTransition;", "Lkotlin/ExtensionFunctionType;", "graphRoute", "", "slidingNavGraphExitTransition", "Landroidx/compose/animation/ExitTransition;", "isInNavigationStack", "", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ComposeAnimationUtilsKt {
    private static final ProvidableCompositionLocal<SharedTransitionScope> LocalSharedTransitionScope = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: com.box.android.base.compose.ComposeAnimationUtilsKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ComposeAnimationUtilsKt.LocalSharedTransitionScope$lambda$0();
        }
    }, 1, null);
    private static final ProvidableCompositionLocal<AnimatedVisibilityScope> LocalNavAnimatedVisibilityScope = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: com.box.android.base.compose.ComposeAnimationUtilsKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ComposeAnimationUtilsKt.LocalNavAnimatedVisibilityScope$lambda$0();
        }
    }, 1, null);
    private static final SpringSpec<IntOffset> navigationTransitionSpec = AnimationSpecKt.spring$default(0.0f, 200.0f, IntOffset.m9806boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnimatedVisibilityScope LocalNavAnimatedVisibilityScope$lambda$0() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SharedTransitionScope LocalSharedTransitionScope$lambda$0() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int slidingNavGraphEnterTransition$lambda$0$0(int i) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int slidingNavGraphExitTransition$lambda$0$0(int i) {
        return i;
    }

    public static final ProvidableCompositionLocal<SharedTransitionScope> getLocalSharedTransitionScope() {
        return LocalSharedTransitionScope;
    }

    public static final ProvidableCompositionLocal<AnimatedVisibilityScope> getLocalNavAnimatedVisibilityScope() {
        return LocalNavAnimatedVisibilityScope;
    }

    public static final SpringSpec<IntOffset> getNavigationTransitionSpec() {
        return navigationTransitionSpec;
    }

    public static final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, EnterTransition> slidingNavGraphEnterTransition(final String graphRoute) {
        Intrinsics.checkNotNullParameter(graphRoute, "graphRoute");
        return new Function1() { // from class: com.box.android.base.compose.ComposeAnimationUtilsKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ComposeAnimationUtilsKt.slidingNavGraphEnterTransition$lambda$0(graphRoute, (AnimatedContentTransitionScope) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final EnterTransition slidingNavGraphEnterTransition$lambda$0(String str, AnimatedContentTransitionScope animatedContentTransitionScope) {
        Intrinsics.checkNotNullParameter(animatedContentTransitionScope, "<this>");
        if (isInNavigationStack((NavBackStackEntry) animatedContentTransitionScope.getInitialState(), str)) {
            return null;
        }
        return EnterExitTransitionKt.slideInHorizontally(navigationTransitionSpec, new Function1() { // from class: com.box.android.base.compose.ComposeAnimationUtilsKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(ComposeAnimationUtilsKt.slidingNavGraphEnterTransition$lambda$0$0(((Integer) obj).intValue()));
            }
        });
    }

    public static final Function1<AnimatedContentTransitionScope<NavBackStackEntry>, ExitTransition> slidingNavGraphExitTransition(final String graphRoute) {
        Intrinsics.checkNotNullParameter(graphRoute, "graphRoute");
        return new Function1() { // from class: com.box.android.base.compose.ComposeAnimationUtilsKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ComposeAnimationUtilsKt.slidingNavGraphExitTransition$lambda$0(graphRoute, (AnimatedContentTransitionScope) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final ExitTransition slidingNavGraphExitTransition$lambda$0(String str, AnimatedContentTransitionScope animatedContentTransitionScope) {
        Intrinsics.checkNotNullParameter(animatedContentTransitionScope, "<this>");
        if (isInNavigationStack((NavBackStackEntry) animatedContentTransitionScope.getTargetState(), str)) {
            return null;
        }
        return EnterExitTransitionKt.slideOutHorizontally(navigationTransitionSpec, new Function1() { // from class: com.box.android.base.compose.ComposeAnimationUtilsKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(ComposeAnimationUtilsKt.slidingNavGraphExitTransition$lambda$0$0(((Integer) obj).intValue()));
            }
        });
    }

    private static final boolean isInNavigationStack(NavBackStackEntry navBackStackEntry, String str) {
        Iterator<NavDestination> it = NavDestination.INSTANCE.getHierarchy(navBackStackEntry.getDestination()).iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next().getRoute(), str)) {
                return true;
            }
        }
        return false;
    }
}
