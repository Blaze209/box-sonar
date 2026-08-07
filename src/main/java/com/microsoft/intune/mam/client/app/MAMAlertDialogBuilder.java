package com.microsoft.intune.mam.client.app;

import android.app.AlertDialog;
import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class MAMAlertDialogBuilder extends AlertDialog.Builder {
    public MAMAlertDialogBuilder(Context context) {
        super(context);
    }

    public MAMAlertDialogBuilder(Context context, int i) {
        super(context, i);
    }

    @Override // android.app.AlertDialog.Builder
    public AlertDialog create() {
        AlertDialog alertDialogCreate = super.create();
        AlertDialogBuilderBehavior alertDialogBuilderBehavior = (AlertDialogBuilderBehavior) MAMComponents.get(AlertDialogBuilderBehavior.class);
        if (alertDialogBuilderBehavior != null) {
            alertDialogBuilderBehavior.enforcePolicy(alertDialogCreate);
        }
        return alertDialogCreate;
    }
}
