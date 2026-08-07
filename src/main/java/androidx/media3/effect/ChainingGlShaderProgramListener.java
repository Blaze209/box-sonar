package androidx.media3.effect;

import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.GlUtil;
import com.google.common.base.Preconditions;
import java.util.Objects;

/* JADX INFO: loaded from: classes8.dex */
final class ChainingGlShaderProgramListener implements GlShaderProgram.InputListener, GlShaderProgram.OutputListener {
    private final FrameConsumptionManager frameConsumptionManager;
    private final GlShaderProgram producingGlShaderProgram;
    private final VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor;

    public ChainingGlShaderProgramListener(GlObjectsProvider glObjectsProvider, GlShaderProgram glShaderProgram, GlShaderProgram glShaderProgram2, VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor) {
        Preconditions.checkArgument(glShaderProgram != glShaderProgram2, "Creating a self loop in the chain: %s", glShaderProgram);
        this.producingGlShaderProgram = glShaderProgram;
        this.frameConsumptionManager = new FrameConsumptionManager(glObjectsProvider, glShaderProgram2, videoFrameProcessingTaskExecutor);
        this.videoFrameProcessingTaskExecutor = videoFrameProcessingTaskExecutor;
    }

    @Override // androidx.media3.effect.GlShaderProgram.InputListener
    public synchronized void onReadyToAcceptInputFrame() {
        this.frameConsumptionManager.onReadyToAcceptInputFrame();
    }

    @Override // androidx.media3.effect.GlShaderProgram.InputListener
    public void onInputFrameProcessed(final GlTextureInfo glTextureInfo) {
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.ChainingGlShaderProgramListener$$ExternalSyntheticLambda0
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f$0.m10363xbbe1aa34(glTextureInfo);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onInputFrameProcessed$0$androidx-media3-effect-ChainingGlShaderProgramListener, reason: not valid java name */
    /* synthetic */ void m10363xbbe1aa34(GlTextureInfo glTextureInfo) throws VideoFrameProcessingException, GlUtil.GlException {
        this.producingGlShaderProgram.releaseOutputFrame(glTextureInfo);
    }

    @Override // androidx.media3.effect.GlShaderProgram.InputListener
    public synchronized void onFlush() {
        this.frameConsumptionManager.onFlush();
        VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor = this.videoFrameProcessingTaskExecutor;
        final GlShaderProgram glShaderProgram = this.producingGlShaderProgram;
        Objects.requireNonNull(glShaderProgram);
        videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.ChainingGlShaderProgramListener$$ExternalSyntheticLambda1
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() {
                glShaderProgram.flush();
            }
        });
    }

    @Override // androidx.media3.effect.GlShaderProgram.OutputListener
    public synchronized void onOutputFrameAvailable(GlTextureInfo glTextureInfo, long j) {
        this.frameConsumptionManager.queueInputFrame(glTextureInfo, j);
    }

    @Override // androidx.media3.effect.GlShaderProgram.OutputListener
    public synchronized void onCurrentOutputStreamEnded() {
        this.frameConsumptionManager.signalEndOfCurrentStream();
    }
}
