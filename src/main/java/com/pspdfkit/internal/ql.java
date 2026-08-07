package com.pspdfkit.internal;

import com.pspdfkit.instant.client.InstantProgress;
import com.pspdfkit.instant.exceptions.InstantDownloadException;
import com.pspdfkit.instant.exceptions.InstantErrorCode;
import com.pspdfkit.instant.internal.jni.NativeInstantError;
import com.pspdfkit.instant.internal.jni.NativeProgressObserver;
import com.pspdfkit.instant.internal.jni.NativeProgressReporter;
import io.reactivex.rxjava3.core.FlowableEmitter;

/* JADX INFO: loaded from: classes3.dex */
public final class ql extends NativeProgressObserver {
    public final /* synthetic */ FlowableEmitter a;
    public final /* synthetic */ rl b;

    public ql(rl rlVar, FlowableEmitter flowableEmitter) {
        this.b = rlVar;
        this.a = flowableEmitter;
    }

    @Override // com.pspdfkit.instant.internal.jni.NativeProgressObserver
    public final void onCancellation(NativeProgressReporter nativeProgressReporter) {
        this.b.a(false);
        if (this.a.isCancelled()) {
            return;
        }
        this.a.onError(new InstantDownloadException(InstantErrorCode.USER_CANCELLED, "Download canceled", null));
    }

    @Override // com.pspdfkit.instant.internal.jni.NativeProgressObserver
    public final void onError(NativeProgressReporter nativeProgressReporter, NativeInstantError nativeInstantError) {
        this.b.a(false);
        if (this.a.isCancelled()) {
            return;
        }
        this.a.onError(new InstantDownloadException(lr.a(nativeInstantError.getCode()), nativeInstantError.getMessage(), nativeInstantError.getUnderlyingError()));
    }

    @Override // com.pspdfkit.instant.internal.jni.NativeProgressObserver
    public final void onProgress(NativeProgressReporter nativeProgressReporter) {
        if (this.a.isCancelled()) {
            nativeProgressReporter.cancel();
        } else {
            this.a.onNext(new InstantProgress((int) nativeProgressReporter.getCurrentProgress(), nativeProgressReporter.isInFinalState()));
        }
    }

    @Override // com.pspdfkit.instant.internal.jni.NativeProgressObserver
    public final void onSuccess(NativeProgressReporter nativeProgressReporter) {
        this.b.a(true);
        if (this.a.isCancelled()) {
            return;
        }
        this.a.onNext(rl.d);
        this.a.onComplete();
    }
}
