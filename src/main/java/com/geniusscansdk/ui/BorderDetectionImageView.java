package com.geniusscansdk.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.geniusscansdk.core.Quadrangle;

/* JADX INFO: loaded from: classes13.dex */
public class BorderDetectionImageView extends ImageView {
    private static final int MOVE_THRESHOLD_DP = 3;
    int currentActivePointer;
    int currentCorner;
    PointF currentPosition;
    private Paint dashedPaint;
    private int imageHeight;
    private int imageWidth;
    private BorderDetectionOnTouchListener listener;
    private Paint maskPaint;
    private final float moveThresholdPx;
    PointF originalPosition;
    private Quadrangle quad;
    private Paint strokePaint;
    private float xMargin;
    private float yMargin;

    public interface BorderDetectionOnTouchListener {
        void onCornerFocus(float f, float f2);

        void onCornerUnfocus();
    }

    public void setListener(BorderDetectionOnTouchListener borderDetectionOnTouchListener) {
        this.listener = borderDetectionOnTouchListener;
    }

    public BorderDetectionImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.currentActivePointer = -1;
        this.currentCorner = -1;
        this.originalPosition = null;
        this.currentPosition = null;
        initPaints();
        this.moveThresholdPx = getResources().getDisplayMetrics().density * 3.0f;
    }

    public void setOverlayColor(int i) {
        this.strokePaint.setColor(i);
        this.dashedPaint.setColor(i);
        invalidate();
    }

    public void setOverlayColorResource(int i) {
        setOverlayColor(ContextCompat.getColor(getContext(), i));
    }

    private void initPaints() {
        Paint paint = new Paint();
        this.strokePaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.strokePaint.setStrokeWidth(dpToPx(2));
        this.strokePaint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.maskPaint = paint2;
        paint2.setARGB(70, 0, 0, 0);
        this.maskPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.maskPaint.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.dashedPaint = paint3;
        paint3.setStyle(Paint.Style.STROKE);
        this.dashedPaint.setPathEffect(new DashPathEffect(new float[]{dpToPx(7), dpToPx(7)}, 0.0f));
        this.dashedPaint.setStrokeWidth(dpToPx(1));
        this.dashedPaint.setAntiAlias(true);
    }

    private float dpToPx(int i) {
        return i * getContext().getResources().getDisplayMetrics().density;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getDrawable() != null) {
            float[] fArr = new float[9];
            getImageMatrix().getValues(fArr);
            this.imageWidth = (int) (fArr[0] * getDrawable().getIntrinsicWidth());
            this.imageHeight = (int) (fArr[4] * getDrawable().getIntrinsicHeight());
            this.xMargin = (int) fArr[2];
            this.yMargin = (int) fArr[5];
            Quadrangle quadrangle = this.quad;
            if (quadrangle != null) {
                float[] points = quadrangle.getPoints();
                float f = points[0];
                int i = this.imageWidth;
                float f2 = this.xMargin;
                float f3 = (f * i) + f2;
                float f4 = (points[2] * i) + f2;
                float f5 = (points[4] * i) + f2;
                float f6 = (points[6] * i) + f2;
                float f7 = points[1];
                int i2 = this.imageHeight;
                float f8 = this.yMargin;
                float[] fArr2 = {f3, (f7 * i2) + f8, f4, (points[3] * i2) + f8, f5, (points[5] * i2) + f8, f6, (points[7] * i2) + f8};
                Path path = new Path();
                path.moveTo(fArr2[0], fArr2[1]);
                path.lineTo(fArr2[2], fArr2[3]);
                path.lineTo(fArr2[6], fArr2[7]);
                path.lineTo(fArr2[4], fArr2[5]);
                path.close();
                Path path2 = new Path(path);
                path2.setFillType(Path.FillType.EVEN_ODD);
                path2.moveTo(this.xMargin, this.yMargin);
                path2.lineTo(this.xMargin + this.imageWidth, this.yMargin);
                path2.lineTo(this.xMargin + this.imageWidth, this.yMargin + this.imageHeight);
                path2.lineTo(this.xMargin, this.yMargin + this.imageHeight);
                path2.lineTo(this.xMargin, this.yMargin);
                Path path3 = new Path();
                path3.moveTo(((fArr2[0] * 3.0f) + (fArr2[4] * 1.0f)) / 4.0f, ((fArr2[1] * 3.0f) + (fArr2[5] * 1.0f)) / 4.0f);
                path3.lineTo(((fArr2[2] * 3.0f) + (fArr2[6] * 1.0f)) / 4.0f, ((fArr2[3] * 3.0f) + (fArr2[7] * 1.0f)) / 4.0f);
                path3.moveTo(((fArr2[0] * 2.0f) + (fArr2[4] * 2.0f)) / 4.0f, ((fArr2[1] * 2.0f) + (fArr2[5] * 2.0f)) / 4.0f);
                path3.lineTo(((fArr2[2] * 2.0f) + (fArr2[6] * 2.0f)) / 4.0f, ((fArr2[3] * 2.0f) + (fArr2[7] * 2.0f)) / 4.0f);
                path3.moveTo(((fArr2[0] * 1.0f) + (fArr2[4] * 3.0f)) / 4.0f, ((fArr2[1] * 1.0f) + (fArr2[5] * 3.0f)) / 4.0f);
                path3.lineTo(((fArr2[2] * 1.0f) + (fArr2[6] * 3.0f)) / 4.0f, ((fArr2[3] * 1.0f) + (fArr2[7] * 3.0f)) / 4.0f);
                path3.moveTo(((fArr2[0] * 3.0f) + (fArr2[2] * 1.0f)) / 4.0f, ((fArr2[1] * 3.0f) + (fArr2[3] * 1.0f)) / 4.0f);
                path3.lineTo(((fArr2[4] * 3.0f) + (fArr2[6] * 1.0f)) / 4.0f, ((fArr2[5] * 3.0f) + (fArr2[7] * 1.0f)) / 4.0f);
                path3.moveTo(((fArr2[0] * 2.0f) + (fArr2[2] * 2.0f)) / 4.0f, ((fArr2[1] * 2.0f) + (fArr2[3] * 2.0f)) / 4.0f);
                path3.lineTo(((fArr2[4] * 2.0f) + (fArr2[6] * 2.0f)) / 4.0f, ((fArr2[5] * 2.0f) + (fArr2[7] * 2.0f)) / 4.0f);
                path3.moveTo(((fArr2[0] * 1.0f) + (fArr2[2] * 3.0f)) / 4.0f, ((fArr2[1] * 1.0f) + (fArr2[3] * 3.0f)) / 4.0f);
                path3.lineTo(((fArr2[4] * 1.0f) + (fArr2[6] * 3.0f)) / 4.0f, ((fArr2[5] * 1.0f) + (fArr2[7] * 3.0f)) / 4.0f);
                canvas.drawPath(path2, this.maskPaint);
                canvas.drawPath(path3, this.dashedPaint);
                canvas.drawPath(path, this.strokePaint);
            }
        }
    }

    public Quadrangle getQuad() {
        return this.quad;
    }

    public void setQuad(Quadrangle quadrangle) {
        if (quadrangle != null && quadrangle.isEmpty()) {
            this.quad = Quadrangle.createFullQuadrangle();
        } else {
            this.quad = quadrangle;
        }
    }

    private void moveQuadrangle(int i, float f, float f2) {
        float f3 = f / this.imageWidth;
        float f4 = f2 / this.imageHeight;
        float[] points = this.quad.getPoints();
        float f5 = f2;
        int i2 = 0;
        float f6 = f;
        while (i2 < 4) {
            int i3 = i2 + 1;
            for (int i4 = i3; i4 < 4; i4++) {
                if (i2 != i && i4 != i) {
                    int i5 = i2 * 2;
                    float f7 = points[i5 + 1];
                    int i6 = i4 * 2;
                    float f8 = points[i6 + 1];
                    float f9 = points[i5];
                    float f10 = points[i6];
                    float f11 = ((f7 - f8) * f3) - ((f9 - f10) * f4);
                    if (f11 != 0.0f) {
                        int i7 = i * 2;
                        float f12 = (-(((points[i7] - f10) * (f7 - f8)) - ((points[i7 + 1] - f8) * (f9 - f10)))) / f11;
                        if (f12 >= 0.0f) {
                            float fSqrt = (float) Math.sqrt((f3 * f3) + (f4 * f4));
                            if ((f12 - 1.0f) * fSqrt < 0.03f) {
                                float f13 = f12 - (0.03f / fSqrt);
                                f6 *= f13;
                                f5 *= f13;
                            }
                        }
                    }
                }
            }
            i2 = i3;
        }
        float f14 = this.xMargin;
        float f15 = this.imageWidth + f14;
        float f16 = this.yMargin;
        float f17 = this.imageHeight + f16;
        int i8 = i * 2;
        float f18 = (this.quad.getPoints()[i8] * this.imageWidth) + this.xMargin;
        float f19 = this.quad.getPoints()[i8 + 1];
        int i9 = this.imageHeight;
        float f20 = (f19 * i9) + this.yMargin;
        float f21 = f18 + f6;
        if (f21 < f14) {
            f6 = f14 - f18;
        } else if (f21 > f15) {
            f6 = f15 - f18;
        }
        float f22 = f20 + f5;
        if (f22 < f16) {
            f5 = f16 - f20;
        } else if (f22 > f17) {
            f5 = f17 - f20;
        }
        this.quad.move(i, f6 / this.imageWidth, f5 / i9);
        invalidate();
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0073  */
    /* JADX WARN: Code duplicated, block: B:26:0x0077  */
    /* JADX WARN: Code duplicated, block: B:29:0x007d  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        BorderDetectionOnTouchListener borderDetectionOnTouchListener;
        super.onTouchEvent(motionEvent);
        if (this.quad == null) {
            return false;
        }
        int actionIndex = motionEvent.getActionIndex();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                if (this.currentActivePointer == actionIndex) {
                    this.currentActivePointer = -1;
                }
                borderDetectionOnTouchListener = this.listener;
                if (borderDetectionOnTouchListener != null) {
                    borderDetectionOnTouchListener.onCornerUnfocus();
                }
            } else if (action != 2) {
                if (action == 3) {
                    if (this.currentActivePointer == actionIndex) {
                        this.currentActivePointer = -1;
                    }
                    borderDetectionOnTouchListener = this.listener;
                    if (borderDetectionOnTouchListener != null) {
                        borderDetectionOnTouchListener.onCornerUnfocus();
                    }
                }
            } else if (this.currentActivePointer == actionIndex) {
                PointF pointF = new PointF(motionEvent.getX(actionIndex), motionEvent.getY(actionIndex));
                if (this.originalPosition == null || hasFingerMovedEnough(pointF)) {
                    this.originalPosition = null;
                    moveQuadrangle(this.currentCorner, pointF.x - this.currentPosition.x, pointF.y - this.currentPosition.y);
                    this.currentPosition = pointF;
                    BorderDetectionOnTouchListener borderDetectionOnTouchListener2 = this.listener;
                    if (borderDetectionOnTouchListener2 != null) {
                        borderDetectionOnTouchListener2.onCornerFocus(this.quad.getPoints()[this.currentCorner * 2], this.quad.getPoints()[(this.currentCorner * 2) + 1]);
                    }
                }
            }
        } else if (this.currentActivePointer == -1) {
            this.currentActivePointer = actionIndex;
            this.currentPosition = new PointF(motionEvent.getX(actionIndex), motionEvent.getY(actionIndex));
            this.originalPosition = new PointF(this.currentPosition.x, this.currentPosition.y);
            this.currentCorner = this.quad.getClosestCorner((this.currentPosition.x - this.xMargin) / this.imageWidth, (this.currentPosition.y - this.yMargin) / this.imageHeight);
        }
        return true;
    }

    private boolean hasFingerMovedEnough(PointF pointF) {
        return Math.sqrt(Math.pow((double) (pointF.x - this.originalPosition.x), 2.0d) + Math.pow((double) (pointF.y - this.originalPosition.y), 2.0d)) > ((double) this.moveThresholdPx);
    }
}
