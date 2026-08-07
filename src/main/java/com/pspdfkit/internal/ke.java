package com.pspdfkit.internal;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.document.sharing.DocumentSharingManager;
import com.pspdfkit.document.sharing.SharingOptions;
import com.pspdfkit.ui.dialog.DocumentSharingDialog;

/* JADX INFO: loaded from: classes3.dex */
public final class ke implements DocumentSharingDialog.SharingDialogListener {
    public final /* synthetic */ le a;

    public ke(le leVar) {
        this.a = leVar;
    }

    @Override // com.pspdfkit.ui.dialog.DocumentSharingDialog.SharingDialogListener
    public final void onAccept(SharingOptions sharingOptions) {
        le leVar = this.a;
        leVar.f = false;
        FragmentActivity fragmentActivity = leVar.c;
        if (fragmentActivity == null) {
            return;
        }
        leVar.d = DocumentSharingManager.shareDocument(fragmentActivity, leVar.a, leVar.b, sharingOptions);
        i0 i0VarA = ar.a();
        Bundle bundleA = z50.a(i0VarA);
        bundleA.putString(Analytics.Data.ACTION, leVar.b.name());
        i0VarA.a("share", bundleA);
    }

    @Override // com.pspdfkit.ui.dialog.DocumentSharingDialog.SharingDialogListener
    public final void onDismiss() {
        this.a.f = false;
    }
}
