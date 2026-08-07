package com.microsoft.intune.mam.client.app.offline;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import com.microsoft.intune.mam.client.app.DialogFragmentBehavior;
import com.microsoft.intune.mam.client.app.HookedDialogFragmentBase;
import com.microsoft.intune.mam.client.app.HookedFragmentBase;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineDialogFragmentBehavior extends OfflineFragmentBehavior implements DialogFragmentBehavior {
    @Override // com.microsoft.intune.mam.client.app.DialogFragmentBehavior
    public void initialize(HookedDialogFragmentBase hookedDialogFragmentBase) {
        super.initialize((HookedFragmentBase) hookedDialogFragmentBase);
    }

    @Override // com.microsoft.intune.mam.client.app.DialogFragmentBehavior
    public void onAttach(Activity activity, HookedDialogFragmentBase hookedDialogFragmentBase) {
        super.onAttach(activity, (HookedFragmentBase) hookedDialogFragmentBase);
    }

    @Override // com.microsoft.intune.mam.client.app.DialogFragmentBehavior
    public Dialog onCreateDialog(Bundle bundle) {
        return ((HookedDialogFragmentBase) this.mFragment).onMAMCreateDialog(bundle);
    }

    @Override // com.microsoft.intune.mam.client.app.DialogFragmentBehavior
    public Dialog onMAMCreateDialog(Bundle bundle) {
        return ((HookedDialogFragmentBase) this.mFragment).onCreateDialogReal(bundle);
    }
}
