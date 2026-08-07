package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.TypedArray;
import com.pspdfkit.R;

/* JADX INFO: loaded from: classes3.dex */
public final class yo {
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    public yo(Context context) {
        context.getClass();
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R.styleable.pspdf__MainToolbar, R.attr.pspdf__mainToolbarStyle, R.style.PSPDFKit_MainToolbar);
        typedArrayObtainStyledAttributes.getClass();
        this.a = m.a(typedArrayObtainStyledAttributes, context, R.styleable.pspdf__MainToolbar_pspdf__backgroundColor, androidx.appcompat.R.attr.colorPrimary, R.color.pspdf__primaryLight);
        this.b = m.a(typedArrayObtainStyledAttributes, context, R.styleable.pspdf__MainToolbar_pspdf__textColor, R.color.pspdf__onPrimaryLight);
        this.c = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__MainToolbar_pspdf__toolbarPopupTheme, androidx.appcompat.R.style.ThemeOverlay_AppCompat_Light);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.getTheme().obtainStyledAttributes(null, R.styleable.pspdf__PdfActivityOverlay, R.attr.pspdf__PdfActivityOverlayStyle, 0);
        typedArrayObtainStyledAttributes2.getClass();
        this.d = m.a(typedArrayObtainStyledAttributes2, context, R.styleable.pspdf__PdfActivityOverlay_pspdf__activityTitleOverlayColor, R.color.pspdf__onPrimaryLight);
        typedArrayObtainStyledAttributes2.recycle();
    }
}
