package com.geniusscansdk.scanflow;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.geniusscansdk.R;

/* JADX INFO: loaded from: classes13.dex */
class ShutterButton extends View {
    private static final float SEARCH_SWEEP_ANGLE = 233.99998f;
    private final ValueAnimator animation;
    private final Paint arcPaint;
    private final RectF buttonRect;
    private float currentAngle;
    private int innerCircleColor;
    private final Paint innerCirclePaint;
    private int innerCirclePressedColor;
    private float sweepAngle;

    public ShutterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.innerCircleColor = -1;
        this.innerCirclePressedColor = 0;
        Paint paint = new Paint();
        this.arcPaint = paint;
        float fApplyDimension = TypedValue.applyDimension(1, 6.0f, getResources().getDisplayMetrics());
        paint.setStrokeWidth(fApplyDimension);
        paint.setColor(-1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        float f = fApplyDimension * 0.5f;
        float dimension = getResources().getDimension(R.dimen.shutter_button_size) - f;
        this.buttonRect = new RectF(f, f, dimension, dimension);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
        this.animation = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(2000L);
        valueAnimatorOfFloat.setRepeatCount(-1);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.geniusscansdk.scanflow.ShutterButton$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$new$0(valueAnimator);
            }
        });
        Paint paint2 = new Paint();
        this.innerCirclePaint = paint2;
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.FILL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(ValueAnimator valueAnimator) {
        this.currentAngle = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.buttonRect, this.currentAngle, this.sweepAngle, false, this.arcPaint);
        this.innerCirclePaint.setColor(isPressed() ? this.innerCirclePressedColor : this.innerCircleColor);
        canvas.drawCircle(getMeasuredWidth() * 0.5f, getMeasuredHeight() * 0.5f, getResources().getDimension(R.dimen.shutter_button_inner_circle_size) * 0.5f, this.innerCirclePaint);
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        super.setPressed(z);
        invalidate();
    }

    public void setInnerCircleColor(int i) {
        this.innerCircleColor = i;
    }

    public void setInnerCirclePressedColor(int i) {
        this.innerCirclePressedColor = i;
    }

    public void setButtonArcColor(int i) {
        this.arcPaint.setColor(i);
    }

    public void setSearchAnimationEnabled(boolean z) {
        if (z) {
            this.sweepAngle = SEARCH_SWEEP_ANGLE;
            this.animation.start();
        } else {
            this.sweepAngle = 360.0f;
            this.animation.end();
        }
        invalidate();
    }
}
