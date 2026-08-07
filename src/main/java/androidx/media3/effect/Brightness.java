package androidx.media3.effect;

import android.opengl.Matrix;
import androidx.media3.common.util.GlUtil;
import com.google.common.base.Preconditions;
import java.util.Arrays;

/* JADX INFO: loaded from: classes8.dex */
public final class Brightness implements RgbMatrix {
    private final float[] rgbMatrix;

    public Brightness(float f) {
        Preconditions.checkArgument(f >= -1.0f && f <= 1.0f, "brightness value outside of range from -1f to 1f, inclusive");
        float[] fArrCreate4x4IdentityMatrix = GlUtil.create4x4IdentityMatrix();
        this.rgbMatrix = fArrCreate4x4IdentityMatrix;
        Matrix.translateM(fArrCreate4x4IdentityMatrix, 0, f, f, f);
    }

    @Override // androidx.media3.effect.RgbMatrix
    public float[] getMatrix(long j, boolean z) {
        Preconditions.checkArgument(!z, "HDR is not supported.");
        return this.rgbMatrix;
    }

    @Override // androidx.media3.effect.GlEffect
    public boolean isNoOp(int i, int i2) {
        return Arrays.equals(this.rgbMatrix, GlUtil.create4x4IdentityMatrix());
    }
}
