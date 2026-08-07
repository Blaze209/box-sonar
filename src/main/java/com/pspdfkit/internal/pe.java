package com.pspdfkit.internal;

import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

/* JADX INFO: loaded from: classes3.dex */
public final class pe implements AdapterView.OnItemSelectedListener {
    public final /* synthetic */ TextView a;
    public final /* synthetic */ qe b;

    public pe(qe qeVar, TextView textView) {
        this.b = qeVar;
        this.a = textView;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        if (i < this.b.m.getCount() && this.b.m.getItem(i).c > 0) {
            this.a.setText(no.a(this.b.getContext(), this.b.m.getItem(i).c, this.a));
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView<?> adapterView) {
    }
}
