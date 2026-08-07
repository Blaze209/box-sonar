package com.pspdfkit.internal;

import android.net.Uri;
import com.pspdfkit.document.PdfDocumentLoader;
import com.pspdfkit.document.processor.PdfProcessor;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.subscribers.DisposableSubscriber;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class zw extends DisposableSubscriber<PdfProcessor.ProcessorProgress> {
    public final /* synthetic */ yw.a a;
    public final /* synthetic */ File b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ ax d;

    public class a extends u20 {
        public a() {
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public final void onComplete() {
            zw zwVar = zw.this;
            ax axVar = zwVar.d;
            yw.a aVar = zwVar.a;
            boolean z = zwVar.c;
            int i = axVar.d.s;
            if (i > 0) {
                aVar.a(axVar.a(), i, z);
            } else {
                aVar.b();
            }
        }
    }

    public zw(ax axVar, yw.a aVar, File file, boolean z) {
        this.d = axVar;
        this.a = aVar;
        this.b = file;
        this.c = z;
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        g60 g60VarC;
        if (isDisposed()) {
            return;
        }
        try {
            ax axVar = this.d;
            axVar.d = (lm) PdfDocumentLoader.openDocument(axVar.c, Uri.fromFile(this.b), this.d.d.A.get(0).getPassword());
            this.d.h = true;
            ut utVarA = q10.a.a();
            lm lmVar = this.d.d;
            Completable completableA = utVarA.a(lmVar.B, lmVar.s);
            synchronized (ar.class) {
                g60VarC = q10.c();
            }
            completableA.subscribeOn(((m0) g60VarC).a()).subscribe(new a());
        } catch (IOException unused) {
            this.a.b();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (isDisposed()) {
            return;
        }
        this.a.b();
    }

    @Override // org.reactivestreams.Subscriber
    public final /* bridge */ /* synthetic */ void onNext(Object obj) {
    }
}
