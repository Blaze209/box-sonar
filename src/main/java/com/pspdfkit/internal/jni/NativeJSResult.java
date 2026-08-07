package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeJSResult {
    final NativeJSError mError;
    final NativeJSEvent mEvent;
    final NativeJSValue mValue;

    public NativeJSResult(NativeJSValue nativeJSValue, NativeJSEvent nativeJSEvent, NativeJSError nativeJSError) {
        this.mValue = nativeJSValue;
        this.mEvent = nativeJSEvent;
        this.mError = nativeJSError;
    }

    public NativeJSError getError() {
        return this.mError;
    }

    public NativeJSEvent getEvent() {
        return this.mEvent;
    }

    public NativeJSValue getValue() {
        return this.mValue;
    }

    public String toString() {
        return "NativeJSResult{mValue=" + this.mValue + ",mEvent=" + this.mEvent + ",mError=" + this.mError + "}";
    }
}
