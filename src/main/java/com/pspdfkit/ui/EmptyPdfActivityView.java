package com.pspdfkit.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.pspdfkit.R;

/* JADX INFO: loaded from: classes3.dex */
public class EmptyPdfActivityView extends LinearLayout {
    public EmptyPdfActivityView(Context context) {
        super(context);
    }

    private void prepareViews() {
        if (getChildCount() != 0) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{R.attr.pspdf__backgroundColor});
        int color = typedArrayObtainStyledAttributes.getColor(0, ContextCompat.getColor(getContext(), R.color.pspdf__surfaceLight));
        typedArrayObtainStyledAttributes.recycle();
        setBackgroundColor(color);
        setGravity(17);
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.pspdf__view_empty_activity, (ViewGroup) this, true);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            prepareViews();
        }
    }

    public EmptyPdfActivityView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EmptyPdfActivityView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public EmptyPdfActivityView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
