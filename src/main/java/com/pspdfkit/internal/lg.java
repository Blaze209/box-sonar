package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.TypedArray;
import androidx.core.content.ContextCompat;
import com.pspdfkit.R;

/* JADX INFO: loaded from: classes3.dex */
public final class lg {
    public static final int[] b = R.styleable.pspdf__EraserTool;
    public static final int c = R.attr.pspdf__eraserStyle;
    public static final int d = R.style.PSPDFKit_EraserTool;
    public final int a;

    public lg(Context context) {
        context.getClass();
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, b, c, d);
        typedArrayObtainStyledAttributes.getClass();
        this.a = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__EraserTool_pspdf__eraserOutlineColor, ContextCompat.getColor(context, R.color.pspdf__outlineLight));
        typedArrayObtainStyledAttributes.recycle();
    }
}
