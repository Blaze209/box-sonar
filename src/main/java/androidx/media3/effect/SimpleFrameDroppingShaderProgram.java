package androidx.media3.effect;

import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoFrameProcessingException;
import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: classes8.dex */
final class SimpleFrameDroppingShaderProgram extends PassthroughShaderProgram {
    private int framesReceived;
    private final int n;

    public SimpleFrameDroppingShaderProgram(float f, float f2) {
        int iRound = Math.round(f / f2);
        this.n = iRound;
        Preconditions.checkArgument(iRound >= 1, "The input frame rate should be greater than the target frame rate.");
    }

    @Override // androidx.media3.effect.PassthroughShaderProgram, androidx.media3.effect.GlShaderProgram
    public void queueInputFrame(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, long j) {
        if (this.framesReceived % this.n == 0) {
            super.queueInputFrame(glObjectsProvider, glTextureInfo, j);
        } else {
            getInputListener().onInputFrameProcessed(glTextureInfo);
            getInputListener().onReadyToAcceptInputFrame();
        }
        this.framesReceived++;
    }

    @Override // androidx.media3.effect.PassthroughShaderProgram, androidx.media3.effect.GlShaderProgram
    public void signalEndOfCurrentInputStream() {
        super.signalEndOfCurrentInputStream();
        this.framesReceived = 0;
    }

    @Override // androidx.media3.effect.PassthroughShaderProgram, androidx.media3.effect.GlShaderProgram
    public void flush() {
        super.flush();
        this.framesReceived = 0;
    }

    @Override // androidx.media3.effect.PassthroughShaderProgram, androidx.media3.effect.GlShaderProgram
    public void release() throws VideoFrameProcessingException {
        super.release();
        this.framesReceived = 0;
    }
}
