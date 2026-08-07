package androidx.media3.effect;

import android.content.Context;
import android.opengl.GLES20;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.OverlaySettings;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.GlProgram;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Size;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
final class DefaultCompositorGlProgram {
    private static final String TAG = "CompositorGlProgram";
    private final Context context;
    private GlProgram glProgram;
    private final OverlayMatrixProvider overlayMatrixProvider = new OverlayMatrixProvider();

    static final class InputFrameInfo {
        public final GlTextureInfo glTextureInfo;
        public final OverlaySettings overlaySettings;

        public InputFrameInfo(GlTextureInfo glTextureInfo, OverlaySettings overlaySettings) {
            this.glTextureInfo = glTextureInfo;
            this.overlaySettings = overlaySettings;
        }
    }

    public DefaultCompositorGlProgram(Context context) {
        this.context = context;
    }

    public void drawFrame(List<InputFrameInfo> list, GlTextureInfo glTextureInfo) throws VideoFrameProcessingException, GlUtil.GlException {
        ensureConfigured();
        GlUtil.focusFramebufferUsingCurrentContext(glTextureInfo.fboId, glTextureInfo.width, glTextureInfo.height);
        this.overlayMatrixProvider.configure(new Size(glTextureInfo.width, glTextureInfo.height));
        GlUtil.clearFocusedBuffers();
        ((GlProgram) Preconditions.checkNotNull(this.glProgram)).use();
        GLES20.glEnable(3042);
        GLES20.glBlendFuncSeparate(770, 771, 1, 771);
        GlUtil.checkGlError();
        for (int size = list.size() - 1; size >= 0; size--) {
            blendOntoFocusedTexture(list.get(size));
        }
        GLES20.glDisable(3042);
        GlUtil.checkGlError();
    }

    public void release() {
        try {
            GlProgram glProgram = this.glProgram;
            if (glProgram != null) {
                glProgram.delete();
            }
        } catch (GlUtil.GlException e) {
            Log.e(TAG, "Error releasing GL Program", e);
        }
    }

    private void ensureConfigured() throws VideoFrameProcessingException, GlUtil.GlException {
        if (this.glProgram != null) {
            return;
        }
        try {
            GlProgram glProgram = new GlProgram(this.context, R.raw.vertex_shader_transformation_es2, R.raw.fragment_shader_alpha_scale_es2);
            this.glProgram = glProgram;
            glProgram.setBufferAttribute("aFramePosition", GlUtil.getNormalizedCoordinateBounds(), 4);
            this.glProgram.setFloatsUniform("uTexTransformationMatrix", GlUtil.create4x4IdentityMatrix());
        } catch (IOException e) {
            throw new VideoFrameProcessingException(e);
        }
    }

    private void blendOntoFocusedTexture(InputFrameInfo inputFrameInfo) throws GlUtil.GlException {
        GlProgram glProgram = (GlProgram) Preconditions.checkNotNull(this.glProgram);
        GlTextureInfo glTextureInfo = inputFrameInfo.glTextureInfo;
        glProgram.setSamplerTexIdUniform("uTexSampler", glTextureInfo.texId, 0);
        glProgram.setFloatsUniform("uTransformationMatrix", this.overlayMatrixProvider.getTransformationMatrix(new Size(glTextureInfo.width, glTextureInfo.height), inputFrameInfo.overlaySettings));
        glProgram.setFloatUniform("uAlphaScale", inputFrameInfo.overlaySettings.getAlphaScale());
        glProgram.bindAttributesAndUniforms();
        GLES20.glDrawArrays(5, 0, 4);
        GlUtil.checkGlError();
    }
}
