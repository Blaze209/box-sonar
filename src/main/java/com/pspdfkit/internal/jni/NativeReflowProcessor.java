package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeReflowProcessor {

    public static final class CppProxy extends NativeReflowProcessor {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeReflowProcessorCreationResult create(NativeReflowConfiguration nativeReflowConfiguration, NativeReflowProcessorDelegate nativeReflowProcessorDelegate);

        private native void nativeDestroy(long j);

        private native String native_getReflowedDocument(long j);

        private native NativeReflowResult native_reflowAllPages(long j);

        private native NativeReflowResult native_reflowPages(long j, ArrayList<Integer> arrayList);

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

        @Override // com.pspdfkit.internal.jni.NativeReflowProcessor
        public String getReflowedDocument() {
            return native_getReflowedDocument(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeReflowProcessor
        public NativeReflowResult reflowAllPages() {
            return native_reflowAllPages(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeReflowProcessor
        public NativeReflowResult reflowPages(ArrayList<Integer> arrayList) {
            return native_reflowPages(this.nativeRef, arrayList);
        }
    }

    public static NativeReflowProcessorCreationResult create(NativeReflowConfiguration nativeReflowConfiguration, NativeReflowProcessorDelegate nativeReflowProcessorDelegate) {
        return CppProxy.create(nativeReflowConfiguration, nativeReflowProcessorDelegate);
    }

    public abstract String getReflowedDocument();

    public abstract NativeReflowResult reflowAllPages();

    public abstract NativeReflowResult reflowPages(ArrayList<Integer> arrayList);
}
