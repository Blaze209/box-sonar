package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import androidx.core.content.ContextCompat;
import com.pspdfkit.R;
import com.pspdfkit.preferences.PSPDFKitPreferences;

/* JADX INFO: loaded from: classes3.dex */
public final class e30 {
    public final int a;
    public final Paint b;
    public final Path c;
    public final Matrix d;
    public final Path e;
    public final int f;
    public final PSPDFKitPreferences g;

    public e30(Context context) {
        context.getClass();
        this.a = context.getResources().getDimensionPixelSize(R.dimen.pspdf__measurement_snapping_cross_size);
        Paint paint = new Paint();
        this.b = paint;
        this.c = new Path();
        this.d = new Matrix();
        this.e = new Path();
        this.f = context.getResources().getDimensionPixelSize(R.dimen.pspdf__measurement_snapping_threshold);
        Resources.Theme theme = context.getTheme();
        TypedArray typedArrayObtainStyledAttributes = theme != null ? theme.obtainStyledAttributes(null, R.styleable.pspdf__HelperLine, R.attr.pspdf__helperLineStyle, R.style.PSPDFKit_HelperLine) : null;
        int color = typedArrayObtainStyledAttributes != null ? typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__HelperLine_pspdf__helperLineColor, ContextCompat.getColor(context, R.color.pspdf__errorContainerLight)) : ContextCompat.getColor(context, R.color.pspdf__errorContainerLight);
        PSPDFKitPreferences pSPDFKitPreferences = PSPDFKitPreferences.get(context);
        pSPDFKitPreferences.getClass();
        this.g = pSPDFKitPreferences;
        paint.setColor(color);
        paint.setStrokeWidth(context.getResources().getDimensionPixelSize(R.dimen.pspdf__shape_drawing_helpers_width));
        paint.setStyle(Paint.Style.STROKE);
    }
}
