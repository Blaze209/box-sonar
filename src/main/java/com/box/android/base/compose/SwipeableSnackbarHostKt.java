package com.box.android.base.compose;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.SnackbarData;
import androidx.compose.material3.SnackbarHostKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.SnackbarKt;
import androidx.compose.material3.SwipeToDismissBoxKt;
import androidx.compose.material3.SwipeToDismissBoxState;
import androidx.compose.material3.SwipeToDismissBoxValue;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SwipeableSnackbarHost.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a\u0015\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"SwipeableSnackbarHost", "", "snackbarHostState", "Landroidx/compose/material3/SnackbarHostState;", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SwipeableSnackbar", "snackbarData", "Landroidx/compose/material3/SnackbarData;", "(Landroidx/compose/material3/SnackbarData;Landroidx/compose/runtime/Composer;I)V", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SwipeableSnackbarHostKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SwipeableSnackbar$lambda$2(SnackbarData snackbarData, int i, Composer composer, int i2) {
        SwipeableSnackbar(snackbarData, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SwipeableSnackbarHost$lambda$0(SnackbarHostState snackbarHostState, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SwipeableSnackbarHost(snackbarHostState, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void SwipeableSnackbarHost(SnackbarHostState snackbarHostState, final Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        final SnackbarHostState snackbarHostState2;
        Intrinsics.checkNotNullParameter(snackbarHostState, "snackbarHostState");
        Composer composerStartRestartGroup = composer.startRestartGroup(1200599283);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SwipeableSnackbarHost)N(snackbarHostState,modifier)26@1002L150:SwipeableSnackbarHost.kt#vejmn0");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(snackbarHostState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            snackbarHostState2 = snackbarHostState;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            Modifier modifier2 = modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1200599283, i3, -1, "com.box.android.base.compose.SwipeableSnackbarHost (SwipeableSnackbarHost.kt:25)");
            }
            snackbarHostState2 = snackbarHostState;
            SnackbarHostKt.SnackbarHost(snackbarHostState2, modifier2, ComposableSingletons$SwipeableSnackbarHostKt.INSTANCE.getLambda$42799046$base_generalProdRelease(), composerStartRestartGroup, (i3 & 14) | 384 | (i3 & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.SwipeableSnackbarHostKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SwipeableSnackbarHostKt.SwipeableSnackbarHost$lambda$0(snackbarHostState2, modifier, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SwipeableSnackbar(final SnackbarData snackbarData, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-907312149);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SwipeableSnackbar)N(snackbarData)36@1251L32,38@1331L181,38@1289L223,48@1605L257,45@1518L344:SwipeableSnackbarHost.kt#vejmn0");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(snackbarData) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-907312149, i2, -1, "com.box.android.base.compose.SwipeableSnackbar (SwipeableSnackbarHost.kt:35)");
            }
            SwipeToDismissBoxState swipeToDismissBoxStateRememberSwipeToDismissBoxState = SwipeToDismissBoxKt.rememberSwipeToDismissBoxState(null, null, composerStartRestartGroup, 0, 3);
            SwipeToDismissBoxValue settledValue = swipeToDismissBoxStateRememberSwipeToDismissBoxState.getSettledValue();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -48608960, "CC(remember):SwipeableSnackbarHost.kt#9igjgp");
            boolean zChangedInstance = ((i2 & 14) == 4) | composerStartRestartGroup.changedInstance(swipeToDismissBoxStateRememberSwipeToDismissBoxState);
            SwipeableSnackbarHostKt$SwipeableSnackbar$1$1 swipeableSnackbarHostKt$SwipeableSnackbar$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || swipeableSnackbarHostKt$SwipeableSnackbar$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                swipeableSnackbarHostKt$SwipeableSnackbar$1$1RememberedValue = new SwipeableSnackbarHostKt$SwipeableSnackbar$1$1(swipeToDismissBoxStateRememberSwipeToDismissBoxState, snackbarData, null);
                composerStartRestartGroup.updateRememberedValue(swipeableSnackbarHostKt$SwipeableSnackbar$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(settledValue, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) swipeableSnackbarHostKt$SwipeableSnackbar$1$1RememberedValue, composerStartRestartGroup, 0);
            SwipeToDismissBoxKt.SwipeToDismissBox(swipeToDismissBoxStateRememberSwipeToDismissBoxState, ComposableSingletons$SwipeableSnackbarHostKt.INSTANCE.m11623getLambda$1052744823$base_generalProdRelease(), null, false, false, false, null, ComposableLambdaKt.rememberComposableLambda(1938705679, true, new Function3() { // from class: com.box.android.base.compose.SwipeableSnackbarHostKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SwipeableSnackbarHostKt.SwipeableSnackbar$lambda$1(snackbarData, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, SwipeToDismissBoxState.$stable | 12582960, 124);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.SwipeableSnackbarHostKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SwipeableSnackbarHostKt.SwipeableSnackbar$lambda$2(snackbarData, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SwipeableSnackbar$lambda$1(SnackbarData snackbarData, RowScope SwipeToDismissBox, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(SwipeToDismissBox, "$this$SwipeToDismissBox");
        ComposerKt.sourceInformation(composer, "C51@1704L6,52@1766L6,53@1825L6,49@1615L241:SwipeableSnackbarHost.kt#vejmn0");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1938705679, i, -1, "com.box.android.base.compose.SwipeableSnackbar.<anonymous> (SwipeableSnackbarHost.kt:49)");
            }
            SnackbarKt.m4274SnackbarsDKtq54(snackbarData, null, false, null, BoxTheme.INSTANCE.getColors(composer, 6).m11556getSnackbarContainer0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, 6).m11557getSnackbarContent0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, 6).m11555getSnackbarAction0d7_KjU(), 0L, 0L, composer, 0, 398);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
