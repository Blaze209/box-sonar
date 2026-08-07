package com.pspdfkit.forms;

import android.graphics.RectF;
import com.pspdfkit.annotations.WidgetAnnotation;

/* JADX INFO: loaded from: classes3.dex */
public class SignatureFormConfiguration extends FormElementConfiguration<SignatureFormElement, SignatureFormField> {

    public static class Builder extends FormElementConfiguration.BaseBuilder<SignatureFormConfiguration, Builder> {
        public Builder(int i, RectF rectF) {
            super(i, rectF);
        }

        @Override // com.pspdfkit.forms.FormElementConfiguration.BaseBuilder
        public Builder getThis() {
            return this;
        }

        @Override // com.pspdfkit.forms.FormElementConfiguration.BaseBuilder
        public SignatureFormConfiguration build() {
            return new SignatureFormConfiguration(this);
        }
    }

    public SignatureFormConfiguration(Builder builder) {
        super(builder);
    }

    @Override // com.pspdfkit.forms.FormElementConfiguration
    public String getButtonValue(int i) {
        return null;
    }

    @Override // com.pspdfkit.forms.FormElementConfiguration
    public FormType getType() {
        return FormType.SIGNATURE;
    }

    @Override // com.pspdfkit.forms.FormElementConfiguration
    public SignatureFormElement createFormElement(SignatureFormField signatureFormField, WidgetAnnotation widgetAnnotation) {
        SignatureFormElement signatureFormElement = new SignatureFormElement(signatureFormField, widgetAnnotation);
        applyToFormElement(signatureFormElement);
        return signatureFormElement;
    }
}
