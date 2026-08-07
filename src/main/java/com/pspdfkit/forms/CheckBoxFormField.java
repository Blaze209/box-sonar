package com.pspdfkit.forms;

import com.pspdfkit.internal.jni.NativeFormField;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class CheckBoxFormField extends EditableButtonFormField {
    public CheckBoxFormField(int i, NativeFormField nativeFormField) {
        super(i, nativeFormField);
    }

    @Override // com.pspdfkit.forms.EditableButtonFormField, com.pspdfkit.forms.FormField
    public List<? extends CheckBoxFormElement> getFormElements() {
        return super.getFormElements();
    }

    @Override // com.pspdfkit.forms.EditableButtonFormField
    public List<? extends CheckBoxFormElement> getSelectedButtons() {
        return super.getSelectedButtons();
    }

    @Override // com.pspdfkit.forms.FormField
    public CheckBoxFormElement getFormElement() {
        return (CheckBoxFormElement) super.getFormElement();
    }
}
