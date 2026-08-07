package com.microsoft.identity.common.internal.ui.webview.certbasedauth;

import android.app.Activity;
import android.app.Dialog;

/* JADX INFO: loaded from: classes14.dex */
public abstract class SmartcardDialog {
    protected final Activity mActivity;
    protected Dialog mDialog = null;

    abstract void createDialog();

    abstract void onUnexpectedUnplug();

    public SmartcardDialog(Activity activity) {
        this.mActivity = activity;
    }

    public void show() {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardDialog.1
            @Override // java.lang.Runnable
            public void run() {
                SmartcardDialog.this.mDialog.show();
            }
        });
    }

    public void dismiss() {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardDialog.2
            @Override // java.lang.Runnable
            public void run() {
                SmartcardDialog.this.mDialog.dismiss();
            }
        });
    }
}
