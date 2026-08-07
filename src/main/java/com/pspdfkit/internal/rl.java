package com.pspdfkit.internal;

import com.pspdfkit.instant.client.InstantProgress;
import com.pspdfkit.instant.exceptions.InstantDownloadException;
import com.pspdfkit.instant.internal.jni.NativeInstantError;
import com.pspdfkit.instant.internal.jni.NativeProgressReporter;
import com.pspdfkit.instant.internal.jni.NativeProgressReporterResult;
import com.pspdfkit.instant.internal.jni.NativeServerDocumentLayer;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.core.FlowableOnSubscribe;

/* JADX INFO: loaded from: classes3.dex */
public final class rl {
    public static final InstantProgress d = new InstantProgress(100, true);
    public final NativeServerDocumentLayer a;
    public NativeProgressReporter b;
    public int c = 1;

    public rl(NativeServerDocumentLayer nativeServerDocumentLayer) {
        this.a = nativeServerDocumentLayer;
    }

    public final Flowable<InstantProgress> a(final wl wlVar) {
        return this.c == 3 ? Flowable.fromArray(d) : Flowable.create(new FlowableOnSubscribe() { // from class: com.pspdfkit.internal.rl$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.core.FlowableOnSubscribe
            public final void subscribe(FlowableEmitter flowableEmitter) throws Throwable {
                this.f$0.a(wlVar, flowableEmitter);
            }
        }, BackpressureStrategy.LATEST);
    }

    public final void a(wl wlVar, FlowableEmitter flowableEmitter) throws Throwable {
        synchronized (this) {
            if (this.c != 1) {
                flowableEmitter.onError(new InstantDownloadException("Download is already running."));
                return;
            }
            this.c = 2;
            NativeProgressReporterResult nativeProgressReporterResultDownloadDocument = this.a.downloadDocument(wlVar.a, new ql(this, flowableEmitter));
            if (nativeProgressReporterResultDownloadDocument.isError()) {
                NativeInstantError nativeInstantErrorError = nativeProgressReporterResultDownloadDocument.error();
                flowableEmitter.onError(new InstantDownloadException(lr.a(nativeInstantErrorError.getCode()), "Could not start document download: " + nativeInstantErrorError.getMessage(), nativeInstantErrorError.getUnderlyingError()));
                a(false);
                return;
            }
            this.b = nativeProgressReporterResultDownloadDocument.value();
        }
    }

    public final synchronized void a(boolean z) {
        if (this.c != 2) {
            return;
        }
        this.c = z ? 3 : 1;
    }
}
