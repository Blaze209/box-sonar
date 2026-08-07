package com.pspdfkit.exceptions;

import com.pspdfkit.internal.jni.NativeLongTermValidationAdditionError;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"LongTermValidationException", "Lcom/pspdfkit/exceptions/LongTermValidationException;", "coreError", "Lcom/pspdfkit/internal/jni/NativeLongTermValidationAdditionError;", "sdk-nutrient"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class LongTermValidationExceptionKt {
    public static final LongTermValidationException LongTermValidationException(NativeLongTermValidationAdditionError nativeLongTermValidationAdditionError) {
        nativeLongTermValidationAdditionError.getClass();
        String errorMessage = nativeLongTermValidationAdditionError.getErrorMessage();
        errorMessage.getClass();
        return new LongTermValidationException(errorMessage);
    }
}
