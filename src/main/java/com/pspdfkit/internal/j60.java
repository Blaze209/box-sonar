package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import com.pspdfkit.R;
import com.pspdfkit.ui.thumbnail.ThumbnailBarTheme;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class j60 {
    public static ThumbnailBarTheme a(Context context) {
        context.getClass();
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.pspdf__thumbnail_width);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.pspdf__thumbnail_height);
        Resources.Theme theme = context.getTheme();
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(new int[]{R.attr.pspdf__thumbnailBarStyle});
        typedArrayObtainStyledAttributes.getClass();
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, R.style.PSPDFKit_ThumbnailBar);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = theme.obtainStyledAttributes(resourceId, R.styleable.pspdf__ThumbnailBar);
        typedArrayObtainStyledAttributes2.getClass();
        try {
            int color = typedArrayObtainStyledAttributes2.getColor(R.styleable.pspdf__ThumbnailBar_pspdf__backgroundColor, -1);
            int color2 = typedArrayObtainStyledAttributes2.getColor(R.styleable.pspdf__ThumbnailBar_pspdf__thumbnailBarBorderColor, -3355444);
            int color3 = typedArrayObtainStyledAttributes2.getColor(R.styleable.pspdf__ThumbnailBar_pspdf__thumbnailBorderColor, -16777216);
            int color4 = typedArrayObtainStyledAttributes2.getColor(R.styleable.pspdf__ThumbnailBar_pspdf__thumbnailSelectedBorderColor, -16750849);
            boolean z = typedArrayObtainStyledAttributes2.getBoolean(R.styleable.pspdf__ThumbnailBar_pspdf__usePageAspectRatio, true);
            int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.pspdf__thumbnail_bar_thumbnails_padding);
            int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.pspdf__thumbnail_bar_content_padding);
            int dimensionPixelSize5 = resources.getDimensionPixelSize(R.dimen.pspdf__thumbnail_bar_border_size);
            float f = resources.getDisplayMetrics().density;
            int iCoerceAtLeast = RangesKt.coerceAtLeast(MathKt.roundToInt(f), 1);
            return new ThumbnailBarTheme(color, color2, color3, color4, dimensionPixelSize, dimensionPixelSize2, z, dimensionPixelSize3, dimensionPixelSize4, dimensionPixelSize5, iCoerceAtLeast, iCoerceAtLeast, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, resources.getDimension(R.dimen.pspdf__floating_thumbnail_bar_corner_radius) / f, 0.0f, 12578816, null);
        } finally {
            typedArrayObtainStyledAttributes2.recycle();
        }
    }
}
