package com.geniusscansdk.scanflow;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.geniusscansdk.R;
import com.microsoft.intune.mam.client.view.MAMViewGroup;

/* JADX INFO: loaded from: classes13.dex */
public class PreviewRootLayout extends MAMViewGroup {
    private View bottomToolbar;
    private View preview;
    int savedPreviewHeight;
    private View topToolbar;

    public PreviewRootLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.savedPreviewHeight = 0;
        this.bottomToolbar = null;
        this.topToolbar = null;
        this.preview = null;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 3) {
            throw new RuntimeException("Incorrect number of children.");
        }
        this.bottomToolbar = findViewById(R.id.bottom_toolbar);
        this.topToolbar = findViewById(R.id.top_toolbar);
        View viewFindViewById = findViewById(R.id.preview_layout);
        this.preview = viewFindViewById;
        View view = this.bottomToolbar;
        if (view == null || this.topToolbar == null || viewFindViewById == null) {
            throw null;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(measuredWidth, Integer.MIN_VALUE));
        this.topToolbar.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(measuredWidth, Integer.MIN_VALUE));
        this.preview.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(measuredHeight, Integer.MIN_VALUE));
        int measuredHeight2 = this.preview.getMeasuredHeight();
        int measuredWidth2 = this.preview.getMeasuredWidth();
        if (measuredHeight2 > measuredHeight) {
            throw new RuntimeException("Actual height bigger than available");
        }
        if (measuredHeight2 == 0) {
            i3 = this.savedPreviewHeight;
            if (i3 == 0) {
                i3 = measuredHeight;
            }
        } else {
            if (measuredWidth2 >= measuredWidth || measuredHeight2 >= measuredHeight) {
                measuredWidth = measuredWidth2;
            } else {
                float f = measuredHeight2 / measuredWidth2;
                float f2 = measuredHeight;
                float f3 = measuredWidth;
                if (f < f2 / f3) {
                    measuredHeight2 = (int) (f3 * f);
                } else {
                    measuredWidth = (int) (f2 / f);
                    measuredHeight2 = measuredHeight;
                }
            }
            this.savedPreviewHeight = measuredHeight2;
            measuredWidth2 = measuredWidth;
            i3 = measuredHeight2;
        }
        this.preview.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824), View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
        int measuredHeight3 = this.bottomToolbar.getMeasuredHeight();
        int measuredHeight4 = this.topToolbar.getMeasuredHeight();
        if (measuredHeight3 + measuredHeight4 + i3 <= measuredHeight) {
            int i4 = (((measuredHeight - measuredHeight3) - measuredHeight4) - i3) / 2;
            measuredHeight3 += i4;
            measuredHeight4 += i4;
        } else if (measuredHeight3 + i3 <= measuredHeight) {
            measuredHeight3 += (measuredHeight - measuredHeight3) - i3;
        }
        this.bottomToolbar.measure(i, View.MeasureSpec.makeMeasureSpec(measuredHeight3, 1073741824));
        this.topToolbar.measure(i, View.MeasureSpec.makeMeasureSpec(measuredHeight4, 1073741824));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.bottomToolbar == null || this.topToolbar == null || this.preview == null) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int measuredHeight2 = this.bottomToolbar.getMeasuredHeight();
        int measuredHeight3 = this.topToolbar.getMeasuredHeight();
        int measuredHeight4 = this.preview.getMeasuredHeight();
        int measuredWidth2 = this.preview.getMeasuredWidth();
        if (measuredHeight2 + measuredHeight3 + measuredHeight4 <= measuredHeight) {
            i5 = measuredHeight3;
        } else {
            int i6 = measuredHeight2 + measuredHeight4;
            if (i6 <= measuredHeight) {
                i5 = 0;
            } else {
                i5 = i6 - measuredHeight3 <= measuredHeight ? (measuredHeight - measuredHeight2) - measuredHeight4 : (measuredHeight - measuredHeight4) / 2;
            }
        }
        int i7 = (measuredWidth - measuredWidth2) / 2;
        this.preview.layout(i7, i5, measuredWidth - i7, measuredHeight4 + i5);
        this.topToolbar.layout(0, 0, measuredWidth, measuredHeight3);
        this.bottomToolbar.layout(0, measuredHeight - measuredHeight2, measuredWidth, measuredHeight);
    }
}
