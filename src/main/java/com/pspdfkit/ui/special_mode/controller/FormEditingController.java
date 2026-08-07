package com.pspdfkit.ui.special_mode.controller;

import com.pspdfkit.forms.FormElement;
import com.pspdfkit.ui.special_mode.controller.base.FragmentSpecialModeController;
import com.pspdfkit.ui.special_mode.manager.FormManager;

/* JADX INFO: loaded from: classes3.dex */
public interface FormEditingController extends FragmentSpecialModeController {
    void bindFormElementViewController(FormElementViewController formElementViewController);

    boolean canClearFormField();

    boolean clearFormField();

    boolean finishEditing();

    FormElement getCurrentlySelectedFormElement();

    FormManager getFormManager();

    boolean hasNextElement();

    boolean hasPreviousElement();

    boolean selectNextFormElement();

    boolean selectPreviousFormElement();

    void unbindFormElementViewController();
}
