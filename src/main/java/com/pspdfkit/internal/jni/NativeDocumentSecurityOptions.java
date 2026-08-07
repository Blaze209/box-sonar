package com.pspdfkit.internal.jni;

import java.util.EnumSet;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeDocumentSecurityOptions {
    final NativeDocumentSecurityEncryptionAlgorithm mEncryptionAlgorithm;
    final int mKeyLength;
    final String mOwnerPassword;
    final NativePDFVersion mPdfVersion;
    final EnumSet<NativeDocumentPermissions> mPermissionFlags;
    final String mUserPassword;

    public NativeDocumentSecurityOptions(String str, String str2, int i, EnumSet<NativeDocumentPermissions> enumSet, NativePDFVersion nativePDFVersion, NativeDocumentSecurityEncryptionAlgorithm nativeDocumentSecurityEncryptionAlgorithm) {
        this.mUserPassword = str;
        this.mOwnerPassword = str2;
        this.mKeyLength = i;
        this.mPermissionFlags = enumSet;
        this.mPdfVersion = nativePDFVersion;
        this.mEncryptionAlgorithm = nativeDocumentSecurityEncryptionAlgorithm;
    }

    public NativeDocumentSecurityEncryptionAlgorithm getEncryptionAlgorithm() {
        return this.mEncryptionAlgorithm;
    }

    public int getKeyLength() {
        return this.mKeyLength;
    }

    public String getOwnerPassword() {
        return this.mOwnerPassword;
    }

    public NativePDFVersion getPdfVersion() {
        return this.mPdfVersion;
    }

    public EnumSet<NativeDocumentPermissions> getPermissionFlags() {
        return this.mPermissionFlags;
    }

    public String getUserPassword() {
        return this.mUserPassword;
    }

    public String toString() {
        return "NativeDocumentSecurityOptions{mUserPassword=" + this.mUserPassword + ",mOwnerPassword=" + this.mOwnerPassword + ",mKeyLength=" + this.mKeyLength + ",mPermissionFlags=" + this.mPermissionFlags + ",mPdfVersion=" + this.mPdfVersion + ",mEncryptionAlgorithm=" + this.mEncryptionAlgorithm + "}";
    }
}
