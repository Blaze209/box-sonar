package com.pspdfkit.forms;

import com.pspdfkit.annotations.WidgetAnnotation;

/* JADX INFO: loaded from: classes3.dex */
public class CheckBoxFormElement extends EditableButtonFormElement {
    public CheckBoxFormElement(CheckBoxFormField checkBoxFormField, WidgetAnnotation widgetAnnotation) {
        super(checkBoxFormField, widgetAnnotation);
    }

    public String getExportValue() {
        return getFormControl().getExportValue(getObjectNumber());
    }

    @Override // com.pspdfkit.forms.FormElement
    public FormType getType() {
        return FormType.CHECKBOX;
    }

    @Override // com.pspdfkit.forms.FormElement
    public CheckBoxFormField getFormField() {
        return (CheckBoxFormField) super.getFormField();
    }
}
