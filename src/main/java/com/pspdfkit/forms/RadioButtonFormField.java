package com.pspdfkit.forms;

import com.pspdfkit.internal.jni.NativeFormField;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class RadioButtonFormField extends EditableButtonFormField {
    public RadioButtonFormField(int i, NativeFormField nativeFormField) {
        super(i, nativeFormField);
    }

    @Override // com.pspdfkit.forms.EditableButtonFormField, com.pspdfkit.forms.FormField
    public List<? extends RadioButtonFormElement> getFormElements() {
        return super.getFormElements();
    }

    @Override // com.pspdfkit.forms.EditableButtonFormField
    public List<? extends RadioButtonFormElement> getSelectedButtons() {
        return super.getSelectedButtons();
    }

    @Override // com.pspdfkit.forms.FormField
    public RadioButtonFormElement getFormElement() {
        return (RadioButtonFormElement) super.getFormElement();
    }
}
