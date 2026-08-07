package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import androidx.core.content.ContextCompat;
import com.pspdfkit.R;

/* JADX INFO: loaded from: classes3.dex */
public final class ci {
    public static final int[] j = R.styleable.pspdf__FormSelection;
    public static final int k = R.attr.pspdf__formSelectionStyle;
    public static final int l = R.style.PSPDFKit_FormSelection;
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;

    public ci(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, j, k, l);
        this.a = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__FormSelection_pspdf__highlightColor, ContextCompat.getColor(context, R.color.pspdf__formHighlightColorLight));
        this.b = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__FormSelection_pspdf__itemHighlightColor, ContextCompat.getColor(context, R.color.pspdf__selected_choice_form_item_highlight_color));
        this.d = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__FormSelection_pspdf__selectedTextElementBackgroundColor, ContextCompat.getColor(context, R.color.pspdf__tertiaryContainerLight));
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__FormSelection_pspdf__touchedFormElementHighlightColor, ContextCompat.getColor(context, R.color.pspdf__surfaceDimLight));
        this.c = Color.argb(96, Color.red(color), Color.green(color), Color.blue(color));
        this.e = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__FormSelection_pspdf__selectedTextElementBorderColor, ContextCompat.getColor(context, R.color.pspdf__selected_text_form_element_border_color));
        this.f = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__FormSelection_pspdf__requiredTextElementBorderColor, ContextCompat.getColor(context, R.color.pspdf__errorContainerLight));
        this.g = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__FormSelection_pspdf__signHereOverlayBackgroundColor, ContextCompat.getColor(context, R.color.pspdf__errorContainerLight));
        this.h = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__FormSelection_pspdf__suggestionListBackgroundColor, f60.a(context, android.R.attr.colorBackground));
        this.i = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__FormSelection_pspdf__suggestionListTextColor, f60.a(context, android.R.attr.colorForeground));
        typedArrayObtainStyledAttributes.recycle();
    }
}
