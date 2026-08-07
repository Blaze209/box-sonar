package com.box.android.preview.annotations.ui.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.dialog.BoxAlertDialogKt;
import com.box.android.preview.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PendingAnnotationsConfirmationDialog.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"PendingAnnotationsConfirmationDialog", "", "exitOrSwitch", "Lkotlin/Function0;", "cancelExitOrSwitch", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "preview_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PendingAnnotationsConfirmationDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PendingAnnotationsConfirmationDialog$lambda$0(Function0 function0, Function0 function1, int i, Composer composer, int i2) {
        PendingAnnotationsConfirmationDialog(function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void PendingAnnotationsConfirmationDialog(Function0<Unit> exitOrSwitch, Function0<Unit> cancelExitOrSwitch, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function0;
        final Function0<Unit> function1;
        Composer composer2;
        Intrinsics.checkNotNullParameter(exitOrSwitch, "exitOrSwitch");
        Intrinsics.checkNotNullParameter(cancelExitOrSwitch, "cancelExitOrSwitch");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1718083779);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PendingAnnotationsConfirmationDialog)N(exitOrSwitch,cancelExitOrSwitch)10@400L518:PendingAnnotationsConfirmationDialog.kt#sozp7t");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(exitOrSwitch) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(cancelExitOrSwitch) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            function0 = exitOrSwitch;
            function1 = cancelExitOrSwitch;
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1718083779, i2, -1, "com.box.android.preview.annotations.ui.compose.PendingAnnotationsConfirmationDialog (PendingAnnotationsConfirmationDialog.kt:9)");
            }
            composer2 = composerStartRestartGroup;
            function1 = cancelExitOrSwitch;
            function0 = exitOrSwitch;
            BoxAlertDialogKt.m11705BoxAlertDialogSxpAMN0(R.string.clear_drawing_alert_header, R.string.clear_drawing_alert_body, new ButtonItem.TextButtonItem(false, exitOrSwitch, R.string.clear_drawing_alert_button_text, 1, null), new ButtonItem.TextButtonItem(false, function1, R.string.clear_drawing_alert_cancel_button_text, 1, null), "PendingAnnotationsConfirmationDialog", null, 0L, 0L, composer2, 24576, 224);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.annotations.ui.compose.PendingAnnotationsConfirmationDialogKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PendingAnnotationsConfirmationDialogKt.PendingAnnotationsConfirmationDialog$lambda$0(function0, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
