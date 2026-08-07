package androidx.media3.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Surface;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DebugViewProvider;
import androidx.media3.common.Effect;
import androidx.media3.common.Format;
import androidx.media3.common.OnInputFrameProcessedListener;
import androidx.media3.common.SurfaceInfo;
import androidx.media3.common.VideoCompositorSettings;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.VideoFrameProcessor;
import androidx.media3.common.VideoGraph;
import androidx.media3.common.util.TimestampIterator;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes8.dex */
public class SingleInputVideoGraph implements VideoGraph {
    private final Context context;
    private final DebugViewProvider debugViewProvider;
    private volatile boolean hasProducedFrameWithTimestampZero;
    private final VideoGraph.Listener listener;
    private final Executor listenerExecutor;
    private final ColorInfo outputColorInfo;
    private SurfaceInfo outputSurfaceInfo;
    private boolean released;
    private final boolean renderFramesAutomatically;
    private VideoFrameProcessor videoFrameProcessor;
    private final VideoFrameProcessor.Factory videoFrameProcessorFactory;
    private ImmutableList<Effect> compositionEffects = ImmutableList.of();
    private int inputIndex = -1;

    @Override // androidx.media3.common.VideoGraph
    public void initialize() {
    }

    public static final class Factory implements VideoGraph.Factory {
        private final VideoFrameProcessor.Factory videoFrameProcessorFactory;

        @Override // androidx.media3.common.VideoGraph.Factory
        public boolean supportsMultipleInputs() {
            return false;
        }

        public Factory() {
            this(new DefaultVideoFrameProcessor.Factory.Builder().build());
        }

        public Factory(VideoFrameProcessor.Factory factory) {
            this.videoFrameProcessorFactory = factory;
        }

        @Override // androidx.media3.common.VideoGraph.Factory
        public SingleInputVideoGraph create(Context context, ColorInfo colorInfo, DebugViewProvider debugViewProvider, VideoGraph.Listener listener, Executor executor, long j, boolean z) {
            return new SingleInputVideoGraph(context, this.videoFrameProcessorFactory, colorInfo, listener, debugViewProvider, executor, z);
        }
    }

    public SingleInputVideoGraph(Context context, VideoFrameProcessor.Factory factory, ColorInfo colorInfo, VideoGraph.Listener listener, DebugViewProvider debugViewProvider, Executor executor, boolean z) {
        this.context = context;
        this.videoFrameProcessorFactory = factory;
        this.outputColorInfo = colorInfo;
        this.listener = listener;
        this.debugViewProvider = debugViewProvider;
        this.listenerExecutor = executor;
        this.renderFramesAutomatically = z;
    }

    @Override // androidx.media3.common.VideoGraph
    public void registerInput(int i) throws VideoFrameProcessingException {
        Preconditions.checkState(this.videoFrameProcessor == null && !this.released);
        Preconditions.checkState(this.inputIndex == -1, "This VideoGraph supports only one input.");
        this.inputIndex = i;
        VideoFrameProcessor videoFrameProcessorCreate = this.videoFrameProcessorFactory.create(this.context, this.debugViewProvider, this.outputColorInfo, this.renderFramesAutomatically, MoreExecutors.directExecutor(), new AnonymousClass1());
        this.videoFrameProcessor = videoFrameProcessorCreate;
        SurfaceInfo surfaceInfo = this.outputSurfaceInfo;
        if (surfaceInfo != null) {
            videoFrameProcessorCreate.setOutputSurfaceInfo(surfaceInfo);
        }
    }

    /* JADX INFO: renamed from: androidx.media3.effect.SingleInputVideoGraph$1, reason: invalid class name */
    class AnonymousClass1 implements VideoFrameProcessor.Listener {
        private long lastProcessedFramePresentationTimeUs;

        AnonymousClass1() {
        }

        /* JADX INFO: renamed from: lambda$onOutputSizeChanged$0$androidx-media3-effect-SingleInputVideoGraph$1, reason: not valid java name */
        /* synthetic */ void m10431xade93702(int i, int i2) {
            SingleInputVideoGraph.this.listener.onOutputSizeChanged(i, i2);
        }

        @Override // androidx.media3.common.VideoFrameProcessor.Listener
        public void onOutputSizeChanged(final int i, final int i2) {
            SingleInputVideoGraph.this.listenerExecutor.execute(new Runnable() { // from class: androidx.media3.effect.SingleInputVideoGraph$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m10431xade93702(i, i2);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onOutputFrameRateChanged$1$androidx-media3-effect-SingleInputVideoGraph$1, reason: not valid java name */
        /* synthetic */ void m10430x6a56d5b3(float f) {
            SingleInputVideoGraph.this.listener.onOutputFrameRateChanged(f);
        }

        @Override // androidx.media3.common.VideoFrameProcessor.Listener
        public void onOutputFrameRateChanged(final float f) {
            SingleInputVideoGraph.this.listenerExecutor.execute(new Runnable() { // from class: androidx.media3.effect.SingleInputVideoGraph$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m10430x6a56d5b3(f);
                }
            });
        }

        @Override // androidx.media3.common.VideoFrameProcessor.Listener
        public void onOutputFrameAvailableForRendering(final long j, final boolean z) {
            if (j == 0) {
                SingleInputVideoGraph.this.hasProducedFrameWithTimestampZero = true;
            }
            this.lastProcessedFramePresentationTimeUs = j;
            SingleInputVideoGraph.this.listenerExecutor.execute(new Runnable() { // from class: androidx.media3.effect.SingleInputVideoGraph$1$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m10429x29302f1a(j, z);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onOutputFrameAvailableForRendering$2$androidx-media3-effect-SingleInputVideoGraph$1, reason: not valid java name */
        /* synthetic */ void m10429x29302f1a(long j, boolean z) {
            SingleInputVideoGraph.this.listener.onOutputFrameAvailableForRendering(j, z);
        }

        /* JADX INFO: renamed from: lambda$onError$3$androidx-media3-effect-SingleInputVideoGraph$1, reason: not valid java name */
        /* synthetic */ void m10428lambda$onError$3$androidxmedia3effectSingleInputVideoGraph$1(VideoFrameProcessingException videoFrameProcessingException) {
            SingleInputVideoGraph.this.listener.onError(videoFrameProcessingException);
        }

        @Override // androidx.media3.common.VideoFrameProcessor.Listener
        public void onError(final VideoFrameProcessingException videoFrameProcessingException) {
            SingleInputVideoGraph.this.listenerExecutor.execute(new Runnable() { // from class: androidx.media3.effect.SingleInputVideoGraph$1$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m10428lambda$onError$3$androidxmedia3effectSingleInputVideoGraph$1(videoFrameProcessingException);
                }
            });
        }

        @Override // androidx.media3.common.VideoFrameProcessor.Listener
        public void onEnded() {
            SingleInputVideoGraph.this.listenerExecutor.execute(new Runnable() { // from class: androidx.media3.effect.SingleInputVideoGraph$1$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m10427lambda$onEnded$4$androidxmedia3effectSingleInputVideoGraph$1();
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onEnded$4$androidx-media3-effect-SingleInputVideoGraph$1, reason: not valid java name */
        /* synthetic */ void m10427lambda$onEnded$4$androidxmedia3effectSingleInputVideoGraph$1() {
            SingleInputVideoGraph.this.listener.onEnded(this.lastProcessedFramePresentationTimeUs);
        }
    }

    @Override // androidx.media3.common.VideoGraph
    public void setOutputSurfaceInfo(SurfaceInfo surfaceInfo) {
        this.outputSurfaceInfo = surfaceInfo;
        VideoFrameProcessor videoFrameProcessor = this.videoFrameProcessor;
        if (videoFrameProcessor != null) {
            videoFrameProcessor.setOutputSurfaceInfo(surfaceInfo);
        }
    }

    @Override // androidx.media3.common.VideoGraph
    public boolean hasProducedFrameWithTimestampZero() {
        return this.hasProducedFrameWithTimestampZero;
    }

    @Override // androidx.media3.common.VideoGraph
    public boolean queueInputBitmap(int i, Bitmap bitmap, TimestampIterator timestampIterator) {
        Preconditions.checkNotNull(this.videoFrameProcessor);
        return this.videoFrameProcessor.queueInputBitmap(bitmap, timestampIterator);
    }

    @Override // androidx.media3.common.VideoGraph
    public boolean queueInputTexture(int i, int i2, long j) {
        Preconditions.checkNotNull(this.videoFrameProcessor);
        return this.videoFrameProcessor.queueInputTexture(i2, j);
    }

    @Override // androidx.media3.common.VideoGraph
    public void setOnInputFrameProcessedListener(int i, OnInputFrameProcessedListener onInputFrameProcessedListener) {
        Preconditions.checkNotNull(this.videoFrameProcessor);
        this.videoFrameProcessor.setOnInputFrameProcessedListener(onInputFrameProcessedListener);
    }

    @Override // androidx.media3.common.VideoGraph
    public void setOnInputSurfaceReadyListener(int i, Runnable runnable) {
        Preconditions.checkNotNull(this.videoFrameProcessor);
        this.videoFrameProcessor.setOnInputSurfaceReadyListener(runnable);
    }

    @Override // androidx.media3.common.VideoGraph
    public Surface getInputSurface(int i) {
        Preconditions.checkNotNull(this.videoFrameProcessor);
        return this.videoFrameProcessor.getInputSurface();
    }

    @Override // androidx.media3.common.VideoGraph
    public void registerInputStream(int i, int i2, Format format, List<Effect> list, long j) {
        Preconditions.checkNotNull(this.videoFrameProcessor);
        this.videoFrameProcessor.registerInputStream(i2, format, new ImmutableList.Builder().addAll((Iterable) list).addAll((Iterable) this.compositionEffects).build(), j);
    }

    @Override // androidx.media3.common.VideoGraph
    public void setCompositionEffects(List<Effect> list) {
        this.compositionEffects = ImmutableList.copyOf((Collection) list);
    }

    @Override // androidx.media3.common.VideoGraph
    public void setCompositorSettings(VideoCompositorSettings videoCompositorSettings) {
        Preconditions.checkArgument(videoCompositorSettings.equals(VideoCompositorSettings.DEFAULT), "SingleInputVideoGraph does not use VideoCompositor, and therefore cannot apply VideoCompositorSettings");
    }

    @Override // androidx.media3.common.VideoGraph
    public boolean registerInputFrame(int i) {
        Preconditions.checkNotNull(this.videoFrameProcessor);
        return this.videoFrameProcessor.registerInputFrame();
    }

    @Override // androidx.media3.common.VideoGraph
    public int getPendingInputFrameCount(int i) {
        Preconditions.checkNotNull(this.videoFrameProcessor);
        return this.videoFrameProcessor.getPendingInputFrameCount();
    }

    @Override // androidx.media3.common.VideoGraph
    public void renderOutputFrame(long j) {
        Preconditions.checkNotNull(this.videoFrameProcessor);
        this.videoFrameProcessor.renderOutputFrame(j);
    }

    @Override // androidx.media3.common.VideoGraph
    public void redraw() {
        ((VideoFrameProcessor) Preconditions.checkNotNull(this.videoFrameProcessor)).redraw();
    }

    @Override // androidx.media3.common.VideoGraph
    public void flush() {
        Preconditions.checkNotNull(this.videoFrameProcessor);
        this.videoFrameProcessor.flush();
    }

    @Override // androidx.media3.common.VideoGraph
    public void signalEndOfInput(int i) {
        Preconditions.checkNotNull(this.videoFrameProcessor);
        this.videoFrameProcessor.signalEndOfInput();
    }

    @Override // androidx.media3.common.VideoGraph
    public void release() {
        if (this.released) {
            return;
        }
        VideoFrameProcessor videoFrameProcessor = this.videoFrameProcessor;
        if (videoFrameProcessor != null) {
            videoFrameProcessor.release();
        }
        this.released = true;
    }
}
