package com.box.android.base.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.android.base.R;
import com.box.android.observability.DiagnosisParams;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WaveVisualizer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0013\b'\u0018\u0000 J2\u00020\u0001:\u0001JB\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u00107\u001a\u000208H\u0002J\u001a\u00109\u001a\u0002082\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010:\u001a\u00020\nH&J\b\u0010;\u001a\u00020\nH&J\b\u0010<\u001a\u00020\nH\u0004J\b\u0010=\u001a\u00020\nH\u0004J\u0010\u0010>\u001a\u00020\u00142\u0006\u0010?\u001a\u00020\nH\u0004J\b\u0010@\u001a\u00020\u0014H\u0004J\u0018\u0010A\u001a\u0002082\u0006\u0010B\u001a\u00020\n2\u0006\u0010C\u001a\u00020\nH\u0014J(\u0010D\u001a\u0002082\u0006\u0010E\u001a\u00020\n2\u0006\u0010F\u001a\u00020\n2\u0006\u0010G\u001a\u00020\n2\u0006\u0010H\u001a\u00020\nH\u0014J\u0006\u0010I\u001a\u000208R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0014X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001a\u0010\u001c\u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0014@DX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u001a\u0010%\u001a\u00020\u0014X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010\u0018R\u001a\u0010(\u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001e\"\u0004\b*\u0010 R\u001a\u0010+\u001a\u00020,X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020,X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R\u001a\u00104\u001a\u00020,X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010.\"\u0004\b6\u00100¨\u0006K"}, d2 = {"Lcom/box/android/base/views/WaveVisualizer;", "Landroid/view/View;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "amps", "", "", "getAmps", "()Ljava/util/List;", "setAmps", "(Ljava/util/List;)V", "spaceBetweenBar", "", "getSpaceBetweenBar", "()F", "setSpaceBetweenBar", "(F)V", "cursorPosition", "getCursorPosition", "setCursorPosition", "tickPerBar", "getTickPerBar", "()I", "setTickPerBar", "(I)V", "value", "barWidth", "getBarWidth", "setBarWidth", "silenceBarHeightFraction", "getSilenceBarHeightFraction", "setSilenceBarHeightFraction", "maxVisibleBars", "getMaxVisibleBars", "setMaxVisibleBars", "loadedBarPrimeColor", "Landroid/graphics/Paint;", "getLoadedBarPrimeColor", "()Landroid/graphics/Paint;", "setLoadedBarPrimeColor", "(Landroid/graphics/Paint;)V", "silenceBarPrimeColor", "getSilenceBarPrimeColor", "setSilenceBarPrimeColor", "cursorBarColor", "getCursorBarColor", "setCursorBarColor", "init", "", "loadAttribute", "getStartBar", "getWaveStartPosition", "getBaseLine", "getEndBar", "getBarHeightAt", "i", "getBarPosition", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", CmcdData.STREAMING_FORMAT_HLS, "oldw", "oldh", DiagnosisParams.CLEAR_ON_LOGOUT, "Companion", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class WaveVisualizer extends View {
    public static final float MAX_HEIGHT = 0.95f;
    public static final long TICK_DURATION = 30;
    private List<Double> amps;
    private float barWidth;
    protected Paint cursorBarColor;
    private float cursorPosition;
    protected Paint loadedBarPrimeColor;
    private int maxVisibleBars;
    private float silenceBarHeightFraction;
    protected Paint silenceBarPrimeColor;
    private float spaceBetweenBar;
    private int tickPerBar;
    public static final int $stable = 8;

    public abstract int getStartBar();

    public abstract int getWaveStartPosition();

    public WaveVisualizer(Context context) {
        super(context);
        this.amps = new ArrayList();
        this.spaceBetweenBar = 2.0f;
        this.tickPerBar = 1;
        this.barWidth = 4.0f;
        this.silenceBarHeightFraction = 0.01f;
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WaveVisualizer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.amps = new ArrayList();
        this.spaceBetweenBar = 2.0f;
        this.tickPerBar = 1;
        this.barWidth = 4.0f;
        this.silenceBarHeightFraction = 0.01f;
        init();
        loadAttribute(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WaveVisualizer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.amps = new ArrayList();
        this.spaceBetweenBar = 2.0f;
        this.tickPerBar = 1;
        this.barWidth = 4.0f;
        this.silenceBarHeightFraction = 0.01f;
        init();
        loadAttribute(context, attributeSet);
    }

    protected final List<Double> getAmps() {
        return this.amps;
    }

    protected final void setAmps(List<Double> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.amps = list;
    }

    protected final float getSpaceBetweenBar() {
        return this.spaceBetweenBar;
    }

    protected final void setSpaceBetweenBar(float f) {
        this.spaceBetweenBar = f;
    }

    protected final float getCursorPosition() {
        return this.cursorPosition;
    }

    protected final void setCursorPosition(float f) {
        this.cursorPosition = f;
    }

    protected final int getTickPerBar() {
        return this.tickPerBar;
    }

    protected final void setTickPerBar(int i) {
        this.tickPerBar = i;
    }

    protected final float getBarWidth() {
        return this.barWidth;
    }

    protected final void setBarWidth(float f) {
        if (this.barWidth > 0.0f) {
            this.barWidth = f;
            getLoadedBarPrimeColor().setStrokeWidth(f);
            getSilenceBarPrimeColor().setStrokeWidth(f);
            getCursorBarColor().setStrokeWidth(f);
        }
    }

    protected final float getSilenceBarHeightFraction() {
        return this.silenceBarHeightFraction;
    }

    protected final void setSilenceBarHeightFraction(float f) {
        this.silenceBarHeightFraction = f;
    }

    protected final int getMaxVisibleBars() {
        return this.maxVisibleBars;
    }

    protected final void setMaxVisibleBars(int i) {
        this.maxVisibleBars = i;
    }

    protected final Paint getLoadedBarPrimeColor() {
        Paint paint = this.loadedBarPrimeColor;
        if (paint != null) {
            return paint;
        }
        Intrinsics.throwUninitializedPropertyAccessException("loadedBarPrimeColor");
        return null;
    }

    protected final void setLoadedBarPrimeColor(Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "<set-?>");
        this.loadedBarPrimeColor = paint;
    }

    protected final Paint getSilenceBarPrimeColor() {
        Paint paint = this.silenceBarPrimeColor;
        if (paint != null) {
            return paint;
        }
        Intrinsics.throwUninitializedPropertyAccessException("silenceBarPrimeColor");
        return null;
    }

    protected final void setSilenceBarPrimeColor(Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "<set-?>");
        this.silenceBarPrimeColor = paint;
    }

    protected final Paint getCursorBarColor() {
        Paint paint = this.cursorBarColor;
        if (paint != null) {
            return paint;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cursorBarColor");
        return null;
    }

    protected final void setCursorBarColor(Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "<set-?>");
        this.cursorBarColor = paint;
    }

    private final void init() {
        setSilenceBarPrimeColor(new Paint());
        getSilenceBarPrimeColor().setStrokeCap(Paint.Cap.ROUND);
        setLoadedBarPrimeColor(new Paint());
        getLoadedBarPrimeColor().setStrokeCap(Paint.Cap.ROUND);
        setCursorBarColor(new Paint());
        getCursorBarColor().setStrokeCap(Paint.Cap.ROUND);
    }

    private final void loadAttribute(Context context, AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.WaveVisualizer, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            setBarWidth(typedArrayObtainStyledAttributes.getDimension(R.styleable.WaveVisualizer_barWidth, 2.0f));
            this.spaceBetweenBar = typedArrayObtainStyledAttributes.getDimension(R.styleable.WaveVisualizer_spaceBetweenBar, 2.0f);
            Paint loadedBarPrimeColor = getLoadedBarPrimeColor();
            loadedBarPrimeColor.setStrokeWidth(this.barWidth);
            loadedBarPrimeColor.setColor(typedArrayObtainStyledAttributes.getColor(R.styleable.WaveVisualizer_loadedBarColor, context.getResources().getColor(R.color.box_blue_50, context.getTheme())));
            Paint silenceBarPrimeColor = getSilenceBarPrimeColor();
            silenceBarPrimeColor.setStrokeWidth(this.barWidth);
            silenceBarPrimeColor.setColor(typedArrayObtainStyledAttributes.getColor(R.styleable.WaveVisualizer_silenceBarColor, context.getResources().getColor(R.color.box_gray_80, context.getTheme())));
            Paint cursorBarColor = getCursorBarColor();
            cursorBarColor.setStrokeWidth(this.barWidth);
            cursorBarColor.setColor(typedArrayObtainStyledAttributes.getColor(R.styleable.WaveVisualizer_cursorBarColor, context.getResources().getColor(R.color.box_blue, context.getTheme())));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    protected final int getBaseLine() {
        return getHeight() / 2;
    }

    protected final int getEndBar() {
        return Math.min(this.amps.size(), getStartBar() + this.maxVisibleBars);
    }

    protected final float getBarHeightAt(int i) {
        float height = getHeight();
        float f = this.silenceBarHeightFraction;
        List<Double> list = this.amps;
        return height * Math.max(f, Math.min(((i < 0 || i >= list.size()) ? 0 : list.get(i)).floatValue(), 0.95f));
    }

    protected final float getBarPosition() {
        return this.cursorPosition / this.tickPerBar;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.maxVisibleBars = (int) (getWidth() / (this.barWidth + this.spaceBetweenBar));
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.maxVisibleBars = (int) (w / (this.barWidth + this.spaceBetweenBar));
    }

    public final void clear() {
        this.amps.clear();
        this.cursorPosition = 0.0f;
        invalidate();
    }
}
