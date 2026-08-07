package com.pspdfkit.internal;

import com.pspdfkit.undo.edit.Edit;

/* JADX INFO: loaded from: classes3.dex */
public final class mf extends lf<Edit> implements at {
    public mf(at atVar) {
        super(atVar);
    }

    @Override // com.pspdfkit.internal.at
    public final void a(Edit edit) {
        edit.getClass();
        if (this.b) {
            this.c.add(edit);
        }
    }
}
