package com.box.android.base.compose.dialog;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.media3.extractor.ts.PsExtractor;
import com.box.android.base.R;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.cpl.ItemActionConfirmationReducer;
import com.box.android.cpl.Store;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxActionConfirmationDialog.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u001aI\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\u00072\b\b\u0001\u0010\n\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\u000b\u001a!\u0010\f\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007¢\u0006\u0002\u0010\r\u001a!\u0010\u000e\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007¢\u0006\u0002\u0010\r¨\u0006\u000f"}, d2 = {"ItemActionConfirmationDialog", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/base/cpl/ItemActionConfirmationReducer$State;", "Lcom/box/android/base/cpl/ItemActionConfirmationReducer$Action;", "confirmationTitle", "", "confirmationText", "confirmButton", "dismissButton", "(Lcom/box/android/cpl/Store;IIIILandroidx/compose/runtime/Composer;I)V", "EndCollaborationConfirmationDialog", "(Lcom/box/android/cpl/Store;Landroidx/compose/runtime/Composer;I)V", "DeleteItemConfirmationDialog", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxActionConfirmationDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeleteItemConfirmationDialog$lambda$0(Store store, int i, Composer composer, int i2) {
        DeleteItemConfirmationDialog(store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EndCollaborationConfirmationDialog$lambda$0(Store store, int i, Composer composer, int i2) {
        EndCollaborationConfirmationDialog(store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemActionConfirmationDialog$lambda$2(Store store, int i, int i2, int i3, int i4, int i5, Composer composer, int i6) {
        ItemActionConfirmationDialog(store, i, i2, i3, i4, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void ItemActionConfirmationDialog(final Store<ItemActionConfirmationReducer.State, ItemActionConfirmationReducer.Action> store, final int i, final int i2, final int i3, final int i4, Composer composer, final int i5) {
        int i6;
        int i7;
        Composer composer2;
        Intrinsics.checkNotNullParameter(store, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1451423695);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ItemActionConfirmationDialog)N(store,confirmationTitle,confirmationText,confirmButton,dismissButton)22@794L66,26@983L66,18@636L466:BoxActionConfirmationDialog.kt#fwd9q");
        if ((i5 & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= composerStartRestartGroup.changed(i2) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= composerStartRestartGroup.changed(i3) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i7 = i4;
            i6 |= composerStartRestartGroup.changed(i7) ? 16384 : 8192;
        } else {
            i7 = i4;
        }
        if (!composerStartRestartGroup.shouldExecute((i6 & 9363) != 9362, i6 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1451423695, i6, -1, "com.box.android.base.compose.dialog.ItemActionConfirmationDialog (BoxActionConfirmationDialog.kt:17)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1046214419, "CC(remember):BoxActionConfirmationDialog.kt#9igjgp");
            int i8 = i6 & 14;
            boolean z = i8 == 4;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.base.compose.dialog.BoxActionConfirmationDialogKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxActionConfirmationDialogKt.ItemActionConfirmationDialog$lambda$0$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ButtonItem.TextButtonItem textButtonItem = new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue, i3, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1046220467, "CC(remember):BoxActionConfirmationDialog.kt#9igjgp");
            boolean z2 = i8 == 4;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.base.compose.dialog.BoxActionConfirmationDialogKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxActionConfirmationDialogKt.ItemActionConfirmationDialog$lambda$1$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            BoxAlertDialogKt.m11705BoxAlertDialogSxpAMN0(i, i2, textButtonItem, new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue2, i7, 1, null), null, null, 0L, 0L, composer2, (i6 >> 3) & 126, PsExtractor.VIDEO_STREAM_MASK);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxActionConfirmationDialogKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxActionConfirmationDialogKt.ItemActionConfirmationDialog$lambda$2(store, i, i2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemActionConfirmationDialog$lambda$0$0(Store store) {
        store.send(ItemActionConfirmationReducer.Action.ConfirmAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemActionConfirmationDialog$lambda$1$0(Store store) {
        store.send(ItemActionConfirmationReducer.Action.DismissAction.INSTANCE);
        return Unit.INSTANCE;
    }

    public static final void EndCollaborationConfirmationDialog(Store<ItemActionConfirmationReducer.State, ItemActionConfirmationReducer.Action> store, Composer composer, final int i) {
        int i2;
        final Store<ItemActionConfirmationReducer.State, ItemActionConfirmationReducer.Action> store2;
        Intrinsics.checkNotNullParameter(store, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(861692380);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(EndCollaborationConfirmationDialog)N(store)34@1252L201:BoxActionConfirmationDialog.kt#fwd9q");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            store2 = store;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(861692380, i2, -1, "com.box.android.base.compose.dialog.EndCollaborationConfirmationDialog (BoxActionConfirmationDialog.kt:33)");
            }
            store2 = store;
            ItemActionConfirmationDialog(store2, R.string.end_collaboration_confirmation_title, R.string.end_collaboration_confirmation_text, R.string.yes, R.string.no, composerStartRestartGroup, i2 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxActionConfirmationDialogKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxActionConfirmationDialogKt.EndCollaborationConfirmationDialog$lambda$0(store2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void DeleteItemConfirmationDialog(Store<ItemActionConfirmationReducer.State, ItemActionConfirmationReducer.Action> store, Composer composer, final int i) {
        int i2;
        final Store<ItemActionConfirmationReducer.State, ItemActionConfirmationReducer.Action> store2;
        Intrinsics.checkNotNullParameter(store, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(-603310168);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DeleteItemConfirmationDialog)N(store)45@1597L179:BoxActionConfirmationDialog.kt#fwd9q");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            store2 = store;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-603310168, i2, -1, "com.box.android.base.compose.dialog.DeleteItemConfirmationDialog (BoxActionConfirmationDialog.kt:44)");
            }
            store2 = store;
            ItemActionConfirmationDialog(store2, R.string.LS_Delete_file_, R.string.delete_confirmation_question, R.string.LS_Delete, R.string.no, composerStartRestartGroup, i2 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxActionConfirmationDialogKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxActionConfirmationDialogKt.DeleteItemConfirmationDialog$lambda$0(store2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
