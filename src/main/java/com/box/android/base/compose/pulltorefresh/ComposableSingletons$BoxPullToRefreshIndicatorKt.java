package com.box.android.base.compose.pulltorefresh;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.pulltorefresh.PullToRefreshKt;
import androidx.compose.material3.pulltorefresh.PullToRefreshState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import com.box.android.base.compose.BoxTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: BoxPullToRefreshIndicator.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$BoxPullToRefreshIndicatorKt {
    public static final ComposableSingletons$BoxPullToRefreshIndicatorKt INSTANCE = new ComposableSingletons$BoxPullToRefreshIndicatorKt();

    /* JADX INFO: renamed from: lambda$-1749201142, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f181lambda$1749201142 = ComposableLambdaKt.composableLambdaInstance(-1749201142, false, new Function2() { // from class: com.box.android.base.compose.pulltorefresh.ComposableSingletons$BoxPullToRefreshIndicatorKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxPullToRefreshIndicatorKt.lambda__1749201142$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1749201142$base_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m11738getLambda$1749201142$base_generalProdRelease() {
        return f181lambda$1749201142;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1749201142$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C55@2284L28,56@2341L54,63@2525L6,67@2708L23,69@2760L521,60@2405L876,85@3320L122,85@3291L151:BoxPullToRefreshIndicator.kt#1dt47l");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1749201142, i, -1, "com.box.android.base.compose.pulltorefresh.ComposableSingletons$BoxPullToRefreshIndicatorKt.lambda$-1749201142.<anonymous> (BoxPullToRefreshIndicator.kt:55)");
            }
            final PullToRefreshState pullToRefreshStateRememberPullToRefreshState = PullToRefreshKt.rememberPullToRefreshState(composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1650081728, "CC(remember):BoxPullToRefreshIndicator.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), BoxTheme.INSTANCE.getColors(composer, 6).m11498getAppBackground0d7_KjU(), null, 2, null);
            boolean zLambda__1749201142$lambda$0$1 = lambda__1749201142$lambda$0$1(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, -1650070015, "CC(remember):BoxPullToRefreshIndicator.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.base.compose.pulltorefresh.ComposableSingletons$BoxPullToRefreshIndicatorKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$BoxPullToRefreshIndicatorKt.lambda__1749201142$lambda$0$3$0(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxWithConstraintsKt.BoxWithConstraints(PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(modifierM589backgroundbw27NRU$default, zLambda__1749201142$lambda$0$1, pullToRefreshStateRememberPullToRefreshState, false, 0.0f, (Function0) objRememberedValue2, 12, null), null, false, ComposableLambdaKt.rememberComposableLambda(-58745504, true, new Function3() { // from class: com.box.android.base.compose.pulltorefresh.ComposableSingletons$BoxPullToRefreshIndicatorKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ComposableSingletons$BoxPullToRefreshIndicatorKt.lambda__1749201142$lambda$0$4(pullToRefreshStateRememberPullToRefreshState, mutableState, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 3072, 6);
            Boolean boolValueOf = Boolean.valueOf(lambda__1749201142$lambda$0$1(mutableState));
            ComposerKt.sourceInformationMarkerStart(composer, -1650050332, "CC(remember):BoxPullToRefreshIndicator.kt#9igjgp");
            ComposableSingletons$BoxPullToRefreshIndicatorKt$lambda$1749201142$1$3$1 composableSingletons$BoxPullToRefreshIndicatorKt$lambda$1749201142$1$3$1RememberedValue = composer.rememberedValue();
            if (composableSingletons$BoxPullToRefreshIndicatorKt$lambda$1749201142$1$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                composableSingletons$BoxPullToRefreshIndicatorKt$lambda$1749201142$1$3$1RememberedValue = new ComposableSingletons$BoxPullToRefreshIndicatorKt$lambda$1749201142$1$3$1(mutableState, null);
                composer.updateRememberedValue(composableSingletons$BoxPullToRefreshIndicatorKt$lambda$1749201142$1$3$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) composableSingletons$BoxPullToRefreshIndicatorKt$lambda$1749201142$1$3$1RememberedValue, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean lambda__1749201142$lambda$0$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lambda__1749201142$lambda$0$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1749201142$lambda$0$3$0(MutableState mutableState) {
        lambda__1749201142$lambda$0$2(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1749201142$lambda$0$4(PullToRefreshState pullToRefreshState, MutableState mutableState, BoxWithConstraintsScope BoxWithConstraints, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation(composer, "C75@3029L21,71@2853L212,78@3079L192:BoxPullToRefreshIndicator.kt#1dt47l");
        if ((i & 6) == 0) {
            i |= composer.changed(BoxWithConstraints) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-58745504, i, -1, "com.box.android.base.compose.pulltorefresh.ComposableSingletons$BoxPullToRefreshIndicatorKt.lambda$-1749201142.<anonymous>.<anonymous> (BoxPullToRefreshIndicator.kt:71)");
            }
            BoxKt.Box(ScrollKt.verticalScroll$default(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), BoxWithConstraints.mo1100getMaxHeightD9Ej5fM()), ScrollKt.rememberScrollState(0, composer, 0, 1), false, null, false, 14, null), composer, 0);
            BoxPullToRefreshIndicatorKt.BoxPullToRefreshIndicator(pullToRefreshState, lambda__1749201142$lambda$0$1(mutableState), BoxWithConstraints.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
