package com.box.android.base.presentation.fragments;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes9.dex */
public interface ISpinnerDialog {
    void broadcastDismissSpinner();

    void setSpinnerOnCancelListener(DialogInterface.OnCancelListener onCancelListener);

    void showSpinner();

    void showSpinner(String str);

    void showSpinner(String str, boolean z);
}
