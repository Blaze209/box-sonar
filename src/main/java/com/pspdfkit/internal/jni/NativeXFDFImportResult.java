package com.pspdfkit.internal.jni;

import com.pspdfkit.internal.nv;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeXFDFImportResult {
    final String mErrorMessage;
    final ArrayList<NativeAnnotation> mImportedAnnotations;
    final boolean mSuccess;

    public NativeXFDFImportResult(ArrayList<NativeAnnotation> arrayList, boolean z, String str) {
        this.mImportedAnnotations = arrayList;
        this.mSuccess = z;
        this.mErrorMessage = str;
    }

    public String getErrorMessage() {
        return this.mErrorMessage;
    }

    public ArrayList<NativeAnnotation> getImportedAnnotations() {
        return this.mImportedAnnotations;
    }

    public boolean getSuccess() {
        return this.mSuccess;
    }

    public String toString() {
        return nv.a(new StringBuilder("NativeXFDFImportResult{mImportedAnnotations=").append(this.mImportedAnnotations).append(",mSuccess=").append(this.mSuccess).append(",mErrorMessage="), this.mErrorMessage, "}");
    }
}
