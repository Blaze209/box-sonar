package com.box.android.capture.audiorecording.wavevisualizer;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.box.android.base.views.WaveVisualizer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecordingVisualizer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\u0002J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0015\u001a\u00020\nH\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016J\u0014\u0010\u0017\u001a\u00020\r2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019¨\u0006\u001b"}, d2 = {"Lcom/box/android/capture/audiorecording/wavevisualizer/RecordingVisualizer;", "Lcom/box/android/base/views/WaveVisualizer;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "drawStraightBar", "", "canvas", "Landroid/graphics/Canvas;", "startX", "", "height", "baseLine", "onDraw", "getStartBar", "getWaveStartPosition", "updateAmps", "ampsList", "", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RecordingVisualizer extends WaveVisualizer {
    public static final int $stable = WaveVisualizer.$stable;

    public RecordingVisualizer(Context context) {
        super(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecordingVisualizer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecordingVisualizer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void drawStraightBar(Canvas canvas, float startX, int height, int baseLine) {
        float f = baseLine + (height / 2);
        float f2 = height;
        float f3 = f - f2;
        if (f2 <= getHeight() * getSilenceBarHeightFraction()) {
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
        super.onDraw(canvas);
    }

    @Override // com.box.android.base.views.WaveVisualizer
    public int getStartBar() {
        return Math.max(0, ((int) getBarPosition()) - getMaxVisibleBars());
    }

    @Override // com.box.android.base.views.WaveVisualizer
    public int getWaveStartPosition() {
        return getWidth();
    }

    public final void updateAmps(List<Double> ampsList) {
        Intrinsics.checkNotNullParameter(ampsList, "ampsList");
        getAmps().clear();
        getAmps().addAll(ampsList);
        setCursorPosition((getAmps().size() - 1) + (getTickPerBar() / getTickPerBar()));
        invalidate();
    }
}
