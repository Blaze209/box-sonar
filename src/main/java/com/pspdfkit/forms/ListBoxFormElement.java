package com.pspdfkit.forms;

import com.pspdfkit.annotations.WidgetAnnotation;

/* JADX INFO: loaded from: classes3.dex */
public class ListBoxFormElement extends ChoiceFormElement {
    public ListBoxFormElement(ListBoxFormField listBoxFormField, WidgetAnnotation widgetAnnotation) {
        super(listBoxFormField, widgetAnnotation);
    }

    @Override // com.pspdfkit.forms.FormElement
    public FormType getType() {
        return FormType.LISTBOX;
    }

    @Override // com.pspdfkit.forms.ChoiceFormElement, com.pspdfkit.forms.FormElement
    public ListBoxFormField getFormField() {
        return (ListBoxFormField) super.getFormField();
    }
}
