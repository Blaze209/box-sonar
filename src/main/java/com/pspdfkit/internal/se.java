package com.pspdfkit.internal;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.sharing.DocumentSharingController;
import com.pspdfkit.document.sharing.DocumentSharingManager;
import com.pspdfkit.document.sharing.ShareAction;
import com.pspdfkit.document.sharing.ShareTarget;
import com.pspdfkit.document.sharing.SharingOptions;
import com.pspdfkit.document.sharing.SharingOptionsProvider;
import com.pspdfkit.ui.dialog.DocumentSharingDialogFactory;

/* JADX INFO: loaded from: classes3.dex */
public final class se {
    public final PdfDocument a;
    public final int b;
    public final String c;
    public final ShareTarget d;
    public final ShareAction e;
    public FragmentActivity f;
    public DocumentSharingController g;
    public final DocumentSharingDialogFactory h;
    public final SharingOptionsProvider i;
    public boolean j;
    public final boolean k;

    public se(FragmentActivity fragmentActivity, PdfDocument pdfDocument, DocumentSharingDialogFactory documentSharingDialogFactory, SharingOptionsProvider sharingOptionsProvider, ShareTarget shareTarget, int i, String str) {
        this.k = false;
        this.f = fragmentActivity;
        this.a = pdfDocument;
        this.h = documentSharingDialogFactory;
        this.i = sharingOptionsProvider;
        this.d = shareTarget;
        if (shareTarget.isPrintTarget()) {
            this.k = true;
        }
        this.e = shareTarget.getShareAction();
        this.b = i;
        this.c = str;
    }

    public final void a(SharingOptions sharingOptions) {
        FragmentActivity fragmentActivity = this.f;
        if (fragmentActivity == null) {
            return;
        }
        String str = this.k ? Analytics.Event.PRINT : "share";
        ShareTarget shareTarget = this.d;
        PdfDocument pdfDocument = this.a;
        if (shareTarget == null) {
            this.g = DocumentSharingManager.shareDocument(fragmentActivity, pdfDocument, this.e, sharingOptions);
            i0 i0VarA = ar.a();
            Bundle bundleA = z50.a(i0VarA);
            bundleA.putString(Analytics.Data.ACTION, this.e.name());
            i0VarA.a(str, bundleA);
            return;
        }
        this.g = DocumentSharingManager.shareDocument(fragmentActivity, pdfDocument, shareTarget, sharingOptions);
        i0 i0VarA2 = ar.a();
        Bundle bundleA2 = z50.a(i0VarA2);
        bundleA2.putString(Analytics.Data.PACKAGE_NAME, this.d.getPackageName());
        bundleA2.putString(Analytics.Data.ACTION, this.d.getShareAction().name());
        i0VarA2.a(str, bundleA2);
    }
}
