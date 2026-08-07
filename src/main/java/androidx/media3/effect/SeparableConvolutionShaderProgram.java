package androidx.media3.effect;

import android.content.Context;
import android.opengl.GLES20;
import androidx.media3.common.C;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.GlProgram;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Size;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes8.dex */
public class SeparableConvolutionShaderProgram implements GlShaderProgram {
    private static final int FUNCTION_LUT_PADDING = 5;
    private static final int RASTER_SAMPLES_PER_TEXEL = 5;
    private final ConvolutionFunction1D.Provider convolutionFunction1DProvider;
    private GlShaderProgram.ErrorListener errorListener;
    private Executor errorListenerExecutor;
    private float functionLutCenterX;
    private float functionLutDomainStart;
    private float functionLutTexelStep;
    private GlTextureInfo functionLutTexture;
    private float functionLutWidth;
    private final GlProgram glProgram;
    private GlShaderProgram.InputListener inputListener;
    private Size intermediateSize;
    private GlTextureInfo intermediateTexture;
    private ConvolutionFunction1D lastConvolutionFunction;
    private Size lastInputSize;
    private GlShaderProgram.OutputListener outputListener;
    private Size outputSize;
    private GlTextureInfo outputTexture;
    private boolean outputTextureInUse;
    private final boolean useHdr;

    static /* synthetic */ void lambda$new$0(VideoFrameProcessingException videoFrameProcessingException) {
    }

    protected void onBlurRendered(GlTextureInfo glTextureInfo) throws GlUtil.GlException {
    }

    public SeparableConvolutionShaderProgram(Context context, boolean z, SeparableConvolution separableConvolution, float f, float f2) throws VideoFrameProcessingException {
        this(context, z, new SeparableConvolutionWrapper(separableConvolution, f, f2));
    }

    public SeparableConvolutionShaderProgram(Context context, boolean z, ConvolutionFunction1D.Provider provider) throws VideoFrameProcessingException {
        this.useHdr = z;
        this.convolutionFunction1DProvider = provider;
        this.inputListener = new GlShaderProgram.InputListener() { // from class: androidx.media3.effect.SeparableConvolutionShaderProgram.1
        };
        this.outputListener = new GlShaderProgram.OutputListener() { // from class: androidx.media3.effect.SeparableConvolutionShaderProgram.2
        };
        this.errorListener = new GlShaderProgram.ErrorListener() { // from class: androidx.media3.effect.SeparableConvolutionShaderProgram$$ExternalSyntheticLambda1
            @Override // androidx.media3.effect.GlShaderProgram.ErrorListener
            public final void onError(VideoFrameProcessingException videoFrameProcessingException) {
                SeparableConvolutionShaderProgram.lambda$new$0(videoFrameProcessingException);
            }
        };
        this.errorListenerExecutor = MoreExecutors.directExecutor();
        this.functionLutTexture = GlTextureInfo.UNSET;
        this.intermediateTexture = GlTextureInfo.UNSET;
        this.outputTexture = GlTextureInfo.UNSET;
        this.lastInputSize = Size.ZERO;
        this.intermediateSize = Size.ZERO;
        this.outputSize = Size.ZERO;
        this.lastConvolutionFunction = null;
        try {
            this.glProgram = new GlProgram(context, R.raw.vertex_shader_transformation_es2, R.raw.fragment_shader_separable_convolution_es2);
        } catch (GlUtil.GlException | IOException e) {
            throw new VideoFrameProcessingException(e);
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public final void setInputListener(GlShaderProgram.InputListener inputListener) {
        this.inputListener = inputListener;
        if (this.outputTextureInUse) {
            return;
        }
        inputListener.onReadyToAcceptInputFrame();
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public final void setOutputListener(GlShaderProgram.OutputListener outputListener) {
        this.outputListener = outputListener;
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public final void setErrorListener(Executor executor, GlShaderProgram.ErrorListener errorListener) {
        this.errorListenerExecutor = executor;
        this.errorListener = errorListener;
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public final void queueInputFrame(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, final long j) {
        Preconditions.checkState(!this.outputTextureInUse, "The shader program does not currently accept input frames. Release prior output frames first.");
        try {
            ensureTexturesAreConfigured(glObjectsProvider, new Size(glTextureInfo.width, glTextureInfo.height), j);
            this.outputTextureInUse = true;
            renderHorizontal(glTextureInfo);
            renderVertical();
            onBlurRendered(glTextureInfo);
            GLES20.glDrawArrays(5, 0, 4);
            GlUtil.checkGlError();
            this.inputListener.onInputFrameProcessed(glTextureInfo);
            this.outputListener.onOutputFrameAvailable(this.outputTexture, j);
        } catch (GlUtil.GlException e) {
            this.errorListenerExecutor.execute(new Runnable() { // from class: androidx.media3.effect.SeparableConvolutionShaderProgram$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m10426xa4ff972e(e, j);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$queueInputFrame$1$androidx-media3-effect-SeparableConvolutionShaderProgram, reason: not valid java name */
    /* synthetic */ void m10426xa4ff972e(GlUtil.GlException glException, long j) {
        this.errorListener.onError(VideoFrameProcessingException.from(glException, j));
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public final void releaseOutputFrame(GlTextureInfo glTextureInfo) {
        this.outputTextureInUse = false;
        this.inputListener.onReadyToAcceptInputFrame();
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public final void signalEndOfCurrentInputStream() {
        this.outputListener.onCurrentOutputStreamEnded();
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public final void flush() {
        this.outputTextureInUse = false;
        this.inputListener.onFlush();
        this.inputListener.onReadyToAcceptInputFrame();
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void release() throws VideoFrameProcessingException {
        try {
            this.outputTexture.release();
            this.intermediateTexture.release();
            this.functionLutTexture.release();
            this.glProgram.delete();
        } catch (GlUtil.GlException e) {
            throw new VideoFrameProcessingException(e);
        }
    }

    private void renderOnePass(int i, boolean z) throws GlUtil.GlException {
        int width = z ? this.lastInputSize.getWidth() : this.intermediateSize.getHeight();
        this.glProgram.use();
        this.glProgram.setSamplerTexIdUniform("uTexSampler", i, 0);
        this.glProgram.setIntUniform("uIsHorizontal", z ? 1 : 0);
        float f = width;
        this.glProgram.setFloatUniform("uSourceTexelSize", 1.0f / f);
        this.glProgram.setFloatUniform("uSourceFullSize", f);
        this.glProgram.setFloatUniform("uConvStartTexels", this.functionLutDomainStart);
        this.glProgram.setFloatUniform("uConvWidthTexels", this.functionLutWidth);
        this.glProgram.setFloatUniform("uFunctionLookupStepSize", this.functionLutTexelStep);
        this.glProgram.setFloatsUniform("uFunctionLookupCenter", new float[]{this.functionLutCenterX, 0.5f});
        this.glProgram.setSamplerTexIdUniform("uFunctionLookupSampler", this.functionLutTexture.texId, 1);
        this.glProgram.bindAttributesAndUniforms();
        GLES20.glDrawArrays(5, 0, 4);
        GlUtil.checkGlError();
    }

    private void renderHorizontal(GlTextureInfo glTextureInfo) throws GlUtil.GlException {
        GlUtil.focusFramebufferUsingCurrentContext(this.intermediateTexture.fboId, this.intermediateTexture.width, this.intermediateTexture.height);
        GlUtil.clearFocusedBuffers();
        renderOnePass(glTextureInfo.texId, true);
    }

    private void renderVertical() throws GlUtil.GlException {
        GlUtil.focusFramebufferUsingCurrentContext(this.outputTexture.fboId, this.outputTexture.width, this.outputTexture.height);
        GlUtil.clearFocusedBuffers();
        renderOnePass(this.intermediateTexture.texId, false);
    }

    private void ensureTexturesAreConfigured(GlObjectsProvider glObjectsProvider, Size size, long j) throws GlUtil.GlException {
        this.outputSize = this.convolutionFunction1DProvider.configure(size);
        ConvolutionFunction1D convolution = this.convolutionFunction1DProvider.getConvolution(j);
        if (!convolution.equals(this.lastConvolutionFunction)) {
            updateFunctionTexture(convolution);
            this.lastConvolutionFunction = convolution;
        }
        if (size.equals(this.lastInputSize)) {
            return;
        }
        this.glProgram.setBufferAttribute("aFramePosition", GlUtil.getNormalizedCoordinateBounds(), 4);
        float[] fArrCreate4x4IdentityMatrix = GlUtil.create4x4IdentityMatrix();
        this.glProgram.setFloatsUniform("uTransformationMatrix", fArrCreate4x4IdentityMatrix);
        this.glProgram.setFloatsUniform("uTexTransformationMatrix", fArrCreate4x4IdentityMatrix);
        Size size2 = new Size(this.outputSize.getWidth(), size.getHeight());
        this.intermediateSize = size2;
        this.intermediateTexture = configurePixelTexture(glObjectsProvider, this.intermediateTexture, size2);
        this.outputTexture = configurePixelTexture(glObjectsProvider, this.outputTexture, this.outputSize);
        this.lastInputSize = size;
    }

    private void updateFunctionTexture(ConvolutionFunction1D convolutionFunction1D) throws GlUtil.GlException {
        int i;
        int iCeil = (int) Math.ceil((convolutionFunction1D.width() * 5.0f) + 10.0f);
        float f = iCeil;
        this.functionLutTexelStep = 1.0f / (f / 5.0f);
        FloatBuffer floatBufferAllocate = FloatBuffer.allocate(iCeil);
        float fDomainStart = convolutionFunction1D.domainStart();
        int i2 = 0;
        int i3 = 0;
        while (i2 < iCeil) {
            int i4 = i2 - 5;
            floatBufferAllocate.put(i3, (i4 < 0 || i2 > iCeil + (-5)) ? 0.0f : convolutionFunction1D.value((i4 * 0.2f) + fDomainStart));
            i2++;
            i3++;
        }
        this.functionLutCenterX = (-(fDomainStart - 1.1f)) / (0.2f * f);
        this.functionLutDomainStart = convolutionFunction1D.domainStart();
        this.functionLutWidth = convolutionFunction1D.width();
        if (this.functionLutTexture == GlTextureInfo.UNSET || this.functionLutTexture.width != iCeil) {
            this.functionLutTexture.release();
            i = iCeil;
            this.functionLutTexture = new GlTextureInfo(GlUtil.generateTexture(), -1, -1, i, 1);
        } else {
            i = iCeil;
        }
        GlUtil.bindTexture(3553, this.functionLutTexture.texId, C.TEXTURE_MIN_FILTER_LINEAR);
        GLES20.glTexImage2D(3553, 0, 33325, i, 1, 0, 6403, 5126, floatBufferAllocate);
        GlUtil.checkGlError();
    }

    private GlTextureInfo configurePixelTexture(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, Size size) throws GlUtil.GlException {
        if (size.getWidth() == glTextureInfo.width && size.getHeight() == glTextureInfo.height) {
            return glTextureInfo;
        }
        glTextureInfo.release();
        return glObjectsProvider.createBuffersForTexture(GlUtil.createTexture(size.getWidth(), size.getHeight(), this.useHdr), size.getWidth(), size.getHeight());
    }

    private static final class SeparableConvolutionWrapper implements ConvolutionFunction1D.Provider {
        private final float scaleHeight;
        private final float scaleWidth;
        private final SeparableConvolution separableConvolution;

        public SeparableConvolutionWrapper(SeparableConvolution separableConvolution, float f, float f2) {
            this.separableConvolution = separableConvolution;
            this.scaleWidth = f;
            this.scaleHeight = f2;
        }

        @Override // androidx.media3.effect.ConvolutionFunction1D.Provider
        public ConvolutionFunction1D getConvolution(long j) {
            return this.separableConvolution.getConvolution(j);
        }

        @Override // androidx.media3.effect.ConvolutionFunction1D.Provider
        public Size configure(Size size) {
            return new Size((int) (size.getWidth() * this.scaleWidth), (int) (size.getHeight() * this.scaleHeight));
        }
    }
}
