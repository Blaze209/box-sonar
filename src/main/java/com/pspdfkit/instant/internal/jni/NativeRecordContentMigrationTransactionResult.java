package com.pspdfkit.instant.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeRecordContentMigrationTransactionResult {

    public static final class CppProxy extends NativeRecordContentMigrationTransactionResult {
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

        private native NativeInstantError native_error(long j);

        private native boolean native_isError(long j);

        private native NativeRecordContentMigrationTransaction native_value(long j);

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

        @Override // com.pspdfkit.instant.internal.jni.NativeRecordContentMigrationTransactionResult
        public NativeInstantError error() {
            return native_error(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeRecordContentMigrationTransactionResult
        public boolean isError() {
            return native_isError(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeRecordContentMigrationTransactionResult
        public NativeRecordContentMigrationTransaction value() {
            return native_value(this.nativeRef);
        }
    }

    public abstract NativeInstantError error();

    public abstract boolean isError();

    public abstract NativeRecordContentMigrationTransaction value();
}
