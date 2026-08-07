package com.pspdfkit.forms;

import com.pspdfkit.annotations.WidgetAnnotation;
import com.pspdfkit.internal.jni.NativeFormControl;

/* JADX INFO: loaded from: classes3.dex */
public abstract class FormElement {
    private final FormField formField;
    private FormElement nextElement;
    private FormElement previousElement;
    private final WidgetAnnotation widgetAnnotation;

    public FormElement(FormField formField, WidgetAnnotation widgetAnnotation) {
        this.formField = formField;
        this.widgetAnnotation = widgetAnnotation;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FormElement)) {
            return false;
        }
        FormElement formElement = (FormElement) obj;
        return this.widgetAnnotation.equals(formElement.widgetAnnotation) && this.formField.equals(formElement.formField);
    }

    public WidgetAnnotation getAnnotation() {
        return this.widgetAnnotation;
    }

    public NativeFormControl getFormControl() {
        return this.formField.getInternal().getNativeFormControl();
    }

    public FormField getFormField() {
        return this.formField;
    }

    public String getFullyQualifiedName() {
        return this.formField.getFullyQualifiedNameForFormElement(this);
    }

    public String getName() {
        return this.formField.getNameForFormElement(this);
    }

    public FormElement getNextElement() {
        return this.nextElement;
    }

    public int getObjectNumber() {
        return this.widgetAnnotation.getObjectNumber();
    }

    public FormElement getPreviousElement() {
        return this.previousElement;
    }

    public abstract FormType getType();

    public int hashCode() {
        return this.formField.hashCode() + (this.widgetAnnotation.hashCode() * 31);
    }

    public boolean isReadOnly() {
        return this.formField.isReadOnly();
    }

    public boolean isRequired() {
        return this.formField.isRequired();
    }

    public void setNextElement(FormElement formElement) {
        this.nextElement = formElement;
    }

    public void setPreviousElement(FormElement formElement) {
        this.previousElement = formElement;
    }
}
