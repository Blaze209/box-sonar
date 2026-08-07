package androidx.media3.effect;

import android.opengl.Matrix;
import androidx.media3.common.util.GlUtil;
import com.google.common.base.Preconditions;
import java.util.Arrays;

/* JADX INFO: loaded from: classes8.dex */
public final class RgbAdjustment implements RgbMatrix {
    private final float[] rgbMatrix;

    public static final class Builder {
        private float redScale = 1.0f;
        private float greenScale = 1.0f;
        private float blueScale = 1.0f;

        public Builder setRedScale(float f) {
            Preconditions.checkArgument(0.0f <= f, "Red scale needs to be non-negative.");
            this.redScale = f;
            return this;
        }

        public Builder setGreenScale(float f) {
            Preconditions.checkArgument(0.0f <= f, "Green scale needs to be non-negative.");
            this.greenScale = f;
            return this;
        }

        public Builder setBlueScale(float f) {
            Preconditions.checkArgument(0.0f <= f, "Blue scale needs to be non-negative.");
            this.blueScale = f;
            return this;
        }

        public RgbAdjustment build() {
            float[] fArrCreate4x4IdentityMatrix = GlUtil.create4x4IdentityMatrix();
            Matrix.scaleM(fArrCreate4x4IdentityMatrix, 0, this.redScale, this.greenScale, this.blueScale);
            return new RgbAdjustment(fArrCreate4x4IdentityMatrix);
        }
    }

    private RgbAdjustment(float[] fArr) {
        this.rgbMatrix = fArr;
    }

    @Override // androidx.media3.effect.RgbMatrix
    public float[] getMatrix(long j, boolean z) {
        return this.rgbMatrix;
    }

    @Override // androidx.media3.effect.GlEffect
    public boolean isNoOp(int i, int i2) {
        return Arrays.equals(this.rgbMatrix, GlUtil.create4x4IdentityMatrix());
    }
}
