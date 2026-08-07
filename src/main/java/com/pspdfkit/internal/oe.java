package com.pspdfkit.internal;

import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;

/* JADX INFO: loaded from: classes3.dex */
public final class oe implements AdapterView.OnItemSelectedListener {
    public final /* synthetic */ qe a;

    public oe(qe qeVar) {
        this.a = qeVar;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.a.b();
        qe qeVar = this.a;
        boolean z = qeVar.i.getItem(qeVar.h.getSelectedItemPosition()).a == 2;
        EditText editText = this.a.j;
        if (!z) {
            editText.setEnabled(false);
            this.a.j.animate().alpha(0.0f);
        } else {
            editText.setVisibility(0);
            this.a.j.setEnabled(true);
            this.a.j.animate().alpha(1.0f);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView<?> adapterView) {
    }
}
