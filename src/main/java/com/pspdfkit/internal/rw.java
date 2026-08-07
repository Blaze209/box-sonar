package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.TypedArray;
import androidx.core.content.ContextCompat;
import com.pspdfkit.R;

/* JADX INFO: loaded from: classes3.dex */
public final class rw {
    public static final int[] d = R.styleable.pspdf__PopupToolbar;
    public static final int e = R.attr.pspdf__popupToolbarStyle;
    public static final int f = R.style.PSPDFKit_PopupToolbar;
    public final int a;
    public final int b;
    public final int c;

    public rw(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, d, e, f);
        this.a = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__PopupToolbar_pspdf__backgroundColor, ContextCompat.getColor(context, R.color.pspdf__popup_toolbar_background_color));
        this.b = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__PopupToolbar_pspdf__itemTint, ContextCompat.getColor(context, R.color.pspdf__popup_toolbar_item_tint));
        this.c = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__PopupToolbar_pspdf__itemTintDisabled, ContextCompat.getColor(context, R.color.pspdf__dark_popup_toolbar_item_tint_disabled));
        typedArrayObtainStyledAttributes.recycle();
    }
}
