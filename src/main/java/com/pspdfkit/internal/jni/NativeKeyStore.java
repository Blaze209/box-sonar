package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeKeyStore {

    public static final class CppProxy extends NativeKeyStore {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeKeyStore create();

        private native void nativeDestroy(long j);

        private native void native_addCertificate(long j, NativeX509Certificate nativeX509Certificate);

        private native void native_addCertificates(long j, ArrayList<NativeX509Certificate> arrayList);

        private native int native_numberOfCertificates(long j);

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

        @Override // com.pspdfkit.internal.jni.NativeKeyStore
        public void addCertificate(NativeX509Certificate nativeX509Certificate) {
            native_addCertificate(this.nativeRef, nativeX509Certificate);
        }

        @Override // com.pspdfkit.internal.jni.NativeKeyStore
        public void addCertificates(ArrayList<NativeX509Certificate> arrayList) {
            native_addCertificates(this.nativeRef, arrayList);
        }

        @Override // com.pspdfkit.internal.jni.NativeKeyStore
        public int numberOfCertificates() {
            return native_numberOfCertificates(this.nativeRef);
        }
    }

    public static NativeKeyStore create() {
        return CppProxy.create();
    }

    public abstract void addCertificate(NativeX509Certificate nativeX509Certificate);

    public abstract void addCertificates(ArrayList<NativeX509Certificate> arrayList);

    public abstract int numberOfCertificates();
}
