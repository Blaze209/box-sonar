package com.pspdfkit.internal;

import com.pspdfkit.instant.document.InstantPdfDocument;
import com.pspdfkit.instant.exceptions.InstantException;
import com.pspdfkit.instant.listeners.InstantDocumentListener;
import io.reactivex.rxjava3.core.CompletableEmitter;

/* JADX INFO: loaded from: classes3.dex */
public final class jl implements InstantDocumentListener {
    public final /* synthetic */ CompletableEmitter a;
    public final /* synthetic */ String b;
    public final /* synthetic */ kl c;

    public jl(kl klVar, CompletableEmitter completableEmitter, String str) {
        this.c = klVar;
        this.a = completableEmitter;
        this.b = str;
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public final void onAuthenticationFailed(InstantPdfDocument instantPdfDocument, InstantException instantException) {
        pl plVarA = this.c.a.a();
        plVarA.getClass();
        plVarA.b.b(this);
        if (this.a.isDisposed()) {
            return;
        }
        this.a.onError(instantException);
    }

    @Override // com.pspdfkit.instant.listeners.InstantDocumentListener
    public final void onAuthenticationFinished(InstantPdfDocument instantPdfDocument, String str) {
        pl plVarA = this.c.a.a();
        plVarA.getClass();
        plVarA.b.b(this);
        if (this.a.isDisposed() || !this.b.equals(str)) {
            return;
        }
        this.a.onComplete();
    }
}
