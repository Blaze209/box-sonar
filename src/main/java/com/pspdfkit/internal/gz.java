package com.pspdfkit.internal;

import com.pspdfkit.annotations.actions.ResetFormAction;
import com.pspdfkit.forms.FormField;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class gz<T> implements Consumer {
    public final /* synthetic */ lm a;
    public final /* synthetic */ ResetFormAction b;

    public gz(lm lmVar, ResetFormAction resetFormAction) {
        this.a = lmVar;
        this.b = resetFormAction;
    }

    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Object obj) {
        List<? extends FormField> list = (List) obj;
        list.getClass();
        this.a.g.resetFormFields(list, this.b.getExcludeFormFields());
    }
}
