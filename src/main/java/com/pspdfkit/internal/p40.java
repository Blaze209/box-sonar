package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.TypedArray;
import androidx.core.content.ContextCompat;
import com.pspdfkit.R;

/* JADX INFO: loaded from: classes3.dex */
public final class p40 {
    public static final int[] d = R.styleable.pspdf__ThumbnailBar;
    public static final int e = R.attr.pspdf__thumbnailBarStyle;
    public static final int f = R.style.PSPDFKit_ThumbnailBar;
    public int a;
    public int b;
    public boolean c;

    public p40(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, d, e, f);
        typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__ThumbnailBar_pspdf__backgroundColor, ContextCompat.getColor(context, R.color.pspdf__primaryLight));
        typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__ThumbnailBar_pspdf__thumbnailBorderColor, ContextCompat.getColor(context, android.R.color.black));
        typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__ThumbnailBar_pspdf__thumbnailSelectedBorderColor, ContextCompat.getColor(context, R.color.pspdf__primaryLight));
        this.a = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.pspdf__ThumbnailBar_pspdf__thumbnailWidth, context.getResources().getDimensionPixelSize(R.dimen.pspdf__thumbnail_width));
        this.b = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.pspdf__ThumbnailBar_pspdf__thumbnailHeight, context.getResources().getDimensionPixelSize(R.dimen.pspdf__thumbnail_height));
        this.c = typedArrayObtainStyledAttributes.getBoolean(R.styleable.pspdf__ThumbnailBar_pspdf__usePageAspectRatio, true);
        typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__ThumbnailBar_pspdf__thumbnailBarBorderColor, ContextCompat.getColor(context, android.R.color.black));
        typedArrayObtainStyledAttributes.recycle();
    }
}
