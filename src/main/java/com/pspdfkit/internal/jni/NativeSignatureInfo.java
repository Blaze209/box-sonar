package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeSignatureInfo {

    public static final class CppProxy extends NativeSignatureInfo {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native NativeSignatureInfo create();

        private native void nativeDestroy(long j);

        private native byte[] native_getBiometricProperties(long j);

        private native NativeSignatureBuildProperties native_getBuildProperties(long j);

        private native ArrayList<Long> native_getByteRange(long j);

        private native byte[] native_getContents(long j);

        private native Date native_getCreationDate(long j);

        private native int native_getEstimatedSize(long j);

        private native String native_getFilter(long j);

        private native String native_getLocation(long j);

        private native String native_getName(long j);

        private native String native_getReason(long j);

        private native ArrayList<NativeSignatureReference> native_getReferences(long j);

        private native String native_getSubFilter(long j);

        private native NativeSignatureBiometricProperties native_getUnencryptedBiometricProperties(long j, NativePrivateKey nativePrivateKey);

        private native void native_setBiometricProperties(long j, byte[] bArr);

        private native void native_setBuildProperties(long j, NativeSignatureBuildProperties nativeSignatureBuildProperties);

        private native void native_setByteRange(long j, ArrayList<Long> arrayList);

        private native void native_setContents(long j, byte[] bArr);

        private native void native_setCreationDate(long j, Date date);

        private native void native_setEstimatedSize(long j, int i);

        private native void native_setFilter(long j, String str);

        private native void native_setLocation(long j, String str);

        private native void native_setName(long j, String str);

        private native void native_setReason(long j, String str);

        private native void native_setSubFilter(long j, String str);

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

        @Override // com.pspdfkit.internal.jni.NativeSignatureInfo
        public byte[] getBiometricProperties() {
            return native_getBiometricProperties(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureInfo
        public NativeSignatureBuildProperties getBuildProperties() {
            return native_getBuildProperties(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureInfo
        public ArrayList<Long> getByteRange() {
            return native_getByteRange(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureInfo
        public byte[] getContents() {
            return native_getContents(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureInfo
        public Date getCreationDate() {
            return native_getCreationDate(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureInfo
        public int getEstimatedSize() {
            return native_getEstimatedSize(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureInfo
        public String getFilter() {
            return native_getFilter(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureInfo
        public String getLocation() {
            return native_getLocation(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureInfo
        public String getName() {
            return native_getName(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureInfo
        public String getReason() {
            return native_getReason(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureInfo
        public ArrayList<NativeSignatureReference> getReferences() {
            return native_getReferences(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureInfo
        public String getSubFilter() {
            return native_getSubFilter(this.nativeRef);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureInfo
        public NativeSignatureBiometricProperties getUnencryptedBiometricProperties(NativePrivateKey nativePrivateKey) {
            return native_getUnencryptedBiometricProperties(this.nativeRef, nativePrivateKey);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureInfo
        public void setBiometricProperties(byte[] bArr) {
            native_setBiometricProperties(this.nativeRef, bArr);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureInfo
        public void setBuildProperties(NativeSignatureBuildProperties nativeSignatureBuildProperties) {
            native_setBuildProperties(this.nativeRef, nativeSignatureBuildProperties);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureInfo
        public void setByteRange(ArrayList<Long> arrayList) {
            native_setByteRange(this.nativeRef, arrayList);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureInfo
        public void setContents(byte[] bArr) {
            native_setContents(this.nativeRef, bArr);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureInfo
        public void setCreationDate(Date date) {
            native_setCreationDate(this.nativeRef, date);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureInfo
        public void setEstimatedSize(int i) {
            native_setEstimatedSize(this.nativeRef, i);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureInfo
        public void setFilter(String str) {
            native_setFilter(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureInfo
        public void setLocation(String str) {
            native_setLocation(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureInfo
        public void setName(String str) {
            native_setName(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureInfo
        public void setReason(String str) {
            native_setReason(this.nativeRef, str);
        }

        @Override // com.pspdfkit.internal.jni.NativeSignatureInfo
        public void setSubFilter(String str) {
            native_setSubFilter(this.nativeRef, str);
        }
    }

    public static NativeSignatureInfo create() {
        return CppProxy.create();
    }

    public abstract byte[] getBiometricProperties();

    public abstract NativeSignatureBuildProperties getBuildProperties();

    public abstract ArrayList<Long> getByteRange();

    public abstract byte[] getContents();

    public abstract Date getCreationDate();

    public abstract int getEstimatedSize();

    public abstract String getFilter();

    public abstract String getLocation();

    public abstract String getName();

    public abstract String getReason();

    public abstract ArrayList<NativeSignatureReference> getReferences();

    public abstract String getSubFilter();

    public abstract NativeSignatureBiometricProperties getUnencryptedBiometricProperties(NativePrivateKey nativePrivateKey);

    public abstract void setBiometricProperties(byte[] bArr);

    public abstract void setBuildProperties(NativeSignatureBuildProperties nativeSignatureBuildProperties);

    public abstract void setByteRange(ArrayList<Long> arrayList);

    public abstract void setContents(byte[] bArr);

    public abstract void setCreationDate(Date date);

    public abstract void setEstimatedSize(int i);

    public abstract void setFilter(String str);

    public abstract void setLocation(String str);

    public abstract void setName(String str);

    public abstract void setReason(String str);

    public abstract void setSubFilter(String str);
}
