package com.box.android.capture.audiorecording.wavevisualizer;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.box.android.base.views.WaveVisualizer;
import com.facebook.react.uimanager.ViewProps;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReviewVisualizer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0002\b\u0005\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010J(\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nH\u0002J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J(\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nH\u0002J\b\u0010\u001c\u001a\u00020\nH\u0016J\b\u0010\u001d\u001a\u00020\nH\u0016J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0017H\u0002J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\rH\u0002J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\rH\u0002J\b\u0010#\u001a\u00020\u0012H\u0002J\u001c\u0010$\u001a\u00020\u00122\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010\u000e\u001a\u00020\rJ\u001c\u0010(\u001a\u00020\u00122\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010)\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\rJ\u000e\u0010*\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\rR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/box/android/capture/audiorecording/wavevisualizer/ReviewVisualizer;", "Lcom/box/android/base/views/WaveVisualizer;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "tickDuration", "", "duration", "isScrubbing", "", "setScrubbing", "", "drawStraightBar", "canvas", "Landroid/graphics/Canvas;", "startX", "", "height", "baseLine", "onDraw", "drawCursor", "getStartBar", "getWaveStartPosition", "inRangePosition", ViewProps.POSITION, "calculateCursorPosition", "currentTime", "sync", "invalidateTickDuration", "initializeWaveForm", "ampsList", "", "", "setWaveForm", "forceUpdateTime", "updateTime", "Companion", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ReviewVisualizer extends WaveVisualizer {
    private static final float CURSOR_BAR_HEIGHT_FACTOR = 0.7f;
    private long duration;
    private boolean isScrubbing;
    private long tickDuration;
    public static final int $stable = 8;

    public ReviewVisualizer(Context context) {
        super(context);
        this.tickDuration = 30L;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReviewVisualizer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.tickDuration = 30L;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReviewVisualizer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.tickDuration = 30L;
    }

    public final void setScrubbing(boolean isScrubbing) {
        this.isScrubbing = isScrubbing;
    }

    private final void drawStraightBar(Canvas canvas, float startX, int height, int baseLine) {
        float f = baseLine + (height / 2);
        float f2 = height;
        float f3 = f - f2;
        if (startX <= getWaveStartPosition()) {
            canvas.drawLine(startX, f, startX, f3, getSilenceBarPrimeColor());
        } else if (f2 <= getHeight() * getSilenceBarHeightFraction()) {
            canvas.drawLine(startX, f, startX, f3, getSilenceBarPrimeColor());
        } else {
            canvas.drawLine(startX, f, startX, f3, getLoadedBarPrimeColor());
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int endBar = getEndBar();
        for (int startBar = getStartBar(); startBar < endBar; startBar++) {
            drawStraightBar(canvas, getWaveStartPosition() - ((getBarPosition() - startBar) * (getBarWidth() + getSpaceBetweenBar())), (int) getBarHeightAt(startBar), getBaseLine());
        }
        drawCursor(canvas, getWaveStartPosition(), getHeight(), getBaseLine());
        super.onDraw(canvas);
    }

    private final void drawCursor(Canvas canvas, float startX, int height, int baseLine) {
        float f = height * 0.7f;
        float f2 = baseLine + (f / 2);
        canvas.drawLine(startX, f2, startX, f2 - f, getCursorBarColor());
    }

    @Override // com.box.android.base.views.WaveVisualizer
    public int getStartBar() {
        return Math.max(0, ((int) getBarPosition()) - (getMaxVisibleBars() / 2));
    }

    @Override // com.box.android.base.views.WaveVisualizer
    public int getWaveStartPosition() {
        return getWidth() / 2;
    }

    private final float inRangePosition(float position) {
        return Math.min(getAmps().size(), Math.max(0.0f, position));
    }

    private final float calculateCursorPosition(long currentTime) {
        return inRangePosition((currentTime - sync(currentTime)) / this.tickDuration);
    }

    private final float sync(long currentTime) {
        long j = this.duration;
        return (currentTime / j) * (j - (this.tickDuration * ((long) getAmps().size())));
    }

    private final void invalidateTickDuration() {
        if (this.duration <= 0 || getAmps().size() <= 0) {
            return;
        }
        this.tickDuration = this.duration / ((long) getAmps().size());
    }

    public final void initializeWaveForm(List<Double> ampsList, long duration) {
        Intrinsics.checkNotNullParameter(ampsList, "ampsList");
        if (getAmps().size() > 0) {
            return;
        }
        getAmps().clear();
        getAmps().addAll(ampsList);
        this.duration = duration;
        invalidateTickDuration();
        setCursorPosition(0.0f);
        invalidate();
    }

    public final void setWaveForm(List<Double> ampsList, long duration) {
        Intrinsics.checkNotNullParameter(ampsList, "ampsList");
        getAmps().clear();
        getAmps().addAll(ampsList);
        this.duration = duration;
        invalidateTickDuration();
        setCursorPosition(0.0f);
        invalidate();
    }

    public final void forceUpdateTime(long currentTime) {
        setCursorPosition(calculateCursorPosition(currentTime));
        invalidate();
    }

    public final void updateTime(long currentTime) {
        if (this.isScrubbing) {
            return;
        }
        setCursorPosition(calculateCursorPosition(currentTime));
        invalidate();
    }
}
