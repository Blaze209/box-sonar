package com.pspdfkit.forms;

import com.pspdfkit.internal.jni.NativeFormField;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PushButtonFormField extends ButtonFormField {
    public PushButtonFormField(int i, NativeFormField nativeFormField) {
        super(i, nativeFormField);
    }

    @Override // com.pspdfkit.forms.FormField
    public List<? extends PushButtonFormElement> getFormElements() {
        return super.getFormElements();
    }

    @Override // com.pspdfkit.forms.FormField
    public PushButtonFormElement getFormElement() {
        return (PushButtonFormElement) super.getFormElement();
    }
}
