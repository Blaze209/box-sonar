package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import androidx.core.content.ContextCompat;
import com.pspdfkit.R;

/* JADX INFO: loaded from: classes3.dex */
public final class eo {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final float f;
    public final int g;
    public final int h;

    public eo(Context context) {
        Resources resources = context.getResources();
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R.styleable.pspdf__LinkAnnotationHighlighter, R.attr.pspdf__linkAnnotationHighlighterStyle, R.style.PSPDFKit_LinkAnnotationHighlighter);
        this.a = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__LinkAnnotationHighlighter_pspdf__highlightedBackgroundColor, ContextCompat.getColor(context, R.color.pspdf__tertiaryContainerLight));
        this.b = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__LinkAnnotationHighlighter_pspdf__highlightedBorderColor, ContextCompat.getColor(context, R.color.pspdf__scrimLight));
        this.c = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.pspdf__LinkAnnotationHighlighter_pspdf__highlightedBorderWidth, resources.getDimensionPixelSize(R.dimen.pspdf__highlighted_border_width));
        this.d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.pspdf__LinkAnnotationHighlighter_pspdf__highlightedLinkAnnotationPadding, resources.getDimensionPixelOffset(R.dimen.pspdf__highlighted_link_annotation_padding));
        this.e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.pspdf__LinkAnnotationHighlighter_pspdf__highlightedLinkAnnotationAnimationPadding, resources.getDimensionPixelOffset(R.dimen.pspdf__highlighted_link_annotation_animation_padding));
        this.f = typedArrayObtainStyledAttributes.getFloat(R.styleable.pspdf__LinkAnnotationHighlighter_pspdf__highlightedRectangleCornerRadiusToHeightRatio, 0.1f);
        this.g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.pspdf__LinkAnnotationHighlighter_pspdf__highlightedRectangleMinCornerRadius, resources.getDimensionPixelOffset(R.dimen.pspdf__highlighted_rectangle_min_corner_radius));
        this.h = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.pspdf__LinkAnnotationHighlighter_pspdf__highlightedRectangleMaxCornerRadius, resources.getDimensionPixelOffset(R.dimen.pspdf__highlighted_rectangle_max_corner_radius));
        typedArrayObtainStyledAttributes.recycle();
    }
}
