package androidx.media3.effect;

import android.content.Context;
import androidx.media3.common.VideoFrameProcessingException;
import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: classes8.dex */
public final class AlphaScale implements GlEffect {
    private final float alphaScale;

    public AlphaScale(float f) {
        Preconditions.checkArgument(0.0f <= f);
        this.alphaScale = f;
    }

    @Override // androidx.media3.effect.GlEffect
    public AlphaScaleShaderProgram toGlShaderProgram(Context context, boolean z) throws VideoFrameProcessingException {
        return new AlphaScaleShaderProgram(context, z, this.alphaScale);
    }

    @Override // androidx.media3.effect.GlEffect
    public boolean isNoOp(int i, int i2) {
        return this.alphaScale == 1.0f;
    }
}
