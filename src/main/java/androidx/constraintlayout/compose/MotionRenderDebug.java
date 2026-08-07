package androidx.constraintlayout.compose;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import androidx.constraintlayout.core.motion.Motion;
import androidx.core.internal.view.SupportMenu;
import com.box.android.observability.DiagnosisParams;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MotionRenderDebug.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0014\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0000\u0018\u0000 z2\u00020\u0001:\u0001zB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J>\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\u00122\u0006\u0010Y\u001a\u00020\u00122\u0006\u0010Z\u001a\u00020\u00122\u0006\u0010[\u001a\u00020B2\u0006\u0010\\\u001a\u00020BJ6\u0010]\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\u00122\u0006\u0010^\u001a\u00020\u00122\u0006\u0010Y\u001a\u00020\u00122\u0006\u0010Z\u001a\u00020\u0012JZ\u0010]\u001a\u00020S2\u0006\u0010T\u001a\u00020U2*\u0010_\u001a&\u0012\u0006\u0012\u0004\u0018\u00010a\u0012\u0004\u0012\u00020W\u0018\u00010`j\u0012\u0012\u0006\u0012\u0004\u0018\u00010a\u0012\u0004\u0012\u00020W\u0018\u0001`b2\u0006\u0010X\u001a\u00020\u00122\u0006\u0010^\u001a\u00020\u00122\u0006\u0010Y\u001a\u00020\u00122\u0006\u0010Z\u001a\u00020\u0012J6\u0010c\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010d\u001a\u00020\u00122\u0006\u0010e\u001a\u00020\u00122\u0006\u0010V\u001a\u00020W2\u0006\u0010Y\u001a\u00020\u00122\u0006\u0010Z\u001a\u00020\u0012J\u0010\u0010f\u001a\u00020S2\u0006\u0010T\u001a\u00020UH\u0002J\u0010\u0010g\u001a\u00020S2\u0006\u0010T\u001a\u00020UH\u0002J\u0010\u0010h\u001a\u00020S2\u0006\u0010T\u001a\u00020UH\u0002J \u0010i\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010j\u001a\u00020\u00032\u0006\u0010k\u001a\u00020\u0003H\u0002J\u0010\u0010l\u001a\u00020S2\u0006\u0010T\u001a\u00020UH\u0002J \u0010m\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010j\u001a\u00020\u00032\u0006\u0010k\u001a\u00020\u0003H\u0002J@\u0010n\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010j\u001a\u00020\u00032\u0006\u0010k\u001a\u00020\u00032\u0006\u0010o\u001a\u00020\u00122\u0006\u0010p\u001a\u00020\u00122\u0006\u0010Y\u001a\u00020\u00122\u0006\u0010Z\u001a\u00020\u0012H\u0002J\u0018\u0010q\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020WH\u0002J8\u0010\\\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010d\u001a\u00020\u00122\u0006\u0010e\u001a\u00020\u00122\u0006\u0010V\u001a\u00020W2\u0006\u0010Y\u001a\u00020\u00122\u0006\u0010Z\u001a\u00020\u0012H\u0002J0\u0010r\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010s\u001a\u00020\u00032\u0006\u0010t\u001a\u00020\u00032\u0006\u0010u\u001a\u00020\u00032\u0006\u0010v\u001a\u00020\u0003H\u0002J\u0016\u0010w\u001a\u00020S2\u0006\u0010x\u001a\u00020a2\u0006\u0010y\u001a\u00020\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u0012X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u001a\u0010\u001d\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u0012X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0014R\u001a\u0010)\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0018\"\u0004\b+\u0010\u001aR\u001a\u0010,\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0018\"\u0004\b.\u0010\u001aR\u001a\u0010/\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0018\"\u0004\b1\u0010\u001aR\u001c\u00102\u001a\u0004\u0018\u000103X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u00108\u001a\u000209X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001c\u0010>\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010$\"\u0004\b@\u0010&R\u001a\u0010A\u001a\u00020BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u000e\u0010G\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010H\u001a\u00020\u0012X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\u0014R\u0014\u0010J\u001a\u00020\u0012X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bK\u0010\u0014R\u001a\u0010L\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0014\"\u0004\bN\u0010 R\u001a\u0010O\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0018\"\u0004\bQ\u0010\u001a¨\u0006{"}, d2 = {"Landroidx/constraintlayout/compose/MotionRenderDebug;", "", "textSize", "", "(F)V", "mBounds", "Landroid/graphics/Rect;", "getMBounds", "()Landroid/graphics/Rect;", "setMBounds", "(Landroid/graphics/Rect;)V", "mDashPathEffect", "Landroid/graphics/DashPathEffect;", "getMDashPathEffect", "()Landroid/graphics/DashPathEffect;", "setMDashPathEffect", "(Landroid/graphics/DashPathEffect;)V", "mDiamondSize", "", "getMDiamondSize", "()I", "mFillPaint", "Landroid/graphics/Paint;", "getMFillPaint", "()Landroid/graphics/Paint;", "setMFillPaint", "(Landroid/graphics/Paint;)V", "mGraphColor", "getMGraphColor", "mKeyFrameCount", "getMKeyFrameCount", "setMKeyFrameCount", "(I)V", "mKeyFramePoints", "", "getMKeyFramePoints", "()[F", "setMKeyFramePoints", "([F)V", "mKeyframeColor", "getMKeyframeColor", "mPaint", "getMPaint", "setMPaint", "mPaintGraph", "getMPaintGraph", "setMPaintGraph", "mPaintKeyframes", "getMPaintKeyframes", "setMPaintKeyframes", "mPath", "Landroid/graphics/Path;", "getMPath", "()Landroid/graphics/Path;", "setMPath", "(Landroid/graphics/Path;)V", "mPathMode", "", "getMPathMode", "()[I", "setMPathMode", "([I)V", "mPoints", "getMPoints", "setMPoints", "mPresentationMode", "", "getMPresentationMode", "()Z", "setMPresentationMode", "(Z)V", "mRectangle", "mRedColor", "getMRedColor", "mShadowColor", "getMShadowColor", "mShadowTranslate", "getMShadowTranslate", "setMShadowTranslate", "mTextPaint", "getMTextPaint", "setMTextPaint", "basicDraw", "", "canvas", "Landroid/graphics/Canvas;", "motionController", "Landroidx/constraintlayout/core/motion/Motion;", "duration", "layoutWidth", "layoutHeight", "drawPath", "drawTicks", "draw", "debugPath", "frameArrayList", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "drawAll", DiagnosisParams.DIAGNOSIS_MODE, "keyFrames", "drawBasicPath", "drawPathAsConfigured", "drawPathCartesian", "drawPathCartesianTicks", "x", "y", "drawPathRelative", "drawPathRelativeTicks", "drawPathScreenTicks", "viewWidth", "viewHeight", "drawRectangle", "drawTranslation", "x1", "y1", "x2", "y2", "getTextBounds", "text", "paint", "Companion", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MotionRenderDebug {
    private static final int DEBUG_PATH_TICKS_PER_MS = 16;
    public static final int DEBUG_SHOW_NONE = 0;
    public static final int DEBUG_SHOW_PATH = 2;
    public static final int DEBUG_SHOW_PROGRESS = 1;
    public static final int MAX_KEY_FRAMES = 50;
    private DashPathEffect mDashPathEffect;
    private Paint mFillPaint;
    private int mKeyFrameCount;
    private float[] mKeyFramePoints;
    private Paint mPaint;
    private Paint mPaintGraph;
    private Paint mPaintKeyframes;
    private Path mPath;
    private int[] mPathMode;
    private float[] mPoints;
    private boolean mPresentationMode;
    private final float[] mRectangle;
    private int mShadowTranslate;
    private Paint mTextPaint;
    public static final int $stable = 8;
    private final int mRedColor = -21965;
    private final int mKeyframeColor = -2067046;
    private final int mGraphColor = -13391360;
    private final int mShadowColor = 1996488704;
    private final int mDiamondSize = 10;
    private Rect mBounds = new Rect();

    public MotionRenderDebug(float f) {
        this.mShadowTranslate = 1;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setColor(-21965);
        this.mPaint.setStrokeWidth(2.0f);
        this.mPaint.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.mPaintKeyframes = paint2;
        paint2.setAntiAlias(true);
        this.mPaintKeyframes.setColor(-2067046);
        this.mPaintKeyframes.setStrokeWidth(2.0f);
        this.mPaintKeyframes.setStyle(Paint.Style.STROKE);
        Paint paint3 = new Paint();
        this.mPaintGraph = paint3;
        paint3.setAntiAlias(true);
        this.mPaintGraph.setColor(-13391360);
        this.mPaintGraph.setStrokeWidth(2.0f);
        this.mPaintGraph.setStyle(Paint.Style.STROKE);
        Paint paint4 = new Paint();
        this.mTextPaint = paint4;
        paint4.setAntiAlias(true);
        this.mTextPaint.setColor(-13391360);
        this.mTextPaint.setTextSize(f);
        this.mRectangle = new float[8];
        Paint paint5 = new Paint();
        this.mFillPaint = paint5;
        paint5.setAntiAlias(true);
        DashPathEffect dashPathEffect = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
        this.mDashPathEffect = dashPathEffect;
        this.mPaintGraph.setPathEffect(dashPathEffect);
        this.mKeyFramePoints = new float[100];
        this.mPathMode = new int[50];
        if (this.mPresentationMode) {
            this.mPaint.setStrokeWidth(8.0f);
            this.mFillPaint.setStrokeWidth(8.0f);
            this.mPaintKeyframes.setStrokeWidth(8.0f);
            this.mShadowTranslate = 4;
        }
    }

    public final float[] getMPoints() {
        return this.mPoints;
    }

    public final void setMPoints(float[] fArr) {
        this.mPoints = fArr;
    }

    public final int[] getMPathMode() {
        return this.mPathMode;
    }

    public final void setMPathMode(int[] iArr) {
        this.mPathMode = iArr;
    }

    public final float[] getMKeyFramePoints() {
        return this.mKeyFramePoints;
    }

    public final void setMKeyFramePoints(float[] fArr) {
        this.mKeyFramePoints = fArr;
    }

    public final Path getMPath() {
        return this.mPath;
    }

    public final void setMPath(Path path) {
        this.mPath = path;
    }

    public final Paint getMPaint() {
        return this.mPaint;
    }

    public final void setMPaint(Paint paint) {
        this.mPaint = paint;
    }

    public final Paint getMPaintKeyframes() {
        return this.mPaintKeyframes;
    }

    public final void setMPaintKeyframes(Paint paint) {
        this.mPaintKeyframes = paint;
    }

    public final Paint getMPaintGraph() {
        return this.mPaintGraph;
    }

    public final void setMPaintGraph(Paint paint) {
        this.mPaintGraph = paint;
    }

    public final Paint getMTextPaint() {
        return this.mTextPaint;
    }

    public final void setMTextPaint(Paint paint) {
        this.mTextPaint = paint;
    }

    public final Paint getMFillPaint() {
        return this.mFillPaint;
    }

    public final void setMFillPaint(Paint paint) {
        this.mFillPaint = paint;
    }

    public final int getMRedColor() {
        return this.mRedColor;
    }

    public final int getMKeyframeColor() {
        return this.mKeyframeColor;
    }

    public final int getMGraphColor() {
        return this.mGraphColor;
    }

    public final int getMShadowColor() {
        return this.mShadowColor;
    }

    public final int getMDiamondSize() {
        return this.mDiamondSize;
    }

    public final DashPathEffect getMDashPathEffect() {
        return this.mDashPathEffect;
    }

    public final void setMDashPathEffect(DashPathEffect dashPathEffect) {
        this.mDashPathEffect = dashPathEffect;
    }

    public final int getMKeyFrameCount() {
        return this.mKeyFrameCount;
    }

    public final void setMKeyFrameCount(int i) {
        this.mKeyFrameCount = i;
    }

    public final Rect getMBounds() {
        return this.mBounds;
    }

    public final void setMBounds(Rect rect) {
        this.mBounds = rect;
    }

    public final boolean getMPresentationMode() {
        return this.mPresentationMode;
    }

    public final void setMPresentationMode(boolean z) {
        this.mPresentationMode = z;
    }

    public final int getMShadowTranslate() {
        return this.mShadowTranslate;
    }

    public final void setMShadowTranslate(int i) {
        this.mShadowTranslate = i;
    }

    public final void draw(Canvas canvas, HashMap<String, Motion> frameArrayList, int duration, int debugPath, int layoutWidth, int layoutHeight) {
        if (frameArrayList == null || frameArrayList.size() == 0) {
            return;
        }
        canvas.save();
        Iterator<Motion> it = frameArrayList.values().iterator();
        while (it.hasNext()) {
            draw(canvas, it.next(), duration, debugPath, layoutWidth, layoutHeight);
        }
        canvas.restore();
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0029  */
    public final void draw(Canvas canvas, Motion motionController, int duration, int debugPath, int layoutWidth, int layoutHeight) {
        int drawPath = motionController.getDrawPath();
        if (debugPath > 0 && drawPath == 0) {
            drawPath = 1;
        }
        if (drawPath == 0) {
            return;
        }
        this.mKeyFrameCount = motionController.buildKeyFrames(this.mKeyFramePoints, this.mPathMode, null);
        if (drawPath >= 1) {
            int i = duration / 16;
            float[] fArr = this.mPoints;
            if (fArr != null) {
                Intrinsics.checkNotNull(fArr);
                if (fArr.length != i * 2) {
                    this.mPoints = new float[i * 2];
                    this.mPath = new Path();
                }
            } else {
                this.mPoints = new float[i * 2];
                this.mPath = new Path();
            }
            int i2 = this.mShadowTranslate;
            canvas.translate(i2, i2);
            this.mPaint.setColor(this.mShadowColor);
            this.mFillPaint.setColor(this.mShadowColor);
            this.mPaintKeyframes.setColor(this.mShadowColor);
            this.mPaintGraph.setColor(this.mShadowColor);
            motionController.buildPath(this.mPoints, i);
            int i3 = drawPath;
            drawAll(canvas, i3, this.mKeyFrameCount, motionController, layoutWidth, layoutHeight);
            this.mPaint.setColor(this.mRedColor);
            this.mPaintKeyframes.setColor(this.mKeyframeColor);
            this.mFillPaint.setColor(this.mKeyframeColor);
            this.mPaintGraph.setColor(this.mGraphColor);
            int i4 = this.mShadowTranslate;
            canvas.translate(-i4, -i4);
            drawAll(canvas, i3, this.mKeyFrameCount, motionController, layoutWidth, layoutHeight);
            if (i3 == 5) {
                drawRectangle(canvas, motionController);
            }
        }
    }

    public final void drawAll(Canvas canvas, int mode, int keyFrames, Motion motionController, int layoutWidth, int layoutHeight) {
        if (mode == 4) {
            drawPathAsConfigured(canvas);
        }
        if (mode == 2) {
            drawPathRelative(canvas);
        }
        if (mode == 3) {
            drawPathCartesian(canvas);
        }
        drawBasicPath(canvas);
        drawTicks(canvas, mode, keyFrames, motionController, layoutWidth, layoutHeight);
    }

    /* JADX WARN: Code duplicated, block: B:6:0x0019  */
    public final void basicDraw(Canvas canvas, Motion motionController, int duration, int layoutWidth, int layoutHeight, boolean drawPath, boolean drawTicks) {
        MotionRenderDebug motionRenderDebug;
        Canvas canvas2;
        Motion motion;
        int i;
        int i2;
        this.mKeyFrameCount = motionController.buildKeyFrames(this.mKeyFramePoints, this.mPathMode, null);
        int i3 = duration / 16;
        float[] fArr = this.mPoints;
        if (fArr != null) {
            Intrinsics.checkNotNull(fArr);
            if (fArr.length != i3 * 2) {
                this.mPoints = new float[i3 * 2];
                this.mPath = new Path();
            }
        } else {
            this.mPoints = new float[i3 * 2];
            this.mPath = new Path();
        }
        int i4 = this.mShadowTranslate;
        canvas.translate(i4, i4);
        this.mPaint.setColor(this.mShadowColor);
        this.mFillPaint.setColor(this.mShadowColor);
        this.mPaintKeyframes.setColor(this.mShadowColor);
        this.mPaintGraph.setColor(this.mShadowColor);
        motionController.buildPath(this.mPoints, i3);
        if (drawPath) {
            drawBasicPath(canvas);
        }
        if (drawTicks) {
            motionRenderDebug = this;
            canvas2 = canvas;
            motion = motionController;
            i = layoutWidth;
            i2 = layoutHeight;
            motionRenderDebug.drawTicks(canvas2, 1, this.mKeyFrameCount, motion, i, i2);
        } else {
            motionRenderDebug = this;
            canvas2 = canvas;
            motion = motionController;
            i = layoutWidth;
            i2 = layoutHeight;
        }
        motionRenderDebug.mPaint.setColor(motionRenderDebug.mRedColor);
        motionRenderDebug.mPaintKeyframes.setColor(motionRenderDebug.mKeyframeColor);
        motionRenderDebug.mFillPaint.setColor(motionRenderDebug.mKeyframeColor);
        motionRenderDebug.mPaintGraph.setColor(motionRenderDebug.mGraphColor);
        int i5 = motionRenderDebug.mShadowTranslate;
        canvas2.translate(-i5, -i5);
        if (drawPath) {
            motionRenderDebug.drawBasicPath(canvas2);
        }
        if (drawTicks) {
            motionRenderDebug.drawTicks(canvas2, 1, motionRenderDebug.mKeyFrameCount, motion, i, i2);
        }
    }

    private final void drawBasicPath(Canvas canvas) {
        float[] fArr = this.mPoints;
        Intrinsics.checkNotNull(fArr);
        canvas.drawLines(fArr, this.mPaint);
    }

    private final void drawTicks(Canvas canvas, int mode, int keyFrames, Motion motionController, int layoutWidth, int layoutHeight) {
        int width;
        int height;
        if (motionController.getView() != null) {
            width = motionController.getView().getWidth();
            height = motionController.getView().getHeight();
        } else {
            width = 0;
            height = 0;
        }
        int i = keyFrames - 1;
        for (int i2 = 1; i2 < i; i2++) {
            if (mode != 4 || this.mPathMode[i2 - 1] != 0) {
                float[] fArr = this.mKeyFramePoints;
                int i3 = i2 * 2;
                float f = fArr[i3];
                float f2 = fArr[i3 + 1];
                Path path = this.mPath;
                Intrinsics.checkNotNull(path);
                path.reset();
                Path path2 = this.mPath;
                Intrinsics.checkNotNull(path2);
                path2.moveTo(f, this.mDiamondSize + f2);
                Path path3 = this.mPath;
                Intrinsics.checkNotNull(path3);
                path3.lineTo(this.mDiamondSize + f, f2);
                Path path4 = this.mPath;
                Intrinsics.checkNotNull(path4);
                path4.lineTo(f, f2 - this.mDiamondSize);
                Path path5 = this.mPath;
                Intrinsics.checkNotNull(path5);
                path5.lineTo(f - this.mDiamondSize, f2);
                Path path6 = this.mPath;
                Intrinsics.checkNotNull(path6);
                path6.close();
                if (mode == 4) {
                    int i4 = this.mPathMode[i2 - 1];
                    if (i4 == 1) {
                        drawPathRelativeTicks(canvas, f - 0.0f, f2 - 0.0f);
                    } else if (i4 == 0) {
                        drawPathCartesianTicks(canvas, f - 0.0f, f2 - 0.0f);
                    } else if (i4 == 2) {
                        drawPathScreenTicks(canvas, f - 0.0f, f2 - 0.0f, width, height, layoutWidth, layoutHeight);
                    }
                    Path path7 = this.mPath;
                    Intrinsics.checkNotNull(path7);
                    canvas.drawPath(path7, this.mFillPaint);
                }
                if (mode == 2) {
                    drawPathRelativeTicks(canvas, f - 0.0f, f2 - 0.0f);
                }
                if (mode == 3) {
                    drawPathCartesianTicks(canvas, f - 0.0f, f2 - 0.0f);
                }
                if (mode == 6) {
                    drawPathScreenTicks(canvas, f - 0.0f, f2 - 0.0f, width, height, layoutWidth, layoutHeight);
                }
                Path path8 = this.mPath;
                Intrinsics.checkNotNull(path8);
                canvas.drawPath(path8, this.mFillPaint);
            }
        }
        float[] fArr2 = this.mPoints;
        Intrinsics.checkNotNull(fArr2);
        if (fArr2.length > 1) {
            float[] fArr3 = this.mPoints;
            Intrinsics.checkNotNull(fArr3);
            float f3 = fArr3[0];
            float[] fArr4 = this.mPoints;
            Intrinsics.checkNotNull(fArr4);
            canvas.drawCircle(f3, fArr4[1], 8.0f, this.mPaintKeyframes);
            float[] fArr5 = this.mPoints;
            Intrinsics.checkNotNull(fArr5);
            float[] fArr6 = this.mPoints;
            Intrinsics.checkNotNull(fArr6);
            float f4 = fArr5[fArr6.length - 2];
            float[] fArr7 = this.mPoints;
            Intrinsics.checkNotNull(fArr7);
            float[] fArr8 = this.mPoints;
            Intrinsics.checkNotNull(fArr8);
            canvas.drawCircle(f4, fArr7[fArr8.length - 1], 8.0f, this.mPaintKeyframes);
        }
    }

    private final void drawTranslation(Canvas canvas, float x1, float y1, float x2, float y2) {
        canvas.drawRect(x1, y1, x2, y2, this.mPaintGraph);
        canvas.drawLine(x1, y1, x2, y2, this.mPaintGraph);
    }

    private final void drawPathRelative(Canvas canvas) {
        float[] fArr = this.mPoints;
        Intrinsics.checkNotNull(fArr);
        float f = fArr[0];
        float[] fArr2 = this.mPoints;
        Intrinsics.checkNotNull(fArr2);
        float f2 = fArr2[1];
        float[] fArr3 = this.mPoints;
        Intrinsics.checkNotNull(fArr3);
        float[] fArr4 = this.mPoints;
        Intrinsics.checkNotNull(fArr4);
        float f3 = fArr3[fArr4.length - 2];
        float[] fArr5 = this.mPoints;
        Intrinsics.checkNotNull(fArr5);
        float[] fArr6 = this.mPoints;
        Intrinsics.checkNotNull(fArr6);
        canvas.drawLine(f, f2, f3, fArr5[fArr6.length - 1], this.mPaintGraph);
    }

    private final void drawPathAsConfigured(Canvas canvas) {
        int i = this.mKeyFrameCount;
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.mPathMode[i2];
            if (i3 == 1) {
                z = true;
            }
            if (i3 == 0) {
                z2 = true;
            }
        }
        if (z) {
            drawPathRelative(canvas);
        }
        if (z2) {
            drawPathCartesian(canvas);
        }
    }

    private final void drawPathRelativeTicks(Canvas canvas, float x, float y) {
        float[] fArr = this.mPoints;
        Intrinsics.checkNotNull(fArr);
        float f = fArr[0];
        float[] fArr2 = this.mPoints;
        Intrinsics.checkNotNull(fArr2);
        float f2 = fArr2[1];
        float[] fArr3 = this.mPoints;
        Intrinsics.checkNotNull(fArr3);
        float[] fArr4 = this.mPoints;
        Intrinsics.checkNotNull(fArr4);
        float f3 = fArr3[fArr4.length - 2];
        float[] fArr5 = this.mPoints;
        Intrinsics.checkNotNull(fArr5);
        float[] fArr6 = this.mPoints;
        Intrinsics.checkNotNull(fArr6);
        float f4 = fArr5[fArr6.length - 1];
        float fHypot = (float) Math.hypot(f - f3, f2 - f4);
        float f5 = f3 - f;
        float f6 = f4 - f2;
        float f7 = (((x - f) * f5) + ((y - f2) * f6)) / (fHypot * fHypot);
        float f8 = f + (f5 * f7);
        float f9 = f2 + (f7 * f6);
        Path path = new Path();
        path.moveTo(x, y);
        path.lineTo(f8, f9);
        float fHypot2 = (float) Math.hypot(f8 - x, f9 - y);
        String str = "" + (((int) ((100 * fHypot2) / fHypot)) / 100.0f);
        getTextBounds(str, this.mTextPaint);
        canvas.drawTextOnPath(str, path, (fHypot2 / 2) - (this.mBounds.width() / 2), -20.0f, this.mTextPaint);
        canvas.drawLine(x, y, f8, f9, this.mPaintGraph);
    }

    public final void getTextBounds(String text, Paint paint) {
        paint.getTextBounds(text, 0, text.length(), this.mBounds);
    }

    private final void drawPathCartesian(Canvas canvas) {
        float[] fArr = this.mPoints;
        Intrinsics.checkNotNull(fArr);
        float f = fArr[0];
        float[] fArr2 = this.mPoints;
        Intrinsics.checkNotNull(fArr2);
        float f2 = fArr2[1];
        float[] fArr3 = this.mPoints;
        Intrinsics.checkNotNull(fArr3);
        float[] fArr4 = this.mPoints;
        Intrinsics.checkNotNull(fArr4);
        float f3 = fArr3[fArr4.length - 2];
        float[] fArr5 = this.mPoints;
        Intrinsics.checkNotNull(fArr5);
        float[] fArr6 = this.mPoints;
        Intrinsics.checkNotNull(fArr6);
        float f4 = fArr5[fArr6.length - 1];
        canvas.drawLine(Math.min(f, f3), Math.max(f2, f4), Math.max(f, f3), Math.max(f2, f4), this.mPaintGraph);
        canvas.drawLine(Math.min(f, f3), Math.min(f2, f4), Math.min(f, f3), Math.max(f2, f4), this.mPaintGraph);
    }

    private final void drawPathCartesianTicks(Canvas canvas, float x, float y) {
        float[] fArr = this.mPoints;
        Intrinsics.checkNotNull(fArr);
        float f = fArr[0];
        float[] fArr2 = this.mPoints;
        Intrinsics.checkNotNull(fArr2);
        float f2 = fArr2[1];
        float[] fArr3 = this.mPoints;
        Intrinsics.checkNotNull(fArr3);
        float[] fArr4 = this.mPoints;
        Intrinsics.checkNotNull(fArr4);
        float f3 = fArr3[fArr4.length - 2];
        float[] fArr5 = this.mPoints;
        Intrinsics.checkNotNull(fArr5);
        float[] fArr6 = this.mPoints;
        Intrinsics.checkNotNull(fArr6);
        float f4 = fArr5[fArr6.length - 1];
        float fMin = Math.min(f, f3);
        float fMax = Math.max(f2, f4);
        float fMin2 = x - Math.min(f, f3);
        float fMax2 = Math.max(f2, f4) - y;
        float f5 = 100;
        String str = "" + (((int) (((double) ((f5 * fMin2) / Math.abs(f3 - f))) + 0.5d)) / 100.0f);
        getTextBounds(str, this.mTextPaint);
        float f6 = 2;
        canvas.drawText(str, ((fMin2 / f6) - (this.mBounds.width() / 2)) + fMin, y - 20, this.mTextPaint);
        canvas.drawLine(x, y, Math.min(f, f3), y, this.mPaintGraph);
        String str2 = "" + (((int) (((double) ((f5 * fMax2) / Math.abs(f4 - f2))) + 0.5d)) / 100.0f);
        getTextBounds(str2, this.mTextPaint);
        canvas.drawText(str2, x + 5, fMax - ((fMax2 / f6) - (this.mBounds.height() / 2)), this.mTextPaint);
        canvas.drawLine(x, y, x, Math.max(f2, f4), this.mPaintGraph);
    }

    private final void drawPathScreenTicks(Canvas canvas, float x, float y, int viewWidth, int viewHeight, int layoutWidth, int layoutHeight) {
        float f = 100;
        String str = "" + (((int) (((double) (((x - (viewWidth / 2)) * f) / (layoutWidth - viewWidth))) + 0.5d)) / 100.0f);
        getTextBounds(str, this.mTextPaint);
        float f2 = 2;
        canvas.drawText(str, ((x / f2) - (this.mBounds.width() / 2)) + 0.0f, y - 20, this.mTextPaint);
        canvas.drawLine(x, y, Math.min(0.0f, 1.0f), y, this.mPaintGraph);
        String str2 = "" + (((int) (((double) ((f * (y - (viewHeight / 2))) / (layoutHeight - viewHeight))) + 0.5d)) / 100.0f);
        getTextBounds(str2, this.mTextPaint);
        canvas.drawText(str2, x + 5, 0.0f - ((y / f2) - (this.mBounds.height() / 2)), this.mTextPaint);
        canvas.drawLine(x, y, x, Math.max(0.0f, 1.0f), this.mPaintGraph);
    }

    private final void drawRectangle(Canvas canvas, Motion motionController) {
        Path path = this.mPath;
        Intrinsics.checkNotNull(path);
        path.reset();
        int i = 0;
        while (true) {
            motionController.buildRect(i / 50, this.mRectangle, 0);
            Path path2 = this.mPath;
            Intrinsics.checkNotNull(path2);
            float[] fArr = this.mRectangle;
            path2.moveTo(fArr[0], fArr[1]);
            Path path3 = this.mPath;
            Intrinsics.checkNotNull(path3);
            float[] fArr2 = this.mRectangle;
            path3.lineTo(fArr2[2], fArr2[3]);
            Path path4 = this.mPath;
            Intrinsics.checkNotNull(path4);
            float[] fArr3 = this.mRectangle;
            path4.lineTo(fArr3[4], fArr3[5]);
            Path path5 = this.mPath;
            Intrinsics.checkNotNull(path5);
            float[] fArr4 = this.mRectangle;
            path5.lineTo(fArr4[6], fArr4[7]);
            Path path6 = this.mPath;
            Intrinsics.checkNotNull(path6);
            path6.close();
            if (i == 50) {
                this.mPaint.setColor(1140850688);
                canvas.translate(2.0f, 2.0f);
                Path path7 = this.mPath;
                Intrinsics.checkNotNull(path7);
                canvas.drawPath(path7, this.mPaint);
                canvas.translate(-2.0f, -2.0f);
                this.mPaint.setColor(SupportMenu.CATEGORY_MASK);
                Path path8 = this.mPath;
                Intrinsics.checkNotNull(path8);
                canvas.drawPath(path8, this.mPaint);
                return;
            }
            i++;
        }
    }
}
