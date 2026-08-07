package com.microsoft.identity.common.internal.ui.webview.certbasedauth;

import android.app.Activity;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.microsoft.identity.common.R;

/* JADX INFO: loaded from: classes14.dex */
public class SmartcardNfcPromptDialog extends SmartcardDialog {
    private final ICancelCbaCallback mCancelCbaCallback;

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardDialog
    void onUnexpectedUnplug() {
    }

    public SmartcardNfcPromptDialog(ICancelCbaCallback iCancelCbaCallback, Activity activity) {
        super(activity);
        if (iCancelCbaCallback == null) {
            throw new NullPointerException("cancelCbaCallback is marked non-null but is null");
        }
        if (activity == null) {
            throw new NullPointerException("activity is marked non-null but is null");
        }
        this.mCancelCbaCallback = iCancelCbaCallback;
        createDialog();
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardDialog
    void createDialog() {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardNfcPromptDialog.1
            @Override // java.lang.Runnable
            public void run() {
                AlertDialog alertDialogCreate = new AlertDialog.Builder(SmartcardNfcPromptDialog.this.mActivity, R.style.UserChoiceAlertDialogTheme).setTitle(R.string.smartcard_nfc_prompt_dialog_title).setMessage(R.string.smartcard_nfc_prompt_dialog_message).setNegativeButton(R.string.smartcard_nfc_prompt_dialog_negative_button, new DialogInterface.OnClickListener() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardNfcPromptDialog.1.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        SmartcardNfcPromptDialog.this.mCancelCbaCallback.onCancel();
                    }
                }).create();
                alertDialogCreate.setCanceledOnTouchOutside(false);
                SmartcardNfcPromptDialog.this.mDialog = alertDialogCreate;
            }
        });
    }
}
