package androidx.media3.effect;

/* JADX INFO: loaded from: classes8.dex */
public final class GaussianBlur extends SeparableConvolution {
    private final float numStandardDeviations;
    private final float sigma;

    public GaussianBlur(float f, float f2) {
        this.sigma = f;
        this.numStandardDeviations = f2;
    }

    public GaussianBlur(float f) {
        this(f, 2.0f);
    }

    @Override // androidx.media3.effect.SeparableConvolution
    public ConvolutionFunction1D getConvolution(long j) {
        return new GaussianFunction(this.sigma, this.numStandardDeviations);
    }
}
