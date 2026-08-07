package com.pspdfkit.instant.ui;

import android.content.Context;
import android.net.Uri;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.exceptions.NutrientException;
import com.pspdfkit.instant.document.InstantDocumentState;
import com.pspdfkit.instant.document.InstantPdfDocument;
import com.pspdfkit.instant.exceptions.InstantException;
import com.pspdfkit.instant.listeners.InstantPdfActivityListener;
import com.pspdfkit.internal.cw;
import com.pspdfkit.internal.ul;
import com.pspdfkit.internal.uw;
import com.pspdfkit.ui.DocumentCoordinator;
import com.pspdfkit.ui.PdfActivity;
import com.pspdfkit.ui.PdfFragment;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class InstantPdfActivity extends PdfActivity implements InstantPdfActivityListener {
    private InstantPdfUiImpl instantImplementation;

    public static void showInstantDocument(Context context, String str, String str2, PdfActivityConfiguration pdfActivityConfiguration) {
        uw.a(context, "context", null);
        uw.a(str, "serverUrl", null);
        uw.a(str2, "jwt", null);
        context.startActivity(InstantPdfActivityIntentBuilder.INSTANCE.fromInstantDocument(context, str, str2).configuration(pdfActivityConfiguration).build());
    }

    @Override // com.pspdfkit.ui.PdfActivity
    public cw createImplementation() {
        if (this.instantImplementation == null) {
            this.instantImplementation = new InstantPdfUiImpl(this, this, this, this.internalPdfUi);
        }
        return this.instantImplementation;
    }

    @Override // com.pspdfkit.ui.PdfUi
    public DocumentCoordinator getDocumentCoordinator() {
        throw new NutrientException("DocumentCoordinator is not supported when using InstantPdfActivity, use PdfActivity instead!");
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public void onAuthenticationFailed(InstantPdfDocument instantPdfDocument, InstantException instantException) {
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public void onAuthenticationFinished(InstantPdfDocument instantPdfDocument, String str) {
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public void onDocumentCorrupted(InstantPdfDocument instantPdfDocument) {
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public void onDocumentInvalidated(InstantPdfDocument instantPdfDocument) {
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public void onDocumentStateChanged(InstantPdfDocument instantPdfDocument, InstantDocumentState instantDocumentState) {
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public void onSyncError(InstantPdfDocument instantPdfDocument, InstantException instantException) {
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public void onSyncFinished(InstantPdfDocument instantPdfDocument) {
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public void onSyncStarted(InstantPdfDocument instantPdfDocument) {
    }

    public void setDocument(String str, String str2) {
        this.instantImplementation.setDocument(new ul(str, str2));
    }

    @Override // com.pspdfkit.ui.PdfUi
    public void setDocumentFromDataProvider(DataProvider dataProvider, String str) {
        throw new NutrientException("setDocumentFromDataProvider() may not be called when using InstantPdfActivity, use PdfActivity instead!");
    }

    @Override // com.pspdfkit.ui.PdfUi
    public void setDocumentFromDataProviders(List<DataProvider> list, List<String> list2) {
        throw new NutrientException("setDocumentFromDataProviders() may not be called when using InstantPdfActivity, use PdfActivity instead!");
    }

    @Override // com.pspdfkit.ui.PdfUi
    public void setDocumentFromUri(Uri uri, String str) throws IllegalStateException {
        throw new NutrientException("setDocumentFromUri() may not be called when using InstantPdfActivity, use PdfActivity instead!");
    }

    @Override // com.pspdfkit.ui.PdfUi
    public void setDocumentFromUris(List<Uri> list, List<String> list2) {
        throw new NutrientException("setDocumentFromUris() may not be called when using InstantPdfActivity, use PdfActivity instead!");
    }

    @Override // com.pspdfkit.ui.PdfUi
    public InstantPdfDocument getDocument() {
        return getPdfFragment().getDocument();
    }

    @Override // com.pspdfkit.ui.PdfUi
    public InstantPdfFragment getPdfFragment() {
        PdfFragment pdfFragment = super.getPdfFragment();
        if (pdfFragment instanceof InstantPdfFragment) {
            return (InstantPdfFragment) pdfFragment;
        }
        throw new IllegalStateException("Instant activity has wrong fragment type. InstantPdfFragment was expected!");
    }

    @Override // com.pspdfkit.ui.PdfUi
    public InstantPdfFragment requirePdfFragment() {
        return getPdfFragment();
    }
}
