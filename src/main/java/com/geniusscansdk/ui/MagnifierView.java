package com.geniusscansdk.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes13.dex */
public class MagnifierView extends View implements BorderDetectionImageView.BorderDetectionOnTouchListener {
    private static int BORDER_WIDTH = 3;
    private static int PADDING = 3 + 5;
    private static int SHADOW_WIDTH = 5;
    private Bitmap bitmap;
    private Paint bitmapPaint;
    private Paint borderPaint;
    private Paint crosshairPaint;
    private Path crosshairPath;
    private RelativePoint currentFocusedPoint;
    private Paint shadowPaint;

    @Override // com.geniusscansdk.ui.BorderDetectionImageView.BorderDetectionOnTouchListener
    public void onCornerFocus(float f, float f2) {
        this.currentFocusedPoint = new RelativePoint(f, f2);
        invalidate();
    }

    @Override // com.geniusscansdk.ui.BorderDetectionImageView.BorderDetectionOnTouchListener
    public void onCornerUnfocus() {
        this.currentFocusedPoint = null;
        invalidate();
    }

    private class RelativePoint {
        float x;
        float y;

        private RelativePoint(float f, float f2) {
            this.x = f;
            this.y = f2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getX() {
            return this.x;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getY() {
            return this.y;
        }
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public MagnifierView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initializePaints();
    }

    private void initializePaints() {
        float f = getResources().getDisplayMetrics().density;
        this.bitmapPaint = new Paint();
        Paint paint = new Paint();
        this.crosshairPaint = paint;
        paint.setColor(-7829368);
        this.crosshairPaint.setStyle(Paint.Style.STROKE);
        float f2 = 1.0f * f;
        this.crosshairPaint.setStrokeWidth(f2);
        Paint paint2 = new Paint();
        this.borderPaint = paint2;
        paint2.setAntiAlias(true);
        this.borderPaint.setColor(-1);
        this.borderPaint.setStyle(Paint.Style.STROKE);
        this.borderPaint.setStrokeWidth(BORDER_WIDTH * f);
        Paint paint3 = new Paint();
        this.shadowPaint = paint3;
        setLayerType(1, paint3);
        this.shadowPaint.setShadowLayer(SHADOW_WIDTH * f, 0.0f, f2, -16777216);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int i5 = (int) (getResources().getDisplayMetrics().density * 30.0f);
        Path path = new Path();
        this.crosshairPath = path;
        float f = i2 / 2;
        path.moveTo((i - i5) / 2, f);
        this.crosshairPath.lineTo((i + i5) / 2, f);
        float f2 = i / 2;
        this.crosshairPath.moveTo(f2, (i2 - i5) / 2);
        this.crosshairPath.lineTo(f2, (i2 + i5) / 2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.currentFocusedPoint != null) {
            int width = getWidth();
            int height = getHeight();
            float f = getResources().getDisplayMetrics().density;
            float f2 = width / 2;
            float f3 = height / 2;
            float f4 = width / 2.0f;
            canvas.drawCircle(f2, f3, f4 - (PADDING * f), this.shadowPaint);
            int x = (int) (this.currentFocusedPoint.getX() * this.bitmap.getWidth());
            int y = (int) (this.currentFocusedPoint.getY() * this.bitmap.getHeight());
            Bitmap bitmap = this.bitmap;
            int i = PADDING;
            Bitmap roundedBitmap = getRoundedBitmap(bitmap, x, y, width - ((int) ((i * f) * 2.0f)), height - ((int) ((i * f) * 2.0f)));
            int i2 = PADDING;
            canvas.drawBitmap(roundedBitmap, i2 * f, i2 * f, this.bitmapPaint);
            canvas.drawPath(this.crosshairPath, this.crosshairPaint);
            canvas.drawCircle(f2, f3, f4 - (PADDING * f), this.borderPaint);
        }
    }

    private Bitmap getRoundedBitmap(Bitmap bitmap, int i, int i2, int i3, int i4) {
        int iMin = Math.min(i3, i4);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        int i5 = iMin / 2;
        float f = i5;
        canvas.drawCircle(f, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, (-i) + i5, (-i2) + i5, paint);
        return bitmapCreateBitmap;
    }
}
