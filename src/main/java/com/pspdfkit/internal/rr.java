package com.pspdfkit.internal;

import com.pspdfkit.document.processor.PdfProcessor;
import com.pspdfkit.document.processor.PdfProcessorException;
import com.pspdfkit.internal.jni.NativeProcessorDelegate;
import com.pspdfkit.internal.jni.NativeProcessorErrorType;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.core.FlowableEmitter;

/* JADX INFO: loaded from: classes3.dex */
public final class rr extends NativeProcessorDelegate {
    public final /* synthetic */ FlowableEmitter a;

    public rr(FlowableEmitter flowableEmitter) {
        this.a = flowableEmitter;
    }

    @Override // com.pspdfkit.internal.jni.NativeProcessorDelegate
    public final void completion(boolean z, String str) {
        this.a.onComplete();
    }

    @Override // com.pspdfkit.internal.jni.NativeProcessorDelegate
    public final void error(NativeProcessorErrorType nativeProcessorErrorType, String str) {
        if (this.a.isCancelled()) {
            return;
        }
        PdfLog.w("Nutri.Processor", "Error while processing document [" + nativeProcessorErrorType.toString() + "] " + str, new Object[0]);
        this.a.onError(new PdfProcessorException(str));
    }

    @Override // com.pspdfkit.internal.jni.NativeProcessorDelegate
    public final boolean isCanceled() {
        return this.a.isCancelled();
    }

    @Override // com.pspdfkit.internal.jni.NativeProcessorDelegate
    public final void progress(int i, int i2) {
        this.a.onNext(new PdfProcessor.ProcessorProgress(i, i2));
    }
}
