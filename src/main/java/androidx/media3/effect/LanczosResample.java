package androidx.media3.effect;

import android.content.Context;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Size;
import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: classes8.dex */
public final class LanczosResample implements GlEffect {
    private static final float DEFAULT_RADIUS = 3.0f;
    private static final float NO_OP_THRESHOLD = 0.01f;
    private final boolean assumeLandscapeOrientation;
    private final int longSide;
    private final float radius;
    private final int shortSide;

    public static LanczosResample scaleToFit(int i, int i2) {
        Preconditions.checkArgument(i > 0);
        Preconditions.checkArgument(i2 > 0);
        return new LanczosResample(3.0f, i, i2, true);
    }

    public static LanczosResample scaleToFitWithFlexibleOrientation(int i, int i2) {
        Preconditions.checkArgument(i > 0);
        Preconditions.checkArgument(i2 > 0);
        if (i > i2) {
            return new LanczosResample(3.0f, i, i2, false);
        }
        return new LanczosResample(3.0f, i2, i, false);
    }

    private LanczosResample(float f, int i, int i2, boolean z) {
        this.radius = f;
        this.longSide = i;
        this.shortSide = i2;
        this.assumeLandscapeOrientation = z;
    }

    @Override // androidx.media3.effect.GlEffect
    public GlShaderProgram toGlShaderProgram(Context context, boolean z) throws VideoFrameProcessingException {
        return new SeparableConvolutionShaderProgram(context, z, new LanczosResampleScaledFunctionProvider(this.radius, this.longSide, this.shortSide, this.assumeLandscapeOrientation));
    }

    @Override // androidx.media3.effect.GlEffect
    public boolean isNoOp(int i, int i2) {
        Size targetSize = getTargetSize(i, i2, this.longSide, this.shortSide, this.assumeLandscapeOrientation);
        return Math.abs(scalingFactorToFit(i, i2, targetSize.getWidth(), targetSize.getHeight()) - 1.0f) < 0.01f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float scalingFactorToFit(int i, int i2, int i3, int i4) {
        Preconditions.checkArgument(i > 0);
        Preconditions.checkArgument(i2 > 0);
        return i2 * i3 <= i4 * i ? i3 / i : i4 / i2;
    }

    private static class LanczosResampleScaledFunctionProvider implements ConvolutionFunction1D.Provider {
        private static final float SCALE_UNSET = -3.4028235E38f;
        private final boolean assumeLandscapeOrientation;
        private final int longSide;
        private final float radius;
        private float scale;
        private final int shortSide;

        private LanczosResampleScaledFunctionProvider(float f, int i, int i2, boolean z) {
            Preconditions.checkArgument(f > 0.0f);
            Preconditions.checkArgument(i > 0);
            Preconditions.checkArgument(i2 > 0);
            this.radius = f;
            this.longSide = i;
            this.shortSide = i2;
            this.assumeLandscapeOrientation = z;
            this.scale = -3.4028235E38f;
        }

        @Override // androidx.media3.effect.ConvolutionFunction1D.Provider
        public ConvolutionFunction1D getConvolution(long j) {
            return new ScaledLanczosFunction(this.radius, Math.min(this.scale, 1.0f));
        }

        @Override // androidx.media3.effect.ConvolutionFunction1D.Provider
        public Size configure(Size size) {
            Size targetSize = LanczosResample.getTargetSize(size.getWidth(), size.getHeight(), this.longSide, this.shortSide, this.assumeLandscapeOrientation);
            this.scale = LanczosResample.scalingFactorToFit(size.getWidth(), size.getHeight(), targetSize.getWidth(), targetSize.getHeight());
            return new Size(Math.round(size.getWidth() * this.scale), Math.round(size.getHeight() * this.scale));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Size getTargetSize(int i, int i2, int i3, int i4, boolean z) {
        if (z || i > i2) {
            return new Size(i3, i4);
        }
        return new Size(i4, i3);
    }
}
