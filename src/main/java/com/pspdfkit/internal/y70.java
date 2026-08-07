package com.pspdfkit.internal;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes3.dex */
public final class y70 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener b;

    public y70(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.a = view;
        this.b = onGlobalLayoutListener;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.b.onGlobalLayout();
    }
}
