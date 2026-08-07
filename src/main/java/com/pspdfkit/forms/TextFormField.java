package com.pspdfkit.forms;

import com.pspdfkit.internal.jni.NativeFormField;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class TextFormField extends FormField {
    public TextFormField(int i, NativeFormField nativeFormField) {
        super(i, nativeFormField);
    }

    @Override // com.pspdfkit.forms.FormField
    public List<? extends TextFormElement> getFormElements() {
        return super.getFormElements();
    }

    @Override // com.pspdfkit.forms.FormField
    public TextFormElement getFormElement() {
        return (TextFormElement) super.getFormElement();
    }
}
