package com.pspdfkit.internal.jni;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeImageDocument {

    public static final class CppProxy extends NativeImageDocument {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeImageDocumentOpenResult createImageDocument(NativeDataDescriptor nativeDataDescriptor);

        private native void nativeDestroy(long j);

        private native boolean native_cancelOperation(long j);

        private native NativeDocument native_getDocument(long j);

        private native NativeDataDescriptor native_getSourceDataDescriptor(long j);

        private native NativeDataDescriptor native_getTargetDataDescriptor(long j);

        private native NativeImageEncoding native_getTargetEncoding(long j);

        private native NativeResult native_open(long j);

        private native NativeResult native_saveIfModified(long j, NativeDocumentSaveOptions nativeDocumentSaveOptions, boolean z);

        private native void native_setTargetDataDescriptor(long j, NativeDataDescriptor nativeDataDescriptor);

        private native NativeResult native_setTargetEncoding(long j, NativeImageEncoding nativeImageEncoding, Byte b);

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

        @Override // com.pspdfkit.internal.jni.NativeImageDocument
        public boolean cancelOperation() {
            return native_cancelOperation(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeImageDocument
        public NativeDocument getDocument() {
            return native_getDocument(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeImageDocument
        public NativeDataDescriptor getSourceDataDescriptor() {
            return native_getSourceDataDescriptor(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeImageDocument
        public NativeDataDescriptor getTargetDataDescriptor() {
            return native_getTargetDataDescriptor(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeImageDocument
        public NativeImageEncoding getTargetEncoding() {
            return native_getTargetEncoding(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeImageDocument
        public NativeResult open() {
            return native_open(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeImageDocument
        public NativeResult saveIfModified(NativeDocumentSaveOptions nativeDocumentSaveOptions, boolean z) {
            return native_saveIfModified(this.nativeRef, nativeDocumentSaveOptions, z);
        }

        @Override // com.pspdfkit.internal.jni.NativeImageDocument
        public void setTargetDataDescriptor(NativeDataDescriptor nativeDataDescriptor) {
            native_setTargetDataDescriptor(this.nativeRef, nativeDataDescriptor);
        }

        @Override // com.pspdfkit.internal.jni.NativeImageDocument
        public NativeResult setTargetEncoding(NativeImageEncoding nativeImageEncoding, Byte b) {
            return native_setTargetEncoding(this.nativeRef, nativeImageEncoding, b);
        }
    }

    public static NativeImageDocumentOpenResult createImageDocument(NativeDataDescriptor nativeDataDescriptor) {
        return CppProxy.createImageDocument(nativeDataDescriptor);
    }

    public abstract boolean cancelOperation();

    public abstract NativeDocument getDocument();

    public abstract NativeDataDescriptor getSourceDataDescriptor();

    public abstract NativeDataDescriptor getTargetDataDescriptor();

    public abstract NativeImageEncoding getTargetEncoding();

    public abstract NativeResult open();

    public abstract NativeResult saveIfModified(NativeDocumentSaveOptions nativeDocumentSaveOptions, boolean z);

    public abstract void setTargetDataDescriptor(NativeDataDescriptor nativeDataDescriptor);

    public abstract NativeResult setTargetEncoding(NativeImageEncoding nativeImageEncoding, Byte b);
}
