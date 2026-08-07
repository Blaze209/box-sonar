package com.pspdfkit.internal;

import com.pspdfkit.forms.FormField;
import com.pspdfkit.forms.FormListeners;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class ai<T> implements Consumer {
    public final /* synthetic */ zh a;

    public ai(zh zhVar) {
        this.a = zhVar;
    }

    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Object obj) {
        FormField formField = (FormField) obj;
        formField.getClass();
        Iterator<FormListeners.OnFormFieldUpdatedListener> it = this.a.f.iterator();
        while (it.hasNext()) {
            it.next().onFormFieldUpdated(formField);
        }
    }
}
