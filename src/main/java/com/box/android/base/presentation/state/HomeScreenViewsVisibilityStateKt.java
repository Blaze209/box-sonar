package com.box.android.base.presentation.state;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: HomeScreenViewsVisibilityState.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a!\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"rememberHomeScreenViewsVisibilityState", "Lcom/box/android/base/presentation/state/HomeScreenViewsVisibilityState;", "initialPrimaryTabRowVisible", "", "initialNavigationBarVisible", "(ZZLandroidx/compose/runtime/Composer;II)Lcom/box/android/base/presentation/state/HomeScreenViewsVisibilityState;", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class HomeScreenViewsVisibilityStateKt {
    public static final HomeScreenViewsVisibilityState rememberHomeScreenViewsVisibilityState(final boolean z, final boolean z2, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1044960716, "C(rememberHomeScreenViewsVisibilityState)N(initialPrimaryTabRowVisible,initialNavigationBarVisible)20@958L178,20@895L241:HomeScreenViewsVisibilityState.kt#skrrzf");
        boolean z3 = true;
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1044960716, i, -1, "com.box.android.base.presentation.state.rememberHomeScreenViewsVisibilityState (HomeScreenViewsVisibilityState.kt:20)");
        }
        Object[] objArr = new Object[0];
        Saver<HomeScreenViewsVisibilityState, Pair<Boolean, Boolean>> saver = HomeScreenViewsVisibilityState.INSTANCE.getSaver();
        ComposerKt.sourceInformationMarkerStart(composer, -815091330, "CC(remember):HomeScreenViewsVisibilityState.kt#9igjgp");
        boolean z4 = (((i & 14) ^ 6) > 4 && composer.changed(z)) || (i & 6) == 4;
        if ((((i & 112) ^ 48) <= 32 || !composer.changed(z2)) && (i & 48) != 32) {
            z3 = false;
        }
        boolean z5 = z4 | z3;
        Object objRememberedValue = composer.rememberedValue();
        if (z5 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.box.android.base.presentation.state.HomeScreenViewsVisibilityStateKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return HomeScreenViewsVisibilityStateKt.rememberHomeScreenViewsVisibilityState$lambda$0$0(z, z2);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        HomeScreenViewsVisibilityState homeScreenViewsVisibilityState = (HomeScreenViewsVisibilityState) RememberSaveableKt.m6247rememberSaveable(objArr, (Saver) saver, (Function0) objRememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return homeScreenViewsVisibilityState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HomeScreenViewsVisibilityState rememberHomeScreenViewsVisibilityState$lambda$0$0(boolean z, boolean z2) {
        return new HomeScreenViewsVisibilityState(z, z2);
    }
}
