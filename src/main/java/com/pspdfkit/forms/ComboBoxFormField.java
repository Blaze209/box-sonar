package com.pspdfkit.forms;

import com.pspdfkit.internal.jni.NativeFormField;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ComboBoxFormField extends ChoiceFormField {
    public ComboBoxFormField(int i, NativeFormField nativeFormField) {
        super(i, nativeFormField);
    }

    @Override // com.pspdfkit.forms.FormField
    public List<? extends ComboBoxFormElement> getFormElements() {
        return super.getFormElements();
    }

    @Override // com.pspdfkit.forms.FormField
    public ComboBoxFormElement getFormElement() {
        return (ComboBoxFormElement) super.getFormElement();
    }
}
