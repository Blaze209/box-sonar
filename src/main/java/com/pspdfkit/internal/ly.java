package com.pspdfkit.internal;

import com.pspdfkit.internal.jni.NativeReflowProcessorDelegate;
import com.pspdfkit.ui.PdfReaderView;

/* JADX INFO: loaded from: classes3.dex */
public final class ly extends NativeReflowProcessorDelegate {
    public final PdfReaderView a;

    public ly(PdfReaderView pdfReaderView) {
        this.a = pdfReaderView;
    }

    @Override // com.pspdfkit.internal.jni.NativeReflowProcessorDelegate
    public final boolean isCanceled() {
        PdfReaderView pdfReaderView = this.a;
        if (pdfReaderView != null) {
            return pdfReaderView.isCanceled();
        }
        return false;
    }

    @Override // com.pspdfkit.internal.jni.NativeReflowProcessorDelegate
    public final void progress(int i, int i2) {
        PdfReaderView pdfReaderView = this.a;
        if (pdfReaderView != null) {
            pdfReaderView.progress(i, i2);
        }
    }
}
