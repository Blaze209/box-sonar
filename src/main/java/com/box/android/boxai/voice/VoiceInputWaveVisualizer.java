package com.box.android.boxai.voice;

import android.content.Context;
import android.graphics.Canvas;
import com.box.android.base.views.WaveVisualizer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VoiceInputWaveVisualizer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J0\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0014J\b\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016J.\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\rJ\u0014\u0010\u001a\u001a\u00020\u00072\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cJ\u000e\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u000b¨\u0006 "}, d2 = {"Lcom/box/android/boxai/voice/VoiceInputWaveVisualizer;", "Lcom/box/android/base/views/WaveVisualizer;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "drawStraightBar", "", "canvas", "Landroid/graphics/Canvas;", "startX", "", "height", "", "baseLine", "isRecorded", "", "onDraw", "getStartBar", "getWaveStartPosition", "setStyle", "barWidthPx", "spaceBetweenBarPx", "silenceBarHeightFraction", "loadedBarColor", "silenceBarColor", "updateAmps", "ampsList", "", "", "updateCursorPosition", "cursorPosition", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class VoiceInputWaveVisualizer extends WaveVisualizer {
    public static final int $stable = WaveVisualizer.$stable;

    public VoiceInputWaveVisualizer(Context context) {
        super(context);
    }

    private final void drawStraightBar(Canvas canvas, float startX, int height, int baseLine, boolean isRecorded) {
        float f = baseLine + (height / 2);
        canvas.drawLine(startX, f, startX, f - height, isRecorded ? getLoadedBarPrimeColor() : getSilenceBarPrimeColor());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) throws Throwable {
        Canvas canvas2;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int width = getWidth();
        int height = getHeight();
        int iSave = canvas.save();
        canvas.clipRect(0, 0, width, height);
        try {
            int startBar = getStartBar();
            int endBar = getEndBar();
            while (startBar < endBar) {
                VoiceInputWaveVisualizer voiceInputWaveVisualizer = this;
                canvas2 = canvas;
                try {
                    voiceInputWaveVisualizer.drawStraightBar(canvas2, this.getWaveStartPosition() - ((this.getBarPosition() - startBar) * (this.getBarWidth() + this.getSpaceBetweenBar())), (int) this.getBarHeightAt(startBar), this.getBaseLine(), startBar > 0);
                    startBar++;
                    this = voiceInputWaveVisualizer;
                    canvas = canvas2;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    canvas2.restoreToCount(iSave);
                    throw th2;
                }
            }
            Canvas canvas3 = canvas;
            canvas3.restoreToCount(iSave);
            super.onDraw(canvas3);
        } catch (Throwable th3) {
            th = th3;
            canvas2 = canvas;
        }
    }

    @Override // com.box.android.base.views.WaveVisualizer
    public int getStartBar() {
        return ((int) getBarPosition()) - getMaxVisibleBars();
    }

    @Override // com.box.android.base.views.WaveVisualizer
    public int getWaveStartPosition() {
        return getWidth();
    }

    public final void setStyle(float barWidthPx, float spaceBetweenBarPx, float silenceBarHeightFraction, int loadedBarColor, int silenceBarColor) {
        setBarWidth(barWidthPx);
        setSpaceBetweenBar(spaceBetweenBarPx);
        setSilenceBarHeightFraction(silenceBarHeightFraction);
        getLoadedBarPrimeColor().setColor(loadedBarColor);
        getSilenceBarPrimeColor().setColor(silenceBarColor);
    }

    public final void updateAmps(List<Double> ampsList) {
        Intrinsics.checkNotNullParameter(ampsList, "ampsList");
        getAmps().clear();
        getAmps().addAll(ampsList);
        invalidate();
    }

    public final void updateCursorPosition(float cursorPosition) {
        setCursorPosition(cursorPosition);
        invalidate();
    }
}
