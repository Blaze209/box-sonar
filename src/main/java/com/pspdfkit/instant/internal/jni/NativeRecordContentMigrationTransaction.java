package com.pspdfkit.instant.internal.jni;

import com.pspdfkit.internal.jni.NativeDocument;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeRecordContentMigrationTransaction {

    public static final class CppProxy extends NativeRecordContentMigrationTransaction {
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

        private native NativeInstantError native_commitChanges(long j);

        private native NativeDocument native_document(long j);

        private native NativeProgressReporter native_migrationProgress(long j);

        private native NativeRecordResult native_recordsToMigrate(long j);

        private native NativeInstantError native_rollbackChanges(long j);

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

        @Override // com.pspdfkit.instant.internal.jni.NativeRecordContentMigrationTransaction
        public NativeInstantError commitChanges() {
            return native_commitChanges(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeRecordContentMigrationTransaction
        public NativeDocument document() {
            return native_document(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeRecordContentMigrationTransaction
        public NativeProgressReporter migrationProgress() {
            return native_migrationProgress(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeRecordContentMigrationTransaction
        public NativeRecordResult recordsToMigrate() {
            return native_recordsToMigrate(this.nativeRef);
        }

        @Override // com.pspdfkit.instant.internal.jni.NativeRecordContentMigrationTransaction
        public NativeInstantError rollbackChanges() {
            return native_rollbackChanges(this.nativeRef);
        }
    }

    public abstract NativeInstantError commitChanges();

    public abstract NativeDocument document();

    public abstract NativeProgressReporter migrationProgress();

    public abstract NativeRecordResult recordsToMigrate();

    public abstract NativeInstantError rollbackChanges();
}
