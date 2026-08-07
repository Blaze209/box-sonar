package com.pspdfkit.internal;

import android.view.KeyEvent;
import com.pspdfkit.forms.CheckBoxFormElement;
import com.pspdfkit.forms.FormElement;
import com.pspdfkit.forms.FormType;
import com.pspdfkit.forms.RadioButtonFormElement;
import com.pspdfkit.forms.TextFormElement;
import com.pspdfkit.ui.special_mode.controller.FormEditingController;
import com.pspdfkit.ui.special_mode.manager.FormManager;

/* JADX INFO: loaded from: classes3.dex */
public final class xh implements FormManager.OnFormElementEditingModeChangeListener {
    public FormElement a;
    public FormEditingController b;

    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[FormType.values().length];
            try {
                iArr[FormType.RADIOBUTTON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FormType.CHECKBOX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    public final boolean a(int i, KeyEvent keyEvent) {
        keyEvent.getClass();
        FormEditingController formEditingController = this.b;
        FormElement formElement = this.a;
        if (formEditingController == null || formElement == null) {
            return false;
        }
        boolean z = i == 61 || i == 4;
        if (formElement.getType() == FormType.TEXT) {
            return z || (i == 66 && !((TextFormElement) formElement).isMultiLine());
        }
        return z || i == 66 || i == 62;
    }

    public final boolean b(int i, KeyEvent keyEvent) {
        FormElement formElement;
        FormEditingController formEditingController;
        keyEvent.getClass();
        FormEditingController formEditingController2 = this.b;
        if (formEditingController2 == null || (formElement = this.a) == null) {
            return false;
        }
        if (i == 61 && keyEvent.isShiftPressed()) {
            return formEditingController2.selectPreviousFormElement();
        }
        if (i == 61) {
            return formEditingController2.selectNextFormElement();
        }
        if (i == 4) {
            return formEditingController2.finishEditing();
        }
        if (formElement.getType() == FormType.TEXT) {
            if (i != 66 || ((TextFormElement) formElement).isMultiLine() || (formEditingController = this.b) == null) {
                return false;
            }
            return (formEditingController.getFragment().getConfiguration().isAutoSelectNextFormElementEnabled() && formEditingController.hasNextElement()) ? formEditingController.selectNextFormElement() : formEditingController.finishEditing();
        }
        if (i == 66) {
            FormEditingController formEditingController3 = this.b;
            if (formEditingController3 == null) {
                return false;
            }
            return (formEditingController3.getFragment().getConfiguration().isAutoSelectNextFormElementEnabled() && formEditingController3.hasNextElement()) ? formEditingController3.selectNextFormElement() : formEditingController3.finishEditing();
        }
        if (i == 62) {
            int i2 = a.a[formElement.getType().ordinal()];
            if (i2 == 1) {
                ((RadioButtonFormElement) formElement).toggleSelection();
                return true;
            }
            if (i2 == 2) {
                ((CheckBoxFormElement) formElement).toggleSelection();
                return true;
            }
        }
        return false;
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementEditingModeChangeListener
    public final void onChangeFormElementEditingMode(FormEditingController formEditingController) {
        formEditingController.getClass();
        this.b = formEditingController;
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementEditingModeChangeListener
    public final void onEnterFormElementEditingMode(FormEditingController formEditingController) {
        formEditingController.getClass();
        this.b = formEditingController;
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementEditingModeChangeListener
    public final void onExitFormElementEditingMode(FormEditingController formEditingController) {
        formEditingController.getClass();
        this.b = null;
    }
}
