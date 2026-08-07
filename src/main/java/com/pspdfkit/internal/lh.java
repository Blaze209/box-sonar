package com.pspdfkit.internal;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.WidgetAnnotation;
import com.pspdfkit.forms.CheckBoxFormElement;
import com.pspdfkit.forms.ComboBoxFormElement;
import com.pspdfkit.forms.FormElement;
import com.pspdfkit.forms.FormType;
import com.pspdfkit.forms.ListBoxFormElement;
import com.pspdfkit.forms.TextFormElement;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.special_mode.controller.FormEditingController;
import com.pspdfkit.ui.special_mode.controller.FormElementViewController;
import com.pspdfkit.ui.special_mode.manager.FormManager;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class lh extends l30 implements FormEditingController, ViewTreeObserver.OnGlobalFocusChangeListener {
    public final PdfFragment d;
    public final vh e;
    public FormElement f;
    public final EnumSet<FormType> g;
    public FormElementViewController h;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[FormType.values().length];
            a = iArr;
            try {
                iArr[FormType.CHECKBOX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[FormType.TEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[FormType.LISTBOX.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[FormType.COMBOBOX.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public lh(vh vhVar, PdfFragment pdfFragment, at atVar) {
        super(pdfFragment.getContext(), pdfFragment, atVar);
        this.g = EnumSet.of(FormType.CHECKBOX, FormType.RADIOBUTTON, FormType.TEXT, FormType.COMBOBOX, FormType.LISTBOX);
        this.d = pdfFragment;
        this.e = vhVar;
    }

    public final void a(FormElement formElement) {
        this.h = null;
        FormElement formElement2 = this.f;
        if (formElement == null) {
            if (formElement2 != null) {
                this.f = null;
                yh yhVar = (yh) this.e;
                yhVar.getClass();
                yh.a();
                Iterator<FormManager.OnFormElementEditingModeChangeListener> it = yhVar.d.iterator();
                while (it.hasNext()) {
                    it.next().onExitFormElementEditingMode(this);
                }
                this.d.getView().getViewTreeObserver().removeOnGlobalFocusChangeListener(this);
                return;
            }
            return;
        }
        if (formElement2 != null) {
            this.f = formElement;
            yh yhVar2 = (yh) this.e;
            yhVar2.getClass();
            yh.a();
            Iterator<FormManager.OnFormElementEditingModeChangeListener> it2 = yhVar2.d.iterator();
            while (it2.hasNext()) {
                it2.next().onChangeFormElementEditingMode(this);
            }
            return;
        }
        this.f = formElement;
        yh yhVar3 = (yh) this.e;
        yhVar3.getClass();
        yh.a();
        Iterator<FormManager.OnFormElementEditingModeChangeListener> it3 = yhVar3.d.iterator();
        while (it3.hasNext()) {
            it3.next().onEnterFormElementEditingMode(this);
        }
        this.d.getView().getViewTreeObserver().addOnGlobalFocusChangeListener(this);
    }

    @Override // com.pspdfkit.ui.special_mode.controller.FormEditingController
    public final void bindFormElementViewController(FormElementViewController formElementViewController) {
        this.h = formElementViewController;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.FormEditingController
    public final boolean canClearFormField() {
        FormElement formElement = this.f;
        if (formElement == null) {
            return false;
        }
        FormElementViewController formElementViewController = this.h;
        if (formElementViewController != null) {
            return formElementViewController.canClearFormField();
        }
        int i = a.a[formElement.getType().ordinal()];
        if (i == 1) {
            return ((CheckBoxFormElement) this.f).isSelected();
        }
        if (i == 2) {
            return !TextUtils.isEmpty(((TextFormElement) this.f).getText());
        }
        if (i == 3) {
            return !((ListBoxFormElement) this.f).getSelectedIndexes().isEmpty();
        }
        if (i != 4) {
            return false;
        }
        ComboBoxFormElement comboBoxFormElement = (ComboBoxFormElement) this.f;
        return comboBoxFormElement.isCustomTextSet() || !comboBoxFormElement.getSelectedIndexes().isEmpty();
    }

    @Override // com.pspdfkit.ui.special_mode.controller.FormEditingController
    public final boolean clearFormField() {
        FormElement formElement = this.f;
        if (formElement == null) {
            return false;
        }
        FormElementViewController formElementViewController = this.h;
        if (formElementViewController != null) {
            return formElementViewController.clearFormField();
        }
        int i = a.a[formElement.getType().ordinal()];
        if (i == 1) {
            return ((CheckBoxFormElement) this.f).deselect();
        }
        if (i == 2) {
            String text = ((TextFormElement) this.f).getText();
            ((TextFormElement) this.f).setText("");
            return !TextUtils.isEmpty(text);
        }
        if (i == 3) {
            ListBoxFormElement listBoxFormElement = (ListBoxFormElement) this.f;
            boolean z = !listBoxFormElement.getSelectedIndexes().isEmpty();
            listBoxFormElement.setSelectedIndexes(Collections.EMPTY_LIST);
            return z;
        }
        if (i != 4) {
            return false;
        }
        ComboBoxFormElement comboBoxFormElement = (ComboBoxFormElement) this.f;
        boolean z2 = comboBoxFormElement.isCustomTextSet() || !comboBoxFormElement.getSelectedIndexes().isEmpty();
        comboBoxFormElement.setSelectedIndexes(Collections.EMPTY_LIST);
        comboBoxFormElement.setCustomText(null);
        return z2;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.FormEditingController
    public final boolean finishEditing() {
        if (this.f == null) {
            return false;
        }
        this.d.exitCurrentlyActiveMode();
        return true;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.FormEditingController
    public final FormElement getCurrentlySelectedFormElement() {
        return this.f;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.FormEditingController
    public final FormManager getFormManager() {
        return this.e;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.base.FragmentSpecialModeController
    public final PdfFragment getFragment() {
        return this.d;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.FormEditingController
    public final boolean hasNextElement() {
        FormElement nextElement;
        if (this.f == null) {
            nextElement = null;
        } else {
            HashSet hashSet = new HashSet();
            nextElement = this.f.getNextElement();
            while (nextElement != null && this.f != null && nextElement.getAnnotation().getPageIndex() == this.f.getAnnotation().getPageIndex() && !hashSet.contains(nextElement)) {
                if (!this.g.contains(nextElement.getType()) || !ww.a(nextElement)) {
                    hashSet.add(nextElement);
                    nextElement = nextElement.getNextElement();
                }
            }
            nextElement = null;
        }
        return nextElement != null;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.FormEditingController
    public final boolean hasPreviousElement() {
        FormElement previousElement;
        if (this.f == null) {
            previousElement = null;
        } else {
            HashSet hashSet = new HashSet();
            previousElement = this.f.getPreviousElement();
            while (previousElement != null && this.f != null && previousElement.getAnnotation().getPageIndex() == this.f.getAnnotation().getPageIndex() && !hashSet.contains(previousElement)) {
                if (!this.g.contains(previousElement.getType()) || !ww.a(previousElement)) {
                    hashSet.add(previousElement);
                    previousElement = previousElement.getPreviousElement();
                }
            }
            previousElement = null;
        }
        return previousElement != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    public final void onGlobalFocusChanged(View view, View view2) {
        FormElement formElement;
        if (!(view2 instanceof z4)) {
            if (view2 instanceof au) {
                this.d.exitCurrentlyActiveMode();
            }
        } else {
            Annotation annotation = ((z4) view2).getAnnotation();
            if (!(annotation instanceof WidgetAnnotation) || (formElement = ((WidgetAnnotation) annotation).getFormElement()) == null) {
                return;
            }
            this.d.setSelectedFormElement(formElement);
        }
    }

    @Override // com.pspdfkit.ui.special_mode.controller.FormEditingController
    public final boolean selectNextFormElement() {
        FormElement nextElement;
        FormElement formElement = this.f;
        if (formElement == null) {
            return false;
        }
        if (formElement != null) {
            HashSet hashSet = new HashSet();
            nextElement = this.f.getNextElement();
            while (true) {
                if (nextElement != null && this.f != null && nextElement.getAnnotation().getPageIndex() == this.f.getAnnotation().getPageIndex() && !hashSet.contains(nextElement)) {
                    if (this.g.contains(nextElement.getType()) && ww.a(nextElement)) {
                        break;
                    }
                    hashSet.add(nextElement);
                    nextElement = nextElement.getNextElement();
                } else {
                    nextElement = null;
                    break;
                }
            }
        } else {
            nextElement = null;
            break;
        }
        if (nextElement == null) {
            return false;
        }
        this.d.setSelectedFormElement(nextElement);
        return true;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.FormEditingController
    public final boolean selectPreviousFormElement() {
        FormElement previousElement;
        FormElement formElement = this.f;
        if (formElement == null) {
            return false;
        }
        if (formElement != null) {
            HashSet hashSet = new HashSet();
            previousElement = this.f.getPreviousElement();
            while (true) {
                if (previousElement != null && this.f != null && previousElement.getAnnotation().getPageIndex() == this.f.getAnnotation().getPageIndex() && !hashSet.contains(previousElement)) {
                    if (this.g.contains(previousElement.getType()) && ww.a(previousElement)) {
                        break;
                    }
                    hashSet.add(previousElement);
                    previousElement = previousElement.getPreviousElement();
                } else {
                    previousElement = null;
                    break;
                }
            }
        } else {
            previousElement = null;
            break;
        }
        if (previousElement == null) {
            return false;
        }
        this.d.setSelectedFormElement(previousElement);
        return true;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.FormEditingController
    public final void unbindFormElementViewController() {
        this.h = null;
    }
}
