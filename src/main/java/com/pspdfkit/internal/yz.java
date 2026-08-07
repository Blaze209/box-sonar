package com.pspdfkit.internal;

import io.reactivex.rxjava3.disposables.Disposable;

/* JADX INFO: loaded from: classes3.dex */
public final class yz {
    public static void a(Disposable disposable) {
        if (disposable == null || disposable.isDisposed()) {
            return;
        }
        disposable.dispose();
    }
}
