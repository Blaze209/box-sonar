package com.pspdfkit.internal;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes3.dex */
public final class z70 implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ ViewTreeObserver.OnPreDrawListener b;

    public z70(View view, ViewTreeObserver.OnPreDrawListener onPreDrawListener) {
        this.a = view;
        this.b = onPreDrawListener;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        return this.b.onPreDraw();
    }
}
