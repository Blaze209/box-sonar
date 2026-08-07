package com.pspdfkit.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeContentEditor {

    public static final class CppProxy extends NativeContentEditor {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeContentEditor create(NativeDocument nativeDocument);

        private native void nativeDestroy(long j);

        private native NativeContentEditingResult native_executeCommand(long j, NativeContentEditingCommand nativeContentEditingCommand, String str);

        private native void native_releaseResources(long j);

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

        @Override // com.pspdfkit.internal.jni.NativeContentEditor
        public NativeContentEditingResult executeCommand(NativeContentEditingCommand nativeContentEditingCommand, String str) {
            return native_executeCommand(this.nativeRef, nativeContentEditingCommand, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeContentEditor
        public void releaseResources() {
            native_releaseResources(this.nativeRef);
        }
    }

    public static NativeContentEditor create(NativeDocument nativeDocument) {
        return CppProxy.create(nativeDocument);
    }

    public abstract NativeContentEditingResult executeCommand(NativeContentEditingCommand nativeContentEditingCommand, String str);

    public abstract void releaseResources();
}
