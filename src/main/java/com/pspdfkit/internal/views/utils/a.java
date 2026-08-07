package com.pspdfkit.internal.views.utils;

import android.database.DataSetObserver;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends DataSetObserver {
    public final /* synthetic */ OutlinePagerTabView a;

    public a(OutlinePagerTabView outlinePagerTabView) {
        this.a = outlinePagerTabView;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        this.a.a.getMenu().clear();
    }
}
