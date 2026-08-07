package com.pspdfkit.internal.jni;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeLongTermValidationAdditionErrorList {
    public static final int CANNOT_ADD_LTV_INFORMATION = 3;
    public static final int CANNOT_PARSE_REVOCATION_RESPONSES = 0;
    public static final int NO_REVOCATION_RESPONSES = 2;
    public static final int REVOCATION_RESPONSES_IS_NOT_ARRAY = 1;
    public static final NativeLongTermValidationAdditionError CANNOT_PARSE_REVOCATION_RESPONSES_ERROR = new NativeLongTermValidationAdditionError(0, "Cannot parse the certificate revocation responses JSON");
    public static final NativeLongTermValidationAdditionError REVOCATION_RESPONSES_IS_NOT_ARRAY_ERROR = new NativeLongTermValidationAdditionError(1, "The revocation responses JSON is not an array");
    public static final NativeLongTermValidationAdditionError NO_REVOCATION_RESPONSES_ERROR = new NativeLongTermValidationAdditionError(2, "There are no certificate revocation responses, so no LTV information will be added");
    public static final NativeLongTermValidationAdditionError CANNOT_ADD_LTV_INFORMATION_ERROR = new NativeLongTermValidationAdditionError(3, "Cannot add LTV information to the document");

    public String toString() {
        return "NativeLongTermValidationAdditionErrorList{}";
    }
}
