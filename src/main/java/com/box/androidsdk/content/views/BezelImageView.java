package com.box.androidsdk.content.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.box.android.dataaccess.content.R;

/* JADX INFO: loaded from: classes13.dex */
public class BezelImageView extends AppCompatImageView {
    private Paint mBlackPaint;
    private Drawable mBorderDrawable;
    private Rect mBounds;
    private RectF mBoundsF;
    private Bitmap mCacheBitmap;
    private boolean mCacheValid;
    private int mCachedHeight;
    private int mCachedWidth;
    private ColorMatrixColorFilter mDesaturateColorFilter;
    private boolean mDesaturateOnPress;
    private Drawable mMaskDrawable;
    private Paint mMaskedPaint;

    public BezelImageView(Context context) {
        this(context, null);
    }

    public BezelImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BezelImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDesaturateOnPress = false;
        this.mCacheValid = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BezelImageView, i, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.BezelImageView_maskDrawable);
        this.mMaskDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(R.styleable.BezelImageView_borderDrawable);
        this.mBorderDrawable = drawable2;
        if (drawable2 != null) {
            drawable2.setCallback(this);
        }
        this.mDesaturateOnPress = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BezelImageView_desaturateOnPress, this.mDesaturateOnPress);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.mBlackPaint = paint;
        paint.setColor(-16777216);
        Paint paint2 = new Paint();
        this.mMaskedPaint = paint2;
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.mCacheBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        if (this.mDesaturateOnPress) {
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(0.0f);
            this.mDesaturateColorFilter = new ColorMatrixColorFilter(colorMatrix);
        }
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        this.mBounds = new Rect(0, 0, i3 - i, i4 - i2);
        this.mBoundsF = new RectF(this.mBounds);
        Drawable drawable = this.mBorderDrawable;
        if (drawable != null) {
            drawable.setBounds(this.mBounds);
        }
        Drawable drawable2 = this.mMaskDrawable;
        if (drawable2 != null) {
            drawable2.setBounds(this.mBounds);
        }
        if (frame) {
            this.mCacheValid = false;
        }
        return frame;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Rect rect = this.mBounds;
        if (rect == null) {
            return;
        }
        int iWidth = rect.width();
        int iHeight = this.mBounds.height();
        if (iWidth == 0 || iHeight == 0) {
            return;
        }
        if (!this.mCacheValid || iWidth != this.mCachedWidth || iHeight != this.mCachedHeight) {
            if (iWidth == this.mCachedWidth && iHeight == this.mCachedHeight) {
                this.mCacheBitmap.eraseColor(0);
            } else {
                this.mCacheBitmap.recycle();
                this.mCacheBitmap = Bitmap.createBitmap(iWidth, iHeight, Bitmap.Config.ARGB_8888);
                this.mCachedWidth = iWidth;
                this.mCachedHeight = iHeight;
            }
            Canvas canvas2 = new Canvas(this.mCacheBitmap);
            if (this.mMaskDrawable != null) {
                int iSave = canvas2.save();
                this.mMaskDrawable.draw(canvas2);
                this.mMaskedPaint.setColorFilter((this.mDesaturateOnPress && isPressed()) ? this.mDesaturateColorFilter : null);
                saveLayer(canvas2);
                super.onDraw(canvas2);
                canvas2.restoreToCount(iSave);
            } else if (this.mDesaturateOnPress && isPressed()) {
                int iSave2 = canvas2.save();
                canvas2.drawRect(0.0f, 0.0f, this.mCachedWidth, this.mCachedHeight, this.mBlackPaint);
                this.mMaskedPaint.setColorFilter(this.mDesaturateColorFilter);
                saveLayer(canvas2);
                super.onDraw(canvas2);
                canvas2.restoreToCount(iSave2);
            } else {
                super.onDraw(canvas2);
            }
            Drawable drawable = this.mBorderDrawable;
            if (drawable != null) {
                drawable.draw(canvas2);
            }
        }
        canvas.drawBitmap(this.mCacheBitmap, this.mBounds.left, this.mBounds.top, (Paint) null);
    }

    private void saveLayer(Canvas canvas) {
        canvas.saveLayer(this.mBoundsF, this.mMaskedPaint);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mBorderDrawable;
        if (drawable != null && drawable.isStateful()) {
            this.mBorderDrawable.setState(getDrawableState());
        }
        Drawable drawable2 = this.mMaskDrawable;
        if (drawable2 != null && drawable2.isStateful()) {
            this.mMaskDrawable.setState(getDrawableState());
        }
        if (isDuplicateParentStateEnabled()) {
            postInvalidateOnAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        if (drawable == this.mBorderDrawable || drawable == this.mMaskDrawable) {
            invalidate();
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return drawable == this.mBorderDrawable || drawable == this.mMaskDrawable || super.verifyDrawable(drawable);
    }
}
