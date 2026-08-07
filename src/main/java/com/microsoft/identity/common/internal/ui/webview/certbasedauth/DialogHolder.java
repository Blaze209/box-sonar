package com.microsoft.identity.common.internal.ui.webview.certbasedauth;

import android.app.Activity;
import android.view.WindowManager;
import com.microsoft.identity.common.R;
import com.microsoft.identity.common.logging.Logger;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public class DialogHolder implements IDialogHolder {
    private final Activity mActivity;
    private final String TAG = "DialogHolder";
    private SmartcardDialog mCurrentDialog = null;

    public DialogHolder(Activity activity) {
        this.mActivity = activity;
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.IDialogHolder
    public synchronized void showCertPickerDialog(List<ICertDetails> list, SmartcardCertPickerDialog.PositiveButtonListener positiveButtonListener, ICancelCbaCallback iCancelCbaCallback) {
        try {
            showDialog(new SmartcardCertPickerDialog(list, positiveButtonListener, iCancelCbaCallback, this.mActivity));
        } catch (WindowManager.BadTokenException e) {
            Logger.error(this.TAG + ":showCertPickerDialog", "Failed to show CertPickerDialog due to BadTokenException. Activity may be finishing or destroyed.", e);
            iCancelCbaCallback.onCancel();
        }
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.IDialogHolder
    public synchronized void showPinDialog(SmartcardPinDialog.PositiveButtonListener positiveButtonListener, ICancelCbaCallback iCancelCbaCallback) {
        try {
            showDialog(new SmartcardPinDialog(positiveButtonListener, iCancelCbaCallback, this.mActivity));
        } catch (WindowManager.BadTokenException e) {
            Logger.error(this.TAG + ":showPinDialog", "Failed to show PinDialog due to BadTokenException. Activity may be finishing or destroyed.", e);
            iCancelCbaCallback.onCancel();
        }
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.IDialogHolder
    public synchronized void showErrorDialog(int i, int i2) {
        try {
            showDialog(new SmartcardErrorDialog(i, i2, R.string.smartcard_error_dialog_positive_button, new IDismissCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.DialogHolder.1
                @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.IDismissCallback
                public void onDismiss() {
                    DialogHolder.this.dismissDialog();
                }
            }, this.mActivity));
        } catch (WindowManager.BadTokenException e) {
            Logger.error(this.TAG + ":showErrorDialog", "Failed to show ErrorDialog due to BadTokenException. Activity may be finishing or destroyed.", e);
        }
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.IDialogHolder
    public synchronized void showErrorDialog(int i, int i2, int i3) {
        try {
            showDialog(new SmartcardErrorDialog(i, i2, i3, new IDismissCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.DialogHolder.2
                @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.IDismissCallback
                public void onDismiss() {
                    DialogHolder.this.dismissDialog();
                }
            }, this.mActivity));
        } catch (WindowManager.BadTokenException e) {
            Logger.error(this.TAG + ":showErrorDialog", "Failed to show ErrorDialog due to BadTokenException. Activity may be finishing or destroyed.", e);
        }
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.IDialogHolder
    public synchronized void showUserChoiceDialog(UserChoiceDialog.PositiveButtonListener positiveButtonListener, ICancelCbaCallback iCancelCbaCallback) {
        try {
            showDialog(new UserChoiceDialog(positiveButtonListener, iCancelCbaCallback, this.mActivity));
        } catch (WindowManager.BadTokenException e) {
            Logger.error(this.TAG + ":showUserChoiceDialog", "Failed to show UserChoiceDialog due to BadTokenException. Activity may be finishing or destroyed.", e);
            iCancelCbaCallback.onCancel();
        }
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.IDialogHolder
    public synchronized void showSmartcardPromptDialog(ICancelCbaCallback iCancelCbaCallback) {
        try {
            showDialog(new SmartcardPromptDialog(iCancelCbaCallback, this.mActivity));
        } catch (WindowManager.BadTokenException e) {
            Logger.error(this.TAG + ":showSmartcardPromptDialog", "Failed to show SmartcardPromptDialog due to BadTokenException. Activity may be finishing or destroyed.", e);
            iCancelCbaCallback.onCancel();
        }
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.IDialogHolder
    public synchronized void showSmartcardNfcLoadingDialog() {
        try {
            showDialog(new SmartcardNfcLoadingDialog(this.mActivity));
        } catch (WindowManager.BadTokenException e) {
            Logger.error(this.TAG + ":showSmartcardNfcLoadingDialog", "Failed to show SmartcardNfcLoadingDialog due to BadTokenException. Activity may be finishing or destroyed.", e);
        }
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.IDialogHolder
    public synchronized void showSmartcardNfcPromptDialog(ICancelCbaCallback iCancelCbaCallback) {
        try {
            showDialog(new SmartcardNfcPromptDialog(iCancelCbaCallback, this.mActivity));
        } catch (WindowManager.BadTokenException e) {
            Logger.error(this.TAG + ":showSmartcardNfcPromptDialog", "Failed to show SmartcardNfcPromptDialog due to BadTokenException. Activity may be finishing or destroyed.", e);
            iCancelCbaCallback.onCancel();
        }
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.IDialogHolder
    public synchronized void showSmartcardNfcReminderDialog(IDismissCallback iDismissCallback) {
        try {
            showDialog(new SmartcardNfcReminderDialog(iDismissCallback, this.mActivity));
        } catch (WindowManager.BadTokenException e) {
            Logger.error(this.TAG + ":showSmartcardNfcReminderDialog", "Failed to show SmartcardNfcReminderDialog due to BadTokenException. Activity may be finishing or destroyed.", e);
            iDismissCallback.onDismiss();
        }
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.IDialogHolder
    public synchronized void showSmartcardRemovalPromptDialog(final IDismissCallback iDismissCallback) {
        try {
            showDialog(new SmartcardRemovalPromptDialog(new IDismissCallback() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.DialogHolder.3
                @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.IDismissCallback
                public void onDismiss() {
                    DialogHolder.this.dismissDialog();
                    IDismissCallback iDismissCallback2 = iDismissCallback;
                    if (iDismissCallback2 != null) {
                        iDismissCallback2.onDismiss();
                    }
                }
            }, this.mActivity));
        } catch (WindowManager.BadTokenException e) {
            Logger.error(this.TAG + ":showSmartcardRemovalPromptDialog", "Failed to show SmartcardRemovalPromptDialog due to BadTokenException. Activity may be finishing or destroyed.", e);
            if (iDismissCallback != null) {
                iDismissCallback.onDismiss();
            }
        }
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.IDialogHolder
    public synchronized void dismissDialog() {
        showDialog(null);
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.IDialogHolder
    public synchronized void showDialog(SmartcardDialog smartcardDialog) {
        SmartcardDialog smartcardDialog2 = this.mCurrentDialog;
        if (smartcardDialog2 != null) {
            smartcardDialog2.dismiss();
        }
        this.mCurrentDialog = smartcardDialog;
        if (smartcardDialog != null) {
            smartcardDialog.show();
        }
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.IDialogHolder
    public synchronized boolean isDialogShowing() {
        return this.mCurrentDialog != null;
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.IDialogHolder
    public synchronized boolean isSmartcardRemovalPromptDialogShowing() {
        return this.mCurrentDialog instanceof SmartcardRemovalPromptDialog;
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.IDialogHolder
    public synchronized void onUnexpectedUnplug() {
        SmartcardDialog smartcardDialog = this.mCurrentDialog;
        if (smartcardDialog != null) {
            smartcardDialog.onUnexpectedUnplug();
        }
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.certbasedauth.IDialogHolder
    public synchronized void setPinDialogErrorMode() {
        SmartcardDialog smartcardDialog = this.mCurrentDialog;
        if (smartcardDialog instanceof SmartcardPinDialog) {
            ((SmartcardPinDialog) smartcardDialog).setErrorMode();
        }
    }
}
