package com.geniusscansdk.camera;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.core.internal.view.SupportMenu;
import com.geniusscansdk.R;

/* JADX INFO: loaded from: classes13.dex */
public class DefaultFocusIndicator extends FrameLayout implements FocusIndicator {
    private Point center;
    private Paint paint;
    private boolean visible;

    public DefaultFocusIndicator(Context context) {
        this(context, null);
    }

    public DefaultFocusIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DefaultFocusIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.visible = false;
        initialize();
        setBackgroundColor(0);
    }

    private void initialize() {
        setVisible(false);
        Paint paint = new Paint();
        this.paint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(getContext().getResources().getDimensionPixelSize(R.dimen.focus_indicator_stroke_size));
        this.paint.setAntiAlias(true);
    }

    @Override // com.geniusscansdk.camera.FocusIndicator
    public void setPosition(int i, int i2) {
        this.center = new Point(i, i2);
    }

    @Override // com.geniusscansdk.camera.FocusIndicator
    public void showStart() {
        setVisible(true);
        setColor(-1);
    }

    @Override // com.geniusscansdk.camera.FocusIndicator
    public void showFinished(boolean z) {
        setColor(z ? -16711936 : SupportMenu.CATEGORY_MASK);
    }

    @Override // com.geniusscansdk.camera.FocusIndicator
    public void hide() {
        setVisible(false);
    }

    private void setVisible(boolean z) {
        this.visible = z;
        invalidate();
    }

    private void setColor(int i) {
        this.paint.setColor(i);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.visible) {
            if (this.center == null) {
                this.center = new Point(getWidth() / 2, getHeight() / 2);
            }
            canvas.drawCircle(this.center.x, this.center.y, getContext().getResources().getDimensionPixelSize(R.dimen.focus_indicator_size) / 2, this.paint);
        }
    }
}
