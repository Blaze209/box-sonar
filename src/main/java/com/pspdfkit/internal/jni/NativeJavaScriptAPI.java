package com.pspdfkit.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeJavaScriptAPI {

    public static final class CppProxy extends NativeJavaScriptAPI {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        private native void nativeDestroy(long j);

        private native void native_addEvaluationObserver(long j, NativeJSEvaluationObserver nativeJSEvaluationObserver);

        private native NativeJSResult native_evaluateScript(long j, NativeJSScriptDescriptor nativeJSScriptDescriptor, NativeJSPlatformDelegate nativeJSPlatformDelegate);

        private native String native_getInitPath(long j);

        private native void native_removeEvaluationObserver(long j, NativeJSEvaluationObserver nativeJSEvaluationObserver);

        public void _djinni_private_destroy() {
            if (this.destroyed.getAndSet(true)) {
                return;
            }
            nativeDestroy(this.nativeRef);
        }

        public void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.pspdfkit.internal.jni.NativeJavaScriptAPI
        public void addEvaluationObserver(NativeJSEvaluationObserver nativeJSEvaluationObserver) {
            native_addEvaluationObserver(this.nativeRef, nativeJSEvaluationObserver);
        }

        @Override // com.pspdfkit.internal.jni.NativeJavaScriptAPI
        public NativeJSResult evaluateScript(NativeJSScriptDescriptor nativeJSScriptDescriptor, NativeJSPlatformDelegate nativeJSPlatformDelegate) {
            return native_evaluateScript(this.nativeRef, nativeJSScriptDescriptor, nativeJSPlatformDelegate);
        }

        @Override // com.pspdfkit.internal.jni.NativeJavaScriptAPI
        public String getInitPath() {
            return native_getInitPath(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeJavaScriptAPI
        public void removeEvaluationObserver(NativeJSEvaluationObserver nativeJSEvaluationObserver) {
            native_removeEvaluationObserver(this.nativeRef, nativeJSEvaluationObserver);
        }
    }

    public abstract void addEvaluationObserver(NativeJSEvaluationObserver nativeJSEvaluationObserver);

    public abstract NativeJSResult evaluateScript(NativeJSScriptDescriptor nativeJSScriptDescriptor, NativeJSPlatformDelegate nativeJSPlatformDelegate);

    public abstract String getInitPath();

    public abstract void removeEvaluationObserver(NativeJSEvaluationObserver nativeJSEvaluationObserver);
}
