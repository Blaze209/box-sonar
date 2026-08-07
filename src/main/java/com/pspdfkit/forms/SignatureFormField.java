package com.pspdfkit.forms;

import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.exceptions.InvalidNutrientLicenseException;
import com.pspdfkit.exceptions.NutrientException;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.jni.NativeFormField;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.jni.NativeSignatureRemovalResult;
import com.pspdfkit.internal.lm;
import com.pspdfkit.signatures.DigitalSignatureInfo;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.functions.Action;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class SignatureFormField extends FormField {
    private DigitalSignatureInfo signature;

    public SignatureFormField(lm lmVar, int i, NativeFormField nativeFormField) {
        super(i, nativeFormField);
        this.signature = new DigitalSignatureInfo(lmVar, i, nativeFormField);
    }

    @Override // com.pspdfkit.forms.FormField
    public List<? extends SignatureFormElement> getFormElements() {
        return super.getFormElements();
    }

    public DigitalSignatureInfo getSignatureInfo() {
        if (ar.b().a(NativeLicenseFeatures.DIGITAL_SIGNATURES)) {
            return this.signature;
        }
        throw new InvalidNutrientLicenseException("Retrieving digital signature information of a form field requires the digital signature feature in your license.");
    }

    public void removeSignature() {
        if (!ar.b().a(NativeLicenseFeatures.DIGITAL_SIGNATURES)) {
            throw new InvalidNutrientLicenseException("Removing digital signature information of a form field requires the digital signature feature in your license.");
        }
        HashSet hashSet = new HashSet();
        ArrayList<Integer> annotationWidgetIds = getInternal().getNativeFormField().getAnnotationWidgetIds();
        int size = annotationWidgetIds.size();
        int i = 0;
        while (i < size) {
            Integer num = annotationWidgetIds.get(i);
            i++;
            hashSet.add(getInternal().getNativeFormField().getPageForAnnotation(num.intValue()));
        }
        PdfDocument document = this.signature.getDocument();
        NativeSignatureRemovalResult nativeSignatureRemovalResultRemoveDigitalSignature = getInternal().getNativeFormField().removeDigitalSignature();
        if (nativeSignatureRemovalResultRemoveDigitalSignature.getHasError()) {
            throw new NutrientException(nativeSignatureRemovalResultRemoveDigitalSignature.getErrorMessage());
        }
        this.signature = new DigitalSignatureInfo(this.signature);
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            document.invalidateCacheForPage(((Integer) it.next()).intValue());
        }
    }

    public Completable removeSignatureAsync() {
        if (ar.b().a(NativeLicenseFeatures.DIGITAL_SIGNATURES)) {
            return Completable.fromAction(new Action() { // from class: com.pspdfkit.forms.SignatureFormField$$ExternalSyntheticLambda0
                @Override // io.reactivex.rxjava3.functions.Action
                public final void run() {
                    this.f$0.removeSignature();
                }
            });
        }
        throw new InvalidNutrientLicenseException("Removing digital signature information of a form field requires the digital signature feature in your license.");
    }
}
