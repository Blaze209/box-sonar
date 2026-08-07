package sdk.pendo.io.views.custom;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes5.dex */
public class MarginDrawable extends Drawable {
    private static final Paint TRANSPARENT_PAINT;
    private final int mBottom;
    private final Drawable mDrawable;
    private final int mLeft;
    private final int mRight;
    private final int mTop;

    public static final class Builder {
        private final Drawable mDrawable;
        private int mLeft = 0;
        private int mTop = 0;
        private int mRight = 0;
        private int mBottom = 0;

        public Builder(Drawable drawable) {
            this.mDrawable = drawable;
        }

        public MarginDrawable build() {
            return new MarginDrawable(this.mDrawable, this.mLeft, this.mTop, this.mRight, this.mBottom);
        }

        public Builder setBottomMargin(int i) {
            this.mBottom = i;
            return this;
        }

        public Builder setLeftMargin(int i) {
            this.mLeft = i;
            return this;
        }

        public Builder setRightMargin(int i) {
            this.mRight = i;
            return this;
        }

        public Builder setTopMargin(int i) {
            this.mTop = i;
            return this;
        }
    }

    static {
        Paint paint = new Paint();
        TRANSPARENT_PAINT = paint;
        paint.setColor(0);
    }

    private MarginDrawable(Drawable drawable, int i, int i2, int i3, int i4) {
        this.mDrawable = drawable;
        if (i < 0) {
            this.mLeft = 0;
        } else {
            this.mLeft = i;
        }
        if (i2 < 0) {
            this.mTop = 0;
        } else {
            this.mTop = i2;
        }
        if (i3 < 0) {
            this.mRight = 0;
        } else {
            this.mRight = i3;
        }
        if (i4 < 0) {
            this.mBottom = 0;
        } else {
            this.mBottom = i4;
        }
        Rect bounds = getBounds();
        int i5 = bounds.left + this.mLeft;
        int i6 = bounds.top + this.mTop;
        setBounds(i5, i6, (getIntrinsicWidth() - this.mLeft) + i5, (getIntrinsicHeight() - this.mTop) + i6);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = this.mDrawable.getBounds();
        Rect bounds2 = getBounds();
        bounds.offsetTo(bounds2.left + this.mLeft, bounds2.top + this.mTop);
        this.mDrawable.setBounds(bounds);
        canvas.drawRect(bounds2, TRANSPARENT_PAINT);
        this.mDrawable.draw(canvas);
    }

    public Drawable getDrawable() {
        return this.mDrawable;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mTop + this.mDrawable.getIntrinsicHeight() + this.mBottom;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mLeft + this.mDrawable.getIntrinsicHeight() + this.mRight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return (this.mLeft == 0 && this.mBottom == 0 && this.mTop == 0 && this.mRight == 0) ? false : true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
