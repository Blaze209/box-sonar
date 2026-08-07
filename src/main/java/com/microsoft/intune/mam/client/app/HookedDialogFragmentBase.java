package com.microsoft.intune.mam.client.app;

import android.app.Dialog;
import android.os.Bundle;

/* JADX INFO: loaded from: classes3.dex */
public interface HookedDialogFragmentBase extends HookedFragmentBase {
    Dialog createMAMDialog();

    Dialog onCreateDialogReal(Bundle bundle);

    Dialog onMAMCreateDialog(Bundle bundle);
}
