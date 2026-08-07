package com.pspdfkit.forms;

import com.pspdfkit.annotations.WidgetAnnotation;

/* JADX INFO: loaded from: classes3.dex */
public class UnknownFormElement extends FormElement {
    public UnknownFormElement(FormField formField, WidgetAnnotation widgetAnnotation) {
        super(formField, widgetAnnotation);
    }

    @Override // com.pspdfkit.forms.FormElement
    public FormType getType() {
        return FormType.UNDEFINED;
    }
}
