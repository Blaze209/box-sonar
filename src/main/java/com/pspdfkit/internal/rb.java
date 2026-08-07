package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import androidx.core.content.ContextCompat;
import com.pspdfkit.R;

/* JADX INFO: loaded from: classes3.dex */
public final class rb {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;

    public rb(Context context) {
        context.getClass();
        Resources.Theme theme = context.getTheme();
        TypedArray typedArrayObtainStyledAttributes = theme != null ? theme.obtainStyledAttributes(null, R.styleable.pspdf__ContextualToolbar, R.attr.pspdf__contextualToolbarStyle, R.style.PSPDFKit_ContextualToolbar) : null;
        if (typedArrayObtainStyledAttributes != null) {
            this.a = m.a(typedArrayObtainStyledAttributes, context, R.styleable.pspdf__ContextualToolbar_pspdf__backgroundColor, androidx.appcompat.R.attr.colorPrimaryDark, R.color.pspdf__onPrimaryContainerLight);
            this.b = m.a(typedArrayObtainStyledAttributes, context, R.styleable.pspdf__ContextualToolbar_pspdf__borderColor, androidx.appcompat.R.attr.colorPrimaryDark, R.color.pspdf__onPrimaryContainerLight);
            this.c = m.a(typedArrayObtainStyledAttributes, context, R.styleable.pspdf__ContextualToolbar_pspdf__submenuBackgroundColor, androidx.appcompat.R.attr.colorPrimary, R.color.pspdf__primaryLight);
            this.d = m.a(typedArrayObtainStyledAttributes, context, R.styleable.pspdf__ContextualToolbar_pspdf__submenuBorderColor, androidx.appcompat.R.attr.colorPrimary, R.color.pspdf__primaryLight);
            this.e = m.a(typedArrayObtainStyledAttributes, context, R.styleable.pspdf__ContextualToolbar_pspdf__iconsColor, R.color.pspdf__onPrimaryLight);
            this.f = m.a(typedArrayObtainStyledAttributes, context, R.styleable.pspdf__ContextualToolbar_pspdf__iconsColorActivated, R.color.pspdf__onPrimaryLight);
            typedArrayObtainStyledAttributes.recycle();
            return;
        }
        int color = ContextCompat.getColor(context, R.color.pspdf__primaryLight);
        this.a = color;
        this.b = color;
        int color2 = ContextCompat.getColor(context, R.color.pspdf__primaryLight);
        this.c = color2;
        this.d = color2;
        this.e = ContextCompat.getColor(context, R.color.pspdf__onPrimaryLight);
        this.f = ContextCompat.getColor(context, R.color.pspdf__onPrimaryLight);
    }
}
