package com.pspdfkit.internal;

import android.graphics.drawable.ColorDrawable;

/* JADX INFO: loaded from: classes3.dex */
public final class p8 extends ColorDrawable {
    public p8(int i, int i2, int i3) {
        super(i);
        setBounds(0, 0, i2, i3);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return getBounds().height();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return getBounds().width();
    }
}
