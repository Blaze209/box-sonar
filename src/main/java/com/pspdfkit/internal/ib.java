package com.pspdfkit.internal;

import com.pspdfkit.undo.edit.Edit;
import com.pspdfkit.undo.edit.contentediting.ContentEditingEdit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ib<T extends ContentEditingEdit> extends q7<T> {
    public ib(Class<T> cls, q7.a<? super T> aVar) {
        super(cls, aVar, 4);
    }

    @Override // com.pspdfkit.internal.y60
    public final boolean a(Edit edit) {
        ((ContentEditingEdit) edit).getClass();
        return true;
    }

    @Override // com.pspdfkit.internal.y60
    public final boolean b(Edit edit) {
        ((ContentEditingEdit) edit).getClass();
        return true;
    }
}
