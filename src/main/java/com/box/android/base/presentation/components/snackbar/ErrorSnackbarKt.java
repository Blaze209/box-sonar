package com.box.android.base.presentation.components.snackbar;

import androidx.compose.material3.SnackbarDuration;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.res.StringResources_androidKt;
import com.box.android.base.R;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.DomainErrorKt;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenDismissEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ErrorSnackbar.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"ErrorSnackbar", "", "error", "Lcom/box/android/domain/models/DomainError;", "snackbarHostState", "Landroidx/compose/material3/SnackbarHostState;", "onNetworkErrorRetry", "Lkotlin/Function0;", StackScreenDismissEvent.EVENT_REGISTRATION_NAME, "(Lcom/box/android/domain/models/DomainError;Landroidx/compose/material3/SnackbarHostState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ErrorSnackbarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ErrorSnackbar$lambda$1(DomainError domainError, SnackbarHostState snackbarHostState, Function0 function0, Function0 function1, int i, Composer composer, int i2) {
        ErrorSnackbar(domainError, snackbarHostState, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ErrorSnackbar(final DomainError error, final SnackbarHostState snackbarHostState, final Function0<Unit> onNetworkErrorRetry, final Function0<Unit> onDismiss, Composer composer, final int i) {
        int i2;
        String strStringResource;
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(snackbarHostState, "snackbarHostState");
        Intrinsics.checkNotNullParameter(onNetworkErrorRetry, "onNetworkErrorRetry");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer composerStartRestartGroup = composer.startRestartGroup(511321205);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ErrorSnackbar)N(error,snackbarHostState,onNetworkErrorRetry,onDismiss)25@959L131,31@1317L370,31@1295L392:ErrorSnackbar.kt#hzn1l5");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(error) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(snackbarHostState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onNetworkErrorRetry) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onDismiss) ? 2048 : 1024;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(511321205, i3, -1, "com.box.android.base.presentation.components.snackbar.ErrorSnackbar (ErrorSnackbar.kt:23)");
            }
            boolean zIsNetworkConnectionError = DomainErrorKt.isNetworkConnectionError(error);
            String strStringResource2 = StringResources_androidKt.stringResource(zIsNetworkConnectionError ? R.string.boxsdk_error_network_connection : R.string.box_sharesdk_generic_error, composerStartRestartGroup, 0);
            if (zIsNetworkConnectionError) {
                composerStartRestartGroup.startReplaceGroup(1753419176);
                ComposerKt.sourceInformation(composerStartRestartGroup, "28@1133L51");
                strStringResource = StringResources_androidKt.stringResource(R.string.box_browsesdk_tap_to_retry, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1478525304);
                composerStartRestartGroup.endReplaceGroup();
                strStringResource = null;
            }
            SnackbarDuration snackbarDuration = zIsNetworkConnectionError ? SnackbarDuration.Indefinite : SnackbarDuration.Short;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1753425383, "CC(remember):ErrorSnackbar.kt#9igjgp");
            boolean zChanged = ((i3 & 112) == 32) | composerStartRestartGroup.changed(strStringResource2) | composerStartRestartGroup.changed(strStringResource) | composerStartRestartGroup.changed(snackbarDuration.ordinal()) | ((i3 & 896) == 256) | ((i3 & 7168) == 2048);
            ErrorSnackbarKt$ErrorSnackbar$1$1 errorSnackbarKt$ErrorSnackbar$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || errorSnackbarKt$ErrorSnackbar$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                errorSnackbarKt$ErrorSnackbar$1$1RememberedValue = new ErrorSnackbarKt$ErrorSnackbar$1$1(snackbarHostState, strStringResource2, strStringResource, snackbarDuration, onNetworkErrorRetry, onDismiss, null);
                composerStartRestartGroup.updateRememberedValue(errorSnackbarKt$ErrorSnackbar$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(error, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) errorSnackbarKt$ErrorSnackbar$1$1RememberedValue, composerStartRestartGroup, i3 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.snackbar.ErrorSnackbarKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ErrorSnackbarKt.ErrorSnackbar$lambda$1(error, snackbarHostState, onNetworkErrorRetry, onDismiss, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
