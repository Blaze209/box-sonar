package com.pspdfkit.signatures;

import com.pspdfkit.forms.SignatureFormField;
import java.util.Calendar;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface DocumentSignatureInfo {
    Calendar getLatestSignatureCreationDate();

    List<SignatureFormField> getSignatureFormFields();

    List<String> getSigners();

    boolean isSigned();

    ValidationStatus isValid();

    void removeSignatureFormField(SignatureFormField signatureFormField);
}
