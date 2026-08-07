package com.pspdfkit.internal;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class f20 extends wc {
    public f20(Context context, yq yqVar) {
        super(context, yqVar);
    }

    @Override // com.pspdfkit.internal.wc
    public final void setTitleTextColor(int i) {
        super.setTitleTextColor(i);
        setCloseButtonColor(i);
        setBackButtonColor(i);
    }
}
