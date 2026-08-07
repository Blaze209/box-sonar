package androidx.media3.effect;

import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Size;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes8.dex */
public abstract class BaseGlShaderProgram implements GlShaderProgram {
    private static final String TAG = "BaseGlShaderProgram";
    protected final TexturePool outputTexturePool;
    private GlShaderProgram.InputListener inputListener = new GlShaderProgram.InputListener() { // from class: androidx.media3.effect.BaseGlShaderProgram.1
    };
    private GlShaderProgram.OutputListener outputListener = new GlShaderProgram.OutputListener() { // from class: androidx.media3.effect.BaseGlShaderProgram.2
    };
    private GlShaderProgram.ErrorListener errorListener = new GlShaderProgram.ErrorListener() { // from class: androidx.media3.effect.BaseGlShaderProgram$$ExternalSyntheticLambda0
        @Override // androidx.media3.effect.GlShaderProgram.ErrorListener
        public final void onError(VideoFrameProcessingException videoFrameProcessingException) {
            Log.e(BaseGlShaderProgram.TAG, "Exception caught by default BaseGlShaderProgram errorListener.", videoFrameProcessingException);
        }
    };
    private Executor errorListenerExecutor = MoreExecutors.directExecutor();
    private int inputWidth = -1;
    private int inputHeight = -1;

    public abstract Size configure(int i, int i2) throws VideoFrameProcessingException;

    public abstract void drawFrame(int i, long j) throws VideoFrameProcessingException;

    public boolean shouldClearTextureBuffer() {
        return true;
    }

    public BaseGlShaderProgram(boolean z, int i) {
        this.outputTexturePool = new TexturePool(z, i);
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void setInputListener(GlShaderProgram.InputListener inputListener) {
        this.inputListener = inputListener;
        for (int i = 0; i < this.outputTexturePool.freeTextureCount(); i++) {
            inputListener.onReadyToAcceptInputFrame();
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void setOutputListener(GlShaderProgram.OutputListener outputListener) {
        this.outputListener = outputListener;
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void setErrorListener(Executor executor, GlShaderProgram.ErrorListener errorListener) {
        this.errorListenerExecutor = executor;
        this.errorListener = errorListener;
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void queueInputFrame(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, long j) {
        try {
            if (this.inputWidth != glTextureInfo.width || this.inputHeight != glTextureInfo.height || !this.outputTexturePool.isConfigured()) {
                this.inputWidth = glTextureInfo.width;
                this.inputHeight = glTextureInfo.height;
                Size sizeConfigure = configure(glTextureInfo.width, glTextureInfo.height);
                this.outputTexturePool.ensureConfigured(glObjectsProvider, sizeConfigure.getWidth(), sizeConfigure.getHeight());
            }
            GlTextureInfo glTextureInfoUseTexture = this.outputTexturePool.useTexture();
            GlUtil.focusFramebufferUsingCurrentContext(glTextureInfoUseTexture.fboId, glTextureInfoUseTexture.width, glTextureInfoUseTexture.height);
            if (shouldClearTextureBuffer()) {
                GlUtil.clearFocusedBuffers();
            }
            drawFrame(glTextureInfo.texId, j);
            this.inputListener.onInputFrameProcessed(glTextureInfo);
            this.outputListener.onOutputFrameAvailable(glTextureInfoUseTexture, j);
        } catch (VideoFrameProcessingException | GlUtil.GlException e) {
            this.errorListenerExecutor.execute(new Runnable() { // from class: androidx.media3.effect.BaseGlShaderProgram$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m10355xcc033467(e);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$queueInputFrame$1$androidx-media3-effect-BaseGlShaderProgram, reason: not valid java name */
    /* synthetic */ void m10355xcc033467(Exception exc) {
        this.errorListener.onError(VideoFrameProcessingException.from(exc));
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void releaseOutputFrame(GlTextureInfo glTextureInfo) {
        if (this.outputTexturePool.isUsingTexture(glTextureInfo)) {
            this.outputTexturePool.freeTexture(glTextureInfo);
            this.inputListener.onReadyToAcceptInputFrame();
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void signalEndOfCurrentInputStream() {
        this.outputListener.onCurrentOutputStreamEnded();
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void flush() {
        this.outputTexturePool.freeAllTextures();
        this.inputListener.onFlush();
        for (int i = 0; i < this.outputTexturePool.capacity(); i++) {
            this.inputListener.onReadyToAcceptInputFrame();
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void release() throws VideoFrameProcessingException {
        try {
            this.outputTexturePool.deleteAllTextures();
        } catch (GlUtil.GlException e) {
            throw new VideoFrameProcessingException(e);
        }
    }

    protected final GlShaderProgram.InputListener getInputListener() {
        return this.inputListener;
    }

    protected final GlShaderProgram.OutputListener getOutputListener() {
        return this.outputListener;
    }

    protected final void onError(final Exception exc) {
        this.errorListenerExecutor.execute(new Runnable() { // from class: androidx.media3.effect.BaseGlShaderProgram$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m10354lambda$onError$2$androidxmedia3effectBaseGlShaderProgram(exc);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onError$2$androidx-media3-effect-BaseGlShaderProgram, reason: not valid java name */
    /* synthetic */ void m10354lambda$onError$2$androidxmedia3effectBaseGlShaderProgram(Exception exc) {
        this.errorListener.onError(VideoFrameProcessingException.from(exc));
    }
}
