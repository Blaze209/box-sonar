package com.pspdfkit.internal;

import android.widget.EditText;
import com.pspdfkit.document.sharing.SharingOptions;

/* JADX INFO: loaded from: classes3.dex */
public final class ne extends c30 {
    public final /* synthetic */ qe a;

    public ne(qe qeVar) {
        this.a = qeVar;
    }

    @Override // com.pspdfkit.internal.c30, android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.a.k.d = SharingOptions.parsePageRange(charSequence.toString(), this.a.d);
        qe qeVar = this.a;
        EditText editText = qeVar.j;
        boolean zIsEmpty = qeVar.k.d.isEmpty();
        qe qeVar2 = this.a;
        a80.a(editText, !zIsEmpty ? qeVar2.o : qeVar2.p);
        this.a.b();
    }
}
