package com.geniusscansdk.scanflow;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: classes13.dex */
class ZoomableImageView extends AppCompatImageView implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    static final int CLICK = 3;
    private static final float DOUBLE_TAP_SCALE = 2.0f;
    static final int DRAG = 1;
    static final int NONE = 0;
    static final int ZOOM = 2;
    Context context;
    PointF last;
    float[] m;
    GestureDetector mGestureDetector;
    ScaleGestureDetector mScaleDetector;
    Matrix matrix;
    float maxScale;
    float minScale;
    int mode;
    int oldMeasuredHeight;
    int oldMeasuredWidth;
    protected float origHeight;
    protected float origWidth;
    float saveScale;
    PointF start;
    int viewHeight;
    int viewWidth;

    float getFixDragTranslation(float f, float f2, float f3) {
        if (f3 <= f2) {
            return 0.0f;
        }
        return f;
    }

    float getFixTranslation(float f, float f2, float f3) {
        float f4;
        float f5;
        if (f3 <= f2) {
            f5 = f2 - f3;
            f4 = 0.0f;
        } else {
            f4 = f2 - f3;
            f5 = 0.0f;
        }
        if (f < f4) {
            return (-f) + f4;
        }
        if (f > f5) {
            return (-f) + f5;
        }
        return 0.0f;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public ZoomableImageView(Context context) {
        super(context);
        this.mode = 0;
        this.last = new PointF();
        this.start = new PointF();
        this.minScale = 1.0f;
        this.maxScale = 10.0f;
        this.saveScale = 1.0f;
        setup(context);
    }

    public ZoomableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mode = 0;
        this.last = new PointF();
        this.start = new PointF();
        this.minScale = 1.0f;
        this.maxScale = 10.0f;
        this.saveScale = 1.0f;
        setup(context);
    }

    private void setup(Context context) {
        super.setClickable(true);
        this.context = context;
        setupGestures(context);
        setupMatrix();
        setupTouchListener();
    }

    private void setupGestures(Context context) {
        GestureDetector gestureDetector = new GestureDetector(context, this);
        this.mGestureDetector = gestureDetector;
        gestureDetector.setOnDoubleTapListener(this);
        this.mScaleDetector = new ScaleGestureDetector(context, new ScaleListener());
    }

    private void setupMatrix() {
        Matrix matrix = new Matrix();
        this.matrix = matrix;
        this.m = new float[9];
        setImageMatrix(matrix);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    private void setupTouchListener() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.geniusscansdk.scanflow.ZoomableImageView.1
            private void handleDownAction(PointF pointF) {
                ZoomableImageView.this.last.set(pointF);
                ZoomableImageView.this.start.set(ZoomableImageView.this.last);
            }

            private void handleDragMove(PointF pointF) {
                float f = pointF.x - ZoomableImageView.this.last.x;
                float f2 = pointF.y - ZoomableImageView.this.last.y;
                float f3 = ZoomableImageView.this.origWidth * ZoomableImageView.this.saveScale;
                float f4 = ZoomableImageView.this.origHeight * ZoomableImageView.this.saveScale;
                ZoomableImageView zoomableImageView = ZoomableImageView.this;
                float fixDragTranslation = zoomableImageView.getFixDragTranslation(f, zoomableImageView.viewWidth, f3);
                ZoomableImageView zoomableImageView2 = ZoomableImageView.this;
                ZoomableImageView.this.matrix.postTranslate(fixDragTranslation, zoomableImageView2.getFixDragTranslation(f2, zoomableImageView2.viewHeight, f4));
                ZoomableImageView.this.fixTranslation();
                ZoomableImageView.this.last.set(pointF.x, pointF.y);
            }

            private void handleUpAction(PointF pointF) {
                int iAbs = (int) Math.abs(pointF.x - ZoomableImageView.this.start.x);
                int iAbs2 = (int) Math.abs(pointF.y - ZoomableImageView.this.start.y);
                if (iAbs >= 3 || iAbs2 >= 3) {
                    return;
                }
                ZoomableImageView.this.performClick();
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ZoomableImageView.this.mScaleDetector.onTouchEvent(motionEvent);
                ZoomableImageView.this.mGestureDetector.onTouchEvent(motionEvent);
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                int action = motionEvent.getAction();
                if (action == 0) {
                    handleDownAction(pointF);
                    ZoomableImageView.this.mode = 1;
                } else if (action == 1) {
                    ZoomableImageView.this.mode = 0;
                    handleUpAction(pointF);
                } else if (action != 2) {
                    if (action == 6) {
                        ZoomableImageView.this.mode = 0;
                    }
                } else if (ZoomableImageView.this.mode == 1) {
                    handleDragMove(pointF);
                }
                ZoomableImageView zoomableImageView = ZoomableImageView.this;
                zoomableImageView.setImageMatrix(zoomableImageView.matrix);
                ZoomableImageView.this.invalidate();
                return true;
            }
        });
    }

    public void setMaxZoom(float f) {
        this.maxScale = f;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        float f = this.saveScale;
        float f2 = this.minScale;
        if (f != f2) {
            this.saveScale = f2;
        } else {
            f2 = f * 2.0f;
            this.saveScale = f2;
        }
        float f3 = f2 / f;
        this.matrix.postScale(f3, f3, this.viewWidth / 2.0f, this.viewHeight / 2.0f);
        fixTranslation();
        return false;
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private ScaleListener() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            ZoomableImageView.this.mode = 2;
            return true;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x0073  */
        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float f;
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            float f2 = ZoomableImageView.this.saveScale;
            ZoomableImageView.this.saveScale *= scaleFactor;
            if (ZoomableImageView.this.saveScale > ZoomableImageView.this.maxScale) {
                ZoomableImageView zoomableImageView = ZoomableImageView.this;
                zoomableImageView.saveScale = zoomableImageView.maxScale;
                f = ZoomableImageView.this.maxScale;
            } else {
                if (ZoomableImageView.this.saveScale < ZoomableImageView.this.minScale) {
                    ZoomableImageView zoomableImageView2 = ZoomableImageView.this;
                    zoomableImageView2.saveScale = zoomableImageView2.minScale;
                    f = ZoomableImageView.this.minScale;
                }
                if (ZoomableImageView.this.origWidth * ZoomableImageView.this.saveScale > ZoomableImageView.this.viewWidth || ZoomableImageView.this.origHeight * ZoomableImageView.this.saveScale <= ZoomableImageView.this.viewHeight) {
                    ZoomableImageView.this.matrix.postScale(scaleFactor, scaleFactor, ZoomableImageView.this.viewWidth / 2.0f, ZoomableImageView.this.viewHeight / 2.0f);
                } else {
                    ZoomableImageView.this.matrix.postScale(scaleFactor, scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                }
                ZoomableImageView.this.fixTranslation();
                return true;
            }
            scaleFactor = f / f2;
            if (ZoomableImageView.this.origWidth * ZoomableImageView.this.saveScale > ZoomableImageView.this.viewWidth) {
                ZoomableImageView.this.matrix.postScale(scaleFactor, scaleFactor, ZoomableImageView.this.viewWidth / 2.0f, ZoomableImageView.this.viewHeight / 2.0f);
            } else {
                ZoomableImageView.this.matrix.postScale(scaleFactor, scaleFactor, ZoomableImageView.this.viewWidth / 2.0f, ZoomableImageView.this.viewHeight / 2.0f);
            }
            ZoomableImageView.this.fixTranslation();
            return true;
        }
    }

    private PointF getPointFromMatrix(Matrix matrix) {
        matrix.getValues(this.m);
        float[] fArr = this.m;
        return new PointF(fArr[2], fArr[5]);
    }

    void fixTranslation() {
        PointF pointFromMatrix = getPointFromMatrix(this.matrix);
        float fixTranslation = getFixTranslation(pointFromMatrix.x, this.viewWidth, this.origWidth * this.saveScale);
        float fixTranslation2 = getFixTranslation(pointFromMatrix.y, this.viewHeight, this.origHeight * this.saveScale);
        if (fixTranslation == 0.0f && fixTranslation2 == 0.0f) {
            return;
        }
        this.matrix.postTranslate(fixTranslation, fixTranslation2);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.viewWidth = View.MeasureSpec.getSize(i);
        int size = View.MeasureSpec.getSize(i2);
        this.viewHeight = size;
        int i3 = this.oldMeasuredHeight;
        int i4 = this.viewWidth;
        if ((i3 == i4 && i3 == size) || i4 == 0 || size == 0) {
            return;
        }
        this.oldMeasuredHeight = size;
        this.oldMeasuredWidth = i4;
        if (this.saveScale == 1.0f) {
            fitToScreen();
        }
        fixTranslation();
    }

    private void fitToScreen() {
        Drawable drawable = getDrawable();
        if (drawable == null || drawable.getIntrinsicWidth() == 0 || drawable.getIntrinsicHeight() == 0) {
            return;
        }
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        float fMin = Math.min(this.viewWidth / intrinsicWidth, this.viewHeight / intrinsicHeight);
        this.matrix.setScale(fMin, fMin);
        float f = (this.viewHeight - (intrinsicHeight * fMin)) / 2.0f;
        float f2 = (this.viewWidth - (fMin * intrinsicWidth)) / 2.0f;
        this.matrix.postTranslate(f2, f);
        this.origWidth = this.viewWidth - (f2 * 2.0f);
        this.origHeight = this.viewHeight - (f * 2.0f);
        setImageMatrix(this.matrix);
    }
}
