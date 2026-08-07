package com.pspdfkit.internal;

import com.pspdfkit.forms.FormElement;
import com.pspdfkit.forms.FormField;

/* JADX INFO: loaded from: classes3.dex */
public final class bi {
    public static final FormElement a(FormField formField, int i) {
        for (FormElement formElement : formField.getFormElements()) {
            if (formElement.getAnnotation().getObjectNumber() == i) {
                return formElement;
            }
        }
        return null;
    }
}
