package com.pspdfkit.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes3.dex */
public class PdfFrameLayout extends FrameLayout {
    public PdfFrameLayout(Context context) {
        super(context);
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        super.fitSystemWindows(rect);
        return false;
    }

    public PdfFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PdfFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public PdfFrameLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
