package com.pspdfkit.internal.jni;

import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeAPStreamDocumentGenerator {

    public static final class CppProxy extends NativeAPStreamDocumentGenerator {
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

        private native NativeAPStreamResult native_generateAPStream(long j, NativeAnnotation nativeAnnotation, EnumSet<NativeAPStreamGenerationOptions> enumSet);

        private native boolean native_shouldUseApstreamDocumentGenerator(long j, NativeAnnotation nativeAnnotation);

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

        @Override // com.pspdfkit.internal.jni.NativeAPStreamDocumentGenerator
        public NativeAPStreamResult generateAPStream(NativeAnnotation nativeAnnotation, EnumSet<NativeAPStreamGenerationOptions> enumSet) {
            return native_generateAPStream(this.nativeRef, nativeAnnotation, enumSet);
        }

        @Override // com.pspdfkit.internal.jni.NativeAPStreamDocumentGenerator
        public boolean shouldUseApstreamDocumentGenerator(NativeAnnotation nativeAnnotation) {
            return native_shouldUseApstreamDocumentGenerator(this.nativeRef, nativeAnnotation);
        }
    }

    public abstract NativeAPStreamResult generateAPStream(NativeAnnotation nativeAnnotation, EnumSet<NativeAPStreamGenerationOptions> enumSet);

    public abstract boolean shouldUseApstreamDocumentGenerator(NativeAnnotation nativeAnnotation);
}
