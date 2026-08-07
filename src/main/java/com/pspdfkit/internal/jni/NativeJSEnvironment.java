package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeJSEnvironment {
    final NativeDocumentProvider mDocumentProvider;
    final NativeJSEvent mEvent;

    public NativeJSEnvironment(NativeJSEvent nativeJSEvent, NativeDocumentProvider nativeDocumentProvider) {
        this.mEvent = nativeJSEvent;
        this.mDocumentProvider = nativeDocumentProvider;
    }

    public NativeDocumentProvider getDocumentProvider() {
        return this.mDocumentProvider;
    }

    public NativeJSEvent getEvent() {
        return this.mEvent;
    }

    public String toString() {
        return "NativeJSEnvironment{mEvent=" + this.mEvent + ",mDocumentProvider=" + this.mDocumentProvider + "}";
    }
}
