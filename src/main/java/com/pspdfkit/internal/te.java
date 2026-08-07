package com.pspdfkit.internal;

import com.pspdfkit.forms.FormField;
import com.pspdfkit.forms.FormType;
import com.pspdfkit.forms.SignatureFormField;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.signatures.DocumentSignatureInfo;
import com.pspdfkit.signatures.ValidationStatus;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes3.dex */
public final class te implements DocumentSignatureInfo {
    public final ArrayList a = new ArrayList();

    public te(lm lmVar) {
        if (ar.b().a(NativeLicenseFeatures.ACRO_FORMS) && ar.b().a(NativeLicenseFeatures.DIGITAL_SIGNATURES)) {
            for (FormField formField : lmVar.g.getFormFields()) {
                if (formField.getType() == FormType.SIGNATURE) {
                    this.a.add((SignatureFormField) formField);
                }
            }
        }
    }

    @Override // com.pspdfkit.signatures.DocumentSignatureInfo
    public final Calendar getLatestSignatureCreationDate() {
        ArrayList arrayList = this.a;
        int size = arrayList.size();
        int i = 0;
        long timeInMillis = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            SignatureFormField signatureFormField = (SignatureFormField) obj;
            if (signatureFormField.getSignatureInfo().getCreationDate() != null) {
                Calendar creationDate = signatureFormField.getSignatureInfo().getCreationDate();
                if (creationDate.getTimeInMillis() > timeInMillis) {
                    timeInMillis = creationDate.getTimeInMillis();
                }
            }
        }
        if (timeInMillis == 0) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.setTimeInMillis(timeInMillis);
        return calendar;
    }

    @Override // com.pspdfkit.signatures.DocumentSignatureInfo
    public final List<SignatureFormField> getSignatureFormFields() {
        return Collections.unmodifiableList(this.a);
    }

    @Override // com.pspdfkit.signatures.DocumentSignatureInfo
    public final List<String> getSigners() {
        ArrayList arrayList = new ArrayList(this.a.size());
        ArrayList arrayList2 = this.a;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            SignatureFormField signatureFormField = (SignatureFormField) obj;
            if (signatureFormField.getSignatureInfo().getName() != null) {
                arrayList.add(signatureFormField.getSignatureInfo().getName());
            }
        }
        return arrayList;
    }

    @Override // com.pspdfkit.signatures.DocumentSignatureInfo
    public final boolean isSigned() {
        ArrayList arrayList = this.a;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            if (((SignatureFormField) obj).getSignatureInfo().isSigned()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.pspdfkit.signatures.DocumentSignatureInfo
    public final ValidationStatus isValid() {
        ValidationStatus validationStatus = ValidationStatus.VALID;
        ArrayList arrayList = this.a;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ValidationStatus validationStatus2 = ((SignatureFormField) obj).getSignatureInfo().validate().getValidationStatus();
            ValidationStatus validationStatus3 = ValidationStatus.ERROR;
            validationStatus = (validationStatus == validationStatus3 || validationStatus2 == validationStatus3 || validationStatus == (validationStatus3 = ValidationStatus.WARNING) || validationStatus2 == validationStatus3) ? validationStatus3 : ValidationStatus.VALID;
        }
        return validationStatus;
    }

    @Override // com.pspdfkit.signatures.DocumentSignatureInfo
    public final void removeSignatureFormField(SignatureFormField signatureFormField) {
        this.a.remove(signatureFormField);
    }
}
