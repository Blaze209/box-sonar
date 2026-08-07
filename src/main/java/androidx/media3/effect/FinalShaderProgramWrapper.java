package androidx.media3.effect;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.SurfaceInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.VideoFrameProcessor;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.LongArrayQueue;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.SystemClock;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes8.dex */
final class FinalShaderProgramWrapper implements GlShaderProgram, GlTextureProducer {
    private static final int SURFACE_INPUT_CAPACITY = 1;
    private static final String TAG = "FinalShaderWrapper";
    private final Context context;
    private DefaultShaderProgram defaultShaderProgram;
    private final EGLContext eglContext;
    private final EGLDisplay eglDisplay;
    private int inputHeight;
    private int inputWidth;
    private boolean isInputStreamEndedWithPendingAvailableFrames;
    private Listener listener;
    private boolean matrixTransformationsChanged;
    private final ColorInfo outputColorInfo;
    private EGLSurface outputEglSurface;
    private Size outputSizeBeforeSurfaceTransformation;
    private SurfaceInfo outputSurfaceInfo;
    private boolean outputSurfaceInfoChanged;
    private final TexturePool outputTexturePool;
    private final LongArrayQueue outputTextureTimestamps;
    private final EGLSurface placeholderSurface;
    private final boolean renderFramesAutomatically;
    private final int sdrWorkingColorSpace;
    private final LongArrayQueue syncObjects;
    private final GlTextureProducer.Listener textureOutputListener;
    private final VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor;
    private final VideoFrameProcessor.Listener videoFrameProcessorListener;
    private final Executor videoFrameProcessorListenerExecutor;
    private final List<GlMatrixTransformation> matrixTransformations = new ArrayList();
    private final List<RgbMatrix> rgbMatrices = new ArrayList();
    private GlShaderProgram.InputListener inputListener = new GlShaderProgram.InputListener() { // from class: androidx.media3.effect.FinalShaderProgramWrapper.1
    };
    private final Queue<TimedGlTextureInfo> availableFrames = new ConcurrentLinkedQueue();
    private long redrawFramePresentationTimeUs = -9223372036854775807L;

    public interface Listener {
        void onFrameRendered(long j);

        void onInputStreamProcessed();
    }

    public FinalShaderProgramWrapper(Context context, EGLDisplay eGLDisplay, EGLContext eGLContext, EGLSurface eGLSurface, ColorInfo colorInfo, VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor, Executor executor, VideoFrameProcessor.Listener listener, GlTextureProducer.Listener listener2, int i, int i2, boolean z) {
        this.context = context;
        this.eglDisplay = eGLDisplay;
        this.eglContext = eGLContext;
        this.placeholderSurface = eGLSurface;
        this.outputColorInfo = colorInfo;
        this.videoFrameProcessingTaskExecutor = videoFrameProcessingTaskExecutor;
        this.videoFrameProcessorListenerExecutor = executor;
        this.videoFrameProcessorListener = listener;
        this.textureOutputListener = listener2;
        this.sdrWorkingColorSpace = i2;
        this.renderFramesAutomatically = z;
        this.outputTexturePool = new TexturePool(ColorInfo.isTransferHdr(colorInfo), i);
        this.outputTextureTimestamps = new LongArrayQueue(i);
        this.syncObjects = new LongArrayQueue(i);
    }

    @Override // androidx.media3.effect.GlTextureProducer
    public void releaseOutputTexture(final long j) {
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.FinalShaderProgramWrapper$$ExternalSyntheticLambda8
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f$0.m10398x579c0390(j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: releaseOutputTextureInternal, reason: merged with bridge method [inline-methods] */
    public void m10398x579c0390(long j) throws GlUtil.GlException {
        Preconditions.checkState(this.textureOutputListener != null);
        while (this.outputTexturePool.freeTextureCount() < this.outputTexturePool.capacity() && this.outputTextureTimestamps.element() <= j) {
            this.outputTexturePool.freeTexture();
            this.outputTextureTimestamps.remove();
            GlUtil.deleteSyncObject(this.syncObjects.remove());
            this.inputListener.onReadyToAcceptInputFrame();
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void setInputListener(GlShaderProgram.InputListener inputListener) {
        this.videoFrameProcessingTaskExecutor.verifyVideoFrameProcessingThread();
        this.inputListener = inputListener;
        for (int i = 0; i < getInputCapacity(); i++) {
            inputListener.onReadyToAcceptInputFrame();
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void setOutputListener(GlShaderProgram.OutputListener outputListener) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void setErrorListener(Executor executor, GlShaderProgram.ErrorListener errorListener) {
        throw new UnsupportedOperationException();
    }

    public void setListener(Listener listener) {
        this.videoFrameProcessingTaskExecutor.verifyVideoFrameProcessingThread();
        this.listener = listener;
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void signalEndOfCurrentInputStream() {
        this.videoFrameProcessingTaskExecutor.verifyVideoFrameProcessingThread();
        if (this.availableFrames.isEmpty()) {
            ((Listener) Preconditions.checkNotNull(this.listener)).onInputStreamProcessed();
            this.isInputStreamEndedWithPendingAvailableFrames = false;
        } else {
            Preconditions.checkState(!this.renderFramesAutomatically);
            this.isInputStreamEndedWithPendingAvailableFrames = true;
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void queueInputFrame(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, final long j) {
        final FinalShaderProgramWrapper finalShaderProgramWrapper;
        this.videoFrameProcessingTaskExecutor.verifyVideoFrameProcessingThread();
        if (!isWaitingForRedrawFrame()) {
            this.videoFrameProcessorListenerExecutor.execute(new Runnable() { // from class: androidx.media3.effect.FinalShaderProgramWrapper$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m10396xb5581648(j);
                }
            });
        }
        if (this.textureOutputListener == null) {
            if (this.renderFramesAutomatically) {
                renderFrame(glObjectsProvider, glTextureInfo, j, j * 1000);
                finalShaderProgramWrapper = this;
            } else {
                finalShaderProgramWrapper = this;
                finalShaderProgramWrapper.availableFrames.add(new TimedGlTextureInfo(glTextureInfo, j));
                if (finalShaderProgramWrapper.isWaitingForRedrawFrame()) {
                    if (j == finalShaderProgramWrapper.redrawFramePresentationTimeUs) {
                        finalShaderProgramWrapper.redrawFramePresentationTimeUs = -9223372036854775807L;
                        finalShaderProgramWrapper.videoFrameProcessorListenerExecutor.execute(new Runnable() { // from class: androidx.media3.effect.FinalShaderProgramWrapper$$ExternalSyntheticLambda5
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.m10397xa701bc67(j);
                            }
                        });
                        finalShaderProgramWrapper.renderFrame(glObjectsProvider, glTextureInfo, j, SystemClock.DEFAULT.nanoTime());
                        finalShaderProgramWrapper.availableFrames.clear();
                    } else {
                        finalShaderProgramWrapper.inputListener.onInputFrameProcessed(glTextureInfo);
                    }
                }
            }
            finalShaderProgramWrapper.inputListener.onReadyToAcceptInputFrame();
            return;
        }
        Preconditions.checkState(this.outputTexturePool.freeTextureCount() > 0);
        renderFrame(glObjectsProvider, glTextureInfo, j, j * 1000);
    }

    /* JADX INFO: renamed from: lambda$queueInputFrame$1$androidx-media3-effect-FinalShaderProgramWrapper, reason: not valid java name */
    /* synthetic */ void m10396xb5581648(long j) {
        this.videoFrameProcessorListener.onOutputFrameAvailableForRendering(j, false);
    }

    /* JADX INFO: renamed from: lambda$queueInputFrame$2$androidx-media3-effect-FinalShaderProgramWrapper, reason: not valid java name */
    /* synthetic */ void m10397xa701bc67(long j) {
        this.videoFrameProcessorListener.onOutputFrameAvailableForRendering(j, true);
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void releaseOutputFrame(GlTextureInfo glTextureInfo) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void flush() {
        this.videoFrameProcessingTaskExecutor.verifyVideoFrameProcessingThread();
        this.availableFrames.clear();
        this.isInputStreamEndedWithPendingAvailableFrames = false;
        DefaultShaderProgram defaultShaderProgram = this.defaultShaderProgram;
        if (defaultShaderProgram != null) {
            defaultShaderProgram.flush();
        }
        this.inputListener.onFlush();
        if (this.textureOutputListener == null) {
            for (int i = 0; i < getInputCapacity(); i++) {
                this.inputListener.onReadyToAcceptInputFrame();
            }
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void release() throws VideoFrameProcessingException {
        this.videoFrameProcessingTaskExecutor.verifyVideoFrameProcessingThread();
        DefaultShaderProgram defaultShaderProgram = this.defaultShaderProgram;
        if (defaultShaderProgram != null) {
            defaultShaderProgram.release();
            this.defaultShaderProgram = null;
        }
        try {
            try {
                this.outputTexturePool.deleteAllTextures();
                GlUtil.destroyEglSurface(this.eglDisplay, this.outputEglSurface);
                GlUtil.checkGlError();
                this.outputEglSurface = null;
            } catch (GlUtil.GlException e) {
                throw new VideoFrameProcessingException(e);
            }
        } catch (Throwable th) {
            this.outputEglSurface = null;
            throw th;
        }
    }

    public void flushFinished() {
        if (this.textureOutputListener != null) {
            this.outputTexturePool.freeAllTextures();
            this.outputTextureTimestamps.clear();
            this.syncObjects.clear();
            for (int i = 0; i < getInputCapacity(); i++) {
                this.inputListener.onReadyToAcceptInputFrame();
            }
            try {
                this.textureOutputListener.flush();
            } catch (VideoFrameProcessingException e) {
                this.videoFrameProcessorListenerExecutor.execute(new Runnable() { // from class: androidx.media3.effect.FinalShaderProgramWrapper$$ExternalSyntheticLambda9
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m10395xcf45cea4(e);
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: lambda$flushFinished$3$androidx-media3-effect-FinalShaderProgramWrapper, reason: not valid java name */
    /* synthetic */ void m10395xcf45cea4(VideoFrameProcessingException videoFrameProcessingException) {
        this.videoFrameProcessorListener.onError(videoFrameProcessingException);
    }

    public void setMatrixTransformations(List<GlMatrixTransformation> list, List<RgbMatrix> list2) {
        this.videoFrameProcessingTaskExecutor.verifyVideoFrameProcessingThread();
        this.matrixTransformations.clear();
        this.matrixTransformations.addAll(list);
        this.rgbMatrices.clear();
        this.rgbMatrices.addAll(list2);
        this.matrixTransformationsChanged = true;
    }

    public void renderOutputFrame(GlObjectsProvider glObjectsProvider, long j) {
        this.videoFrameProcessingTaskExecutor.verifyVideoFrameProcessingThread();
        if (this.textureOutputListener != null) {
            return;
        }
        Preconditions.checkState(!this.renderFramesAutomatically);
        if (this.availableFrames.isEmpty()) {
            return;
        }
        TimedGlTextureInfo timedGlTextureInfoRemove = this.availableFrames.remove();
        renderFrame(glObjectsProvider, timedGlTextureInfoRemove.glTextureInfo, timedGlTextureInfoRemove.presentationTimeUs, j);
        if (this.availableFrames.isEmpty() && this.isInputStreamEndedWithPendingAvailableFrames) {
            ((Listener) Preconditions.checkNotNull(this.listener)).onInputStreamProcessed();
            this.isInputStreamEndedWithPendingAvailableFrames = false;
        }
    }

    public void setOutputSurfaceInfo(final SurfaceInfo surfaceInfo) {
        try {
            this.videoFrameProcessingTaskExecutor.invoke(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.FinalShaderProgramWrapper$$ExternalSyntheticLambda2
                @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
                public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                    this.f$0.m10400xabcd9107(surfaceInfo);
                }
            });
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            this.videoFrameProcessorListenerExecutor.execute(new Runnable() { // from class: androidx.media3.effect.FinalShaderProgramWrapper$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m10401x9d773726(e);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$setOutputSurfaceInfo$5$androidx-media3-effect-FinalShaderProgramWrapper, reason: not valid java name */
    /* synthetic */ void m10401x9d773726(InterruptedException interruptedException) {
        this.videoFrameProcessorListener.onError(VideoFrameProcessingException.from(interruptedException));
    }

    void prepareToRedraw(long j) {
        this.redrawFramePresentationTimeUs = j;
        for (int i = 0; i < this.availableFrames.size(); i++) {
            this.inputListener.onInputFrameProcessed(this.availableFrames.remove().glTextureInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setOutputSurfaceInfoInternal, reason: merged with bridge method [inline-methods] */
    public void m10400xabcd9107(SurfaceInfo surfaceInfo) {
        if (this.textureOutputListener == null && !Objects.equals(this.outputSurfaceInfo, surfaceInfo)) {
            SurfaceInfo surfaceInfo2 = this.outputSurfaceInfo;
            if (surfaceInfo2 != null && (surfaceInfo == null || !surfaceInfo2.surface.equals(surfaceInfo.surface))) {
                destroyOutputEglSurface();
            }
            SurfaceInfo surfaceInfo3 = this.outputSurfaceInfo;
            this.outputSurfaceInfoChanged = (surfaceInfo3 != null && surfaceInfo != null && surfaceInfo3.width == surfaceInfo.width && this.outputSurfaceInfo.height == surfaceInfo.height && this.outputSurfaceInfo.orientationDegrees == surfaceInfo.orientationDegrees) ? false : true;
            this.outputSurfaceInfo = surfaceInfo;
        }
    }

    private int getInputCapacity() {
        if (this.textureOutputListener == null) {
            return 1;
        }
        return this.outputTexturePool.freeTextureCount();
    }

    private void destroyOutputEglSurface() {
        if (this.outputEglSurface == null) {
            return;
        }
        try {
            DefaultShaderProgram defaultShaderProgram = this.defaultShaderProgram;
            if (defaultShaderProgram != null) {
                defaultShaderProgram.release();
                this.defaultShaderProgram = null;
            }
            GlUtil.focusEglSurface(this.eglDisplay, this.eglContext, this.placeholderSurface, 1, 1);
            GlUtil.destroyEglSurface(this.eglDisplay, this.outputEglSurface);
        } catch (VideoFrameProcessingException e) {
            this.videoFrameProcessorListenerExecutor.execute(new Runnable() { // from class: androidx.media3.effect.FinalShaderProgramWrapper$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m10393x7e64b438(e);
                }
            });
        } catch (GlUtil.GlException e2) {
            this.videoFrameProcessorListenerExecutor.execute(new Runnable() { // from class: androidx.media3.effect.FinalShaderProgramWrapper$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m10392x8cbb0e19(e2);
                }
            });
        } finally {
            this.outputEglSurface = null;
        }
    }

    /* JADX INFO: renamed from: lambda$destroyOutputEglSurface$6$androidx-media3-effect-FinalShaderProgramWrapper, reason: not valid java name */
    /* synthetic */ void m10392x8cbb0e19(GlUtil.GlException glException) {
        this.videoFrameProcessorListener.onError(VideoFrameProcessingException.from(glException));
    }

    /* JADX INFO: renamed from: lambda$destroyOutputEglSurface$7$androidx-media3-effect-FinalShaderProgramWrapper, reason: not valid java name */
    /* synthetic */ void m10393x7e64b438(VideoFrameProcessingException videoFrameProcessingException) {
        this.videoFrameProcessorListener.onError(videoFrameProcessingException);
    }

    private boolean isWaitingForRedrawFrame() {
        return this.redrawFramePresentationTimeUs != -9223372036854775807L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001a, code lost:
    
        if (r10 != r7.redrawFramePresentationTimeUs) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void renderFrame(androidx.media3.common.GlObjectsProvider r8, androidx.media3.common.GlTextureInfo r9, final long r10, long r12) {
        /*
            r7 = this;
            r0 = -2
            int r0 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r0 == 0) goto L3f
            int r1 = r9.width     // Catch: java.lang.Throwable -> L3a
            int r2 = r9.height     // Catch: java.lang.Throwable -> L3a
            boolean r8 = r7.ensureConfigured(r8, r1, r2)     // Catch: java.lang.Throwable -> L3a
            if (r8 == 0) goto L3f
            boolean r8 = r7.isWaitingForRedrawFrame()     // Catch: java.lang.Throwable -> L3a
            if (r8 == 0) goto L23
            long r1 = r7.redrawFramePresentationTimeUs     // Catch: java.lang.Throwable -> L1d
            int r8 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r8 == 0) goto L23
            goto L3f
        L1d:
            r0 = move-exception
            r8 = r0
            r1 = r7
            r2 = r9
            r3 = r10
            goto L57
        L23:
            androidx.media3.common.SurfaceInfo r8 = r7.outputSurfaceInfo     // Catch: java.lang.Throwable -> L3a java.lang.Throwable -> L3a
            if (r8 == 0) goto L2f
            r1 = r7
            r2 = r9
            r3 = r10
            r5 = r12
            r1.renderFrameToOutputSurface(r2, r3, r5)     // Catch: java.lang.Throwable -> L55
            goto L61
        L2f:
            r1 = r7
            r2 = r9
            r3 = r10
            androidx.media3.effect.GlTextureProducer$Listener r7 = r1.textureOutputListener     // Catch: java.lang.Throwable -> L55
            if (r7 == 0) goto L61
            r1.renderFrameToOutputTexture(r2, r3)     // Catch: java.lang.Throwable -> L55
            goto L61
        L3a:
            r0 = move-exception
            r1 = r7
            r2 = r9
            r3 = r10
            goto L56
        L3f:
            r1 = r7
            r2 = r9
            r3 = r10
            androidx.media3.effect.GlShaderProgram$InputListener r7 = r1.inputListener     // Catch: java.lang.Throwable -> L55
            r7.onInputFrameProcessed(r2)     // Catch: java.lang.Throwable -> L55
            if (r0 != 0) goto L54
            androidx.media3.effect.FinalShaderProgramWrapper$Listener r7 = r1.listener     // Catch: java.lang.Throwable -> L55
            java.lang.Object r7 = com.google.common.base.Preconditions.checkNotNull(r7)     // Catch: java.lang.Throwable -> L55
            androidx.media3.effect.FinalShaderProgramWrapper$Listener r7 = (androidx.media3.effect.FinalShaderProgramWrapper.Listener) r7     // Catch: java.lang.Throwable -> L55
            r7.onFrameRendered(r3)     // Catch: java.lang.Throwable -> L55
        L54:
            return
        L55:
            r0 = move-exception
        L56:
            r8 = r0
        L57:
            java.util.concurrent.Executor r7 = r1.videoFrameProcessorListenerExecutor
            androidx.media3.effect.FinalShaderProgramWrapper$$ExternalSyntheticLambda0 r9 = new androidx.media3.effect.FinalShaderProgramWrapper$$ExternalSyntheticLambda0
            r9.<init>()
            r7.execute(r9)
        L61:
            androidx.media3.effect.GlShaderProgram$InputListener r7 = r1.inputListener
            r7.onInputFrameProcessed(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.effect.FinalShaderProgramWrapper.renderFrame(androidx.media3.common.GlObjectsProvider, androidx.media3.common.GlTextureInfo, long, long):void");
    }

    /* JADX INFO: renamed from: lambda$renderFrame$8$androidx-media3-effect-FinalShaderProgramWrapper, reason: not valid java name */
    /* synthetic */ void m10399x4bfd5cfe(Exception exc, long j) {
        this.videoFrameProcessorListener.onError(VideoFrameProcessingException.from(exc, j));
    }

    private void renderFrameToOutputSurface(GlTextureInfo glTextureInfo, long j, long j2) throws VideoFrameProcessingException, GlUtil.GlException {
        EGLSurface eGLSurface = (EGLSurface) Preconditions.checkNotNull(this.outputEglSurface);
        SurfaceInfo surfaceInfo = (SurfaceInfo) Preconditions.checkNotNull(this.outputSurfaceInfo);
        DefaultShaderProgram defaultShaderProgram = (DefaultShaderProgram) Preconditions.checkNotNull(this.defaultShaderProgram);
        GlUtil.focusEglSurface(this.eglDisplay, this.eglContext, eGLSurface, surfaceInfo.width, surfaceInfo.height);
        GlUtil.clearFocusedBuffers();
        defaultShaderProgram.drawFrame(glTextureInfo.texId, j);
        if (j2 == -3) {
            Preconditions.checkState(j != -9223372036854775807L);
            j2 = 1000 * j;
        }
        EGLExt.eglPresentationTimeANDROID(this.eglDisplay, eGLSurface, j2);
        EGL14.eglSwapBuffers(this.eglDisplay, eGLSurface);
        ((Listener) Preconditions.checkNotNull(this.listener)).onFrameRendered(j);
        DebugTraceUtil.logEvent(DebugTraceUtil.COMPONENT_VFP, DebugTraceUtil.EVENT_RENDERED_TO_OUTPUT_SURFACE, j);
    }

    private void renderFrameToOutputTexture(GlTextureInfo glTextureInfo, long j) throws VideoFrameProcessingException, GlUtil.GlException {
        GlTextureInfo glTextureInfoUseTexture = this.outputTexturePool.useTexture();
        this.outputTextureTimestamps.add(j);
        GlUtil.focusFramebufferUsingCurrentContext(glTextureInfoUseTexture.fboId, glTextureInfoUseTexture.width, glTextureInfoUseTexture.height);
        GlUtil.clearFocusedBuffers();
        ((DefaultShaderProgram) Preconditions.checkNotNull(this.defaultShaderProgram)).drawFrame(glTextureInfo.texId, j);
        long jCreateGlSyncFence = GlUtil.createGlSyncFence();
        this.syncObjects.add(jCreateGlSyncFence);
        ((GlTextureProducer.Listener) Preconditions.checkNotNull(this.textureOutputListener)).onTextureRendered(this, glTextureInfoUseTexture, j, jCreateGlSyncFence);
    }

    private boolean ensureConfigured(GlObjectsProvider glObjectsProvider, int i, int i2) throws VideoFrameProcessingException, GlUtil.GlException {
        int width;
        int height;
        boolean z = (this.inputWidth == i && this.inputHeight == i2 && this.outputSizeBeforeSurfaceTransformation != null) ? false : true;
        if (z) {
            this.inputWidth = i;
            this.inputHeight = i2;
            final Size sizeConfigureAndGetOutputSize = MatrixUtils.configureAndGetOutputSize(i, i2, this.matrixTransformations);
            if (!Objects.equals(this.outputSizeBeforeSurfaceTransformation, sizeConfigureAndGetOutputSize)) {
                this.outputSizeBeforeSurfaceTransformation = sizeConfigureAndGetOutputSize;
                this.videoFrameProcessorListenerExecutor.execute(new Runnable() { // from class: androidx.media3.effect.FinalShaderProgramWrapper$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m10394xf92f607e(sizeConfigureAndGetOutputSize);
                    }
                });
            }
        }
        Preconditions.checkNotNull(this.outputSizeBeforeSurfaceTransformation);
        SurfaceInfo surfaceInfo = this.outputSurfaceInfo;
        if (surfaceInfo == null && this.textureOutputListener == null) {
            Preconditions.checkState(this.outputEglSurface == null);
            DefaultShaderProgram defaultShaderProgram = this.defaultShaderProgram;
            if (defaultShaderProgram != null) {
                defaultShaderProgram.release();
                this.defaultShaderProgram = null;
            }
            Log.w(TAG, "Output surface and size not set, dropping frame.");
            return false;
        }
        if (surfaceInfo == null) {
            width = this.outputSizeBeforeSurfaceTransformation.getWidth();
        } else {
            width = surfaceInfo.width;
        }
        SurfaceInfo surfaceInfo2 = this.outputSurfaceInfo;
        if (surfaceInfo2 == null) {
            height = this.outputSizeBeforeSurfaceTransformation.getHeight();
        } else {
            height = surfaceInfo2.height;
        }
        SurfaceInfo surfaceInfo3 = this.outputSurfaceInfo;
        if (surfaceInfo3 != null && this.outputEglSurface == null) {
            this.outputEglSurface = glObjectsProvider.createEglSurface(this.eglDisplay, surfaceInfo3.surface, this.outputColorInfo.colorTransfer, this.outputSurfaceInfo.isEncoderInputSurface);
        }
        if (this.textureOutputListener != null) {
            this.outputTexturePool.ensureConfigured(glObjectsProvider, width, height);
        }
        DefaultShaderProgram defaultShaderProgram2 = this.defaultShaderProgram;
        if (defaultShaderProgram2 != null && (this.outputSurfaceInfoChanged || z || this.matrixTransformationsChanged)) {
            defaultShaderProgram2.release();
            this.defaultShaderProgram = null;
        }
        if (this.defaultShaderProgram == null) {
            SurfaceInfo surfaceInfo4 = this.outputSurfaceInfo;
            this.defaultShaderProgram = createDefaultShaderProgram(surfaceInfo4 == null ? 0 : surfaceInfo4.orientationDegrees, width, height);
            this.outputSurfaceInfoChanged = false;
            this.matrixTransformationsChanged = false;
        }
        return true;
    }

    /* JADX INFO: renamed from: lambda$ensureConfigured$9$androidx-media3-effect-FinalShaderProgramWrapper, reason: not valid java name */
    /* synthetic */ void m10394xf92f607e(Size size) {
        this.videoFrameProcessorListener.onOutputSizeChanged(size.getWidth(), size.getHeight());
    }

    private DefaultShaderProgram createDefaultShaderProgram(int i, int i2, int i3) throws VideoFrameProcessingException {
        ImmutableList.Builder builderAddAll = new ImmutableList.Builder().addAll((Iterable) this.matrixTransformations);
        if (i != 0) {
            builderAddAll.add(new ScaleAndRotateTransformation.Builder().setRotationDegrees(i).build());
        }
        builderAddAll.add(Presentation.createForWidthAndHeight(i2, i3, 0));
        DefaultShaderProgram defaultShaderProgramCreateApplyingOetf = DefaultShaderProgram.createApplyingOetf(this.context, builderAddAll.build(), this.rgbMatrices, this.outputColorInfo, this.sdrWorkingColorSpace);
        Size sizeConfigure = defaultShaderProgramCreateApplyingOetf.configure(this.inputWidth, this.inputHeight);
        SurfaceInfo surfaceInfo = this.outputSurfaceInfo;
        if (surfaceInfo != null) {
            SurfaceInfo surfaceInfo2 = (SurfaceInfo) Preconditions.checkNotNull(surfaceInfo);
            Preconditions.checkState(sizeConfigure.getWidth() == surfaceInfo2.width);
            Preconditions.checkState(sizeConfigure.getHeight() == surfaceInfo2.height);
        }
        return defaultShaderProgramCreateApplyingOetf;
    }
}
