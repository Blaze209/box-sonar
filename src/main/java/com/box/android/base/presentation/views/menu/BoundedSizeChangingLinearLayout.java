package com.box.android.base.presentation.views.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.box.android.base.R;

/* JADX INFO: loaded from: classes9.dex */
public class BoundedSizeChangingLinearLayout extends LinearLayout {
    private int mMaxHeight;
    private int mOriginalHeightDifference;
    private SizeChangeDelegate mSizeChangeDelegate;

    public interface SizeChangeDelegate {
        boolean isSizeChanging();
    }

    public BoundedSizeChangingLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BoundedSizeChangingLinearLayout);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == R.styleable.BoundedSizeChangingLinearLayout_maxHeight) {
                this.mMaxHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public BoundedSizeChangingLinearLayout(Context context) {
        super(context);
    }

    public void setSizeChangeDelegate(SizeChangeDelegate sizeChangeDelegate) {
        this.mSizeChangeDelegate = sizeChangeDelegate;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int iMax;
        int size = View.MeasureSpec.getSize(i2);
        if (!this.mSizeChangeDelegate.isSizeChanging()) {
            super.onMeasure(i, i2);
            iMax = Math.min(getMeasuredHeight(), this.mMaxHeight);
            this.mOriginalHeightDifference = Math.max(size - iMax, 0);
        } else {
            iMax = Math.max(size - this.mOriginalHeightDifference, 0);
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(iMax, 1073741824));
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        SizeChangeDelegate sizeChangeDelegate = this.mSizeChangeDelegate;
        if (sizeChangeDelegate != null && sizeChangeDelegate.isSizeChanging()) {
            postDelayed(new Runnable() { // from class: com.box.android.base.presentation.views.menu.BoundedSizeChangingLinearLayout.1
                @Override // java.lang.Runnable
                public void run() {
                    BoundedSizeChangingLinearLayout.super.requestLayout();
                }
            }, 500L);
        }
        super.requestLayout();
    }
}
