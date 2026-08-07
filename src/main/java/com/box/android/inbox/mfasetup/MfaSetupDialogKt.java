package com.box.android.inbox.mfasetup;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.box.android.R;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.dialog.BoxAlertDialogKt;
import com.box.android.cpl.Store;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MfaSetupDialog.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"MfaSetupDialog", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/inbox/mfasetup/MfaSetupDialogReducer$State;", "Lcom/box/android/inbox/mfasetup/MfaSetupDialogReducer$Action;", "(Lcom/box/android/cpl/Store;Landroidx/compose/runtime/Composer;I)V", "box_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class MfaSetupDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MfaSetupDialog$lambda$4(Store store, int i, Composer composer, int i2) {
        MfaSetupDialog(store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void MfaSetupDialog(final Store<MfaSetupDialogReducer.State, MfaSetupDialogReducer.Action> store, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(store, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(442069253);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MfaSetupDialog)N(store)14@566L7,16@600L65,16@579L86,24@870L99,30@1118L79,35@1288L72,20@671L695:MfaSetupDialog.kt#jt25ik");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(442069253, i2, -1, "com.box.android.inbox.mfasetup.MfaSetupDialog (MfaSetupDialog.kt:13)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Context context = (Context) objConsume;
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -373205018, "CC(remember):MfaSetupDialog.kt#9igjgp");
            int i3 = i2 & 14;
            boolean z = i3 == 4;
            MfaSetupDialogKt$MfaSetupDialog$1$1 mfaSetupDialogKt$MfaSetupDialog$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || mfaSetupDialogKt$MfaSetupDialog$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                mfaSetupDialogKt$MfaSetupDialog$1$1RememberedValue = new MfaSetupDialogKt$MfaSetupDialog$1$1(store, null);
                composerStartRestartGroup.updateRememberedValue(mfaSetupDialogKt$MfaSetupDialog$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) mfaSetupDialogKt$MfaSetupDialog$1$1RememberedValue, composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -373196344, "CC(remember):MfaSetupDialog.kt#9igjgp");
            boolean zChangedInstance = (i3 == 4) | composerStartRestartGroup.changedInstance(context);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.inbox.mfasetup.MfaSetupDialogKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MfaSetupDialogKt.MfaSetupDialog$lambda$1$0(store, context);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ButtonItem.TextButtonItem textButtonItem = new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue, R.string.inbox_mfa_setup_alert_positive, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -373188428, "CC(remember):MfaSetupDialog.kt#9igjgp");
            boolean z2 = i3 == 4;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.inbox.mfasetup.MfaSetupDialogKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MfaSetupDialogKt.MfaSetupDialog$lambda$2$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ButtonItem.TextButtonItem textButtonItem2 = new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue2, R.string.boxsdk_alert_dialog_cancel, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -373182995, "CC(remember):MfaSetupDialog.kt#9igjgp");
            boolean z3 = i3 == 4;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.box.android.inbox.mfasetup.MfaSetupDialogKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MfaSetupDialogKt.MfaSetupDialog$lambda$3$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxAlertDialogKt.m11705BoxAlertDialogSxpAMN0(R.string.inbox_mfa_setup_alert_title, R.string.inbox_mfa_setup_alert_message, textButtonItem, textButtonItem2, null, (Function0) objRememberedValue3, 0L, 0L, composerStartRestartGroup, 54, 208);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.mfasetup.MfaSetupDialogKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MfaSetupDialogKt.MfaSetupDialog$lambda$4(store, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MfaSetupDialog$lambda$1$0(Store store, Context context) {
        store.send(new MfaSetupDialogReducer.Action.NavigateToBrowser(context));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MfaSetupDialog$lambda$2$0(Store store) {
        store.send(MfaSetupDialogReducer.Action.Cancel.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MfaSetupDialog$lambda$3$0(Store store) {
        store.send(MfaSetupDialogReducer.Action.Dismiss.INSTANCE);
        return Unit.INSTANCE;
    }
}
