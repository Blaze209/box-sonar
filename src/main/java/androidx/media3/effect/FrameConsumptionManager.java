package androidx.media3.effect;

import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.GlUtil;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

/* JADX INFO: loaded from: classes8.dex */
final class FrameConsumptionManager implements GlShaderProgram.InputListener {
    private final Queue<TimedGlTextureInfo> availableFrames = new ArrayDeque();
    private final GlShaderProgram consumingGlShaderProgram;
    private int consumingGlShaderProgramInputCapacity;
    private final GlObjectsProvider glObjectsProvider;
    private final VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor;

    public FrameConsumptionManager(GlObjectsProvider glObjectsProvider, GlShaderProgram glShaderProgram, VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor) {
        this.glObjectsProvider = glObjectsProvider;
        this.consumingGlShaderProgram = glShaderProgram;
        this.videoFrameProcessingTaskExecutor = videoFrameProcessingTaskExecutor;
    }

    @Override // androidx.media3.effect.GlShaderProgram.InputListener
    public synchronized void onReadyToAcceptInputFrame() {
        final TimedGlTextureInfo timedGlTextureInfoPoll = this.availableFrames.poll();
        if (timedGlTextureInfoPoll == null) {
            this.consumingGlShaderProgramInputCapacity++;
            return;
        }
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.FrameConsumptionManager$$ExternalSyntheticLambda2
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f$0.m10402xd81ce908(timedGlTextureInfoPoll);
            }
        });
        TimedGlTextureInfo timedGlTextureInfoPeek = this.availableFrames.peek();
        if (timedGlTextureInfoPeek != null && timedGlTextureInfoPeek.presentationTimeUs == Long.MIN_VALUE) {
            VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor = this.videoFrameProcessingTaskExecutor;
            GlShaderProgram glShaderProgram = this.consumingGlShaderProgram;
            Objects.requireNonNull(glShaderProgram);
            videoFrameProcessingTaskExecutor.submit(new FrameConsumptionManager$$ExternalSyntheticLambda0(glShaderProgram));
            this.availableFrames.remove();
        }
    }

    /* JADX INFO: renamed from: lambda$onReadyToAcceptInputFrame$0$androidx-media3-effect-FrameConsumptionManager, reason: not valid java name */
    /* synthetic */ void m10402xd81ce908(TimedGlTextureInfo timedGlTextureInfo) throws VideoFrameProcessingException, GlUtil.GlException {
        this.consumingGlShaderProgram.queueInputFrame(this.glObjectsProvider, timedGlTextureInfo.glTextureInfo, timedGlTextureInfo.presentationTimeUs);
    }

    @Override // androidx.media3.effect.GlShaderProgram.InputListener
    public synchronized void onFlush() {
        this.consumingGlShaderProgramInputCapacity = 0;
        this.availableFrames.clear();
    }

    public synchronized void queueInputFrame(final GlTextureInfo glTextureInfo, final long j) {
        if (this.consumingGlShaderProgramInputCapacity > 0) {
            this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.FrameConsumptionManager$$ExternalSyntheticLambda1
                @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
                public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                    this.f$0.m10403x6311f25d(glTextureInfo, j);
                }
            });
            this.consumingGlShaderProgramInputCapacity--;
        } else {
            this.availableFrames.add(new TimedGlTextureInfo(glTextureInfo, j));
        }
    }

    /* JADX INFO: renamed from: lambda$queueInputFrame$1$androidx-media3-effect-FrameConsumptionManager, reason: not valid java name */
    /* synthetic */ void m10403x6311f25d(GlTextureInfo glTextureInfo, long j) throws VideoFrameProcessingException, GlUtil.GlException {
        this.consumingGlShaderProgram.queueInputFrame(this.glObjectsProvider, glTextureInfo, j);
    }

    public synchronized void signalEndOfCurrentStream() {
        if (!this.availableFrames.isEmpty()) {
            this.availableFrames.add(new TimedGlTextureInfo(GlTextureInfo.UNSET, Long.MIN_VALUE));
        } else {
            VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor = this.videoFrameProcessingTaskExecutor;
            GlShaderProgram glShaderProgram = this.consumingGlShaderProgram;
            Objects.requireNonNull(glShaderProgram);
            videoFrameProcessingTaskExecutor.submit(new FrameConsumptionManager$$ExternalSyntheticLambda0(glShaderProgram));
        }
    }

    public synchronized int getPendingFrameCount() {
        return this.availableFrames.size();
    }
}
