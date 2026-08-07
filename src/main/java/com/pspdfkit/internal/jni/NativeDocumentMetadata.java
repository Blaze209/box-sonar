package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeDocumentMetadata {
    public static final String XMP_DC_NAMESPACE = "http://purl.org/dc/elements/1.1/";
    public static final String XMP_DC_NAMESPACE_PREFIX = "dc";
    public static final String XMP_PDF_NAMESPACE = "http://ns.adobe.com/pdf/1.3/";
    public static final String XMP_PDF_NAMESPACE_PREFIX = "pdf";
    public static final String XMP_XMP_NAMESPACE = "http://ns.adobe.com/xap/1.0/";
    public static final String XMP_XMP_NAMESPACE_PREFIX = "xmp";

    public static final class CppProxy extends NativeDocumentMetadata {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeDocumentMetadata create(NativeDocument nativeDocument);

        private native void nativeDestroy(long j);

        private native NativeDocument native_getDocument(long j);

        private native NativePDFObject native_getFromPDF(long j, String str, Integer num);

        private native NativeXMPMetadataRecord native_getFromXMP(long j, String str, String str2, Integer num);

        private native ArrayList<String> native_getTopLevelKeysFromPDF(long j, Integer num);

        private native void native_setInPDF(long j, String str, NativePDFObject nativePDFObject, Integer num);

        private native void native_setInXMP(long j, String str, NativeXMPMetadataRecord nativeXMPMetadataRecord, String str2, String str3, Integer num);

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

        @Override // com.pspdfkit.internal.jni.NativeDocumentMetadata
        public NativeDocument getDocument() {
            return native_getDocument(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentMetadata
        public NativePDFObject getFromPDF(String str, Integer num) {
            return native_getFromPDF(this.nativeRef, str, num);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentMetadata
        public NativeXMPMetadataRecord getFromXMP(String str, String str2, Integer num) {
            return native_getFromXMP(this.nativeRef, str, str2, num);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentMetadata
        public ArrayList<String> getTopLevelKeysFromPDF(Integer num) {
            return native_getTopLevelKeysFromPDF(this.nativeRef, num);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentMetadata
        public void setInPDF(String str, NativePDFObject nativePDFObject, Integer num) {
            native_setInPDF(this.nativeRef, str, nativePDFObject, num);
        }

        @Override // com.pspdfkit.internal.jni.NativeDocumentMetadata
        public void setInXMP(String str, NativeXMPMetadataRecord nativeXMPMetadataRecord, String str2, String str3, Integer num) {
            native_setInXMP(this.nativeRef, str, nativeXMPMetadataRecord, str2, str3, num);
        }
    }

    public static NativeDocumentMetadata create(NativeDocument nativeDocument) {
        return CppProxy.create(nativeDocument);
    }

    public abstract NativeDocument getDocument();

    public abstract NativePDFObject getFromPDF(String str, Integer num);

    public abstract NativeXMPMetadataRecord getFromXMP(String str, String str2, Integer num);

    public abstract ArrayList<String> getTopLevelKeysFromPDF(Integer num);

    public abstract void setInPDF(String str, NativePDFObject nativePDFObject, Integer num);

    public abstract void setInXMP(String str, NativeXMPMetadataRecord nativeXMPMetadataRecord, String str2, String str3, Integer num);
}
