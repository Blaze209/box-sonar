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
final class HslShaderProgram extends BaseGlShaderProgram {
    private final GlProgram glProgram;

    public HslShaderProgram(Context context, HslAdjustment hslAdjustment, boolean z) throws VideoFrameProcessingException {
        super(z, 1);
        Preconditions.checkArgument(!z, "HDR is not yet supported.");
        try {
            GlProgram glProgram = new GlProgram(context, R.raw.vertex_shader_transformation_es2, R.raw.fragment_shader_hsl_es2);
            this.glProgram = glProgram;
            glProgram.setBufferAttribute("aFramePosition", GlUtil.getNormalizedCoordinateBounds(), 4);
            float[] fArrCreate4x4IdentityMatrix = GlUtil.create4x4IdentityMatrix();
            glProgram.setFloatsUniform("uTransformationMatrix", fArrCreate4x4IdentityMatrix);
            glProgram.setFloatsUniform("uTexTransformationMatrix", fArrCreate4x4IdentityMatrix);
            glProgram.setFloatUniform("uHueAdjustmentDegrees", hslAdjustment.hueAdjustmentDegrees / 360.0f);
            glProgram.setFloatUniform("uSaturationAdjustment", hslAdjustment.saturationAdjustment / 100.0f);
            glProgram.setFloatUniform("uLightnessAdjustment", hslAdjustment.lightnessAdjustment / 100.0f);
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
            this.glProgram.bindAttributesAndUniforms();
            GLES20.glDrawArrays(5, 0, 4);
        } catch (GlUtil.GlException e) {
            throw new VideoFrameProcessingException(e, j);
        }
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram, androidx.media3.effect.GlShaderProgram
    public void release() throws VideoFrameProcessingException {
        super.release();
        try {
            this.glProgram.delete();
        } catch (GlUtil.GlException e) {
            throw new VideoFrameProcessingException(e);
        }
    }
}
