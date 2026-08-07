package com.pspdfkit.ui.editor;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.pspdfkit.internal.hn;
import com.pspdfkit.ui.LocalizedEditText;

/* JADX INFO: loaded from: classes3.dex */
public class ScreenAdjustingEditText extends LocalizedEditText {
    private int originalSoftInputMode;

    public ScreenAdjustingEditText(Context context) {
        super(context);
        this.originalSoftInputMode = 48;
    }

    @Override // android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (z) {
            this.originalSoftInputMode = hn.a(getContext(), 16);
        } else {
            hn.a(getContext(), this.originalSoftInputMode);
            hn.c(this);
        }
    }

    public ScreenAdjustingEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.originalSoftInputMode = 48;
    }

    public ScreenAdjustingEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.originalSoftInputMode = 48;
    }
}
