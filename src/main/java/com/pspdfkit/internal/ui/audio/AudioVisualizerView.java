package com.pspdfkit.internal.ui.audio;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/pspdfkit/internal/ui/audio/AudioVisualizerView;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "waveformColor", "", "setWaveformColor", "(I)V", "Ljava/nio/ByteBuffer;", "samples", "setSamples", "(Ljava/nio/ByteBuffer;)V", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AudioVisualizerView extends View {
    public final Paint a;
    public final Path b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AudioVisualizerView(Context context) {
        this(context, null, 0, 6, null);
        context.getClass();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        canvas.getClass();
        super.onDraw(canvas);
        if (!this.b.isEmpty()) {
            canvas.drawPath(this.b, this.a);
        } else {
            float height = getHeight() / 2.0f;
            canvas.drawLine(0.0f, height, getWidth(), height, this.a);
        }
    }

    public final void setSamples(ByteBuffer samples) {
        this.b.reset();
        if (samples != null && getWidth() != 0) {
            ShortBuffer shortBufferAsShortBuffer = samples.asShortBuffer();
            int iLimit = shortBufferAsShortBuffer.limit();
            int width = getWidth();
            float height = getHeight() / 2.0f;
            for (int i = 0; i < width; i++) {
                float f = i;
                float f2 = height - ((shortBufferAsShortBuffer.get((int) ((f / width) * iLimit)) / 32767.0f) * height);
                Path path = this.b;
                if (i == 0) {
                    path.moveTo(f, f2);
                } else {
                    path.lineTo(f, f2);
                }
            }
        }
        postInvalidate();
    }

    public final void setWaveformColor(int waveformColor) {
        this.a.setColor(waveformColor);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AudioVisualizerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        context.getClass();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioVisualizerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        context.getClass();
        Paint paint = new Paint();
        this.a = paint;
        this.b = new Path();
        paint.setColor(-16777216);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2.0f);
        paint.setAntiAlias(true);
    }

    public /* synthetic */ AudioVisualizerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
