package androidx.media3.effect;

import android.content.Context;
import androidx.media3.common.VideoFrameProcessingException;

/* JADX INFO: loaded from: classes8.dex */
public final class FrameDropEffect implements GlEffect {
    private final float inputFrameRate;
    private final float targetFrameRate;

    public static FrameDropEffect createDefaultFrameDropEffect(float f) {
        return new FrameDropEffect(-3.4028235E38f, f);
    }

    public static FrameDropEffect createSimpleFrameDropEffect(float f, float f2) {
        return new FrameDropEffect(f, f2);
    }

    @Override // androidx.media3.effect.GlEffect
    public GlShaderProgram toGlShaderProgram(Context context, boolean z) throws VideoFrameProcessingException {
        if (this.inputFrameRate == -3.4028235E38f) {
            return new DefaultFrameDroppingShaderProgram(context, z, this.targetFrameRate);
        }
        return new SimpleFrameDroppingShaderProgram(this.inputFrameRate, this.targetFrameRate);
    }

    private FrameDropEffect(float f, float f2) {
        this.inputFrameRate = f;
        this.targetFrameRate = f2;
    }
}
