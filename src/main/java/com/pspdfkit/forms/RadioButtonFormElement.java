package com.pspdfkit.forms;

import com.pspdfkit.annotations.WidgetAnnotation;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class RadioButtonFormElement extends EditableButtonFormElement {
    public RadioButtonFormElement(RadioButtonFormField radioButtonFormField, WidgetAnnotation widgetAnnotation) {
        super(radioButtonFormField, widgetAnnotation);
    }

    public String getExportValue() {
        return getFormControl().getExportValue(getObjectNumber());
    }

    public List<RadioButtonFormElement> getRadioGroup() {
        return getFormField().getFormElements();
    }

    @Override // com.pspdfkit.forms.FormElement
    public FormType getType() {
        return FormType.RADIOBUTTON;
    }

    @Override // com.pspdfkit.forms.FormElement
    public RadioButtonFormField getFormField() {
        return (RadioButtonFormField) super.getFormField();
    }
}
