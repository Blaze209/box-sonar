package com.pspdfkit.forms;

import android.graphics.RectF;
import com.pspdfkit.annotations.WidgetAnnotation;
import com.pspdfkit.internal.jni.NativeFormChoiceFlags;
import com.pspdfkit.internal.uw;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ListBoxFormConfiguration extends FormElementConfiguration<ListBoxFormElement, ListBoxFormField> {
    private final boolean multiSelectionEnabled;
    private final List<FormOption> options;
    private final List<Integer> selectedIndexes;

    public static class Builder extends FormElementConfiguration.BaseBuilder<ListBoxFormConfiguration, Builder> {
        private boolean multiSelectionEnabled;
        List<FormOption> options;
        List<Integer> selectedIndexes;

        public Builder(int i, RectF rectF) {
            super(i, rectF);
        }

        @Override // com.pspdfkit.forms.FormElementConfiguration.BaseBuilder
        public Builder getThis() {
            return this;
        }

        public Builder setFormOptions(List<FormOption> list) {
            uw.a(list, "options", null);
            this.options = Collections.unmodifiableList(list);
            return this;
        }

        public Builder setMultiSelectionEnabled(boolean z) {
            this.multiSelectionEnabled = z;
            return this;
        }

        public Builder setSelectedIndexes(List<Integer> list) {
            uw.a(list, "selectedIndexes", null);
            this.selectedIndexes = Collections.unmodifiableList(list);
            if (list.size() > 1) {
                this.multiSelectionEnabled = true;
            }
            return this;
        }

        @Override // com.pspdfkit.forms.FormElementConfiguration.BaseBuilder
        public ListBoxFormConfiguration build() {
            return new ListBoxFormConfiguration(this);
        }
    }

    public ListBoxFormConfiguration(Builder builder) {
        super(builder);
        this.selectedIndexes = builder.selectedIndexes;
        this.options = builder.options;
        this.multiSelectionEnabled = builder.multiSelectionEnabled;
    }

    @Override // com.pspdfkit.forms.FormElementConfiguration
    public String getButtonValue(int i) {
        return null;
    }

    public List<FormOption> getOptions() {
        return this.options;
    }

    public List<Integer> getSelectedIndexes() {
        return this.selectedIndexes;
    }

    @Override // com.pspdfkit.forms.FormElementConfiguration
    public FormType getType() {
        return FormType.LISTBOX;
    }

    public boolean isMultiSelectionEnabled() {
        return this.multiSelectionEnabled;
    }

    @Override // com.pspdfkit.forms.FormElementConfiguration
    public ListBoxFormElement createFormElement(ListBoxFormField listBoxFormField, WidgetAnnotation widgetAnnotation) {
        ListBoxFormElement listBoxFormElement = new ListBoxFormElement(listBoxFormField, widgetAnnotation);
        applyToFormElement(listBoxFormElement);
        List<FormOption> list = this.options;
        if (list != null) {
            listBoxFormElement.setOptions(list);
        }
        List<Integer> list2 = this.selectedIndexes;
        if (list2 != null) {
            listBoxFormElement.setSelectedIndexes(list2);
        }
        if (isMultiSelectionEnabled()) {
            listBoxFormElement.getFormField().getInternal().setChoiceFlags(EnumSet.of(NativeFormChoiceFlags.MULTI_SELECT));
        }
        return listBoxFormElement;
    }
}
