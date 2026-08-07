package com.microsoft.identity.common.internal.ui.webview.certbasedauth;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import com.microsoft.identity.common.R;

/* JADX INFO: loaded from: classes14.dex */
public class SmartcardNfcLoadingDialog extends SmartcardDialog {
    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardDialog
    void onUnexpectedUnplug() {
    }

    public SmartcardNfcLoadingDialog(Activity activity) {
        super(activity);
        createDialog();
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardDialog
    void createDialog() {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardNfcLoadingDialog.1
            @Override // java.lang.Runnable
            public void run() {
                AlertDialog alertDialogCreate = new AlertDialog.Builder(SmartcardNfcLoadingDialog.this.mActivity, R.style.UserChoiceAlertDialogTheme).setTitle(R.string.smartcard_nfc_loading_dialog_title).setMessage(R.string.smartcard_nfc_loading_dialog_message).setView(SmartcardNfcLoadingDialog.this.mActivity.getLayoutInflater().inflate(R.layout.nfc_loading_layout, (ViewGroup) null)).create();
                alertDialogCreate.setCanceledOnTouchOutside(false);
                SmartcardNfcLoadingDialog.this.mDialog = alertDialogCreate;
            }
        });
    }
}
