package com.pspdfkit.internal;

import android.text.TextUtils;
import android.widget.EditText;

/* JADX INFO: loaded from: classes3.dex */
public final class me extends c30 {
    public final /* synthetic */ qe a;

    public me(qe qeVar) {
        this.a = qeVar;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x002e  */
    @Override // com.pspdfkit.internal.c30, android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        qe qeVar = this.a;
        EditText editText = qeVar.g;
        if (TextUtils.isEmpty(editText.getText())) {
            z = false;
        } else {
            String string = qeVar.g.getText().toString();
            if (TextUtils.isEmpty(string) || !string.replaceAll("[:\\\\/*\"?|<>']", "").equals(string)) {
                z = false;
            } else {
                z = true;
            }
        }
        qe qeVar2 = this.a;
        a80.a(editText, z ? qeVar2.o : qeVar2.p);
        this.a.b();
    }
}
