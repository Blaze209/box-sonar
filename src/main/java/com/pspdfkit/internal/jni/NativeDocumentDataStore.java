package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeDocumentDataStore {

    public static final class CppProxy extends NativeDocumentDataStore {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeDocumentDataStoreCreateResult create(String str);

        private native void nativeDestroy(long j);

        private native void native_clear(long j);

        private native void native_clearValues(long j, String str);

        private native boolean native_copyToFile(long j, String str);

        private native boolean native_copyToSink(long j, NativeDataSink nativeDataSink);

        private native NativeDocumentData native_get(long j, String str);

        private native ArrayList<NativeDocumentDataUid> native_getUids(long j);

        private native long native_lastUpdated(long j);

        private native void native_prune(long j, int i, int i2);

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

        @Override // com.pspdfkit.internal.jni.NativeDocumentDataStore
        public void clear() {
            native_clear(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentDataStore
        public void clearValues(String str) {
            native_clearValues(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentDataStore
        public boolean copyToFile(String str) {
            return native_copyToFile(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentDataStore
        public boolean copyToSink(NativeDataSink nativeDataSink) {
            return native_copyToSink(this.nativeRef, nativeDataSink);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentDataStore
        public NativeDocumentData get(String str) {
            return native_get(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentDataStore
        public ArrayList<NativeDocumentDataUid> getUids() {
            return native_getUids(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentDataStore
        public long lastUpdated() {
            return native_lastUpdated(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentDataStore
        public void prune(int i, int i2) {
            native_prune(this.nativeRef, i, i2);
        }
    }

    public static NativeDocumentDataStoreCreateResult create(String str) {
        return CppProxy.create(str);
    }

    public abstract void clear();

    public abstract void clearValues(String str);

    public abstract boolean copyToFile(String str);

    public abstract boolean copyToSink(NativeDataSink nativeDataSink);

    public abstract NativeDocumentData get(String str);

    public abstract ArrayList<NativeDocumentDataUid> getUids();

    public abstract long lastUpdated();

    public abstract void prune(int i, int i2);
}
