package com.microsoft.identity.common.internal.ui.webview.certbasedauth;

import android.app.Activity;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.microsoft.identity.common.R;

/* JADX INFO: loaded from: classes14.dex */
public class SmartcardNfcReminderDialog extends SmartcardDialog {
    private final IDismissCallback mDismissCallback;

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardDialog
    void onUnexpectedUnplug() {
    }

    public SmartcardNfcReminderDialog(IDismissCallback iDismissCallback, Activity activity) {
        super(activity);
        this.mDismissCallback = iDismissCallback;
        createDialog();
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardDialog
    void createDialog() {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardNfcReminderDialog.1
            @Override // java.lang.Runnable
            public void run() {
                AlertDialog alertDialogCreate = new AlertDialog.Builder(SmartcardNfcReminderDialog.this.mActivity, R.style.UserChoiceAlertDialogTheme).setTitle(R.string.smartcard_nfc_reminder_dialog_title).setMessage(R.string.smartcard_nfc_reminder_dialog_message).setPositiveButton(R.string.smartcard_nfc_reminder_dialog_positive_button, new DialogInterface.OnClickListener() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardNfcReminderDialog.1.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        SmartcardNfcReminderDialog.this.mDismissCallback.onDismiss();
                    }
                }).create();
                alertDialogCreate.setCanceledOnTouchOutside(false);
                alertDialogCreate.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardNfcReminderDialog.1.2
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        SmartcardNfcReminderDialog.this.mDismissCallback.onDismiss();
                    }
                });
                SmartcardNfcReminderDialog.this.mDialog = alertDialogCreate;
            }
        });
    }
}
