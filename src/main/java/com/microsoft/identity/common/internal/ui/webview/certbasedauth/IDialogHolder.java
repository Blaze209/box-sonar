package com.microsoft.identity.common.internal.ui.webview.certbasedauth;

import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public interface IDialogHolder {
    void dismissDialog();

    boolean isDialogShowing();

    boolean isSmartcardRemovalPromptDialogShowing();

    void onUnexpectedUnplug();

    void setPinDialogErrorMode();

    void showCertPickerDialog(List<ICertDetails> list, SmartcardCertPickerDialog.PositiveButtonListener positiveButtonListener, ICancelCbaCallback iCancelCbaCallback);

    void showDialog(SmartcardDialog smartcardDialog);

    void showErrorDialog(int i, int i2);

    void showErrorDialog(int i, int i2, int i3);

    void showPinDialog(SmartcardPinDialog.PositiveButtonListener positiveButtonListener, ICancelCbaCallback iCancelCbaCallback);

    void showSmartcardNfcLoadingDialog();

    void showSmartcardNfcPromptDialog(ICancelCbaCallback iCancelCbaCallback);

    void showSmartcardNfcReminderDialog(IDismissCallback iDismissCallback);

    void showSmartcardPromptDialog(ICancelCbaCallback iCancelCbaCallback);

    void showSmartcardRemovalPromptDialog(IDismissCallback iDismissCallback);

    void showUserChoiceDialog(UserChoiceDialog.PositiveButtonListener positiveButtonListener, ICancelCbaCallback iCancelCbaCallback);
}
