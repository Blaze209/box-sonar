package com.box.android.base.presentation.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.box.android.base.R;
import com.microsoft.intune.mam.client.widget.MAMRelativeLayout;

/* JADX INFO: loaded from: classes9.dex */
public class AspectRatioRelativeLayout extends MAMRelativeLayout {
    float mAspectRatio;

    public AspectRatioRelativeLayout(Context context) {
        super(context);
        this.mAspectRatio = -1.0f;
    }

    public AspectRatioRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAspectRatio = -1.0f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AspectRatioRelativeLayout);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == R.styleable.AspectRatioRelativeLayout_aspectRatio) {
                this.mAspectRatio = typedArrayObtainStyledAttributes.getFloat(index, -1.0f);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        float f = this.mAspectRatio;
        if (f > 0.0f && mode == 1073741824 && size > size2) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec((int) (f * size), 1073741824));
        } else {
            super.onMeasure(i, i2);
        }
    }
}
