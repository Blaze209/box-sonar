package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.pspdfkit.R;

/* JADX INFO: loaded from: classes3.dex */
public class yq implements wc.a {
    protected int cornerRadius;
    protected int titleColor;
    protected int titleHeight;
    protected int titleIconsColor;
    protected int titlePadding;
    protected int titleTextColor;
    protected int titleTextSize;

    public yq(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R.styleable.pspdf__ModalDialog, R.attr.pspdf__modalDialogStyle, R.style.PSPDFKit_ModalDialog);
        this.titleColor = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__ModalDialog_pspdf__titleBackground, f60.a(context, androidx.appcompat.R.attr.colorPrimary, R.color.pspdf__primaryLight));
        this.titleTextColor = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__ModalDialog_pspdf__titleTextColor, ContextCompat.getColor(context, R.color.pspdf__onPrimaryLight));
        this.titleIconsColor = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__ModalDialog_pspdf__titleIconsColor, ContextCompat.getColor(context, R.color.pspdf__onPrimaryLight));
        this.titleHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.pspdf__ModalDialog_pspdf__titleHeight, context.getResources().getDimensionPixelSize(R.dimen.pspdf__dialog_title_height));
        this.titleTextSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.pspdf__ModalDialog_pspdf__titleTextSize, context.getResources().getDimensionPixelSize(R.dimen.pspdf__dialog_title_text_size));
        this.titlePadding = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.pspdf__ModalDialog_pspdf__titlePadding, context.getResources().getDimensionPixelSize(R.dimen.pspdf__dialog_title_padding));
        this.cornerRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.pspdf__ModalDialog_pspdf__cornerRadius, context.getResources().getDimensionPixelSize(R.dimen.pspdf__dialog_corner_radius));
        typedArrayObtainStyledAttributes.recycle();
    }

    public static void setRoundedBackground(View view, wc wcVar, int i, int i2, boolean z) {
        float f;
        if (z) {
            if (wcVar != null) {
                wcVar.setRoundedCornersRadius(0.0f);
            }
            view.setBackgroundColor(i);
        } else {
            if (wcVar != null) {
                f = i2 + 2;
                wcVar.setRoundedCornersRadius(i2);
            } else {
                f = i2;
            }
            float f2 = i2;
            a80.a(view, i, new float[]{f, f, f, f, f2, f2, f2, f2});
        }
    }

    @Override // com.pspdfkit.internal.wc.a
    public int getCornerRadius() {
        return this.cornerRadius;
    }

    @Override // com.pspdfkit.internal.wc.a
    public int getTitleColor() {
        return this.titleColor;
    }

    @Override // com.pspdfkit.internal.wc.a
    public int getTitleHeight() {
        return this.titleHeight;
    }

    @Override // com.pspdfkit.internal.wc.a
    public int getTitleIconsColor() {
        return this.titleIconsColor;
    }

    @Override // com.pspdfkit.internal.wc.a
    public int getTitlePadding() {
        return this.titlePadding;
    }

    @Override // com.pspdfkit.internal.wc.a
    public int getTitleTextColor() {
        return this.titleTextColor;
    }

    @Override // com.pspdfkit.internal.wc.a
    public int getTitleTextSize() {
        return this.titleTextSize;
    }
}
