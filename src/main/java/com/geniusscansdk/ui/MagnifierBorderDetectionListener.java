package com.geniusscansdk.ui;

import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes13.dex */
public class MagnifierBorderDetectionListener implements BorderDetectionImageView.BorderDetectionOnTouchListener {
    private final MagnifierView magnifierView;

    public MagnifierBorderDetectionListener(MagnifierView magnifierView) {
        this.magnifierView = magnifierView;
    }

    @Override // com.geniusscansdk.ui.BorderDetectionImageView.BorderDetectionOnTouchListener
    public void onCornerFocus(float f, float f2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.magnifierView.getLayoutParams();
        int i = (((double) f) < 0.5d ? 5 : 3) | 48;
        if (layoutParams.gravity != i) {
            layoutParams.gravity = i;
            this.magnifierView.setLayoutParams(layoutParams);
            this.magnifierView.requestLayout();
        }
        this.magnifierView.onCornerFocus(f, f2);
    }

    @Override // com.geniusscansdk.ui.BorderDetectionImageView.BorderDetectionOnTouchListener
    public void onCornerUnfocus() {
        this.magnifierView.onCornerUnfocus();
    }
}
