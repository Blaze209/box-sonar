package com.pspdfkit.instant.ui;

import android.os.Bundle;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.instant.document.InstantPdfDocument;
import com.pspdfkit.instant.listeners.InstantDocumentListener;
import com.pspdfkit.internal.cw;
import com.pspdfkit.internal.sm;
import com.pspdfkit.internal.ul;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.PdfUi;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
final class InstantPdfUiImpl extends cw {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final InstantDocumentListener instantDocumentListener;

    public InstantPdfUiImpl(AppCompatActivity appCompatActivity, PdfUi pdfUi, InstantDocumentListener instantDocumentListener, sm smVar) {
        super(appCompatActivity, pdfUi, smVar);
        this.instantDocumentListener = instantDocumentListener;
    }

    private PdfActivityConfiguration sanitizePdfActivityConfiguration(PdfActivityConfiguration pdfActivityConfiguration) {
        return new PdfActivityConfiguration.Builder(pdfActivityConfiguration).documentEditorEnabled(false).bookmarkListEnabled(false).setRedactionUiEnabled(false).configuration(InstantPdfFragment.validatedPdfConfiguration(pdfActivityConfiguration.getConfiguration())).build();
    }

    @Override // com.pspdfkit.internal.cw
    public void removeListeners(PdfFragment pdfFragment) {
        super.removeListeners(pdfFragment);
        ((InstantPdfFragment) pdfFragment).removeInstantDocumentListener(this.instantDocumentListener);
    }

    @Override // com.pspdfkit.internal.cw
    public Bundle requirePdfParameters() {
        Bundle pdfParameters = getPdfParameters();
        if (pdfParameters != null && pdfParameters.containsKey("Instant.InstantDocumentSource") && pdfParameters.containsKey("Nutri.Configuration")) {
            PdfActivityConfiguration pdfActivityConfiguration = (PdfActivityConfiguration) pdfParameters.getParcelable("Nutri.Configuration");
            if (pdfActivityConfiguration != null) {
                pdfParameters.putParcelable("Nutri.Configuration", sanitizePdfActivityConfiguration(pdfActivityConfiguration));
            }
            return pdfParameters;
        }
        StringBuilder sb = new StringBuilder();
        if (pdfParameters != null) {
            if (!pdfParameters.containsKey("Instant.InstantDocumentSource")) {
                sb.append("- Document source was not set.\n");
            }
            if (!pdfParameters.containsKey("Nutri.Configuration")) {
                sb.append("- No configuration was passed.\n");
            }
        } else {
            sb.append("- Extras bundle was missing entirely.\n");
        }
        throw new IllegalArgumentException("InstantPdfActivity was not initialized with proper arguments:\n".concat(sb.toString()));
    }

    @Override // com.pspdfkit.internal.cw
    public void setConfiguration(PdfActivityConfiguration pdfActivityConfiguration) {
        super.setConfiguration(sanitizePdfActivityConfiguration(pdfActivityConfiguration));
    }

    @Override // com.pspdfkit.internal.cw
    public void setupListeners(PdfFragment pdfFragment) {
        super.setupListeners(pdfFragment);
        ((InstantPdfFragment) pdfFragment).addInstantDocumentListener(this.instantDocumentListener);
    }

    @Override // com.pspdfkit.internal.cw
    public void setDocument(PdfDocument pdfDocument) {
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("setDocument() may only be called from the UI thread.");
        }
        if (!(pdfDocument instanceof InstantPdfDocument)) {
            throw new IllegalStateException("Only InstantPdfDocument can be set to instant fragment!");
        }
        setFragment(InstantPdfFragment.newInstance((InstantPdfDocument) pdfDocument, getConfiguration().getConfiguration()));
    }

    @Override // com.pspdfkit.internal.cw
    public void setDocument(Bundle bundle) {
        setDocument((ul) bundle.getParcelable("Instant.InstantDocumentSource"));
    }

    public void setDocument(ul ulVar) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            setFragment(InstantPdfFragment.newInstance(ulVar, getConfiguration().getConfiguration()));
            return;
        }
        throw new IllegalStateException("setDocument() may only be called from the UI thread.");
    }
}
