package com.pspdfkit.internal;

import com.pspdfkit.utils.PdfLog;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: classes3.dex */
public final class ep extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    public ep(CoroutineExceptionHandler.Companion companion) {
        super(companion);
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public final void handleException(CoroutineContext coroutineContext, Throwable th) {
        PdfLog.e("Nutri.MarkupAnnotMHand", "Unable to update annotation data", th);
    }
}
