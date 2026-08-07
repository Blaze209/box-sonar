package com.pspdfkit.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.graphics.drawable.DrawableCompat;
import com.pspdfkit.R;

/* JADX INFO: loaded from: classes3.dex */
public class AppCompatTextViewTint extends AppCompatTextView {
    public AppCompatTextViewTint(Context context) {
        super(context);
        init(context, null, 0);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.pspdf__AppCompatTextViewTint, i, 0);
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.pspdf__AppCompatTextViewTint_pspdf__drawableTint)) {
            int color = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__AppCompatTextViewTint_pspdf__drawableTint, 0);
            for (Drawable drawable : getCompoundDrawablesRelative()) {
                if (drawable != null) {
                    Drawable drawableMutate = drawable.mutate();
                    drawableMutate.getClass();
                    Drawable drawableWrap = DrawableCompat.wrap(drawableMutate);
                    drawableWrap.getClass();
                    DrawableCompat.setTint(drawableWrap, color);
                }
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public AppCompatTextViewTint(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet, 0);
    }

    public AppCompatTextViewTint(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet, i);
    }
}
