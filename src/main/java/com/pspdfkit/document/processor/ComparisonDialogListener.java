package com.pspdfkit.document.processor;

import com.pspdfkit.document.DocumentSource;

/* JADX INFO: loaded from: classes3.dex */
public interface ComparisonDialogListener {
    void onComparisonSuccessful(DocumentSource documentSource);

    void onError(Throwable th);
}
