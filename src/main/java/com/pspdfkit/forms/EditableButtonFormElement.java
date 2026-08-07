package com.pspdfkit.forms;

import com.pspdfkit.annotations.WidgetAnnotation;

/* JADX INFO: loaded from: classes3.dex */
public abstract class EditableButtonFormElement extends ButtonFormElement {
    public EditableButtonFormElement(EditableButtonFormField editableButtonFormField, WidgetAnnotation widgetAnnotation) {
        super(editableButtonFormField, widgetAnnotation);
    }

    public boolean deselect() {
        return getFormControl().deselectButton(getObjectNumber());
    }

    public boolean isSelected() {
        return getFormControl().isButtonSelected(getObjectNumber());
    }

    public boolean select() {
        return getFormControl().selectButton(getObjectNumber());
    }

    public boolean toggleSelection() {
        return isSelected() ? deselect() : select();
    }
}
