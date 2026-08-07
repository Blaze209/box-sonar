package com.pspdfkit.internal.jni;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeSignatureValidationResult {
    final NativeDocumentIntegrityStatus mDocumentIntegrityStatus;
    final ArrayList<NativeSignatureValidationProblem> mErrors;
    final NativeSignatureValidationInformation mSignatureInformation;
    final NativeSignatureValidationStatus mStatus;

    public NativeSignatureValidationResult(NativeSignatureValidationStatus nativeSignatureValidationStatus, ArrayList<NativeSignatureValidationProblem> arrayList, NativeDocumentIntegrityStatus nativeDocumentIntegrityStatus, NativeSignatureValidationInformation nativeSignatureValidationInformation) {
        this.mStatus = nativeSignatureValidationStatus;
        this.mErrors = arrayList;
        this.mDocumentIntegrityStatus = nativeDocumentIntegrityStatus;
        this.mSignatureInformation = nativeSignatureValidationInformation;
    }

    public NativeDocumentIntegrityStatus getDocumentIntegrityStatus() {
        return this.mDocumentIntegrityStatus;
    }

    public ArrayList<NativeSignatureValidationProblem> getErrors() {
        return this.mErrors;
    }

    public NativeSignatureValidationInformation getSignatureInformation() {
        return this.mSignatureInformation;
    }

    public NativeSignatureValidationStatus getStatus() {
        return this.mStatus;
    }

    public String toString() {
        return "NativeSignatureValidationResult{mStatus=" + this.mStatus + ",mErrors=" + this.mErrors + ",mDocumentIntegrityStatus=" + this.mDocumentIntegrityStatus + ",mSignatureInformation=" + this.mSignatureInformation + "}";
    }
}
