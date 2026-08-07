package com.pspdfkit.forms;

import android.graphics.RectF;
import com.pspdfkit.annotations.WidgetAnnotation;

/* JADX INFO: loaded from: classes3.dex */
public class RadioButtonFormConfiguration extends FormElementConfiguration<RadioButtonFormElement, RadioButtonFormField> {
    private final boolean selected;

    public static class Builder extends FormElementConfiguration.BaseBuilder<RadioButtonFormConfiguration, Builder> {
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
        public RadioButtonFormConfiguration build() {
            return new RadioButtonFormConfiguration(this);
        }
    }

    public RadioButtonFormConfiguration(Builder builder) {
        super(builder);
        this.selected = builder.selected;
    }

    @Override // com.pspdfkit.forms.FormElementConfiguration
    public String getButtonValue(int i) {
        return "RadioButton-" + i;
    }

    @Override // com.pspdfkit.forms.FormElementConfiguration
    public FormType getType() {
        return FormType.RADIOBUTTON;
    }

    public boolean isSelected() {
        return this.selected;
    }

    @Override // com.pspdfkit.forms.FormElementConfiguration
    public RadioButtonFormElement createFormElement(RadioButtonFormField radioButtonFormField, WidgetAnnotation widgetAnnotation) {
        RadioButtonFormElement radioButtonFormElement = new RadioButtonFormElement(radioButtonFormField, widgetAnnotation);
        applyToFormElement(radioButtonFormElement);
        if (this.selected) {
            radioButtonFormElement.select();
            return radioButtonFormElement;
        }
        radioButtonFormElement.deselect();
        return radioButtonFormElement;
    }
}
