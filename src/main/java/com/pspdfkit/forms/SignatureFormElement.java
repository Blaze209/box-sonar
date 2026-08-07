package com.pspdfkit.forms;

import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationProviderBlocking;
import com.pspdfkit.annotations.InkAnnotation;
import com.pspdfkit.annotations.StampAnnotation;
import com.pspdfkit.annotations.WidgetAnnotation;
import com.pspdfkit.internal.lm;
import com.pspdfkit.signatures.DigitalSignatureInfo;
import io.reactivex.rxjava3.core.Maybe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public class SignatureFormElement extends FormElement {
    public SignatureFormElement(SignatureFormField signatureFormField, WidgetAnnotation widgetAnnotation) {
        super(signatureFormField, widgetAnnotation);
    }

    public Annotation getOverlappingSignature() {
        lm internalDocument = getAnnotation().getInternal().getInternalDocument();
        if (internalDocument == null) {
            return null;
        }
        ArrayList<Integer> overlappingInkAndStampSignatureIds = getFormField().getInternal().getNativeFormField().getOverlappingInkAndStampSignatureIds(getAnnotation().getObjectNumber());
        if (overlappingInkAndStampSignatureIds.isEmpty()) {
            return null;
        }
        return AnnotationProviderBlocking.getAnnotationBlocking(internalDocument.getAnnotationProvider(), getAnnotation().getPageIndex(), overlappingInkAndStampSignatureIds.get(0).intValue());
    }

    public Maybe<Annotation> getOverlappingSignatureAsync() {
        return Maybe.fromCallable(new Callable() { // from class: com.pspdfkit.forms.SignatureFormElement$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.getOverlappingSignature();
            }
        }).subscribeOn(getAnnotation().getInternal().getInternalDocument().b(5));
    }

    public List<Annotation> getOverlappingSignatures() {
        lm internalDocument = getAnnotation().getInternal().getInternalDocument();
        if (internalDocument == null) {
            return Collections.EMPTY_LIST;
        }
        HashSet hashSet = new HashSet(getFormField().getInternal().getNativeFormField().getOverlappingInkAndStampSignatureIds(getAnnotation().getObjectNumber()));
        if (hashSet.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<Annotation> annotationsBlocking = AnnotationProviderBlocking.getAnnotationsBlocking(internalDocument.getAnnotationProvider(), getAnnotation().getPageIndex());
        ArrayList arrayList = new ArrayList();
        for (Annotation annotation : annotationsBlocking) {
            if ((annotation instanceof InkAnnotation) || (annotation instanceof StampAnnotation)) {
                if (hashSet.contains(Integer.valueOf(annotation.getObjectNumber()))) {
                    hashSet.remove(Integer.valueOf(annotation.getObjectNumber()));
                    arrayList.add(annotation);
                }
            }
        }
        return arrayList;
    }

    public DigitalSignatureInfo getSignatureInfo() {
        return getFormField().getSignatureInfo();
    }

    @Override // com.pspdfkit.forms.FormElement
    public FormType getType() {
        return FormType.SIGNATURE;
    }

    public boolean isSigned() {
        return getFormField().getSignatureInfo().isSigned();
    }

    @Override // com.pspdfkit.forms.FormElement
    public SignatureFormField getFormField() {
        return (SignatureFormField) super.getFormField();
    }
}
