package com.box.android.base.presentation.components.fileactions;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.box.android.base.R;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.dialog.BoxAlertDialogKt;
import com.box.android.cpl.Store;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OfflineLargeFileErrorDialog.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"OfflineLargeFileErrorDialog", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/base/presentation/components/fileactions/OfflineFilesReducer$State;", "Lcom/box/android/base/presentation/components/fileactions/OfflineFilesReducer$Action;", "(Lcom/box/android/cpl/Store;Landroidx/compose/runtime/Composer;I)V", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class OfflineLargeFileErrorDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineLargeFileErrorDialog$lambda$3(Store store, int i, Composer composer, int i2) {
        OfflineLargeFileErrorDialog(store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void OfflineLargeFileErrorDialog(final Store<OfflineFilesReducer.State, OfflineFilesReducer.Action> store, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(store, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(-630078730);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OfflineLargeFileErrorDialog)N(store)16@727L157,24@1021L156,14@602L49,11@442L808:OfflineLargeFileErrorDialog.kt#ql6oa9");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-630078730, i2, -1, "com.box.android.base.presentation.components.fileactions.OfflineLargeFileErrorDialog (OfflineLargeFileErrorDialog.kt:10)");
            }
            int i3 = i2;
            int i4 = R.string.save_for_offline_access_dialog_title;
            int i5 = R.string.save_for_offline_access_dialog_text;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 84741907, "CC(remember):OfflineLargeFileErrorDialog.kt#9igjgp");
            int i6 = i3 & 14;
            boolean z = i6 == 4;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.base.presentation.components.fileactions.OfflineLargeFileErrorDialogKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return OfflineLargeFileErrorDialogKt.OfflineLargeFileErrorDialog$lambda$0$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ButtonItem.TextButtonItem textButtonItem = new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue, R.string.use_preview_button, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 84751314, "CC(remember):OfflineLargeFileErrorDialog.kt#9igjgp");
            boolean z2 = i6 == 4;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.components.fileactions.OfflineLargeFileErrorDialogKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return OfflineLargeFileErrorDialogKt.OfflineLargeFileErrorDialog$lambda$1$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ButtonItem.TextButtonItem textButtonItem2 = new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue2, R.string.download_original_button, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 84737799, "CC(remember):OfflineLargeFileErrorDialog.kt#9igjgp");
            boolean z3 = i6 == 4;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.components.fileactions.OfflineLargeFileErrorDialogKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return OfflineLargeFileErrorDialogKt.OfflineLargeFileErrorDialog$lambda$2$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxAlertDialogKt.m11705BoxAlertDialogSxpAMN0(i4, i5, textButtonItem2, textButtonItem, null, (Function0) objRememberedValue3, 0L, 0L, composerStartRestartGroup, 0, 208);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.fileactions.OfflineLargeFileErrorDialogKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OfflineLargeFileErrorDialogKt.OfflineLargeFileErrorDialog$lambda$3(store, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineLargeFileErrorDialog$lambda$2$0(Store store) {
        store.send(OfflineFilesReducer.Action.Finish.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineLargeFileErrorDialog$lambda$0$0(Store store) {
        store.send(new OfflineFilesReducer.Action.MakeAvailableOffline(false));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineLargeFileErrorDialog$lambda$1$0(Store store) {
        store.send(new OfflineFilesReducer.Action.MakeAvailableOffline(true));
        return Unit.INSTANCE;
    }
}
