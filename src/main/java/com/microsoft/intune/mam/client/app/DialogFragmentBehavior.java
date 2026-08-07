package com.microsoft.intune.mam.client.app;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;

/* JADX INFO: loaded from: classes3.dex */
public interface DialogFragmentBehavior extends FragmentBehavior {
    void initialize(HookedDialogFragmentBase hookedDialogFragmentBase);

    void onAttach(Activity activity, HookedDialogFragmentBase hookedDialogFragmentBase);

    Dialog onCreateDialog(Bundle bundle);

    Dialog onMAMCreateDialog(Bundle bundle);
}
