package androidx.media3.effect;

import android.opengl.Matrix;
import androidx.media3.common.OverlaySettings;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Size;

/* JADX INFO: loaded from: classes8.dex */
final class SamplerOverlayMatrixProvider extends OverlayMatrixProvider {
    private final float[] transformationMatrixInv = GlUtil.create4x4IdentityMatrix();

    @Override // androidx.media3.effect.OverlayMatrixProvider
    public float[] getTransformationMatrix(Size size, OverlaySettings overlaySettings) {
        Matrix.invertM(this.transformationMatrixInv, 0, super.getTransformationMatrix(size, overlaySettings), 0);
        return this.transformationMatrixInv;
    }
}
