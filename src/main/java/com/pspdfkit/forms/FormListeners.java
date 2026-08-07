package com.pspdfkit.forms;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface FormListeners {

    public interface OnButtonFormFieldUpdatedListener {
        void onButtonSelected(EditableButtonFormField editableButtonFormField, EditableButtonFormElement editableButtonFormElement, boolean z);
    }

    public interface OnChoiceFormFieldUpdatedListener {
        void onCustomOptionSet(ChoiceFormField choiceFormField, ChoiceFormElement choiceFormElement, String str);

        void onOptionSelected(ChoiceFormField choiceFormField, ChoiceFormElement choiceFormElement, List<Integer> list);
    }

    public interface OnFormFieldUpdatedListener {
        void onFormFieldReset(FormField formField, FormElement formElement);

        void onFormFieldUpdated(FormField formField);
    }

    public interface OnFormTabOrderUpdatedListener {
        void onFormTabOrderUpdated();
    }

    public interface OnTextFormFieldUpdatedListener {
        void onMaxLengthChanged(TextFormField textFormField, TextFormElement textFormElement, int i);

        void onRichTextChanged(TextFormField textFormField, TextFormElement textFormElement, String str);

        void onTextChanged(TextFormField textFormField, TextFormElement textFormElement, String str);
    }
}
