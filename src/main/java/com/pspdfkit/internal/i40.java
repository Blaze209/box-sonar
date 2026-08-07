package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.pspdfkit.R;

/* JADX INFO: loaded from: classes3.dex */
public final class i40 {
    public static final int[] i = R.styleable.pspdf__StampPicker;
    public static final int j = R.attr.pspdf__stampPickerStyle;
    public static final int k = R.style.PSPDFKit_StampPicker;
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final Drawable h;

    public i40(Context context) {
        Drawable drawableWrap;
        context.getClass();
        this.a = ContextCompat.getColor(context, com.google.android.material.R.color.design_default_color_primary);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, i, j, k);
        typedArrayObtainStyledAttributes.getClass();
        this.f = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__StampPicker_pspdf__stamp_grid_backgroundColor, -1);
        this.g = f60.a(context, android.R.attr.colorBackground, R.color.pspdf__onPrimaryLight);
        this.b = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__StampPicker_pspdf__textColor, ContextCompat.getColor(context, R.color.pspdf__outlineLight));
        this.c = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__StampPicker_pspdf__hintColor, ContextCompat.getColor(context, R.color.pspdf__outlineVariantLight));
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__StampPicker_pspdf__acceptCustomStampIconColor, -1);
        this.d = color;
        this.e = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__StampPicker_pspdf__acceptCustomStampIconBackgroundColor, f60.a(context, androidx.appcompat.R.attr.colorAccent));
        Drawable drawableB = a80.b(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__StampPicker_pspdf__acceptCustomStampIcon, R.drawable.pspdf__ic_done));
        if (drawableB == null) {
            drawableWrap = a80.a(context, R.drawable.pspdf__ic_done, color);
        } else {
            drawableWrap = DrawableCompat.wrap(drawableB);
            drawableWrap.getClass();
            DrawableCompat.setTint(drawableWrap, color);
        }
        this.h = drawableWrap;
        typedArrayObtainStyledAttributes.recycle();
    }
}
