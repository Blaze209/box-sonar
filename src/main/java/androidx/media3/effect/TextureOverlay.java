package androidx.media3.effect;

import androidx.media3.common.OverlaySettings;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Size;

/* JADX INFO: loaded from: classes8.dex */
public abstract class TextureOverlay {
    private static final float[] IDENTITY_MATRIX = GlUtil.create4x4IdentityMatrix();

    public void configure(Size size) {
    }

    public abstract int getTextureId(long j) throws VideoFrameProcessingException;

    public abstract Size getTextureSize(long j);

    public void release() throws VideoFrameProcessingException {
    }

    public float[] getVertexTransformation(long j) {
        return IDENTITY_MATRIX;
    }

    public OverlaySettings getOverlaySettings(long j) {
        return new OverlaySettings() { // from class: androidx.media3.effect.TextureOverlay.1
        };
    }
}
