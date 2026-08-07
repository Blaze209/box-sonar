package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import androidx.core.content.ContextCompat;
import com.pspdfkit.R;

/* JADX INFO: loaded from: classes3.dex */
public final class k00 {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public float g;
    public int h;
    public int i;

    public k00(Context context) {
        Resources resources = context.getResources();
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R.styleable.pspdf__SearchResultHighlighter, R.attr.pspdf__searchResultHighlighterStyle, R.style.PSPDFKit_SearchResultHighlighter);
        this.a = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SearchResultHighlighter_pspdf__searchResultBackgroundColor, ContextCompat.getColor(context, R.color.pspdf__tertiaryContainerLight));
        this.b = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SearchResultHighlighter_pspdf__searchResultBorderColor, ContextCompat.getColor(context, R.color.pspdf__border_color_highlight));
        this.c = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.pspdf__SearchResultHighlighter_pspdf__searchResultBorderWidth, resources.getDimensionPixelSize(R.dimen.pspdf__search_result_border_width));
        this.d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.pspdf__SearchResultHighlighter_pspdf__searchResultPadding, resources.getDimensionPixelOffset(R.dimen.pspdf__search_result_padding));
        this.e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.pspdf__SearchResultHighlighter_pspdf__searchResultAnnotationPadding, resources.getDimensionPixelOffset(R.dimen.pspdf__search_result_annotation_padding));
        this.f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.pspdf__SearchResultHighlighter_pspdf__searchResultAnimationPadding, resources.getDimensionPixelOffset(R.dimen.pspdf__search_result_animation_padding));
        this.g = typedArrayObtainStyledAttributes.getFloat(R.styleable.pspdf__SearchResultHighlighter_pspdf__searchResultCornerRadiusToHeightRatio, 0.1f);
        this.h = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.pspdf__SearchResultHighlighter_pspdf__searchResultCornerRadiusMin, resources.getDimensionPixelOffset(R.dimen.pspdf__search_result_min_corner_radius));
        this.i = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.pspdf__SearchResultHighlighter_pspdf__searchResultCornerRadiusMax, resources.getDimensionPixelOffset(R.dimen.pspdf__search_result_max_corner_radius));
        typedArrayObtainStyledAttributes.recycle();
    }
}
