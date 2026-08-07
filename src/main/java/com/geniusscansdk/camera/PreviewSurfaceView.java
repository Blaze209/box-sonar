package com.geniusscansdk.camera;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.microsoft.intune.mam.client.widget.MAMSurfaceView;

/* JADX INFO: loaded from: classes13.dex */
public class PreviewSurfaceView extends MAMSurfaceView {
    private static final String TAG = "PreviewSurfaceView";
    private boolean isAspectFill;
    private int ratioHeight;
    private int ratioWidth;

    public PreviewSurfaceView(Context context) {
        this(context, null);
    }

    public PreviewSurfaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreviewSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ratioWidth = 0;
        this.ratioHeight = 0;
        this.isAspectFill = false;
        getHolder().setType(3);
    }

    public void setAspectRatio(int i, int i2) {
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Size cannot be negative.");
        }
        this.ratioWidth = i;
        this.ratioHeight = i2;
        requestLayout();
    }

    public void setAspectFill(boolean z) {
        this.isAspectFill = z;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        View.MeasureSpec.getMode(i);
        int i4 = this.ratioWidth;
        if (i4 != 0 && (i3 = this.ratioHeight) != 0) {
            boolean z = size < (size2 * i4) / i3;
            if (this.isAspectFill) {
                if (z) {
                    size = (i4 * size2) / i3;
                } else {
                    size2 = (i3 * size) / i4;
                }
            } else if (z) {
                size2 = (i3 * size) / i4;
            } else {
                size = (i4 * size2) / i3;
            }
        }
        setMeasuredDimension(size, size2);
    }
}
