package com.pspdfkit.forms;

import com.pspdfkit.internal.jni.NativeFormField;
import com.pspdfkit.internal.jni.NativeFormOption;
import com.pspdfkit.internal.uw;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ChoiceFormField extends FormField {
    private List<FormOption> options;

    public ChoiceFormField(int i, NativeFormField nativeFormField) {
        super(i, nativeFormField);
    }

    public List<FormOption> getOptions() {
        List<FormOption> list;
        synchronized (this) {
            if (this.options == null) {
                ArrayList<NativeFormOption> options = getInternal().getNativeFormControl().getOptions();
                this.options = new ArrayList(options.size());
                int size = options.size();
                int i = 0;
                while (i < size) {
                    NativeFormOption nativeFormOption = options.get(i);
                    i++;
                    this.options.add(new FormOption(nativeFormOption));
                }
            }
            list = this.options;
        }
        return list;
    }

    public void setOptions(List<FormOption> list) {
        uw.a(list, "options", null);
        synchronized (this) {
            List<FormOption> list2 = this.options;
            if (list2 == null) {
                this.options = new ArrayList(list.size());
            } else {
                list2.clear();
            }
            this.options.addAll(list);
            ArrayList<NativeFormOption> arrayList = new ArrayList<>(list.size());
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(new NativeFormOption(list.get(i).getLabel(), list.get(i).getValue()));
            }
            getInternal().getNativeFormControl().setOptions(arrayList);
        }
    }
}
