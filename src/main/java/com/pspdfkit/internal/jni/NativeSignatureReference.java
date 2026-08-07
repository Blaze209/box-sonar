package com.pspdfkit.internal.jni;

import com.pspdfkit.datastructures.Range;
import com.pspdfkit.internal.nv;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeSignatureReference {
    final String mDataName;
    final Range mDigestLocation;
    final String mDigestMethod;
    final String mDigestValue;
    final NativeSignatureReferenceTransformMethod mTransformMethod;
    final NativePDFObject mTransformParams;

    public NativeSignatureReference(NativeSignatureReferenceTransformMethod nativeSignatureReferenceTransformMethod, NativePDFObject nativePDFObject, String str, String str2, Range range, String str3) {
        this.mTransformMethod = nativeSignatureReferenceTransformMethod;
        this.mTransformParams = nativePDFObject;
        this.mDigestMethod = str;
        this.mDigestValue = str2;
        this.mDigestLocation = range;
        this.mDataName = str3;
    }

    public String getDataName() {
        return this.mDataName;
    }

    public Range getDigestLocation() {
        return this.mDigestLocation;
    }

    public String getDigestMethod() {
        return this.mDigestMethod;
    }

    public String getDigestValue() {
        return this.mDigestValue;
    }

    public NativeSignatureReferenceTransformMethod getTransformMethod() {
        return this.mTransformMethod;
    }

    public NativePDFObject getTransformParams() {
        return this.mTransformParams;
    }

    public String toString() {
        return nv.a(new StringBuilder("NativeSignatureReference{mTransformMethod=").append(this.mTransformMethod).append(",mTransformParams=").append(this.mTransformParams).append(",mDigestMethod=").append(this.mDigestMethod).append(",mDigestValue=").append(this.mDigestValue).append(",mDigestLocation=").append(this.mDigestLocation).append(",mDataName="), this.mDataName, "}");
    }
}
