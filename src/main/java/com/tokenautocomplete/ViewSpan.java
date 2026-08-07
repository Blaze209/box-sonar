package com.tokenautocomplete;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes3.dex */
public class ViewSpan extends ReplacementSpan {
    private int cachedMaxWidth = -1;
    private Layout layout;
    protected View view;

    public interface Layout {
        int getMaxViewSpanWidth();
    }

    public ViewSpan(View view, Layout layout) {
        this.layout = layout;
        this.view = view;
        view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    }

    private void prepView() {
        if (this.layout.getMaxViewSpanWidth() != this.cachedMaxWidth) {
            int maxViewSpanWidth = this.layout.getMaxViewSpanWidth();
            this.cachedMaxWidth = maxViewSpanWidth;
            this.view.measure(View.MeasureSpec.makeMeasureSpec(maxViewSpanWidth, maxViewSpanWidth == 0 ? 0 : Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
            View view = this.view;
            view.layout(0, 0, view.getMeasuredWidth(), this.view.getMeasuredHeight());
        }
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        prepView();
        canvas.save();
        canvas.translate(f, i3);
        this.view.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        prepView();
        if (fontMetricsInt != null) {
            int measuredHeight = this.view.getMeasuredHeight();
            int baseline = this.view.getBaseline();
            if (baseline == -1) {
                baseline = measuredHeight;
            }
            int i3 = -baseline;
            fontMetricsInt.top = i3;
            fontMetricsInt.ascent = i3;
            int i4 = measuredHeight - baseline;
            fontMetricsInt.bottom = i4;
            fontMetricsInt.descent = i4;
        }
        return this.view.getRight();
    }
}
