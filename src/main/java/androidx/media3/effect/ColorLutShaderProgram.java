package androidx.media3.effect;

import android.content.Context;
import android.opengl.GLES20;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.GlProgram;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Size;
import com.google.common.base.Preconditions;
import java.io.IOException;

/* JADX INFO: loaded from: classes8.dex */
final class ColorLutShaderProgram extends BaseGlShaderProgram {
    private final ColorLut colorLut;
    private final GlProgram glProgram;

    public ColorLutShaderProgram(Context context, ColorLut colorLut, boolean z) throws VideoFrameProcessingException {
        super(z, 1);
        Preconditions.checkArgument(!z, "ColorLutShaderProgram does not support HDR colors.");
        this.colorLut = colorLut;
        try {
            GlProgram glProgram = new GlProgram(context, R.raw.vertex_shader_transformation_es2, R.raw.fragment_shader_lut_es2);
            this.glProgram = glProgram;
            glProgram.setBufferAttribute("aFramePosition", GlUtil.getNormalizedCoordinateBounds(), 4);
            float[] fArrCreate4x4IdentityMatrix = GlUtil.create4x4IdentityMatrix();
            glProgram.setFloatsUniform("uTransformationMatrix", fArrCreate4x4IdentityMatrix);
            glProgram.setFloatsUniform("uTexTransformationMatrix", fArrCreate4x4IdentityMatrix);
        } catch (GlUtil.GlException | IOException e) {
            throw new VideoFrameProcessingException(e);
        }
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram
    public Size configure(int i, int i2) {
        return new Size(i, i2);
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram
    public void drawFrame(int i, long j) throws VideoFrameProcessingException {
        try {
            this.glProgram.use();
            this.glProgram.setSamplerTexIdUniform("uTexSampler", i, 0);
            this.glProgram.setSamplerTexIdUniform("uColorLut", this.colorLut.getLutTextureId(j), 1);
            this.glProgram.setFloatUniform("uColorLutLength", this.colorLut.getLength(j));
            this.glProgram.bindAttributesAndUniforms();
            GLES20.glDrawArrays(5, 0, 4);
        } catch (GlUtil.GlException e) {
            throw new VideoFrameProcessingException(e);
        }
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram, androidx.media3.effect.GlShaderProgram
    public void release() throws VideoFrameProcessingException {
        super.release();
        try {
            this.colorLut.release();
            this.glProgram.delete();
        } catch (GlUtil.GlException e) {
            throw new VideoFrameProcessingException(e);
        }
    }
}
