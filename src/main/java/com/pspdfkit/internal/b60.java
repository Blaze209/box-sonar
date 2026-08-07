package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.TypedArray;
import androidx.core.content.ContextCompat;
import com.pspdfkit.R;

/* JADX INFO: loaded from: classes3.dex */
public final class b60 {
    public final int a;
    public final int b;
    public final int c;

    public b60(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R.styleable.pspdf__TextSelection, R.attr.pspdf__textSelectionStyle, R.style.PSPDFKit_TextSelection);
        this.a = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__TextSelection_pspdf__highlightColor, ContextCompat.getColor(context, R.color.pspdf__outlineVariantLight));
        this.b = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__TextSelection_pspdf__leftHandleColor, ContextCompat.getColor(context, R.color.pspdf__outlineVariantLight));
        this.c = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__TextSelection_pspdf__rightHandleColor, ContextCompat.getColor(context, R.color.pspdf__outlineVariantLight));
        typedArrayObtainStyledAttributes.recycle();
    }
}
