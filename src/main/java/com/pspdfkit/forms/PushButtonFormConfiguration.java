package com.pspdfkit.forms;

import android.graphics.Bitmap;
import android.graphics.RectF;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.annotations.WidgetAnnotation;
import com.pspdfkit.annotations.actions.Action;
import com.pspdfkit.internal.uw;

/* JADX INFO: loaded from: classes3.dex */
public class PushButtonFormConfiguration extends FormElementConfiguration<PushButtonFormElement, PushButtonFormField> {
    private final Action action;
    final Bitmap bitmap;

    public static class Builder extends FormElementConfiguration.BaseBuilder<PushButtonFormConfiguration, Builder> {
        Action action;
        Bitmap bitmap;

        public Builder(int i, RectF rectF, Bitmap bitmap) {
            super(i, rectF);
            uw.a(bitmap, "bitmap", null);
            this.bitmap = bitmap;
        }

        @Override // com.pspdfkit.forms.FormElementConfiguration.BaseBuilder
        public Builder getThis() {
            return this;
        }

        public Builder setAction(Action action) {
            uw.a(action, Analytics.Data.ACTION, null);
            this.action = action;
            return this;
        }

        @Override // com.pspdfkit.forms.FormElementConfiguration.BaseBuilder
        public PushButtonFormConfiguration build() {
            return new PushButtonFormConfiguration(this);
        }
    }

    public PushButtonFormConfiguration(Builder builder) {
        super(builder);
        this.bitmap = builder.bitmap;
        this.action = builder.action;
    }

    public Action getAction() {
        return this.action;
    }

    public Bitmap getBitmap() {
        return Bitmap.createBitmap(this.bitmap);
    }

    @Override // com.pspdfkit.forms.FormElementConfiguration
    public String getButtonValue(int i) {
        return null;
    }

    @Override // com.pspdfkit.forms.FormElementConfiguration
    public FormType getType() {
        return FormType.PUSHBUTTON;
    }

    @Override // com.pspdfkit.forms.FormElementConfiguration
    public PushButtonFormElement createFormElement(PushButtonFormField pushButtonFormField, WidgetAnnotation widgetAnnotation) {
        PushButtonFormElement pushButtonFormElement = new PushButtonFormElement(pushButtonFormField, widgetAnnotation, this.bitmap);
        applyToFormElement(pushButtonFormElement);
        Action action = this.action;
        if (action != null) {
            pushButtonFormElement.setAction(action);
        }
        return pushButtonFormElement;
    }
}
