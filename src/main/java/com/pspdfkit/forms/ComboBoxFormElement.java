package com.pspdfkit.forms;

import com.pspdfkit.annotations.WidgetAnnotation;
import com.pspdfkit.internal.jni.NativeFormChoiceFlags;
import com.pspdfkit.internal.n70;

/* JADX INFO: loaded from: classes3.dex */
public class ComboBoxFormElement extends ChoiceFormElement {
    public ComboBoxFormElement(ComboBoxFormField comboBoxFormField, WidgetAnnotation widgetAnnotation) {
        super(comboBoxFormField, widgetAnnotation);
    }

    public String getCustomText() {
        return getFormControl().getCustomValue();
    }

    @Override // com.pspdfkit.forms.FormElement
    public FormType getType() {
        return FormType.COMBOBOX;
    }

    public boolean isCustomTextSet() {
        return getFormControl().isCustomValueSet();
    }

    public boolean isEditable() {
        return getChoiceFlags().contains(NativeFormChoiceFlags.EDIT);
    }

    public boolean isSpellCheckEnabled() {
        return !getChoiceFlags().contains(NativeFormChoiceFlags.DO_NOT_SPELL_CHECK);
    }

    public boolean setCustomText(String str) {
        if (!isEditable() || n70.a(str, getFormControl().getCustomValue())) {
            return false;
        }
        getFormControl().setCustomValue(str);
        return true;
    }

    @Override // com.pspdfkit.forms.ChoiceFormElement, com.pspdfkit.forms.FormElement
    public ComboBoxFormField getFormField() {
        return (ComboBoxFormField) super.getFormField();
    }
}
