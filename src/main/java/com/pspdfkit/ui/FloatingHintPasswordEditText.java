package com.pspdfkit.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.pspdfkit.R;

/* JADX INFO: loaded from: classes3.dex */
public class FloatingHintPasswordEditText extends FloatingHintEditText {
    public FloatingHintPasswordEditText(Context context) {
        super(context, context.getResources().getString(R.string.pspdf__password));
    }

    public FloatingHintPasswordEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, context.getResources().getString(R.string.pspdf__password));
    }

    public FloatingHintPasswordEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, context.getResources().getString(R.string.pspdf__password));
    }
}
