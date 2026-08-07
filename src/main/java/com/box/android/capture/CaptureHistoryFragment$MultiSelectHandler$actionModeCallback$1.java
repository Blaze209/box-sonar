package com.box.android.capture;

import android.content.DialogInterface;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AlertDialog;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.base.presentation.presenters.BaseListingPresenter;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.models.CaptureHistoryModel;
import com.box.android.observability.DiagnosisParams;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: CaptureHistoryFragment.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0002¨\u0006\u000f"}, d2 = {"com/box/android/capture/CaptureHistoryFragment$MultiSelectHandler$actionModeCallback$1", "Landroid/view/ActionMode$Callback;", "onCreateActionMode", "", DiagnosisParams.DIAGNOSIS_MODE, "Landroid/view/ActionMode;", "menu", "Landroid/view/Menu;", "onPrepareActionMode", "onActionItemClicked", "item", "Landroid/view/MenuItem;", "onDestroyActionMode", "", "showDeleteConfirmation", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CaptureHistoryFragment$MultiSelectHandler$actionModeCallback$1 implements ActionMode.Callback {
    final /* synthetic */ CaptureHistoryFragment.MultiSelectHandler this$0;
    final /* synthetic */ CaptureHistoryFragment this$1;

    CaptureHistoryFragment$MultiSelectHandler$actionModeCallback$1(CaptureHistoryFragment.MultiSelectHandler multiSelectHandler, CaptureHistoryFragment captureHistoryFragment) {
        this.this$0 = multiSelectHandler;
        this.this$1 = captureHistoryFragment;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(menu, "menu");
        mode.getMenuInflater().inflate(R.menu.capture_history_batch, menu);
        this.this$0.setMultiSelectEnabled(true);
        return true;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(menu, "menu");
        menu.findItem(R.id.delete_menu_item).setVisible(this.this$0.isAtLeastOneItemSelected());
        int size = this.this$0.selectedItems.size();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(CommonBoxUtil.plural(R.array.n_items_selected, size), Arrays.copyOf(new Object[]{Integer.valueOf(size)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        mode.setTitle(str);
        return true;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() != R.id.delete_menu_item || !this.this$0.isAtLeastOneItemSelected()) {
            return false;
        }
        showDeleteConfirmation();
        return true;
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode mode) {
        this.this$0.setMultiSelectEnabled(false);
        this.this$0.actionMode = null;
    }

    private final void showDeleteConfirmation() {
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(this.this$1.requireContext());
        materialAlertDialogBuilder.setMessage(R.string.cannot_be_undone);
        materialAlertDialogBuilder.setTitle(R.string.delete_confirmation_question);
        int i = R.string.LS_Delete;
        final CaptureHistoryFragment captureHistoryFragment = this.this$1;
        final CaptureHistoryFragment.MultiSelectHandler multiSelectHandler = this.this$0;
        materialAlertDialogBuilder.setPositiveButton(i, new DialogInterface.OnClickListener() { // from class: com.box.android.capture.CaptureHistoryFragment$MultiSelectHandler$actionModeCallback$1$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                CaptureHistoryFragment$MultiSelectHandler$actionModeCallback$1.showDeleteConfirmation$lambda$0(captureHistoryFragment, multiSelectHandler, dialogInterface, i2);
            }
        });
        materialAlertDialogBuilder.setNegativeButton(R.string.alert_dialog_cancel, new DialogInterface.OnClickListener() { // from class: com.box.android.capture.CaptureHistoryFragment$MultiSelectHandler$actionModeCallback$1$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialogCreate = materialAlertDialogBuilder.create();
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "create(...)");
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDeleteConfirmation$lambda$0(CaptureHistoryFragment captureHistoryFragment, CaptureHistoryFragment.MultiSelectHandler multiSelectHandler, DialogInterface dialogInterface, int i) {
        BaseListingPresenter presenter = captureHistoryFragment.getPresenter();
        Intrinsics.checkNotNull(presenter, "null cannot be cast to non-null type com.box.android.capture.CaptureHistoryPresenter");
        ((CaptureHistoryPresenter) presenter).deleteCaptureHistoryItems(multiSelectHandler.selectedItems);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(CommonBoxUtil.plural(R.array.Deleting_item_and_n_other_items, multiSelectHandler.selectedItems.size() - 1), Arrays.copyOf(new Object[]{((CaptureHistoryModel) CollectionsKt.first(multiSelectHandler.selectedItems)).getFileModel().getName(), Integer.valueOf(multiSelectHandler.selectedItems.size() - 1)}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        BoxPresentationUtils.displayToast(str, captureHistoryFragment.getContext());
        ActionMode actionMode = multiSelectHandler.actionMode;
        if (actionMode != null) {
            actionMode.finish();
        }
        dialogInterface.dismiss();
    }
}
