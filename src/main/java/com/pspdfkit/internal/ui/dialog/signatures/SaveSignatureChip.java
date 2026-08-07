package com.pspdfkit.internal.ui.dialog.signatures;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.navigation.NavigationBarView;
import com.pspdfkit.R;
import com.pspdfkit.internal.a80;
import com.pspdfkit.internal.f60;

/* JADX INFO: loaded from: classes3.dex */
public final class SaveSignatureChip extends AppCompatTextView {
    public int a;

    public SaveSignatureChip(Context context) {
        super(context);
        a(null);
    }

    public final void a(AttributeSet attributeSet) {
        setBackgroundResource(R.drawable.pspdf__electronic_signature_save_signature_chip_background_selectable);
        this.a = getResources().getDimensionPixelOffset(R.dimen.pspdf__electronic_signature_save_signature_chip_padding);
        setSingleLine(true);
        setEllipsize(TextUtils.TruncateAt.END);
        setGravity(NavigationBarView.ITEM_GRAVITY_START_CENTER);
        setPaddingRelative(0, 0, this.a, 0);
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.pspdf__ic_done);
        if (drawable != null) {
            int iA = f60.a(getContext(), androidx.appcompat.R.attr.colorControlNormal, 0);
            Drawable drawableWrap = DrawableCompat.wrap(drawable);
            drawableWrap.getClass();
            DrawableCompat.setTint(drawableWrap, iA);
            TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds(this, new InsetDrawable(drawableWrap, a80.a(getContext(), 4)), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        setClickable(true);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{android.R.attr.checked});
        setSelected(typedArrayObtainStyledAttributes.getBoolean(0, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(getResources().getDimensionPixelSize(R.dimen.pspdf__electronic_signature_save_signature_chip_height), 1073741824));
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        int i = this.a;
        if (z) {
            setPaddingRelative(0, 0, i, 0);
            Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.pspdf__ic_done);
            if (drawable != null) {
                int iA = f60.a(getContext(), androidx.appcompat.R.attr.colorControlNormal, 0);
                Drawable drawableWrap = DrawableCompat.wrap(drawable);
                drawableWrap.getClass();
                DrawableCompat.setTint(drawableWrap, iA);
                TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds(this, new InsetDrawable(drawableWrap, a80.a(getContext(), 4)), (Drawable) null, (Drawable) null, (Drawable) null);
            }
        } else {
            setPaddingRelative(i, 0, i, 0);
            TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds(this, (Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        super.setSelected(z);
    }

    public SaveSignatureChip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public SaveSignatureChip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(attributeSet);
    }
}
