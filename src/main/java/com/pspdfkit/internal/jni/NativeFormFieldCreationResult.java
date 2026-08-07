package com.pspdfkit.internal.jni;

import com.pspdfkit.internal.nv;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeFormFieldCreationResult {
    final NativeFormField mCreatedFormField;
    final String mErrorMessage;

    public NativeFormFieldCreationResult(NativeFormField nativeFormField, String str) {
        this.mCreatedFormField = nativeFormField;
        this.mErrorMessage = str;
    }

    public NativeFormField getCreatedFormField() {
        return this.mCreatedFormField;
    }

    public String getErrorMessage() {
        return this.mErrorMessage;
    }

    public String toString() {
        return nv.a(new StringBuilder("NativeFormFieldCreationResult{mCreatedFormField=").append(this.mCreatedFormField).append(",mErrorMessage="), this.mErrorMessage, "}");
    }
}
