package com.pspdfkit.document.sharing;

import android.content.Context;
import android.net.Uri;
import com.pspdfkit.document.processor.PdfProcessor;
import com.pspdfkit.internal.uw;
import io.reactivex.rxjava3.disposables.Disposable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DocumentSharingController {
    private Context context;
    private Disposable shareDocumentDisposable;

    public DocumentSharingController(Context context) {
        uw.a(context, "context", null);
        DocumentSharingProvider.checkProviderConfiguration(context);
        this.context = context;
    }

    public void cancelSharing() {
        Disposable disposable = this.shareDocumentDisposable;
        if (disposable != null) {
            disposable.dispose();
            this.shareDocumentDisposable = null;
        }
    }

    public Context getContext() {
        return this.context;
    }

    public boolean isSharingInProgress() {
        return this.shareDocumentDisposable != null;
    }

    public void onAttach(Context context) {
        uw.a(context, "context", null);
        this.context = context;
    }

    public void onDetach() {
        this.context = null;
    }

    public abstract void onDocumentPrepared(Uri uri);

    public void onSharingError() {
        cancelSharing();
    }

    public void onSharingFinished(Uri uri) {
        uw.a(uri, "shareUri", null);
        this.shareDocumentDisposable = null;
        if (this.context == null) {
            return;
        }
        onDocumentPrepared(uri);
    }

    public void onSharingProgress(PdfProcessor.ProcessorProgress processorProgress) {
    }

    public void onSharingStarted(Disposable disposable) {
        uw.a(disposable, "shareDocumentDisposable", null);
        this.shareDocumentDisposable = disposable;
    }
}
