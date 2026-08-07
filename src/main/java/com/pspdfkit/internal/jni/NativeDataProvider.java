package com.pspdfkit.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeDataProvider {

    public static final class CppProxy extends NativeDataProvider {
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

        private native NativeDataSink native_createDataSink(long j, NativeDataSinkOption nativeDataSinkOption);

        private native long native_getSize(long j);

        private native String native_getUid(long j);

        private native NativeSpanView native_read(long j, long j2, long j3);

        private native boolean native_replaceWithDataSink(long j, NativeDataSink nativeDataSink);

        private native boolean native_supportsAppending(long j);

        private native boolean native_supportsWriting(long j);

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

        @Override // com.pspdfkit.internal.jni.NativeDataProvider
        public NativeDataSink createDataSink(NativeDataSinkOption nativeDataSinkOption) {
            return native_createDataSink(this.nativeRef, nativeDataSinkOption);
        }

        @Override // com.pspdfkit.internal.jni.NativeDataProvider
        public long getSize() {
            return native_getSize(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDataProvider
        public String getUid() {
            return native_getUid(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDataProvider
        public NativeSpanView read(long j, long j2) {
            return native_read(this.nativeRef, j, j2);
        }

        @Override // com.pspdfkit.internal.jni.NativeDataProvider
        public boolean replaceWithDataSink(NativeDataSink nativeDataSink) {
            return native_replaceWithDataSink(this.nativeRef, nativeDataSink);
        }

        @Override // com.pspdfkit.internal.jni.NativeDataProvider
        public boolean supportsAppending() {
            return native_supportsAppending(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDataProvider
        public boolean supportsWriting() {
            return native_supportsWriting(this.nativeRef);
        }
    }

    public abstract NativeDataSink createDataSink(NativeDataSinkOption nativeDataSinkOption);

    public abstract long getSize();

    public abstract String getUid();

    public abstract NativeSpanView read(long j, long j2);

    public abstract boolean replaceWithDataSink(NativeDataSink nativeDataSink);

    public abstract boolean supportsAppending();

    public abstract boolean supportsWriting();
}
