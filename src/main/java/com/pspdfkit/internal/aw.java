package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.TypedArray;
import androidx.core.content.ContextCompat;
import com.pspdfkit.R;

/* JADX INFO: loaded from: classes3.dex */
public final class aw {
    public static final int[] k = R.styleable.pspdf__TabBar;
    public static final int l = R.attr.pspdf__tabBarStyle;
    public static final int m = R.style.PSPDFKit_TabBar;
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;

    public aw(Context context) {
        context.getClass();
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, k, l, m);
        typedArrayObtainStyledAttributes.getClass();
        this.a = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__TabBar_pspdf__backgroundColor, ContextCompat.getColor(context, R.color.pspdf__primaryLight));
        this.b = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__TabBar_pspdf__tabColor, 0);
        this.c = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__TabBar_pspdf__tabIndicatorColor, ContextCompat.getColor(context, R.color.pspdf__color_white_quarter_translucent));
        this.d = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__TabBar_pspdf__tabTextColor, ContextCompat.getColor(context, R.color.pspdf__surfaceContainerHighestLight));
        this.e = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__TabBar_pspdf__tabTextColorSelected, ContextCompat.getColor(context, R.color.pspdf__onPrimaryLight));
        typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__TabBar_pspdf__tabIconColor, ContextCompat.getColor(context, R.color.pspdf__surfaceContainerHighestLight));
        this.f = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__TabBar_pspdf__tabIconColorSelected, ContextCompat.getColor(context, R.color.pspdf__onPrimaryLight));
        this.g = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.pspdf__TabBar_pspdf__tabBarHeight, context.getResources().getDimensionPixelSize(R.dimen.pspdf__tab_bar_height));
        this.i = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.pspdf__TabBar_pspdf__tabBarMinimumWidth, context.getResources().getDimensionPixelSize(R.dimen.pspdf__tab_bar_minimum_width));
        this.j = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.pspdf__TabBar_pspdf__tabBarTextSize, context.getResources().getDimensionPixelSize(R.dimen.pspdf__tab_bar_text_size));
        this.h = context.getResources().getDimensionPixelSize(R.dimen.pspdf__tab_bar_item_margin_width);
        typedArrayObtainStyledAttributes.recycle();
    }
}
