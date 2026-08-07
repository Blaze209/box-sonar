package com.pspdfkit.instant.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeDatabaseRecord {

    public static final class CppProxy extends NativeDatabaseRecord {
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

        private native byte[] native_canonicalContent(long j);

        private native int native_contentVersion(long j);

        private native String native_identifier(long j);

        private native byte[] native_localContent(long j);

        private native NativeInstantError native_markAsDeleted(long j);

        private native Integer native_pageIndex(long j);

        private native byte[] native_stagedContent(long j);

        private native String native_type(long j);

        private native NativeInstantError native_updateContentWithData(long j, byte[] bArr);

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

        @Override // com.pspdfkit.instant.internal.jni.NativeDatabaseRecord
        public byte[] canonicalContent() {
            return native_canonicalContent(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeDatabaseRecord
        public int contentVersion() {
            return native_contentVersion(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeDatabaseRecord
        public String identifier() {
            return native_identifier(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeDatabaseRecord
        public byte[] localContent() {
            return native_localContent(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeDatabaseRecord
        public NativeInstantError markAsDeleted() {
            return native_markAsDeleted(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeDatabaseRecord
        public Integer pageIndex() {
            return native_pageIndex(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeDatabaseRecord
        public byte[] stagedContent() {
            return native_stagedContent(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeDatabaseRecord
        public String type() {
            return native_type(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeDatabaseRecord
        public NativeInstantError updateContentWithData(byte[] bArr) {
            return native_updateContentWithData(this.nativeRef, bArr);
        }
    }

    public abstract byte[] canonicalContent();

    public abstract int contentVersion();

    public abstract String identifier();

    public abstract byte[] localContent();

    public abstract NativeInstantError markAsDeleted();

    public abstract Integer pageIndex();

    public abstract byte[] stagedContent();

    public abstract String type();

    public abstract NativeInstantError updateContentWithData(byte[] bArr);
}
