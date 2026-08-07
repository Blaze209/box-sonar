package com.pspdfkit.forms;

import com.pspdfkit.annotations.WidgetAnnotation;
import com.pspdfkit.internal.jni.NativeFormChoiceFlags;
import com.pspdfkit.internal.uw;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ChoiceFormElement extends FormElement {
    public ChoiceFormElement(ChoiceFormField choiceFormField, WidgetAnnotation widgetAnnotation) {
        super(choiceFormField, widgetAnnotation);
    }

    public EnumSet<NativeFormChoiceFlags> getChoiceFlags() {
        return getFormField().getInternal().getChoiceFlags();
    }

    public List<FormOption> getOptions() {
        return getFormField().getOptions();
    }

    public List<Integer> getSelectedIndexes() {
        return getFormControl().getSelectedIndexes();
    }

    public boolean isCommitOnSelectionChangeEnabled() {
        return getChoiceFlags().contains(NativeFormChoiceFlags.COMMIT_ON_SEL_CHANGE);
    }

    public boolean isMultiSelectEnabled() {
        return getChoiceFlags().contains(NativeFormChoiceFlags.MULTI_SELECT);
    }

    public void setOptions(List<FormOption> list) {
        uw.a(list, "options", null);
        getFormField().setOptions(list);
    }

    public void setSelectedIndexes(List<Integer> list) {
        uw.a(list, "selectedIndexes", null);
        if (list.equals(getSelectedIndexes())) {
            return;
        }
        if (list instanceof ArrayList) {
            getFormControl().setSelectedIndexes((ArrayList) list);
        } else {
            getFormControl().setSelectedIndexes(new ArrayList<>(list));
        }
    }

    @Override // com.pspdfkit.forms.FormElement
    public ChoiceFormField getFormField() {
        return (ChoiceFormField) super.getFormField();
    }
}
