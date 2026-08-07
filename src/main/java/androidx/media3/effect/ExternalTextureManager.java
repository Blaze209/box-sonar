package androidx.media3.effect;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import androidx.media3.common.FrameInfo;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes8.dex */
final class ExternalTextureManager extends TextureManager {
    private static final float EPSILON = 1.0E-9f;
    private static final long SURFACE_TEXTURE_TIMEOUT_MS;
    private static final String TAG = "ExtTexMgr";
    private static final String TIMER_THREAD_NAME = "ExtTexMgr:Timer";
    private boolean automaticReregistration;
    private int availableFrameCount;
    private FrameInfo currentFrame;
    private boolean currentInputStreamEnded;
    private final boolean experimentalAdjustSurfaceTextureTransformationMatrix;
    private ExternalShaderProgram externalShaderProgram;
    private int externalShaderProgramInputCapacity;
    private final int externalTexId;
    private Future<?> forceSignalEndOfStreamFuture;
    private final GlObjectsProvider glObjectsProvider;
    private FrameInfo lastRegisteredFrame;
    private final Queue<FrameInfo> pendingFrames;
    private volatile RuntimeException releaseAllFramesException;
    private CountDownLatch releaseAllFramesLatch;
    private final ScheduledExecutorService scheduledExecutorService;
    private volatile boolean shouldRejectIncomingFrames;
    private final Surface surface;
    private final SurfaceTexture surfaceTexture;
    private final float[] textureTransformMatrix;
    private static final int[] TRANSFORMATION_MATRIX_EXPECTED_ZERO_INDICES = {2, 3, 6, 7, 8, 9, 11, 14};
    private static final int[] ADDITIONAL_CANDIDATE_BUFFER_SIZE_GUESSES = {1920, 1088};

    static {
        SURFACE_TEXTURE_TIMEOUT_MS = Util.isRunningOnEmulator() ? 20000L : 500L;
    }

    public ExternalTextureManager(GlObjectsProvider glObjectsProvider, final VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor, boolean z, boolean z2) throws VideoFrameProcessingException {
        super(videoFrameProcessingTaskExecutor);
        this.glObjectsProvider = glObjectsProvider;
        this.automaticReregistration = z;
        this.experimentalAdjustSurfaceTextureTransformationMatrix = z2;
        try {
            int iCreateExternalTexture = GlUtil.createExternalTexture();
            this.externalTexId = iCreateExternalTexture;
            SurfaceTexture surfaceTexture = new SurfaceTexture(iCreateExternalTexture);
            this.surfaceTexture = surfaceTexture;
            this.textureTransformMatrix = new float[16];
            this.pendingFrames = new ConcurrentLinkedQueue();
            this.scheduledExecutorService = Util.newSingleThreadScheduledExecutor(TIMER_THREAD_NAME);
            surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: androidx.media3.effect.ExternalTextureManager$$ExternalSyntheticLambda2
                @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                    this.f$0.m10385lambda$new$1$androidxmedia3effectExternalTextureManager(videoFrameProcessingTaskExecutor, surfaceTexture2);
                }
            });
            this.surface = new Surface(surfaceTexture);
        } catch (GlUtil.GlException e) {
            throw new VideoFrameProcessingException(e);
        }
    }

    /* JADX INFO: renamed from: lambda$new$1$androidx-media3-effect-ExternalTextureManager, reason: not valid java name */
    /* synthetic */ void m10385lambda$new$1$androidxmedia3effectExternalTextureManager(VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor, SurfaceTexture surfaceTexture) {
        videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.ExternalTextureManager$$ExternalSyntheticLambda7
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f$0.m10384lambda$new$0$androidxmedia3effectExternalTextureManager();
            }
        }, false);
    }

    /* JADX INFO: renamed from: lambda$new$0$androidx-media3-effect-ExternalTextureManager, reason: not valid java name */
    /* synthetic */ void m10384lambda$new$0$androidxmedia3effectExternalTextureManager() throws VideoFrameProcessingException, GlUtil.GlException {
        DebugTraceUtil.logEvent(DebugTraceUtil.COMPONENT_VFP, DebugTraceUtil.EVENT_SURFACE_TEXTURE_INPUT, -9223372036854775807L);
        if (this.automaticReregistration) {
            this.pendingFrames.add((FrameInfo) Preconditions.checkNotNull(this.lastRegisteredFrame));
        }
        if (this.shouldRejectIncomingFrames) {
            this.surfaceTexture.updateTexImage();
            this.pendingFrames.poll();
            if (this.releaseAllFramesLatch == null || !this.pendingFrames.isEmpty()) {
                return;
            }
            this.releaseAllFramesLatch.countDown();
            return;
        }
        if (this.currentInputStreamEnded) {
            restartForceSignalEndOfStreamTimer();
        }
        this.availableFrameCount++;
        maybeQueueFrameToExternalShaderProgram();
    }

    @Override // androidx.media3.effect.TextureManager
    public void setSamplingGlShaderProgram(GlShaderProgram glShaderProgram) {
        Preconditions.checkState(glShaderProgram instanceof ExternalShaderProgram);
        this.externalShaderProgramInputCapacity = 0;
        this.externalShaderProgram = (ExternalShaderProgram) glShaderProgram;
    }

    @Override // androidx.media3.effect.TextureManager
    public void setDefaultBufferSize(int i, int i2) {
        this.surfaceTexture.setDefaultBufferSize(i, i2);
    }

    @Override // androidx.media3.effect.TextureManager
    public Surface getInputSurface() {
        return this.surface;
    }

    @Override // androidx.media3.effect.GlShaderProgram.InputListener
    public void onReadyToAcceptInputFrame() {
        final ExternalShaderProgram externalShaderProgram = this.externalShaderProgram;
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.ExternalTextureManager$$ExternalSyntheticLambda8
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f$0.m10387xcc1ffcf6(externalShaderProgram);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onReadyToAcceptInputFrame$2$androidx-media3-effect-ExternalTextureManager, reason: not valid java name */
    /* synthetic */ void m10387xcc1ffcf6(ExternalShaderProgram externalShaderProgram) throws VideoFrameProcessingException, GlUtil.GlException {
        if (externalShaderProgram != this.externalShaderProgram) {
            return;
        }
        this.externalShaderProgramInputCapacity++;
        maybeQueueFrameToExternalShaderProgram();
    }

    @Override // androidx.media3.effect.GlShaderProgram.InputListener
    public void onInputFrameProcessed(GlTextureInfo glTextureInfo) {
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.ExternalTextureManager$$ExternalSyntheticLambda5
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f$0.m10386xedec5979();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onInputFrameProcessed$3$androidx-media3-effect-ExternalTextureManager, reason: not valid java name */
    /* synthetic */ void m10386xedec5979() throws VideoFrameProcessingException, GlUtil.GlException {
        this.currentFrame = null;
        if (!this.currentInputStreamEnded || !this.pendingFrames.isEmpty()) {
            maybeQueueFrameToExternalShaderProgram();
            return;
        }
        this.currentInputStreamEnded = false;
        ((ExternalShaderProgram) Preconditions.checkNotNull(this.externalShaderProgram)).signalEndOfCurrentInputStream();
        DebugTraceUtil.logEvent(DebugTraceUtil.COMPONENT_EXTERNAL_TEXTURE_MANAGER, DebugTraceUtil.EVENT_SIGNAL_EOS, Long.MIN_VALUE);
        cancelForceSignalEndOfStreamTimer();
    }

    @Override // androidx.media3.effect.TextureManager
    public void setInputFrameInfo(FrameInfo frameInfo, boolean z) {
        this.automaticReregistration = z;
        if (z) {
            this.lastRegisteredFrame = frameInfo;
            this.surfaceTexture.setDefaultBufferSize(frameInfo.format.width, frameInfo.format.height);
        }
    }

    @Override // androidx.media3.effect.TextureManager
    public void registerInputFrame(FrameInfo frameInfo) {
        this.lastRegisteredFrame = frameInfo;
        if (!this.automaticReregistration) {
            this.pendingFrames.add(frameInfo);
        }
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.ExternalTextureManager$$ExternalSyntheticLambda1
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f$0.m10388x57e5f12e();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$registerInputFrame$4$androidx-media3-effect-ExternalTextureManager, reason: not valid java name */
    /* synthetic */ void m10388x57e5f12e() throws VideoFrameProcessingException, GlUtil.GlException {
        this.shouldRejectIncomingFrames = false;
    }

    @Override // androidx.media3.effect.TextureManager
    public int getPendingFrameCount() {
        return this.pendingFrames.size();
    }

    @Override // androidx.media3.effect.TextureManager
    public void signalEndOfCurrentInputStream() {
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.ExternalTextureManager$$ExternalSyntheticLambda0
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f$0.m10391xae45132a();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$signalEndOfCurrentInputStream$5$androidx-media3-effect-ExternalTextureManager, reason: not valid java name */
    /* synthetic */ void m10391xae45132a() throws VideoFrameProcessingException, GlUtil.GlException {
        if (this.automaticReregistration) {
            this.shouldRejectIncomingFrames = true;
        }
        if (this.pendingFrames.isEmpty() && this.currentFrame == null) {
            ((ExternalShaderProgram) Preconditions.checkNotNull(this.externalShaderProgram)).signalEndOfCurrentInputStream();
            DebugTraceUtil.logEvent(DebugTraceUtil.COMPONENT_EXTERNAL_TEXTURE_MANAGER, DebugTraceUtil.EVENT_SIGNAL_EOS, Long.MIN_VALUE);
            cancelForceSignalEndOfStreamTimer();
        } else {
            this.currentInputStreamEnded = true;
            restartForceSignalEndOfStreamTimer();
        }
    }

    @Override // androidx.media3.effect.TextureManager
    public void release() {
        this.surfaceTexture.release();
        this.surface.release();
        this.scheduledExecutorService.shutdownNow();
    }

    @Override // androidx.media3.effect.TextureManager
    protected void flush() throws VideoFrameProcessingException {
        this.externalShaderProgramInputCapacity = 0;
        this.currentFrame = null;
        this.pendingFrames.clear();
        this.lastRegisteredFrame = null;
        super.flush();
    }

    @Override // androidx.media3.effect.TextureManager
    public void dropIncomingRegisteredFrames() {
        this.shouldRejectIncomingFrames = true;
    }

    @Override // androidx.media3.effect.TextureManager
    public void releaseAllRegisteredFrames() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.releaseAllFramesLatch = countDownLatch;
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.ExternalTextureManager$$ExternalSyntheticLambda4
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f$0.m10389xafddfbec();
            }
        });
        try {
            if (!countDownLatch.await(SURFACE_TEXTURE_TIMEOUT_MS, TimeUnit.MILLISECONDS)) {
                Log.w(TAG, "Timeout reached while waiting for latch to be unblocked.");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            Log.w(TAG, "Interrupted when waiting for MediaCodec frames to arrive.");
        }
        this.releaseAllFramesLatch = null;
        if (this.releaseAllFramesException != null) {
            throw this.releaseAllFramesException;
        }
    }

    /* JADX INFO: renamed from: lambda$releaseAllRegisteredFrames$6$androidx-media3-effect-ExternalTextureManager, reason: not valid java name */
    /* synthetic */ void m10389xafddfbec() throws VideoFrameProcessingException, GlUtil.GlException {
        try {
            removeAllSurfaceTextureFrames();
        } catch (RuntimeException e) {
            this.releaseAllFramesException = e;
            Log.e(TAG, "Failed to remove texture frames", e);
            if (this.releaseAllFramesLatch != null) {
                this.releaseAllFramesLatch.countDown();
            }
        }
    }

    private void restartForceSignalEndOfStreamTimer() {
        cancelForceSignalEndOfStreamTimer();
        this.forceSignalEndOfStreamFuture = this.scheduledExecutorService.schedule(new Runnable() { // from class: androidx.media3.effect.ExternalTextureManager$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m10390xe7407162();
            }
        }, SURFACE_TEXTURE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: renamed from: lambda$restartForceSignalEndOfStreamTimer$7$androidx-media3-effect-ExternalTextureManager, reason: not valid java name */
    /* synthetic */ void m10390xe7407162() {
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.ExternalTextureManager$$ExternalSyntheticLambda6
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() {
                this.f$0.forceSignalEndOfStream();
            }
        });
    }

    private void cancelForceSignalEndOfStreamTimer() {
        Future<?> future = this.forceSignalEndOfStreamFuture;
        if (future != null) {
            future.cancel(false);
        }
        this.forceSignalEndOfStreamFuture = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void forceSignalEndOfStream() {
        if (this.availableFrameCount == this.pendingFrames.size()) {
            return;
        }
        Log.w(TAG, Util.formatInvariant("Forcing EOS after missing %d frames for %d ms, with available frame count: %d", Integer.valueOf(this.pendingFrames.size()), Long.valueOf(SURFACE_TEXTURE_TIMEOUT_MS), Integer.valueOf(this.availableFrameCount)));
        this.currentInputStreamEnded = false;
        this.currentFrame = null;
        this.shouldRejectIncomingFrames = true;
        removeAllSurfaceTextureFrames();
        this.pendingFrames.clear();
        signalEndOfCurrentInputStream();
    }

    private void removeAllSurfaceTextureFrames() {
        while (true) {
            int i = this.availableFrameCount;
            if (i <= 0) {
                break;
            }
            this.availableFrameCount = i - 1;
            this.surfaceTexture.updateTexImage();
            this.pendingFrames.remove();
        }
        if (this.releaseAllFramesLatch == null || !this.pendingFrames.isEmpty()) {
            return;
        }
        this.releaseAllFramesLatch.countDown();
    }

    private void maybeQueueFrameToExternalShaderProgram() {
        if (this.externalShaderProgramInputCapacity == 0 || this.availableFrameCount == 0 || this.currentFrame != null) {
            return;
        }
        this.surfaceTexture.updateTexImage();
        this.availableFrameCount--;
        FrameInfo frameInfoElement = this.pendingFrames.element();
        this.currentFrame = frameInfoElement;
        this.externalShaderProgramInputCapacity--;
        this.surfaceTexture.getTransformMatrix(this.textureTransformMatrix);
        long timestamp = (this.surfaceTexture.getTimestamp() / 1000) + frameInfoElement.offsetToAddUs;
        if (this.experimentalAdjustSurfaceTextureTransformationMatrix) {
            removeSurfaceTextureScaleFromTransformMatrix(this.textureTransformMatrix, timestamp, frameInfoElement.format.width, frameInfoElement.format.height);
        }
        ((ExternalShaderProgram) Preconditions.checkNotNull(this.externalShaderProgram)).setTextureTransformMatrix(this.textureTransformMatrix);
        ((ExternalShaderProgram) Preconditions.checkNotNull(this.externalShaderProgram)).queueInputFrame(this.glObjectsProvider, new GlTextureInfo(this.externalTexId, -1, -1, frameInfoElement.format.width, frameInfoElement.format.height), timestamp);
        Preconditions.checkNotNull(this.pendingFrames.remove());
        DebugTraceUtil.logEvent(DebugTraceUtil.COMPONENT_VFP, DebugTraceUtil.EVENT_QUEUE_FRAME, timestamp);
    }

    private static void removeSurfaceTextureScaleFromTransformMatrix(float[] fArr, long j, int i, int i2) {
        byte b;
        byte b2;
        boolean z = true;
        boolean z2 = fArr.length != 16;
        for (int i3 : TRANSFORMATION_MATRIX_EXPECTED_ZERO_INDICES) {
            z2 |= Math.abs(fArr[i3]) > EPSILON;
        }
        boolean z3 = z2 | (Math.abs(fArr[10] - 1.0f) > EPSILON) | (Math.abs(fArr[15] - 1.0f) > EPSILON);
        float fAbs = Math.abs(fArr[0]);
        byte b3 = Ascii.FF;
        byte b4 = 4;
        if (fAbs > EPSILON && Math.abs(fArr[5]) > EPSILON) {
            z = (Math.abs(fArr[4]) > EPSILON) | z3 | (Math.abs(fArr[1]) > EPSILON);
            b2 = 13;
            b4 = 5;
            b = 0;
        } else if (Math.abs(fArr[1]) <= EPSILON || Math.abs(fArr[4]) <= EPSILON) {
            b = -1;
            b2 = -1;
            b3 = -1;
            b4 = -1;
        } else {
            z = z3 | (Math.abs(fArr[0]) > EPSILON) | (Math.abs(fArr[5]) > EPSILON);
            b2 = 12;
            b3 = 13;
            b = 1;
        }
        if (z) {
            DebugTraceUtil.logEvent(DebugTraceUtil.COMPONENT_EXTERNAL_TEXTURE_MANAGER, DebugTraceUtil.EVENT_SURFACE_TEXTURE_TRANSFORM_FIX, j, "Unable to apply SurfaceTexture fix", new Object[0]);
            return;
        }
        float f = fArr[b];
        float f2 = fArr[b3];
        if (Math.abs(f) + EPSILON < 1.0f) {
            float fCopySign = Math.copySign(guessScaleWithoutSurfaceTextureTrim(Math.abs(f), i), f);
            DebugTraceUtil.logEvent(DebugTraceUtil.COMPONENT_EXTERNAL_TEXTURE_MANAGER, DebugTraceUtil.EVENT_SURFACE_TEXTURE_TRANSFORM_FIX, j, "Width scale adjusted.", new Object[0]);
            fArr[b] = fCopySign;
            fArr[b3] = ((f - fCopySign) * 0.5f) + f2;
        }
        float f3 = fArr[b4];
        float f4 = fArr[b2];
        if (Math.abs(f3) + EPSILON < 1.0f) {
            float fCopySign2 = Math.copySign(guessScaleWithoutSurfaceTextureTrim(Math.abs(f3), i2), f3);
            DebugTraceUtil.logEvent(DebugTraceUtil.COMPONENT_EXTERNAL_TEXTURE_MANAGER, DebugTraceUtil.EVENT_SURFACE_TEXTURE_TRANSFORM_FIX, j, "Height scale adjusted.", new Object[0]);
            fArr[b4] = fCopySign2;
            fArr[b2] = ((f3 - fCopySign2) * 0.5f) + f4;
        }
    }

    private static float guessScaleWithoutSurfaceTextureTrim(float f, int i) {
        int i2 = i;
        for (int i3 = 2; i3 <= 256; i3 *= 2) {
            int i4 = (((i + i3) - 1) / i3) * i3;
            if (scoreForCandidateBufferSize(i4, f, i) < scoreForCandidateBufferSize(i2, f, i)) {
                i2 = i4;
            }
        }
        for (int i5 : ADDITIONAL_CANDIDATE_BUFFER_SIZE_GUESSES) {
            if (i5 >= i && scoreForCandidateBufferSize(i5, f, i) < scoreForCandidateBufferSize(i2, f, i)) {
                i2 = i5;
            }
        }
        return scoreForCandidateBufferSize(i2, f, i) > EPSILON ? f : i / i2;
    }

    private static float scoreForCandidateBufferSize(int i, float f, int i2) {
        float fAbs = 1.0f;
        for (int i3 = 0; i3 <= 2; i3++) {
            float f2 = ((i2 - i3) / i) - f;
            if (Math.abs(f2) < fAbs) {
                fAbs = Math.abs(f2);
            }
        }
        return fAbs;
    }
}
