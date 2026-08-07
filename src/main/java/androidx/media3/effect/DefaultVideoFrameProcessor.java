package androidx.media3.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.os.Build;
import android.util.Pair;
import android.view.Surface;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DebugViewProvider;
import androidx.media3.common.Effect;
import androidx.media3.common.Format;
import androidx.media3.common.FrameInfo;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.OnInputFrameProcessedListener;
import androidx.media3.common.SurfaceInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.VideoFrameProcessor;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.TimestampIterator;
import androidx.media3.common.util.Util;
import com.bumptech.glide.Registry;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes8.dex */
public final class DefaultVideoFrameProcessor implements VideoFrameProcessor {
    private static final String TAG = "DefaultFrameProcessor";
    public static final int WORKING_COLOR_SPACE_DEFAULT = 0;
    public static final int WORKING_COLOR_SPACE_LINEAR = 2;
    public static final int WORKING_COLOR_SPACE_ORIGINAL = 1;
    private final Context context;
    private InputStreamInfo currentInputStreamInfo;
    private final DebugViewProvider debugViewProvider;
    private final EGLDisplay eglDisplay;
    private final FinalShaderProgramWrapper finalShaderProgramWrapper;
    private final ReplayableFrameCacheGlShaderProgram frameCache;
    private final GlObjectsProvider glObjectsProvider;
    private volatile boolean inputStreamEnded;
    private final ConditionVariable inputStreamRegisteredCondition;
    private final InputSwitcher inputSwitcher;
    private final ConditionVariable isConfiguring;
    private final VideoFrameProcessor.Listener listener;
    private final Executor listenerExecutor;
    private volatile FrameInfo nextInputFrameInfo;
    private Runnable onInputSurfaceReadyListener;
    private final ColorInfo outputColorInfo;
    private InputStreamInfo pendingInputStreamInfo;
    private boolean registeredFirstInputStream;
    private volatile boolean released;
    private final boolean renderFramesAutomatically;
    private final boolean shouldReleaseGlObjectsProvider;
    private final VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor;
    private final List<Effect> activeEffects = new ArrayList();
    private final Object lock = new Object();
    private final List<GlShaderProgram> intermediateGlShaderPrograms = new ArrayList();

    public interface ReleaseOutputTextureCallback {
        void release(long j);
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface WorkingColorSpace {
    }

    static {
        MediaLibraryInfo.registerModule("media3.effect");
    }

    public static final class Factory implements VideoFrameProcessor.Factory {
        private static final String THREAD_NAME = "Effect:DefaultVideoFrameProcessor:GlThread";
        private final boolean enableReplayableCache;
        private final ExecutorService executorService;
        private final boolean experimentalAdjustSurfaceTextureTransformationMatrix;
        private final boolean experimentalRepeatInputBitmapWithoutResampling;
        private final GlObjectsProvider glObjectsProvider;
        private final boolean repeatLastRegisteredFrame;
        private final int sdrWorkingColorSpace;
        private final int textureOutputCapacity;
        private final GlTextureProducer.Listener textureOutputListener;

        /* synthetic */ Factory(int i, boolean z, GlObjectsProvider glObjectsProvider, ExecutorService executorService, GlTextureProducer.Listener listener, int i2, boolean z2, boolean z3, boolean z4, AnonymousClass1 anonymousClass1) {
            this(i, z, glObjectsProvider, executorService, listener, i2, z2, z3, z4);
        }

        public static final class Builder {
            private boolean enableReplayableCache;
            private ExecutorService executorService;
            private boolean experimentalAdjustSurfaceTextureTransformationMatrix;
            private boolean experimentalRepeatInputBitmapWithoutResampling;
            private GlObjectsProvider glObjectsProvider;
            private boolean requireRegisteringAllInputFrames;
            private int sdrWorkingColorSpace;
            private int textureOutputCapacity;
            private GlTextureProducer.Listener textureOutputListener;

            /* synthetic */ Builder(Factory factory, AnonymousClass1 anonymousClass1) {
                this(factory);
            }

            public Builder() {
                this.sdrWorkingColorSpace = 0;
                this.requireRegisteringAllInputFrames = true;
                this.experimentalAdjustSurfaceTextureTransformationMatrix = true;
                this.experimentalRepeatInputBitmapWithoutResampling = true;
            }

            private Builder(Factory factory) {
                this.sdrWorkingColorSpace = factory.sdrWorkingColorSpace;
                this.executorService = factory.executorService;
                this.glObjectsProvider = factory.glObjectsProvider;
                this.textureOutputListener = factory.textureOutputListener;
                this.textureOutputCapacity = factory.textureOutputCapacity;
                this.enableReplayableCache = factory.enableReplayableCache;
                this.requireRegisteringAllInputFrames = !factory.repeatLastRegisteredFrame;
                this.experimentalAdjustSurfaceTextureTransformationMatrix = factory.experimentalAdjustSurfaceTextureTransformationMatrix;
                this.experimentalRepeatInputBitmapWithoutResampling = factory.experimentalRepeatInputBitmapWithoutResampling;
            }

            public Builder setSdrWorkingColorSpace(int i) {
                this.sdrWorkingColorSpace = i;
                return this;
            }

            @Deprecated
            public Builder setRequireRegisteringAllInputFrames(boolean z) {
                this.requireRegisteringAllInputFrames = z;
                return this;
            }

            public Builder setGlObjectsProvider(GlObjectsProvider glObjectsProvider) {
                this.glObjectsProvider = glObjectsProvider;
                return this;
            }

            public Builder setExecutorService(ExecutorService executorService) {
                this.executorService = executorService;
                return this;
            }

            public Builder setEnableReplayableCache(boolean z) {
                this.enableReplayableCache = z;
                return this;
            }

            public Builder setTextureOutput(GlTextureProducer.Listener listener, int i) {
                this.textureOutputListener = listener;
                Preconditions.checkArgument(i >= 1);
                this.textureOutputCapacity = i;
                return this;
            }

            @Deprecated
            public Builder setExperimentalAdjustSurfaceTextureTransformationMatrix(boolean z) {
                this.experimentalAdjustSurfaceTextureTransformationMatrix = z;
                return this;
            }

            @Deprecated
            public Builder setExperimentalRepeatInputBitmapWithoutResampling(boolean z) {
                this.experimentalRepeatInputBitmapWithoutResampling = z;
                return this;
            }

            public Factory build() {
                return new Factory(this.sdrWorkingColorSpace, !this.requireRegisteringAllInputFrames, this.glObjectsProvider, this.executorService, this.textureOutputListener, this.textureOutputCapacity, this.enableReplayableCache, this.experimentalAdjustSurfaceTextureTransformationMatrix, this.experimentalRepeatInputBitmapWithoutResampling, null);
            }
        }

        private Factory(int i, boolean z, GlObjectsProvider glObjectsProvider, ExecutorService executorService, GlTextureProducer.Listener listener, int i2, boolean z2, boolean z3, boolean z4) {
            this.sdrWorkingColorSpace = i;
            this.repeatLastRegisteredFrame = z;
            this.glObjectsProvider = glObjectsProvider;
            this.executorService = executorService;
            this.textureOutputListener = listener;
            this.textureOutputCapacity = i2;
            this.enableReplayableCache = z2;
            this.experimentalAdjustSurfaceTextureTransformationMatrix = z3;
            this.experimentalRepeatInputBitmapWithoutResampling = z4;
        }

        public Builder buildUpon() {
            return new Builder(this, null);
        }

        @Override // androidx.media3.common.VideoFrameProcessor.Factory
        public DefaultVideoFrameProcessor create(final Context context, final DebugViewProvider debugViewProvider, final ColorInfo colorInfo, final boolean z, final Executor executor, final VideoFrameProcessor.Listener listener) throws VideoFrameProcessingException {
            ExecutorService executorServiceNewSingleThreadExecutor = this.executorService;
            if (executorServiceNewSingleThreadExecutor == null) {
                executorServiceNewSingleThreadExecutor = Util.newSingleThreadExecutor(THREAD_NAME);
            }
            ExecutorService executorService = executorServiceNewSingleThreadExecutor;
            boolean z2 = this.executorService == null;
            Objects.requireNonNull(listener);
            final VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor = new VideoFrameProcessingTaskExecutor(executorService, z2, new VideoFrameProcessingTaskExecutor.ErrorListener() { // from class: androidx.media3.effect.DefaultVideoFrameProcessor$Factory$$ExternalSyntheticLambda0
                @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.ErrorListener
                public final void onError(VideoFrameProcessingException videoFrameProcessingException) {
                    listener.onError(videoFrameProcessingException);
                }
            });
            GlObjectsProvider defaultGlObjectsProvider = this.glObjectsProvider;
            final boolean z3 = defaultGlObjectsProvider == null || this.executorService == null;
            if (defaultGlObjectsProvider == null) {
                defaultGlObjectsProvider = new DefaultGlObjectsProvider();
            }
            final GlObjectsProvider glObjectsProvider = defaultGlObjectsProvider;
            try {
                return (DefaultVideoFrameProcessor) executorService.submit(new Callable() { // from class: androidx.media3.effect.DefaultVideoFrameProcessor$Factory$$ExternalSyntheticLambda1
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.f$0.m10375x7d446e8(context, debugViewProvider, colorInfo, z, videoFrameProcessingTaskExecutor, executor, listener, glObjectsProvider, z3);
                    }
                }).get();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new VideoFrameProcessingException(e);
            } catch (ExecutionException e2) {
                throw new VideoFrameProcessingException(e2);
            }
        }

        /* JADX INFO: renamed from: lambda$create$0$androidx-media3-effect-DefaultVideoFrameProcessor$Factory, reason: not valid java name */
        /* synthetic */ DefaultVideoFrameProcessor m10375x7d446e8(Context context, DebugViewProvider debugViewProvider, ColorInfo colorInfo, boolean z, VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor, Executor executor, VideoFrameProcessor.Listener listener, GlObjectsProvider glObjectsProvider, boolean z2) throws Exception {
            return DefaultVideoFrameProcessor.createOpenGlObjectsAndFrameProcessor(context, debugViewProvider, colorInfo, this.sdrWorkingColorSpace, z, videoFrameProcessingTaskExecutor, executor, listener, glObjectsProvider, z2, this.enableReplayableCache, this.textureOutputListener, this.textureOutputCapacity, this.repeatLastRegisteredFrame, this.experimentalAdjustSurfaceTextureTransformationMatrix, this.experimentalRepeatInputBitmapWithoutResampling);
        }
    }

    private DefaultVideoFrameProcessor(Context context, GlObjectsProvider glObjectsProvider, boolean z, EGLDisplay eGLDisplay, InputSwitcher inputSwitcher, VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor, VideoFrameProcessor.Listener listener, Executor executor, FinalShaderProgramWrapper finalShaderProgramWrapper, boolean z2, ColorInfo colorInfo, DebugViewProvider debugViewProvider, ReplayableFrameCacheGlShaderProgram replayableFrameCacheGlShaderProgram) {
        this.context = context;
        this.glObjectsProvider = glObjectsProvider;
        this.shouldReleaseGlObjectsProvider = z;
        this.eglDisplay = eGLDisplay;
        this.inputSwitcher = inputSwitcher;
        this.videoFrameProcessingTaskExecutor = videoFrameProcessingTaskExecutor;
        this.listener = listener;
        this.listenerExecutor = executor;
        this.renderFramesAutomatically = z2;
        this.outputColorInfo = colorInfo;
        this.frameCache = replayableFrameCacheGlShaderProgram;
        this.debugViewProvider = debugViewProvider;
        this.finalShaderProgramWrapper = finalShaderProgramWrapper;
        ConditionVariable conditionVariable = new ConditionVariable();
        this.inputStreamRegisteredCondition = conditionVariable;
        conditionVariable.open();
        ConditionVariable conditionVariable2 = new ConditionVariable();
        this.isConfiguring = conditionVariable2;
        conditionVariable2.open();
        finalShaderProgramWrapper.setListener(new AnonymousClass1(executor, listener, videoFrameProcessingTaskExecutor, replayableFrameCacheGlShaderProgram));
    }

    /* JADX INFO: renamed from: androidx.media3.effect.DefaultVideoFrameProcessor$1, reason: invalid class name */
    class AnonymousClass1 implements FinalShaderProgramWrapper.Listener {
        final /* synthetic */ ReplayableFrameCacheGlShaderProgram val$frameCache;
        final /* synthetic */ VideoFrameProcessor.Listener val$listener;
        final /* synthetic */ Executor val$listenerExecutor;
        final /* synthetic */ VideoFrameProcessingTaskExecutor val$videoFrameProcessingTaskExecutor;

        AnonymousClass1(Executor executor, VideoFrameProcessor.Listener listener, VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor, ReplayableFrameCacheGlShaderProgram replayableFrameCacheGlShaderProgram) {
            this.val$listenerExecutor = executor;
            this.val$listener = listener;
            this.val$videoFrameProcessingTaskExecutor = videoFrameProcessingTaskExecutor;
            this.val$frameCache = replayableFrameCacheGlShaderProgram;
        }

        @Override // androidx.media3.effect.FinalShaderProgramWrapper.Listener
        public void onInputStreamProcessed() {
            if (DefaultVideoFrameProcessor.this.inputStreamEnded) {
                Executor executor = this.val$listenerExecutor;
                final VideoFrameProcessor.Listener listener = this.val$listener;
                Objects.requireNonNull(listener);
                executor.execute(new Runnable() { // from class: androidx.media3.effect.DefaultVideoFrameProcessor$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        listener.onEnded();
                    }
                });
                DebugTraceUtil.logEvent(DebugTraceUtil.COMPONENT_VFP, DebugTraceUtil.EVENT_SIGNAL_ENDED, Long.MIN_VALUE);
                return;
            }
            VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor = this.val$videoFrameProcessingTaskExecutor;
            final DefaultVideoFrameProcessor defaultVideoFrameProcessor = DefaultVideoFrameProcessor.this;
            videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.DefaultVideoFrameProcessor$1$$ExternalSyntheticLambda1
                @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
                public final void run() throws VideoFrameProcessingException {
                    defaultVideoFrameProcessor.configurePendingInputStream();
                }
            });
        }

        @Override // androidx.media3.effect.FinalShaderProgramWrapper.Listener
        public void onFrameRendered(long j) {
            ReplayableFrameCacheGlShaderProgram replayableFrameCacheGlShaderProgram = this.val$frameCache;
            if (replayableFrameCacheGlShaderProgram == null) {
                return;
            }
            replayableFrameCacheGlShaderProgram.onFrameRendered(j);
        }
    }

    public VideoFrameProcessingTaskExecutor getTaskExecutor() {
        return this.videoFrameProcessingTaskExecutor;
    }

    @Deprecated
    public void setInputDefaultBufferSize(int i, int i2) {
        this.inputSwitcher.setInputDefaultBufferSize(i, i2);
    }

    @Override // androidx.media3.common.VideoFrameProcessor
    public boolean queueInputBitmap(Bitmap bitmap, TimestampIterator timestampIterator) {
        Preconditions.checkState(!this.inputStreamEnded);
        boolean z = false;
        if (!this.inputStreamRegisteredCondition.isOpen() || this.released) {
            return false;
        }
        if (ColorInfo.isTransferHdr(this.outputColorInfo)) {
            if (Build.VERSION.SDK_INT >= 34 && bitmap.hasGainmap()) {
                z = true;
            }
            Preconditions.checkArgument(z, "VideoFrameProcessor configured for HDR output, but either received SDR input, or is on an API level that doesn't support gainmaps. SDR to HDR tonemapping is not supported.");
        }
        this.inputSwitcher.activeTextureManager().queueInputBitmap(bitmap, (FrameInfo) Preconditions.checkNotNull(this.nextInputFrameInfo), timestampIterator);
        return true;
    }

    @Override // androidx.media3.common.VideoFrameProcessor
    public boolean queueInputTexture(int i, long j) {
        Preconditions.checkState(!this.inputStreamEnded);
        if (!this.inputStreamRegisteredCondition.isOpen() || this.released) {
            return false;
        }
        this.inputSwitcher.activeTextureManager().queueInputTexture(i, j);
        return true;
    }

    @Override // androidx.media3.common.VideoFrameProcessor
    public void setOnInputFrameProcessedListener(OnInputFrameProcessedListener onInputFrameProcessedListener) {
        this.inputSwitcher.setOnInputFrameProcessedListener(onInputFrameProcessedListener);
    }

    @Override // androidx.media3.common.VideoFrameProcessor
    public void setOnInputSurfaceReadyListener(Runnable runnable) {
        synchronized (this.lock) {
            if (this.inputStreamRegisteredCondition.isOpen()) {
                runnable.run();
            } else {
                this.onInputSurfaceReadyListener = runnable;
            }
        }
    }

    @Override // androidx.media3.common.VideoFrameProcessor
    public Surface getInputSurface() {
        return this.inputSwitcher.getInputSurface();
    }

    @Override // androidx.media3.common.VideoFrameProcessor
    public void redraw() {
        ReplayableFrameCacheGlShaderProgram replayableFrameCacheGlShaderProgram = this.frameCache;
        if (replayableFrameCacheGlShaderProgram == null) {
            throw new UnsupportedOperationException("Replaying when enableReplayableCache is set to false");
        }
        if (replayableFrameCacheGlShaderProgram.isEmpty()) {
            return;
        }
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.DefaultVideoFrameProcessor$$ExternalSyntheticLambda1
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f$0.m10371xfa81421d();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$redraw$0$androidx-media3-effect-DefaultVideoFrameProcessor, reason: not valid java name */
    /* synthetic */ void m10371xfa81421d() throws VideoFrameProcessingException, GlUtil.GlException {
        this.finalShaderProgramWrapper.prepareToRedraw(((ReplayableFrameCacheGlShaderProgram) Util.castNonNull(this.frameCache)).getReplayFramePresentationTimeUs());
        this.frameCache.replayFrame();
    }

    @Override // androidx.media3.common.VideoFrameProcessor
    public void registerInputStream(int i, Format format, List<Effect> list, long j) {
        if (this.released) {
            return;
        }
        DebugTraceUtil.logEvent(DebugTraceUtil.COMPONENT_VFP, DebugTraceUtil.EVENT_REGISTER_NEW_INPUT_STREAM, j, "InputType %s - %dx%d", getInputTypeString(i), Integer.valueOf(format.width), Integer.valueOf(format.height));
        this.nextInputFrameInfo = new FrameInfo(adjustForPixelWidthHeightRatio(format), j);
        try {
            this.inputStreamRegisteredCondition.block();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            this.listenerExecutor.execute(new Runnable() { // from class: androidx.media3.effect.DefaultVideoFrameProcessor$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m10372xc3d52c54(e);
                }
            });
        }
        synchronized (this.lock) {
            final InputStreamInfo inputStreamInfo = new InputStreamInfo(i, format, list, j);
            if (!this.registeredFirstInputStream) {
                this.registeredFirstInputStream = true;
                this.inputStreamRegisteredCondition.close();
                this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.DefaultVideoFrameProcessor$$ExternalSyntheticLambda4
                    @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
                    public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                        this.f$0.m10373x7604a15(inputStreamInfo);
                    }
                });
            } else {
                this.pendingInputStreamInfo = inputStreamInfo;
                this.inputStreamRegisteredCondition.close();
                this.inputSwitcher.signalEndOfCurrentInputStream();
            }
        }
    }

    /* JADX INFO: renamed from: lambda$registerInputStream$1$androidx-media3-effect-DefaultVideoFrameProcessor, reason: not valid java name */
    /* synthetic */ void m10372xc3d52c54(InterruptedException interruptedException) {
        this.listener.onError(VideoFrameProcessingException.from(interruptedException));
    }

    /* JADX INFO: renamed from: lambda$registerInputStream$2$androidx-media3-effect-DefaultVideoFrameProcessor, reason: not valid java name */
    /* synthetic */ void m10373x7604a15(InputStreamInfo inputStreamInfo) throws VideoFrameProcessingException, GlUtil.GlException {
        configure(inputStreamInfo, true);
    }

    @Override // androidx.media3.common.VideoFrameProcessor
    public boolean registerInputFrame() {
        Preconditions.checkState(!this.inputStreamEnded);
        Preconditions.checkNotNull(this.nextInputFrameInfo, "registerInputStream must be called before registering input frames");
        if (!this.inputStreamRegisteredCondition.isOpen() || this.released) {
            return false;
        }
        this.inputSwitcher.activeTextureManager().registerInputFrame(this.nextInputFrameInfo);
        return true;
    }

    @Override // androidx.media3.common.VideoFrameProcessor
    public int getPendingInputFrameCount() {
        if (this.inputSwitcher.hasActiveInput()) {
            return this.inputSwitcher.activeTextureManager().getPendingFrameCount();
        }
        return 0;
    }

    @Override // androidx.media3.common.VideoFrameProcessor
    public void setOutputSurfaceInfo(SurfaceInfo surfaceInfo) {
        this.finalShaderProgramWrapper.setOutputSurfaceInfo(surfaceInfo);
    }

    @Override // androidx.media3.common.VideoFrameProcessor
    public void renderOutputFrame(final long j) {
        Preconditions.checkState(!this.renderFramesAutomatically, "Calling this method is not allowed when renderFramesAutomatically is enabled");
        this.videoFrameProcessingTaskExecutor.submitWithHighPriority(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.DefaultVideoFrameProcessor$$ExternalSyntheticLambda11
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f$0.m10374xedda5745(j);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$renderOutputFrame$3$androidx-media3-effect-DefaultVideoFrameProcessor, reason: not valid java name */
    /* synthetic */ void m10374xedda5745(long j) throws VideoFrameProcessingException, GlUtil.GlException {
        this.finalShaderProgramWrapper.renderOutputFrame(this.glObjectsProvider, j);
    }

    @Override // androidx.media3.common.VideoFrameProcessor
    public void signalEndOfInput() {
        DebugTraceUtil.logEvent(DebugTraceUtil.COMPONENT_VFP, DebugTraceUtil.EVENT_RECEIVE_END_OF_ALL_INPUT, Long.MIN_VALUE);
        Preconditions.checkState(!this.inputStreamEnded);
        this.inputStreamEnded = true;
        if (this.released) {
            return;
        }
        this.inputSwitcher.signalEndOfCurrentInputStream();
    }

    @Override // androidx.media3.common.VideoFrameProcessor
    public void flush() {
        try {
            this.isConfiguring.block();
            this.inputStreamEnded = false;
            if (this.inputSwitcher.hasActiveInput()) {
                TextureManager textureManagerActiveTextureManager = this.inputSwitcher.activeTextureManager();
                textureManagerActiveTextureManager.dropIncomingRegisteredFrames();
                this.videoFrameProcessingTaskExecutor.flush();
                textureManagerActiveTextureManager.releaseAllRegisteredFrames();
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                Objects.requireNonNull(countDownLatch);
                textureManagerActiveTextureManager.setOnFlushCompleteListener(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.DefaultVideoFrameProcessor$$ExternalSyntheticLambda5
                    @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
                    public final void run() {
                        countDownLatch.countDown();
                    }
                });
                VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor = this.videoFrameProcessingTaskExecutor;
                final FinalShaderProgramWrapper finalShaderProgramWrapper = this.finalShaderProgramWrapper;
                Objects.requireNonNull(finalShaderProgramWrapper);
                videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.DefaultVideoFrameProcessor$$ExternalSyntheticLambda6
                    @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
                    public final void run() {
                        finalShaderProgramWrapper.flush();
                    }
                });
                countDownLatch.await();
                textureManagerActiveTextureManager.setOnFlushCompleteListener(null);
                VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor2 = this.videoFrameProcessingTaskExecutor;
                final FinalShaderProgramWrapper finalShaderProgramWrapper2 = this.finalShaderProgramWrapper;
                Objects.requireNonNull(finalShaderProgramWrapper2);
                videoFrameProcessingTaskExecutor2.invoke(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.DefaultVideoFrameProcessor$$ExternalSyntheticLambda7
                    @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
                    public final void run() {
                        finalShaderProgramWrapper2.flushFinished();
                    }
                });
                this.videoFrameProcessingTaskExecutor.invoke(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.DefaultVideoFrameProcessor$$ExternalSyntheticLambda8
                    @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
                    public final void run() throws VideoFrameProcessingException {
                        this.f$0.configurePendingInputStream();
                    }
                });
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            this.listenerExecutor.execute(new Runnable() { // from class: androidx.media3.effect.DefaultVideoFrameProcessor$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m10370lambda$flush$4$androidxmedia3effectDefaultVideoFrameProcessor(e);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$flush$4$androidx-media3-effect-DefaultVideoFrameProcessor, reason: not valid java name */
    /* synthetic */ void m10370lambda$flush$4$androidxmedia3effectDefaultVideoFrameProcessor(InterruptedException interruptedException) {
        this.listener.onError(new VideoFrameProcessingException(interruptedException));
    }

    @Override // androidx.media3.common.VideoFrameProcessor
    public void release() {
        this.released = true;
        try {
            this.videoFrameProcessingTaskExecutor.release(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.DefaultVideoFrameProcessor$$ExternalSyntheticLambda12
                @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
                public final void run() {
                    this.f$0.releaseGlObjects();
                }
            });
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException(e);
        }
    }

    private Format adjustForPixelWidthHeightRatio(Format format) {
        if (format.pixelWidthHeightRatio > 1.0f) {
            return format.buildUpon().setWidth((int) (format.width * format.pixelWidthHeightRatio)).setPixelWidthHeightRatio(1.0f).build();
        }
        return format.pixelWidthHeightRatio < 1.0f ? format.buildUpon().setHeight((int) (format.height / format.pixelWidthHeightRatio)).setPixelWidthHeightRatio(1.0f).build() : format;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void configurePendingInputStream() throws VideoFrameProcessingException {
        InputStreamInfo inputStreamInfo;
        this.videoFrameProcessingTaskExecutor.verifyVideoFrameProcessingThread();
        synchronized (this.lock) {
            inputStreamInfo = this.pendingInputStreamInfo;
            if (inputStreamInfo != null) {
                this.pendingInputStreamInfo = null;
            } else {
                inputStreamInfo = null;
            }
        }
        if (inputStreamInfo != null) {
            configure(inputStreamInfo, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:15:0x007e  */
    /* JADX WARN: Code duplicated, block: B:16:0x009a  */
    public static DefaultVideoFrameProcessor createOpenGlObjectsAndFrameProcessor(Context context, DebugViewProvider debugViewProvider, ColorInfo colorInfo, int i, boolean z, VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor, Executor executor, VideoFrameProcessor.Listener listener, GlObjectsProvider glObjectsProvider, boolean z2, boolean z3, GlTextureProducer.Listener listener2, int i2, boolean z4, boolean z5, boolean z6) throws VideoFrameProcessingException, GlUtil.GlException {
        int[] iArr;
        int i3;
        ColorInfo colorInfo2;
        ReplayableFrameCacheGlShaderProgram replayableFrameCacheGlShaderProgram;
        Context context2;
        EGLDisplay defaultEglDisplay = GlUtil.getDefaultEglDisplay();
        boolean zIsTransferHdr = ColorInfo.isTransferHdr(colorInfo);
        if (zIsTransferHdr) {
            iArr = GlUtil.EGL_CONFIG_ATTRIBUTES_RGBA_1010102;
        } else {
            iArr = GlUtil.EGL_CONFIG_ATTRIBUTES_RGBA_8888;
        }
        Pair<EGLContext, EGLSurface> pairCreateFocusedEglContextWithFallback = createFocusedEglContextWithFallback(glObjectsProvider, defaultEglDisplay, iArr);
        ColorInfo colorInfoBuild = colorInfo.buildUpon().setColorTransfer(1).setHdrStaticInfo(null).build();
        if (!zIsTransferHdr) {
            i3 = i;
            if (i3 != 2) {
                colorInfo2 = colorInfo;
            }
            Objects.requireNonNull(listener);
            InputSwitcher inputSwitcher = new InputSwitcher(context, colorInfo2, glObjectsProvider, videoFrameProcessingTaskExecutor, executor, new DefaultVideoFrameProcessor$$ExternalSyntheticLambda10(listener), i3, z4, z5, z6);
            FinalShaderProgramWrapper finalShaderProgramWrapper = new FinalShaderProgramWrapper(context, defaultEglDisplay, (EGLContext) pairCreateFocusedEglContextWithFallback.first, (EGLSurface) pairCreateFocusedEglContextWithFallback.second, colorInfo, videoFrameProcessingTaskExecutor, executor, listener, listener2, i2, i, z);
            if (z3) {
                context2 = context;
                replayableFrameCacheGlShaderProgram = new ReplayableFrameCacheGlShaderProgram(context, zIsTransferHdr);
            } else {
                replayableFrameCacheGlShaderProgram = null;
                context2 = context;
            }
            new DefaultVideoFrameProcessor(context2, glObjectsProvider, z2, defaultEglDisplay, inputSwitcher, videoFrameProcessingTaskExecutor, listener, executor, finalShaderProgramWrapper, z, colorInfo, debugViewProvider, replayableFrameCacheGlShaderProgram);
            return r1;
        }
        i3 = i;
        colorInfo2 = colorInfoBuild;
        Objects.requireNonNull(listener);
        InputSwitcher inputSwitcher2 = new InputSwitcher(context, colorInfo2, glObjectsProvider, videoFrameProcessingTaskExecutor, executor, new DefaultVideoFrameProcessor$$ExternalSyntheticLambda10(listener), i3, z4, z5, z6);
        FinalShaderProgramWrapper finalShaderProgramWrapper2 = new FinalShaderProgramWrapper(context, defaultEglDisplay, (EGLContext) pairCreateFocusedEglContextWithFallback.first, (EGLSurface) pairCreateFocusedEglContextWithFallback.second, colorInfo, videoFrameProcessingTaskExecutor, executor, listener, listener2, i2, i, z);
        if (z3) {
            context2 = context;
            replayableFrameCacheGlShaderProgram = new ReplayableFrameCacheGlShaderProgram(context, zIsTransferHdr);
        } else {
            replayableFrameCacheGlShaderProgram = null;
            context2 = context;
        }
        new DefaultVideoFrameProcessor(context2, glObjectsProvider, z2, defaultEglDisplay, inputSwitcher2, videoFrameProcessingTaskExecutor, listener, executor, finalShaderProgramWrapper2, z, colorInfo, debugViewProvider, replayableFrameCacheGlShaderProgram);
        return r1;
    }

    private static ImmutableList<GlShaderProgram> createGlShaderPrograms(Context context, List<Effect> list, ColorInfo colorInfo, FinalShaderProgramWrapper finalShaderProgramWrapper) throws VideoFrameProcessingException {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        ImmutableList.Builder builder2 = new ImmutableList.Builder();
        ImmutableList.Builder builder3 = new ImmutableList.Builder();
        for (int i = 0; i < list.size(); i++) {
            Effect effect = list.get(i);
            Preconditions.checkArgument(effect instanceof GlEffect, "DefaultVideoFrameProcessor only supports GlEffects");
            GlEffect glEffect = (GlEffect) effect;
            if (glEffect instanceof GlMatrixTransformation) {
                builder2.add((GlMatrixTransformation) glEffect);
            } else if (glEffect instanceof RgbMatrix) {
                builder3.add((RgbMatrix) glEffect);
            } else {
                boolean zIsTransferHdr = ColorInfo.isTransferHdr(colorInfo);
                ImmutableList immutableListBuild = builder2.build();
                ImmutableList immutableListBuild2 = builder3.build();
                if (!immutableListBuild.isEmpty() || !immutableListBuild2.isEmpty()) {
                    builder.add(DefaultShaderProgram.create(context, immutableListBuild, immutableListBuild2, zIsTransferHdr));
                    builder2 = new ImmutableList.Builder();
                    builder3 = new ImmutableList.Builder();
                }
                builder.add(glEffect.toGlShaderProgram(context, zIsTransferHdr));
            }
        }
        finalShaderProgramWrapper.setMatrixTransformations(builder2.build(), builder3.build());
        return builder.build();
    }

    private static void chainShaderProgramsWithListeners(GlObjectsProvider glObjectsProvider, List<GlShaderProgram> list, FinalShaderProgramWrapper finalShaderProgramWrapper, VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor, VideoFrameProcessor.Listener listener, Executor executor) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.add(finalShaderProgramWrapper);
        int i = 0;
        while (i < arrayList.size() - 1) {
            GlShaderProgram glShaderProgram = (GlShaderProgram) arrayList.get(i);
            i++;
            GlShaderProgram glShaderProgram2 = (GlShaderProgram) arrayList.get(i);
            ChainingGlShaderProgramListener chainingGlShaderProgramListener = new ChainingGlShaderProgramListener(glObjectsProvider, glShaderProgram, glShaderProgram2, videoFrameProcessingTaskExecutor);
            glShaderProgram.setOutputListener(chainingGlShaderProgramListener);
            Objects.requireNonNull(listener);
            glShaderProgram.setErrorListener(executor, new DefaultVideoFrameProcessor$$ExternalSyntheticLambda10(listener));
            glShaderProgram2.setInputListener(chainingGlShaderProgramListener);
        }
    }

    private static String getInputTypeString(int i) {
        if (i == 1) {
            return "Surface";
        }
        if (i == 2) {
            return Registry.BUCKET_BITMAP;
        }
        if (i == 3) {
            return "Texture ID";
        }
        if (i == 4) {
            return "Surface with automatic frame registration";
        }
        throw new IllegalArgumentException(String.valueOf(i));
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002e A[Catch: all -> 0x0021, LOOP:0: B:10:0x0026->B:12:0x002e, LOOP_END, TryCatch #0 {all -> 0x0021, blocks: (B:4:0x0016, B:21:0x00b6, B:23:0x00ba, B:24:0x00bd, B:25:0x00d4, B:30:0x00e0, B:32:0x00ee, B:35:0x0106, B:34:0x00fc, B:41:0x0111, B:10:0x0026, B:12:0x002e, B:13:0x003c, B:15:0x0052, B:16:0x005e, B:18:0x007a, B:20:0x0094, B:19:0x0085, B:26:0x00d5, B:28:0x00d9, B:29:0x00df), top: B:44:0x0016, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:15:0x0052 A[Catch: all -> 0x0021, TryCatch #0 {all -> 0x0021, blocks: (B:4:0x0016, B:21:0x00b6, B:23:0x00ba, B:24:0x00bd, B:25:0x00d4, B:30:0x00e0, B:32:0x00ee, B:35:0x0106, B:34:0x00fc, B:41:0x0111, B:10:0x0026, B:12:0x002e, B:13:0x003c, B:15:0x0052, B:16:0x005e, B:18:0x007a, B:20:0x0094, B:19:0x0085, B:26:0x00d5, B:28:0x00d9, B:29:0x00df), top: B:44:0x0016, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:18:0x007a A[Catch: all -> 0x0021, TryCatch #0 {all -> 0x0021, blocks: (B:4:0x0016, B:21:0x00b6, B:23:0x00ba, B:24:0x00bd, B:25:0x00d4, B:30:0x00e0, B:32:0x00ee, B:35:0x0106, B:34:0x00fc, B:41:0x0111, B:10:0x0026, B:12:0x002e, B:13:0x003c, B:15:0x0052, B:16:0x005e, B:18:0x007a, B:20:0x0094, B:19:0x0085, B:26:0x00d5, B:28:0x00d9, B:29:0x00df), top: B:44:0x0016, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x0085 A[Catch: all -> 0x0021, TryCatch #0 {all -> 0x0021, blocks: (B:4:0x0016, B:21:0x00b6, B:23:0x00ba, B:24:0x00bd, B:25:0x00d4, B:30:0x00e0, B:32:0x00ee, B:35:0x0106, B:34:0x00fc, B:41:0x0111, B:10:0x0026, B:12:0x002e, B:13:0x003c, B:15:0x0052, B:16:0x005e, B:18:0x007a, B:20:0x0094, B:19:0x0085, B:26:0x00d5, B:28:0x00d9, B:29:0x00df), top: B:44:0x0016, inners: #1 }] */
    private void configure(final InputStreamInfo inputStreamInfo, boolean z) throws VideoFrameProcessingException {
        int i;
        ImmutableList.Builder builderAddAll;
        ImmutableList.Builder builder;
        ReplayableFrameCacheGlShaderProgram replayableFrameCacheGlShaderProgram;
        checkColors((ColorInfo) Preconditions.checkNotNull(inputStreamInfo.format.colorInfo), this.outputColorInfo);
        this.isConfiguring.close();
        if (!z) {
            try {
                if (!this.activeEffects.equals(inputStreamInfo.effects)) {
                    for (i = 0; i < this.intermediateGlShaderPrograms.size(); i++) {
                        this.intermediateGlShaderPrograms.get(i).release();
                    }
                    this.intermediateGlShaderPrograms.clear();
                    builderAddAll = new ImmutableList.Builder().addAll((Iterable) inputStreamInfo.effects);
                    if (this.debugViewProvider != DebugViewProvider.NONE) {
                        builderAddAll.add(new DebugViewEffect(this.debugViewProvider, this.outputColorInfo));
                    }
                    this.intermediateGlShaderPrograms.addAll(createGlShaderPrograms(this.context, builderAddAll.build(), this.outputColorInfo, this.finalShaderProgramWrapper));
                    builder = new ImmutableList.Builder();
                    replayableFrameCacheGlShaderProgram = this.frameCache;
                    if (replayableFrameCacheGlShaderProgram != null) {
                        this.inputSwitcher.setDownstreamShaderProgram(replayableFrameCacheGlShaderProgram);
                        builder.add(this.frameCache);
                    } else {
                        this.inputSwitcher.setDownstreamShaderProgram((GlShaderProgram) Iterables.getFirst(this.intermediateGlShaderPrograms, this.finalShaderProgramWrapper));
                    }
                    builder.addAll((Iterable) this.intermediateGlShaderPrograms);
                    chainShaderProgramsWithListeners(this.glObjectsProvider, builder.build(), this.finalShaderProgramWrapper, this.videoFrameProcessingTaskExecutor, this.listener, this.listenerExecutor);
                    this.activeEffects.clear();
                    this.activeEffects.addAll(inputStreamInfo.effects);
                }
            } catch (Throwable th) {
                this.isConfiguring.open();
                throw th;
            }
            this.isConfiguring.open();
            throw th;
        }
        while (i < this.intermediateGlShaderPrograms.size()) {
            this.intermediateGlShaderPrograms.get(i).release();
        }
        this.intermediateGlShaderPrograms.clear();
        builderAddAll = new ImmutableList.Builder().addAll((Iterable) inputStreamInfo.effects);
        if (this.debugViewProvider != DebugViewProvider.NONE) {
            builderAddAll.add(new DebugViewEffect(this.debugViewProvider, this.outputColorInfo));
        }
        this.intermediateGlShaderPrograms.addAll(createGlShaderPrograms(this.context, builderAddAll.build(), this.outputColorInfo, this.finalShaderProgramWrapper));
        builder = new ImmutableList.Builder();
        replayableFrameCacheGlShaderProgram = this.frameCache;
        if (replayableFrameCacheGlShaderProgram != null) {
            this.inputSwitcher.setDownstreamShaderProgram(replayableFrameCacheGlShaderProgram);
            builder.add(this.frameCache);
        } else {
            this.inputSwitcher.setDownstreamShaderProgram((GlShaderProgram) Iterables.getFirst(this.intermediateGlShaderPrograms, this.finalShaderProgramWrapper));
        }
        builder.addAll((Iterable) this.intermediateGlShaderPrograms);
        chainShaderProgramsWithListeners(this.glObjectsProvider, builder.build(), this.finalShaderProgramWrapper, this.videoFrameProcessingTaskExecutor, this.listener, this.listenerExecutor);
        this.activeEffects.clear();
        this.activeEffects.addAll(inputStreamInfo.effects);
        ReplayableFrameCacheGlShaderProgram replayableFrameCacheGlShaderProgram2 = this.frameCache;
        if (replayableFrameCacheGlShaderProgram2 != null) {
            replayableFrameCacheGlShaderProgram2.onNewInputStream();
        }
        this.inputSwitcher.switchToInput(inputStreamInfo.inputType, new FrameInfo(inputStreamInfo.format, inputStreamInfo.offsetToAddUs));
        this.inputStreamRegisteredCondition.open();
        synchronized (this.lock) {
            Runnable runnable = this.onInputSurfaceReadyListener;
            if (runnable != null) {
                runnable.run();
                this.onInputSurfaceReadyListener = null;
            }
        }
        this.listenerExecutor.execute(new Runnable() { // from class: androidx.media3.effect.DefaultVideoFrameProcessor$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m10368x9bcdeb37(inputStreamInfo);
            }
        });
        if (this.currentInputStreamInfo == null || inputStreamInfo.format.frameRate != this.currentInputStreamInfo.format.frameRate) {
            this.listenerExecutor.execute(new Runnable() { // from class: androidx.media3.effect.DefaultVideoFrameProcessor$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m10369xdf5908f8(inputStreamInfo);
                }
            });
        }
        this.currentInputStreamInfo = inputStreamInfo;
        this.isConfiguring.open();
    }

    /* JADX INFO: renamed from: lambda$configure$5$androidx-media3-effect-DefaultVideoFrameProcessor, reason: not valid java name */
    /* synthetic */ void m10368x9bcdeb37(InputStreamInfo inputStreamInfo) {
        this.listener.onInputStreamRegistered(inputStreamInfo.inputType, inputStreamInfo.format, inputStreamInfo.effects);
    }

    /* JADX INFO: renamed from: lambda$configure$6$androidx-media3-effect-DefaultVideoFrameProcessor, reason: not valid java name */
    /* synthetic */ void m10369xdf5908f8(InputStreamInfo inputStreamInfo) {
        this.listener.onOutputFrameRateChanged(inputStreamInfo.format.frameRate);
    }

    private static void checkColors(ColorInfo colorInfo, ColorInfo colorInfo2) throws VideoFrameProcessingException {
        if (ColorInfo.isTransferHdr(colorInfo)) {
            Preconditions.checkArgument(colorInfo.colorSpace == 6);
        }
        if (ColorInfo.isTransferHdr(colorInfo) || ColorInfo.isTransferHdr(colorInfo2)) {
            try {
                if (GlUtil.getContextMajorVersion() != 3) {
                    throw new VideoFrameProcessingException("OpenGL ES 3.0 context support is required for HDR input or output.");
                }
            } catch (GlUtil.GlException e) {
                throw VideoFrameProcessingException.from(e);
            }
        }
        Preconditions.checkArgument(colorInfo.isDataSpaceValid());
        Preconditions.checkArgument(colorInfo.colorTransfer != 1);
        Preconditions.checkArgument(colorInfo2.isDataSpaceValid());
        Preconditions.checkArgument(colorInfo2.colorTransfer != 1);
        if (ColorInfo.isTransferHdr(colorInfo) != ColorInfo.isTransferHdr(colorInfo2)) {
            Preconditions.checkArgument(isSupportedToneMapping(colorInfo, colorInfo2) || isUltraHdr(colorInfo, colorInfo2));
        }
    }

    private static boolean isSupportedToneMapping(ColorInfo colorInfo, ColorInfo colorInfo2) {
        if (colorInfo.colorSpace == 6 && colorInfo2.colorSpace != 6 && ColorInfo.isTransferHdr(colorInfo)) {
            return colorInfo2.colorTransfer == 10 || colorInfo2.colorTransfer == 3;
        }
        return false;
    }

    private static boolean isUltraHdr(ColorInfo colorInfo, ColorInfo colorInfo2) {
        return colorInfo.equals(ColorInfo.SRGB_BT709_FULL) && colorInfo2.colorSpace == 6 && ColorInfo.isTransferHdr(colorInfo2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseGlObjects() {
        try {
            try {
                this.inputSwitcher.release();
                ReplayableFrameCacheGlShaderProgram replayableFrameCacheGlShaderProgram = this.frameCache;
                if (replayableFrameCacheGlShaderProgram != null) {
                    replayableFrameCacheGlShaderProgram.release();
                }
                for (int i = 0; i < this.intermediateGlShaderPrograms.size(); i++) {
                    this.intermediateGlShaderPrograms.get(i).release();
                }
                this.finalShaderProgramWrapper.release();
            } catch (Exception e) {
                Log.e(TAG, "Error releasing shader program", e);
            }
        } finally {
            if (this.shouldReleaseGlObjectsProvider) {
                try {
                    this.glObjectsProvider.release(this.eglDisplay);
                } catch (GlUtil.GlException e2) {
                    Log.e(TAG, "Error releasing GL objects", e2);
                }
            }
        }
    }

    private static Pair<EGLContext, EGLSurface> createFocusedEglContextWithFallback(GlObjectsProvider glObjectsProvider, EGLDisplay eGLDisplay, int[] iArr) throws GlUtil.GlException {
        try {
            return createFocusedEglContext(glObjectsProvider, eGLDisplay, 3, iArr);
        } catch (GlUtil.GlException unused) {
            return createFocusedEglContext(glObjectsProvider, eGLDisplay, 2, iArr);
        }
    }

    private static Pair<EGLContext, EGLSurface> createFocusedEglContext(GlObjectsProvider glObjectsProvider, EGLDisplay eGLDisplay, int i, int[] iArr) throws GlUtil.GlException {
        EGLContext eGLContextCreateEglContext = glObjectsProvider.createEglContext(eGLDisplay, i, iArr);
        return Pair.create(eGLContextCreateEglContext, glObjectsProvider.createFocusedPlaceholderEglSurface(eGLContextCreateEglContext, eGLDisplay));
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class InputStreamInfo {
        public final List<Effect> effects;
        public final Format format;
        public final int inputType;
        public final long offsetToAddUs;

        public InputStreamInfo(int i, Format format, List<Effect> list, long j) {
            this.inputType = i;
            this.format = format;
            this.effects = list;
            this.offsetToAddUs = j;
        }
    }
}
