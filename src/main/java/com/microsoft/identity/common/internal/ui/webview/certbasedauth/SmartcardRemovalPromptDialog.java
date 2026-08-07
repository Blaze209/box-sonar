package com.microsoft.identity.common.internal.ui.webview.certbasedauth;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.microsoft.identity.common.R;
import com.microsoft.intune.mam.client.app.MAMAlertDialogBuilder;

/* JADX INFO: loaded from: classes14.dex */
public class SmartcardRemovalPromptDialog extends SmartcardDialog {
    private final IDismissCallback mDismissCallback;

    public SmartcardRemovalPromptDialog(IDismissCallback iDismissCallback, Activity activity) {
        super(activity);
        this.mDismissCallback = iDismissCallback;
        createDialog();
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardDialog
    void createDialog() {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardRemovalPromptDialog.1
            @Override // java.lang.Runnable
            public void run() {
                AlertDialog alertDialogCreate = new MAMAlertDialogBuilder(SmartcardRemovalPromptDialog.this.mActivity, R.style.TitleOnlyAlertDialogTheme).setTitle(R.string.smartcard_removal_prompt_dialog_title).setPositiveButton(R.string.smartcard_removal_prompt_dialog_positive_button, new DialogInterface.OnClickListener() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardRemovalPromptDialog.1.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        SmartcardRemovalPromptDialog.this.mDismissCallback.onDismiss();
                    }
                }).create();
                alertDialogCreate.setCanceledOnTouchOutside(false);
                SmartcardRemovalPromptDialog.this.mDialog = alertDialogCreate;
            }
        });
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardDialog
    void onUnexpectedUnplug() {
        this.mDismissCallback.onDismiss();
    }
}
