package com.microsoft.identity.common.internal.ui.webview.certbasedauth;

import android.app.Activity;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.microsoft.identity.common.R;

/* JADX INFO: loaded from: classes14.dex */
public class SmartcardErrorDialog extends SmartcardDialog {
    private final int mDismissButtonStringResourceId;
    private final IDismissCallback mDismissCallback;
    private final int mMessageStringResourceId;
    private final int mTitleStringResourceId;

    public SmartcardErrorDialog(int i, int i2, int i3, IDismissCallback iDismissCallback, Activity activity) {
        super(activity);
        this.mTitleStringResourceId = i;
        this.mMessageStringResourceId = i2;
        this.mDismissButtonStringResourceId = i3;
        this.mDismissCallback = iDismissCallback;
        createDialog();
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardDialog
    protected void createDialog() {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardErrorDialog.1
            @Override // java.lang.Runnable
            public void run() {
                AlertDialog alertDialogCreate = new AlertDialog.Builder(SmartcardErrorDialog.this.mActivity, R.style.ErrorAlertDialogTheme).setTitle(SmartcardErrorDialog.this.mTitleStringResourceId).setMessage(SmartcardErrorDialog.this.mMessageStringResourceId).setPositiveButton(SmartcardErrorDialog.this.mDismissButtonStringResourceId, new DialogInterface.OnClickListener() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardErrorDialog.1.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        SmartcardErrorDialog.this.mDismissCallback.onDismiss();
                    }
                }).create();
                alertDialogCreate.setCanceledOnTouchOutside(false);
                alertDialogCreate.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardErrorDialog.1.2
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        SmartcardErrorDialog.this.mDismissCallback.onDismiss();
                    }
                });
                SmartcardErrorDialog.this.mDialog = alertDialogCreate;
            }
        });
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardDialog
    void onUnexpectedUnplug() {
        this.mDismissCallback.onDismiss();
    }
}
