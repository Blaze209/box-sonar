package com.microsoft.identity.common.internal.ui.webview.certbasedauth;

import android.app.Activity;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.microsoft.identity.common.R;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes14.dex */
public class UserChoiceDialog extends SmartcardDialog {
    private final ICancelCbaCallback mCancelCbaCallback;
    private final PositiveButtonListener mPositiveButtonListener;

    public interface PositiveButtonListener {
        void onClick(int i);
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardDialog
    void onUnexpectedUnplug() {
    }

    public UserChoiceDialog(PositiveButtonListener positiveButtonListener, ICancelCbaCallback iCancelCbaCallback, Activity activity) {
        super(activity);
        this.mPositiveButtonListener = positiveButtonListener;
        this.mCancelCbaCallback = iCancelCbaCallback;
        createDialog();
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardDialog
    void createDialog() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mActivity.getResources().getString(R.string.user_choice_dialog_on_device_name));
        arrayList.add(this.mActivity.getResources().getString(R.string.user_choice_dialog_smartcard_name));
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this.mActivity, R.style.UserChoiceAlertDialogTheme).setTitle(R.string.user_choice_dialog_title).setSingleChoiceItems((String[]) Arrays.copyOf(arrayList.toArray(), arrayList.size(), String[].class), 0, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.user_choice_dialog_positive_button, new DialogInterface.OnClickListener() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.UserChoiceDialog.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                UserChoiceDialog.this.mPositiveButtonListener.onClick(((AlertDialog) dialogInterface).getListView().getCheckedItemPosition());
            }
        }).setNegativeButton(R.string.user_choice_dialog_negative_button, new DialogInterface.OnClickListener() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.UserChoiceDialog.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                UserChoiceDialog.this.mCancelCbaCallback.onCancel();
            }
        }).create();
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.UserChoiceDialog.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                UserChoiceDialog.this.mCancelCbaCallback.onCancel();
            }
        });
        this.mDialog = alertDialogCreate;
    }
}
