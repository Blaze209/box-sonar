package com.pspdfkit.internal;

import android.net.Uri;
import com.pspdfkit.document.DocumentSource;
import com.pspdfkit.document.providers.ContentResolverDataProvider;
import io.reactivex.rxjava3.functions.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public final class fj<T> implements Consumer {
    public final /* synthetic */ gj a;
    public final /* synthetic */ int b;

    public fj(gj gjVar, int i) {
        this.a = gjVar;
        this.b = i;
    }

    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Object obj) {
        Uri uri = (Uri) obj;
        uri.getClass();
        this.a.a.setCustomPdfSource(new DocumentSource(new ContentResolverDataProvider(uri)));
        this.a.a.setPageIndex(this.b);
    }
}
