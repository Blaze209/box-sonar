package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativePDFVersion {
    final byte mMajorVersion;
    final byte mMinorVersion;

    public NativePDFVersion(byte b, byte b2) {
        this.mMajorVersion = b;
        this.mMinorVersion = b2;
    }

    public byte getMajorVersion() {
        return this.mMajorVersion;
    }

    public byte getMinorVersion() {
        return this.mMinorVersion;
    }

    public String toString() {
        return "NativePDFVersion{mMajorVersion=" + ((int) this.mMajorVersion) + ",mMinorVersion=" + ((int) this.mMinorVersion) + "}";
    }
}
