package com.pspdfkit.forms;

import android.graphics.RectF;
import com.pspdfkit.annotations.WidgetAnnotation;

/* JADX INFO: loaded from: classes3.dex */
public class CheckBoxFormConfiguration extends FormElementConfiguration<CheckBoxFormElement, CheckBoxFormField> {
    private final boolean selected;

    public static class Builder extends FormElementConfiguration.BaseBuilder<CheckBoxFormConfiguration, Builder> {
        boolean selected;

        public Builder(int i, RectF rectF) {
            super(i, rectF);
            this.selected = false;
        }

        public Builder deselect() {
            this.selected = false;
            return this;
        }

        @Override // com.pspdfkit.forms.FormElementConfiguration.BaseBuilder
        public Builder getThis() {
            return this;
        }

        public Builder select() {
            this.selected = true;
            return this;
        }

        @Override // com.pspdfkit.forms.FormElementConfiguration.BaseBuilder
        public CheckBoxFormConfiguration build() {
            return new CheckBoxFormConfiguration(this);
        }
    }

    public CheckBoxFormConfiguration(Builder builder) {
        super(builder);
        this.selected = builder.selected;
    }

    @Override // com.pspdfkit.forms.FormElementConfiguration
    public String getButtonValue(int i) {
        return "CheckBox-" + i;
    }

    @Override // com.pspdfkit.forms.FormElementConfiguration
    public FormType getType() {
        return FormType.CHECKBOX;
    }

    public boolean isSelected() {
        return this.selected;
    }

    @Override // com.pspdfkit.forms.FormElementConfiguration
    public CheckBoxFormElement createFormElement(CheckBoxFormField checkBoxFormField, WidgetAnnotation widgetAnnotation) {
        CheckBoxFormElement checkBoxFormElement = new CheckBoxFormElement(checkBoxFormField, widgetAnnotation);
        applyToFormElement(checkBoxFormElement);
        if (this.selected) {
            checkBoxFormElement.select();
            return checkBoxFormElement;
        }
        checkBoxFormElement.deselect();
        return checkBoxFormElement;
    }
}
