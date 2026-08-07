package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeProcessorDelegate {
    public abstract void completion(boolean z, String str);

    public abstract void error(NativeProcessorErrorType nativeProcessorErrorType, String str);

    public abstract boolean isCanceled();

    public abstract void progress(int i, int i2);
}
