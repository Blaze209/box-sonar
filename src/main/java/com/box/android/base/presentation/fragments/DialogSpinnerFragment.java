package com.box.android.base.presentation.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.coreservices.modelcontroller.messages.Controller;

/* JADX INFO: loaded from: classes9.dex */
public abstract class DialogSpinnerFragment extends BoxFragment implements ISpinnerDialog {
    private static final Intent DISMISS_SPINNER_INTENT = new Intent(Controller.ACTION_DISMISS_SPINNER);

    @Override // com.box.android.base.presentation.fragments.ISpinnerDialog
    public void showSpinner(String str, boolean z) {
        ISpinnerDialog underlyingSpinnerDialogActivity = getUnderlyingSpinnerDialogActivity();
        if (underlyingSpinnerDialogActivity != null) {
            underlyingSpinnerDialogActivity.showSpinner(str, z);
        }
    }

    @Override // com.box.android.base.presentation.fragments.ISpinnerDialog
    public void showSpinner(String str) {
        ISpinnerDialog underlyingSpinnerDialogActivity = getUnderlyingSpinnerDialogActivity();
        if (underlyingSpinnerDialogActivity != null) {
            underlyingSpinnerDialogActivity.showSpinner(str);
        }
    }

    @Override // com.box.android.base.presentation.fragments.ISpinnerDialog
    public void showSpinner() {
        ISpinnerDialog underlyingSpinnerDialogActivity = getUnderlyingSpinnerDialogActivity();
        if (underlyingSpinnerDialogActivity != null) {
            underlyingSpinnerDialogActivity.showSpinner();
        }
    }

    @Override // com.box.android.base.presentation.fragments.ISpinnerDialog
    public void broadcastDismissSpinner() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.box.android.base.presentation.fragments.DialogSpinnerFragment.1
            @Override // java.lang.Runnable
            public void run() {
                LocalBroadcastManager.getInstance(ApplicationProvider.application).sendBroadcast(DialogSpinnerFragment.DISMISS_SPINNER_INTENT);
            }
        });
    }

    @Override // com.box.android.base.presentation.fragments.ISpinnerDialog
    public void setSpinnerOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        ISpinnerDialog underlyingSpinnerDialogActivity = getUnderlyingSpinnerDialogActivity();
        if (underlyingSpinnerDialogActivity != null) {
            underlyingSpinnerDialogActivity.setSpinnerOnCancelListener(onCancelListener);
        }
    }

    private ISpinnerDialog getUnderlyingSpinnerDialogActivity() {
        if (getActivity() instanceof ISpinnerDialog) {
            return (ISpinnerDialog) getActivity();
        }
        return null;
    }
}
