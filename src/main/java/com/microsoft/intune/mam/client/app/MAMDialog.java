package com.microsoft.intune.mam.client.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

/* JADX INFO: loaded from: classes3.dex */
public class MAMDialog extends Dialog implements HookedDialog {
    private DialogBehavior mBehavior;

    @Override // com.microsoft.intune.mam.client.app.HookedDialog
    public Dialog asDialog() {
        return this;
    }

    public MAMDialog(Context context) {
        super(context);
        init();
    }

    public MAMDialog(Context context, int i) {
        super(context, i);
        init();
    }

    private void init() {
        DialogBehavior dialogBehavior = (DialogBehavior) MAMComponents.get(DialogBehavior.class);
        this.mBehavior = dialogBehavior;
        if (dialogBehavior != null) {
            dialogBehavior.attach(this);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        DialogBehavior dialogBehavior = this.mBehavior;
        if (dialogBehavior != null) {
            dialogBehavior.onCreate(bundle);
        } else {
            onCreateReal(bundle);
        }
    }

    @Override // com.microsoft.intune.mam.client.app.HookedDialog
    public final void onCreateReal(Bundle bundle) {
        super.onCreate(bundle);
    }
}
