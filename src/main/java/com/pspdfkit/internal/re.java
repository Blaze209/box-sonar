package com.pspdfkit.internal;

import com.pspdfkit.document.sharing.SharingOptions;
import com.pspdfkit.ui.dialog.DocumentSharingDialog;

/* JADX INFO: loaded from: classes3.dex */
public final class re implements DocumentSharingDialog.SharingDialogListener {
    public final /* synthetic */ se a;

    public re(se seVar) {
        this.a = seVar;
    }

    @Override // com.pspdfkit.ui.dialog.DocumentSharingDialog.SharingDialogListener
    public final void onAccept(SharingOptions sharingOptions) {
        se seVar = this.a;
        seVar.j = false;
        seVar.a(sharingOptions);
    }

    @Override // com.pspdfkit.ui.dialog.DocumentSharingDialog.SharingDialogListener
    public final void onDismiss() {
        this.a.j = false;
    }
}
