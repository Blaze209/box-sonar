package com.pspdfkit.internal;

import android.graphics.Bitmap;
import io.reactivex.rxjava3.core.CompletableEmitter;

/* JADX INFO: loaded from: classes3.dex */
public final class m10 extends b30<Bitmap> {
    public final /* synthetic */ CompletableEmitter a;
    public final /* synthetic */ n10 b;

    public m10(n10 n10Var, CompletableEmitter completableEmitter) {
        this.b = n10Var;
        this.a = completableEmitter;
    }

    @Override // com.pspdfkit.internal.b30, io.reactivex.rxjava3.core.SingleObserver
    public final void onSuccess(Object obj) {
        this.b.j = null;
        if (isDisposed() || this.a.isDisposed()) {
            return;
        }
        this.a.onComplete();
    }
}
