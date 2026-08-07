package com.pspdfkit.javascript;

import io.reactivex.rxjava3.core.Completable;

/* JADX INFO: loaded from: classes3.dex */
public interface JavaScriptProvider {
    void executeDocumentLevelScripts();

    Completable executeDocumentLevelScriptsAsync();

    boolean isJavaScriptEnabled();

    void setJavaScriptEnabled(boolean z);
}
