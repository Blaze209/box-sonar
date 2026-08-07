package com.pspdfkit.ui.inspector.forms;

import android.content.ContentResolver;
import android.content.Context;
import android.text.InputFilter;
import android.text.TextUtils;
import com.pspdfkit.R;
import com.pspdfkit.forms.ChoiceFormElement;
import com.pspdfkit.forms.ComboBoxFormElement;
import com.pspdfkit.forms.FormElement;
import com.pspdfkit.forms.FormOption;
import com.pspdfkit.forms.FormType;
import com.pspdfkit.internal.k9;
import com.pspdfkit.internal.no;
import com.pspdfkit.internal.sh;
import com.pspdfkit.internal.th;
import com.pspdfkit.ui.inspector.AbstractPropertyInspectorController;
import com.pspdfkit.ui.inspector.PropertyInspector;
import com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayoutController;
import com.pspdfkit.ui.inspector.PropertyInspectorView;
import com.pspdfkit.ui.inspector.views.OptionPickerInspectorView;
import com.pspdfkit.ui.special_mode.controller.FormEditingController;
import com.pspdfkit.ui.special_mode.manager.FormManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class FormEditingInspectorController extends AbstractPropertyInspectorController implements FormManager.OnFormElementUpdatedListener, FormManager.OnFormElementEditingModeChangeListener {
    private FormEditingController controller;
    private boolean isFormEditingBarEnabled;
    private OptionPickerInspectorView optionPickerInspectorView;
    private FormElement selectedFormElement;

    public FormEditingInspectorController(Context context, PropertyInspectorCoordinatorLayoutController propertyInspectorCoordinatorLayoutController) {
        super(context, propertyInspectorCoordinatorLayoutController);
        getPropertyInspector().setId(R.id.pspdf__form_editing_inspector);
        getPropertyInspector().setCancelOnTouchOutside(false);
        getPropertyInspector().setTitleBarVisible(true);
    }

    private void applyControllerChanges() {
        FormEditingController formEditingController = this.controller;
        if (formEditingController == null || formEditingController.getCurrentlySelectedFormElement() == null) {
            cancel();
            return;
        }
        FormElement currentlySelectedFormElement = this.controller.getCurrentlySelectedFormElement();
        List<PropertyInspectorView> inspectorViews = getInspectorViews(this.controller, currentlySelectedFormElement);
        if (inspectorViews.isEmpty()) {
            cancel();
            return;
        }
        getPropertyInspector().setInspectorViews(inspectorViews, true);
        String alternateFieldName = currentlySelectedFormElement.getFormField().getAlternateFieldName();
        if (TextUtils.isEmpty(alternateFieldName)) {
            alternateFieldName = currentlySelectedFormElement.getName();
            if (TextUtils.isEmpty(alternateFieldName)) {
                alternateFieldName = no.a(getContext(), R.string.pspdf__edit, null);
            }
        }
        getPropertyInspector().setTitle(alternateFieldName);
        getCoordinatorController().setDrawUnderBottomInset(true);
        getCoordinatorController().setBottomInset(this.isFormEditingBarEnabled ? getContext().getResources().getDimensionPixelSize(R.dimen.pspdf__form_editing_bar_height) : 0);
        this.selectedFormElement = currentlySelectedFormElement;
        showInspector(!isRestoringState());
    }

    private List<PropertyInspectorView> getInspectorViews(final FormEditingController formEditingController, final FormElement formElement) {
        String customText;
        boolean z;
        ArrayList arrayList = new ArrayList();
        if (formElement.getType() != FormType.LISTBOX && formElement.getType() != FormType.COMBOBOX) {
            return arrayList;
        }
        final ChoiceFormElement choiceFormElement = (ChoiceFormElement) formElement;
        final boolean zIsMultiSelectEnabled = choiceFormElement.isMultiSelectEnabled();
        if (formElement.getType() == FormType.COMBOBOX) {
            ComboBoxFormElement comboBoxFormElement = (ComboBoxFormElement) formElement;
            boolean zIsEditable = comboBoxFormElement.isEditable();
            customText = comboBoxFormElement.getCustomText();
            z = zIsEditable;
        } else {
            customText = null;
            z = false;
        }
        String str = customText;
        ArrayList arrayList2 = new ArrayList(choiceFormElement.getOptions().size());
        Iterator<FormOption> it = choiceFormElement.getOptions().iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().getLabel());
        }
        final boolean z2 = z;
        OptionPickerInspectorView optionPickerInspectorView = new OptionPickerInspectorView(getContext(), arrayList2, choiceFormElement.getSelectedIndexes(), zIsMultiSelectEnabled, z, str, new OptionPickerInspectorView.OnOptionPickedListener() { // from class: com.pspdfkit.ui.inspector.forms.FormEditingInspectorController.1
            @Override // com.pspdfkit.ui.inspector.views.OptionPickerInspectorView.OnOptionPickedListener
            public void onCustomValueChanged(String str2) {
                if (formElement.getType() == FormType.COMBOBOX) {
                    sh.a((ComboBoxFormElement) formElement, str2).subscribe();
                }
            }

            @Override // com.pspdfkit.ui.inspector.views.OptionPickerInspectorView.OnOptionPickedListener
            public void onOptionsSelected(OptionPickerInspectorView optionPickerInspectorView2, List<Integer> list) {
                sh.a(choiceFormElement, list).subscribe();
                if (zIsMultiSelectEnabled || z2) {
                    return;
                }
                if (FormEditingInspectorController.this.isAutoSelectNextFormElementEnabled() && formEditingController.hasNextElement()) {
                    formEditingController.selectNextFormElement();
                } else {
                    formEditingController.finishEditing();
                }
            }
        });
        this.optionPickerInspectorView = optionPickerInspectorView;
        if (z) {
            ComboBoxFormElement comboBoxFormElement2 = (ComboBoxFormElement) formElement;
            ContentResolver contentResolver = getContext().getContentResolver();
            contentResolver.getClass();
            optionPickerInspectorView.setInputType(th.a(sh.a(comboBoxFormElement2), contentResolver) | (comboBoxFormElement2.isSpellCheckEnabled() ? 32768 : 524288));
            this.optionPickerInspectorView.setFilters(new InputFilter[]{new k9(comboBoxFormElement2)});
        }
        arrayList.add(this.optionPickerInspectorView);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAutoSelectNextFormElementEnabled() {
        FormEditingController formEditingController = this.controller;
        return formEditingController != null && formEditingController.getFragment().getConfiguration().isAutoSelectNextFormElementEnabled();
    }

    public void bindFormEditingController(FormEditingController formEditingController) {
        unbindFormEditingController();
        this.controller = formEditingController;
        formEditingController.getFormManager().addOnFormElementEditingModeChangeListener(this);
        formEditingController.getFormManager().addOnFormElementUpdatedListener(this);
        if (onRestoreState()) {
            return;
        }
        applyControllerChanges();
    }

    @Override // com.pspdfkit.ui.inspector.AbstractPropertyInspectorController
    public boolean isBoundToController() {
        return this.controller != null;
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementEditingModeChangeListener
    public void onChangeFormElementEditingMode(FormEditingController formEditingController) {
        applyControllerChanges();
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementEditingModeChangeListener
    public void onEnterFormElementEditingMode(FormEditingController formEditingController) {
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementEditingModeChangeListener
    public void onExitFormElementEditingMode(FormEditingController formEditingController) {
        cancel();
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementUpdatedListener
    public void onFormElementUpdated(FormElement formElement) {
        if (isInspectorVisible() && isBoundToController() && this.optionPickerInspectorView != null && this.selectedFormElement == formElement) {
            if (formElement.getType() == FormType.LISTBOX || formElement.getType() == FormType.COMBOBOX) {
                this.optionPickerInspectorView.setSelectedOptions(((ChoiceFormElement) formElement).getSelectedIndexes(), false);
                if (formElement.getType() == FormType.COMBOBOX) {
                    this.optionPickerInspectorView.setCustomValue(((ComboBoxFormElement) formElement).getCustomText());
                }
            }
        }
    }

    @Override // com.pspdfkit.ui.inspector.AbstractPropertyInspectorController, com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayoutController.PropertyInspectorLifecycleListener
    public void onPreparePropertyInspector(PropertyInspector propertyInspector) {
        super.onPreparePropertyInspector(propertyInspector);
        applyControllerChanges();
    }

    @Override // com.pspdfkit.ui.inspector.AbstractPropertyInspectorController, com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayoutController.PropertyInspectorLifecycleListener
    public void onRemovePropertyInspector(PropertyInspector propertyInspector) {
        super.onRemovePropertyInspector(propertyInspector);
        FormEditingController formEditingController = this.controller;
        if (formEditingController == null || formEditingController.getCurrentlySelectedFormElement() == null || this.controller.getCurrentlySelectedFormElement() != this.selectedFormElement) {
            return;
        }
        this.controller.finishEditing();
    }

    public void setFormEditingBarEnabled(boolean z) {
        this.isFormEditingBarEnabled = z;
    }

    public void unbindFormEditingController() {
        FormEditingController formEditingController = this.controller;
        if (formEditingController != null) {
            formEditingController.getFormManager().removeOnFormElementEditingModeChangeListener(this);
            this.controller.getFormManager().removeOnFormElementUpdatedListener(this);
            this.controller = null;
        }
        cancel();
    }
}
