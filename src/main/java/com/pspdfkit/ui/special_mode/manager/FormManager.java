package com.pspdfkit.ui.special_mode.manager;

import com.pspdfkit.forms.FormElement;
import com.pspdfkit.forms.TextFormElement;
import com.pspdfkit.ui.special_mode.controller.FormEditingController;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface FormManager {

    public interface OnFormElementClickedListener {
        default boolean isFormElementClickable(FormElement formElement) {
            return true;
        }

        boolean onFormElementClicked(FormElement formElement);
    }

    public interface OnFormElementDeselectedListener {
        void onFormElementDeselected(FormElement formElement, boolean z);
    }

    public interface OnFormElementEditingModeChangeListener {
        void onChangeFormElementEditingMode(FormEditingController formEditingController);

        void onEnterFormElementEditingMode(FormEditingController formEditingController);

        void onExitFormElementEditingMode(FormEditingController formEditingController);
    }

    public interface OnFormElementSelectedListener {
        void onFormElementSelected(FormElement formElement);

        default boolean onPrepareFormElementSelection(FormElement formElement) {
            return true;
        }
    }

    public interface OnFormElementUpdatedListener {
        void onFormElementUpdated(FormElement formElement);
    }

    public interface OnFormElementViewUpdatedListener {
        void onFormElementValidationFailed(FormElement formElement, String str);

        void onFormElementValidationSuccess(FormElement formElement);

        void onFormElementViewUpdated(FormElement formElement);
    }

    public interface OnTextFormElementSuggestionRequestListener {
        List<String> onTextFormElementGetSuggestions(TextFormElement textFormElement);

        default boolean shouldShowSuggestionsImmediately(TextFormElement textFormElement) {
            return true;
        }
    }

    void addOnFormElementClickedListener(OnFormElementClickedListener onFormElementClickedListener);

    void addOnFormElementDeselectedListener(OnFormElementDeselectedListener onFormElementDeselectedListener);

    void addOnFormElementEditingModeChangeListener(OnFormElementEditingModeChangeListener onFormElementEditingModeChangeListener);

    void addOnFormElementSelectedListener(OnFormElementSelectedListener onFormElementSelectedListener);

    void addOnFormElementUpdatedListener(OnFormElementUpdatedListener onFormElementUpdatedListener);

    void addOnFormElementViewUpdatedListener(OnFormElementViewUpdatedListener onFormElementViewUpdatedListener);

    void addOnTextFormElementSuggestionRequestListener(OnTextFormElementSuggestionRequestListener onTextFormElementSuggestionRequestListener);

    void removeOnFormElementClickedListener(OnFormElementClickedListener onFormElementClickedListener);

    void removeOnFormElementDeselectedListener(OnFormElementDeselectedListener onFormElementDeselectedListener);

    void removeOnFormElementEditingModeChangeListener(OnFormElementEditingModeChangeListener onFormElementEditingModeChangeListener);

    void removeOnFormElementSelectedListener(OnFormElementSelectedListener onFormElementSelectedListener);

    void removeOnFormElementUpdatedListener(OnFormElementUpdatedListener onFormElementUpdatedListener);

    void removeOnFormElementViewUpdatedListener(OnFormElementViewUpdatedListener onFormElementViewUpdatedListener);

    void removeOnTextFormElementSuggestionRequestListener(OnTextFormElementSuggestionRequestListener onTextFormElementSuggestionRequestListener);
}
