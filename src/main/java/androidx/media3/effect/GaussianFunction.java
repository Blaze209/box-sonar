package androidx.media3.effect;

import com.google.common.base.Preconditions;
import java.util.Objects;

/* JADX INFO: loaded from: classes8.dex */
public final class GaussianFunction implements ConvolutionFunction1D {
    private final float numStdDev;
    private final float sigma;

    public GaussianFunction(float f, float f2) {
        Preconditions.checkArgument(f > 0.0f && f2 > 0.0f);
        this.sigma = f;
        this.numStdDev = f2;
    }

    @Override // androidx.media3.effect.ConvolutionFunction1D
    public float domainStart() {
        return (-this.numStdDev) * this.sigma;
    }

    @Override // androidx.media3.effect.ConvolutionFunction1D
    public float domainEnd() {
        return this.numStdDev * this.sigma;
    }

    @Override // androidx.media3.effect.ConvolutionFunction1D
    public float value(float f) {
        float fAbs = Math.abs(f);
        float f2 = this.numStdDev;
        float f3 = this.sigma;
        if (fAbs > f2 * f3) {
            return 0.0f;
        }
        float f4 = f / f3;
        return (float) ((Math.exp(((-f4) * f4) / 2.0f) / Math.sqrt(6.283185307179586d)) / ((double) this.sigma));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GaussianFunction)) {
            return false;
        }
        GaussianFunction gaussianFunction = (GaussianFunction) obj;
        return Float.compare(gaussianFunction.sigma, this.sigma) == 0 && Float.compare(gaussianFunction.numStdDev, this.numStdDev) == 0;
    }

    public int hashCode() {
        return Objects.hash(Float.valueOf(this.sigma), Float.valueOf(this.numStdDev));
    }
}
