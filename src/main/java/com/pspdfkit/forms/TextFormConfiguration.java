package com.pspdfkit.forms;

import android.graphics.RectF;
import com.pspdfkit.annotations.WidgetAnnotation;
import com.pspdfkit.internal.em;
import com.pspdfkit.internal.jni.NativeFormTextFlags;
import com.pspdfkit.internal.n70;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes3.dex */
public class TextFormConfiguration extends FormElementConfiguration<TextFormElement, TextFormField> {
    private final int maxLength;
    private final String richText;
    private final String text;
    private final EnumSet<NativeFormTextFlags> textFlags;

    public static class Builder extends FormElementConfiguration.BaseBuilder<TextFormConfiguration, Builder> {
        int maxLength;
        String richText;
        String text;
        final EnumSet<NativeFormTextFlags> textFlags;

        public Builder(int i, RectF rectF) {
            super(i, rectF);
            this.textFlags = EnumSet.noneOf(NativeFormTextFlags.class);
        }

        @Override // com.pspdfkit.forms.FormElementConfiguration.BaseBuilder
        public Builder getThis() {
            return this;
        }

        public Builder setMaxLength(int i) {
            if (i < 0) {
                i = 0;
            }
            this.maxLength = i;
            return this;
        }

        public Builder setMultiLine(boolean z) {
            n70.a(this.textFlags, NativeFormTextFlags.MULTI_LINE, z);
            return this;
        }

        public Builder setPassword(boolean z) {
            n70.a(this.textFlags, NativeFormTextFlags.PASSWORD, z);
            return this;
        }

        public Builder setRichText(String str) {
            this.richText = str;
            n70.a(this.textFlags, NativeFormTextFlags.RICH_TEXT, str != null);
            return this;
        }

        public Builder setScrollEnabled(boolean z) {
            n70.a(this.textFlags, NativeFormTextFlags.DO_NOT_SCROLL, !z);
            return this;
        }

        public Builder setSpellCheckEnabled(boolean z) {
            n70.a(this.textFlags, NativeFormTextFlags.DO_NOT_SPELL_CHECK, !z);
            return this;
        }

        public Builder setText(String str) {
            this.text = str;
            return this;
        }

        @Override // com.pspdfkit.forms.FormElementConfiguration.BaseBuilder
        public TextFormConfiguration build() {
            return new TextFormConfiguration(this);
        }
    }

    private TextFormConfiguration(Builder builder) {
        super(builder);
        this.text = builder.text;
        this.richText = builder.richText;
        this.textFlags = EnumSet.copyOf((EnumSet) builder.textFlags);
        this.maxLength = builder.maxLength;
    }

    @Override // com.pspdfkit.forms.FormElementConfiguration
    public String getButtonValue(int i) {
        return null;
    }

    public int getMaxLength() {
        return this.maxLength;
    }

    public String getRichText() {
        return this.richText;
    }

    public String getText() {
        return this.text;
    }

    @Override // com.pspdfkit.forms.FormElementConfiguration
    public FormType getType() {
        return FormType.TEXT;
    }

    public boolean isMultiLine() {
        return this.textFlags.contains(NativeFormTextFlags.MULTI_LINE);
    }

    public boolean isPassword() {
        return this.textFlags.contains(NativeFormTextFlags.PASSWORD);
    }

    public boolean isSpellCheckEnabled() {
        return !this.textFlags.contains(NativeFormTextFlags.DO_NOT_SPELL_CHECK);
    }

    @Override // com.pspdfkit.forms.FormElementConfiguration
    public TextFormElement createFormElement(TextFormField textFormField, WidgetAnnotation widgetAnnotation) {
        TextFormElement textFormElement = new TextFormElement(textFormField, widgetAnnotation);
        applyToFormElement(textFormElement);
        String str = this.text;
        if (str != null) {
            textFormElement.setText(str);
        }
        String str2 = this.richText;
        if (str2 != null) {
            textFormElement.setRichText(str2);
        }
        em internal = textFormElement.getFormField().getInternal();
        internal.setTextFlags(this.textFlags);
        internal.getNativeFormControl().setMaxLength(this.maxLength);
        return textFormElement;
    }
}
