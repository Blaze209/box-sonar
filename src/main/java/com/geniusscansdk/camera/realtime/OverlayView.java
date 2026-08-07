package com.geniusscansdk.camera.realtime;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.geniusscansdk.core.QuadStreamAnalyzer;
import com.geniusscansdk.core.Quadrangle;
import com.geniusscansdk.core.RotationAngle;

/* JADX INFO: loaded from: classes13.dex */
public class OverlayView extends View {
    private static final String TAG = "OverlayView";
    private ValueAnimator currentProgressAnimator;
    private boolean displayQuad;
    private long minDurationInAboutToTriggerForTrigger;
    private PathMeasure pathMeasure;
    private Paint quadFillPaint;
    private Path quadPath;
    private Paint quadStrokePaint;
    private Quadrangle quadrangle;
    private RotationAngle quadrangleRotationAngle;
    private Paint triggerQuadPaint;
    private Path triggerQuadPath;

    public OverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.displayQuad = false;
        this.triggerQuadPath = new Path();
        this.pathMeasure = new PathMeasure();
        Paint paint = new Paint();
        this.quadStrokePaint = paint;
        paint.setAntiAlias(true);
        this.quadStrokePaint.setStrokeJoin(Paint.Join.ROUND);
        this.quadStrokePaint.setStyle(Paint.Style.STROKE);
        this.quadStrokePaint.setStrokeWidth(TypedValue.applyDimension(1, 3.0f, getContext().getResources().getDisplayMetrics()));
        Paint paint2 = new Paint();
        this.quadFillPaint = paint2;
        paint2.setAntiAlias(true);
        this.quadFillPaint.setStrokeJoin(Paint.Join.ROUND);
        this.quadFillPaint.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint();
        this.triggerQuadPaint = paint3;
        paint3.setAntiAlias(true);
        this.triggerQuadPaint.setStrokeJoin(Paint.Join.ROUND);
        this.triggerQuadPaint.setStrokeCap(Paint.Cap.ROUND);
        this.triggerQuadPaint.setStrokeWidth(TypedValue.applyDimension(1, 7.0f, getContext().getResources().getDisplayMetrics()));
        this.triggerQuadPaint.setStyle(Paint.Style.STROKE);
        setOverlayColor(-16776961);
        if (isInEditMode()) {
            return;
        }
        this.minDurationInAboutToTriggerForTrigger = QuadStreamAnalyzer.getMinDurationInAboutToTriggerForTrigger();
    }

    public void setQuadrangleRotationAngle(RotationAngle rotationAngle) {
        this.quadrangleRotationAngle = rotationAngle;
    }

    public void setDisplayQuad(boolean z) {
        this.displayQuad = z;
        if (z) {
            return;
        }
        updateBorder(null, false);
    }

    public void setOverlayColorResource(int i) {
        setOverlayColor(getResources().getColor(i));
    }

    public void setOverlayColor(int i) {
        this.quadStrokePaint.setColor(i);
        this.quadFillPaint.setColor(i);
        this.quadFillPaint.setAlpha(128);
        this.triggerQuadPaint.setColor(i);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            setMeasuredDimension(size2, size);
        } else {
            setMeasuredDimension(size2, 0);
        }
    }

    public void updateBorder(QuadStreamAnalyzer.Result result, boolean z) {
        Quadrangle quadrangle = result == null ? null : result.resultQuadrangle;
        this.quadrangle = quadrangle;
        boolean z2 = false;
        if (quadrangle != null && !quadrangle.isFullImage()) {
            this.quadrangle = this.quadrangle.rotate(this.quadrangleRotationAngle);
            this.quadPath = new Path();
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            float[] points = this.quadrangle.getPoints();
            float f = measuredWidth - 1;
            float f2 = measuredHeight - 1;
            this.quadPath.moveTo(points[0] * f, points[1] * f2);
            this.quadPath.lineTo(points[2] * f, points[3] * f2);
            this.quadPath.lineTo(points[6] * f, points[7] * f2);
            this.quadPath.lineTo(points[4] * f, points[5] * f2);
            this.quadPath.close();
            this.pathMeasure.setPath(this.quadPath, false);
        } else {
            this.quadPath = null;
        }
        if (z && result != null && result.status == QuadStreamAnalyzer.Status.ABOUT_TO_TRIGGER) {
            z2 = true;
        }
        setAboutToTriggerAnimationEnabled(z2);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        Path path = this.quadPath;
        if (path == null || !this.displayQuad) {
            return;
        }
        canvas.drawPath(path, this.quadStrokePaint);
        canvas.drawPath(this.quadPath, this.quadFillPaint);
        if (this.currentProgressAnimator != null) {
            this.triggerQuadPath.reset();
            float fFloatValue = ((Float) this.currentProgressAnimator.getAnimatedValue()).floatValue();
            this.pathMeasure.getSegment(0.0f, this.pathMeasure.getLength() * fFloatValue, this.triggerQuadPath, true);
            this.triggerQuadPath.rLineTo(0.0f, 0.0f);
            if (fFloatValue >= 1.0f) {
                this.triggerQuadPath.close();
            }
            canvas.drawPath(this.triggerQuadPath, this.triggerQuadPaint);
        }
    }

    public void setAboutToTriggerAnimationEnabled(boolean z) {
        ValueAnimator valueAnimator;
        if (!z || this.currentProgressAnimator != null) {
            if (z || (valueAnimator = this.currentProgressAnimator) == null) {
                return;
            }
            valueAnimator.end();
            this.currentProgressAnimator = null;
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.currentProgressAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.minDurationInAboutToTriggerForTrigger);
        this.currentProgressAnimator.setInterpolator(new LinearInterpolator());
        this.currentProgressAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.geniusscansdk.camera.realtime.OverlayView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                OverlayView.this.invalidate();
            }
        });
        this.currentProgressAnimator.start();
    }
}
