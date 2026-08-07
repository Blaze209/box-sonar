package com.pspdfkit.internal;

import android.os.Handler;
import android.os.Looper;
import com.pspdfkit.instant.document.InstantDocumentState;
import com.pspdfkit.instant.document.InstantPdfDocument;
import com.pspdfkit.instant.exceptions.InstantException;
import com.pspdfkit.instant.listeners.InstantDocumentListener;

/* JADX INFO: loaded from: classes3.dex */
public final class sl implements InstantDocumentListener {
    public final InstantDocumentListener a;
    public final Handler b = new Handler(Looper.getMainLooper());

    public sl(InstantDocumentListener instantDocumentListener) {
        this.a = instantDocumentListener;
    }

    public final /* synthetic */ void a(InstantPdfDocument instantPdfDocument, InstantException instantException) {
        this.a.onAuthenticationFailed(instantPdfDocument, instantException);
    }

    public final /* synthetic */ void b(InstantPdfDocument instantPdfDocument, InstantException instantException) {
        this.a.onSyncError(instantPdfDocument, instantException);
    }

    public final /* synthetic */ void c(InstantPdfDocument instantPdfDocument) {
        this.a.onSyncFinished(instantPdfDocument);
    }

    public final /* synthetic */ void d(InstantPdfDocument instantPdfDocument) {
        this.a.onSyncStarted(instantPdfDocument);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof sl) {
            return this.a.equals(((sl) obj).a);
        }
        if (!(obj instanceof InstantDocumentListener)) {
            return false;
        }
        return this.a.equals((InstantDocumentListener) obj);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public final void onAuthenticationFailed(final InstantPdfDocument instantPdfDocument, final InstantException instantException) {
        this.b.post(new Runnable() { // from class: com.pspdfkit.internal.sl$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(instantPdfDocument, instantException);
            }
        });
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public final void onAuthenticationFinished(final InstantPdfDocument instantPdfDocument, final String str) {
        this.b.post(new Runnable() { // from class: com.pspdfkit.internal.sl$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(instantPdfDocument, str);
            }
        });
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public final void onDocumentCorrupted(final InstantPdfDocument instantPdfDocument) {
        this.b.post(new Runnable() { // from class: com.pspdfkit.internal.sl$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(instantPdfDocument);
            }
        });
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public final void onDocumentInvalidated(final InstantPdfDocument instantPdfDocument) {
        this.b.post(new Runnable() { // from class: com.pspdfkit.internal.sl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(instantPdfDocument);
            }
        });
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public final void onDocumentStateChanged(final InstantPdfDocument instantPdfDocument, final InstantDocumentState instantDocumentState) {
        this.b.post(new Runnable() { // from class: com.pspdfkit.internal.sl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(instantPdfDocument, instantDocumentState);
            }
        });
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public final void onSyncError(final InstantPdfDocument instantPdfDocument, final InstantException instantException) {
        this.b.post(new Runnable() { // from class: com.pspdfkit.internal.sl$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(instantPdfDocument, instantException);
            }
        });
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public final void onSyncFinished(final InstantPdfDocument instantPdfDocument) {
        this.b.post(new Runnable() { // from class: com.pspdfkit.internal.sl$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c(instantPdfDocument);
            }
        });
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public final void onSyncStarted(final InstantPdfDocument instantPdfDocument) {
        this.b.post(new Runnable() { // from class: com.pspdfkit.internal.sl$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.d(instantPdfDocument);
            }
        });
    }

    public final /* synthetic */ void a(InstantPdfDocument instantPdfDocument, String str) {
        this.a.onAuthenticationFinished(instantPdfDocument, str);
    }

    public final /* synthetic */ void b(InstantPdfDocument instantPdfDocument) {
        this.a.onDocumentInvalidated(instantPdfDocument);
    }

    public final /* synthetic */ void a(InstantPdfDocument instantPdfDocument, InstantDocumentState instantDocumentState) {
        this.a.onDocumentStateChanged(instantPdfDocument, instantDocumentState);
    }

    public final /* synthetic */ void a(InstantPdfDocument instantPdfDocument) {
        this.a.onDocumentCorrupted(instantPdfDocument);
    }
}
