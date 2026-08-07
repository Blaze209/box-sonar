package androidx.media3.effect;

import android.content.Context;
import android.util.Pair;
import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.FrameInfo;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.ConstantRateTimestampIterator;
import androidx.media3.common.util.Consumer;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes8.dex */
final class BitmapToGlTextureFrameProcessor implements FrameProcessor<BitmapFrame, GlTextureFrame>, GlShaderProgram.OutputListener, GlShaderProgram.ErrorListener {
    private FrameConsumer<GlTextureFrame> downstreamConsumer;
    private final ListeningExecutorService glThreadExecutorService;
    private final ColorInfo outputColorInfo;
    private final GlShaderProgram samplingGlShaderProgram;
    private final TextureManager textureManager;
    private final InputConsumer inputConsumer = new InputConsumer();
    private final Queue<GlTextureFrame> processedFrames = new ArrayDeque();
    private final AtomicReference<BitmapFrame> currentInputFrame = new AtomicReference<>();
    private final AtomicReference<Pair<Executor, Consumer<VideoFrameProcessingException>>> onErrorCallback = new AtomicReference<>();
    private final AtomicBoolean isReleased = new AtomicBoolean();

    public static BitmapToGlTextureFrameProcessor create(Context context, ListeningExecutorService listeningExecutorService, GlObjectsProvider glObjectsProvider, ColorInfo colorInfo, ColorInfo colorInfo2, Consumer<VideoFrameProcessingException> consumer) throws VideoFrameProcessingException {
        Objects.requireNonNull(consumer);
        return create(listeningExecutorService, new BitmapTextureManager(glObjectsProvider, new VideoFrameProcessingTaskExecutor(listeningExecutorService, false, new BitmapToGlTextureFrameProcessor$$ExternalSyntheticLambda3(consumer)), false), DefaultShaderProgram.createWithInternalSampler(context, colorInfo, colorInfo2, 0, 2), colorInfo2);
    }

    static BitmapToGlTextureFrameProcessor create(ListeningExecutorService listeningExecutorService, TextureManager textureManager, GlShaderProgram glShaderProgram, ColorInfo colorInfo) {
        BitmapToGlTextureFrameProcessor bitmapToGlTextureFrameProcessor = new BitmapToGlTextureFrameProcessor(listeningExecutorService, textureManager, glShaderProgram, colorInfo);
        textureManager.setSamplingGlShaderProgram(glShaderProgram);
        glShaderProgram.setOutputListener(bitmapToGlTextureFrameProcessor);
        glShaderProgram.setInputListener(textureManager);
        return bitmapToGlTextureFrameProcessor;
    }

    private BitmapToGlTextureFrameProcessor(ListeningExecutorService listeningExecutorService, TextureManager textureManager, GlShaderProgram glShaderProgram, ColorInfo colorInfo) {
        this.glThreadExecutorService = listeningExecutorService;
        this.textureManager = textureManager;
        this.samplingGlShaderProgram = glShaderProgram;
        this.outputColorInfo = colorInfo;
    }

    @Override // androidx.media3.effect.FrameProcessor
    public FrameConsumer<BitmapFrame> getInput() {
        Preconditions.checkState(!this.isReleased.get());
        return this.inputConsumer;
    }

    @Override // androidx.media3.effect.FrameProcessor
    public ListenableFuture<Void> setOutputAsync(final FrameConsumer<GlTextureFrame> frameConsumer) {
        Preconditions.checkState(!this.isReleased.get());
        return Futures.submit(new Runnable() { // from class: androidx.media3.effect.BitmapToGlTextureFrameProcessor$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m10361x5f4294f1(frameConsumer);
            }
        }, this.glThreadExecutorService);
    }

    @Override // androidx.media3.effect.FrameProcessor
    public ListenableFuture<Void> releaseAsync() {
        if (!this.isReleased.compareAndSet(false, true)) {
            return Futures.immediateVoidFuture();
        }
        return this.glThreadExecutorService.submit(new Callable() { // from class: androidx.media3.effect.BitmapToGlTextureFrameProcessor$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m10360xb9655d94();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$releaseAsync$1$androidx-media3-effect-BitmapToGlTextureFrameProcessor, reason: not valid java name */
    /* synthetic */ Void m10360xb9655d94() throws Exception {
        releaseInternal();
        return null;
    }

    @Override // androidx.media3.effect.FrameProcessor
    public void setOnErrorCallback(Executor executor, Consumer<VideoFrameProcessingException> consumer) {
        this.onErrorCallback.set(new Pair<>(executor, consumer));
    }

    @Override // androidx.media3.effect.FrameProcessor
    public void clearOnErrorCallback() {
        this.onErrorCallback.set(null);
    }

    @Override // androidx.media3.effect.GlShaderProgram.OutputListener
    public void onCurrentOutputStreamEnded() {
        BitmapFrame andSet = this.currentInputFrame.getAndSet(null);
        if (andSet != null) {
            andSet.release(null);
        }
        this.inputConsumer.notifyCapacityListener();
    }

    @Override // androidx.media3.effect.GlShaderProgram.OutputListener
    public void onOutputFrameAvailable(GlTextureInfo glTextureInfo, long j) {
        BitmapFrame bitmapFrame = this.currentInputFrame.get();
        Preconditions.checkState(bitmapFrame != null);
        Format formatBuild = bitmapFrame.getMetadata().getFormat().buildUpon().setColorInfo(this.outputColorInfo).build();
        ListeningExecutorService listeningExecutorService = this.glThreadExecutorService;
        GlShaderProgram glShaderProgram = this.samplingGlShaderProgram;
        Objects.requireNonNull(glShaderProgram);
        this.processedFrames.add(new GlTextureFrame.Builder(glTextureInfo, listeningExecutorService, new BitmapToGlTextureFrameProcessor$$ExternalSyntheticLambda5(glShaderProgram)).setPresentationTimeUs(j).setFormat(formatBuild).build());
        maybeDrainProcessedFrames();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setOutputInternal, reason: merged with bridge method [inline-methods] */
    public void m10361x5f4294f1(FrameConsumer<GlTextureFrame> frameConsumer) {
        FrameConsumer<GlTextureFrame> frameConsumer2 = this.downstreamConsumer;
        if (frameConsumer2 == frameConsumer) {
            return;
        }
        if (frameConsumer2 != null) {
            frameConsumer2.clearOnCapacityAvailableCallback();
        }
        this.downstreamConsumer = frameConsumer;
        if (frameConsumer != null) {
            frameConsumer.setOnCapacityAvailableCallback(this.glThreadExecutorService, new Runnable() { // from class: androidx.media3.effect.BitmapToGlTextureFrameProcessor$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.maybeDrainProcessedFrames();
                }
            });
        }
    }

    private void releaseInternal() throws VideoFrameProcessingException {
        BitmapFrame bitmapFrame = this.currentInputFrame.get();
        if (bitmapFrame != null) {
            bitmapFrame.release(null);
        }
        GlTextureFrame glTextureFramePoll = this.processedFrames.poll();
        while (glTextureFramePoll != null) {
            glTextureFramePoll.release(null);
            glTextureFramePoll = this.processedFrames.poll();
        }
        this.textureManager.release();
        this.samplingGlShaderProgram.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeDrainProcessedFrames() {
        if (this.isReleased.get()) {
            return;
        }
        GlTextureFrame glTextureFramePeek = this.processedFrames.peek();
        while (glTextureFramePeek != null) {
            FrameConsumer<GlTextureFrame> frameConsumer = this.downstreamConsumer;
            if (frameConsumer == null || !frameConsumer.queueFrame(glTextureFramePeek)) {
                return;
            }
            this.processedFrames.poll();
            glTextureFramePeek = this.processedFrames.peek();
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram.ErrorListener
    public void onError(final VideoFrameProcessingException videoFrameProcessingException) {
        final Pair<Executor, Consumer<VideoFrameProcessingException>> pair = this.onErrorCallback.get();
        if (pair != null) {
            ((Executor) pair.first).execute(new Runnable() { // from class: androidx.media3.effect.BitmapToGlTextureFrameProcessor$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    ((Consumer) pair.second).accept(videoFrameProcessingException);
                }
            });
        }
    }

    private class InputConsumer implements FrameConsumer<BitmapFrame> {
        private final AtomicReference<Pair<Executor, Runnable>> onCapacityAvailableCallbackReference = new AtomicReference<>(null);

        public InputConsumer() {
        }

        @Override // androidx.media3.effect.FrameConsumer
        public boolean queueFrame(BitmapFrame bitmapFrame) {
            Preconditions.checkState(!BitmapToGlTextureFrameProcessor.this.isReleased.get());
            if (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(BitmapToGlTextureFrameProcessor.this.currentInputFrame, null, bitmapFrame)) {
                return false;
            }
            BitmapToGlTextureFrameProcessor.this.textureManager.queueInputBitmap(bitmapFrame.getBitmap(), new FrameInfo(bitmapFrame.getMetadata().getFormat(), 0L), new ConstantRateTimestampIterator(bitmapFrame.getMetadata().getPresentationTimeUs(), 1 + bitmapFrame.getMetadata().getPresentationTimeUs(), 1.0f));
            BitmapToGlTextureFrameProcessor.this.textureManager.signalEndOfCurrentInputStream();
            return true;
        }

        @Override // androidx.media3.effect.FrameConsumer
        public void setOnCapacityAvailableCallback(Executor executor, Runnable runnable) {
            if (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.onCapacityAvailableCallbackReference, null, new Pair(executor, runnable))) {
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
            if (BitmapToGlTextureFrameProcessor.this.isReleased.get() || (pair = this.onCapacityAvailableCallbackReference.get()) == null) {
                return;
            }
            ((Executor) pair.first).execute((Runnable) pair.second);
        }
    }
}
