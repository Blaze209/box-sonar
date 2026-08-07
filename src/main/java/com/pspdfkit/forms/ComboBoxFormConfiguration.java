package com.pspdfkit.forms;

import android.graphics.RectF;
import com.pspdfkit.annotations.WidgetAnnotation;
import com.pspdfkit.internal.jni.NativeFormChoiceFlags;
import com.pspdfkit.internal.n70;
import com.pspdfkit.internal.uw;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ComboBoxFormConfiguration extends FormElementConfiguration<ComboBoxFormElement, ComboBoxFormField> {
    private final EnumSet<NativeFormChoiceFlags> choiceFlags;
    private final String customText;
    private final List<FormOption> options;
    private final Integer selectedIndex;

    public static class Builder extends FormElementConfiguration.BaseBuilder<ComboBoxFormConfiguration, Builder> {
        final EnumSet<NativeFormChoiceFlags> choiceFlags;
        String customText;
        List<FormOption> options;
        Integer selectedIndex;

        public Builder(int i, RectF rectF) {
            super(i, rectF);
            this.choiceFlags = EnumSet.noneOf(NativeFormChoiceFlags.class);
        }

        @Override // com.pspdfkit.forms.FormElementConfiguration.BaseBuilder
        public Builder getThis() {
            return this;
        }

        public Builder setCustomText(String str) {
            this.customText = str;
            if (str != null) {
                setEditable(true);
            }
            return this;
        }

        public Builder setEditable(boolean z) {
            n70.a(this.choiceFlags, NativeFormChoiceFlags.EDIT, z);
            if (!z) {
                this.customText = null;
            }
            return this;
        }

        public Builder setFormOptions(List<FormOption> list) {
            uw.a(list, "options", null);
            this.options = Collections.unmodifiableList(list);
            return this;
        }

        public Builder setMultiSelectionEnabled(boolean z) {
            n70.a(this.choiceFlags, NativeFormChoiceFlags.MULTI_SELECT, z);
            return this;
        }

        public Builder setSelectedIndex(Integer num) {
            this.selectedIndex = num;
            return this;
        }

        public Builder setSpellCheckEnabled(boolean z) {
            n70.a(this.choiceFlags, NativeFormChoiceFlags.DO_NOT_SPELL_CHECK, !z);
            return this;
        }

        @Override // com.pspdfkit.forms.FormElementConfiguration.BaseBuilder
        public ComboBoxFormConfiguration build() {
            return new ComboBoxFormConfiguration(this);
        }
    }

    public ComboBoxFormConfiguration(Builder builder) {
        super(builder);
        this.selectedIndex = builder.selectedIndex;
        this.customText = builder.customText;
        this.options = builder.options;
        this.choiceFlags = EnumSet.copyOf((EnumSet) builder.choiceFlags);
    }

    @Override // com.pspdfkit.forms.FormElementConfiguration
    public String getButtonValue(int i) {
        return null;
    }

    public String getCustomText() {
        return this.customText;
    }

    public List<FormOption> getOptions() {
        return this.options;
    }

    public Integer getSelectedIndex() {
        return this.selectedIndex;
    }

    @Override // com.pspdfkit.forms.FormElementConfiguration
    public FormType getType() {
        return FormType.COMBOBOX;
    }

    public boolean isEditable() {
        return this.choiceFlags.contains(NativeFormChoiceFlags.EDIT);
    }

    public boolean isMultiSelectionEnabled() {
        return this.choiceFlags.contains(NativeFormChoiceFlags.MULTI_SELECT);
    }

    @Override // com.pspdfkit.forms.FormElementConfiguration
    public ComboBoxFormElement createFormElement(ComboBoxFormField comboBoxFormField, WidgetAnnotation widgetAnnotation) {
        ComboBoxFormElement comboBoxFormElement = new ComboBoxFormElement(comboBoxFormField, widgetAnnotation);
        applyToFormElement(comboBoxFormElement);
        List<FormOption> list = this.options;
        if (list != null) {
            comboBoxFormElement.setOptions(list);
        }
        if (this.customText != null) {
            this.choiceFlags.add(NativeFormChoiceFlags.EDIT);
            comboBoxFormElement.getFormField().getInternal().setChoiceFlags(this.choiceFlags);
            comboBoxFormElement.setCustomText(this.customText);
        } else {
            comboBoxFormElement.getFormField().getInternal().setChoiceFlags(this.choiceFlags);
        }
        Integer num = this.selectedIndex;
        if (num != null) {
            comboBoxFormElement.setSelectedIndexes(Collections.singletonList(num));
        }
        return comboBoxFormElement;
    }
}
