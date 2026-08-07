package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.TypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import com.pspdfkit.R;

/* JADX INFO: loaded from: classes3.dex */
public final class g20 {
    public static final int[] A = R.styleable.pspdf__SignatureLayout;
    public static final int B = R.attr.pspdf__signatureLayoutStyle;
    public static final int C = R.style.PSPDFKit_SignatureLayout;
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final boolean g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public final int o;
    public final int p;
    public final int q;
    public final int r;
    public final int s;
    public final int t;
    public final int u;
    public final int v;
    public final int w;
    public final int x;
    public final int y;
    public final int z;

    public g20(Context context) {
        context.getClass();
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, A, B, C);
        typedArrayObtainStyledAttributes.getClass();
        try {
            this.d = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__SignatureLayout_pspdf__clearSignatureCanvasIcon, R.drawable.pspdf__ic_delete);
            this.e = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SignatureLayout_pspdf__clearSignatureCanvasIconColor, -1);
            this.f = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SignatureLayout_pspdf__clearSignatureCanvasIconBackgroundColor, -7829368);
            this.a = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__SignatureLayout_pspdf__acceptSignatureIcon, R.drawable.pspdf__ic_done);
            this.b = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SignatureLayout_pspdf__acceptSignatureIconColor, ContextCompat.getColor(context, R.color.pspdf__color_white));
            this.c = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SignatureLayout_pspdf__acceptSignatureIconBackgroundColor, ContextCompat.getColor(context, R.color.pspdf__color_teal));
            this.g = typedArrayObtainStyledAttributes.getBoolean(R.styleable.pspdf__SignatureLayout_pspdf__fontSelectionVisible, false);
            this.h = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SignatureLayout_pspdf__circleButtonBorderColor, ContextCompat.getColor(context, R.color.pspdf__primaryLight));
            this.i = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SignatureLayout_pspdf__signatureInkColorPrimary, -16777216);
            this.j = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SignatureLayout_pspdf__signatureInkColorSecondary, SupportMenu.CATEGORY_MASK);
            this.k = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SignatureLayout_pspdf__signatureInkColorTertiary, -16776961);
            this.l = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SignatureLayout_pspdf__backgroundColor, ContextCompat.getColor(context, R.color.pspdf__color_white));
            this.m = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__SignatureLayout_pspdf__addSignatureIcon, R.drawable.pspdf__ic_add);
            this.n = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SignatureLayout_pspdf__addSignatureIconColor, ContextCompat.getColor(context, R.color.pspdf__onPrimaryLight));
            this.o = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SignatureLayout_pspdf__addSignatureIconBackgroundColor, ContextCompat.getColor(context, R.color.pspdf__primaryLight));
            this.p = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__SignatureLayout_pspdf__deleteSelectedSignaturesIcon, R.drawable.pspdf__ic_delete);
            this.q = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SignatureLayout_pspdf__deleteSelectedSignaturesIconColor, ContextCompat.getColor(context, R.color.pspdf__onPrimaryLight));
            this.r = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SignatureLayout_pspdf__deleteSelectedSignaturesIconBackgroundColor, ContextCompat.getColor(context, R.color.pspdf__errorContainerLight));
            this.s = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SignatureLayout_pspdf__selectedTabIndicatorColor, ContextCompat.getColor(context, R.color.pspdf__backgroundLight));
            this.t = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SignatureLayout_pspdf__typeSignatureFontColor, ContextCompat.getColor(context, R.color.pspdf__primaryLight));
            this.u = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SignatureLayout_pspdf__clearSignatureTextColor, ContextCompat.getColor(context, R.color.pspdf__primaryLight));
            this.v = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SignatureLayout_pspdf__selectImageTextColor, -16777216);
            this.w = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SignatureLayout_pspdf__replaceImageTextColor, -16777216);
            typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SignatureLayout_pspdf__textColor, -16777216);
            this.x = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SignatureLayout_pspdf__signHereTextColor, -16777216);
            this.y = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SignatureLayout_pspdf__signatureListSelectedItemBackground, ContextCompat.getColor(context, R.color.pspdf__primaryContainerLight));
            this.z = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SignatureLayout_pspdf__signatureListItemBackground, ContextCompat.getColor(context, R.color.pspdf__backgroundLight));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
