package androidx.media3.effect;

import android.util.Pair;
import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Consumer;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes8.dex */
public final class GlShaderProgramFrameProcessor implements FrameProcessor<GlTextureFrame, GlTextureFrame>, GlShaderProgram.InputListener, GlShaderProgram.OutputListener, GlShaderProgram.ErrorListener {
    private GlTextureFrame currentInputFrame;
    private Frame.Metadata currentInputMetadata;
    private GlTextureFrame currentProcessedFrame;
    private FrameConsumer<GlTextureFrame> downstreamConsumer;
    private final GlObjectsProvider glObjectsProvider;
    private final ListeningExecutorService glThreadExecutorService;
    private final GlShaderProgram shaderProgram;
    private final InputConsumer inputConsumer = new InputConsumer();
    private final AtomicBoolean canAcceptInput = new AtomicBoolean(false);
    private final AtomicReference<Pair<Executor, Consumer<VideoFrameProcessingException>>> onErrorCallbackReference = new AtomicReference<>(null);
    private final AtomicBoolean isReleased = new AtomicBoolean();

    public static GlShaderProgramFrameProcessor create(ListeningExecutorService listeningExecutorService, GlShaderProgram glShaderProgram, GlObjectsProvider glObjectsProvider) {
        GlShaderProgramFrameProcessor glShaderProgramFrameProcessor = new GlShaderProgramFrameProcessor(listeningExecutorService, glShaderProgram, glObjectsProvider);
        glShaderProgram.setInputListener(glShaderProgramFrameProcessor);
        glShaderProgram.setOutputListener(glShaderProgramFrameProcessor);
        glShaderProgram.setErrorListener(listeningExecutorService, glShaderProgramFrameProcessor);
        return glShaderProgramFrameProcessor;
    }

    private GlShaderProgramFrameProcessor(ListeningExecutorService listeningExecutorService, GlShaderProgram glShaderProgram, GlObjectsProvider glObjectsProvider) {
        this.glThreadExecutorService = listeningExecutorService;
        this.shaderProgram = glShaderProgram;
        this.glObjectsProvider = glObjectsProvider;
    }

    @Override // androidx.media3.effect.FrameProcessor
    public FrameConsumer<GlTextureFrame> getInput() {
        Preconditions.checkState(!this.isReleased.get());
        return this.inputConsumer;
    }

    @Override // androidx.media3.effect.FrameProcessor
    public ListenableFuture<Void> setOutputAsync(final FrameConsumer<GlTextureFrame> frameConsumer) {
        Preconditions.checkState(!this.isReleased.get());
        return Futures.submit(new Runnable() { // from class: androidx.media3.effect.GlShaderProgramFrameProcessor$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m10406x11d242df(frameConsumer);
            }
        }, this.glThreadExecutorService);
    }

    @Override // androidx.media3.effect.FrameProcessor
    public ListenableFuture<Void> releaseAsync() {
        if (!this.isReleased.compareAndSet(false, true)) {
            return Futures.immediateVoidFuture();
        }
        return this.glThreadExecutorService.submit(new Callable() { // from class: androidx.media3.effect.GlShaderProgramFrameProcessor$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m10405xbe44d842();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$releaseAsync$1$androidx-media3-effect-GlShaderProgramFrameProcessor, reason: not valid java name */
    /* synthetic */ Void m10405xbe44d842() throws Exception {
        releaseInternal();
        return null;
    }

    @Override // androidx.media3.effect.FrameProcessor
    public void setOnErrorCallback(Executor executor, Consumer<VideoFrameProcessingException> consumer) {
        this.onErrorCallbackReference.set(Pair.create(executor, consumer));
    }

    @Override // androidx.media3.effect.FrameProcessor
    public void clearOnErrorCallback() {
        this.onErrorCallbackReference.set(null);
    }

    @Override // androidx.media3.effect.GlShaderProgram.ErrorListener
    public void onError(final VideoFrameProcessingException videoFrameProcessingException) {
        final Pair<Executor, Consumer<VideoFrameProcessingException>> pair = this.onErrorCallbackReference.get();
        if (pair != null) {
            ((Executor) pair.first).execute(new Runnable() { // from class: androidx.media3.effect.GlShaderProgramFrameProcessor$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    ((Consumer) pair.second).accept(videoFrameProcessingException);
                }
            });
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram.InputListener
    public void onReadyToAcceptInputFrame() {
        Preconditions.checkState(this.canAcceptInput.compareAndSet(false, true));
        GlTextureFrame glTextureFrame = this.currentInputFrame;
        if (glTextureFrame != null) {
            glTextureFrame.release(null);
            this.currentInputFrame = null;
        }
        this.inputConsumer.notifyCapacityListener();
    }

    @Override // androidx.media3.effect.GlShaderProgram.OutputListener
    public void onOutputFrameAvailable(GlTextureInfo glTextureInfo, long j) {
        GlTextureFrame glTextureFrame = this.currentProcessedFrame;
        if (glTextureFrame != null) {
            glTextureFrame.release(null);
            this.shaderProgram.releaseOutputFrame(glTextureInfo);
            onError(new VideoFrameProcessingException(new IllegalStateException("currentProcessedFrame is not null when onOutputFrameAvailable at presentationTimeUs: " + j)));
        }
        if (this.currentInputMetadata == null) {
            this.shaderProgram.releaseOutputFrame(glTextureInfo);
            onError(new VideoFrameProcessingException(new IllegalStateException("currentInputMetadata is null when onOutputFrameAvailable at presentationTimeUs: " + j)));
            return;
        }
        ListeningExecutorService listeningExecutorService = this.glThreadExecutorService;
        GlShaderProgram glShaderProgram = this.shaderProgram;
        Objects.requireNonNull(glShaderProgram);
        this.currentProcessedFrame = new GlTextureFrame.Builder(glTextureInfo, listeningExecutorService, new BitmapToGlTextureFrameProcessor$$ExternalSyntheticLambda5(glShaderProgram)).setPresentationTimeUs(j).setFormat(((GlTextureFrame) Preconditions.checkNotNull(this.currentInputFrame)).format).setMetadata((Frame.Metadata) Preconditions.checkNotNull(this.currentInputMetadata)).build();
        maybeForwardProcessedFrame();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setOutputInternal, reason: merged with bridge method [inline-methods] */
    public void m10406x11d242df(FrameConsumer<GlTextureFrame> frameConsumer) {
        FrameConsumer<GlTextureFrame> frameConsumer2 = this.downstreamConsumer;
        if (frameConsumer2 == frameConsumer) {
            return;
        }
        if (frameConsumer2 != null) {
            frameConsumer2.clearOnCapacityAvailableCallback();
        }
        this.downstreamConsumer = frameConsumer;
        if (frameConsumer != null) {
            frameConsumer.setOnCapacityAvailableCallback(this.glThreadExecutorService, new Runnable() { // from class: androidx.media3.effect.GlShaderProgramFrameProcessor$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.maybeForwardProcessedFrame();
                }
            });
        }
    }

    private void releaseInternal() throws VideoFrameProcessingException {
        GlTextureFrame glTextureFrame = this.currentInputFrame;
        if (glTextureFrame != null) {
            glTextureFrame.release(null);
            this.currentInputFrame = null;
        }
        GlTextureFrame glTextureFrame2 = this.currentProcessedFrame;
        if (glTextureFrame2 != null) {
            glTextureFrame2.release(null);
            this.currentProcessedFrame = null;
        }
        this.shaderProgram.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeForwardProcessedFrame() {
        GlTextureFrame glTextureFrame;
        FrameConsumer<GlTextureFrame> frameConsumer;
        if (this.isReleased.get() || (glTextureFrame = this.currentProcessedFrame) == null || (frameConsumer = this.downstreamConsumer) == null || !frameConsumer.queueFrame(glTextureFrame)) {
            return;
        }
        this.currentProcessedFrame = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    class InputConsumer implements FrameConsumer<GlTextureFrame> {
        private final AtomicReference<Pair<Executor, Runnable>> onCapacityAvailableCallbackReference;

        private InputConsumer() {
            this.onCapacityAvailableCallbackReference = new AtomicReference<>(null);
        }

        @Override // androidx.media3.effect.FrameConsumer
        public boolean queueFrame(final GlTextureFrame glTextureFrame) {
            Preconditions.checkState(!GlShaderProgramFrameProcessor.this.isReleased.get());
            if (!GlShaderProgramFrameProcessor.this.canAcceptInput.compareAndSet(true, false)) {
                return false;
            }
            Futures.addCallback(GlShaderProgramFrameProcessor.this.glThreadExecutorService.submit(new Callable() { // from class: androidx.media3.effect.GlShaderProgramFrameProcessor$InputConsumer$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f$0.m10407xa267c978(glTextureFrame);
                }
            }), new FutureCallback<Object>() { // from class: androidx.media3.effect.GlShaderProgramFrameProcessor.InputConsumer.1
                @Override // com.google.common.util.concurrent.FutureCallback
                public void onSuccess(Object obj) {
                }

                @Override // com.google.common.util.concurrent.FutureCallback
                public void onFailure(Throwable th) {
                    GlShaderProgramFrameProcessor.this.onError(new VideoFrameProcessingException(th));
                }
            }, GlShaderProgramFrameProcessor.this.glThreadExecutorService);
            return true;
        }

        /* JADX INFO: renamed from: lambda$queueFrame$0$androidx-media3-effect-GlShaderProgramFrameProcessor$InputConsumer, reason: not valid java name */
        /* synthetic */ Object m10407xa267c978(GlTextureFrame glTextureFrame) throws Exception {
            GlTextureInfo glTextureInfo = glTextureFrame.glTextureInfo;
            GlShaderProgramFrameProcessor.this.currentInputFrame = glTextureFrame;
            GlShaderProgramFrameProcessor.this.currentInputMetadata = glTextureFrame.getMetadata();
            GlShaderProgramFrameProcessor.this.shaderProgram.queueInputFrame(GlShaderProgramFrameProcessor.this.glObjectsProvider, glTextureInfo, glTextureFrame.presentationTimeUs);
            return null;
        }

        @Override // androidx.media3.effect.FrameConsumer
        public void setOnCapacityAvailableCallback(Executor executor, Runnable runnable) {
            if (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.onCapacityAvailableCallbackReference, null, Pair.create(executor, runnable))) {
                throw new IllegalStateException("onCapacityAvailableCallback already set");
            }
        }

        @Override // androidx.media3.effect.FrameConsumer
        public void clearOnCapacityAvailableCallback() {
            this.onCapacityAvailableCallbackReference.set(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void notifyCapacityListener() {
            Pair<Executor, Runnable> pair;
            if (GlShaderProgramFrameProcessor.this.isReleased.get() || (pair = this.onCapacityAvailableCallbackReference.get()) == null) {
                return;
            }
            ((Executor) pair.first).execute((Runnable) pair.second);
        }
    }
}
