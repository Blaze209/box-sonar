package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeX509Certificate {

    public static final class CppProxy extends NativeX509Certificate {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native ArrayList<NativeX509Certificate> createFromData(byte[] bArr, EnumSet<NativeX509ParseOptions> enumSet);

        private native void nativeDestroy(long j);

        private native String native_getIssuerCN(long j);

        private native String native_getIssuerDN(long j);

        private native NativePublicKey native_getPublicKey(long j);

        private native byte[] native_getSerialNumber(long j);

        private native String native_getSubjectCN(long j);

        private native String native_getSubjectDN(long j);

        private native Date native_getValidFrom(long j);

        private native Date native_getValidUntil(long j);

        private native boolean native_isCACertificate(long j);

        private native boolean native_isSelfSigned(long j);

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

        @Override // com.pspdfkit.internal.jni.NativeX509Certificate
        public String getIssuerCN() {
            return native_getIssuerCN(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeX509Certificate
        public String getIssuerDN() {
            return native_getIssuerDN(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeX509Certificate
        public NativePublicKey getPublicKey() {
            return native_getPublicKey(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeX509Certificate
        public byte[] getSerialNumber() {
            return native_getSerialNumber(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeX509Certificate
        public String getSubjectCN() {
            return native_getSubjectCN(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeX509Certificate
        public String getSubjectDN() {
            return native_getSubjectDN(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeX509Certificate
        public Date getValidFrom() {
            return native_getValidFrom(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeX509Certificate
        public Date getValidUntil() {
            return native_getValidUntil(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeX509Certificate
        public boolean isCACertificate() {
            return native_isCACertificate(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeX509Certificate
        public boolean isSelfSigned() {
            return native_isSelfSigned(this.nativeRef);
        }
    }

    public static ArrayList<NativeX509Certificate> createFromData(byte[] bArr, EnumSet<NativeX509ParseOptions> enumSet) {
        return CppProxy.createFromData(bArr, enumSet);
    }

    public abstract String getIssuerCN();

    public abstract String getIssuerDN();

    public abstract NativePublicKey getPublicKey();

    public abstract byte[] getSerialNumber();

    public abstract String getSubjectCN();

    public abstract String getSubjectDN();

    public abstract Date getValidFrom();

    public abstract Date getValidUntil();

    public abstract boolean isCACertificate();

    public abstract boolean isSelfSigned();
}
