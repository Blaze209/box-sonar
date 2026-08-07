package com.pspdfkit.internal.jni;

import com.pspdfkit.internal.nv;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeLongTermValidationAdditionError {
    final int mCode;
    final String mErrorMessage;

    public NativeLongTermValidationAdditionError(int i, String str) {
        this.mCode = i;
        this.mErrorMessage = str;
    }

    public int getCode() {
        return this.mCode;
    }

    public String getErrorMessage() {
        return this.mErrorMessage;
    }

    public String toString() {
        return nv.a(new StringBuilder("NativeLongTermValidationAdditionError{mCode=").append(this.mCode).append(",mErrorMessage="), this.mErrorMessage, "}");
    }
}
