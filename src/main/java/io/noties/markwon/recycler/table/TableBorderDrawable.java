package io.noties.markwon.recycler.table;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes4.dex */
class TableBorderDrawable extends Drawable {
    private final Paint paint;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    TableBorderDrawable() {
        Paint paint = new Paint(1);
        this.paint = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.paint.getStrokeWidth() > 0.0f) {
            canvas.drawRect(getBounds(), this.paint);
        }
    }

    void update(int i, int i2) {
        this.paint.setStrokeWidth(i);
        this.paint.setColor(i2);
        invalidateSelf();
    }
}
