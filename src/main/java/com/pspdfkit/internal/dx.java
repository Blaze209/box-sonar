package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.TypedArray;
import androidx.core.content.ContextCompat;
import com.pspdfkit.R;

/* JADX INFO: loaded from: classes3.dex */
public final class dx {
    public final int a;
    public final int b;
    public final int c;
    public final float d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;

    public dx(Context context) {
        TypedArray typedArrayA = ex.a(context);
        this.a = typedArrayA.getDimensionPixelSize(R.styleable.pspdf__PropertyInspector_pspdf__itemHeight, context.getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_item_height));
        typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__backgroundColor, -1);
        typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__progressBackgroundTint, -7829368);
        this.c = typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__textColor, -7829368);
        this.g = typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__errorColor, ContextCompat.getColor(context, R.color.pspdf__errorContainerLight));
        this.h = ContextCompat.getColor(context, R.color.pspdf__outlineVariantLight);
        typedArrayA.getBoolean(R.styleable.pspdf__PropertyInspector_pspdf__searchVisible, false);
        typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__buttonIconTint, f60.a(context, androidx.appcompat.R.attr.colorAccent, R.color.pspdf__primaryLight));
        typedArrayA.recycle();
        this.d = context.getResources().getDimension(R.dimen.pspdf__inspector_text_size);
        this.b = context.getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_preview_item_height);
        this.e = context.getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_padding);
        this.f = context.getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_vertical_padding);
    }
}
