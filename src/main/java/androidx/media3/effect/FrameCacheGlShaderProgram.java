package androidx.media3.effect;

import android.content.Context;
import android.opengl.GLES20;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.GlProgram;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Size;
import java.io.IOException;

/* JADX INFO: loaded from: classes8.dex */
class FrameCacheGlShaderProgram extends BaseGlShaderProgram {
    private final GlProgram copyProgram;

    public FrameCacheGlShaderProgram(Context context, int i, boolean z) throws VideoFrameProcessingException {
        super(z, i);
        try {
            GlProgram glProgram = new GlProgram(context, R.raw.vertex_shader_transformation_es2, R.raw.fragment_shader_transformation_es2);
            this.copyProgram = glProgram;
            float[] fArrCreate4x4IdentityMatrix = GlUtil.create4x4IdentityMatrix();
            glProgram.setFloatsUniform("uTexTransformationMatrix", fArrCreate4x4IdentityMatrix);
            glProgram.setFloatsUniform("uTransformationMatrix", fArrCreate4x4IdentityMatrix);
            glProgram.setFloatsUniform("uRgbMatrix", fArrCreate4x4IdentityMatrix);
            glProgram.setBufferAttribute("aFramePosition", GlUtil.getNormalizedCoordinateBounds(), 4);
        } catch (GlUtil.GlException | IOException e) {
            throw VideoFrameProcessingException.from(e);
        }
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram
    public Size configure(int i, int i2) {
        return new Size(i, i2);
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram
    public void drawFrame(int i, long j) throws VideoFrameProcessingException {
        try {
            this.copyProgram.use();
            this.copyProgram.setSamplerTexIdUniform("uTexSampler", i, 0);
            this.copyProgram.bindAttributesAndUniforms();
            GLES20.glDrawArrays(5, 0, 4);
        } catch (GlUtil.GlException e) {
            throw VideoFrameProcessingException.from(e);
        }
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram, androidx.media3.effect.GlShaderProgram
    public void release() throws VideoFrameProcessingException {
        super.release();
        try {
            this.copyProgram.delete();
        } catch (GlUtil.GlException e) {
            throw new VideoFrameProcessingException(e);
        }
    }
}
