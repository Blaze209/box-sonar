package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.pspdfkit.R;

/* JADX INFO: loaded from: classes3.dex */
public final class ij extends FrameLayout {
    public final TextView a;
    public final ImageView b;
    public final View c;

    public ij(Context context) {
        super(context);
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.pspdf__grid_list_item, (ViewGroup) this, true);
        this.a = (TextView) viewInflate.findViewById(R.id.pspdf__label);
        this.b = (ImageView) viewInflate.findViewById(R.id.pspdf__icon);
        this.c = viewInflate.findViewById(R.id.pspdf__icon_background);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.weight = 1.0f;
        setLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.b.getDrawable().setAlpha(z ? 255 : 128);
    }

    public void setIcon(Drawable drawable) {
        this.b.setImageDrawable(drawable);
    }

    public void setIconBackground(Drawable drawable) {
        this.c.setBackground(drawable);
    }

    public void setIconPadding(int i) {
        this.b.setPadding(i, i, i, i);
    }

    public void setLabel(String str) {
        this.a.setText(str);
    }

    public void setLabelTextColor(int i) {
        this.a.setTextColor(i);
    }
}
