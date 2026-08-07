package com.pspdfkit.forms;

import com.pspdfkit.internal.jni.NativeFormField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class EditableButtonFormField extends ButtonFormField {
    public EditableButtonFormField(int i, NativeFormField nativeFormField) {
        super(i, nativeFormField);
    }

    @Override // com.pspdfkit.forms.FormField
    public List<? extends EditableButtonFormElement> getFormElements() {
        return super.getFormElements();
    }

    public List<? extends EditableButtonFormElement> getSelectedButtons() {
        ArrayList<Integer> selectedButtonWidgetIds = getInternal().getNativeFormControl().getSelectedButtonWidgetIds();
        ArrayList arrayList = new ArrayList(selectedButtonWidgetIds.size());
        for (EditableButtonFormElement editableButtonFormElement : getFormElements()) {
            if (selectedButtonWidgetIds.contains(Integer.valueOf(editableButtonFormElement.getObjectNumber()))) {
                arrayList.add(editableButtonFormElement);
            }
        }
        return arrayList;
    }

    public boolean setSelectedButtons(List<? extends EditableButtonFormElement> list) {
        ArrayList<Integer> arrayList = new ArrayList<>(list.size());
        Iterator<? extends EditableButtonFormElement> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(it.next().getObjectNumber()));
        }
        return getInternal().getNativeFormControl().setSelectedButtonWidgetIds(arrayList);
    }
}
